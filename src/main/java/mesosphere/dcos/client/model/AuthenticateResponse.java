package mesosphere.dcos.client.model;

import mesosphere.client.common.ModelUtils;

public class AuthenticateResponse {
    private String token;

    public String getToken() { return token; }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return The auth token returned as a {@link DCOSAuthToken}, which allows checking if the token is expired.
     */
    public DCOSAuthToken toDCOSAuthToken() {
        try {
            return new DCOSAuthToken(token);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
