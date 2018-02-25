package eu.thomaspro.raspberryPiDashboard.controllers;

import eu.thomaspro.raspberryPiDashboard.models.Clock;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;

public class Controller implements IController{
    @FXML
    private Label clockTime;

    @FXML
    private Label clockDate;

    @FXML
    private WebView weatherView;

    @FXML
    private ListView<?> listView;

    @FXML
    private ImageView raspberryImg;

    @FXML
    private Button closeBtn;

    @FXML
    private Button maxBtn;

    @FXML
    private Button hideBtn;
    public void initialize(URL location, ResourceBundle resources) {
        Timer timer = new Timer();
        timer.schedule(new Clock(clockDate, clockTime), 0, 1);
        weatherView.getEngine().setJavaScriptEnabled(true);
        weatherView.getEngine().loadContent("<html><head><style>html, body{margin: 0 auto; padding 0;}</style></head><body><a class=\"weatherwidget-io\" href=\"https://forecast7.com/pl/54d3518d65/gdansk/\" data-label_1=\"GDAŃSK\" data-theme=\"weather_one\" ></a>\n" +
                "<script>\n" +
                "!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src='https://weatherwidget.io/js/widget.min.js';fjs.parentNode.insertBefore(js,fjs);}}(document,'script','weatherwidget-io-js');\n" +
                "</script></body></html>");
        raspberryImg.setImage(new Image("/icon/icons8-raspberry-pi-32.png"));
        raspberryImgRotate();

        closeBtn.setOnAction(event -> Platform.exit());
        hideBtn.setOnAction(event -> {
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            // is stage minimizable into task bar. (true | false)
            stage.setIconified(true);
        });
        maxBtn.setOnAction(event -> {
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.setFullScreen(true);
        });
    }
    private void raspberryImgRotate(){

        FadeTransition ft = new FadeTransition();
        ft.setNode(raspberryImg);
        ft.setDuration(new Duration(1000));
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Integer.MAX_VALUE);
        ft.setAutoReverse(true);
        ft.play();
    }

}
