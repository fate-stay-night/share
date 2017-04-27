package xyz.vimtools.share.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * json工具类
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-27
 */
public class JsonUtils {

    public JsonUtils() {
    }

    /**
     * 对象转json
     *
     * @param object 要转的对象
     * @return String
     */
    public static String objectToJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(object);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    /**
     * json转对象
     * @param json json字符串
     * @param valueType 对象类
     * @return 对象
     */
    public static <T> T jsonToObject(String json, Class<T> valueType) {
        return jsonToObject(json, valueType, false);
    }

    public static <T> T jsonToObject(String json, Class<T> valueType, boolean uppercase) {
        ObjectMapper mapper = new ObjectMapper();
        if(uppercase) {
            mapper.setPropertyNamingStrategy(new PropertyNamingStrategy() {
                private static final long serialVersionUID = 1L;

                public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
                    return method.getName().substring(3);
                }

                public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
                    return method.getName().substring(3);
                }
            });
        }

        try {
            return mapper.readValue(json, valueType);
        } catch (Exception var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static <T> T[] jsonToArray(String json, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        ArrayType arrayType = typeFactory.constructArrayType(valueType);

        try {
            return mapper.readValue(json, arrayType);
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> jsonToList(String json, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        CollectionType collectionType = typeFactory.constructCollectionType(List.class, valueType);

        try {
            return (List)mapper.readValue(json, collectionType);
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static <T> Set<T> jsonToSet(String json, Class<T> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        CollectionType collectionType = typeFactory.constructCollectionType(Set.class, valueType);

        try {
            return (Set)mapper.readValue(json, collectionType);
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static <K, V> Map<K, V> jsonToMap(String json, Class<K> keyType, Class<V> valueType) {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = TypeFactory.defaultInstance();
        MapType mapType = typeFactory.constructMapType(Map.class, keyType, valueType);

        try {
            return (Map)mapper.readValue(json, mapType);
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }
}
