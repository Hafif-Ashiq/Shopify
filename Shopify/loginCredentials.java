import java.io.Serializable;
import java.util.ArrayList;

public class loginCredentials implements Serializable{
    private String userName = " ",email;
    private char[] password;
    private ArrayList<CartProducts> cartItems = new ArrayList<>();

    public loginCredentials(){

    }
    public loginCredentials(String userName,String email,char[] password){
        this.userName = userName;

        if (email.contains("@") && email.contains(".com")) {
            this.email = email;
        }
        
        if (password.length >= 8) {
            this.password = password;
        }

    }

    public void setPassword(char[] password) {
        if (password.length >= 8) {
            this.password = password;
        }
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        if (email.contains("@") && email.contains(".com")) {
            this.email = email;
        }
    }
    public String getEmail() {
        return email;
    }
    public char[] getPassword() {
        return password;
    }
    public String getUserName() {
        return userName;
    }

    public String toString(){
        return email + " "+ userName + " " + password;
    }
    
    public void setCartItems(ArrayList<CartProducts> cartItems) {
        this.cartItems = cartItems;
    }
    public ArrayList<CartProducts> getCartItems() {
        return cartItems;
    }

    public int getItemIndex(Products p){
        for(int i = 0; i<cartItems.size();i++){
            System.out.println(p.toString() + "\n" + cartItems.get(i).getProducts().toString() +  "\n\n");
            if(p.equals(cartItems.get(i).getProducts())){
                return i;
            }
        }
        return -1;
    }

}
