import models.ShapeModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ButtonUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Home extends JFrame {
    public  Home(){
        setLayout(new BorderLayout());
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(new HeaderPanel(),BorderLayout.NORTH);
        add(new FooterPanel(this) , BorderLayout.SOUTH);
        add(new ContentPanel() , BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Home().setVisible(true);
    }
}

class HeaderPanel extends  JPanel{
    public HeaderPanel(){
        setBorder(new EmptyBorder(20, 20, 20, 10));
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        Label heading = new Label("Lovely Shapes");
        Label subHeading = new Label("Learn shapes with fun");
        heading.setFont(new Font("Arial",Font.BOLD,30));
        add(heading);
        subHeading.setFont(new Font("Arial",Font.PLAIN,20));
        add(subHeading);
    }
}

class FooterPanel extends JPanel {
    public FooterPanel(Home home) {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        Label heading = new Label("Select an option");
        JButton shapesBtn = new JButton("Shapes");
        JButton artBoardBtn = new JButton("Art Board");
        JButton aboutBtn = new JButton("About");
        JButton guideBtn = new JButton("Guide");
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        artBoardBtn.setForeground(Color.black);
        shapesBtn.setBackground(Color.blue);
        aboutBtn.setBackground(Color.blue);
        artBoardBtn.setBackground(Color.orange);
        guideBtn.setForeground(Color.black);
        guideBtn.setBackground(Color.blue);
        shapesBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.setVisible(false);
                new ShapeDisplay();
            }
        });
        artBoardBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.setVisible(false);
                new ArtBoard(new ShapeModel("Square", new Square()), 00);
            }
        });
       aboutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.setVisible(false);
                new About();
            }
        });
        guideBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                home.setVisible(false);
                new About();
            }
        });
        shapesBtn.setForeground(Color.white);
        shapesBtn.setFocusPainted(false);
        shapesBtn.setBorder(new EmptyBorder(15, 10, 15, 10));
        shapesBtn.setFont(new Font("Arial", Font.BOLD, 16));

        artBoardBtn.setForeground(Color.white);
        artBoardBtn.setFocusPainted(false);
        artBoardBtn.setBorder(new EmptyBorder(15, 10, 15, 10));
        artBoardBtn.setFont(new Font("Arial", Font.BOLD, 16));

        aboutBtn.setForeground(Color.white);
        aboutBtn.setFocusPainted(false);
        aboutBtn.setBorder(new EmptyBorder(15, 10, 15, 10));
        aboutBtn.setFont(new Font("Arial", Font.BOLD, 16));

        guideBtn.setForeground(Color.white);
        guideBtn.setFocusPainted(false);
        guideBtn.setBorder(new EmptyBorder(15, 10, 15, 10));
        guideBtn.setFont(new Font("Arial", Font.BOLD, 16));

        add(heading);
        add(shapesBtn);
        add(artBoardBtn);
        add(aboutBtn);
        add(guideBtn);

    }
}


class ContentPanel extends  JPanel{
    Image backgroundImage;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(backgroundImage != null){
            g.drawImage(backgroundImage,0,0,this);
        }
    }

    public ContentPanel() {
        setBorder(new EmptyBorder(20, 20, 20, 20));
        loadImage();
    }

    public void loadImage(){
        String projectDirectory = System.getProperty("user.dir");
        File file = new File(projectDirectory+"\\src\\Images\\cover.jpg");
        try {
            backgroundImage = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

