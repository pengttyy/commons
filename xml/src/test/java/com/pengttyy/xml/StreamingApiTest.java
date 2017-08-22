package com.pengttyy.xml;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.io.StringWriter;

import static com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void xmlStreamGenerator() throws Exception {
        XmlFactory f = new XmlFactory();
        StringWriter out = new StringWriter();
        ToXmlGenerator gen = f.createGenerator(out);
        // root name is special, need to be fed first:
        gen.setNextName(new QName("root"));
        gen.writeStartObject();
        gen.writeFieldName("elem");
        gen.writeString("value");
        gen.writeEndObject();
        gen.close();
        String xml = out.toString();
        assertEquals("<root><elem>value</elem></root>", xml);
    }
}
