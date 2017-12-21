package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private JFXColorPicker materialCode;

    @FXML
    private ColorPicker simpleCode;

    @FXML
    private JFXTextField outputText;
    @FXML
    private JFXTextField sb1;

    @FXML
    private Pane pbox1;

    @FXML
    private JFXTextField sb2;

    @FXML
    private Pane pbox2;

    @FXML
    private JFXTextField sb3;

    @FXML
    private Pane pbox3;

    @FXML
    private JFXTextField sb4;

    @FXML
    private Pane pbox4;

    @FXML
    private JFXTextField sb5;

    @FXML
    private Pane pbox5;

    @FXML
    private JFXTextField sb6;

    @FXML
    private Pane previewBox;

    @FXML
    private Label status;

    @FXML
    private JFXButton del1;

    @FXML
    private JFXButton del2;

    @FXML
    private JFXButton del3;

    @FXML
    private JFXButton del4;

    @FXML
    private JFXButton del5;

    @FXML
    private JFXButton del6;


    @FXML
    private JFXButton copy1;

    @FXML
    private JFXButton copy2;

    @FXML
    private JFXButton copy3;

    @FXML
    private JFXButton copy4;

    @FXML
    private JFXButton copy5;

    @FXML
    private JFXButton copy6;


    @FXML
    private Pane pbox6;

    private AnchorPane aboutUI;
    private Stage aboutStage;
    private Color color;
    private SaveColors saveColors;
    private FadeTransition aboutTransition;
    private Clipboard clipboard = Clipboard.getSystemClipboard();
    private ClipboardContent content = new ClipboardContent();

    @Override
    public void initialize(URL location, ResourceBundle resources){
        aboutStage = new Stage();
        try {
            saveColors = new SaveColors();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        initilizeSaveColor();
    }
    @FXML
    void getSimpleColor(ActionEvent event) {
        color = simpleCode.getValue();
        outputText.setText("#"+simpleCode.getValue().toString().substring(2,8).toUpperCase());
        previewBox.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    @FXML
    void getMaterialColor(ActionEvent event) {
        color = materialCode.getValue();
        outputText.setText("#"+materialCode.getValue().toString().substring(2,8).toUpperCase());
        previewBox.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @FXML
    void clearColorCode(ActionEvent event) {
        outputText.setText("");
    }

    @FXML
    void copyContent(ActionEvent event) {
        content.putString(outputText.getText());
        clipboard.setContent(content);
        status.setText("Color Copied");
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

    @FXML
    boolean saveCode(ActionEvent event) {

        if (outputText.getText().equals("")){
            return false;
        }else {
            if (sb1.getText().equals("")) {
                sb1.setText(outputText.getText());
                pbox1.setStyle("-fx-background-color:"+outputText.getText());
                pbox1.setOpacity(1);
                saveColors.saveColorToFile(outputText.getText());
                return true;
            }
            if (sb2.getText().equals("")) {
                sb2.setText(outputText.getText());
                pbox2.setStyle("-fx-background-color:"+outputText.getText());
                pbox2.setOpacity(1);
                saveColors.saveColorToFile(outputText.getText());
                return true;
            }
            if (sb3.getText().equals("")) {
                sb3.setText(outputText.getText());
                pbox3.setStyle("-fx-background-color:"+outputText.getText());
                pbox3.setOpacity(1);
                saveColors.saveColorToFile(outputText.getText());
                return true;
            }
            if (sb4.getText().equals("")) {
                sb4.setText(outputText.getText());
                pbox4.setStyle("-fx-background-color:"+outputText.getText());
                pbox4.setOpacity(1);
                saveColors.saveColorToFile(outputText.getText());
                return true;
            }
            if (sb5.getText().equals("")) {
                sb5.setText(outputText.getText());
                pbox5.setStyle("-fx-background-color:"+outputText.getText());
                pbox5.setOpacity(1);
                saveColors.saveColorToFile(outputText.getText());
                return true;
            }
            if (sb6.getText().equals("")) {
                sb6.setText(outputText.getText());
                pbox6.setStyle("-fx-background-color:"+outputText.getText());
                pbox6.setOpacity(1);
                saveColors.saveColorToFile(outputText.getText());
                return true;
            }
            else {
                return false;
            }
        }
    }

    private void initilizeSaveColor(){

        String[] colorList = saveColors.getColors();
        sb1.setText(colorList[0]);
        sb2.setText(colorList[1]);
        sb3.setText(colorList[2]);
        sb4.setText(colorList[3]);
        sb5.setText(colorList[4]);
        sb6.setText(colorList[5]);
        pbox1.setStyle("-fx-background-color: "+sb1.getText());
        pbox2.setStyle("-fx-background-color: "+sb2.getText());
        pbox3.setStyle("-fx-background-color: "+sb3.getText());
        pbox4.setStyle("-fx-background-color: "+sb4.getText());
        pbox5.setStyle("-fx-background-color: "+sb5.getText());
        pbox6.setStyle("-fx-background-color: "+sb6.getText());
    }


    @FXML
    void delColor(ActionEvent event) throws IOException {

        String id = getId(event.getSource().toString());

        switch (id){

            case "del1":
                saveColors.removeColor(sb1.getText());
                pbox1.setOpacity(0);
                sb1.setText("");
                break;
            case "del2":
                saveColors.removeColor(sb2.getText());
                pbox2.setOpacity(0);
                sb2.setText("");
                break;
            case "del3":
                saveColors.removeColor(sb3.getText());
                pbox3.setOpacity(0);
                sb3.setText("");
                break;
            case "del4":
                saveColors.removeColor(sb4.getText());
                pbox4.setOpacity(0);
                sb4.setText("");
                break;
            case "del5":
                saveColors.removeColor(sb5.getText());
                pbox5.setOpacity(0);
                sb5.setText("");
                break;
            case "del6":
                saveColors.removeColor(sb6.getText());
                pbox6.setOpacity(0);
                sb6.setText("");
                break;

        }

    }


    @FXML
    void copySavedColor(ActionEvent event) {
        switch (getId(event.getSource().toString())){
            case "copy1":
                content.putString(sb1.getText());
                break;
            case "copy2":
                content.putString(sb2.getText());
                break;
            case "copy3":
                content.putString(sb3.getText());
                break;
            case "copy4":
                content.putString(sb4.getText());
                break;
            case "copy5":
                content.putString(sb5.getText());
                break;
            case "copy6":
                content.putString(sb6.getText());
                break;
        }

        clipboard.setContent(content);
        status.setText("Color Copied");

    }

    private String getId(String raw){
        return raw.substring(raw.indexOf("=")+1,raw.indexOf(","));
    }

    public void exit(){
        System.exit(1);
    }
}
