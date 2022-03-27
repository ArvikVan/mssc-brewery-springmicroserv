package arvik.springmicroserv.services.v2;

import arvik.springmicroserv.model.BeerDto;
import arvik.springmicroserv.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 27.03.2022
 */
public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
