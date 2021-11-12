import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class MyFrame extends JFrame implements ActionListener {

    //Frames
    private  JFrame mainFrame;
    private JFrame templateOne;

    private String title = "Ekha- MEMGEN V.0.00.01";

    public ImageIcon imLogo;
    public JLabel logoLbl ;

    private JButton templateOneBtn;

    private final JButton addImgBtn; //Image ADD Button
    private final JPanel centerPanel; //Center Panel
    private JLabel memIme; //JLabel Center Image
    private ImageIcon memIco;//Image icon //the Meme Image
    private String userFile; //custom File path details from the user to load the image
    private JLabel userInputLbl; //Meme Text label that shows user input into the JPanel
    private JTextField userInput;//User Input field declaration
    private int  counter = 1; //Counter for

    //Font Swatch BUTTONS
    private JButton fontRedBtn; //Red Btn
    private  JButton fontBlueBtn; //Blue Btn
    private  JButton fontGreenBtn;//Green Btn
    private  JButton fontCyanBtn;//Cyan Btn

    //BG Swatch BUTTONS
    private JButton bgRedBtn; //Red Btn
    private  JButton bgBlueBtn; //Blue Btn
    private  JButton bgGreenBtn;//Green Btn
    private  JButton bgCyanBtn;//Cyan Btn

    //Save Button
    private JButton saveImgBtn;//Saves the Image and other function on btn click event

    public Color blk = Color.BLACK;



    /***
     *
     * BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
     * Graphics2D g2d = image.createGraphics();
     * component.print( g2d );
     * g2d.dispose();
     * ImageIO.write(image, ".jpg", new File(...));
     */



    public MyFrame(){
        //MAIN FRAME
        mainFrame = new JFrame(title); //Title of the Main Frame
        mainFrame.setBackground(Color.BLACK);

        //Template pane in the Main Frame
        JPanel templatePane = new JPanel();
        templatePane.setLayout(new GridLayout(5,1));
        templatePane.setBackground(Color.CYAN);
        templateOneBtn = new JButton("Template One");
        templateOneBtn.addActionListener(this);
        templatePane.add(templateOneBtn);

        //Logo Pane in Main Frame
        JPanel logoPane = new JPanel();
        logoPane.setBackground(Color.BLACK);
        ImageIcon imLogo = new ImageIcon(getClass().getResource("MEMGEN_icon.png")); //icon with the image
        JLabel logoLbl = new JLabel(imLogo); //Label for the icon
        logoPane.add(logoLbl);

        //Info Pane in Main Frame
        JPanel infoPane = new JPanel();
        infoPane.setBackground(Color.BLACK);
        JLabel infoTitle = new JLabel("Information");
        infoPane.add(infoTitle);


        //Adding panels to the main Frame
        mainFrame.add(logoPane);
        mainFrame.add(templatePane);
        mainFrame.add(infoPane);

        //MAIN Frame Specification
        mainFrame.setLayout(new GridLayout(1,3)); //Frame
        mainFrame.setBounds(20,20,1300,700);
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);




        //TEMPLATE ONE
        templateOne = new JFrame(title + String.valueOf(userFile));

        //Top Pane or NORTH PANE
        JPanel topPanel = new JPanel();//top panel or LoGO panel
        imLogo = new ImageIcon(getClass().getResource("MEMGEN_icon.png"));
        logoLbl = new JLabel(imLogo);
        topPanel.add(logoLbl);//adding the label to the Top panel
        topPanel.setBackground(Color.BLACK);//BG of Top Panel
        templateOne.add(topPanel);// Adding top panel to Main Frame

        //BTM Pane or NORTH PANE
        JPanel btmPanel = new JPanel();//footer panel on the bottom of the Main frame
        JLabel footerLbl = new JLabel("FOOTER LABEL"); //Identification of the Frame
        btmPanel.add(footerLbl); //adding the lbl to the pane
        templateOne.add(btmPanel);//adding the pane to the main frame

        //WEST- EDIT SIDE BAR
        JPanel westPanel = new JPanel(); //The West EDit panel
        westPanel.setBackground(Color.BLACK);//setting the Background of the editing panel
        westPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Empty border for margin
        westPanel.setLayout(new GridLayout(12,1,2,2)); //grid layout for a better view

        //Editing Panel Identification Label
        JLabel westLbl = new JLabel("Editing panel"); //label to identify panel
        westLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        westLbl.setFont(new Font("Serif", Font.BOLD, 20));
        westLbl.setForeground(Color.WHITE);

        JLabel btndesLbl = new JLabel("Add your image");
        btndesLbl.setForeground(Color.MAGENTA);

        JLabel fontColordesLbl = new JLabel("Font color");
        fontColordesLbl.setForeground(Color.MAGENTA);

        JLabel inputdesLbl = new JLabel("Custom Text");
        inputdesLbl.setForeground(Color.MAGENTA);

        JLabel bgDesLbl = new JLabel("Background Color");
        bgDesLbl.setForeground(Color.MAGENTA);

        JLabel savedesLbl = new JLabel("Save Your Image ");
        savedesLbl.setForeground(Color.MAGENTA);

        //FONT SWATCH PANEL
            JPanel colorSwatch = new JPanel();
            colorSwatch.setLayout(new GridLayout(1,5));
                //RED FONT BTN
                fontRedBtn = new JButton();
                fontRedBtn.setBackground(Color.RED);
                fontRedBtn.addActionListener(this);
                //Blue Font Btn
                fontBlueBtn = new JButton();
                fontBlueBtn.setBackground(Color.BLUE);
                fontBlueBtn.addActionListener(this);
                //Green Font Btn
                fontGreenBtn = new JButton();
                fontGreenBtn.setBackground(Color.GREEN);
                fontGreenBtn.addActionListener(this);
                //CYAN Font Btn
                fontCyanBtn = new JButton();
                fontCyanBtn.setBackground(Color.CYAN);
                fontCyanBtn.addActionListener(this);
                //Adding Buttons to the FONT Swatch Panel
                colorSwatch.add(fontRedBtn);
                colorSwatch.add(fontBlueBtn);
                colorSwatch.add(fontGreenBtn);
                colorSwatch.add(fontCyanBtn);



        addImgBtn = new JButton("SELECT IMAGE"); //Button to upload user image
        addImgBtn.addActionListener(this);// adds the object name to the action listener so a file choose pops up

        saveImgBtn = new JButton("SAVE IMAGE"); //Button to upload user image
        saveImgBtn.addActionListener(this);

        userInput = new JTextField(1); //setting max column
        userInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Background SWATCH PANEL
        JPanel BColorSwatch = new JPanel();
        BColorSwatch.setLayout(new GridLayout(1,5));
        //RED FONT BTN
        bgRedBtn = new JButton();
        bgRedBtn.setBackground(Color.RED);
        bgRedBtn.addActionListener(this);
        //Blue Font Btn
        bgBlueBtn = new JButton();
        bgBlueBtn.setBackground(Color.BLUE);
        bgBlueBtn.addActionListener(this);
        //Green Font Btn
        bgGreenBtn = new JButton();
        bgGreenBtn.setBackground(Color.GREEN);
        bgGreenBtn.addActionListener(this);
        //CYAN Font Btn
        bgCyanBtn = new JButton();
        bgCyanBtn.setBackground(Color.CYAN);
        bgCyanBtn.addActionListener(this);
        //Adding Buttons to the BG Swatch Panel
        BColorSwatch.add(bgCyanBtn);
        BColorSwatch.add(bgGreenBtn);
        BColorSwatch.add(bgBlueBtn);
        BColorSwatch.add(bgRedBtn);


        //Adding Labels and other components to Editing Panel
        westPanel.add(westLbl);
        westPanel.add(btndesLbl);
        westPanel.add(addImgBtn); // adding the button to
        westPanel.add(fontColordesLbl);
        westPanel.add(colorSwatch);
        westPanel.add(inputdesLbl);
        westPanel.add(userInput);
        westPanel.add(bgDesLbl);
        westPanel.add(BColorSwatch);
        westPanel.add(savedesLbl);
        westPanel.add(saveImgBtn);
        //END OF EDIT PANEL

        //CENTER PANEL
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //centerPanel.setBackground(Color.BLACK);
        userInputLbl = new JLabel("Type Somthing Here..");
        userInputLbl.setOpaque(true);
        userInputLbl.setHorizontalAlignment(SwingConstants.CENTER);
        userInputLbl.setFont(new Font("Serif", Font.PLAIN, 40));
        userInputLbl.setBackground(Color.BLACK);
        userInputLbl.setForeground(Color.CYAN);



        memIme = new JLabel(memIco);
        memIme.setSize(centerPanel.getWidth(),centerPanel.getHeight());

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(userInputLbl,BorderLayout.SOUTH);
        centerPanel.add(memIme,BorderLayout.NORTH);




        //TEMP One FRAME SPECIFICATIONS
        //templateOne.setLayout(new BorderLayout(10,10)); //Frame
        templateOne.setBounds(20,20,1300,700);
        templateOne.setResizable(true);

        //ADDING PANELS to TEMPLAPTE ONE
        templateOne.add(topPanel, BorderLayout.NORTH);//TOP PANEL BORDER LAYOUT NORTH
        templateOne.add(btmPanel, BorderLayout.SOUTH);//BOTTOM PANEL BORDER LAYOUT SOUTH
        templateOne.add(westPanel, BorderLayout.WEST);//WEST PANEL BORDER LAYOUT WEST
        templateOne.add(centerPanel, BorderLayout.CENTER);//CENTER PANEL BORDER LAYOUT CENTER
        templateOne.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addImgBtn){
            userInputLbl.setText(userInput.getText());
            JFileChooser file = new JFileChooser("/Desktop");
            file.setFileFilter(new FileNameExtensionFilter("JPEG file", "jpg", "jpeg"));
            file.showOpenDialog(null);
            userFile =file.getSelectedFile().getPath();
            if(userFile != ""){

                //memIco = new ImageIcon(new ImageIcon(userFile).getImage().getScaledInstance(centerPanel.getWidth(), centerPanel.getHeight()-50, Image.SCALE_FAST));//new ImageIcon();
                try {
                    BufferedImage bimg = ImageIO.read(new File(userFile));
                    memIco = new ImageIcon(bimg);
                    System.out.println(bimg.getHeight());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                memIme.setIcon(memIco);
                centerPanel.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Feel Free to Look Later");
            }


            centerPanel.add(memIme,BorderLayout.NORTH);
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

        }else if(e.getSource() == templateOneBtn){

            mainFrame.setVisible(false);
            templateOne.setVisible(true);
        }
        else if(e.getSource() == fontBlueBtn){
            userInputLbl.setForeground(Color.BLUE);
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

        }else if(e.getSource() == fontRedBtn){
            userInputLbl.setForeground(Color.RED);
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

        }else if(e.getSource() == fontGreenBtn){
            userInputLbl.setForeground(Color.GREEN);
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

        }else if(e.getSource() == fontCyanBtn){
            userInputLbl.setForeground(Color.CYAN);
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

        }else if(e.getSource() == bgCyanBtn){

            userInputLbl.setBackground(Color.CYAN);
            userInputLbl.repaint();

        }else if(e.getSource() == bgBlueBtn){

            userInputLbl.setBackground(Color.BLUE);
            userInputLbl.repaint();

        }else if(e.getSource() == bgRedBtn){

            userInputLbl.setBackground(Color.RED);
            userInputLbl.repaint();

        }else if(e.getSource() == bgGreenBtn){

            userInputLbl.setBackground(Color.GREEN);
            userInputLbl.repaint();

        }else if(e.getSource() == saveImgBtn){

            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

            Dimension d = centerPanel.getSize();
            BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            centerPanel.print( g2d );
            g2d.dispose();
            String fileNameGen = "MyMem_00"+String.valueOf(counter)+".jpg";

            File f = new File(fileNameGen);
            try {
                ImageIO.write(image, "JPEG", f);
                counter++;
                JOptionPane.showMessageDialog(null, " Image saved succesfully! ");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(".");


        }
}
}
