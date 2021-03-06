package arvik.springmicroserv.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createDate;
    @Null
    private OffsetDateTime lastModifiedDate;
    @NotBlank /*The annotated element must not be null and must contain at least one non-whitespace character. Accepts CharSequence.*/
    private String beerName;
    @NotNull
    private String beerStyle;
    @Positive
    @NotNull
    private Long upc;
    @NotNull
    @Positive
    private BigDecimal price;

    private Integer quantityOnHand;
}
