import models.ShapeModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ArtBoard extends JFrame {

    private final DataModel dataModel;
    private final ShapeModel shapeDTO;
    private int i = 0;
    JFXPanel fxPanel = new JFXPanel();
    String shapeName = "";
    Display3DCube display3DCube = null;
   
    Label Namelabel = null;

    public ArtBoard(ShapeModel shapeDTO , int i){
        this.i = i;
        dataModel = new DataModel();
        dataModel.setSelectedShape(shapeDTO);
        this.shapeDTO = shapeDTO;
        setSize(1078,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());  // Use BorderLayout for the main frame
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
        setContentPane(contentPanel);
        setLocationRelativeTo(null);
        setResizable(false);
        add(new ShapeCanvas(dataModel , this , shapeDTO),BorderLayout.CENTER);
        add(BottomSidePanel(),BorderLayout.PAGE_END);
        add(LeftSidePanel(),BorderLayout.LINE_END);
        pack();
        setVisible(true);
    }

    private  JPanel  LeftSidePanel(){
        JPanel rSidepanel = new JPanel();
        rSidepanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        rSidepanel.setPreferredSize(new Dimension(this.getWidth()/3,this.getHeight()));
        rSidepanel.setLayout(new BoxLayout(rSidepanel,BoxLayout.Y_AXIS));
        rSidepanel.setBackground(Color.white);

        JPanel shapeNamePanel = new JPanel();
        shapeNamePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        shapeName = shapeDTO.getShapeName();
        Namelabel = new Label(shapeName);
        Namelabel.setFont(new Font("Arial",Font.BOLD , 30));
        //Set padding for label
        Namelabel.setPreferredSize(new Dimension(this.getWidth()/3,40));
        shapeNamePanel.add(headingLabel("Selected Shape"), Color.BLUE);
        shapeNamePanel.add(Namelabel);
        shapeNamePanel.setBackground(Color.white);
        rSidepanel.add(shapeNamePanel);

        JPanel colorChooserPanel = new JPanel();
        colorChooserPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        colorChooserPanel.add(headingLabel("Change Color"));
        JPanel colorChooser = createColorPickerPanel();
        colorChooserPanel.add(colorChooser);
        colorChooserPanel.setBackground(Color.white);
        rSidepanel.add(colorChooserPanel);

        JPanel scaleChooserPanel = new JPanel();
        scaleChooserPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        scaleChooserPanel.add(headingLabel("Scale"));
        JSlider scaleSlider = customSlider();
        scaleSlider.addChangeListener(e -> {
            int scale = scaleSlider.getValue();
            dataModel.setShapeScale(scale);
        });
        scaleChooserPanel.setBackground(Color.white);
        scaleChooserPanel.add(scaleSlider);
        rSidepanel.add(scaleChooserPanel);

        JPanel widthChooserPanel = new JPanel();
        widthChooserPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        widthChooserPanel.add(headingLabel("Width"));
        JSlider widthSlider = customSlider();
        widthSlider.addChangeListener(e -> {
            int width = widthSlider.getValue();
            dataModel.setShapeWidth(width);
        });
        widthChooserPanel.setBackground(Color.white);
        widthChooserPanel.add(widthSlider);
        rSidepanel.add(widthChooserPanel);

        JPanel heightChooserPanel = new JPanel();
        heightChooserPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        heightChooserPanel.add(headingLabel("Height"));
        JSlider heightSlider = customSlider();
        heightSlider.addChangeListener(e -> {
            int height = heightSlider.getValue();
            dataModel.setShapeHeight(height);
        });
        heightChooserPanel.setBackground(Color.white);
        heightChooserPanel.add(heightSlider);
        rSidepanel.add(heightChooserPanel);


        rSidepanel.add(footerControl());

        return rSidepanel;
    }

    private JPanel BottomSidePanel() {
        JPanel lSidePanel = new JPanel();
        lSidePanel.setBorder(new EmptyBorder(20, 20, 20, 10));
        lSidePanel.setPreferredSize(new Dimension(this.getWidth() / 8, this.getHeight()));
        lSidePanel.setLayout(new BorderLayout());
        lSidePanel.setBackground(Color.white);
    
        // Create a panel to hold the shape buttons
        JPanel shapeButtonsPanel = new JPanel();
        shapeButtonsPanel.setLayout(new BoxLayout(shapeButtonsPanel, BoxLayout.Y_AXIS));
        shapeButtonsPanel.setBackground(Color.white);
    
        // Iterate over the shapeModel array and create buttons with shape icons
        for (ShapeModel shape : ShapeCreator.shapeModel) {
            // Create a button with a custom icon representing the shape
            JButton shapeButton = new JButton(new ShapeIcon(shape));
    
            // Set the button's properties
            shapeButton.setFocusPainted(false);
            shapeButton.setPreferredSize(new Dimension(10, 50));
    
            // Add an action listener to handle shape selection
            shapeButton.addActionListener(e -> {
                dataModel.setSelectedShape(shape);
                shapeName = shape.getShapeName();
                Namelabel.setText(shapeName);
                
                if (shape.getShapeName().equals(ShapeType.Rectangle.name())) {
                    // Set the height equal to the width
                    dataModel.setShapeWidth(200);
                }
                else if (shape.getShapeName().equals(ShapeType.Ellipse.name())) {
                    // Set the height equal to the width
                    dataModel.setShapeWidth(200);
                }

                repaint();
            });
    
            shapeButtonsPanel.add(shapeButton);
        }
    
        lSidePanel.add(shapeButtonsPanel, BorderLayout.CENTER);
    
        return lSidePanel;
    }

    JPanel footerControl(){
        JPanel footerControlPanel = new JPanel();
        footerControlPanel.setPreferredSize(new Dimension(200,50));
        footerControlPanel.setSize(new Dimension(this.getWidth()/3,30));
        footerControlPanel.setLayout(new GridLayout(1 , 3));
        JButton prevButton = new JButton("Previous");
        prevButton.setFocusPainted(false);
        prevButton.setFont(new Font("Arial",Font.BOLD,14));
        if(i==0){
            prevButton.setText("Home");
            prevButton.addActionListener(ev->{
                this.setVisible(false);
                new Home().setVisible(true);
            });
        }else if(i > 0){
            prevButton.addActionListener(ev->{
                i = i-1;
                this.setVisible(false);
                new Editor(ShapeCreator.shapeModel[i],i).setVisible(true);
            });
        }
        footerControlPanel.add(prevButton);



        JButton saveButton = new JButton("Save");
        saveButton.setFocusPainted(false);
        saveButton.setFont(new Font("Arial",Font.BOLD,14));
        footerControlPanel.add(saveButton);
        saveButton.addActionListener(ev-> {
            this.dataModel.setCaptureScreenShot(true);
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        exitButton.setFocusPainted(false);
        exitButton.setFont(new Font("Arial",Font.BOLD,14));
        footerControlPanel.add(exitButton);


        return  footerControlPanel;
    }

    JSlider customSlider(){
        JSlider customSlider = new JSlider(50, 200, 100);
        customSlider.setBackground(Color.white);
        customSlider.setMajorTickSpacing(50);
        customSlider.setMinorTickSpacing(10);
        customSlider.setPaintTicks(true);
        customSlider.setPaintLabels(true);
        customSlider.setPreferredSize(new Dimension((this.getWidth()/3)-50,50));
        return customSlider;
    }

    JPanel createColorPickerPanel(){
        JPanel colorPickerPanel = new JPanel();
        colorPickerPanel.setBackground(Color.white);
        colorPickerPanel.setPreferredSize(new Dimension((this.getWidth()/3)-50,50));
        colorPickerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        JButton colorPicker = new JButton();
        colorPicker.setPreferredSize(new Dimension(50,50));
        colorPicker.setBackground(Color.BLACK);
        colorPicker.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Select a color", Color.BLACK);
            if (color != null) {
                dataModel.setSelectedColor(color);
                colorPicker.setBackground(color);
            }
        });
        colorPickerPanel.add(colorPicker);
        return colorPickerPanel;
    }
    

    Label headingLabel(String heading){
        Font headingFont = new Font("Arial",Font.BOLD , 18);
        Label label = new Label(heading);
        label.setFont(headingFont);
        label.setPreferredSize(new Dimension(this.getWidth()/3,30));
        return label;
    }
}

