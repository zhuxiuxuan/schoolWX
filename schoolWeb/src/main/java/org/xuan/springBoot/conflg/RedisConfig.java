package org.xuan.springBoot.conflg;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
/**
 * @ClassName: RedisConfig
 * @Description: TODO功能描述:(redis 配置类)
 * @author 朱修轩
 * @date 2018年12月29日 上午11:55:07
 * @remark 备注:(这里是添加备注的信息...)
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport{
	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
			}
		};
	}
	/**
	 * @Title: CacheManagercacheManager
	 * @Description: TODO方法描述:(配置CacheManager，通过配置Spring的CacheManager为redis，即可指定使用redis做缓存)
	 * @param @param factory
	 * @param @return    设定文件
	 * @return CacheManager    返回类型
	 * @throws
	 */
	@Bean
    public CacheManager  CacheManagercacheManager(RedisConnectionFactory factory) {
		RedisCacheManager cacheManager = RedisCacheManager.create(factory);
    return cacheManager;
    }

	
   @Bean
   public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
       RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
       redisTemplate.setConnectionFactory(factory);
       // 修改rdis默认序列化方式为StringRedisSerializer
       StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
       redisTemplate.setKeySerializer(stringRedisSerializer);
       redisTemplate.setHashKeySerializer(stringRedisSerializer);
       redisTemplate.setHashValueSerializer(stringRedisSerializer);
       redisTemplate.setValueSerializer(stringRedisSerializer);

       return redisTemplate;
   }
	

}
