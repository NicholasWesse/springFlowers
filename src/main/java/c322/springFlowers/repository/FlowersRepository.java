package c322.springFlowers.repository;


import c322.springFlowers.model.Flowers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowersRepository extends CrudRepository<Flowers, String> {

    Flowers save(Flowers flower);

    List<Flowers> findAll();
}
