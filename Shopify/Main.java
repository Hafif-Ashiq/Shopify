
import java.awt.*;
import java.awt.event.*;  
import java.awt.event.ActionEvent;
import javax.swing.*;

// Essentials 
// Orange White: 255, 248, 238
// Orange:  249, 165, 20
// Light Orange: 254, 242, 225
// Line Color: 216, 216, 216
// FOnt: "Fonts\\Montserrat-Bold.ttf"

public class Main {
    
    // Screen Essentials
    protected static int screen_Width = 1280;
    protected static int screen_Height = 759;
    protected static int screen_R = 255;
    protected static int screen_G = 248;
    protected static int screen_B = 238; 
    protected static String screen_Title = "Shopify";
    protected static String screen_Image_Location = "Logos\\ShopifyPNG.png";

    // protected static classes
    protected static login_signup ls1 = new login_signup(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location);
    protected static Screen s1 = new Screen(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location, "Welcome, " + textFields.currentUser.getUserName(), "Categories");
    protected static Fashion f1 = new Fashion(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location, "Welcome, Abdullah", "Fashion");
    protected static textFields t1 = new textFields(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location);
    protected static cart c1 = new cart(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location, "Welcome, Abdullah", "Cart");
    protected static signupField su1 = new signupField(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location);
    protected static creditCard cr1 = new creditCard(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location);
    protected static cash cs1 = new cash(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location);
    protected static payment py1 = new payment(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location, "Welcome, Abdullah", "Categories");
    protected static addCategory ad1 = new addCategory(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location);
    protected static addProduct ap1 = new addProduct(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location);
    protected static about ab1 = new about(screen_Width, screen_Height, screen_R, screen_G, screen_B, screen_Title, screen_Image_Location, "Welcome, Abdullah", "Categories");
           

    public static void main(String[] args) {
        
        
        /* s1.categories_Buttons();
        s1.setVisible(true); */

       /*  f1.addItems();
        f1.setVisible(true); */
        
        
        // t1.setVisible(true);
        
        /* c1.addItems();
        c1.setVisible(true); */

        // Products p = new Products("name"," size"," color",12, "adressImage");
        
        
         ls1.setVisible();


//        char[] a = {'a','d','m','i','n','1','2','3'};
//        loginCredentials l = new loginCredentials("ADMIN", "admin@gmail.com",a );
//        l.getCartItems().add(new CartProducts(new Products("Essentials Men's Fleece Jogger Pants ", "Medium", "Grey", 20, "Fashion\\pants grey.jpg"), 2));
        // Categories1 c = new Categories1("Fashion", "Categories\\Fashion.jpg");
        // c.addProduct(new Products("Essentials Men's Fleece Jogger Pants ", "Medium", "Grey", 20, "Fashion\\pants grey.jpg"));
        // c.addProduct(new Products("Essentials Men's Fleece Jogger Pants ", "Medium", "White", 25, "Fashion\\pants.jpg"));
        // c.addProduct(new Products("Gildan Men's Crew T-Shirts Multipack ", "All", "All", 15, "Fashion\\shirts.jpg"));
        // Categories1 c2 = new Categories1("Electronics", "Categories\\Electronics.jpg");
        // Categories1 c3 = new Categories1("Movies", "Categories\\Movies.jpg");
        // Categories1 c4 = new Categories1("Sports", "Categories\\Sports.jpg");
        // Categories1 c5 = new Categories1("Kitchen", "Categories\\Kitchen.jpg");
    //     Categories1 c6 = new Categories1("Tools", "Categories\\Tools.jpg");
    //    fileO<Categories1>  fc = new fileO<>();
//        fc.writeToFile(l);
        // fc.writeToFile(c);
        // fc.writeToFile(c2);
        // fc.writeToFile(c3);
        // fc.writeToFile(c4);
        // fc.writeToFile(c5);
        // fc.writeToFile(c6);
        // ArrayList<Categories1> array = fc.getInArrayCategories();
        // ArrayList<loginCredentials> array = fc.getInArrayLogins();
        // System.out.println(array.get(0).getCartItems().size());


    //     JFrame j = new JFrame();
    //     j.setSize(500,500);
    //     j.setLayout(null);
    //    for(int i=0;i<array.size();i++){

    //     categories c1 = new categories();
    //     c1.newButton(j, 100, 100, 100, 100, array.get(i).getImageAddress());
    //    }

    //     // JButton b = new JButton();
    //     // b.setBounds(100,100,100,100);
    //     // ImageIcon i = new ImageIcon(c.getImageAddress());
    //     // b.setIcon(i);
    //     // j.add(b);
    //     j.setVisible(true);

    
    }   
}

