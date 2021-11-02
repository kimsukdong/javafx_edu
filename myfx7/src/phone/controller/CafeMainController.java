package phone.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import phone.mysqlconnect;
import phone.Main;

public class CafeMainController {
	Main main = new Main();
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	Window owner;

	@FXML
	private ComboBox<String> comboType;
	@FXML
	private AnchorPane loginpane;
	@FXML
	private AnchorPane lblpane;
	@FXML
	private Label lbl_welcome;
	@FXML
	private TextField txt_username;

	@FXML
	private PasswordField txt_password;

	@FXML
	private VBox logo;
	@FXML
	private void initialize() {
		comboType.getItems().addAll("판매담당","관리자","임원");
		txt_username.setText(Main.main_username);
		txt_password.setText(Main.main_password);

		if(Main.sw.equals("on")) {
			String s1 = "안녕하세요? " +Main.main_username+ " 님 !!!";
			loginpane.setVisible(false);
			lbl_welcome.setText(s1);
			lblpane.setVisible(true);
		}
	}
	@FXML
	void onClickType(ActionEvent event) {

	}
	@FXML
	void onClickLogin(ActionEvent event) {   	
		conn = mysqlconnect.ConnectDb();
		String sql = "SELECT * FROM users WHERE username = ? AND password=?";
		if(comboType.getValue() == null) {
			JOptionPane.showMessageDialog(null,"Try to select ComboBox");
			return;
		}
		else 
			Main.position = comboType.getValue().toString();    	
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, txt_username.getText());
			pst.setString(2, txt_password.getText());
			rs = pst.executeQuery();			
			if(rs.next()) {
				Main.sw = "on";
				String s1 = "안녕하세요? " + Main.main_username + " 님 !!!";
				JOptionPane.showMessageDialog(null,s1);
				loginpane.setVisible(false);
				lbl_welcome.setText(s1);
				lblpane.setVisible(true);


			} else {
				JOptionPane.showMessageDialog(null,"Try to another Username or Password");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void onClickLogout(ActionEvent event) {
		loginpane.setVisible(true);
		lblpane.setVisible(false);
		Main.sw = "off";

	}
	@FXML
	void onClickSignup(ActionEvent event) {
		JOptionPane.showMessageDialog(null,"Comming soon !");
	}

	@FXML
	void onClickOrder(ActionEvent event) throws IOException {
		if(Main.sw.equals("on") && ((Main.position.equals("판매담당"))||(Main.position.equals("임원")))) {				
			AnchorPane root = FXMLLoader.load(getClass().getResource("/phone/view/CafeMenu.fxml"));
			Scene scene = new Scene(root,1500,800);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
			Main.primaryStage.setTitle("주문 화면");
		} 
		else
		{
			JOptionPane.showMessageDialog(null,"Try to another Username or position !!!");
			return;
		}

	}

	@FXML
	void onClickStatistic(ActionEvent event) throws IOException {
		if(Main.sw.equals("on") && ((Main.position.equals("관리자"))||(Main.position.equals("임원")))) {		
			AnchorPane root = FXMLLoader.load(getClass().getResource("/phone/view/CafeView.fxml"));
			Scene scene = new Scene(root,1500,800);
			Main.primaryStage.setScene(scene);
			Main.primaryStage.show();
			Main.primaryStage.setTitle("통계 화면");
			
			
		} 
		else
		{
			JOptionPane.showMessageDialog(null,"Try to another Username or position !!!");
			return;
		}
	}
}

