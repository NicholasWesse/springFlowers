package c322.springFlowers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Entity
@Table(schema = "flowers")
public final class Images {

    @Id
    private int id;

    @Lob
    private File img;

    public Images(){}

    public Images(int id, File img){
        this.id = id;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }
}
