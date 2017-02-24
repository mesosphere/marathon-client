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

public class DCOSClient {
    public static final String DCOS_CLIENT_USER_AGENT = "dcos/client";

    public static DCOS getInstance(String endpoint) {
        return getInstance(endpoint, null);
    }

    public static DCOS getInstance(String endpoint, final DCOSAuthCredentials authCredentials) {

        GsonDecoder decoder = new GsonDecoder(ModelUtils.GSON);
        GsonEncoder encoder = new GsonEncoder(ModelUtils.GSON);

        Feign.Builder builder = Feign.builder()
                .encoder(encoder)
                .decoder(decoder)
                .errorDecoder(new DCOSErrorDecoder());

        if (authCredentials != null) {
            // Need to use a non-authenticated DCOSClient instance to perform the authorization and token refresh,
            // unfortunately.
            builder.requestInterceptor(new DCOSAPIInterceptor()).requestInterceptor(
                    new DCOSAuthTokenHeaderInterceptor(authCredentials, getInstance(endpoint)));
        }

        return builder.target(DCOS.class, endpoint);
    }

    private static class DCOSErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {

            String details;
            try {
                details = IOUtils.toString(response.body().asInputStream(), "UTF-8");
            } catch (IOException e) {
                details = "Unable to read response body";
            }
            return new DCOSException(response.status(), response.reason(), methodKey, details);
        }
    }
}