class ShapeCanvas extends  JPanel{
    private ShapeModel selectedShape;
    private Color shapeColor;
    private int shapeWidth;
    private int shapeHeight;
    private int shapeScale;

    private  DataModel dataModel;
    public ShapeCanvas(DataModel dataModel , JFrame frame , ShapeModel selectedShape){
        setBackground(Color.white);
        this.selectedShape = selectedShape;
        this.dataModel = dataModel;
        dataModel.addPropertyChangeListener(evt -> {
            if ("selectedColor".equals(evt.getPropertyName())) {
                Color newValue = (Color) evt.getNewValue();
                shapeColor = newValue;
                repaint();
            }
        });

        dataModel.addPropertyChangeListener(evt -> {
            if ("shapeScale".equals(evt.getPropertyName())) {
                int newValue = (int) evt.getNewValue();
                shapeScale = newValue;
                repaint();
            }
        });

        dataModel.addPropertyChangeListener(evt -> {
            if ("shapeWidth".equals(evt.getPropertyName())) {
                int newValue = (int) evt.getNewValue();
                shapeWidth = newValue;
                repaint();
            }
        });

        dataModel.addPropertyChangeListener(evt -> {
            if ("shapeHeight".equals(evt.getPropertyName())) {
                int newValue = (int) evt.getNewValue();
                shapeHeight = newValue;
                repaint();
            }
        });

        dataModel.addPropertyChangeListener(evt -> {
            if ("selectedShape".equals(evt.getPropertyName())) {
                ShapeModel newValue = (ShapeModel) evt.getNewValue();
                this.selectedShape = newValue;
                repaint();
            }
        });

        dataModel.addPropertyChangeListener(evt->{
            if ("captureScreenShot".equals(evt.getPropertyName())) {
                boolean newValue = (boolean) evt.getNewValue();
                if(newValue){
                    this.takeScreenShot();
                    repaint();
                }
            }
        });
        setPreferredSize(new Dimension(2*frame.getWidth()/3,frame.getHeight()));
        setSelectedShape();
    }

