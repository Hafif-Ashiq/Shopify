import java.io.Serializable;
import java.util.ArrayList;

public class Categories1 implements Serializable {
    private  String name;
    private String imageAddress;
    private ArrayList<Products> listP = new ArrayList<>();


    public Categories1(String n,String im){
        name = n;
        imageAddress = im;
    }

    public void addProduct(Products p){
        listP.add(p);
    }
    public boolean productExists(String n){
        for (int i = 0; i < listP.size(); i++) {
            if(listP.get(i).getName().equals(n)){
                return true;
            }
        }
        return false;
    }

    public String getImageAddress() {
        return imageAddress;
    }
    public ArrayList<Products> getListP() {
        return listP;
    }
    public String getName() {
        return name;
    }
    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }
    public void setListP(ArrayList<Products> listP) {
        this.listP = listP;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
