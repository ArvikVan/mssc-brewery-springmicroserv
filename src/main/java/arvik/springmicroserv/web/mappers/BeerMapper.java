package arvik.springmicroserv.web.mappers;

import arvik.springmicroserv.domain.Beer;
import arvik.springmicroserv.model.BeerDto;

public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
