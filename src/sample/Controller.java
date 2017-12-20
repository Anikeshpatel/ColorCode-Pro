package sample;

import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private JFXColorPicker materialCode;

    @FXML
    private ColorPicker simpleCode;

    @FXML
    private JFXTextField outputText;

    @FXML
    private AnchorPane root;
    private AnchorPane aboutUI;
    private Stage aboutStage;
    private Color color;

    private FadeTransition aboutTransition;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        aboutStage = new Stage();
        aboutStage.setResizable(false);
        try {
            aboutUI = FXMLLoader.load(getClass().getResource("about.fxml"));
            aboutStage.setScene(new Scene(aboutUI));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aboutStage.setTitle("About Software");
        aboutStage.getIcons().add(new Image("about_icon.png"));

        aboutTransition = new FadeTransition(Duration.seconds(2),aboutUI);
        aboutTransition.setFromValue(0);
        aboutTransition.setToValue(1);
        aboutTransition.setCycleCount(1);
    }
    @FXML
    void getSimpleColor(ActionEvent event) {
        color = simpleCode.getValue();
        outputText.setText("#"+simpleCode.getValue().toString().substring(2,8).toUpperCase());
        root.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    @FXML
    void getMaterialColor(ActionEvent event) {
        color = materialCode.getValue();
        outputText.setText("#"+materialCode.getValue().toString().substring(2,8).toUpperCase());
        root.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @FXML
    void clearColorCode(ActionEvent event) {
        outputText.setText("");
    }

    @FXML
    void copyContent(ActionEvent event) {

        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(outputText.getText());
        clipboard.setContent(content);
    }

    @FXML
    void cutContent(ActionEvent event) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(outputText.getText());
        clipboard.setContent(content);
        outputText.setText("");
    }

    public void showAbout(ActionEvent event){
        aboutStage.show();
        aboutTransition.play();
    }

    public void exit(){
        System.exit(1);
    }
}
