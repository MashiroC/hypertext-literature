package org.gameboyz.hypertext.literature.been.jwt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author shiina18
 * @description
 * @date 2018/10/10
 **/
public final class SecretUtil {

    public static byte[] encode(String macInstanceName, String secret, String message) {
        Mac mac = null;
        try {
            mac = Mac.getInstance(macInstanceName);
            SecretKeySpec key = new SecretKeySpec(secret.getBytes(), macInstanceName);
            mac.init(key);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        if (mac != null) {
            byte[] buff = mac.doFinal(message.getBytes());
            return buff;
        }
        return null;
    }

    public static String encodeBase64(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String decodeBase64(String text) {
        return new String(Base64.getDecoder().decode(text.getBytes()));
    }

    public static byte[] decodeBase64ToBtye(String text) {
        return Base64.getDecoder().decode(text.getBytes());
    }

    public static String encodeBase64(byte[] encode) {
        return Base64.getEncoder().encodeToString(encode);
    }
}