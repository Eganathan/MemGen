import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class MyFrame extends JFrame implements ActionListener {

    //Frames
    private  JFrame mainFrame, templateOne;

    private String title = "Ekha- MEMGEN V.0.00.01";

    public ImageIcon imLogo;
    public JLabel logoLbl ;

    private JButton templateOneBtn, templateTwoBtn, addImgBtn, sveBtn, resetBtn;

    private final JPanel centerPanel; //Center Panel

    private JLabel memIme; //JLabel Center Image
    private ImageIcon memIco;//Image icon //the Meme Image
    private String userFile; //custom File path details from the user to load the image
    private JLabel userInputLbl; //Meme Text label that shows user input into the JPanel
    private JTextField userInput;//User Input field declaration
    private int  counter = 1; //Counter for

    //Font Swatch BUTTONS
    private JButton fontRedBtn,fontBlueBtn,fontGreenBtn,fontCyanBtn  ; //Red Btn

    //BG Swatch BUTTONS
    private JButton bgRedBtn,bgCyanBtn, bgBlueBtn, bgGreenBtn ; //Red Btn

    private JSlider fontSize ,imgSize;
    private Font customFont = new Font("Serif", Font.PLAIN, 50);

    //Top Panel Button
    private JButton homeBtn, saveImgBtn;

    private int fontSizeVal = 40;
    public Color blk = Color.BLACK;

    private int orgImgWidth, orgImgHeight ;

    private JMenu menu , imgMenu;
    private JMenuItem newItem, currFolderItem, exitItem,saveItem, loadImgItem;

    /***
     *
     * BufferedImage image = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_RGB);
     * Graphics2D g2d = image.createGraphics();
     * component.print( g2d );
     * g2d.dispose();
     * ImageIO.write(image, ".jpg", new File(...));
     */

    public MyFrame(){

        JMenuBar mbar = new JMenuBar();

        menu = new JMenu("File ");
        newItem = new JMenuItem("new file");
        saveItem = new JMenuItem("Save");
        currFolderItem = new JMenuItem("Current Dir");
        exitItem = new JMenuItem("EXIT");

        saveItem.addActionListener(this);
        newItem.addActionListener(this);
        currFolderItem.addActionListener(this);
        exitItem.addActionListener(this);


        menu.add(newItem);
        menu.add(saveItem);
        menu.add(currFolderItem);
        menu.add(exitItem);

        imgMenu = new JMenu("Image");
        loadImgItem = new JMenuItem("Load image");
        loadImgItem.addActionListener(this);
        imgMenu.add(loadImgItem);

        mbar.add(menu);
        mbar.add(imgMenu);

        //MAIN FRAME
        mainFrame = new JFrame(title); //Title of the Main Frame
        mainFrame.setBackground(Color.BLACK);

        //Template pane in the Main Frame
        JPanel templatePane = new JPanel();
        templatePane.setLayout(new GridLayout(1,1));
        templatePane.setBackground(Color.CYAN);

        templateOneBtn = new JButton( "Create New");
        templateOneBtn.setFont(new Font("Ariel BOLD", Font.PLAIN, 65));
        templateOneBtn.setFocusPainted(false);
        templateOneBtn.setForeground(Color.CYAN);
        templateOneBtn.setBackground(Color.MAGENTA);
        templatePane.add(templateOneBtn);


        //tempOneImg = new ImageIcon(tempOneImgScaled);

        //templateOneBtn.setIcon(tempOneImg);
        ///ImageIcon x = new ImageIcon(tempOneImgScaled);
        ///templateOneBtn.setIcon(x);
        templateOneBtn.addActionListener(this);
        templateOneBtn.updateUI();
        //templatePane.add(templateOneBtn);

        //templateTwoBtn = new JButton("Template Two");
        //templateTwoBtn.addActionListener(this);
        //templatePane.add(templateTwoBtn);

        //Logo Pane in Main Frame
        JPanel logoPane = new JPanel();
        logoPane.setBackground(Color.BLACK);


        ImageIcon imLogo = new ImageIcon(getClass().getResource("MEMGENFlash.png")); //icon with the image
        JLabel logoLbl = new JLabel(imLogo); //Label for the icon
        logoLbl.setVerticalAlignment(SwingConstants.CENTER);
        logoPane.add(logoLbl);

        //Info Pane in Main Frame
        JPanel infoPane = new JPanel();
        infoPane.setBorder(new EmptyBorder(30,30,30,30));
        infoPane.setLayout(new GridLayout(12,1));
        infoPane.setBackground(Color.CYAN);

        JLabel info1, info2, info3, info4, info5, info6, info7,info8,info9,info10,info11;

        JLabel infoTitle = new JLabel("Features available\n");
        infoTitle.setVerticalAlignment(SwingConstants.CENTER);
        infoTitle.setHorizontalAlignment(SwingConstants.CENTER);

        info1 = new JLabel(" ");
        info2 = new JLabel("1. Option to Load your custom image");
        info3 = new JLabel("2. Set your preferred text option");
        info4 = new JLabel("3. Enabled to change colors");
        info5 = new JLabel("4. Different font size available");
        info6 = new JLabel("5. Meme Background color options ");
        info7 = new JLabel("6. Save your fav Meme to your device");
        info8 = new JLabel("7. Does not overwrite file if the same file name \n is found on the dir");
        info9 = new JLabel("8. Image Aspect Ratio while resizing");


        infoPane.add(infoTitle);
        infoPane.add(info1);
        infoPane.add(info2);
        infoPane.add(info3);
        infoPane.add(info4);
        infoPane.add(info5);
        infoPane.add(info6);
        infoPane.add(info7);
        infoPane.add(info8);
        infoPane.add(info9);


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
        //END OF MAIN FRAME


        //START OF TEMPLATE ONE
        templateOne = new JFrame(title + String.valueOf(userFile));
        ImageIcon icon = new ImageIcon(getClass().getResource("MGicon.png"));
        templateOne.setIconImage(icon.getImage());

        //START of TOP PANEL or NORTH PANE in Template One
        JPanel topPanel = new JPanel();//top panel or LoGO panel
        topPanel.setLayout(new BorderLayout());

        imLogo = new ImageIcon(getClass().getResource("MEMGEN_icon.png"));
        logoLbl = new JLabel(imLogo);

        //Buttons
        ImageIcon homeIco = new ImageIcon(getClass().getResource("homeImg.png"));
        homeBtn = new JButton(homeIco);
        homeBtn.setToolTipText("Go Home");
        homeBtn.setBackground(blk);
        homeBtn.setBorderPainted(false);
        homeBtn.setSize(20,topPanel.getHeight());
        homeBtn.addActionListener(this);


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
        //END OF TOP PANEL

        //START OF BTM Pane or NORTH PANE
        JPanel btmPanel = new JPanel();//footer panel on the bottom of the Main frame
        btmPanel.setBackground(blk);
        JLabel footerLbl = new JLabel("***"); //Identification of the Frame
        btmPanel.add(footerLbl); //adding the lbl to the pane
        templateOne.add(btmPanel);//adding the pane to the main frame
        //END OF BTM PANEL

        //START OF WEST- EDIT SIDE BAR
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

        //Image Scaler
        JLabel imgSizeLbl = new JLabel("Set image size");
        imgSizeLbl.setForeground(Color.MAGENTA);

        imgSize = new JSlider(1,10);
        imgSize.setMinorTickSpacing(1);
        imgSize.setMajorTickSpacing(1);
        imgSize.setPaintLabels(true);
        imgSize.setBackground(Color.BLACK);
        imgSize.setForeground(Color.CYAN);
        imgSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                memIme.setVerticalAlignment(SwingConstants.CENTER);
                memIme.setHorizontalAlignment(SwingConstants.CENTER);

                imgScale(imgSize.getValue());
            }
        });

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

        resetBtn = new JButton("Reset");
        resetBtn.addActionListener(this);

        userInput = new JTextField("Sample Text");
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

        westPanel.add(imgSizeLbl);
        westPanel.add(imgSize);

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
        memIme.setHorizontalAlignment(SwingConstants.CENTER);
        memIme.setVerticalAlignment(SwingConstants.CENTER);
        memIme.setSize(centerPanel.getWidth(),centerPanel.getHeight());
        memIme.setMaximumSize(new Dimension(centerPanel.getWidth(), centerPanel.getHeight()));

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(userInputLbl,BorderLayout.SOUTH);
        centerPanel.add(memIme,BorderLayout.CENTER);
        //END OF CENTER PANEL

        //TEMP One FRAME SPECIFICATIONS
        //templateOne.setLayout(new BorderLayout(10,10)); //Frame
        templateOne.setBounds(20,20,1300,700);
        templateOne.setResizable(true);

        //ADDING PANELS to TEMPLATE ONE
        templateOne.setJMenuBar(mbar);
        templateOne.add(topPanel, BorderLayout.NORTH);//TOP PANEL BORDER LAYOUT NORTH
        templateOne.add(btmPanel, BorderLayout.SOUTH);//BOTTOM PANEL BORDER LAYOUT SOUTH
        templateOne.add(westPanel, BorderLayout.WEST);//WEST PANEL BORDER LAYOUT WEST
        templateOne.add(centerPanel, BorderLayout.CENTER);//CENTER PANEL BORDER LAYOUT CENTER
        templateOne.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    //METHODS AND OTHERS

    public void imgScale(int v){
        ImageIcon tempOneImg = new ImageIcon(userFile);
        int sW = tempOneImg.getIconWidth();
        int sH = tempOneImg.getIconHeight();


        int val = tempOneImg.getIconWidth();

        if(v == 1){
            sW = orgImgWidth/10;
            sH = orgImgHeight/10;
        } else if(v == 2){
            sW = orgImgWidth/9;
            sH = orgImgHeight/9;
        }else if(v == 3){
            sW = orgImgWidth/8;
            sH = orgImgHeight/8;
        }else if(v == 4){
            sW = orgImgWidth/7;
            sH = orgImgHeight/7;
        }else if(v == 5){
            sW = orgImgWidth/6;
            sH = orgImgHeight/6;
        }else if(v == 6){
            sW = orgImgWidth/5;
            sH = orgImgHeight/5;
        }else if(v == 7){
            sW = orgImgWidth/4;
            sH = orgImgHeight/4;
        }else if(v == 8){
            sW = orgImgWidth/3;
            sH = orgImgHeight/3;
        }else if(v == 9){
            sW = orgImgWidth/2;
            sH = orgImgHeight/2;
        }else if(v == 10){
            Image tempOneImgScaled = (tempOneImg).getImage().getScaledInstance(orgImgWidth,orgImgHeight,Image.SCALE_SMOOTH);
        }else{
            System.out.println("incorrect Image size");
        }


        Image tempOneImgScaled = (tempOneImg).getImage().getScaledInstance(sW,sH,Image.SCALE_SMOOTH);
        ImageIcon  x = new ImageIcon(tempOneImgScaled);
        memIme.setIcon(x);
        centerPanel.updateUI();
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
                userInputLbl.setForeground(Color.CYAN);
                userInputLbl.setBackground(blk);
                centerPanel.setBackground(blk);
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
        memIme.setIcon(null);
        userInputLbl.setText("Sample Text");
        memIme.setText("Load Image :( ");
        updateBgColor('Z');
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addImgBtn || e.getSource() == loadImgItem){
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
                    orgImgWidth = memIco.getIconWidth();
                    orgImgHeight = memIco.getIconHeight();

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

        }else if(e.getSource() == saveImgBtn || e.getSource() == sveBtn || e.getSource() == saveItem){

            saveImg();

        }else if(e.getSource() == templateTwoBtn){
            mainFrame.setVisible(false);
            TemplateTwo twoFrame = new TemplateTwo();
            twoFrame.setVisible(true);
        } else if(e.getSource() == resetBtn || e.getSource() == newItem){
            resetInputs();
        }else if(e.getSource() == homeBtn){

            templateOne.setVisible(false);
            mainFrame.setVisible(true);
        }else if(e.getSource() == currFolderItem){

            try {
                URL location = MemGen.class.getProtectionDomain().getCodeSource().getLocation();
                Process p = new ProcessBuilder("explorer.exe", "/select,"+userFile+"\\directory\\selectedFile").start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }else if(e.getSource() == exitItem){
            mainFrame.dispose();
            templateOne.setVisible(false);
            templateOne.dispose();
        }
}}
