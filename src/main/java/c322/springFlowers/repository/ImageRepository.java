package c322.springFlowers.repository;

import c322.springFlowers.model.Images;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Repository
public interface ImageRepository extends CrudRepository<Images, String> {

    public Images save(Images img);

    public Images findById(int id);
}
