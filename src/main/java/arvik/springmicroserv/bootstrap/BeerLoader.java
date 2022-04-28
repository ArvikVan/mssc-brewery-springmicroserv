package arvik.springmicroserv.bootstrap;

import arvik.springmicroserv.domain.Beer;
import arvik.springmicroserv.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author ArvikV
 * @version 1.0
 * @since 28.04.2022
 */
@Component
public class BeerLoader implements CommandLineRunner {
    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

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
                            .upc("3232323233L")
                            .price(new BigDecimal("12.366"))
                            .minOnHand(32)
                    .build());
            beerRepository.save(Beer.builder()
                    .beerName("ArvikBeer")
                    .beerStyle("ALE")
                    .quantityToBrew(200)
                    .upc("3232323233L")
                    .price(new BigDecimal("10.35"))
                    .minOnHand(2)
                    .build());
        }
        System.out.println("Loaded beer " + beerRepository.count());
    }
}
