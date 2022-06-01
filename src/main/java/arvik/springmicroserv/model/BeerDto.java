package arvik.springmicroserv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 25.03.2022
 */
@Data /*Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.*/
@NoArgsConstructor/*Generates a no-args constructor. Will generate an error message if such a
constructor cannot be written due to the existence of final fields.*/
@AllArgsConstructor/*Generates an all-args constructor. An all-args constructor requires one argument for every
field in the class.*/
@Builder/*куча конструкторов на каждое поле и класс*/
public class BeerDto {
    @Null/*The annotated element must be null. Accepts any type.*/
    private UUID id;
    @NotBlank /*The annotated element must not be null and must contain at least one non-whitespace character. Accepts CharSequence.*/
    private String beerName;
    @NotBlank
    private String beerStyle;
    @Positive
    private Long upc;
}
