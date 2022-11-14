
public class OrderingStudent 
{
	private int orderNum;
	private Student st;
	private Order od;
	
	public OrderingStudent(int orderNum, Student st, Order od)
	{
		this.orderNum = orderNum;
		this.st = st;
		this.od = od;
	}
	
	public int getOrderNum()
	{
		return orderNum;
	}
	
	public Student getStudent()
	{
		return st;
	}
	
	public Order getOrder() 
	{
		return od;
	}
	
}
