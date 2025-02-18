import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentManagementGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title of the window
        primaryStage.setTitle("Student Management System");

        // UI Layout
        VBox layout = new VBox(20);
        Label welcomeLabel = new Label("Welcome to Student Management System");

        layout.getChildren().addAll(welcomeLabel);

        // Set scene
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
