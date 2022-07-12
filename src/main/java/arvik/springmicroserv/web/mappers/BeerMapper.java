package arvik.springmicroserv.web.mappers;

import arvik.springmicroserv.domain.BeerMap;
import arvik.springmicroserv.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @author ArvikV
 * @version 1.0
 * @since 12.07.2022
 * маппим объект BeerDto в другую сущность BeerMap и обратно
 */
@Mapper
public interface BeerMapper {
    BeerDto beerMapToBeerDto(BeerMap beerMap);
    BeerMap beerDtoToBeerMap(BeerDto dto);
}
