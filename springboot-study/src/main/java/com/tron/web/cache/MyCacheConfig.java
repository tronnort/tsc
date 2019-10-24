package com.tron.web.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class MyCacheConfig{

//    @Primary //若配置多个缓存管理器需要有一个默认的缓存管理器
//    @Bean
//    public RedisCacheManager personCacheManager(RedisConnectionFactory redisConnectionFactory) {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//            //.entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
//                .disableCachingNullValues();
//        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(config)
//                .build();
//        return cacheManager;
//    }
//
//    @Bean
//    public RedisCacheManager tronCacheManager(RedisConnectionFactory redisConnectionFactory) {
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Person.class);
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        //.entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
//                .disableCachingNullValues();
//        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(config)
//                .build();
//        return cacheManager;
//    }
}
