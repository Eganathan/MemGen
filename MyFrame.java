import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MyFrame extends JFrame implements ActionListener {

    private final JButton addImgBtn;
    private final JPanel centerPanel;
    private JLabel memIme;
    private ImageIcon memIco;



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

        //WEST- Option side bar
        JPanel westPanel = new JPanel(); //The West EDit panel
        westPanel.setLayout(new GridLayout(8,1,2,2));
        JLabel westLbl = new JLabel("Editing PANEL"); //label to identify panel
        JLabel btndesLbl = new JLabel("Add an image");
        JLabel inputdesLbl = new JLabel("Text color");

        JPanel colorSwatch = new JPanel();
        colorSwatch.setLayout(new GridLayout(1,3));
        JButton redBtn = new JButton();
        redBtn.setBackground(Color.RED);
        JButton blueBtn = new JButton();
        blueBtn.setBackground(Color.BLUE);
        JButton greenBtn = new JButton();
        greenBtn.setBackground(Color.GREEN);
        colorSwatch.add(redBtn);
        colorSwatch.add(blueBtn);
        colorSwatch.add(greenBtn);

        addImgBtn = new JButton("SELECT IMAGE"); //Button to upload user image
        addImgBtn.addActionListener(this);// adds the object name to the action listener so a file choose pops up
        JButton saveImgBtn = new JButton("SAVE IMAGE"); //Button to upload user image
        JTextField topInput = new JTextField();
        //topInput.setMinimumSize();

        westPanel.add(westLbl);// adding the identification label
        westPanel.add(btndesLbl);
        westPanel.add(addImgBtn); // adding the button to
        westPanel.add(inputdesLbl);
        westPanel.add(colorSwatch);
        westPanel.add(topInput);
        westPanel.add(saveImgBtn);


        //CENTER Canvas Option
        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        JLabel eastLbl = new JLabel("CENTER PANEL");

        memIco = new ImageIcon(getClass().getResource("MEMGEN_icon.png"));
        memIme = new JLabel(memIco);
        memIme.setSize(centerPanel.getWidth(),centerPanel.getWidth()-100);

        centerPanel.add(eastLbl);
        centerPanel.add(memIme);




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
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(null);
            System.out.println("Working!!");

            String path=file.getSelectedFile().getAbsolutePath();
            String filename=file.getSelectedFile().getName();

        } else{
            System.out.println("NOT Working!!");
        }
    }

    public void paid(Graphics g){

    }
}
