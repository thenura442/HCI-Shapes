package models;

public class ShapeModel {
    public ShapeModel(String shapeName, ShapeInterface shape) {
        this.shapeName = shapeName;
        this.shape = shape;
    }

    String shapeName;

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public ShapeInterface getShape() {
        return shape;
    }

    public void setShape(ShapeInterface shape) {
        this.shape = shape;
    }

    ShapeInterface shape;

}
