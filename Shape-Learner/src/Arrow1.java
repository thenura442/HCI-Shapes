import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Arrow1 extends JFrame {
    private JPanel panel;

    public Arrow1 () {
        JFrame frame = new JFrame("Arrow");
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



        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);

                Label heading = new Label("Arrow ");
                heading.setFont(new Font("Arial",Font.BOLD,30));
                add(heading);


                int[] xPoints = {50, 100, 100, 200, 200, 100, 100};
                int[] yPoints = {200, 200, 100, 100, 300, 300, 200};

                g.drawPolygon(xPoints, yPoints, 7);
                g.drawLine(200, 200, 250, 200);
                g.drawLine(250, 200, 225, 175);
                g.drawLine(250, 200, 225, 225);
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
            Arrow1 arrow = new Arrow1();
            arrow.setVisible(true);
        });
    }
}