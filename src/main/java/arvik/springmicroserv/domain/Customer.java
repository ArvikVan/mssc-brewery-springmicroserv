package arvik.springmicroserv.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
public class Customer {
    private UUID id;
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
}
