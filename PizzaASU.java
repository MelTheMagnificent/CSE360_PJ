
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;
	
public class PizzaASU extends Application
{
	private TabPane tabPane;
	private OrderPage orderPage;
	private LogInPage logInPage;
	ArrayList<Order> orderList;
	ArrayList<Integer> employeeLogIn;
	ArrayList<Integer> studentLogIn;
	
	public void start(Stage primaryStage) {
		
		StackPane root = new StackPane();
		tabPane = new TabPane();
		//logInList.add(new LogIn(123456789));
		orderList = new ArrayList<Order>();
		employeeLogIn = new ArrayList<Integer>();
		studentLogIn = new ArrayList<Integer>();
		
		employeeLogIn.add(12345);
		employeeLogIn.add(36283);
		employeeLogIn.add(52637);
		
		studentLogIn.add(1829373);
		studentLogIn.add(3947024);
		studentLogIn.add(4820837);
		
		orderPage = new OrderPage(orderList);
		logInPage = new LogInPage(studentLogIn, employeeLogIn);		
		
		//declare and initialize variables
		//DecimalFormat df = new DecimalFormat();
		
		Tab tab1 = new Tab();
		tab1.setText("Order");
		tab1.setContent(orderPage);
		
		Tab tab2 = new Tab();
		tab2.setText("Log In");
		tab2.setContent(logInPage);
		
	    tabPane.getSelectionModel().select(0);
	    tabPane.getTabs().addAll(tab1, tab2);

	    root.getChildren().add(tabPane);
		
		//set the scene upon the stage
	    Scene scene = new Scene(root, 600, 300);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	}//end of Stage

	public static void main(String[] args) 
	{
	    launch(args);
	}

}
