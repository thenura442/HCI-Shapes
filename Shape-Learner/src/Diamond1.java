import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;

public class Diamond1 extends JFrame {
    private JPanel panel;

    public Diamond1 () {
        JFrame frame = new JFrame("Diamond");
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
                Label heading = new Label("Diamond");
                heading.setFont(new Font("Arial",Font.BOLD,30));
                add(heading);

                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int width = 100;
                int height = 100;

                int[] xPoints = {centerX, centerX + width / 2, centerX, centerX - width / 2};
                int[] yPoints = {centerY - height / 2, centerY, centerY + height / 2, centerY};

                g.fillPolygon(xPoints, yPoints, 4);
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
            Diamond1  diamond  = new Diamond1();
            diamond.setVisible(true);
        });
    }
}
