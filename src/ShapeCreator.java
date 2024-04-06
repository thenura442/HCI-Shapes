
import models.ShapeInterface;
import models.ShapeModel;

import java.awt.*;

public class ShapeCreator {
    static public ShapeModel[] shapeModel = new ShapeModel[]{
            new ShapeModel(ShapeType.Square.name(),new Square()),
            new ShapeModel(ShapeType.Circle.name(),new Circle()),
            new ShapeModel(ShapeType.Rectangle.name(),new Rectangle()),
            new ShapeModel(ShapeType.Triangle.name(),new Triangle()),
            new ShapeModel(ShapeType.Pentagon.name(),new Pentagon()),
            new ShapeModel(ShapeType.Hexagon.name(),new Hexagon()),
            new ShapeModel(ShapeType.Octagon.name(),new Octagon()),
            new ShapeModel(ShapeType.Ellipse.name(),new Ellipse()),
            new ShapeModel(ShapeType.Diamond.name(),new Diamond()),
            new ShapeModel(ShapeType.Trapezoid.name(),new Trapezoid()),
            new ShapeModel(ShapeType.Parallelogram.name(),new Parallelogram()),

    };
}


enum ShapeType{
    Rectangle,
    Circle,
    Triangle,
    Square,
    Pentagon,
    Hexagon,
    Octagon,
    Ellipse,
    Diamond,
    Trapezoid,
    Parallelogram
}

class Square implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillRect(x, y, width, height);
    }
}
class Rectangle implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillRect(x, y, width, height-5);
    }
}

class Circle implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillOval(x, y, width, height);
    }
}

class Triangle implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int[] xPoints = {x, x + width / 2, x + width};
        int[] yPoints = {y + height, y, y + height};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
class Pentagon implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int radius = Math.min(width, height) / 2;
        int[] xPoints = {(int) (x + width / 2 + radius * Math.cos(0)),
                (int) (x + width / 2 + radius * Math.cos(2 * Math.PI / 5)),
                (int) (x + width / 2 + radius * Math.cos(4 * Math.PI / 5)),
                (int) (x + width / 2 + radius * Math.cos(6 * Math.PI / 5)),
                (int) (x + width / 2 + radius * Math.cos(8 * Math.PI / 5))};
        int[] yPoints = {(int) (y + height / 2 - radius * Math.sin(0)),
                (int) (y + height / 2 - radius * Math.sin(2 * Math.PI / 5)),
                (int) (y + height / 2 - radius * Math.sin(4 * Math.PI / 5)),
                (int) (y + height / 2 - radius * Math.sin(6 * Math.PI / 5)),
                (int) (y + height / 2 - radius * Math.sin(8 * Math.PI / 5))};
        g.fillPolygon(xPoints, yPoints, 5);
    }
}

class Hexagon implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int[] xPoints = {x + width / 4, x + width * 3 / 4, x + width, x + width * 3 / 4, x + width / 4, x};
        int[] yPoints = {y, y, y + height / 2, y + height, y + height, y + height / 2};
        g.fillPolygon(xPoints, yPoints, 6);
    }
}

class Octagon implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int[] xPoints = {x + width / 3, x + width * 2 / 3, x + width, x + width, x + width * 2 / 3, x + width / 3, x, x};
        int[] yPoints = {y, y, y + height / 3, y + height * 2 / 3, y + height, y + height, y + height * 2 / 3, y + height / 3};
        g.fillPolygon(xPoints, yPoints, 8);
    }
}

class Ellipse implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.fillOval(x, y, width, height-5);
    }
}

class Diamond implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int[] xPoints = {x + width / 2, x + width, x + width / 2, x};
        int[] yPoints = {y, y + height / 2, y + height, y + height / 2};
        g.fillPolygon(xPoints, yPoints, 4);
    }
}

class Trapezoid implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int[] xPoints = {x + width / 4, x + width * 3 / 4, x + width, x};
        int[] yPoints = {y, y, y + height, y + height};
        g.fillPolygon(xPoints, yPoints, 4);
    }
}

class Parallelogram implements ShapeInterface {
    @Override
    public void draw(Graphics g, int x, int y, int width, int height) {
        int[] xPoints = {x + width / 4, x + width, x + width * 3 / 4, x};
        int[] yPoints = {y, y, y + height, y + height};
        g.fillPolygon(xPoints, yPoints, 4);
    }
}





