    private  void takeScreenShot(){
        BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        this.print(g2);
        g2.dispose();
        File outputFile = new File("saved_shapes/shape_" + System.currentTimeMillis() + ".jpeg");
        try {
            ImageIO.write(image, "jpeg", outputFile);
           JOptionPane.showMessageDialog(null,"Shape saved successfully to "+outputFile.getPath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error saving shape: " + ex.getMessage());
        } finally {
            this.dataModel.setCaptureScreenShot(false);
        }
    }

    public void setSelectedShape() {
        if(this.selectedShape == null){
            this.selectedShape = new ShapeModel("Square",new Square());
        }
        shapeColor = Color.BLACK;
        shapeWidth = 100;
        shapeHeight = 100;
        shapeScale = 100;
        if(selectedShape.getShapeName().equals(ShapeType.Rectangle.name())
                || selectedShape.getShapeName().equals(ShapeType.Ellipse.name())){
            shapeWidth*=1.5;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - shapeWidth) / 2;
        int y = (getHeight() - shapeHeight) / 2;

        int scaledWidth = shapeWidth * shapeScale / 100;
        int scaledHeight = shapeHeight * shapeScale / 100;

        g.setColor(shapeColor);
        this.selectedShape.getShape().draw(g, x, y, scaledWidth, scaledHeight);
    }

}