class login_signup extends logo{
    private JFrame frame;
    private buttons login, signup; 
    private ImageIcon image;
    //private JLabel label;
    //private Font font;

    // Argumented Constructor
    public login_signup(int width, int height, int R, int G, int B, String title, String location){
        
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
        
        // Adding Logo
        this.frame.add(setLogo("Logos\\ShopifyPNG.png", "Shopify", 280, 280, "Fonts\\Montserrat-Bold.ttf", 26f));
        
        // Login
        login = new buttons();
        this.frame.add(login.setButton(440, 460, 400, 75, "Login", "Fonts\\Montserrat-Bold.ttf", 18f));
        
        // Signup
        signup = new buttons();
        this.frame.add(signup.setButton(440, 545, 400, 75, "Signup", "Fonts\\Montserrat-Bold.ttf", 18f));
        
        
    }
    public boolean isVisible() {
        return frame != null && frame.isVisible();
    }

    // Getters
    public JFrame getFrame(){
        return this.frame;
    }

    // Must call Method to display
    public void setVisible(){
        this.frame.setVisible(true);
    }

    public JLabel setLogo(String imageName, String logoText, int logoWidth, int logoHeight, String fontLocation, float fontSize){

        this.logo = resizeImageIcon(new ImageIcon(imageName), logoWidth, logoHeight);
        this.logoName = new JLabel("Shopify");
        this.logoName.setFont(newFont(fontLocation, fontSize));
        this.logoName.setBounds(500, 60, 280, 350);
        this.logoName.setIconTextGap(10);
        this.logoName.setForeground(new Color(249, 165, 20));
        this.logoName.setHorizontalTextPosition(JLabel.CENTER);
        this.logoName.setVerticalTextPosition(JLabel.BOTTOM);

        // Setting Logo inside JLabel of Logo
        logoName.setIcon(logo);

        return logoName;
    }
}

class buttons extends menuButtons{
    // Default Constructor
    public buttons(){
        super();
    }
    
    // creating a custom button
    public JButton setButton(int button_x, int button_y, int buttonWidth, int buttonHeight, String buttonText, String fontLocation, float fontSize){

        this.button.setBounds(button_x, button_y, buttonWidth, buttonHeight);
        this.button.setForeground(Color.WHITE);
        this.button.setBackground(new Color(249, 165, 20));
        
        // Some settings to make button look awsome!
        this.button.setOpaque(true);
        this.button.setContentAreaFilled(true);
        this.button.setBorderPainted(false);
        this.button.setFocusPainted(false);;
        
        // Added text with in the button
        this.button.setText(buttonText);
        this.button.setFont(newFont(fontLocation, fontSize));
        this.button.setFocusable(false);
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.CENTER);
        this.button.addActionListener(this);
        
        // Creating the hover state of the button
        this.button.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent e) 
            {   
                button.setBounds(button_x - 25, button_y, buttonWidth + 50, buttonHeight);
                
            }
            public void mouseExited(MouseEvent e) 
            {   
                button.setBounds(button_x, button_y, buttonWidth, buttonHeight);
            }
        });
        return button;
    }

    // Action Perform when tap on Button
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Login")){
            // disposing JFrame of login and signup
            JFrame frame = Main.ls1.getFrame();
            frame.setVisible(false);
            //frame.dispose(); 
            
            System.out.println("Clicked login Button!");
            //textFields t1 = new textFields(1280, 759, 255, 248, 238, "Shopify", "Logos\\ShopifyPNG.png");
            Main.t1.setVisible(true);
            
        
        }
        else if(e.getSource() == this.button && this.button.getText().equalsIgnoreCase("Signup")){
            // disposing JFrame of login and signup
            JFrame frame = Main.ls1.getFrame();
            frame.dispose();
            
            System.out.println("Clicked Sign up Button!");
            //textFields t1 = new textFields(1280, 759, 255, 248, 238, "Shopify", "Logos\\ShopifyPNG.png");
            Main.su1.setVisible(true);
        
        }
           
    }
}
