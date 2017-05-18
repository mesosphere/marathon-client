package mesosphere.dcos.client.model;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Objects;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import mesosphere.client.common.ModelUtils;
import net.oauth.signature.pem.PEMReader;

public class DCOSAuthCredentials {

    // Note that these member variables need to remain named this way, as they are serialized with these names in the
    // DCOSClient#authenticate(...) call.
    private final String uid;
    private final String password;
    private final String token;

    private DCOSAuthCredentials(final String uid, final String password, final String servicePrivateKey) {
        this.uid = uid;
        this.password = password;
        this.token = servicePrivateKey;
    }

    /**
     * @param serviceId service account id
     * @param servicePrivateKey contents of the private key (pem) file for the service account
     * @return auth credentials for DC/OS
     */
    public static DCOSAuthCredentials forServiceAccount(final String serviceId, final String servicePrivateKey) {
        try {
            final String serviceLoginToken = signJWT(serviceId, parsePrivateKey(servicePrivateKey));
            return new DCOSAuthCredentials(serviceId, null, serviceLoginToken);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public static DCOSAuthCredentials forUserAccount(final String userId, final String password) {
        return new DCOSAuthCredentials(userId, password, null);
    }

    public String getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public String getServiceLoginToken() {
        return token;
    }

    private static PrivateKey parsePrivateKey(final String key)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        final PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(new PEMReader(key.getBytes()).getDerBytes());
        // I assume RSA is always what DC/OS uses since examples in their doc don't show other algorithms
        // and so this is not configurable
        final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    private static String signJWT(String uid, PrivateKey privateKey) {
        final JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256).type(JOSEObjectType.JWT).build();
        final JWTClaimsSet payload = new JWTClaimsSet.Builder().claim("uid", uid).build();
        final SignedJWT signedJWT = new SignedJWT(header, payload);

        try {
            signedJWT.sign(new RSASSASigner(privateKey));
            return signedJWT.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DCOSAuthCredentials that = (DCOSAuthCredentials) o;
        return Objects.equals(uid, that.uid) && Objects.equals(password, that.password)
                && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, password, token);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
