package arvik.springmicroserv.domain;

import arvik.springmicroserv.model.v2.BeerStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 12.07.2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerMap {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
}
