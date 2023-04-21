
import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class Screen implements panelWithLabel {

    protected JFrame frame;
    protected JPanel panel;
    protected ImageIcon image;
    protected JLabel label;
    protected Font font;
    protected static newButton addButton = new newButton();

    // Default Constructor
    public Screen() {

        this.frame = new JFrame();

        // Essentials for menu display
        this.frame.setSize(1280, 720);
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
    public Screen(int width, int height, int R, int G, int B, String title, String location, String name, String text) {

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

        // side Panels
        panels(this.frame, 350, 50, 150, 60, 249, 165, 20, text, "Fonts\\Montserrat-Bold.ttf", 18f);
        panelInvert(this.frame, 10, 83, 280, 60, 255, 248, 238, name, "Fonts\\Montserrat-Bold.ttf", 18f);

        // Navigation Bar
        navBar n1 = new navBar();
        n1.panels(this.frame, 0, 0, 300, 720, 249, 165, 20);

    }

    public void dispose() {
        this.frame.dispose();
    }

    // Must call Method to display
    public void setVisible(boolean set) {
        this.frame.setVisible(set);
    }

    // Getters
    public JFrame getFrame() {
        return this.frame;
    }

    // Making a New Font
    protected Font newFont(String fontLocation, Float fontSize) {
        // Creating a new custom font
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontLocation)).deriveFont(fontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(font);
        } catch (IOException e) {

        } catch (FontFormatException e) {

        }
        return font;
    }

    // Invert panel for invert colors
    private void panelInvert(JFrame frame, int x_axis, int y_axis, int width, int height, int R, int G, int B,
            String text,
            String fontLocation, float fontSize) {

        // Creating new Label
        this.label = new JLabel();
        this.label.setText(text);
        this.label.setFont(newFont(fontLocation, fontSize));
        this.label.setForeground(new Color(249, 165, 20));
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setVerticalAlignment(JLabel.CENTER);

        // Creating new panels
        panel = new JPanel();
        this.panel.setBounds(x_axis, y_axis, width, height);
        this.panel.setBackground(new Color(R, G, B));
        this.panel.setLayout(new BorderLayout(40, 10));

        // Inserting label into panel
        this.panel.add(label);

        // inserting panel into JFrame
        this.frame.add(panel);
    }

    // Side Panel Indicating what page indicates
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
        this.panel.setLayout(new BorderLayout(40, 10));

        // Inserting label into panel
        this.panel.add(label);

        // inserting panel into JFrame
        this.frame.add(panel);

    }

    // seprated!
    public void addNewItem(int x, int y) {

        // If admin has login in then he has the abaility to add or remove items
        // the frame should refresh good after things have been done

        newButton newItem = new newButton();
        this.frame.add(newItem.setButton(x, y, 45, 45, "+", "Fonts\\Montserrat-Regular.ttf", 30f, 255, 248, 238, 249,
                165, 20));

    }

    // Creating Button
    public void categories_Buttons() {

        fileO<Categories1> filee = new fileO<>();
        ArrayList<Categories1> array = filee.getInArrayCategories();
        System.out.println("Size  ==>" + array.size());

        int x = 350;
        int yButton = 135;
        int yLabel = 335;
        int xCross = 520;
        int yCross = 135;
        int xNew = 429;
        int yNew = 212;
        // int count = 1;
        for (int i = 0; i < array.size(); i++) {

            /////// Cross Only for ADMIN
            if (textFields.currentUser.getEmail().equals("admin@gmail.com")) {

                newButton cross = new newButton();
                this.frame.add(cross.setButton(xCross, yCross, 30, 39, "X", "Fonts\\Montserrat-SemiBold.ttf", 15f, 255,
                        248, 238, 249, 165, 20));
            }
            categories c = new categories();
            c.newButton(this.frame, x, yButton, 200, 200, array.get(i).getImageAddress());
            c.callBottomPannels(this.frame, x, yLabel, 200, 40, 249, 165, 20, array.get(i).getName(),
                    "Fonts\\Montserrat-SemiBold.ttf", 14f);
            if ((i + 1) % 4 == 0) {
                yLabel += 257;
                yButton += 260;
                yCross += 260;
                yNew += 256;

                xNew = 429;
                xCross = 520;
                x = 350;

            } else {
                x += 220;
                xNew += 219;
                xCross += 220;
            }
        }
        if (textFields.currentUser.getEmail().equals("admin@gmail.com")) {

            newButton newItem = new newButton();
            this.frame.add(newItem.setButton(xNew, yNew, 45, 45, "+", "Fonts\\Montserrat-Regular.ttf", 30f, 255, 248,
                    238, 249, 165, 20));
            addButton = newItem;
        } // System.out.println("Button : x,y ::" + xNew + " , " + yNew);

    }

}

