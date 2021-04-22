package police;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {

    Canvas apercuCanva = new Canvas(437.5,50);

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            VBox verticalBox = new VBox();


            AnchorPane anchorPane = new AnchorPane();


            Label policeLabel = new Label("Police :");
            TextField policeTextField = new TextField("Arial");
            ListView policeListView = new ListView<>();
            policeTextField.setPrefWidth(175);
            policeTextField.setPrefHeight(30);
            policeListView.setPrefWidth(175);
            policeListView.setPrefHeight(200);

            ObservableList<String> listPolices = FXCollections.observableArrayList();

            for (Font font : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts()) {
                listPolices.add(font.getName());
            }

            policeListView.setItems(listPolices);








            Label styleLabel = new Label("Style de police :");
            TextField styleTextField = new TextField("Normal");
            ListView styleListView = new ListView<>();
            styleTextField.setPrefWidth(125);
            styleTextField.setPrefHeight(30);
            styleListView.setPrefWidth(125);
            styleListView.setPrefHeight(200);

            ObservableList<String> stylePolice = FXCollections.observableArrayList("Normal","Italique","Gras","Gras Italique");

            styleListView.setItems(stylePolice);





            Label tailleLabel = new Label("Taille :");
            TextField tailleTextField = new TextField("12");
            ListView tailleListView = new ListView<>();
            tailleTextField.setPrefWidth(75);
            tailleTextField.setPrefHeight(30);
            tailleListView.setPrefWidth(75);
            tailleListView.setPrefHeight(200);

            ObservableList<String> taillePolice = FXCollections.observableArrayList();

            for (int i=1;i<200;i++) {
                taillePolice.add(String.valueOf(i));
            }

            tailleListView.setItems(taillePolice);





            Label couleurLabel = new Label("Couleur de police :");
            ColorPicker couleurComboBox = new ColorPicker(Color.BLACK);
            couleurComboBox.setPrefWidth(150);


            FlowPane effetFlowPane = new FlowPane();
            Label effetLabel = new Label();
            effetLabel.setPadding(new Insets(15, 0, 10, 31.25 / 2));

            FlowPane apercuFlowPane = new FlowPane();
            Label apercuLabel = new Label();
            apercuLabel.setPadding(new Insets(15, 0, 10, 31.25 / 2));


            TilePane tilePane = new TilePane();
            int tailleCheckbox = 150;
            CheckBox ch1 = new CheckBox("Barré");
            ch1.setPrefWidth(tailleCheckbox);
            CheckBox ch2 = new CheckBox("Barré double");
            ch2.setPrefWidth(tailleCheckbox);
            CheckBox ch3 = new CheckBox("Exposant");
            ch3.setPrefWidth(tailleCheckbox);
            CheckBox ch4 = new CheckBox("Indice");
            ch4.setPrefWidth(tailleCheckbox);
            CheckBox ch5 = new CheckBox("Petites majuscules");
            ch5.setPrefWidth(tailleCheckbox);
            CheckBox ch6 = new CheckBox("Majuscules");
            ch6.setPrefWidth(tailleCheckbox);
            CheckBox ch7 = new CheckBox("Masqué");
            ch7.setPrefWidth(tailleCheckbox);


            GridPane gridPane = new GridPane();
            Label trueTypeLabel = new Label("Police TrueType, identique à l'écran et à l'impression.");
            drawApercuCanva(apercuCanva, "Arial", FontWeight.NORMAL, 12, Color.BLACK);

            gridPane.add(apercuCanva, 0, 0);
            gridPane.add(trueTypeLabel, 0, 1);
            gridPane.setPadding(new Insets(0,0,0,31.25));





            HBox horizontalBox = new HBox(10);

            Button defautButton = new Button("Définir par défaut");
            Button effetButton = new Button("Effets de texte...");
            Button okButton = new Button("OK");
            Button annulerButton = new Button("Annuler");
            int btnSize = 90;
            defautButton.setMinWidth(btnSize);
            effetButton.setMinWidth(btnSize);
            okButton.setMinWidth(btnSize);
            annulerButton.setMinWidth(btnSize);

            EventHandler<ActionEvent> closeProgram = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    primaryStage.close();
                }
            };
            annulerButton.setOnAction(closeProgram);

            Region region1 = new Region();
            HBox.setHgrow(region1, Priority.ALWAYS);
            horizontalBox.getChildren().addAll(defautButton, effetButton, region1, okButton, annulerButton);
            horizontalBox.setPadding(new Insets(10, 10, 10, 10));

            anchorPane.getChildren().addAll(tailleLabel, tailleTextField, tailleListView, styleLabel, styleTextField, styleListView, couleurLabel, couleurComboBox, policeLabel, policeTextField, policeListView);

            anchorPane.setLeftAnchor(policeLabel, 31.25);
            anchorPane.setLeftAnchor(policeTextField, 31.25);
            anchorPane.setLeftAnchor(policeListView, 31.25);
            anchorPane.setTopAnchor(policeLabel, 31.25);
            anchorPane.setTopAnchor(policeTextField, 55.25);
            anchorPane.setTopAnchor(policeListView, 90.25);

            anchorPane.setLeftAnchor(styleLabel, 237.5);
            anchorPane.setLeftAnchor(styleTextField, 237.5);
            anchorPane.setLeftAnchor(styleListView, 237.5);
            anchorPane.setTopAnchor(styleLabel, 31.25);
            anchorPane.setTopAnchor(styleTextField, 55.25);
            anchorPane.setTopAnchor(styleListView, 90.25);

            anchorPane.setLeftAnchor(tailleLabel, 393.75);
            anchorPane.setLeftAnchor(tailleTextField, 393.75);
            anchorPane.setLeftAnchor(tailleListView, 393.75);
            anchorPane.setTopAnchor(tailleLabel, 31.25);
            anchorPane.setTopAnchor(tailleTextField, 55.25);
            anchorPane.setTopAnchor(tailleListView, 90.25);

            anchorPane.setLeftAnchor(couleurLabel, 31.25);
            anchorPane.setLeftAnchor(couleurComboBox, 31.25);
            anchorPane.setTopAnchor(couleurLabel, 300.25);
            anchorPane.setTopAnchor(couleurComboBox, 320.25);

            tilePane.setPadding(new Insets(0, 0, 0, 31.25));



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

            couleurComboBox.setOnAction(new EventHandler() {
                @Override
                public void handle(Event event) {
                    drawApercuCanva(apercuCanva, policeTextField.getText(), getFontWeight(styleTextField.getText()), Integer.parseInt(tailleTextField.getText()), couleurComboBox.getValue());
                }
            });


            effetLabel.setText("Effets");
            apercuLabel.setText("Aperçu");

            effetFlowPane.getChildren().add(effetLabel);
            apercuFlowPane.getChildren().add(apercuLabel);

            tilePane.getChildren().addAll(ch1, ch2, ch3, ch4, ch5, ch6, ch7);

            verticalBox.getChildren().addAll(anchorPane, effetFlowPane, tilePane, apercuFlowPane, gridPane);


            root.setCenter(verticalBox);
            root.setBottom(horizontalBox);

            Scene scene = new Scene(root, 500, 600);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Police (Java Version)");
            primaryStage.setResizable(false);
            primaryStage.show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public static void main(String[] args) {
        launch(args);
    }


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