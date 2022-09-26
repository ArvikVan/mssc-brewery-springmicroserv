package arvik.springmicroserv.model;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoclaDateDeserialize extends StdScalarDeserializer<LocalDateTime> {
    public LoclaDateDeserialize() {
        super(LocalDate.class);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return LocalDateTime.parse(p.readValueAs(String.class), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
