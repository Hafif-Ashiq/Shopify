import java.awt.*;
import java.awt.event.*;  
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class textFields{

    private Font font;
    private JFrame frame;
    private ImageIcon image;
    protected JButton b1, b2;
    protected Text_Fields t1, t2;
    protected JLabel errorEmail,errorPassword;
    protected static loginCredentials currentUser = new loginCredentials();


    // Default Constructor
    public textFields(){

    }

    // Argumented Constructor
    public textFields(int width, int height, int R, int G, int B, String title, String location){
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
        
        // -------------- Top Right Logo -------------- //
        // Shopify Logo Implementaion
        logoLS l1 = new logoLS();
        frame.add(l1.setLogo("Logos\\ShopifyPNG.png", "Shopify", 40, 40, "Fonts\\Montserrat-Bold.ttf", 18f));
        
        // -------------- Buttons -------------- //
        // Back button
        button b1 = new button();
        frame.add(b1.setButton(215, 25, 60, 60, "<", "Fonts\\Montserrat-Bold.ttf", 18f, 249, 165, 20, 255, 248, 238));
        
        button b2 = new button();
        frame.add(b2.setButton(595, 552, 150, 60, "Jump In", "Fonts\\Montserrat-Bold.ttf", 18f, 255, 248, 238, 249, 165, 20));

        // -------------- Text Fields -------------- //
        // UserName
        t1 = new Text_Fields();
        frame.add(t1.TF(408, 234, 60, 522, "abc@gmail.com"));
        // Password
        t2 = new Text_Fields();
        frame.add(t2.PF(408, 417, 60, 522, "•••••"));

        errorEmail = new JLabel();
        errorEmail.setBounds(408,290,522,60);
        frame.add(errorEmail);
        errorPassword = new JLabel();
        errorPassword.setBounds(408,460,522,60);
        frame.add(errorPassword);
        
        // -------------- Text Fields Panels -------------- //
        // Two Panels indicating "Username" & "Password"
        t1.panels(this.frame, 408, 152, 150, 60, 249, 165, 20, "Email", "Fonts\\Montserrat-Bold.ttf", 16f);
        t1.panels(this.frame, 408, 335, 150, 60, 249, 165, 20, "Password", "Fonts\\Montserrat-Bold.ttf", 16f);
        
        // -------------- Side Bar Orange -------------- //
        // Added the side Orange Panel with a Back button
        sideBar s1 = new sideBar();
        s1.panels(this.frame, 0, 0, 300, 759, 249, 165, 20, "Login", "Fonts\\Montserrat-Bold.ttf", 22f);
        
        
    }
    public boolean isVisible() {
        return frame != null && frame.isVisible();
    }
    // Set visible Method
    public void setVisible(boolean check){
        this.frame.setVisible(check);
    }

    // Getters
    public JFrame getFrame(){
        return this.frame;
    }

    // ------------------------------- Interface Methods -------------------------------
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

class sideBar implements panelWithLabel{

    private JPanel panel;
    private JLabel label;
    private Font font;

    // Side Bar Panel!
    public void panels(JFrame frame, int x_axis, int y_axis, int width, int height, int R, int G, int B, String text, String fontLocation, float fontSize) {
        
        // Creating new Label
        this.label = new JLabel();
        this.label.setText(text);
        this.label.setFont(newFont(fontLocation, fontSize));
        this.label.setForeground(new Color(255, 248, 238));
        this.label.setHorizontalAlignment(JLabel.CENTER);        
        this.label.setVerticalAlignment(JLabel.CENTER);
        
        // Creating Orange Navbar Panel
        panel = new JPanel();
        this.panel.setBounds(x_axis, y_axis, width, height);
        this.panel.setBackground(new Color(R, G, B));
        this.panel.setLayout(new BorderLayout(40,10));
        
        
        
        // Inserting label into panel
        this.panel.add(label);

        // inserting panel into JFrame
        // Orange Title Nav bar
        frame.add(panel);


    }
    // label text
    public String labelText(){
        return label.getText();
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

class Text_Fields implements font, panelWithLabel, ActionListener{

    private JTextField field;
    private JPasswordField pswdField;
    private Font font;
    private JPanel panel;
    private JLabel label;
    String text = "";

    // Gonna make its object JPanel
    public void panels(JFrame frame, int x_axis, int y_axis, int width, int height, int R, int G, int B, String text,
        String fontLocation, float fontSize) {
        
        // Creating new Label
        this.label = new JLabel();
        this.label.setText(text);
        this.label.setFont(newFont(fontLocation, fontSize));
        this.label.setForeground(new Color(255, 248, 238));
        this.label.setHorizontalAlignment(JLabel.CENTER);        
        this.label.setVerticalAlignment(JLabel.CENTER);
        
        // Creating new panels
        panel = new JPanel();
        this.panel.setBounds(x_axis, y_axis, width, height);
        this.panel.setBackground(new Color(R, G, B));
        this.panel.setLayout(new BorderLayout(40,10));
        
        // Inserting label into panel
        this.panel.add(label);

        // Adding panel into frame
        frame.add(this.panel);
        
    }

    // Return a textField 
    public JTextField TF(int x_axis, int y_axis, int height, int width, String Text){

        this.field = new JTextField(25);
        this.field.setBounds(x_axis, y_axis,  width, height);;
        this.field.setFont(newFont("Fonts\\Montserrat-Regular.ttf", 18f));
        this.field.setText(Text);
        this.field.setEditable(true);
        this.field.setBackground(new Color(254, 242, 225));
        this.field.setCaretColor(Color.BLACK);
        this.field.setBorder(BorderFactory.createLoweredBevelBorder());
        this.field.addActionListener(this);
        
        return field;
    }

    

    // Return a passwordField 
    public JPasswordField PF(int x_axis, int y_axis, int height, int width, String Text){

        this.pswdField = new JPasswordField(15);
        this.pswdField.setBounds(x_axis, y_axis,  width, height);;
        this.pswdField.setFont(newFont("Fonts\\Montserrat-Bold.ttf", 20f));
        this.pswdField.setText(Text);
        this.pswdField.setEditable(true);
        this.pswdField.setBackground(new Color(254, 242, 225));
        this.pswdField.setCaretColor(Color.BLACK);
        this.pswdField.setBorder(BorderFactory.createLoweredBevelBorder());
        this.pswdField.addActionListener(this);
        
        return pswdField;
    }

    public void actionPerformed(ActionEvent e) {
        // text = field.getText();
        // try {
        //     File file = new File("Credentials.txt");
        //     file.createNewFile();
        //     System.out.println("Reached!");
        //     FileWriter writer = new FileWriter(file, true);
        //     writer.write(text + "\n");
        //     writer.close();

        // } catch (Exception ex) {
        //     System.out.println("Error!");
        // }
        
    }

    public void setBorder(Color c){
        
        if (field != null) {
            field.setBorder(BorderFactory.createLineBorder(c));
        }
        else if(pswdField != null){
            pswdField.setBorder(BorderFactory.createLineBorder(c));
        }
    }
    
    // ------- Set Text ------- //  
    public void setText(String text){

        field.setText(text);
    }

    public String getText(){
        return field.getText();
    }
    public char[] getPassword(){
        return pswdField.getPassword();
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
// Logo Class for the side monogram
class logoLS implements font{

    private ImageIcon logo;
    private JLabel logoName;
    private Font font;

    // Default Constructor
    public logoLS(){

        logo = new ImageIcon("Logos\\ShopifyPNG.png");
        logoName = new JLabel("Shopify");

    }

    public JLabel setLogo(String imageName, String logoText, int logoWidth, int logoHeight, String fontLocation, float fontSize){

        this.logo = resizeImageIcon(new ImageIcon(imageName), logoWidth, logoHeight);
        this.logoName = new JLabel("Shopify");
        this.logoName.setFont(newFont(fontLocation, fontSize));
        this.logoName.setBounds(1055, -10, 150, 100);
        this.logoName.setIconTextGap(10);
        this.logoName.setForeground(new Color(249, 165, 20));
        
        // Setting Logo inside JLabel of Logo
        logoName.setIcon(logo);

        return logoName;
    }


    // ----------------------------- Interface Methods ----------------------------- //
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

// Button Class for creating new buttons
class button implements ActionListener, font{

    private Font font;
    private JButton button;
    private Font errorFont = new Font("Calbri",Font.PLAIN,15);


    // Default constructior
    public button(){

        button = new JButton();
        button.setBounds(100, 100, 100, 50);

    }

    // Interface Method to change the state of the button
    public JButton setButton(int button_x, int button_y, int buttonWidth, int buttonHeight, String buttonText, String fontLocation, float fontSize, int Fr_R, int Fr_G, int Fr_B,int Br_R, int Br_G, int Br_B) {
        this.button.setBounds(button_x, button_y, buttonWidth, buttonHeight);
        this.button.setForeground(new Color(Fr_R, Fr_G, Fr_B));
        this.button.setBackground(new Color(Br_R, Br_G, Br_B));
        
        this.button.setOpaque(true);
        this.button.setContentAreaFilled(true);
        this.button.setBorder(BorderFactory.createRaisedBevelBorder());
        this.button.setBorderPainted(true);
        

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
        if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Jump in")){


            fileO<loginCredentials> f = new fileO<>();

            loginCredentials l = f.searchEmail(Main.t1.t1.getText());
            // System.out.println(l.toS  tring());
            if (l !=  null  && Arrays.equals(l.getPassword(), Main.t1.t2.getPassword())) {
                // Disposing JFrame of Login
                JFrame frame = Main.t1.getFrame();

                textFields.currentUser = l;
                // frame.setVisible(false);
                frame.dispose();
                Main.t1 = new textFields(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location);
                // textFields.current = l;
                Main.s1 =  new Screen(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");

                // Main.s1.addNewItem(868, 478);
                Main.s1.categories_Buttons();

                Main.s1.setVisible(true);

                // Main.s1.setUserName(l.getUserName());
                System.out.println("Clicked Jumped IN!");
            }
            boolean validE = false;
            
            if(l == null){
                Main.t1.t1.setBorder(Color.red);
                Main.t1.errorEmail.setFont(errorFont);
                Main.t1.errorEmail.setText("Email Not Found.. Try Signing Up instead");
                Main.t1.errorEmail.setForeground(Color.red);;

            }
            else{
                validE = true;
                Main.t1.t1.setBorder(new Color(152,251,152));
                Main.t1.errorEmail.setFont(errorFont);
                Main.t1.errorEmail.setText("");
                Main.t1.errorEmail.setForeground(Color.red);;
            }
            if(validE){
                if (!Arrays.equals(l.getPassword(), Main.t1.t2.getPassword())){
                    Main.t1.t2.setBorder(Color.red);
                    Main.t1.errorPassword.setFont(errorFont);
                    Main.t1.errorPassword.setText("Password Incorrect..");
                    Main.t1.errorPassword.setForeground(Color.red);
                }
                else{
                    Main.t1.t2.setBorder(new Color(152,251,152));
                    Main.t1.errorPassword.setFont(errorFont);
                    Main.t1.errorPassword.setText("");
                    Main.t1.errorPassword.setForeground(Color.red);   
                }
            }
            
        }
        // Back Button
        else if(e.getSource() == this.button && button.getX() == 215 && button.getY() == 25){

            

            if(Main.ad1.isVisible()  || Main.ap1.isVisible() || Main.py1.isVisible() || Main.cs1.isVisible()  || Main.cr1.isVisible() ){
                Main.ad1.getFrame().dispose();
                // Disposing JFrame of Add Product
                Main.ap1.getFrame().dispose();
                // Disposing JFrame of payment!
                Main.py1.getFrame().dispose();
                // Disposing JFrame of COD!
                Main.cs1.getFrame().dispose();
                // Disposing JFrame of Credit card!!
                Main.cr1.getFrame().dispose();
                
                Main.s1.setVisible(true);
                System.out.println("Moved to Home screen!");

            }
            else if(Main.t1.isVisible() || Main.su1.isVisible()){
                
                // Disposing JFrame of Login
                
                Main.t1.t1.setText("abc@gmail.com");
                Main.t1.getFrame().dispose();
                
                // Disposing JFrame of Signup
                Main.su1.getFrame().dispose();
                
                // Disposing JFrame of Add Category
                Main.ls1.setVisible();
                System.out.println("Moved to Main screen!");

            }
            // if (Main.su1.isVisible()) {
            //     // Disposing JFrame of Add Category
            //     Main.ls1.setVisible();
            //     System.out.println("Moved to Main screen!");

            // }
            

        }
        
        else if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Hop in")){

            String userName = Main.su1.t1.getText();



            String email = Main.su1.t2.getText();
            char[] pass = Main.su1.t3.getPassword();
            // System.out.println(pass);
            char[] confirm = Main.su1.t4.getPassword();

            
            
            

            
            
            boolean validEmail = false;
            
                

            if (email.contains("@")  && email.contains(".com")) {
                validEmail = true;
                Main.su1.errorEmail.setText("");
                Main.su1.errorEmail.setFont(errorFont);
                Main.su1.errorEmail.setForeground(Color.RED);
                Main.su1.t2.setBorder(new Color(152,251,152));
            }
            else{
                
                Main.su1.errorEmail.setText("Email should be of Format xxx@xxxxx.com");
                Main.su1.errorEmail.setFont(errorFont);
                Main.su1.errorEmail.setForeground(Color.RED);
                Main.su1.t2.setBorder(Color.RED);
            } 

            fileO<loginCredentials> f = new fileO<>();

            if (validEmail) {
                loginCredentials l = f.searchEmail(email);
                if (l != null) {
                    validEmail = false;
                    Main.su1.errorEmail.setText("Email Already Exists! Try Signing in..");
                    Main.su1.errorEmail.setFont(errorFont);
                    Main.su1.errorEmail.setForeground(Color.RED);
                    Main.su1.t2.setBorder(Color.RED);

                }else{
                    Main.su1.errorEmail.setText("");
                    Main.su1.errorEmail.setFont(errorFont);
                    Main.su1.errorEmail.setForeground(Color.RED);
                    Main.su1.t2.setBorder(new Color(152,251,152));
                }
        

            }
            
            boolean validPass = false;
               

                if (pass.length>= 8) {
                    if (Arrays.equals(pass,confirm)) {
                        validPass = true;
                        Main.su1.errorPassword.setText("");
                        Main.su1.errorPassword.setFont(errorFont);
                        Main.su1.t3.setBorder(new Color(152,251,152));
                        Main.su1.t4.setBorder(new Color(152,251,152));
                    }
                    else{
                        Main.su1.errorPassword.setText("                                        Passwords Don't Match...         ");
                        Main.su1.errorPassword.setFont(errorFont);
                        Main.su1.errorPassword.setForeground(Color.RED);
                        Main.su1.t3.setBorder(Color.RED);
                        Main.su1.t4.setBorder(Color.RED);
                    }
                }
                else{
                    Main.su1.errorPassword.setText("Password's length must be greater or equal to 8");
                    Main.su1.errorPassword.setFont(errorFont);
                    Main.su1.errorPassword.setForeground(Color.RED);
                    Main.su1.t3.setBorder(Color.RED);
                }
            
           
            
            
            if (validPass && validEmail) {

                loginCredentials newObj = new loginCredentials(userName, email, pass);
                textFields.currentUser = newObj;
                // FileOperations<loginCredentials> f = new FileOperations<>();
                f.writeToFile(newObj);

                // Disposing JFrame of Sign up
                Main.su1.getFrame().dispose();
                Main.su1 = new signupField(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location);
                
                Main.su1.getFrame().dispose();





                Main.s1 =  new Screen(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");

                // Main.s1.addNewItem(868, 478);

                Main.s1.categories_Buttons();
                Main.s1.setVisible(true);
                System.out.println("Clicked Jumped IN!");    
            }




            
        }
        
        else if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Verify")){

            String c = Main.cr1.t1.getText();
            System.out.println(Extras.validCreditCard(c));

            if (Extras.validCreditCard(c)) {
            // Disposing JFrame of Login
                JFrame frame = Main.cr1.getFrame();
                //frame.dispose();

                JOptionPane.showMessageDialog(frame, "Payment Successful");
                System.out.println("Verify!");
    
            }
            else{
                Main.cr1.t1.setBorder(Color.red);
            }            
        
        }
        // Add Category
        else if(e.getSource() == this.button && button.getX() == 925 && button.getY() == 324){
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif","jpeg");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
            }
            categories.address1 = chooser.getSelectedFile().getAbsolutePath();
            System.out.println(categories.address1);

            Main.ad1.newLabel.setIcon(Fashion.resizeImageIcon(new ImageIcon(Fashion.address1), 120-(2 * 2), 120-(2 * 2)));


        }
        else if(e.getSource() == this.button && button.getX() == 945 && button.getY() == 420){

            String name = Main.ad1.categoryName.getText();
            fileO<Categories1> f = new fileO<>();
            if(!f.nameCategoryExists(name)){
                Categories1 c = new Categories1(name, categories.address1);
                // FileOperations<Categories1> f = new FileOperations<>();
                f.writeToFile(c);
                Main.s1 =  new Screen(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");
                Main.s1.categories_Buttons();
                Main.s1.setVisible(true);
                Main.ad1.getFrame().dispose();

            }
            else{
                Main.ad1.categoryName.setBorder(Color.red);
            }
        }

        else if(e.getSource() == this.button && button.getX() == 975 && button.getY() == 283){
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", "jpg", "gif","jpeg");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
            }
            Fashion.address2 = chooser.getSelectedFile().getAbsolutePath();
            System.out.println(Fashion.address2);
            
            // ----------- Picture Added! ----------- //
            Main.ap1.productLabel.setIcon(Fashion.resizeImageIcon(new ImageIcon(Fashion.address2), 123-(2 * 2), 157-(2 * 2)));

        }

        // Add Product
        else if(e.getSource() == this.button && button.getX() == 995 && button.getY() == 460){
            

            boolean valid = false;
            boolean validP = true;
            String name = Main.ap1.productName.getText().toUpperCase();
            String color = Main.ap1.color.getText().toUpperCase();
            
            

            String price = Main.ap1.price.getText();
            
            String size = Main.ap1.size.getText().toUpperCase();

            

            for (int i = 0; i < price.length(); i++) {
                if (!Character.isDigit(price.charAt(i)) && price.charAt(i) != '.') {
                    validP = false;
                }
            }
            if (validP && (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") ||size.equalsIgnoreCase("large"))) {
                valid = true;
            }
            
            if (validP) {

                Main.ap1.price.setBorder(new Color(152,251,152));

            }
            else{
                Main.ap1.price.setBorder(Color.red);
                
            }

            if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") ||size.equalsIgnoreCase("large")) {
                Main.ap1.size.setBorder(new Color(152,251,152));
            }
            else{
                Main.ap1.size.setBorder(Color.red);
            }
            
            Main.ap1.productName.setBorder(new Color(152,251,152));
            Main.ap1.color.setBorder(new Color(152,251,152));
            
            if (valid) {
                double priced = Double.parseDouble(price);

                categories.selectedCategory.addProduct(new Products(name, size, color, priced, Fashion.address2));
                fileO<Categories1> f = new fileO<>();
                f.update(categories.selectedCategory);

                
                
                Main.s1 =  new Screen(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,Main.screen_B, Main.screen_Title, Main.screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");
                Main.s1.categories_Buttons();
                Main.s1.setVisible(true);
                Main.ad1.getFrame().dispose();
            }

        }
        
        else if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Proceed")){

            // Disposing JFrame of Login
            JFrame frame = Main.cs1.getFrame();
            //frame.dispose();

            JOptionPane.showMessageDialog(frame, "Your product will be delivered soon :)");
            
            System.out.println("Verify!");

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
