package arvik.springmicroserv.controller;

import arvik.springmicroserv.model.CustomerDto;
import arvik.springmicroserv.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ArvikV
 * @version 1.0
 * @since 25.03.2022
 */
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId")UUID customerId) {
                return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> handlePost(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto saveDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/api/v1/customer" + saveDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> handleUpdate(@PathVariable("customerId") UUID customerId,
                                                    @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping({"/{customerId}"})
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }

    /**
     * Задание, ловим исключение
     * @param e исключение
     * @return на выходе пойманное исключение(в данном случае если имя вышло с промежутка 3-100 и не нулл установленные в дто)
     * и итогом BadRequest
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + " : " +  constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

}
