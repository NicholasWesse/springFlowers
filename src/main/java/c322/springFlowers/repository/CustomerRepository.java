package c322.springFlowers.repository;



import c322.springFlowers.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findByUsername(String username);

    List<Customer> findAll();


}
