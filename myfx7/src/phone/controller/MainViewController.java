package phone.controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import phone.Main;

public class MainViewController {
	Main main= new Main();
	@FXML
	Parent root;
	@FXML
	void onClickOne(ActionEvent event) {
		if(Main.login.equals("ON")) {
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/MainView2.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("林家废 包府");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickSep(ActionEvent event) {
		if(Main.login.equals("ON")) {
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/MainView3.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("林家废 包府");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}
	@FXML
	void onClickCafe(ActionEvent event) {
		if(Main.login.equals("ON")) {
			main.showMainView();
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/CafeMain.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("墨其 包府");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickPizza(ActionEvent event) {
		if(Main.login.equals("ON")) {
			main.showMainView();
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/PizzaMain.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("乔磊 包府");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickBus(ActionEvent event) {
		if(Main.login.equals("ON")) {
			main.showMainView();
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/BusMain.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("滚胶 抗距 包府");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickClose(ActionEvent event) {
		System.exit(0);
	}
	@FXML
	void onClickgohome(ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/phone/view/MainItem.fxml"));
			Main.mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	@FXML
	void onClickHome(ActionEvent event) {
		if(Main.login.equals("ON")) {
			try {
				root = FXMLLoader.load(getClass().getResource("/phone/view/MainItem.fxml"));
				Main.mainLayout.setCenter(root);
				Main.setPrimaryStage("烹钦 包府");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "First, You must do login !");
		}
	}

	@FXML
	void onClickHelp(ActionEvent event) {
		// JOptionPane.showMessageDialog(null,"It's a 4 programs. Address, Bus Stop, Cafe, Pizza Restaurant.");
		infoBox("We have four programs. There are Address, Bus Stop, Cafe, Pizza.",null,"Help");
	}
	public static void infoBox(String infoMessage, String headerText, String title) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(infoMessage);
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.showAndWait();    	
	}

	@FXML
	void onClickStop(ActionEvent event) {
		System.exit(0);
	}

}