package arvik.springmicroserv.bootstrap;

import arvik.springmicroserv.domain.Beer;
import arvik.springmicroserv.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author ArvikV
 * @version 1.0
 * @since 28.04.2022
 */

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {
    public static final String BEER_1_UPC= "3232323233";
    public static final String BEER_2_UPC= "2232323233";
    public static final String BEER_3_UPC= "1232323233";
    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                            .beerName("MANGOBOOOB")
                            .beerStyle("IPA")
                            .quantityToBrew(200)
                            .upc(BEER_1_UPC)
                            .price(new BigDecimal("12.366"))
                            .minOnHand(32)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("ArvikBeer2")
                    .beerStyle("ALE")
                    .quantityToBrew(200)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("10.35"))
                    .minOnHand(2)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("ArvikBeer3")
                    .beerStyle("ALE")
                    .quantityToBrew(200)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("10.35"))
                    .minOnHand(2)
                    .build());
        }
        System.out.println("Loaded beer " + beerRepository.count());
    }
}

