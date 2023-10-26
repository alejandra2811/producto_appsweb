package pe.cibertec.ecommerce.ApiCustomer.service;

import java.util.List;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;

public interface CustomerService {
    
    public List<Customer> findAll();
    public Customer findById(Long id);
    public Customer findByNombre (String nombre);
    public Customer findByDni (Long dni);
    public Customer add(Customer customer);
    public Customer update(Customer customer);
    public void delete (Long id);  
}
