package arvik.springmicroserv.services;

import arvik.springmicroserv.model.BeerDto;

import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 25.03.2022
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
