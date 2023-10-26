package pe.cibertec.ecommerce.ApiCustomer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;
import pe.cibertec.ecommerce.ApiCustomer.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")

public class CustomerController {
    
    @Autowired
    
    private CustomerService customerService; 
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findByNombre/{nombre}")
    public ResponseEntity<Customer> findByNombre(@PathVariable("nombre") String nombre) {
        return new ResponseEntity<>(customerService.findByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/findByDni/{dni}")
    public ResponseEntity<Customer> findByDni(@PathVariable("dni") Long dni) {
        return new ResponseEntity<>(customerService.findByDni(dni), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.add(customer), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.update(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        customerService.delete(id);
    }
}
    
