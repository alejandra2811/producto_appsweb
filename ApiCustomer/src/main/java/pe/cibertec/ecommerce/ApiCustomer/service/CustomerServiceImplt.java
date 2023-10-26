package pe.cibertec.ecommerce.ApiCustomer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiCustomer.dao.CustomerRepository;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;
import pe.cibertec.ecommerce.ApiCustomer.exception.EntityNotFoundException;


@Service
public class CustomerServiceImplt implements CustomerService {

    @Autowired
    
    private CustomerRepository customerRepository;
    
    @Override
    public List<Customer> findAll() {

        return (List<Customer>) customerRepository.findAll();
        
    }

    @Override
    public Customer findByDni(Long dni) {
        
       return customerRepository.findByDni(dni).orElseThrow(()-> new EntityNotFoundException("User not found with dni "+dni.toString()));
        
    }
    
    
    @Override
    public Customer findById(Long id) {

        return customerRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found with id"+id.toString()));
    }

    @Override
    public Customer findByNombre(String nombre) {
        
        return customerRepository.findByNombre(nombre);
        
    }

    @Override
    public Customer add(Customer customer) {
        
        return customerRepository.save(customer);
        
    }

    @Override
    public Customer update(Customer customer) {
        
        var CustomerF = customerRepository.findById(customer.getId()).get();
        CustomerF.setNombre(customer.getNombre());
        CustomerF.setApellido(customer.getApellido());
        CustomerF.setCelular(customer.getCelular());
        CustomerF.setDirección(customer.getDirección());
        CustomerF.setEmail(customer.getEmail());
     
        return customerRepository.save(CustomerF);
        
    }   

    @Override
    public void delete(Long id) {
        
        var CustomerDB = customerRepository.findById(id).get();
        customerRepository.delete(CustomerDB);
        
    }
    
}
