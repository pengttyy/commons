package com.pengttyy.xml;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS;

public class StreamingApiTest {

    @Test
    public void streamGenerator() throws Exception {
        JsonFactory factory = new JsonFactory();
        factory.configure(ALLOW_COMMENTS, true);
        JsonGenerator generator = factory.createGenerator(System.out);
        generator.writeStartObject();
        generator.writeFieldName("country_id");
        generator.writeString("china");
        generator.writeFieldName("provinces");
        generator.writeStartArray();
        generator.writeStartObject();
        generator.writeStringField("name", "Shanxi");
        generator.writeNumberField("population", 33750000);
        generator.writeEndObject();
        generator.writeEndArray();
        generator.writeEndObject();
        generator.close();
    }
}
