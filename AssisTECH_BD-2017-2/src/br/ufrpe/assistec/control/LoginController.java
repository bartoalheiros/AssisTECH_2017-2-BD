package br.ufrpe.assistec.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.ufrpe.assistec.exception.NomeDeUsuarioOuSenhaInvalidaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable{
	@FXML private TextField txtUserName;
	@FXML private PasswordField pswdF;
	@FXML private Button btnAcessar;
	@FXML private ComboBox<String> privilegio;
	ServidorAssisTech svr = ServidorAssisTech.getInstance();
	ObservableList<String> list = FXCollections.observableArrayList("Cliente", "Técnico", "Funcionário");


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		privilegio.setItems(list);

	}

	@FXML public void ckLoginData(ActionEvent event) throws IOException {
		String usrName = new String(txtUserName.getText());
		String pswd = new String(pswdF.getText());

		
			String valor = privilegio.getValue();
			System.out.println(valor);


			if(privilegio.getValue().equals("Cliente")){
				try {

					svr.buscarClientePorLogin(usrName, pswd);
					this.janelaPrincipal(event);
				} catch (NomeDeUsuarioOuSenhaInvalidaException e) {
					Alert err = new Alert(AlertType.ERROR);
					err.setContentText(e.getMessage());
					err.showAndWait();
				}

			}else {
				Alert err = new Alert(AlertType.ERROR);
				err.setContentText("Escolha um nível de privilégio!");
				err.showAndWait();
			}
		

	}//Fim do método chkLoginData

	//carrega a janela principal do aplicativo
	private void janelaPrincipal(ActionEvent event) throws IOException {
		((Node)event.getSource()).getScene().getWindow().hide();
		Parent parent = FXMLLoader.load(getClass().getResource("../view/Janela1.fxml"));
		Stage stage = new Stage();
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("AssisTech");
		stage.setResizable(false);
		stage.show();
	}
}
