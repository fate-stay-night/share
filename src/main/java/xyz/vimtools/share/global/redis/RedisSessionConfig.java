package xyz.vimtools.share.global.redis;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 配置session存入redis中
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-4
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600, redisNamespace = "share")
public class RedisSessionConfig {


}
