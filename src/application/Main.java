package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


///////////////////// 로그인 페이지
public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			//Label Node
			Label lName = new Label("아이디 : ");
			Label lpassword = new Label("비밀번호 : ");
			Label lmessage = new Label();
			
			
			// Field Node
			TextField tfName = new TextField();
			PasswordField pfPassword = new PasswordField();
			
			//Button Node
			Button btn1 = new Button("log in");
			btn1.prefHeightProperty().bind(lName.heightProperty().add(lpassword.heightProperty()));
			btn1.setOnAction(e->{
				lmessage.setStyle("-fx-text-fill:red;");
				String name = tfName.getText();
				String password = pfPassword.getText();
				
				if(name.equals("")){
					lmessage.setText("please enter your name");
					
				}else if(password.equals("")){
					lmessage.setText("please enter your password");
				} else if(!name.equals("min") || !password.equals("1234")){
					lmessage.setText("Invaild id or password");
				} else{
					lmessage.setStyle("-fx-text-fill:green;");
					lmessage.setText("Welcome");
				}
				
				
				
			});
			
			
			//grid Container
			GridPane grid = new GridPane();
			grid.addRow(0, lName, tfName);
			grid.addRow(1, lpassword,pfPassword);
			grid.add(btn1, 2, 0, 2, 2);
			grid.add(lmessage, 0, 3,3,1);
			grid.setAlignment(Pos.CENTER);
			
			//StackPane
			StackPane pane = new StackPane();
			pane.getChildren().add(grid);
			
			
			//Scene
			Scene scene = new Scene(pane,800,500);
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
