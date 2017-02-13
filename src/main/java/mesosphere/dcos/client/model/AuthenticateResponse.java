package mesosphere.dcos.client.model;

import mesosphere.client.common.ModelUtils;

public class AuthenticateResponse {
    private String token;

    public String getRawToken() {
        return token;
    }

    /**
     * @return The auth token returned as a {@link DCOSAuthToken}, which allows checking if the token is expired.
     */
    public DCOSAuthToken toDCOSAuthToken() {
        return new DCOSAuthToken(token);
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
