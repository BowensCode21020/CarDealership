package src.com.back;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Car {
	
	// Declare variables and set certain parameters
	private String carMan;
	private String carModel;
	private String carColor;
	private String carDescription;
	public String getCarDescription() {
		return carDescription;
	}
	private LocalDate dateOfPurchase;

	

	private String carCondition;
	private String carImage;
	private boolean available = false;
	private LocalDate inventoryDate;
	int index = 100;
	
	private int daysUntilBid = 120;
	private int carYear;
	private double carMileage;


	private double carPrice;
	private double discRate;
	private double bidPrice;
	private String carVIN;
	private int custID;
	
	//Constructor
	public Car() {};

	public Car(String carModel, String carMan, int carYear, double carPrice, String carColor, 
			String carDescription, String carImage, double carMileage, String carCondition, 
			boolean available, LocalDate inventoryDate, String carVIN, LocalDate dateOfPurchase,
			int custID) {
		super();
		this.carMan = carMan;
		this.carModel = carModel;
		this.carColor = carColor;
		this.carDescription = carDescription;
		this.carCondition = carCondition;
		this.dateOfPurchase = dateOfPurchase;
		this.carImage = carImage;
		this.available = available;
		this.inventoryDate = inventoryDate;
		this.carYear = carYear;
		this.carMileage = carMileage;
		this.carPrice = carPrice;
		this.carVIN = carVIN;
		this.custID = custID;
	}

	// If a car is sitting in inventory for more than 120 days, 
	// there is to be an option to place a bid on the car.
	

	//
	// The inventory should have minimum 3 cars with idle days of 120+.
	public boolean isBidWorthy() {
		
		LocalDate bidDate = this.inventoryDate.plusDays(daysUntilBid);
		
		// Set the discount rate within the boolean to be used
		if (LocalDate.now().isAfter(bidDate)) {
			double holdDifference = this.carPrice * 0.10;
			this.bidPrice = ((this.carPrice - holdDifference) * 100) / 100.0;
			return true;
		}
		return false;
	}

	public String getCarCondition() {
		return carCondition;
	}

	public void setCarCondition(String carCondition) {
		this.carCondition = carCondition;
	}
	
	public String getCarMan() {
		return carMan;
	}

	public void setCarMan(String carMan) {
		this.carMan = carMan;
	}

	public int getCarYear() {
		return this.carYear;
	}
	
	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}
	
	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public double getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(double carMileage) {
		this.carMileage = carMileage;
	}

	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public int getYear() {
		GregorianCalendar carCalendar = new GregorianCalendar();
		return (carCalendar.get(Calendar.YEAR) - carYear);
	}

	@Override
	public String toString() {
		return  this.carModel +
				", " + this.carMan +
				", " + this.carYear +
				", " + this.carPrice +
				", " + this.carColor +
				", " + this.carDescription +
				", " + this.carImage +
				", " + this.carMileage +
				", " + this.carCondition +
				", " + this.available + 
				", " + this.inventoryDate +
				", " + this.carVIN +
				", " + this.dateOfPurchase +
				", " + this.custID
				+ System.lineSeparator();
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setavailable(boolean available) {
		this.available = available;
	}

	public LocalDate getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(LocalDate inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public double getDiscRate() {
		return discRate;
	}

	public void setDiscRate(double discRate) {
		double tempPrice = carPrice;
		double discount = 0.10;
		double findDiscRate = tempPrice * discount; 
		this.discRate = (double) findDiscRate;
	}

	public String getcarVIN() {
		return carVIN;
	}

	public String setcarVIN(String carVIN) {
		return this.carVIN = carVIN;
	}

	
	public double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}

	public int getDaysUntilBid() {
		return daysUntilBid;
	}

	public void setDaysUntilBid(int daysUntilBid) {
		this.daysUntilBid = daysUntilBid;
	}

	public String getCarVIN() {
		return carVIN;
	}

	public void setCarVIN(String carVIN) {
		this.carVIN = carVIN;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getCarImage() {
		return this.carImage;
	}
	
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	
	// to be used in a possible update, a bidding option and value
	
//	public double biddingWar(double[] setBid, double bidPrice) {
//		double bid = -1;
//				
//		for (int i = 0; i < setBid.length; i++) {
//			if (bidPrice - setBid[i] >= 0 && setBid[i] > bid) {
//				bid = setBid[i];
//			}
//		}
//		
//		return bid;
//	}

	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		
		this.dateOfPurchase = dateOfPurchase;
	}
	
	
}
