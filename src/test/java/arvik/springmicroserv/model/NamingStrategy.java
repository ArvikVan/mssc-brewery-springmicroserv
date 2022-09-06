package arvik.springmicroserv.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("kebab")
@JsonTest
public class NamingStrategy extends BaseTest {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void nameKebab() throws JsonProcessingException {
        BeerDto beerDto = getDTO();
        String json = objectMapper.writeValueAsString(beerDto);
        System.out.println(json);
    }
}
