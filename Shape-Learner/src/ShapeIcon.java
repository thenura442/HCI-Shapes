import javax.swing.*;

import models.ShapeModel;

import java.awt.*;

class ShapeIcon implements Icon {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;
    private static final int SHAPE_PADDING = 5;

    private ShapeModel shape;

    public ShapeIcon(ShapeModel shape) {
        this.shape = shape;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the color and shape dimensions
        g2d.setColor(Color.black);
        int shapeWidth = WIDTH - 2 * SHAPE_PADDING;
        int shapeHeight = HEIGHT - 2 * SHAPE_PADDING;

        // Calculate the position to center the shape
        int shapeX = x + SHAPE_PADDING + (WIDTH - shapeWidth) / 2;
        int shapeY = y + SHAPE_PADDING + (HEIGHT - shapeHeight) / 2;

        // Draw the shape
        shape.getShape().draw(g2d, shapeX, shapeY, shapeWidth, shapeHeight);

        g2d.dispose();
    }

    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }
}
