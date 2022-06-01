package arvik.springmicroserv.controller;

import arvik.springmicroserv.model.BeerDto;
import arvik.springmicroserv.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 25.03.2022
 */
@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    /**
     * метод добавления обжекта
     * @param beerDto обжект для добавления
     * @return на выходе создание обжекта
     * добавлен реквестбоди потому что на выходе получался пустой обжект
     */
    @PostMapping
    public ResponseEntity<BeerDto> handlePost(@Valid @RequestBody BeerDto beerDto) {
        BeerDto saveDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        /*добавим тут урл хосту позже*/
        headers.add("location", "/api/v1/beer" + saveDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * метод обновления пиваса
     * @param beerId пивное ид
     * @param beerDto пивной обжект
     * @return на выходе статус, потому как не доделан метод
     * добавлен реквестбоди потому что на выходе получался пустой обжект
     */
    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * метод удаления
     * @param beerId ид для удаления
     *               статус в отличие от других метод задаем аннотацией
     */
    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
        }
}
