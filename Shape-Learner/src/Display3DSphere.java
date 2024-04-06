import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.scene.shape.Box;
import javafx.scene.transform.Scale;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Rotate;

public class Display3DSphere extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Sphere selectedShape;
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

        // Create a sphere and add it to the scene
        Sphere sphere = new Sphere(200);
        sphere.setTranslateX(WIDTH / 2);
        sphere.setTranslateY(HEIGHT / 2);

        // Set up material and lighting for the sphere
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);  // Change the diffuse color as desired
        material.setSpecularColor(Color.WHITE);  // Set the specular color for reflection
        sphere.setMaterial(material);

        root.getChildren().add(sphere);
        selectedShape = sphere;

        // Create a rotation transform for the selected shape
        Rotate shapeRotateX = new Rotate(0, Rotate.X_AXIS);
        Rotate shapeRotateY = new Rotate(0, Rotate.Y_AXIS);
        selectedShape.getTransforms().addAll(shapeRotateX, shapeRotateY);

        // Handle mouse events to rotate the selected shape
        scene.setOnMouseDragged(event -> {
            double dragX = event.getSceneX() - scene.getWidth() / 2;
            double dragY = event.getSceneY() - scene.getHeight() / 2;
            shapeRotateX.setAngle(shapeRotateX.getAngle() - dragY / 5);
            shapeRotateY.setAngle(shapeRotateY.getAngle() + dragX / 5);
        });

        // Add a PointLight on the left side of the scene
        PointLight light = new PointLight(Color.WHITE);
        light.setTranslateX(-WIDTH / 2);
        light.setTranslateY(HEIGHT / 2);
        light.setTranslateZ(-1000);
        root.getChildren().add(light);

        // Set up the 3D scene
        root.getChildren().add(camera);
        primaryStage.setScene(scene);
        primaryStage.setTitle("3D Shape Viewer");
        primaryStage.show();
    }

    public void closeWindow() {
        primaryStage.close();
    }
}
