import java.awt.*;

import javax.swing.*;


public class addProduct {
    
    private JFrame frame;
    private ImageIcon image;
    protected Text_Fields productName, productDescription, size, color, price;
    protected sideBar s1;
    protected JButton b3, b4;
    protected JLabel productLabel;

    // Default Constructor
    public addProduct(){

    }

    // Argumented Constructor
    public addProduct(int width, int height, int R, int G, int B, String title, String location){
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
        frame.add(confirm.setButton(995, 460, 150, 60, "Confirm", "Fonts\\Montserrat-Bold.ttf", 16f, 255, 248, 238, 249, 165, 20));

        // Add Picture button
        button addPicture = new button();
        frame.add(addPicture.setButton(975, 283, 190, 60, "Add Picture", "Fonts\\Montserrat-Bold.ttf", 16f, 255, 248, 238, 249, 165, 20));


        // ----------- New Picture Added ----------- //
        productLabel = new JLabel();
        JPanel product = new JPanel();
        productLabel.setIcon(Fashion.resizeImageIcon(new ImageIcon(Fashion.address2), 123-(2 * 2), 157-(2 * 2)));
        productLabel.setHorizontalAlignment(JLabel.CENTER);
        productLabel.setVerticalAlignment(JLabel.CENTER);
        
        product.setBounds(959+50, 145-41,123 , 157);
        product.setBackground(new Color(255, 248, 238));
        product.setBorder(BorderFactory.createLineBorder(new Color(249, 165, 20), 2));
        product.setLayout(new BorderLayout());
        product.add(productLabel);

        frame.add(product);

        // -------------- Text Fields -------------- //
        // Product Name
        productName = new Text_Fields();
        frame.add(productName.TF(415, 283, 60, 523, "abc"));

        // size
        size = new Text_Fields();
        frame.add(size.TF(415, 460, 60, 148, ""));
        
        // color
        color = new Text_Fields();
        frame.add(color.TF(604, 460, 60, 148, ""));
        
        // price
        price = new Text_Fields();
        frame.add(price.TF(793, 460, 60, 148, ""));
        
        
        // -------------- Text Fields Panels -------------- //
        // Product Name Panel
        productName.panels(this.frame, 414, 210, 210, 60, 249, 165, 20, "Product Name", "Fonts\\Montserrat-Bold.ttf", 18f);
        // Size Panel
        size.panels(this.frame, 414, 378, 110, 60, 249, 165, 20, "Size", "Fonts\\Montserrat-Bold.ttf", 18f);
        // Color Panel
        color.panels(this.frame, 604, 378, 110, 60, 249, 165, 20, "Color", "Fonts\\Montserrat-Bold.ttf", 18f);
        // Price Panel
        price.panels(this.frame, 793, 378, 110, 60, 249, 165, 20, "Price", "Fonts\\Montserrat-Bold.ttf", 18f);
        
        // -------------- Side Bar Orange -------------- //
        // Added the side Orange Panel with a Back button
        s1 = new sideBar();
        s1.panels(this.frame, 0, 0, 300, 759, 249, 165, 20, "Add Product", "Fonts\\Montserrat-Bold.ttf", 20f);
        
        
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
