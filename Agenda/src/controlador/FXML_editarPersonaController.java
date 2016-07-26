/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;
import util.DateUtil;

/**
 * FXML Controller class
 *
 * @author FLAVIO
 */
public class FXML_editarPersonaController implements Initializable {

    @FXML
    private TextField txt_nombre;
    @FXML
    private TextField txt_apellido;
    @FXML
    private TextField txt_domicilio;
    @FXML
    private TextField txt_ciudad;
    @FXML
    private TextField txt_codigoPostal;
    @FXML
    private TextField txt_cumplanos;
    @FXML
    private Button btn_ok;
    @FXML
    private Button btn_cancelar;

    private Stage stage;
    private Persona persona;
    private boolean ok;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    public void setPersona(Persona persona){
        this.persona = persona;
        
        txt_nombre.setText(persona.getNombre());
        txt_apellido.setText(persona.getApellido());
        txt_domicilio.setText(persona.getDomicilio());
        txt_ciudad.setText(persona.getCiudad());
        txt_codigoPostal.setText(Integer.toString(persona.getCodigoPostal()));
        txt_cumplanos.setText(DateUtil.formato(persona.getCumplano()));
        txt_cumplanos.setPromptText("dd-mm-aaaa");
    }
    
    public boolean isOk(){
        return ok;
    }

    @FXML
    private void modificar(ActionEvent event) {
        if (isValido()) {
            persona.setApellido(txt_apellido.getText());
            persona.setNombre(txt_nombre.getText());
            persona.setCiudad(txt_ciudad.getText());
            persona.setDomicilio(txt_domicilio.getText());
            persona.setCodigoPostal(Integer.parseInt(txt_codigoPostal.getText()));
            persona.setCumplano(DateUtil.parse(txt_cumplanos.getText()));
            
            this.ok = true;
            stage.close();
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        stage.close();
    }

    private boolean isValido() {
        String mensajeError = "";
        
        if (mensajeError.isEmpty()) {
            return true;
        }else{
            Alert msj = new Alert(Alert.AlertType.ERROR);
            msj.setTitle("Registro invalido");
            msj.setContentText(mensajeError);
            msj.setHeaderText("Complete la información erronea");
            msj.show();
            return false;
        }
    }
}