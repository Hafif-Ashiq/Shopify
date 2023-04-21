import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;  
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import javax.swing.*;


// Cart Class and it's methods
class cart extends Fashion{
        
    

    // Argumented Constructor
    public cart(int width, int height, int R, int G, int B, String title, String location, String name, String text){
        super(width, height, R, G, B, title, location, name, text);
        
        // Go Back button
        cartButton back = new cartButton();
        this.frame.add(back.setButton(215, 25, 60, 60, "<", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238, false, ""));
        
    }

    public void addItems(){
        
        // File Handling shit gonna happen in here

        /* if(choice == true){
            // Add a new item
        }
        else{
            // Existing items
        } */
        
        
        // Move Forward
        cartButton move = new cartButton();
        this.frame.add(move.setButton(1055, 560, 60, 60, ">", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 254, 242, 225, false, ""));
        
        // Home Button
        cartButton home = new cartButton();
        this.frame.add(home.setButton(10, 645+8, 280, 60, "Home", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238, false, ""));
        panels(this.frame, 0, 645, 300, 75, 255, 248, 238, 249, 165, 20, "", "Fonts\\Montserrat-Bold.ttf", 22f, 0, 0, 0, 0, true);
        
        // All Buttons on the Cart Screen
        // cartButton less_1 = new cartButton();
        // cartButton more_1 = new cartButton();
        // cartButton delete_1 = new cartButton();

        /* cartButton less_2 = new cartButton();
        cartButton more_2 = new cartButton();
        cartButton delete_2 = new cartButton();

        cartButton less_3 = new cartButton();
        cartButton more_3 = new cartButton();
        cartButton delete_3 = new cartButton();

        cartButton less_4 = new cartButton();
        cartButton more_4 = new cartButton();
        cartButton delete_4 = new cartButton();

        cartButton less_5 = new cartButton();
        cartButton more_5 = new cartButton();
        cartButton delete_5 = new cartButton(); */


        ////////////////////////////////////////// IDHAR APUN KA KAAM HAI NAH BHAEEEE /////////////////////////////////////////////
        // String count = less_1.getCountLabel();

        // String productName = "Gildan Men's CrewT-Shirts Multipack";
        
        // // Picture
        // this.frame.add(productCategories(60, 60, 465, 92, "Fashion\\shirts.jpg", true, 2));
        // // Product Name
        // if (productName.length() > 20) {
        //     productName = productName.substring(0, 18);
        //     panels(this.frame, 525, 92, 300, 60, 255, 248, 238, 249, 165, 20, productName + "...", "Fonts\\Montserrat-Bold.ttf", 18f, 18, 35, 35, 18, true);    
        // }
        // else{
        //     panels(this.frame, 525, 92, 300, 60, 255, 248, 238, 249, 165, 20, productName + "...", "Fonts\\Montserrat-Bold.ttf", 18f, 18, 35, 35, 18, true);        
        // }        
        // // Less Button
        // this.frame.add(less_1.setButton(850, 92, 60, 60, "-", "Fonts\\Montserrat-SemiBold.ttf", 22f, 249, 165, 20, 254, 242, 225, false, ""));
        // // More Button
        // this.frame.add(more_1.setButton(970, 92, 60, 60, "+", "Fonts\\Montserrat-SemiBold.ttf", 22f, 249, 165, 20, 254, 242, 225, false, ""));
        // // Quantity
        // panels(this.frame, 910, 92, 60, 60, 255, 248, 238, 249, 165, 20, count, "Fonts\\Montserrat-SemiBold.ttf", 20f, 18, 35, 35, 18, true);
        // // Bottom Line
        // panels(this.frame, 465, 167, 650, 2, 216, 216, 216, 216, 216, 216, "", "Fonts\\Montserrat-SemiBold.ttf", 20f, 18, 35, 35, 18, true);
        // // Delete Button
        // this.frame.add(delete_1.setButton(1055, 92, 60, 60, "-", "Fonts\\Montserrat-SemiBold.ttf", 22f, 249, 165, 20, 249, 165, 20, true, "Icons\\delete_Owhite.png"));
        


        ArrayList<CartProducts> cItems = textFields.currentUser.getCartItems();

        int y = 92;    // +92
        int yLine = 167; // + 92

        double price = 0;
        for (int i = 0; i < cItems.size(); i++) {
            cartButton less_1 = new cartButton();
            cartButton more_1 = new cartButton();
            cartButton delete_1 = new cartButton();

            int count = cItems.get(i).getNumberOfProducts();
            String countItems = count + "";

            String productName = cItems.get(i).getProducts().getName();
            price += (count* cItems.get(i).getProducts().getPrice());
            // Picture
            this.frame.add(productCategories(60, 60, 465, y, cItems.get(i).getProducts().getAddressImage(), true, 2));
            // Product Name
            if (productName.length() > 20) {
                productName = productName.substring(0, 18);
                panels(this.frame, 525, y, 300, 60, 255, 248, 238, 249, 165, 20, productName + "...", "Fonts\\Montserrat-Bold.ttf", 18f, 18, 35, 35, 18, true);    
            }
            else{
                panels(this.frame, 525, y, 300, 60, 255, 248, 238, 249, 165, 20, productName + "...", "Fonts\\Montserrat-Bold.ttf", 18f, 18, 35, 35, 18, true);        
            }        
            // Less Button
            this.frame.add(less_1.setButton(850, y, 60, 60, "-", "Fonts\\Montserrat-SemiBold.ttf", 22f, 249, 165, 20, 254, 242, 225, false, ""));
            if (count == 1) {
                less_1.getButton().setEnabled(false);
            }
            // More Button
            this.frame.add(more_1.setButton(970, y, 60, 60, "+", "Fonts\\Montserrat-SemiBold.ttf", 22f, 249, 165, 20, 254, 242, 225, false, ""));
            
            // Quantity
            panels(this.frame, 910, y, 60, 60, 255, 248, 238, 249, 165, 20, countItems, "Fonts\\Montserrat-SemiBold.ttf", 20f, 18, 35, 35, 18, true);
            
            // Bottom Line
            panels(this.frame, 465, yLine, 650, 2, 216, 216, 216, 216, 216, 216, "", "Fonts\\Montserrat-SemiBold.ttf", 20f, 18, 35, 35, 18, true);
            // Delete Button
            this.frame.add(delete_1.setButton(1055, y, 60, 60, "-", "Fonts\\Montserrat-SemiBold.ttf", 22f, 249, 165, 20, 249, 165, 20, true, "Icons\\delete_Owhite.png"));
            
            y += 92;
            yLine += 92;
        }

        // Total Price
        panels(this.frame, 850, 560, 205, 60, 255, 248, 238, 249, 165, 20, "Price: $"+price, "Fonts\\Montserrat-Bold.ttf", 22f, 0, 0, 0, 0, true);
        


    }

