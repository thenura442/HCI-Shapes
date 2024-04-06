import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;

public class About extends JFrame {
    private JPanel panel;

    public About () {
        setTitle("About");
        JFrame frame = new JFrame("About");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton HomeBtn = new JButton("Home");
        HomeBtn.setSize(100, 50);
        HomeBtn.setLocation(750, 480);
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Home();

            }
        });
        frame.getContentPane().add(HomeBtn);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - getWidth()) / 2;
        int centerY = (screenSize.height - getHeight()) / 2;
        setLocation(centerX, centerY);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                Label heading = new Label("About");
                heading.setFont(new Font("Arial",Font.BOLD,30));
                add(heading);


            }

        };



        frame.setSize(900, 600);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.getContentPane().add(HomeBtn);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Circle1 circle = new Circle1();
            circle.setVisible(true);
        });
    }
}
