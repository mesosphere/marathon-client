package mesosphere.dcos.client.model;

import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.Instant;
import java.util.Base64;

import com.google.gson.JsonParser;

import mesosphere.client.common.ModelUtils;

public class DCOSAuthToken {

    private final String token;
    private final Instant expiry;
    private final transient Clock clock;

    /**
     * Package-private visibility for testing.
     * @param token
     * @param clock
     */
    DCOSAuthToken(final String token, final Clock clock) {
        this.clock = clock;
        this.token = token;
        expiry = extractExpiry(token);
    }

    public DCOSAuthToken(final String token) {
        this(token, Clock.systemUTC());
    }

    public String getToken() {
        return token;
    }

    public boolean requiresRefresh() {
        // Uh, just do it a day ahead, why not?
        return Instant.now(clock)
                      .plusSeconds(86400)
                      .isAfter(expiry);
    }

    public Instant getExpiry() {
        return expiry;
    }

    private static Instant extractExpiry(final String token) {
        // TODO no real error handling here.
        String[] parts = token.split("\\.");
        String epochTime = new JsonParser().parse(new String(Base64.getDecoder()
                                                                   .decode(parts[1]),
                StandardCharsets.ISO_8859_1))
                                           .getAsJsonObject()
                                           .getAsJsonPrimitive("exp")
                                           .getAsString();

        return Instant.ofEpochSecond(Long.parseLong(epochTime));
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}