    // Getters
    public JFrame getFrame(){
        return this.frame;
    }
    

}

// Button Class for creating new buttons
class cartButton implements ActionListener, font{

    int count = 1;
    String countLabel = count + "";

    private Font font;
    private JButton button;

    public JButton getButton() {
        return button;
    }
    // Default constructior
    public cartButton(){

        button = new JButton();
        button.setBounds(100, 100, 100, 50);

    }

    // count setter
    public void setCount(int count_prime){
        this.count = count_prime;
    }

    public int getCount(){
        return count;
    }

    public String getCountLabel(){
        return countLabel;
    }
    // Gonna create bottons with this one
    public JButton setButton(int button_x, int button_y, int buttonWidth, int buttonHeight, String buttonText, String fontLocation, float fontSize, int Fr_R, int Fr_G, int Fr_B,int Br_R, int Br_G, int Br_B, Boolean choice, String imageLocation ) {
        
        button = new JButton();

        if(choice == true){

            this.button.setBounds(button_x, button_y, buttonWidth, buttonHeight);
            this.button.setBackground(new Color(Br_R, Br_G, Br_B));
            this.button.addActionListener(this);
            this.button.setBorder(BorderFactory.createLineBorder((new Color(255, 248, 238)), 0));
            this.button.setIcon(resizeImageIcon(new ImageIcon(imageLocation), 16, 20));
            
            return button;
        }
        else{
            this.button.setBounds(button_x, button_y, buttonWidth, buttonHeight);
            this.button.setForeground(new Color(Fr_R, Fr_G, Fr_B));
            this.button.setBackground(new Color(Br_R, Br_G, Br_B));
            
            this.button.setOpaque(true);
            this.button.setContentAreaFilled(true);
            this.button.setBorder(BorderFactory.createLineBorder(new Color(249, 165, 20), 0));
            this.button.setBorderPainted(true);
            //this.button.addActionListener(this);

            // Added text with in the button
            this.button.setText(buttonText);
            this.button.setFont(newFont(fontLocation, fontSize));
            this.button.setHorizontalTextPosition(JButton.CENTER);
            this.button.setVerticalTextPosition(JButton.CENTER);

            this.button.addActionListener(this);

            return button;    
        }
        
        
    }


