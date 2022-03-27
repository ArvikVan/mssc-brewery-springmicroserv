package arvik.springmicroserv.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 27.03.2022
 */
@Data /*Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.*/
@NoArgsConstructor/*Generates a no-args constructor. Will generate an error message if such a
constructor cannot be written due to the existence of final fields.*/
@AllArgsConstructor/*Generates an all-args constructor. An all-args constructor requires one argument for every
field in the class.*/
@Builder/*куча конструкторов на каждое поле и класс*/
public class BeerDtoV2 {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
}
