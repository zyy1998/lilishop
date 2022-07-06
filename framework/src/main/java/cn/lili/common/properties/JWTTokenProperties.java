package cn.lili.common.properties;

import cn.lili.common.security.enums.UserEnums;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * token过期配置
 *
 * @author Chopper
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "lili.jwt-setting")
public class JWTTokenProperties {


    /**
     * token默认过期时间，单位分钟
     * @see cn.lili.common.security.token.TokenUtil#createToken(String, Object, boolean, UserEnums)
     * @see cn.lili.common.security.token.TokenUtil#createToken(String, Object, Long)
     */
    private long tokenExpireTime = 60;
}
