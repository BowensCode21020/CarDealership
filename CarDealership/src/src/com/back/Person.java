package src.com.back;

import java.time.LocalDate;

public class Person {
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String message;
	private int custID;

	// card info
	private long cardNumber;
	private int cvv;
	private int expirationMonth;
	private int expirationYear;
	private int index = 0;
	
	
	// User login info
	private String password;
	private String username;
	
	
	public Person() {
		super();
		this.custID = setCustID();
	};

	
	public Person(String firstName, String lastName, String street, String city, String state, int zip, long phoneNumber, long cardNumber, int cvv, int expirationMonth,
			int expirationYear, String password, 
			String username, int custID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expirationMonth = expirationMonth;
		this.password = password;
		this.username = username;

		this.expirationYear = expirationYear;
		this.custID = custID;
	}



	
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public int getExpirationMonth() {
		return expirationMonth;
	}
	public void setExpirationMonth(int expirationMonth) {
		this.expirationMonth = expirationMonth;
	}
	public int getExpirationYear() {
		return expirationYear;
	}
	public void setExpirationYear(int expirationYear) {
		this.expirationYear = expirationYear;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return this.firstName +
				", " + this.lastName +
				", " + this.street +
				", " + this.city +
				", " + this.state +
				", " + this.zip +
				", " + this.phoneNumber +
				", " + this.cardNumber +
				", " + this.cvv +
				", " + this.expirationMonth +
				", " + this.expirationYear +
				", " + this.password +
				", " + this.username +
				", " + this.custID +
				System.lineSeparator();
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public int getCustID() {
		return custID;
	}
	
	// Assign a random ID number to connect
	// and relate files/databases
	public int setCustID() {
		
		int temp = index;
		
		int randomNumber = (int) (Math.random() * Math.pow(7,  6));
		int custID = temp + randomNumber;
		
		return custID;
	}


}
