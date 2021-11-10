import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame implements ActionListener {

    private final JButton addImgBtn; //Image ADD Button
    private final JPanel centerPanel; //Center Panel
    private JLabel memIme; //JLabel Center Image
    private ImageIcon memIco;//Image icon
    private String userFile; //File details
    private JLabel userInputLbl; //Meme Text label
    private JTextField userInput;//User Input field

    //Swatch BUTTONS
    private JButton fontRedBtn;
    private  JButton fontBlueBtn;
    private  JButton fontGreenBtn;
    private  JButton fontCyanBtn;
    private JButton saveImgBtn;



    public MyFrame(){
        //MAIN FRAME
        JFrame mainFrame = new JFrame("MEME-Gen V0.01");


        //Top Pane or NORTH PANE
        JPanel topPanel = new JPanel();
        ImageIcon imLogo = new ImageIcon(getClass().getResource("MEMGEN_icon.png")); //icon with the image
        JLabel logoLbl = new JLabel(imLogo); //Label for the icon
        topPanel.add(logoLbl);//adding the label to the Top panel
        topPanel.setBackground(Color.BLACK);//BG of Top Panel
        mainFrame.add(topPanel);// Adding top panel to Main Frame

        //BTM Pane or NORTH PANE
        JPanel btmPanel = new JPanel();
        JLabel footerLbl = new JLabel("FOOTER LABEL");
        btmPanel.add(footerLbl);
        mainFrame.add(btmPanel);

        //WEST- EDIT SIDE BAR
        JPanel westPanel = new JPanel(); //The West EDit panel
        westPanel.setBackground(Color.BLACK);
        westPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Empty margin for margin
        westPanel.setLayout(new GridLayout(10,1,2,2)); //layount rows and columns
        JLabel westLbl = new JLabel("Editing panel"); //label to identify panel
        westLbl.setFont(new Font("Serif", Font.BOLD, 20));
        westLbl.setForeground(Color.WHITE);
        JLabel btndesLbl = new JLabel("Add your image");
        btndesLbl.setForeground(Color.MAGENTA);
        JLabel fontColordesLbl = new JLabel("Font color");
        fontColordesLbl.setForeground(Color.MAGENTA);
        JLabel inputdesLbl = new JLabel("Custom Text");
        inputdesLbl.setForeground(Color.MAGENTA);
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

        //Adding Labels and other components to Editing Panel
        westPanel.add(westLbl);
        westPanel.add(btndesLbl);
        westPanel.add(addImgBtn); // adding the button to
        westPanel.add(fontColordesLbl);
        westPanel.add(colorSwatch);
        westPanel.add(inputdesLbl);
        westPanel.add(userInput);
        westPanel.add(saveImgBtn);
        //END OF EDIT PANEL

        //CENTER PANEL
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBackground(Color.BLACK);
        userInputLbl = new JLabel("Aren't you typing anything ?");
        userInputLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        userInputLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        userInputLbl.setFont(new Font("Serif", Font.PLAIN, 40));
        userInputLbl.setForeground(Color.CYAN);



        memIme = new JLabel(memIco);
        memIme.setSize(centerPanel.getWidth(),centerPanel.getWidth()-100);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(userInputLbl,BorderLayout.SOUTH);
        centerPanel.add(memIme,BorderLayout.NORTH);




        //MAIN FRAME SPECIFICATIONS
        mainFrame.setLayout(new BorderLayout(20,15)); //Frame
        mainFrame.setBounds(100,100,700,500);
        mainFrame.setResizable(true);

        //ADDING PANELS
        mainFrame.add(topPanel, BorderLayout.NORTH);//TOP PANEL BORDER LAYOUT NORTH
        mainFrame.add(btmPanel, BorderLayout.SOUTH);//BOTEM PANEL BORDER LAYOUT NORTH
        mainFrame.add(westPanel, BorderLayout.WEST);//WEST PANEL BORDER LAYOUT NORTH
        mainFrame.add(centerPanel, BorderLayout.CENTER);//CENTER PANEL BORDER LAYOUT NORTH


        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
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

                memIco = new ImageIcon(new ImageIcon(userFile).getImage().getScaledInstance(centerPanel.getWidth(), centerPanel.getHeight()-50, Image.SCALE_DEFAULT));//new ImageIcon();
                memIme.setIcon(memIco);
                centerPanel.updateUI();
            }else{
                JOptionPane.showMessageDialog(null, "Feel Free to Look Later");
            }


            centerPanel.add(memIme,BorderLayout.NORTH);
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

        }else if(e.getSource() == fontBlueBtn){
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

        }else if(e.getSource() == saveImgBtn){
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();

        }
        else{
            System.out.println("NIl wrong!!");
            userInputLbl.setText(userInput.getText());
            centerPanel.updateUI();
        }
    }
}
