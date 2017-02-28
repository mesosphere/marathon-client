package mesosphere.dcos.client.model;

import java.time.Clock;
import java.time.Instant;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import mesosphere.client.common.ModelUtils;

public class DCOSAuthToken {

    private final String token;
    private final JWTClaimsSet jWTClaimsSet;
    private final transient Clock clock;

    /**
     * Package-private visibility for testing.
     * @param token
     */
    public DCOSAuthToken(final String token) throws java.text.ParseException {
        this.clock = Clock.systemUTC();
        this.token = token;
        jWTClaimsSet = SignedJWT.parse(token).getJWTClaimsSet();
    }

    public String getToken() {
        return token;
    }

    public boolean requiresRefresh() {
        // Uh, just do it a day ahead, why not?
        return jWTClaimsSet.getExpirationTime().toInstant().isBefore(Instant.now(clock).plusSeconds(86400L));
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}