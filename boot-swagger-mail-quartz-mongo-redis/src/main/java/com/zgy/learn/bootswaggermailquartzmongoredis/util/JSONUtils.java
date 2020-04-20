package com.zgy.learn.bootswaggermailquartzmongoredis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JSONUtils {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String getJsonFromObject(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }
}
