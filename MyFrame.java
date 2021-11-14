import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class MyFrame extends JFrame implements ActionListener {

    //Frames
    private  JFrame mainFrame;
    private JFrame templateOne;

    private String title = "Ekha- MEMGEN V.0.00.01";

    public ImageIcon imLogo;
    public JLabel logoLbl ;

    private JButton templateOneBtn;
    private  JButton templateTwoBtn;

    private final JButton addImgBtn; //Image ADD Button
    private final JPanel centerPanel; //Center Panel
    private JLabel memIme; //JLabel Center Image
    private ImageIcon memIco;//Image icon //the Meme Image
    private String userFile; //custom File path details from the user to load the image
    private JLabel userInputLbl; //Meme Text label that shows user input into the JPanel
    private JTextField userInput;//User Input field declaration
    private int  counter = 1; //Counter for

    private JButton sveBtn;
    private JButton resetBtn;

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

    private JSlider fontSize;
    private Font customFont = new Font("Serif", Font.PLAIN, 50);

    //Save Button
    private JButton saveImgBtn;//Saves the Image and other function on btn click event

    private int fontSizeVal = 40;
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

        templateOneBtn = new JButton(" ");
        ImageIcon tempOneImg = new ImageIcon((getClass().getResource("temp01.jpg")));
        //Image tempOneImgScaled = (tempOneImg).getImage().getScaledInstance(templateOneBtn.getWidth(),templateOneBtn.getHeight(), Image.SCALE_FAST);
        //tempOneImg = new ImageIcon(tempOneImgScaled);

        templateOneBtn.setIcon(tempOneImg);
        templateOneBtn.addActionListener(this);
        templatePane.add(templateOneBtn);

        templateTwoBtn = new JButton("Template Two");
        templateTwoBtn.addActionListener(this);
        templatePane.add(templateTwoBtn);

        //Logo Pane in Main Frame
        JPanel logoPane = new JPanel();
        logoPane.setBackground(Color.BLACK);

        ImageIcon imLogo = new ImageIcon(getClass().getResource("MEMGEN_icon.png")); //icon with the image
        JLabel logoLbl = new JLabel(imLogo); //Label for the icon
        logoPane.add(logoLbl);

        //Info Pane in Main Frame
        JPanel infoPane = new JPanel();
        infoPane.setBackground(Color.WHITE);
        JLabel infoTitle = new JLabel("Information");
        JLabel info1 = new JLabel("Details of the application..");


        infoPane.add(infoTitle);
        infoPane.add(info1);

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
        topPanel.setLayout(new BorderLayout());

        imLogo = new ImageIcon(getClass().getResource("MEMGEN_icon.png"));
        logoLbl = new JLabel(imLogo);

        //Buttons
        ImageIcon homeIco = new ImageIcon(getClass().getResource("homeImg.png"));
        JButton homeBtn = new JButton(homeIco);
        homeBtn.setToolTipText("Go Home");
        homeBtn.setBackground(blk);
        homeBtn.setBorderPainted(false);
        homeBtn.setSize(20,topPanel.getHeight());


        ImageIcon saveIco = new ImageIcon(getClass().getResource("saveImg.png"));
        sveBtn = new JButton(saveIco);
        sveBtn.setToolTipText("Save your file");
        sveBtn.setBackground(blk);
        sveBtn.setBorderPainted(false);
        sveBtn.addActionListener(this);

        topPanel.add(homeBtn,BorderLayout.WEST);//adding the label to the Top panel
        topPanel.add(sveBtn,BorderLayout.EAST);//adding the label to the Top panel
        topPanel.add(logoLbl,BorderLayout.CENTER);//adding the label to the Top panel

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
        westPanel.setLayout(new GridLayout(16,1,2,2)); //grid layout for a better view

        //Editing Panel Identification Label
        JLabel westLbl = new JLabel("Editing panel"); //label to identify panel
        westLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        westLbl.setFont(new Font("Serif", Font.BOLD, 20));
        westLbl.setForeground(Color.WHITE);

        JLabel btndesLbl = new JLabel("Add your image");
        btndesLbl.setForeground(Color.MAGENTA);

        JLabel fontColordesLbl = new JLabel("Font color");
        fontColordesLbl.setForeground(Color.MAGENTA);

        JLabel fontSizeLbl = new JLabel("Font Size");
        fontSizeLbl.setForeground(Color.MAGENTA);

        fontSize = new JSlider(20,100);
        fontSize.setMinorTickSpacing(5);
        fontSize.setMajorTickSpacing(10);
        fontSize.setPaintLabels(true);
        fontSize.setBackground(Color.BLACK);
        fontSize.setForeground(Color.CYAN);
        fontSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

               customFont = new Font("Serif", Font.PLAIN, fontSize.getValue());
               upDateText();
            }
        });

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

        resetBtn = new JButton("Reeset");
        resetBtn.addActionListener(this);

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
        westPanel.add(fontSizeLbl);
        westPanel.add(fontSize);
        westPanel.add(inputdesLbl);
        westPanel.add(userInput);
        westPanel.add(bgDesLbl);
        westPanel.add(BColorSwatch);
        westPanel.add(savedesLbl);
        westPanel.add(saveImgBtn);
        westPanel.add(resetBtn);
        //END OF EDIT PANEL

        //CENTER PANEL
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //centerPanel.setBackground(Color.BLACK);
        userInputLbl = new JLabel("Type Something Here..");
        userInputLbl.setOpaque(true);
        userInputLbl.setHorizontalAlignment(SwingConstants.CENTER);
        userInputLbl.setFont(customFont);
        userInputLbl.setBackground(Color.BLACK);
        userInputLbl.setForeground(Color.CYAN);

        memIme = new JLabel(memIco);
        memIme.setSize(centerPanel.getWidth(),centerPanel.getHeight());
        memIme.setMaximumSize(new Dimension(centerPanel.getWidth(), centerPanel.getHeight()));

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(userInputLbl,BorderLayout.SOUTH);
        centerPanel.add(memIme,BorderLayout.NORTH);


        //TEMP One FRAME SPECIFICATIONS
        //templateOne.setLayout(new BorderLayout(10,10)); //Frame
        templateOne.setBounds(20,20,1300,700);
        templateOne.setResizable(true);

        //ADDING PANELS to TEMPLATE ONE
        templateOne.add(topPanel, BorderLayout.NORTH);//TOP PANEL BORDER LAYOUT NORTH
        templateOne.add(btmPanel, BorderLayout.SOUTH);//BOTTOM PANEL BORDER LAYOUT SOUTH
        templateOne.add(westPanel, BorderLayout.WEST);//WEST PANEL BORDER LAYOUT WEST
        templateOne.add(centerPanel, BorderLayout.CENTER);//CENTER PANEL BORDER LAYOUT CENTER
        templateOne.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    /***
     * Updates the user JLabel of user input
     */
    private void upDateText(){
        userInputLbl.setText(userInput.getText());
        userInputLbl.setFont(customFont);
        centerPanel.updateUI();
    }

    /***
     * updates the Background Color
     * @param clr Color of Background
     */
    private void updateBgColor(char clr){

        switch (clr){

            case 'G':
                userInputLbl.setBackground(Color.GREEN);
                centerPanel.setBackground(Color.GREEN);
                centerPanel.repaint();
                break;
            case 'B':
                userInputLbl.setBackground(Color.BLUE);
                centerPanel.setBackground(Color.BLUE);
                centerPanel.repaint();
                break;
            case 'R':
                userInputLbl.setBackground(Color.RED);
                centerPanel.setBackground(Color.RED);
                centerPanel.repaint();
                break;
            case 'C':
                userInputLbl.setBackground(Color.CYAN);
                centerPanel.setBackground(Color.CYAN);
                centerPanel.repaint();
                break;
            case 'Z':
                userInputLbl.setBackground(Color.WHITE);
                centerPanel.setBackground(Color.BLACK);
                centerPanel.repaint();
                break;

        }

    }

    /***
     * Saves the center panel into an image
     */
    private void saveImg(){

        Dimension d = centerPanel.getSize();
        BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        centerPanel.print( g2d );
        g2d.dispose();
        String fileNameGen = "MyMem_00"+String.valueOf(counter)+".jpg";
        File f = new File(fileNameGen);
        /***
         * Checks if the File Name exists
         * if yes then the counter gets increased and runs the method again
         * saves the image only when the file is not present with the same file to avoid overriding the image file
         */
        if(!f.exists()){

            try {
                ImageIO.write(image, "JPEG", f);
                counter++;
                JOptionPane.showMessageDialog(null, " Image saved successfully! ");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            resetInputs();
        }else{
            counter++;
            saveImg();
        }
    }

    /***
     * Load Image from computer and return file path
     */

    private String loadFile(){
        JFileChooser file = new JFileChooser("Desktop");
        file.setFileFilter(new FileNameExtensionFilter("PNG file", "png", "png"));
        file.setFileFilter(new FileNameExtensionFilter("JPEG file", "jpg", "jpeg"));
        file.setAcceptAllFileFilterUsed(false);
        file.showOpenDialog(null);
        userFile =file.getSelectedFile().getPath();
        return userFile;
    }

    /***
     * Reset Inputs and others on same frame
     */
    private void resetInputs(){
        userInputLbl.setText("Sample Text");
        memIme.setText("Load Image :( ");
        updateBgColor('Z');
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addImgBtn){
            /***
             * Load Image Action
             */
            loadFile();

            if(userFile != ""){
                BufferedImage bimg = null;

                //memIco = new ImageIcon(new ImageIcon(userFile).getImage().getScaledInstance(centerPanel.getWidth(), centerPanel.getHeight()-50, Image.SCALE_FAST));//new ImageIcon();
                try {
                    bimg = ImageIO.read(new File(userFile));
                    memIco = new ImageIcon(bimg);
                } catch (IOException ex) {
                    ex.printStackTrace();
                 }

                memIme.setIcon(memIco);
                centerPanel.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Feel Free to Look Later");
            }


            centerPanel.add(memIme,BorderLayout.NORTH);
            upDateText();

        }else if(e.getSource() == templateOneBtn){

            mainFrame.setVisible(false);
            templateOne.setVisible(true);
        }
        else if(e.getSource() == fontBlueBtn){
            userInputLbl.setForeground(Color.BLUE);
            upDateText();

        }else if(e.getSource() == fontRedBtn){
            userInputLbl.setForeground(Color.RED);
            upDateText();

        }else if(e.getSource() == fontGreenBtn){
            userInputLbl.setForeground(Color.GREEN);
            upDateText();

        }else if(e.getSource() == fontCyanBtn){
            userInputLbl.setForeground(Color.CYAN);
            upDateText();

        }else if(e.getSource() == bgCyanBtn){

            updateBgColor('C');

        }else if(e.getSource() == bgBlueBtn){

            updateBgColor('B');

        }else if(e.getSource() == bgRedBtn){

            updateBgColor('R');

        }else if(e.getSource() == bgGreenBtn){
            //Background Color to Green
            updateBgColor('G');

        }else if(e.getSource() == saveImgBtn || e.getSource() == sveBtn ){

            saveImg();

        }else if(e.getSource() == templateTwoBtn){
            mainFrame.setVisible(false);
            TemplateTwo twoFrame = new TemplateTwo();
            twoFrame.setVisible(true);
        } else if(e.getSource() == resetBtn){
            resetInputs();
        }
}}
