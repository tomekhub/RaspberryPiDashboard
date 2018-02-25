package eu.thomaspro.raspberryPiDashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardLayout.fxml"));
        primaryStage.setTitle("Dashboard 1.0.0");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("/icon/icons8-raspberry-pi-32.png"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
