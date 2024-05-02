package c322.springFlowers.repository;

import c322.springFlowers.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrdersRepository extends CrudRepository<Orders, String> {


    Orders save(Orders orders);

    List<Orders> findAll();
}
