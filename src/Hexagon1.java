import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;

public class Hexagon1 extends JFrame {
    private JPanel panel;

    public Hexagon1() {
        JFrame frame = new JFrame("Hexagon");
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

                int centerX = getWidth() / 2; // X-coordinate of the center of the hexagon
                int centerY = getHeight() / 2; // Y-coordinate of the center of the hexagon
                int radius = 100; // Radius of the circumscribed circle of the hexagon

                int sides = 6; // Number of sides (hexagon)

                int[] xPoints = new int[sides];
                int[] yPoints = new int[sides];

                for (int i = 0; i < sides; i++) {
                    double angle = 2 * Math.PI * i / sides;
                    xPoints[i] = (int) (centerX + radius * Math.cos(angle));
                    yPoints[i] = (int) (centerY + radius * Math.sin(angle));
                }

                g.fillPolygon(xPoints, yPoints, sides);
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
            Hexagon1 hexagon = new Hexagon1();
            hexagon.setVisible(true);
        });
    }
}