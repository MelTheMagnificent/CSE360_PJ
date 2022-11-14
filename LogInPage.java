import java.util.ArrayList;

import javafx.event.ActionEvent; //comment
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LogInPage extends BorderPane
{
	ArrayList<Integer> student;
	ArrayList<Integer> employee;
	
	//Text 
	private Text storeName;
	private Text id;
	private TextField enterId;
	private Text validity;
	
	//Buttons
	private Button submit;
	
	//Panes
	private HBox hbox;
	private VBox vbox;
	public static final int WINSIZE_X = 600, WINSIZE_Y = 300;
	
	
	public LogInPage(ArrayList<Integer> student, ArrayList<Integer> employee)
	{
		this.student = student;
		this.employee = employee;
		
		//Text 
		storeName = new Text("Sun Devil Pizza");
		id = new Text("Enter your ASU Student ID \nor your ASU Employee ID");
		enterId = new TextField("");
		validity = new Text("Enter a valid ASU ID");
		//Text totalPrice = new Text("$0.00\t\t\t");
		
		//Buttons
		submit = new Button("Submit");
		
		//Panes
	    hbox = new HBox();
	    vbox = new VBox();
		    
		//set decimal format
	    //df.applyPattern("0.00");
	    
	    //set font of labels
	    storeName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 36));
	    storeName.setFill(Color.DARKRED);
	    
	    id.setFont(Font.font("Time New Roman", FontWeight.NORMAL, 20));	 
	    validity.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
	    validity.setFill(Color.RED);
	    
		//add buttons to layout
	    hbox.getChildren().addAll(enterId, submit);
		vbox.getChildren().addAll(id, hbox, validity);
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		this.setTop(storeName);
		this.setCenter(vbox);
		//this.setBottom(validity);
		
		
		//declare and initialize variables
		//DecimalFormat df = new DecimalFormat();
		
		submit.setOnAction(new EnterId());	
	}
	
	private class EnterId implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) 
		{
			String valid = "Enter a valid ASU ID";
			String getId = enterId.getText();
			int num = Integer.parseInt(getId);
			
			for(int i = 0; i < student.size(); i++)
			{
				if(num == student.get(i))
				{
					valid = "Welcome Student!";
				}
			}
			
			for(int i = 0; i < employee.size(); i++)
			{
				if(num == employee.get(i))
				{
					valid = "Welcome Employee!";
				}
			}
			
			validity.setText(valid);
		}
	}
}
