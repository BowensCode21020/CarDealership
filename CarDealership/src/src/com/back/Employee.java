package src.com.back;

public class Employee {
	private String salesUserName;
	private String salesPassword;
	private String salesID;
	static int index = 100;
	
	
	public Employee() {
		super();
		this.salesID = setSalesID();
	}
	
	public Employee(String salesUserName, String salesPassword, String salesID) {
		super();
		this.salesUserName = salesUserName;
		this.salesPassword = salesPassword;
		this.salesID = salesID;
		this.salesUserName = salesUserName;
		this.salesPassword = salesPassword;
		
		
		this.salesID = setSalesID();
	}
	
	public String getSalesUserName() {
		return salesUserName;
	}
	public void setSalesUserName(String salesUserName) {
		this.salesUserName = salesUserName;
	}
	public String getSalesPassword() {
		return salesPassword;
	}
	public void setSalesPassword(String salesPassword) {
		this.salesPassword = salesPassword;
	}

	public String setSalesID() {
		
		int temp = index;
		
		int randomNumber = (int) (Math.random() * Math.pow(7, 3));
		
		String salesID = Integer.toString(temp + randomNumber);
		return salesID;
	}
	
	public String getSalesID() {
		return salesID;
	}

}