class categories implements ActionListener, font, panelWithLabel {

    protected JButton button;
    protected Font font;
    protected JPanel buttonPanel;
    protected JLabel buttonLabel;
    protected static Categories1 selectedCategory = new Categories1("", "");
    protected static String address1 = null;

    // Default constructor
    public categories() {
    }

    // Method to resize Image
    public static ImageIcon resizeImageIcon(ImageIcon ii, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }

    public void newButton(JFrame frame, int x, int y, int width, int height, String imageLocation) {

        // Creating a new button
        this.button = new JButton();
        this.button.setBounds(x, y, width, height);
        this.button.addActionListener(this);
        this.button.setBorder(BorderFactory.createLineBorder((new Color(255, 248, 238)), 0));
        this.button.setBackground(Color.white);
        this.button.setIcon(resizeImageIcon(new ImageIcon(imageLocation), width, height));

        // Creates hover state
        this.button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBounds(x - 5, y - 5, width + 10, height + 10);
                button.setIcon(resizeImageIcon(new ImageIcon(imageLocation), width + 10, height + 10));
                button.setBorder(BorderFactory.createLineBorder((new Color(249, 165, 20)), 3));

            }

            public void mouseExited(MouseEvent e) {
                button.setBounds(x, y, width, height);
                button.setIcon(resizeImageIcon(new ImageIcon(imageLocation), width, height));
                button.setBorder(BorderFactory.createLineBorder((new Color(255, 248, 238)), 0));
            }
        });

        // Imported frame as it'd add on top of the above screen
        frame.add(button);

    }

    // Creates New panels Ones with the label and orange color
    public void callBottomPannels(JFrame frame, int panel_x, int panel_y, int panel_width, int panel_height,
            int panel_R, int panel_G, int panel_B, String text, String font, float fontSize) {
        panels(frame, panel_x, panel_y, panel_width, panel_height, panel_R, panel_G, panel_B, text, font, fontSize);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button && button.getX() == 470 - 5 && button.getY() == 205 - 5) {
            JFrame frame = Main.py1.getFrame();
            frame.setVisible(false);

            Main.cs1.setVisible(true);
            System.out.println("Clicked! Cash on Delivery");

        } else if (e.getSource() == button && button.getX() == 810 - 5 && button.getY() == 205 - 5) {
            JFrame frame = Main.py1.getFrame();
            frame.setVisible(false);

            Main.cr1.setVisible(true);
            System.out.println("Clicked! Credit Card");

        } else {

            fileO<Categories1> f = new fileO<>();
            ArrayList<Categories1> cArray = f.getInArrayCategories();

            int x = 350;
            int yButton = 135;
            int xCross = 520;
            int yCross = 135;
            int xCrossC = 740;
            int yCrossC = 86;

            for (int i = 0; i < cArray.size(); i++) {

                if (e.getSource() == button && button.getX() == x - 5 && button.getY() == yButton - 5) {

                    // Disposing JFrame of Screen
                    JFrame frame = Main.s1.getFrame();
                    frame.dispose();
                    selectedCategory = cArray.get(i);
                    Main.f1 = new Fashion(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G,
                            Main.screen_B, Main.screen_Title, Main.screen_Image_Location,
                            "Welcome, " + textFields.currentUser.getUserName(), Fashion.selectedCategory.getName());

                    // Main.f1.addNewItem(988, 485);
                    Main.f1.addItems();
                    Main.f1.goBackbutton();
                    Main.f1.setVisible(true);
                    System.out.println("Clicked!");

                }

                if ((i + 1) % 4 == 0) {

                    yButton += 260;
                    x = 350;

                    xCross = 520;

                    yCrossC += 294;

                    xCrossC = 740;
                    yCross += 260;

                } else {
                    x += 220;

                    xCross += 220;

                    xCrossC += 440;
                }

            }

        }

    }

    // Making a New Font
    public Font newFont(String fontLocation, Float fontSize) {

        // Creating a new custom font
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(fontLocation)).deriveFont(fontSize);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(font);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        return font;
    }

    public void panels(JFrame frame, int x_axis, int y_axis, int width, int height, int R, int G, int B, String text,
            String fontLocation, float fontSize) {

        // Creating new Label
        this.buttonLabel = new JLabel();
        this.buttonLabel.setText(text);
        this.buttonLabel.setFont(newFont(fontLocation, fontSize));
        this.buttonLabel.setForeground(Color.WHITE);
        this.buttonLabel.setVerticalAlignment(JLabel.CENTER);
        this.buttonLabel.setHorizontalAlignment(JLabel.CENTER);

        // Creating new panels
        buttonPanel = new JPanel();
        this.buttonPanel.setBounds(x_axis, y_axis, width, height);
        this.buttonPanel.setBackground(new Color(R, G, B));
        this.buttonPanel.setLayout(new BorderLayout(20, 5));

        // Inserting label into panel
        this.buttonPanel.add(buttonLabel);

        // inserting panel into JFrame
        frame.add(buttonPanel);

    }

}

