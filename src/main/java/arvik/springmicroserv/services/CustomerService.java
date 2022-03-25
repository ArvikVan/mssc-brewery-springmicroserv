package arvik.springmicroserv.services;

import arvik.springmicroserv.model.CustomerDto;

import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 25.03.2022
 */
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
