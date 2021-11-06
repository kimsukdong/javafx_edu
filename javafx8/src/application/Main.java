package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static Stage primaryStage;
	String uname="", upass="";
	
	public void set_txt(String uname, String upass) {
		this.uname=uname;
		this.upass=upass;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;
			showMainView();	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showMainView() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			InputStream stream = new FileInputStream("c:/util/hoseo.jpg");
			Image image = new Image(stream);
			primaryStage.getIcons().add(image);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("login");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
