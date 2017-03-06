package mesosphere.dcos.client;

import feign.Feign;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import mesosphere.client.common.ModelUtils;
import mesosphere.dcos.client.model.DCOSAuthCredentials;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.function.Consumer;

public class DCOSClient {
    public static DCOS getInstance(String endpoint) {
        return buildInstance(endpoint, b -> {});
    }

    public static DCOS getInstance(String endpoint, final DCOSAuthCredentials authCredentials) {
        // Need to use a non-authenticated DCOSClient instance to perform the authorization and token refresh to avoid
        // the complexity of synchronizing around checking whether a token needs to be refreshed.
        return buildInstance(endpoint, b ->
                b.requestInterceptor(new DCOSAuthTokenHeaderInterceptor(authCredentials, getInstance(endpoint))));
    }

    private static DCOS buildInstance(String endpoint, Consumer<Feign.Builder> customize) {
        GsonDecoder decoder = new GsonDecoder(ModelUtils.GSON);
        GsonEncoder encoder = new GsonEncoder(ModelUtils.GSON);

        Feign.Builder builder = Feign.builder()
                                     .encoder(encoder)
                                     .decoder(decoder)
                                     .errorDecoder(new DCOSErrorDecoder());
        customize.accept(builder);
        builder.requestInterceptor(new DCOSAPIInterceptor());

        return builder.target(DCOS.class, endpoint);
    }

    private static class DCOSErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {

            String details;
            try {
                details = IOUtils.toString(response.body().asInputStream(), "UTF-8");
            } catch (NullPointerException | IOException e) {
                details = "Unable to read response body";
            }
            return new DCOSException(response.status(), response.reason(), methodKey, details);
        }
    }
}
