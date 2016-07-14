/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.Persona;

/**
 *
 * @author FLAVIO
 */
public class MainApp extends Application{

    private Stage stage;
    private BorderPane rootLayout;
    private ObservableList<Persona> personaData = FXCollections.observableArrayList();

    public MainApp() {
        for (int i = 0; i < 20; i++) {
            personaData.add(new Persona("Nombre" + i, "Apellido" + i));
        }
    }
    
    public ObservableList<Persona> getPersonaData(){
        return personaData;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Agenda");
        
        initRootLayout();
        showPersona();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/FXML_root.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error al leer 'FXML_root.fxml'");
        }
    }
    
    public void showPersona(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/FXML_persona.fxml"));
            AnchorPane fxmlPersona = (AnchorPane) loader.load();
            
            rootLayout.setCenter(fxmlPersona);
            
            FXML_personaController controller = loader.getController();
            controller.setMainApp(this);
        } catch (Exception e) {
            System.out.println("Error al leer 'FXML_persona.fxml'");
        }
    }
    
    public Stage getStage(){
        return stage;
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
