
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class OrderPage extends BorderPane
{	
	ArrayList<Order> orderList;
	//Text 
	private Text storeName;
	private Text pizzaType;
	private Text toppings;
	
	//Buttons
	private Button sendOrder;
	
	//Radio Buttons
	private ToggleGroup toggleGroup;
	private RadioButton cheese;
	private RadioButton pepperoni;
	private RadioButton veggie;
	
	//Check Boxes
	private CheckBox extraCheese;
	private CheckBox mushroom;
	private CheckBox onion;
	private CheckBox olives;
	
	//Panes
	private HBox hbox;
	private GridPane gridpane;
	public static final int WINSIZE_X = 600, WINSIZE_Y = 300;
	
	
	public OrderPage(ArrayList<Order> orderList)
	{
		this.orderList = orderList;
		//Text 
		storeName = new Text("Sun Devil Pizza");
		pizzaType = new Text("Pizza Type");
		toppings = new Text("Toppings");
		//Text totalPrice = new Text("$0.00\t\t\t");
		
		//Buttons
		sendOrder = new Button("Submit");
		
		//Radio Buttons
		toggleGroup = new ToggleGroup();
		cheese = new RadioButton("Cheese");
		pepperoni = new RadioButton("Pepperoni");
		veggie = new RadioButton("Veggie");
		
		//Check Boxes
		extraCheese = new CheckBox("Extra Cheese");
		mushroom = new CheckBox("Mushroom");
		onion = new CheckBox("Onion");
		olives = new CheckBox("Olives");
		
		//Panes
	    hbox = new HBox();
	    gridpane = new GridPane();
		    
		    	    
	    //set up radio buttons in a toggle group
	    cheese.setToggleGroup(toggleGroup);
	    pepperoni.setToggleGroup(toggleGroup);
	    veggie.setToggleGroup(toggleGroup);
		    
		//set decimal format
	    //df.applyPattern("0.00");
	    
	    //set font of labels
	    storeName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 36));
	    storeName.setFill(Color.DARKRED);
	    
	    pizzaType.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    toppings.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    cheese.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    extraCheese.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    pepperoni.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    onion.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    olives.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    veggie.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    mushroom.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    sendOrder.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
	    
	    
		//add buttons to layout
		hbox.getChildren().add(sendOrder);
				
		gridpane.add(pizzaType, 0, 0);
		gridpane.add(cheese, 0, 1);
		gridpane.add(pepperoni, 0, 2);
		gridpane.add(veggie, 0, 3);	    
		    	    
		gridpane.add(toppings, 1, 0);
		gridpane.add(extraCheese, 1, 1);
		gridpane.add(mushroom, 1, 2);
		gridpane.add(olives, 1, 3);
		gridpane.add(onion, 1, 4);
		    
		gridpane.setHgap(25);
		gridpane.setVgap(5);
				   
		    
		//set alignment and color
		hbox.setAlignment(Pos.CENTER);
		gridpane.setAlignment(Pos.CENTER);
		storeName.setTextAlignment(TextAlignment.CENTER); 

		sendOrder.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		    
		//set up border pane
		this.setBottom(hbox);
		this.setTop(storeName);    
		this.setCenter(gridpane);
		
		//declare and initialize variables
		//DecimalFormat df = new DecimalFormat();
		
		sendOrder.setOnAction(new SendOrder());
		
	}
	
    
//connect button to action
//sendOrder.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() 
	private class SendOrder implements EventHandler<ActionEvent>
	{
	
		@Override
		public void handle(ActionEvent event) 
		{
			String pizzaTypeOrder = "";
			String pizzaToppings = "";
			double pizzaTypePrice = 0.00;
			double toppingPrice = 1.50;
			double total = 0.00;
			int count = 0;
			
			//which pizza type is chosen
			if(cheese.isSelected())
			{
				pizzaTypePrice = 10.00;
	        }
			else if(pepperoni.isSelected())
			{
				pizzaTypePrice = 12.00;
	        }
			else if(veggie.isSelected())
			{
				pizzaTypePrice = 15.00;
			}
	
			//count toppings chosen
			if(extraCheese.isSelected())
			{
				count++;
			}
			
			if(onion.isSelected())
			{
				count++;
			}
			
			if(mushroom.isSelected())
			{
				count++;
			}
			
			//calculation of prices
			total = pizzaTypePrice + (count * toppingPrice);
			//df.format(total);
			//totalPrice.setText("$" + (String.format("%.2f", total)) + "\t\t\t");
			
			orderList.add(new Order(pizzaTypeOrder, pizzaToppings, total));
			
			
		}//end of method
	        
	}		
	

}
