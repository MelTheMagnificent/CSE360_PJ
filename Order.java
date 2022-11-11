
public class Order 
{
	private String pizza;
	private String toppings;
	private double cost;
	
	public Order(String pizza, String toppings, double cost)
	{
		this.pizza = pizza;
		this.toppings = toppings;
		this.cost = cost;
	}
	
	public Order()
	{
		this(null, null, 0);
	}
	
	public String getPizza()
	{
		return pizza;
	}	
	
	public void setPizza(String pizza)
	{
		this.pizza = pizza;
	}
	
	public String getToppings()
	{
		return toppings;
	}	
	
	public void setToppings(String toppings)
	{
		this.toppings = toppings;
	}
	
	public double getcost()
	{
		return cost;
	}	
	
	public void setPizza(double cost)
	{
		this.cost = cost;
	}

	public String toString() {
		return String.format("Pizza Type: %s\nToppings: %s\nCost: %d\n", 
							this.pizza, this.toppings, this.cost);		
	}
	
}
