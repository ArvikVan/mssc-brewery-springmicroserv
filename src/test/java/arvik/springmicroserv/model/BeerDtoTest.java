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
        String json = "{\"id\":\"59a24f0c-3bef-4d89-b3bb-1f0a28627936\",\"version\":null,\"createDate\":\"2022-09-05T17:14:02.851750424+03:00\",\"lastModifiedDate\":\"2022-09-05T17:14:02.851787905+03:00\",\"beerName\":\"Name\",\"beerStyle\":\"Ale\",\"upc\":12121,\"price\":100,\"quantityOnHand\":null}";
        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);
        System.out.println(beerDto);
    }
}