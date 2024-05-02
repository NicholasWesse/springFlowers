package c322.springFlowers.controllers;

import c322.springFlowers.model.Flowers;
import c322.springFlowers.model.Images;
import c322.springFlowers.model.Orders;
import c322.springFlowers.repository.FlowersRepository;
import c322.springFlowers.repository.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/flowers")
public class FlowersController {

    FlowersRepository flowersRepository;
    ImageRepository imageRepository;

    public FlowersController(FlowersRepository flowersRepository, ImageRepository imageRepository){
        this.flowersRepository = flowersRepository;
        this.imageRepository = imageRepository;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Flowers flower){
        List<Flowers> s = flowersRepository.findAll();
        int i=0;
        for(Flowers p : s){
            if(p.getId() >= i){
                i = p.getId() + 1;
            }
        }
        flower.setId(i);
        try {
            flowersRepository.save(flower);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(flower);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Flowers getById(@PathVariable int id){
        List<Flowers> flowers = flowersRepository.findAll();
        for(Flowers f : flowers){
            if(f.getId() == id){
                return f;
            }
        }
        return null;
    }

    @GetMapping
    public List<Flowers> getAll(){
        List<Flowers> flowers = flowersRepository.findAll();
        return flowers;
    }

    /*
    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) throws IOException {

        FileInputStream fis = new FileInputStream(imageRepository.findById(id).getImg());
        // Create a ByteArrayOutputStream to write the file content into memory
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        // Create a buffer to read the file content in chunks
        byte[] buffer = new byte[1024];
        int bytesRead;

        // Read from the file and write to the ByteArrayOutputStream until the end of file
        while ((bytesRead = fis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        // Close the streams
        fis.close();
        bos.close();


        byte[] image = bos.toByteArray();
        return ResponseEntity.status(HttpStatus.FOUND)
                .contentType(MediaType.IMAGE_PNG)
                .body(image);
    }

    @PostMapping("/images/{id}")
    public boolean setImage(@PathVariable int id, @RequestParam File file) throws IOException {
        imageRepository.save(new Images(id,file));
        return true;
    }


*/
}
