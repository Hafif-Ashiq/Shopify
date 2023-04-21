import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class payment extends Screen{

    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;

    // Default Constructor
    public payment(){

        super();
        this.frame = new JFrame();

        // Essentials for menu display
        this.frame.setSize(1280,720);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.getContentPane().setBackground(Color.black);
        
        // Title and Logo
        this.image = new ImageIcon("Logos\\ShopifyPNG.png");
        this.frame.setIconImage(image.getImage());
        this.frame.setTitle("Shopify");

        this.frame.setVisible(true);  
    }

    // Argumented Constructor
    public payment(int width, int height, int R, int G, int B, String title, String location, String name, String text){
        
        super(width, height, R, G, B, title, location, name, text);
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
        
        // Back button
        button b1 = new button();
        frame.add(b1.setButton(215, 25, 60, 60, "<", "Fonts\\Montserrat-Bold.ttf", 18f, 249, 165, 20, 255, 248, 238));
        
        // Cash button
        categories cash = new categories();
        cash.newButton(this.frame, 470, 205, 300, 225, "Payment\\cash.jpg");
        cash.callBottomPannels(this.frame, 470, 427, 300, 60, 249, 165, 20, "Cash on Delivery", "Fonts\\Montserrat-Bold.ttf", 18f);
        
        // Credit Card
        categories card = new categories();
        card.newButton(this.frame, 810, 205, 300, 225, "Payment\\credit.jpg");
        card.callBottomPannels(this.frame, 810, 427, 300, 60, 249, 165, 20, "Credit Card", "Fonts\\Montserrat-Bold.ttf", 18f);
        
        // Home Button
        cartButton home = new cartButton();
        this.frame.add(home.setButton(10, 645+8, 280, 60, "Home", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238, false, ""));
        //panels(this.frame, 0, 645, 300, 75, 255, 248, 238, 249, 165, 20, "", "Fonts\\Montserrat-Bold.ttf", 22f, 0, 0, 0, 0, true);
        
        
        sideBar s1 = new sideBar();
        s1.panels(this.frame, 0, 0, 300, 759, 249, 165, 20, "Payment", "Fonts\\Montserrat-Bold.ttf", 22f);
        
        
                
    }
    public boolean isVisible() {
        return frame != null && frame.isVisible();
    }
      
    // Must call Method to display
    public void setVisible(boolean set){
       this.frame.setVisible(set);
    }

    // Getters
    public JFrame getFrame(){
        return this.frame;
    }
    
    
}
