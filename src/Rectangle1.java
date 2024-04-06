import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;

public class Rectangle1 extends JFrame {
    private JPanel panel;

    public Rectangle1() {
        JFrame frame = new JFrame("Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton HomeBtn = new JButton("All Shapes");
        HomeBtn.setSize(100, 50);
        HomeBtn.setLocation(750, 480);
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();

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

                int x = 50; // X-coordinate of the top-left corner of the rectangle
                int y = 50; // Y-coordinate of the top-left corner of the rectangle
                int width = 200; // Width of the rectangle
                int height = 100; // Height of the rectangle

                g.fillRect(x, y, width, height);


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
            Rectangle1 rectangle = new Rectangle1();
            rectangle.setVisible(true);
        });
    }
}