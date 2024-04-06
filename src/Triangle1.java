import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;

public class Triangle1 extends JFrame {
    private JPanel panel;

    public Triangle1 () {

        JFrame frame = new JFrame("Triangle");
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

                int x1 = 50; // X-coordinate of the first point
                int y1 = 300; // Y-coordinate of the first point

                int x2 = 200; // X-coordinate of the second point
                int y2 = 100; // Y-coordinate of the second point

                int x3 = 350; // X-coordinate of the third point
                int y3 = 300; // Y-coordinate of the third point

                int[] xPoints = {x1, x2, x3};
                int[] yPoints = {y1, y2, y3};

                g.fillPolygon(xPoints, yPoints, 3);
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
            Square1 square = new Square1();
            square.setVisible(true);
        });
    }
}