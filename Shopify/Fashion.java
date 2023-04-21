
import java.awt.event.*;  
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Fashion extends categories {

    protected JFrame frame;
    protected JPanel product;
    protected ImageIcon image;
    protected ArrayList<Products> cartItems = new ArrayList<>(); 
    protected static String address2 = null;

    // Arugumented COnstructor
    public Fashion(int width, int height, int R, int G, int B, String title, String location, String name, String text){
        
        super();
        this.frame = new JFrame();

        // Essentials for menu display
        this.frame.setSize(width, height);          
        this.frame.setLayout(null);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(new Color(R, G, B));
        
        // Title and Logo
        this.image = new ImageIcon(location);
        this.frame.setIconImage(image.getImage());
        this.frame.setTitle(title);    
        
            
        // Orange panel 
        panels(frame, 0, 0, 300, 645, 255, 248, 238, 249, 165, 20, text, "Fonts\\Montserrat-Bold.ttf", 22f, 0, 0, 0, 0, true);
        
    }

    // Must call Method to display
    public void setVisible(boolean set){
        this.frame.setVisible(set);
    }

    // Getters
    public JFrame getFrame(){
        return this.frame;
    }

    public void dispose(){
        this.frame.dispose();
    }
    

    // Method to resize Image
    public static ImageIcon resizeImageIcon(ImageIcon ii, int width, int height){
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }

    public void goBackbutton(){

        // Go Back button
        newButton back = new newButton();
        this.frame.add(back.setButton(215, 25, 60, 60, "<", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238));
        

    }
    public void addNewItem(int x, int y){

        // If admin has login in then he has the abaility to add or remove items
        // the frame should refresh good after things have been done
        
        

    }
    
    // gonna use it for the addition of products
    public void addItems(){
        
        /* if(choice == true){
            // Add a new item
        }
        else{
            // Existing items
        } */


        

        // Cart
        newButton cart = new newButton();
        this.frame.add(cart.setButton(10, 645+8, 280, 60, "Cart", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238));
        panels(this.frame, 0, 645, 300, 75, 255, 248, 238, 249, 165, 20, "", "Fonts\\Montserrat-Bold.ttf", 22f, 0, 0, 0, 0, true);
        

        // FileOperations<Categories1> filee = new FileOperations<>();
        Categories1 c = categories.selectedCategory;
        ArrayList<Products> p = c.getListP();

        int xLabel = 570; //  +440
        int xPCategory = 370; // +440
        int yPCategory = 86; // +294
        int yButton = 296;  // + 294
        int yLabel = 86;    // + 294
        int xNew = 548;
        int yNew = 191;
        int xCross = 740;
        int yCross = 86;


        for(int i=0;i< p.size();i++){
            // Cross  Button for admin
            if (textFields.currentUser.getEmail().equals("admin@gmail.com")) {
                
            
                newButton cross7 = new newButton();
                this.frame.add(cross7.setButton(xCross, yCross, 30, 39, "x", "Fonts\\Montserrat-SemiBold.ttf", 15f, 255, 248, 238, 249, 165, 20));        
            }


            this.frame.add(productCategories(200, 255, xPCategory, yPCategory, p.get(i).getAddressImage(), true, 5));
            panels(this.frame, xLabel, yLabel, 200, 210, 0, 0, 0, 254, 242, 225, p.get(i).getName() + "\t\t\t " + " Size:  " + p.get(i).getSize() + " Color: " + p.get(i).getColor() + "\t " + " Price: $ " + p.get(i).getPrice(), "Fonts\\Montserrat-Regular.ttf", 14f, 42, 40, 32, 40, false);
            
            newButton b1 = new newButton();
            this.frame.add(b1.setButton(xLabel, yButton, 200, 45, "+ Add to cart", "Fonts\\Montserrat-SemiBold.ttf", 14f, 255, 248, 238, 249, 165, 20));
            
            if (textFields.currentUser.getItemIndex(p.get(i)) != -1) {
                
            
                b1.getButton().setEnabled(false);
                b1.getButton().setText("Added");
                b1.getButton().setBackground(new Color(254, 242, 225));
            }

            if ((i+1) % 2 == 0 ) {
                yPCategory += 294;
                yButton += 294;
                yLabel += 294;
                yNew += 294;
                yCross += 294;

                xCross = 740;
                xNew = 548;
                xLabel = 570;
                xPCategory = 370;
            }
            else{
                xNew += 440;
                xLabel+= 440;
                xPCategory += 440;
                xCross += 440;
            }
        }
        if (textFields.currentUser.getEmail().equals("admin@gmail.com")) {

            newButton newItem = new newButton();
            this.frame.add(newItem.setButton(xNew, yNew, 45, 45, "+", "Fonts\\Montserrat-Regular.ttf", 30f, 255, 248, 238, 249, 165, 20));
        }
        // System.out.println("Button : x,y ::" + xNew + "  , " + yNew);

        
    }

    // Categories Pictures
    public JPanel productCategories(int width, int height, int x_axis, int y_axis, String imageLocation, Boolean choice, int thickness){

        product = new JPanel();

        if(choice == true){
            
            JLabel newLabel = new JLabel();
            newLabel.setIcon(resizeImageIcon(new ImageIcon(imageLocation), width-(thickness * 2), height-(thickness * 2)));
            newLabel.setHorizontalAlignment(JLabel.CENTER);
            newLabel.setVerticalAlignment(JLabel.CENTER);

            this.product.setBounds(x_axis, y_axis, width, height);
            this.product.setBorder(BorderFactory.createLineBorder(new Color(249, 165, 20), thickness));
            this.product.setLayout(new BorderLayout());
            this.product.add(newLabel);
            return product;
        }
        else{
            JLabel newLabel = new JLabel();
            newLabel.setIcon(resizeImageIcon(new ImageIcon(imageLocation), width, height));
            this.product.setBounds(x_axis, y_axis, width, height);
            this.product.setLayout(new BorderLayout());
            this.product.add(newLabel);
            
            return product;
        }
        


    }
    
    // Gonna use this one for orange panels
    public void panels(JFrame frame, int x_axis, int y_axis, int width, int height, int T_R, int T_G, int T_B, int P_R, int P_G, int P_B, String text, String fontLocation, float fontSize, int top, int left, int right, int bottom, Boolean choice) {
    
        if(choice == true){
            // Creating new Label
            this.buttonLabel = new JLabel();

            this.buttonLabel.setText(text);
            this.buttonLabel.setFont(newFont(fontLocation, fontSize));
            this.buttonLabel.setForeground(new Color(T_R, T_G, T_B));         
            //this.buttonLabel.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
            this.buttonLabel.setVerticalAlignment(JLabel.CENTER);
            this.buttonLabel.setHorizontalAlignment(JLabel.CENTER);
            
            // Creating new panels
            buttonPanel = new JPanel();
            this.buttonPanel.setBounds(x_axis, y_axis, width, height);
            this.buttonPanel.setBackground(new Color(P_R, P_G, P_B));
            this.buttonPanel.setLayout(new BorderLayout(40,10));
            
            // Inserting label into panel
            this.buttonPanel.add(buttonLabel);

            // inserting panel into JFrame
            frame.add(buttonPanel);
        }
        else{

            JTextArea textArea = new JTextArea();
            textArea.setText(text);
            textArea.setFont(newFont(fontLocation, fontSize));
            textArea.setForeground(new Color(T_R, T_G, T_B));         
            textArea.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
    
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setOpaque(false);
            textArea.setEditable(false);
            
            // Creating new panels
            buttonPanel = new JPanel();
            this.buttonPanel.setBounds(x_axis, y_axis, width, height);
            this.buttonPanel.setBackground(new Color(P_R, P_G, P_B));
            this.buttonPanel.setLayout(new BorderLayout(40,10));

            // Inserting label into panel
            this.buttonPanel.add(textArea);

            // inserting panel into JFrame
            frame.add(buttonPanel);

        }
        

        
    }
    
}

