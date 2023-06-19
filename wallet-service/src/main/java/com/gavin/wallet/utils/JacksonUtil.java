package com.turing.wallet.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JacksonUtil {

    public static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER = createObjectMapperUsingLowerCamelCase();

    public static final com.fasterxml.jackson.databind.ObjectMapper OBJECT_MAPPER_WITH_FAIL = createObjectMapperUsingLowerCamelCaseWithFail();

    public static com.fasterxml.jackson.databind.ObjectMapper createObjectMapper() {
        return createObjectMapper(PropertyNamingStrategy.KEBAB_CASE);
    }

    public static com.fasterxml.jackson.databind.ObjectMapper createObjectMapperUsingLowerCamelCase() {
        return createObjectMapper(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    }

    public static com.fasterxml.jackson.databind.ObjectMapper createObjectMapperUsingLowerCamelCaseWithFail() {
        return createObjectMapperWithFail(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    }

    public static com.fasterxml.jackson.databind.ObjectMapper createObjectMapperUsingLowerCamelCaseWithoutNull() {
        return createObjectMapperWithoutNull(PropertyNamingStrategy.LOWER_CAMEL_CASE);
    }

    static com.fasterxml.jackson.databind.ObjectMapper createObjectMapper(PropertyNamingStrategy strategy) {
        final com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        mapper.setPropertyNamingStrategy(strategy);
        mapper.setSerializationInclusion(Include.ALWAYS);
        // disabled features:
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        return mapper;
    }

    static com.fasterxml.jackson.databind.ObjectMapper createObjectMapperWithFail(PropertyNamingStrategy strategy) {
        final com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        mapper.setPropertyNamingStrategy(strategy);
        mapper.setSerializationInclusion(Include.ALWAYS);
        // disabled features:
        mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    static com.fasterxml.jackson.databind.ObjectMapper createObjectMapperWithoutNull(PropertyNamingStrategy strategy) {
        final com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        mapper.setPropertyNamingStrategy(strategy);
        mapper.setSerializationInclusion(Include.NON_NULL);
        // disabled features:
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    public static String writeValue(com.fasterxml.jackson.databind.ObjectMapper mapper, Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(ObjectMapper mapper, String str, Class<T> clazz) {
        try {
            return mapper.readValue(str, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeValue(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readValue(String str, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(str, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static <T> T readValue(String str, TypeReference<T> typeReference) {
        try {
            return OBJECT_MAPPER.readValue(str, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> toMap(Object object) {
        return OBJECT_MAPPER.convertValue(object, Map.class);
    }

    public static <T> List<T> readValueList(String str, Class<T> lass) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory()
                .constructParametricType(ArrayList.class, lass);
        try {
            return OBJECT_MAPPER.readValue(str, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertValue(Object fromValue, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(fromValue, clazz);
    }

    public static <T> List<T> convertValueList(Object fromValue, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(fromValue, new TypeReference<List<T>>() {
            @Override
            public Type getType() {
                TypeToken<?> typeToken = TypeToken.of(super.getType());
                return typeToken.where(new TypeParameter<T>() {
                }, clazz).getType();
            }
        });
    }


    public static <T> List<T> readValueListWithFail(String str, Class<T> lass) {
        JavaType javaType = OBJECT_MAPPER_WITH_FAIL.getTypeFactory()
                .constructParametricType(ArrayList.class, lass);
        try {
            return OBJECT_MAPPER_WITH_FAIL.readValue(str, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, List<Integer>> toMapList(String object) {
        try {
            return OBJECT_MAPPER.readValue(object, new TypeReference<HashMap<String, List<Integer>>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Map<String, String>> toListMap(String object) {
        try {
            return OBJECT_MAPPER.readValue(object, new TypeReference<List<Map<String, String>>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
