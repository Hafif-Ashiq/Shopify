import java.io.Serializable;

public class CartProducts implements Serializable{
    private Products p;
    private int numberOfProducts;

    public CartProducts(){

    }
    public CartProducts(Products p,int n){
        this.p = p;
        numberOfProducts = n;
    }
    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }
    public void setProduct(Products p) {
        this.p = p;
    }
    public int getNumberOfProducts() {
        return numberOfProducts;
    }
    public Products getProducts() {
        return p;
    }

}
