package arvik.springmicroserv.web.mappers;

import arvik.springmicroserv.domain.Customer;
import arvik.springmicroserv.model.CustomerDto;
import org.mapstruct.Mapper;

/**
 * @author ArvikV
 * @version 1.0
 * @since 12.07.2022
 */
@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
