package arvik.springmicroserv.model;

import arvik.springmicroserv.domain.Beer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;
@JsonTest
class BeerDtoTest extends BaseTest {
    @Autowired
    ObjectMapper objectMapper;
    @Test
    void serialize() throws JsonProcessingException {
        BeerDto beerDto = getDTO();
        String json = objectMapper.writeValueAsString(beerDto);
        System.out.println(json);
    }

    @Test
    void deserilize() throws JsonProcessingException {
        String json = "{\"id\":\"a5564015-5116-4621-9cff-effaf98d8c1b\",\"version\":null,\"createDate\":\"2022-09-26T19:04:07+0300\",\"lastModifiedDate\":\"2022-09-26T19:04:07.310855947+03:00\",\"beerName\":\"Name\",\"beerStyle\":\"Ale\",\"upc\":12121,\"price\":\"100\",\"quantityOnHand\":null,\"myLocalDateTime\":\"2022-09-26T19:04:07.31087658\"}";
        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(beerDto);
    }
}