    // Button Action State
    public void actionPerformed(ActionEvent e) {
        
        // We could add the proccess of comparing login and 
        // password details and then giving the access to the
        // person to move to the next page! 
        
        // Home Button
        if(e.getSource() == button && button.getX() == 10 && button.getY() == 645+8){
            
            // Disposing cart
            JFrame frame = Main.c1.getFrame();
            frame.setVisible(false);

            Main.s1.categories_Buttons();
            Main.s1.setVisible(true);
            System.out.println("Alright Let's go home!");
            
        }
        // Move
        else if(e.getSource() == button && button.getX() == 1055 && button.getY() == 560){
            // disposing JFrame of Cart
            JFrame frame = Main.c1.getFrame();
            frame.dispose();


            //textFields t1 = new textFields(1280, 759, 255, 248, 238, "Shopify", "Logos\\ShopifyPNG.png");
            Main.py1.setVisible(true);
            
            System.out.println("Alright Let's move!");
            
        }
        else if(e.getSource() == button && button.getX() == 215 && button.getY() == 25){
            Main.c1.dispose();

            Main.s1 =  new Screen(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");

            // Main.s1.addNewItem(868, 478);
            Main.s1.categories_Buttons();

            Main.s1.setVisible(true);
            // Main.s1.addNewItem(868, 478);
            System.out.println("Heading Back");
            
        }
        // First Button
        else {

            ArrayList<CartProducts> cItems = textFields.currentUser.getCartItems();


            
            int y = 92;    // +92

            for (int i = 0; i < cItems.size(); i++) {
                if(e.getSource() == button && button.getX() == 850 && button.getY() == y){
                    cItems.get(i).setNumberOfProducts(cItems.get(i).getNumberOfProducts()-1);

                    fileO<loginCredentials> f = new fileO<>();
                    f.update(textFields.currentUser);

                    button.setEnabled(true);
                    // Main.c1.panels(Main.c1.frame, 910, y, 60, 60, 255, 248, 238, 249, 165, 20, cItems.get(i).getNumberOfProducts()+"", "Fonts\\Montserrat-SemiBold.ttf", 20f, 18, 35, 35, 18, true);
                    Main.c1.dispose();
                    Main.c1 = new cart(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Cart");
                    Main.c1.addItems();
                    Main.c1.setVisible(true);
                    System.out.println("Clicked First Less!");
                    
                }
                else if(e.getSource() == button && button.getX() == 970 && button.getY() == y){
                    cItems.get(i).setNumberOfProducts(cItems.get(i).getNumberOfProducts()+1);
                    fileO<loginCredentials> f = new fileO<>();
                    f.update(textFields.currentUser);

                    Main.c1.dispose();
                    Main.c1 = new cart(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Cart");
                    Main.c1.addItems();
                    Main.c1.setVisible(true);
                    System.out.println("Clicked First More!");
                    
                }
                else if(e.getSource() == button && button.getX() == 1055 && button.getY() == y){
                    
                    cItems.remove(i);
                    fileO<loginCredentials> f = new fileO<>();
                    f.update(textFields.currentUser);
                    ArrayList<CartProducts> c = textFields.currentUser.getCartItems();
                    if (c.size() == 0) {
                        Main.s1.setVisible(true);   
                    }
                    else{
                        Main.c1.dispose();
                        Main.c1 = new cart(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Cart");
                        Main.c1.addItems();
                        Main.c1.setVisible(true);
                        
                    }
                    System.out.println("Clicked  Delete!");
                }
                
                y += 92;

            }
            
        




            

            
                
            
        }

        

    }


    // Making a New Font
    public Font newFont(String fontLocation, Float fontSize) {
        
        // Creating a new custom font
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontLocation)).deriveFont(fontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(font);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
        return font;
    }

    // Method to resize Image
    public static ImageIcon resizeImageIcon(ImageIcon ii, int width, int height){
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }

}


