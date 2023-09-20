package com.qin_kai.netty.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * 基于jackson的序列化反序列化工具
 * <p>
 * 序列化和反序列和反序列化出错时，包装为RuntimeException，
 * 工具类的调用方不需要进行强制的try catch
 *
 * @author qinkai
 * @date 2020/11/24
 */
public class JsonUtil {

    /**
     * ObjectMapper 线程安全
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        // 当json字符串中存在实体对应的未知属性时忽略
        MAPPER.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 空实体序列化不失败
        MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 设置时区为中国对应的时区
        MAPPER.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        // 设置时间格式化
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 序列化对象为json字符串
     *
     * @param object 待序列化对象
     * @param <T>    对象类型
     * @return String 序列化后的字符串
     */
    public static <T> String toJsonStr(T object) {
        // 如果对象为String类型调用序列化会出现重复的引号
        // 这里判断是String就直接返回toString方法的值
        if (object instanceof String) {
            return object.toString();
        }
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化json字符串为对象
     *
     * @param jsonStr json字符串
     * @return Object 反序列后的对象
     */
    public static Object parse(String jsonStr) {
        try {
            return MAPPER.readValue(jsonStr, Object.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化json字符串为指定类型对象
     *
     * @param jsonStr json字符串
     * @param clazz   反序列化类型Class
     * @param <T>     反序列化对象类型
     */
    public static <T> T parse(String jsonStr, Class<T> clazz) {
        try {
            return MAPPER.readValue(jsonStr, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 指定TypeReference表示反序列化的类型来反序列化json字符串
     * TypeReference可以用来反序列化泛型类
     *
     * @param json          json字符串
     * @param typeReference TypeReference
     * @return 反序列化结果对象
     */
    public static <T> T parse(String json, TypeReference<T> typeReference) {
        try {
            return MAPPER.readValue(json, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化json字符串为指定类型对象，用于通过Class对象序列化泛型类
     * <pre>
     * &lt;T&gt; List&lt;T&gt; fun(String jsonString, Class&lt;T&gt; clazz){
     *      JavaType javaType = JsonUtil.objectMapper().getTypeFactory().constructParametricType(List.class, clazz);
     *      return JsonUtil.parse(jsonString, javaType);
     * }
     * </pre>
     *
     * @param jsonStr json字符串
     * @param type    反序列化类型
     * @param <T>     反序列化对象类型
     */
    public static <T> T parse(String jsonStr, JavaType type) {
        try {
            return MAPPER.readValue(jsonStr, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 反序列化json字符串为指定类型对象，用于通过Class对象序列化泛型类
     *
     * @param jsonStr          json字符串
     * @param parametrized     泛型擦除后的类，Map<Integer, String> -> Map.class
     * @param parameterClasses 泛型参数列表，Map<Integer, String> -> Integer.class, String.class
     * @param <T>              反序列化对象类型
     */
    public static <T> T parse(String jsonStr, Class<?> parametrized, Class<?>... parameterClasses) {
        try {
            return MAPPER.readValue(jsonStr, getJavaType(parametrized, parameterClasses));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解析指定路径json字符串
     * 例如：
     * jsonStr={"test":{"test":"test"}}
     * traces=test.test
     * clazz=String.class
     * 结果为：test
     *
     * @param jsonStr 字符串
     * @param traces  路径，用.分割
     * @param clazz   类型
     * @param <T>     反序列化类型
     * @return 解析后的对象
     */
    public static <T> T parseTreeValue(String jsonStr, String traces, Class<T> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonStr);
            String[] traceList = traces.split("\\.");
            for (String trace : traceList) {
                jsonNode = jsonNode.get(trace);
                if (jsonNode == null) {
                    return null;
                }
            }
            return MAPPER.treeToValue(jsonNode, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseTreeValue(String jsonStr, String traces, Class<?> parametrized, Class<?>... parameterClasses) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonStr);
            String[] traceList = traces.split("\\.");
            for (String trace : traceList) {
                jsonNode = jsonNode.get(trace);
                if (jsonNode == null) {
                    return null;
                }
            }
            return MAPPER.treeToValue(jsonNode, getJavaType(parametrized, parameterClasses));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 转换对象，将一个对象转换为另一个类型的对象
     *
     * @param fromValue   带转换对象
     * @param toValueType 转换后的对象类型
     * @param <T>         转换后的对象类型
     * @return T
     */
    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return MAPPER.convertValue(fromValue, toValueType);
    }

    public static <T> T convertValue(Object fromValue, TypeReference<T> typeReference) {
        return MAPPER.convertValue(fromValue, typeReference);
    }

    public static <T> T convertValue(Object fromValue, Class<?> parametrized, Class<?>... parameterClasses) {
        return MAPPER.convertValue(fromValue, getJavaType(parametrized, parameterClasses));
    }

    /**
     * 获取ObjectMapper实例，方便满足定制化的序列化需求
     * 避免外部修改ObjectMapper配置，拷贝后返回
     *
     * @return ObjectMapper
     */
    public static ObjectMapper objectMapper() {
        return MAPPER.copy();
    }

    private static JavaType getJavaType(Class<?> parametrized, Class<?>... parameterClasses) {
        return MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
    }

}