class navBar implements panel {

    private JPanel panel;
    private logo l1;
    private menuButtons m1, m2, m3, logout;

    // Navigation Bar Panel!
    public void panels(JFrame frame, int x_axis, int y_axis, int width, int height, int R, int G, int B) {

        // Creating Orange Navbar Panel
        panel = new JPanel();
        this.panel.setBounds(x_axis, y_axis, width, height);
        this.panel.setBackground(new Color(R, G, B));
        this.panel.setLayout(new BorderLayout(40, 10));

        // Shopify Logo Implementaion
        l1 = new logo();
        frame.add(l1.setLogo("Logos\\ShopifyWhitePNG.png", "Shopify", 40, 40, "Fonts\\Montserrat-Bold.ttf", 20f));

        // menu buttons
        m1 = new menuButtons();
        frame.add(m1.setButton(0, 150, 300, 165, "Home", "Fonts\\Montserrat-Bold.ttf", 18f));

        m2 = new menuButtons();
        frame.add(m2.setButton(0, 315, 300, 165, "Cart", "Fonts\\Montserrat-Bold.ttf", 18f));

        m3 = new menuButtons();
        frame.add(m3.setButton(0, 480, 300, 165, "About", "Fonts\\Montserrat-Bold.ttf", 18f));

        logout = new menuButtons();
        frame.add(logout.setButtonInvert(10, 645 + 8, 280, 60, "Logout", "Fonts\\Montserrat-Bold.ttf", 16f));

        // inserting panel into JFrame
        // Orange Title Nav bar
        frame.add(panel);

    }

}

class logo extends categories {

    protected ImageIcon logo;
    protected JLabel logoName;

    // Default Constructor
    public logo() {

        logo = new ImageIcon("Logos\\ShopifyPNG.png");
        logoName = new JLabel("Shopify");

    }

    public JLabel setLogo(String imageName, String logoText, int logoWidth, int logoHeight, String fontLocation,
            float fontSize) {

        this.logo = resizeImageIcon(new ImageIcon(imageName), logoWidth, logoHeight);
        this.logoName = new JLabel("Shopify");
        this.logoName.setFont(newFont(fontLocation, fontSize));
        this.logoName.setBounds(75, -10, 150, 100);
        this.logoName.setIconTextGap(10);
        this.logoName.setForeground(new Color(255, 248, 238));
        // Setting Logo inside JLabel of Logo
        logoName.setIcon(logo);

        return logoName;
    }

}

