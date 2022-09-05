package arvik.springmicroserv.model;

import arvik.springmicroserv.domain.Beer;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
    BeerDto getDTO() {
        return BeerDto.builder()
                .beerName("Name")
                .beerStyle("Ale")
                .id(UUID.randomUUID())
                .createDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(BigDecimal.valueOf(100L))
                .upc(12121L)
                .build();
    }
}
