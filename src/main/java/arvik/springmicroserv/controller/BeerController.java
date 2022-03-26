package arvik.springmicroserv.controller;

import arvik.springmicroserv.model.BeerDto;
import arvik.springmicroserv.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 25.03.2022
 */
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

    @PostMapping()
    public ResponseEntity<BeerDto> handlePost(BeerDto beerDto) {
        BeerDto saveDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        /*добавим тут урл хосту позже*/
        headers.add("location", "/api/v1/beer" + saveDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> handleUpdate(@PathVariable("beerId") UUID beerId, BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