// Button Class for creating new buttons
class newButton implements ActionListener, font{

    private Font font;
    private JButton button;


    public JButton getButton() {
        return button;
    }
    // Default constructior
    public newButton(){

        button = new JButton();
        button.setBounds(100, 100, 100, 50);

    }

    // Gonna create bottons with this one
    public JButton setButton(int button_x, int button_y, int buttonWidth, int buttonHeight, String buttonText, String fontLocation, float fontSize, int Fr_R, int Fr_G, int Fr_B,int Br_R, int Br_G, int Br_B) {
        
        button = new JButton();

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
    // Button Action State
    public void actionPerformed(ActionEvent e) {
        
        // We could add the proccess of comparing login and 
        // password details and then giving the access to the
        // person to move to the next page! 
        
        // Previous Page
        if(e.getSource() == button && button.getX() == 215 && button.getY() == 25){

            Main.f1.getFrame().setVisible(false);
            Main.ab1.getFrame().setVisible(false);
            Main.s1.setVisible(true); 
            
            System.out.println("Heading Back!");
            

        }
        // head to Cart
        else if(e.getSource() == button && button.getX() == 10 && button.getY() == 645+8){
            
            ArrayList<CartProducts> c = textFields.currentUser.getCartItems();
            if (c.size() == 0) {
                JOptionPane.showMessageDialog(new JFrame(), "No Items In Cart");   
            }
            else{
                JFrame frame = Main.f1.getFrame();
                frame.dispose();
                Main.c1 = new cart(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Cart");

                Main.c1.addItems();
                Main.c1.setVisible(true);
                System.out.println("Heading to Cart!");
            }

        }
        else if (e.getSource() == Screen.addButton.button) {
                Main.s1.dispose();
                
                Main.ad1.setVisible(true);
                // Main.s1 = new Screen(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G, Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");
                
                System.out.println("Clicked! Add new Category");
        }
        else{
            
            ArrayList<Products> array = categories.selectedCategory.getListP();
            int xLabel = 570; //  +440
            
            int yButton = 296;  // + 294

            int xNew = 548;
            int yNew = 191;
            
            int xCross = 520;
            int yCross = 135;
            
            int xCrossC = 740;
            int yCrossC = 86;

            int count = 0;
            for (int i = 0; i < array.size(); i++) {

                if(e.getSource() == button && button.getX() == xLabel && button.getY() == yButton){

                    // Add check if the user logout's then set enabled get true again
        
                    System.out.println("Clicked! x:" + xLabel + ", y:" + yButton);
                    loginCredentials user = textFields.currentUser;

                    // System.out.println(user.getItemIndex(array.get(i)));
                    
                    
                    user.getCartItems().add(new CartProducts(array.get(i),1));
                    fileO<loginCredentials> fa = new fileO<>();
                    fa.update(user);
                    

                    button.setEnabled(false);
        
                    button.setText("Added");
                    button.setBackground(new Color(254, 242, 225));
                    
                }

                

                else if(e.getSource() == button && button.getX() == xCrossC && button.getY() == yCrossC){
                    
                    ArrayList<Products> array1 =   Fashion.selectedCategory.getListP();
                    // System.out.println(array1.get(i).getName());
                    array1.remove(i);
                    // System.out.println(array1.get(i).getName());

                    fileO<Categories1> fc = new fileO<>();
                    fc.update(Fashion.selectedCategory);

                    JFrame frame = Main.s1.getFrame();
                    frame.dispose();
                    Main.f1.dispose();

                    Main.f1 = new Fashion(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G, Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), Fashion.selectedCategory.getName());

                    // Main.f1.addNewItem(988, 485);
                    Main.f1.addItems();
                    Main.f1.goBackbutton();
                    Main.f1.setVisible(true);

                    
                }
                

                
               

                if ((i+1) % 2 == 0 ) {
                    yButton += 294;
                    yNew += 294;
    
                    xNew = 548;
                    xLabel = 570;

                    // xCross = 520;

                    yCrossC += 294;

                    xCrossC = 740;
                    // yCross+= 260;
                    
                }
                else{
                    
                    xNew += 440;
                    xLabel+= 440;
                    // xCross+= 220;

                    xCrossC += 440;
                }
                count++;
            }

            fileO<Categories1> f = new fileO<>();
            ArrayList<Categories1> cArray = f.getInArrayCategories();

            for (int i = 0; i < cArray.size(); i++) {
            
                if(e.getSource() == button && button.getX() == xCross && button.getY() == yCross){
                    fileO<Categories1> fu = new fileO<>();
                    fu.deleteCategory(i);

                    Main.s1.dispose();
                    Main.s1 =  new Screen(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");

                // Main.s1.addNewItem(868, 478);

                    Main.s1.categories_Buttons();
                    Main.s1.setVisible(true);
                    
                }


                if ((i+1) % 4 == 0 ) {
                    // yButton += 294;
                    // yNew += 294;
    
                    // xNew = 548;/
                    // xLabel = 570;

                    xCross = 520;

                    // yCrossC += 294;

                    // xCrossC = 740;
                    yCross+= 260;
                    
                }
                else{
                    
                    // xNew += 440;
                    // xLabel+= 440;
                    xCross+= 220;

                    // xCrossC += 440;
                }

            
            }


            // System.out.println("Clicked : x,y ::" + xNew + "  , " + yNew);
            if(e.getSource() == button && button.getX() == xNew && button.getY() == yNew){

                Main.f1.dispose();

                System.out.println("Clicked! Add new Product");
                Main.ap1.setVisible(true);
                
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

}
