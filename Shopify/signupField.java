import java.awt.*;
// import java.awt.*;
// import java.awt.event.*;  
// import java.awt.event.ActionEvent;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class signupField extends textFields {
    
    private JFrame frame;
    private ImageIcon image;
    protected Text_Fields t1, t2, t3, t4;
    protected sideBar s1;
    protected JButton b3, b4;


    protected JLabel errorUserName,errorEmail,errorPassword;

    // Default Constructor
    public signupField(){

    }

    // Argumented Constructor
    public signupField(int width, int height, int R, int G, int B, String title, String location){
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
        button backButton = new button();
        frame.add(backButton.setButton(215, 25, 60, 60, "<", "Fonts\\Montserrat-Bold.ttf", 18f, 249, 165, 20, 255, 248, 238));
        
        button hopInButton = new button();
        frame.add(hopInButton.setButton(715, 560, 150, 60, "Hop In", "Fonts\\Montserrat-Bold.ttf", 18f, 255, 248, 238, 249, 165, 20));

        // -------------- Text Fields -------------- //
        // username
        t1 = new Text_Fields();
        frame.add(t1.TF(382, 251, 60, 380, "abc"));
        // Email 
        t2 = new Text_Fields();
        frame.add(t2.TF(817, 251, 60, 380, "abc@gmail.com"));
        // Password
        t3 = new Text_Fields();
        frame.add(t3.PF(382, 434, 60, 380, "•••••"));
        // Confirm Password
        t4 = new Text_Fields();
        frame.add(t4.PF(817, 434, 60, 380, "•••••"));
        
        errorUserName = new JLabel();
        errorUserName.setBounds(382,300,380,60);
        frame.add(errorUserName);

        errorEmail = new JLabel();
        errorEmail.setBounds(817,300,380,60);
        frame.add(errorEmail);

        errorPassword = new JLabel();
        errorPassword.setBounds(600,484,380,60);
        frame.add(errorPassword);
        

        // -------------- Text Fields Panels -------------- //
        // Two Panels indicating "Username" & "Password"
        t1.panels(this.frame, 382, 169, 150, 60, 249, 165, 20, "Username", "Fonts\\Montserrat-Bold.ttf", 16f);
        t1.panels(this.frame, 817, 169, 150, 60, 249, 165, 20, "Email", "Fonts\\Montserrat-Bold.ttf", 16f);
        t1.panels(this.frame, 382, 352, 150, 60, 249, 165, 20, "Password", "Fonts\\Montserrat-Bold.ttf", 16f);
        t1.panels(this.frame, 817, 352, 210, 60, 249, 165, 20, "Confirm Password", "Fonts\\Montserrat-Bold.ttf", 16f);
        
        // -------------- Side Bar Orange -------------- //
        // Added the side Orange Panel with a Back button
        s1 = new sideBar();
        s1.panels(this.frame, 0, 0, 300, 759, 249, 165, 20, "Sign up", "Fonts\\Montserrat-Bold.ttf", 22f);
        
        
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


    // public void actionPerformed(ActionEvent e) {

        
    //     FileOperations<loginCredentials> files  = new FileOperations<loginCredentials>();

    //     if(e.getSource() == hopInButton && hopInButton.getText().equalsIgnoreCase("Hop in")){
    //         System.out.println("here");
    //         boolean check = true;
    //         if (files.searchUserName(userNameText.getText()) != null) {
    //             errorUserName.setText("UserName Already Exists");
    //             errorUserName.setForeground(Color.red);
    //             errorUserName.setFont(new Font("Montserrat-Bold",Font.PLAIN,15));
    //             check = false;
    //         }
    //     }
    // }


}
