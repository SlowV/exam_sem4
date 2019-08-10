package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;

@Entity
public class Phone {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "accountId", columnDefinition = "varchar(100)")
    private String id;
    private String name;
    private String brand;
    private String price;
    private String description;

    public Phone() {
    }

    public Phone(String name, String brand, String price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, String> validPhone() {
        HashMap<String, String> errors = new HashMap<>();
        if (this.name.isEmpty()){
            errors.put("name", "Name is empty!");
        }else if(this.brand.isEmpty()){
            errors.put("brand", "brand is empty!");
        }else if(this.price.isEmpty()){
            errors.put("price", "price is empty!");
        }else if(this.description.isEmpty()){
            errors.put("description", "description is empty!");
        }
        return errors;
    }
}