class menuButtons extends categories {

    protected JButton button;

    // Default constructior
    public menuButtons() {

        button = new JButton();
        button.setBounds(100, 100, 100, 50);

    }

    // creating a custom button
    public JButton setButton(int button_x, int button_y, int buttonWidth, int buttonHeight, String buttonText,
            String fontLocation, float fontSize) {

        this.button.setBounds(button_x, button_y, buttonWidth, buttonHeight);
        this.button.setForeground(Color.WHITE);
        this.button.setBackground(new Color(249, 165, 20));

        // Some settings to make button look awsome!
        this.button.setOpaque(true);
        this.button.setContentAreaFilled(true);
        this.button.setBorderPainted(false);
        this.button.setFocusPainted(false);
        

        // Added text with in the button
        this.button.setText(buttonText);
        this.button.setFont(newFont(fontLocation, fontSize));
        this.button.setFocusable(false);
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.CENTER);
        this.button.addActionListener(this);

        // Creating the hover state of the button
        this.button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setForeground(new Color(249, 165, 20));
                button.setBackground(new Color(255, 248, 238));

            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(249, 165, 20));
                button.setForeground(Color.WHITE);
            }
        });
        return button;
    }

    // creating a custom button
    public JButton setButtonInvert(int button_x, int button_y, int buttonWidth, int buttonHeight, String buttonText,
            String fontLocation, float fontSize) {

        this.button.setBounds(button_x, button_y, buttonWidth, buttonHeight);
        this.button.setForeground(new Color(249, 165, 20));
        this.button.setBackground(new Color(255, 248, 238));

        // Some settings to make button look awsome!
        this.button.setOpaque(true);
        this.button.setContentAreaFilled(true);
        this.button.setBorderPainted(false);

        // Added text with in the button
        this.button.setText(buttonText);
        this.button.setFont(newFont(fontLocation, fontSize));
        this.button.setFocusable(false);
        this.button.setHorizontalTextPosition(JButton.CENTER);
        this.button.setVerticalTextPosition(JButton.CENTER);
        this.button.addActionListener(this);

        // Creating the hover state of the button
        this.button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.BLACK);
                button.setBackground(new Color(255, 248, 238));

            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 248, 238));
                button.setForeground(new Color(249, 165, 20));
            }
        });
        return button;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.button && button.getX() == 0 && button.getY() == 150) {
            System.out.println("Clicked Home!");

        } else if (e.getSource() == this.button && button.getX() == 0 && button.getY() == 315) {
            ArrayList<CartProducts> c = textFields.currentUser.getCartItems();
            if (c.size() == 0) {
                JOptionPane.showMessageDialog(new JFrame(), "No Items In Cart");
            } else {
                JFrame frame = Main.s1.getFrame();
                frame.dispose();

                Main.c1 = new cart(Main.screen_Width, Main.screen_Height, Main.screen_R, Main.screen_G, Main.screen_B,
                        Main.screen_Title, Main.screen_Image_Location,
                        "Welcome, " + textFields.currentUser.getUserName(), "Cart");

                Main.c1.addItems();
                Main.c1.setVisible(true);

                System.out.println("Clicked Cart!");
            }

        } else if (e.getSource() == this.button && button.getX() == 0 && button.getY() == 480) {
            Main.s1.getFrame().setVisible(false);
            Main.ab1.getFrame().setVisible(true);

            System.out.println("Clicked About!");

        } else if (e.getSource() == this.button && button.getX() == 10 && button.getY() == 645 + 8) {
            JFrame frame = Main.s1.getFrame();
            frame.dispose();

            Main.ls1.setVisible();
            System.out.println("Clicked Logout!");

        }
    }
}
