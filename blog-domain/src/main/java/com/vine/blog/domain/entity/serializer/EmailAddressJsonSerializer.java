package com.vine.blog.domain.entity.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.vine.blog.domain.entity.account.EmailAddress;

import java.io.IOException;

public class EmailAddressJsonSerializer extends JsonSerializer<EmailAddress> {
    @Override
    public void serialize(EmailAddress emailAddress, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeString(emailAddress.toString());
    }
}
