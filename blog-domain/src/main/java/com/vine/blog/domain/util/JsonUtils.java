package com.vine.blog.domain.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtils {

    public static String toString(Object object) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(object);
    }

    public static <T> String toString(List<T> list) throws JsonProcessingException {
        return  new ObjectMapper().writeValueAsString(list);
    }

}
