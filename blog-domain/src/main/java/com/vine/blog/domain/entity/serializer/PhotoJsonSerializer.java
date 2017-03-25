package com.vine.blog.domain.entity.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PhotoJsonSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String path, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        if (path == null || path.isEmpty()) {
            jsonGenerator.writeNull();
        } else if (path.startsWith("http://")) {
            // @FIXME: remove this result after redesigned account system
            jsonGenerator.writeString(path);
        } else {
            jsonGenerator.writeString("http://assets.helpdesk.youzan.com" + path + "!optimized");
        }
    }
}
