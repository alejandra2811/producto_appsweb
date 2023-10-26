package pe.cibertec.ecommerce.ApiCustomer.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Customer findByNombre (String nombre); 
    Optional<Customer> findByDni (Long dni);
}
