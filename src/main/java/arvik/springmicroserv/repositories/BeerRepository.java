package arvik.springmicroserv.repositories;

import arvik.springmicroserv.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 26.04.2022
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
