import java.io.Serializable;

public class Products implements Serializable{
    private String name;
    private String size;
    private String color;
    private double price;
    private String addressImage;

    public boolean equals(Products p){
        if (this.name.equals(p.name) && this.size.equals(p.size) && this.color.equals(p.color) && this.price == p.price) {
            return true;
        }
        return false;
    }

    public Products(String name,String size,String color,double price,String adressImage){
        this.name = name;
        this.size = size;
        this.color = color;
        this.addressImage = adressImage;
        if(price > 0){
            this.price = price;
        }
    }

    public void setAddressImage(String addressImage) {
        this.addressImage = addressImage;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAddressImage() {
        return addressImage;
    }
    public String getColor() {
        return color;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getSize() {
        return size;
    }
    
    @Override
    public String toString() {
        
        return name + " " + size + " " + color + " " + price + " " + addressImage;
    }
    
   


}


