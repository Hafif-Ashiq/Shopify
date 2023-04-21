import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class cash extends textFields{
    
    private JFrame frame;
    private ImageIcon image;
    // Default Constructor
    public cash(){

    }

    // Argumented Constructor
    public cash(int width, int height, int R, int G, int B, String title, String location){
        super(width, height, R, G, B, title, location);
        
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
        frame.add(b2.setButton(565, 520, 150, 60, "Proceed", "Fonts\\Montserrat-Bold.ttf", 18f, 255, 248, 238, 249, 165, 20));

        cartButton home = new cartButton();
        this.frame.add(home.setButton(10, 645+8, 280, 60, "Home", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238, false, ""));
        //panels(this.frame, 0, 645, 300, 75, 255, 248, 238, 249, 165, 20, "", "Fonts\\Montserrat-Bold.ttf", 22f, 0, 0, 0, 0, true);
        
        // -------------- Text Fields -------------- //
        // UserName
        Text_Fields t1 = new Text_Fields();
        frame.add(t1.TF(408, 223, 60, 522, ""));
        // Password
        Text_Fields t2 = new Text_Fields();
        frame.add(t2.TF(408, 405, 60, 250, "+XX-XXX-XXXXXXX"));
        // Confirm Password
        Text_Fields t3 = new Text_Fields();
        frame.add(t3.TF(683, 405, 60, 247, "XXX"));
        

        // -------------- Text Fields Panels -------------- //
        // Two Panels indicating "Card Number" , "Expiry Date" & "CVC"
        t1.panels(this.frame, 408, 141, 230, 60, 249, 165, 20, "Permanent Address", "Fonts\\Montserrat-Bold.ttf", 16f);
        t1.panels(this.frame, 408, 323, 190, 60, 249, 165, 20, "Phone  Number", "Fonts\\Montserrat-Bold.ttf", 16f);
        t1.panels(this.frame, 683, 323, 150, 60, 249, 165, 20, "Postal Code", "Fonts\\Montserrat-Bold.ttf", 16f);
        
        // -------------- Side Bar Orange -------------- //
        // Added the side Orange Panel with a Back button
        sideBar s1 = new sideBar();
        s1.panels(this.frame, 0, 0, 300, 759, 249, 165, 20, "Credit Card", "Fonts\\Montserrat-Bold.ttf", 22f);
        
        
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

}
