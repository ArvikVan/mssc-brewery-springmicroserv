package arvik.springmicroserv.controller.v2;

import arvik.springmicroserv.model.BeerDto;
import arvik.springmicroserv.model.v2.BeerDtoV2;
import arvik.springmicroserv.services.v2.BeerServiceV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 27.03.2022
 */
@Validated/*дает возможность в параметрах метода валидировать и ловить исключения(NotNull)*/
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {
    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    /**
     * метод добавления обжекта
     * @param beerDto обжект для добавления
     * @return на выходе создание обжекта
     * добавлен реквестбоди потому что на выходе получался пустой обжект
     */
    @PostMapping
    public ResponseEntity<BeerDtoV2> handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 saveDto = beerServiceV2.saveNewBeer(beerDto);
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
    public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updateBeer(beerId, beerDto);
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
        beerServiceV2.deleteById(beerId);
    }

}
