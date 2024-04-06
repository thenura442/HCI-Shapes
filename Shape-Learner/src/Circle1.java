import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;

public class Circle1 extends JFrame {
    private JPanel panel;

    public Circle1 () {
        setTitle("Circle");
        JFrame frame = new JFrame("Decagon");
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
                Label heading = new Label("Circle");
                heading.setFont(new Font("Arial",Font.BOLD,30));
                add(heading);

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = 100;

                int x = centerX - radius;
                int y = centerY - radius;
                int diameter = radius * 2;

                g.fillOval(x, y, diameter, diameter);
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
