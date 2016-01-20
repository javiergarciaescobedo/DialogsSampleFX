/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogssample;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Javier
 */
public class DialogsSample extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label labelResult = new Label();
        
        Button btnAlert = new Button();
        btnAlert.setText("Alert");
        btnAlert.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                // Ejemplo de uso de ventana de confirmación
                Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to format your system?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    labelResult.setText("Ok pressed");
                } else {
                    labelResult.setText("Cancel pressed");
                }
            }
        });
        
        Button btnInputDialog = new Button();
        btnInputDialog.setText("Input text");
        btnInputDialog.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                // Ejemplo de uso de ventana de introducción de texto
                TextInputDialog textInputDialog = new TextInputDialog("Default text");
                textInputDialog.setTitle("Write a message");
                textInputDialog.setHeaderText("This is the header");
                textInputDialog.showAndWait();
                String InputText = textInputDialog.getEditor().getText();
                labelResult.setText(InputText);
            }
        });
        
        VBox root = new VBox();
        root.getChildren().add(labelResult);
        root.getChildren().add(btnAlert);
        root.getChildren().add(btnInputDialog);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Dialogs Sample");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
