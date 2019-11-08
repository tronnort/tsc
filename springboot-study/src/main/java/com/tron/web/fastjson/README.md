序列化：

String jsonString = JSON.toJSONString(obj);

反序列化：

VO vo = JSON.parseObject("...", VO.class);


泛型反序列化：

import com.alibaba.fastjson.TypeReference;
List<VO> list = JSON.parseObject("...", new TypeReference<List<VO>>() {});

将JSON字符串反序列为JSONObject
public static JSONObject parseObject(String text);

如果你需要输出空值，需要使用 SerializerFeature.WriteMapNullValue


Model obj = ...;
JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);


Fastjson 处理日期的API很简单，例如：

JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS")



JSONField 注解介绍
package com.alibaba.fastjson.annotation;

public @interface JSONField {
    // 配置序列化和反序列化的顺序，1.1.42版本之后才支持
    int ordinal() default 0;

     // 指定字段的名称
    String name() default "";

    // 指定字段的格式，对日期格式有用
    String format() default "";

    // 是否序列化
    boolean serialize() default true;

    // 是否反序列化
    boolean deserialize() default true;
}



配置 RedisTemplate 的话只需在你的配置类(被@Configuration注解修饰的类)中显式创建 RedisTemplate Bean，设置 Serializer 即可。

@Bean
public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate redisTemplate = new RedisTemplate();
    redisTemplate.setConnectionFactory(redisConnectionFactory);

    GenericFastJsonRedisSerializer fastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
    redisTemplate.setDefaultSerializer(fastJsonRedisSerializer);//设置默认的Serialize，包含 keySerializer & valueSerializer

    //redisTemplate.setKeySerializer(fastJsonRedisSerializer);//单独设置keySerializer
    //redisTemplate.setValueSerializer(fastJsonRedisSerializer);//单独设置valueSerializer
    return redisTemplate;
}


