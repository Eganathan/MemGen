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
        JLabel westLbl = new JLabel("Editing PANEL"); //label to identify panel
        JLabel btndesLbl = new JLabel("Add an image");
        JLabel inputdesLbl = new JLabel("Text color");
        //FONT SWATCH
        JPanel colorSwatch = new JPanel();
        colorSwatch.setLayout(new GridLayout(1,3));
        fontRedBtn = new JButton();
        fontRedBtn.setBackground(Color.RED);
        fontBlueBtn = new JButton();
        fontBlueBtn.setBackground(Color.BLUE);
        fontGreenBtn = new JButton();
        fontGreenBtn.setBackground(Color.GREEN);
        colorSwatch.add(fontRedBtn);
        colorSwatch.add(fontBlueBtn);
        colorSwatch.add(fontGreenBtn);

        addImgBtn = new JButton("SELECT IMAGE"); //Button to upload user image
        addImgBtn.addActionListener(this);// adds the object name to the action listener so a file choose pops up
        JButton saveImgBtn = new JButton("SAVE IMAGE"); //Button to upload user image
        userInput = new JTextField(1); //setting max column
        userInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //westPanel.add(westLbl);// adding the identification label
        westPanel.add(btndesLbl);
        westPanel.add(addImgBtn); // adding the button to
        westPanel.add(inputdesLbl);
        westPanel.add(colorSwatch);
        westPanel.add(userInput);
        westPanel.add(saveImgBtn);
        //END OF EDIT PANEL

        //CENTER PANEL
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        centerPanel.setBackground(Color.BLACK);
        userInputLbl = new JLabel("Aren't you typing anything ?");
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
            userInputLbl.repaint();
            userInputLbl.setBackground(Color.RED);
            centerPanel.updateUI();
            System.out.println("wrong!!");
        }
        else{
            System.out.println("NIl wrong!!");
        }
    }
}
