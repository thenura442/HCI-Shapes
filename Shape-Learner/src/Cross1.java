import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;

public class Cross1 extends JFrame {
    private JPanel panel;

    public Cross1 () {
        JFrame frame = new JFrame("Cross");
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
                Label heading = new Label("Cross");
                heading.setFont(new Font("Arial",Font.BOLD,30));
                add(heading);

                int centerX = getWidth() / 2; // X-coordinate of the center of the cross
                int centerY = getHeight() / 2; // Y-coordinate of the center of the cross
                int size = 100; // Size of the cross

                int x1 = centerX - size / 2; // X-coordinate of the left arm of the cross
                int y1 = centerY - size / 10; // Y-coordinate of the left arm of the cross

                int x2 = centerX + size / 2; // X-coordinate of the right arm of the cross
                int y2 = centerY - size / 10; // Y-coordinate of the right arm of the cross

                int x3 = centerX; // X-coordinate of the horizontal line of the cross
                int y3 = centerY - size / 2; // Y-coordinate of the horizontal line of the cross

                int x4 = centerX; // X-coordinate of the vertical line of the cross
                int y4 = centerY + size / 2; // Y-coordinate of the vertical line of the cross

                g.drawLine(x1, y1, x2, y2); // Draw the left arm
                g.drawLine(x3, y3, x4, y4); // Draw the vertical line
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
            Cross1 cross = new Cross1();
            cross.setVisible(true);
        });
    }
}