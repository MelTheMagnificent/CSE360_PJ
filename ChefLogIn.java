import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ChefLogIn extends BorderPane
{
	//ArrayList<Integer> student; 
	ArrayList<Integer> employee;
	ArrayList<OrderingStudent> ordering;
	ArrayList<OrderingStudent> completed;
	//private Order order;
	
	//boolean to check if submit button was pressed
	private boolean checkSubmit;
	
	//Text 
	private Text storeName;
	private Text id;
	private TextField enterId;
	private Text validity;
	
	//Buttons
	private Button submit;
	private Button loadOrder;
	private Button finished;
	private Button currently;
	private Button chooseOrder;
	
	//Panes
	private HBox hbox;
	private VBox vbox;
	private HBox hb3;
	private VBox hb2;
	private VBox hb1;
	
	private Text orderTF;
	private Text forPending;
	private Text forSent;
	
	private ComboBox<String> currentOrders;
	private ComboBox<String> readyOrders;

	private ToggleGroup tg;
	private RadioButton rb;
	
	
	public static final int WINSIZE_X = 600, WINSIZE_Y = 300;
	
	
	public ChefLogIn(ArrayList<Integer> employee, ArrayList<OrderingStudent> ordering, ArrayList<OrderingStudent> completed)
	{
		//this.student = student;
		this.completed = completed;
		this.employee = employee;
		this.ordering = ordering;
		checkSubmit = false;
		
		
		currentOrders = new ComboBox<String>(); //has current orders that chef can see
		readyOrders = new ComboBox<String>();	//has ready orders that chef finished
		
		currentOrders.setValue("Current Orders");
		readyOrders.setValue("Ready Orders");
		rb = new RadioButton("Order" + ordering.size());
		chooseOrder = new Button("Choose Order");
		
		//Text 
		storeName = new Text("Sun Devil Pizza");
		id = new Text("Enter your ASU Employee ID");
		enterId = new TextField("");
		validity = new Text("Enter a valid ASU ID");
		orderTF = new Text("");
		forPending = new Text("");
		forSent = new Text("");
		
		//Buttons
		submit = new Button("Submit");
		loadOrder = new Button("Ready Orders");
		finished = new Button("Ready for pickup");
		currently = new Button("New/In Progress");
		
		//Panes
	    hbox = new HBox();
	    vbox = new VBox();
		
	    hb1 = new VBox();
	    hb2 = new VBox();
	    hb3 = new HBox();
		
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
		
		hb3.getChildren().addAll(hb1, hb2);
		hb3.setSpacing(30);
		hb3.setPadding(new Insets(20));
		
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		this.setTop(storeName);
		this.setCenter(vbox);
		//this.setBottom(validity);
		
		
		submit.setOnAction(new EnterId());	
		loadOrder.setOnAction(new LoadOrdersButtonHandler());
		
	}
	
	private class EnterId implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) 
		{
			String valid = "Enter a valid ASU ID";
			String getId = enterId.getText();
			int num = Integer.parseInt(getId);
			
			for(int i = 0; i < employee.size(); i++)
			{
				if(num == employee.get(i))
				{
					checkSubmit = true;
					//valid = "Welcome Chef!";
				}
			}
			
			/*
			//this is where I am starting from now
			if(valid.equalsIgnoreCase("Welcome chef!"))
			{
				checkSubmit = true;
			}//end of if chef	
			*/
			validity.setText(valid);
			
			if(checkSubmit == true)
			{
				hbox.getChildren().clear();
				vbox.getChildren().clear();
				
				if(ordering.size() >= 1) //fix this part because for some reason it will not do anything
				{
					hb1.getChildren().clear();
					CheckBox checkIt;
									
					String tots = "No orders at this time";
					for(int i = 0; i < ordering.size(); i++)
					{
						String nHero = ordering.get(i).getOrderNum() + "\n" + ordering.get(i).getOrder().toString(); //declare and initialize string to store hero data
						checkIt = new CheckBox(nHero); //initialize checkBox
						//bind checkBoxes to CheckBoxHandler
						checkIt.setOnAction(new CompletedOrder(ordering.get(i).getOrderNum())); 
						//add checkBox to vbox
						hb1.getChildren().add(checkIt);
					}
					orderTF.setText(tots);
				}
				else
				{
					orderTF.setText("No orders at this time");
				}
				
				
				hb1.getChildren().clear();
				hb2.getChildren().clear();
				hb3.getChildren().clear();
				hbox.getChildren().clear();
				vbox.getChildren().clear();
				
				//hb2.getChildren().add(orderTF);	
				//hb1.getChildren().addAll(forPending);
				//hb3.getChildren().addAll(hb1, hb2);
				
				hbox.getChildren().addAll(orderTF);
				vbox.getChildren().addAll(hbox, loadOrder);
			}
			
		}//end of handle
	}//end of enterId
	
	
	
	//this class changes the size of the combo box to add more stuff
	private class LoadOrdersButtonHandler implements EventHandler<ActionEvent> 
	{

		@Override
		public void handle(ActionEvent event) 
		{
//			if(ordering.size() >= 1) 
//			{
//				hb1.getChildren().clear();
//				
//				String tots = "";
//				for(int i = 0; i < ordering.size(); i++)
//				{
//					tots = tots + "Order #" + i + ordering.get(i).toString();
//				}				
//				orderTF.setText(tots);
//			}
//			else
//			{
//				orderTF.setText("No orders at this time");
//			}
//			
		if(ordering.size() >= 1) 
		{
			hbox.getChildren().clear();
			CheckBox checkIt;
							
			String tots = "No ORDERS at this time";
			for(int i = 0; i < ordering.size(); i++)
			{
				String nHero = "Order #" + ordering.get(i).getOrderNum() + "\n" + ordering.get(i).getOrder().toString(); //declare and initialize string to store hero data
				checkIt = new CheckBox(nHero); //initialize checkBox
				//bind checkBoxes to CheckBoxHandler
				checkIt.setOnAction(new CompletedOrder(ordering.get(i).getOrderNum())); 
				//add checkBox to vbox
				hbox.getChildren().add(checkIt);
			}
			orderTF.setText(tots);
		}
		else
		{
			orderTF.setText("No orders at this time");
		}
		}//end of public void handle
	}//end of private class LoadHeroesButtonHandler
	
	private class CompletedOrder implements EventHandler<ActionEvent> 
	{
		private int order;

		public CompletedOrder(int order) 
		{
			this.order = order;
		}//end of public CheckBoxHandler

		@Override
		public void handle(ActionEvent event) 
		{
			CheckBox cBox = (CheckBox) event.getSource(); 
			// ^^^^^^ 7. a) ^^^^^^
			
			// TODO: 7. b) If the CheckBox was selected, add the current hero scores to totalStrength, 
			// 	totalCharisma, and totalDamge. Otherwise, subtract the current hero scores
			// vvvvvv 7. b) vvvvvv (about 8-12 lines)
			//begin if-else statement to run depending on if a hero's box is checked
			if(cBox.isSelected()) //if hero checkBox is selected
			{
				ordering.remove(order - 1);				
			}	

			hb1.getChildren().clear();
			CheckBox checkIt;
							
			String tots = "No orders at this time";
			for(int i = 0; i < ordering.size(); i++)
			{
				String nHero = ordering.get(i).getOrderNum() + "\n" + ordering.get(i).getOrder().toString(); //declare and initialize string to store hero data
				checkIt = new CheckBox(nHero); //initialize checkBox
				//bind checkBoxes to CheckBoxHandler
				checkIt.setOnAction(new CompletedOrder(ordering.get(i).getOrderNum())); 
				//add checkBox to vbox
				hb1.getChildren().add(checkIt);
			}
			orderTF.setText(tots);
			
			// ^^^^^^ 7. c) ^^^^^^

			
		}//end of public void handle
	}//end of private class LoadHeroesButtonHandler
	
	
}

