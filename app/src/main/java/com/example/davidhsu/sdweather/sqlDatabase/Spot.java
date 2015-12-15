package com.example.davidhsu.sdweather.sqlDatabase;

/**
 * Created by David Hsu on 2015/9/15.
 */
import java.io.Serializable;

public class Spot {
    private int id;
    private String clothes;
    private String type;
    private String color;
    private String material;
    private byte[] image;

    public Spot(String clothes, String type, String color, String material, byte[] image) {
        this(0, clothes, type, color, material, image);
    }

    public Spot(int id, String clothes, String type, String color, String material, byte[] image) {
        this.id = id;
        this.clothes = clothes;
        this.type = type ;
        this.color = color;
        this.material = material;
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getClothes() {
        return clothes;
    }

    public void setType(String type) {this.type = type;}

    public String getType() {
        return type;
    }

    public void setColor(String color) {this.color = color;}

    public String getColor() {return color;}

    public void setMaterial(String material) {this.material = material;}

    public String getMaterial() {return material;}

    public void setImage(byte[] image) {this.image = image;}

    public byte[] getImage() {return image;}
}
