package policeFxml;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class PoliceController implements Initializable {

    @FXML
    private Canvas apercuCanva = new Canvas(437.5,50);
    @FXML
    private BorderPane borderPane;
    @FXML
    private VBox verticalBox;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label policeLabel;
    @FXML
    private TextField policeTextField, styleTextField, tailleTextField;
    @FXML
    private ListView policeListView, styleListView, tailleListView;
    @FXML
    private Label styleLabel, tailleLabel, couleurLabel;
    @FXML
    private ColorPicker couleurComboBox;
    @FXML
    private FlowPane effetFlowPane;
    @FXML
    private Label effetLabel;
    @FXML
    private FlowPane apercuFlowPane;
    @FXML
    private Label apercuLabel;
    @FXML
    private TilePane tilePane;
    @FXML
    private CheckBox ch1, ch2, ch3, ch4, ch5, ch6, ch7;
    @FXML
    private GridPane gridPane;
    @FXML
    private Label trueTypeLabel;
    @FXML
    private HBox horizontalBox;
    @FXML
    private Button defautButton, effetButton, okButton, annulerButton;
    @FXML
    private Region region1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> listPolices = FXCollections.observableArrayList();

        for (Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
            listPolices.add(font.getName());
        }

        policeListView.setItems(listPolices);


        ObservableList<String> stylePolice = FXCollections.observableArrayList("Normal","Italique","Gras","Gras Italique");

        styleListView.setItems(stylePolice);


        ObservableList<String> taillePolice = FXCollections.observableArrayList();

        for (int i=1;i<200;i++) taillePolice.add(String.valueOf(i));

        tailleListView.setItems(taillePolice);


        policeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            drawApercuCanva(apercuCanva, newValue.toString(), getFontWeight(styleTextField.getText()), Integer.parseInt(tailleTextField.getText()), couleurComboBox.getValue());
            policeTextField.setText(newValue.toString());
        });


        styleListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            drawApercuCanva(apercuCanva, policeTextField.getText(), getFontWeight(newValue.toString()), Integer.parseInt(tailleTextField.getText()), couleurComboBox.getValue());
            styleTextField.setText(newValue.toString());
        });

        tailleListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            drawApercuCanva(apercuCanva, policeTextField.getText(), getFontWeight(styleTextField.getText()), Integer.parseInt(newValue.toString()), couleurComboBox.getValue());
            tailleTextField.setText(newValue.toString());
        });

        int tailleCheckbox = 150;

        drawApercuCanva(apercuCanva, "Arial", FontWeight.NORMAL, 12, Color.BLACK);

        EventHandler<ActionEvent> closeProgram = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Node source = (Node)  e.getSource();
                Stage stage  = (Stage) source.getScene().getWindow();
                stage.close();
            }
        };

        annulerButton.setOnAction(closeProgram);
    }

    @FXML
    public void changeColor() {
        drawApercuCanva(apercuCanva, policeTextField.getText(), getFontWeight(styleTextField.getText()), Integer.parseInt(tailleTextField.getText()), couleurComboBox.getValue());
    }


    /**
     * Methode permettant de retourner un type de police en FontWeigt selon un type donné en String
     * @param fontString type donné en string
     * @return type de police FontWeight
     */

    private FontWeight getFontWeight(String fontString) {
        switch (fontString){
            case "Normal":
                return FontWeight.NORMAL;
            case "Italique":
                return FontWeight.THIN;
            case "Gras":
                return FontWeight.BOLD;
            case "Gras Italique":
                return FontWeight.BOLD;
            default:
                return FontWeight.NORMAL;
        }
    }

    /**
     * Méthode permettant d'afficher l'apercu dans un canva
     * @param canvas l'objet canva dans le fxml
     * @param police nom de la police
     * @param type style de la police
     * @param taille taille de la police
     */

    @FXML
    private void drawApercuCanva(Canvas canvas, String police, FontWeight type, int taille, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        gc.beginPath();
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.fill();

        gc.beginPath();
        gc.moveTo(0, canvas.getHeight()/2);
        gc.lineTo(80, canvas.getHeight()/2);
        gc.stroke();

        gc.beginPath();
        gc.moveTo(canvas.getWidth()-80, canvas.getHeight()/2);
        gc.lineTo(canvas.getWidth(), canvas.getHeight()/2);
        gc.stroke();

        gc.beginPath();
        gc.setFont(javafx.scene.text.Font.font(police, type, taille));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(color);
        gc.fillText(
                "IUT de Laval",
                Math.round(canvas.getWidth()  / 2),
                Math.round(canvas.getHeight() / 2)
        );
        gc.stroke();
    }
}