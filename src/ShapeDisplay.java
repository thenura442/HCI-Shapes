import javax.swing.*;

import models.ShapeModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ShapeDisplay extends JFrame {

    public ShapeDisplay () { {

        // Create a new JFrame (window)
        JFrame frame = new JFrame("All Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new JButton
        JButton ArrowBtn = new JButton("Arrow");
        JButton CircleBtn = new JButton("Circle");
        JButton CrossBtn = new JButton("Cross");
        JButton DecagonBtn = new JButton("Decagon");
        JButton DiamondBtn = new JButton("Diamond");
        JButton EllipseBtn = new JButton("Ellipse");
        JButton HeptagonBtn = new JButton("Heptagon");
        JButton HexagonBtn = new JButton("Hexagon");
        JButton NonagonBtn = new JButton("Nonagon");
        JButton OctagonBtn = new JButton("Octagon");
        JButton ParallelogramBtn = new JButton("Parallelogram");
        JButton PentagonBtn = new JButton("Pentagon");
        JButton RectangleBtn = new JButton("Rectangle");
        JButton RightTraingleBtn = new JButton("RightTraingle");
        JButton SquareBtn = new JButton("Square");
        JButton TrapezoidBtn = new JButton("Trapezoid");
        JButton StarBtn= new JButton("Star");
        JButton TriangleBtn = new JButton("Triangle");
        JButton HomeBtn = new JButton("Home");


        SquareBtn.setSize(100, 50);
        SquareBtn.setLocation(100, 150);

        TriangleBtn.setSize(100, 50);
        TriangleBtn.setLocation(220, 150);

        CircleBtn.setSize(100, 50);
        CircleBtn.setLocation(340, 150);

        RectangleBtn.setSize(100, 50);
        RectangleBtn.setLocation(460, 150);

        RightTraingleBtn.setSize(100, 50);
        RightTraingleBtn.setLocation(580, 150);

        DiamondBtn.setSize(100, 50);
        DiamondBtn.setLocation(700, 150);

        PentagonBtn.setSize(100, 50);
        PentagonBtn.setLocation(100, 250);

        ArrowBtn.setSize(100, 50);
        ArrowBtn.setLocation(220, 250);

        CrossBtn.setSize(100, 50);
        CrossBtn.setLocation(340, 250);

        DecagonBtn.setSize(100, 50);
        DecagonBtn.setLocation(460, 250);

        EllipseBtn.setSize(100, 50);
        EllipseBtn.setLocation(580, 250);

        HeptagonBtn.setSize(100, 50);
        HeptagonBtn.setLocation(700, 250);

        HexagonBtn.setSize(100, 50);
        HexagonBtn.setLocation(100, 350);

        OctagonBtn.setSize(100, 50);
        OctagonBtn.setLocation(220, 350);

        NonagonBtn.setSize(100, 50);
        NonagonBtn.setLocation(340, 350);

        ParallelogramBtn.setSize(100, 50);
        ParallelogramBtn.setLocation(460, 350);

        TrapezoidBtn.setSize(100, 50);
        TrapezoidBtn.setLocation(580, 350);

        StarBtn.setSize(100, 50);
        StarBtn.setLocation(700, 350);

        HomeBtn.setSize(100, 50);
        HomeBtn.setLocation(400, 450);







        ArrowBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Arrow1();

            }
        });
        CircleBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                new Circle1();
                }
        });
        CrossBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Cross1();
            }
        });
        DecagonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Decagon1();
            }
        });

        DiamondBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Diamond1();
            }
        });
        EllipseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Ellipse1();
            }
        });
        HeptagonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Heptagon1();
            }
        });
        HexagonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Hexagon1();
            }
        });
        NonagonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Nonagon1();
            }
        });
        OctagonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Octagon1();
            }
        });
        ParallelogramBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Parallegoram1();
            }
        });
        PentagonBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Pentagon1();
            }
        });
        RectangleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Rectangle1();
            }
        });
        RightTraingleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Right_Traingle1();
            }
        });
        SquareBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Square1();
            }
        });
        TrapezoidBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Trapeziod1();
            }
        });
        TriangleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Triangle1();
            }
        });
        StarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Star1();
            }
        });
        HomeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            }
        });




        frame.getContentPane().add(ArrowBtn);
        frame.getContentPane().add(CircleBtn);
        frame.getContentPane().add(CrossBtn);
        frame.getContentPane().add(DecagonBtn);
        frame.getContentPane().add(DiamondBtn);
        frame.getContentPane().add(EllipseBtn);
        frame.getContentPane().add(HeptagonBtn);
        frame.getContentPane().add(HexagonBtn);
        frame.getContentPane().add(NonagonBtn);
        frame.getContentPane().add(OctagonBtn);
        frame.getContentPane().add(ParallelogramBtn);
        frame.getContentPane().add(PentagonBtn);
        frame.getContentPane().add(RectangleBtn);
        frame.getContentPane().add(RightTraingleBtn);
        frame.getContentPane().add(SquareBtn);
        frame.getContentPane().add(StarBtn);
        frame.getContentPane().add(TrapezoidBtn);
        frame.getContentPane().add(TriangleBtn);
        frame.getContentPane().add(HomeBtn);

        frame.setSize(900, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ShapeDisplay shapedisplay = new ShapeDisplay();

        });
    }
}









