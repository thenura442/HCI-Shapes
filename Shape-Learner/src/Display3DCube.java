import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Display3DCube extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Shape3D selectedShape;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        // Create the 3D scene
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.LIGHTGRAY);
        //Set resizable to false
        primaryStage.setResizable(false);

        // Create the camera
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-1000);

        // Create a cube and add it to the scene
        Box cube = new Box(200, 200, 200);
        cube.setTranslateX(WIDTH / 2);
        cube.setTranslateY(HEIGHT / 2);
        root.getChildren().add(cube);
        selectedShape = cube;

        // Set up material and lighting for the cube
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);  // Change the diffuse color as desired
        material.setSpecularColor(Color.WHITE);  // Set the specular color for reflection
        cube.setMaterial(material);

        // Create a rotation transform for the selected shape
        Rotate shapeRotateX = new Rotate(10, Rotate.X_AXIS);
        Rotate shapeRotateY = new Rotate(10, Rotate.Y_AXIS);
        selectedShape.getTransforms().addAll(shapeRotateX, shapeRotateY);

        // Handle mouse events to rotate the selected shape
        scene.setOnMouseDragged(event -> {
            double dragX = event.getSceneX() - scene.getWidth() / 2;
            double dragY = event.getSceneY() - scene.getHeight() / 2;
            shapeRotateX.setAngle(shapeRotateX.getAngle() - dragY / 5);
            shapeRotateY.setAngle(shapeRotateY.getAngle() + dragX / 5);
        });

        // Set up the 3D scene
        root.getChildren().add(camera);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D Shape Viewer");
        primaryStage.show();
    }
    public void closeWindow() {
        primaryStage.close();
    }

@Override
public void stop(){
  //Hide the Stage
    primaryStage.hide();
}

//Show the Stage
public void showWindow(){
    primaryStage.show();
}
}