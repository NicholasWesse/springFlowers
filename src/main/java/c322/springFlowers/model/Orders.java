package c322.springFlowers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(schema = "flowers")
public final class Orders {

    @Id
    private int id;


    private String date;
    private float cost;
    private List<Integer> flowersList;

    public Orders(){}
    public Orders(int id , List<Integer> flowersList){
        this.id = id;
        this.flowersList = flowersList;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   public List<Integer> getFlowersList() {
        return flowersList;
    }

    public void setFlowersList(List<Integer> flowersList) {
        this.flowersList = flowersList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
