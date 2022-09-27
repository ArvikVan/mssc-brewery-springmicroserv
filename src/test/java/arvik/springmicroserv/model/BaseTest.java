package arvik.springmicroserv.model;

import arvik.springmicroserv.bootstrap.BeerLoader;
import arvik.springmicroserv.domain.Beer;
import arvik.springmicroserv.model.v2.BeerStyleEnum;
import arvik.springmicroserv.web.mappers.BeerMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
    BeerDto getDTO() {
        return BeerDto.builder()
                .beerName("Name")
                .beerStyle(BeerStyleEnum.valueOf("ALE"))
                .id(UUID.randomUUID())
                .createDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .price(BigDecimal.valueOf(100L))
                .upc(BeerLoader.BEER_1_UPC)
                .myLocalDateTime(LocalDateTime.now())
                .build();
    }
}
