import java.awt.*;
import javax.swing.*;

public class addCategory {
    
    private JFrame frame;
    private ImageIcon image;
    protected Text_Fields categoryName;
    protected sideBar s1;
    protected JButton b3, b4;
    protected JLabel newLabel;
    // Default Constructor
    public addCategory(){

    }

    // Argumented Constructor
    public addCategory(int width, int height, int R, int G, int B, String title, String location){
        //super(width, height, R, G, B, title, location);
        
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
        button back = new button();
        frame.add(back.setButton(215, 25, 60, 60, "<", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238));
        
        // confirm button
        button confirm = new button();
        frame.add(confirm.setButton(945, 420, 150, 60, "Confirm", "Fonts\\Montserrat-Bold.ttf", 16f, 255, 248, 238, 249, 165, 20));

        // Add Picture button
        button addPicture = new button();
        frame.add(addPicture.setButton(925, 324, 190, 60, "Add Picture", "Fonts\\Montserrat-Bold.ttf", 16f, 255, 248, 238, 249, 165, 20));

        // ----------- New Picture Added ----------- //
        newLabel = new JLabel();
        JPanel product = new JPanel();
        newLabel.setIcon(Fashion.resizeImageIcon(new ImageIcon(Fashion.address2), 120-(2 * 2), 120-(2 * 2)));
        newLabel.setHorizontalAlignment(JLabel.CENTER);
        newLabel.setVerticalAlignment(JLabel.CENTER);
        
        product.setBounds(1010-50, 161+25,120 , 120);
        product.setBackground(new Color(255, 248, 238));
        product.setBorder(BorderFactory.createLineBorder(new Color(249, 165, 20), 2));
        product.setLayout(new BorderLayout());
        product.add(newLabel);

        frame.add(product);


        // -------------- Text Fields -------------- //
        // username
        categoryName = new Text_Fields();
        frame.add(categoryName.TF(466, 324, 60, 418, "abc"));

        // -------------- Text Fields Panels -------------- //
        // Two Panels indicating "Username" & "Password"
        categoryName.panels(this.frame, 465, 242, 230, 60, 249, 165, 20, "Category Name", "Fonts\\Montserrat-Bold.ttf", 18f);
        // -------------- Side Bar Orange -------------- //
        // Added the side Orange Panel with a Back button
        s1 = new sideBar();
        s1.panels(this.frame, 0, 0, 300, 759, 249, 165, 20, "Add Category", "Fonts\\Montserrat-Bold.ttf", 20f);
        
        
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
