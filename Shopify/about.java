
import java.awt.*;
import java.io.*;

import javax.swing.*;


public class about{
    
    private JFrame frame;
    private ImageIcon image;  
    private JLabel label, textLabel;
    private JPanel panel;
    private Font font;   

    // Arugumented COnstructor
    public about(int width, int height, int R, int G, int B, String title, String location, String name, String text){
        
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
        

        // Back Button
        newButton back = new newButton();
        this.frame.add(back.setButton(215, 25, 60, 60, "<", "Fonts\\Montserrat-Bold.ttf", 16f, 249, 165, 20, 255, 248, 238));
        
        // Shopify
        frame.add(generateLabel(386, 134, 395, 121, 249, 165, 20, "Shopify", "Fonts\\Montserrat-Bold.ttf", 99f));
        // was designed by
        frame.add(generateLabel(386, 249, 300, 39, 249, 165, 20, "was designed by", "Fonts\\Montserrat-Regular.ttf", 32f));
        // Abdullah Mehdi
        frame.add(generateLabel(386, 323, 482, 71, 70, 66, 60, "Abdullah Mehdi", "Fonts\\Montserrat-Bold.ttf", 58f));
        // Artist
        frame.add(generateLabel(386, 394, 263, 28, 70, 66, 60, "Artist & UI/UX designer", "Fonts\\Montserrat-Regular.ttf", 23f));
        // Hafif Ashiq
        frame.add(generateLabel(386, 442, 334, 71, 70, 66, 60, "Hafif Ashiq", "Fonts\\Montserrat-Bold.ttf", 58f));
        // Artist
        frame.add(generateLabel(388, 513, 350, 28, 70, 66, 60, "Creative & Computerophile", "Fonts\\Montserrat-Regular.ttf", 23f));
        
        // AM panel 
        panels(frame, 1005, 141, 203, 203, 255, 248, 238, "AM", "Fonts\\Montserrat-Bold.ttf", 77f);
        // HA
        panels(frame, 1005, 375, 203, 203, 255, 248, 238, "HA", "Fonts\\Montserrat-Bold.ttf", 77f);
        // Side Panel
        panels(frame, 0, 0, 300, 759, 255, 248, 238, "About", "Fonts\\Montserrat-Bold.ttf", 22f);


    }

    // Must call Method to display
    public void setVisible(boolean set){
        this.frame.setVisible(set);
    }

    // Getters
    public JFrame getFrame(){
        return this.frame;
    }

    // Interface Method
    public void panels(JFrame frame, int x_axis, int y_axis, int width, int height, int R, int G, int B, String text,
        String fontLocation, float fontSize) {
        
        // Creating new Label
        this.label = new JLabel();
        this.label.setText(text);
        this.label.setFont(newFont(fontLocation, fontSize));
        this.label.setForeground(new Color(R, G, B));
        this.label.setHorizontalAlignment(JLabel.CENTER);        
        this.label.setVerticalAlignment(JLabel.CENTER);
        
        // Creating new panels
        panel = new JPanel();
        this.panel.setBounds(x_axis, y_axis, width, height);
        this.panel.setBackground(new Color(249, 165, 20));
        this.panel.setLayout(new BorderLayout(40,10));
        
        // Inserting label into panel
        this.panel.add(label);

        // inserting panel into JFrame
        this.frame.add(panel);
        
    }
    
    // Making a New Font
    protected Font newFont(String fontLocation, Float fontSize) {
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

    // returns
    public JLabel generateLabel(int x, int y, int width, int height, int Fr_R, int Fr_G, int Fr_B, String text, String fontLocation, float fontSize){
        
        textLabel = new JLabel();
        textLabel.setBounds(x, y, width, height);   
        textLabel.setText(text);
        textLabel.setForeground(new Color(Fr_R, Fr_G, Fr_B));
        textLabel.setFont(newFont(fontLocation, fontSize));

        return textLabel;
    } 
}
