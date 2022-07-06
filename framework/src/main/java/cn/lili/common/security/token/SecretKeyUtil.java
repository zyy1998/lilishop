package cn.lili.common.security.token;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;

/**
 * SignWithUtil
 *
 * @author Chopper
 * @version v1.0
 * 2020-11-18 17:30
 */
public class SecretKeyUtil {
    public static SecretKey generalKey() {
        //这里的base64解码出来不是个可读的字符串
        byte[] encodedKey = Base64.decodeBase64("cuAihCz53DZRjZwbsGcZJ2Ai6At+T142uphtJMsk7iQ=");
        javax.crypto.SecretKey key = Keys.hmacShaKeyFor(encodedKey);
        return key;
    }

    public static SecretKey generalKeyByDecoders() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("cuAihCz53DZRjZwbsGcZJ2Ai6At+T142uphtJMsk7iQ="));

    }
}
