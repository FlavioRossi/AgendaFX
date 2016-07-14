/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Persona;
import util.DateUtil;

/**
 *
 * @author FLAVIO
 */
public class FXML_personaController implements Initializable{

    @FXML
    private TableView<Persona> table_persona;
    @FXML
    private TableColumn<Persona, String> table_persona_nombre;
    @FXML
    private TableColumn<Persona, String> table_persona_apellido;
    @FXML
    private Label txt_nombre;
    @FXML
    private Label txt_apellido;
    @FXML
    private Label txt_domicilio;
    @FXML
    private Label txt_calle;
    @FXML
    private Label txt_codigoPostal;
    @FXML
    private Label txt_cumplano;
   
    /**
     * Referencia a la clase principal de la Aplicación.
     */
    private MainApp mainApp;

    public FXML_personaController() {
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table_persona_nombre.setCellValueFactory(cellData -> cellData.getValue().nombre());
        table_persona_apellido.setCellValueFactory(cellData -> cellData.getValue().apellido());
        
        showDetallePersona(null);
        
        table_persona.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
            showDetallePersona(newValue);
        });
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        table_persona.setItems(mainApp.getPersonaData());
    }
    
    public void showDetallePersona(Persona persona){
        if (persona != null) {
            txt_nombre.setText(persona.getNombre());
            txt_apellido.setText(persona.getApellido());
            txt_calle.setText(persona.getCiudad());
            txt_domicilio.setText(persona.getDomicilio());
            txt_codigoPostal.setText(String.valueOf(persona.getCodigoPostal()));
            txt_cumplano.setText(DateUtil.formato(persona.getCumplano()));
        }else{
            txt_nombre.setText(null);
            txt_apellido.setText(null);
            txt_calle.setText(null);
            txt_domicilio.setText(null);
            txt_codigoPostal.setText(null);
            txt_cumplano.setText(null);
        }
    }

    @FXML
    private void eliminarPersona(ActionEvent event) {
        int seleccion = table_persona.getSelectionModel().getSelectedIndex();
        if (seleccion > 0) {
            table_persona.getItems().remove(seleccion);
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Borrar persona");
            alerta.setContentText("No ha seleccionado ninguna persona");
            alerta.setHeaderText("Por favor seleccione una persona");
            alerta.show();
        }
    }
}
