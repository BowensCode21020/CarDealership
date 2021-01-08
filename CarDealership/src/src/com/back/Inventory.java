package src.com.back;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
	
	

	public Inventory() {};

	public ArrayList<Car> readFile() {
		String carFile = "C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\CarDirectory.txt";
		ArrayList<Car> carData = new ArrayList<Car>();

		try {
			Scanner hold = new Scanner(new File(carFile));

			while (hold.hasNextLine()) {
				// Begin read file

				String invent = hold.nextLine();
				String[] inventory = invent.split(", ");

				String carModel = inventory[0];

				String carMan = inventory[1];

				int carYear = Integer.parseInt(inventory[2]);

				double carPrice = Double.parseDouble(inventory[3]);

				String carColor = inventory[4];

				String carDescription = inventory[5];

				String carImage = inventory[6];

				double carMileage = Double.parseDouble(inventory[7]);

				String carCondition = inventory[8];

				String tempAvail = inventory[9];
				boolean available = false;
				if (tempAvail.equals("true")) {
					available = true;
				}

				LocalDate inventoryDate = LocalDate.parse(inventory[10]);
				String carVIN = inventory[11];
				
					LocalDate dateOfPurchase = LocalDate.parse(inventory[12]);
					
					int custID = Integer.parseInt(inventory[13]);
					
					Car car = new Car(carModel, carMan, carYear, carPrice, carColor, carDescription, carImage, carMileage,
							carCondition, available, inventoryDate, carVIN, dateOfPurchase, custID);
					// Add to file
					carData.add(car);				
					
			}
			hold.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot read file");
		} catch (NumberFormatException d) {
			System.out.println("Can't read number value");
		} catch (DateTimeParseException c) {
			System.out.println("Can't read the date");
		}
		
		// Return value
		return carData;
	}

	public ArrayList<Car> filterByUnsold() {
		ArrayList<Car> mainInventory = readFile();
		ArrayList<Car> unsold = new ArrayList<Car>();

		for (Car temp : mainInventory) {
			System.out.println(temp.isAvailable());
			if (temp.isAvailable()) {
				unsold.add(temp);
				
			}
		}
		return unsold;
	}

	public ArrayList<Car> filterBySold() {
		ArrayList<Car> mainInventory = readFile();
		ArrayList<Car> sold = new ArrayList<Car>();

		for (Car temp : mainInventory) {
			if (!temp.isAvailable()) {
				sold.add(temp);
			}
		}
		return sold;
	}
	
	public void updateDataFile(ArrayList<Car> cars) {
		String carFile = "C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\CarDirectory.txt";
		
		Path path = Paths.get(carFile);
		File file = new File(carFile);
		
		if(file.exists()) {
			try {
				for(int i = 0; i < 6; i++) {
					System.out.println("Slow Process");
					Thread.sleep(500);
					System.gc();
				}
				Files.delete(path);
				System.out.println("FILE DELETED");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("FILE NOT DELETED");
				e.printStackTrace();
			}
		}
		
		try {
			file.createNewFile();
			System.out.println("FILE CREATED");
		}
		catch(IOException e) {
			System.out.println("File failed to be created");
			e.printStackTrace();
		}
		int x = 1;
		for(Car car : cars) {
			try {
				System.out.println("Adding car #"+x);
				x++;
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(car.toString());
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	// Bidding cars can be sold at a discounted price up to 10% if and
	// only if the dealership's purchase date is over 120 days.
	public ArrayList<Double> filterByDiscount(ArrayList<Car> car) {
		//readFile();
		ArrayList<Double> tempDiscount = new ArrayList<Double>();

		for (Car tempDisc : readFile()) {

			if (tempDisc.isAvailable() == true) {
				tempDiscount.add(tempDisc.getDiscRate());
			}
		}
		return tempDiscount;
	}

	// A user should also be able to search for a type (model) car from the
	// inventory.

	public ArrayList<String> filterByModel(ArrayList<Car> car) {
		//readFile();
		ArrayList<String> modelCar = new ArrayList<String>();

		for (Car tempModel : readFile()) {
			if (!modelCar.contains(tempModel.getCarModel())) {
				modelCar.add(tempModel.getCarModel());
			}
		}
		return modelCar;
	}

	public ArrayList<String> filterByMake(ArrayList<Car> car) {
		ArrayList<String> makeCar = new ArrayList<String>();

		for (Car tempMake : readFile()) {
			if (!makeCar.contains(tempMake.getCarMan())) {
				makeCar.add(tempMake.getCarMan());
			}
		}
		return makeCar;
	}

	public ArrayList<Integer> filterByYear(ArrayList<Car> car) {
		ArrayList<Integer> yearCar = new ArrayList<Integer>();

		for (Car tempYear : readFile()) {
			if (yearCar.contains(tempYear.getYear())) {
				yearCar.add(tempYear.getCarYear());
			}

		}
		return yearCar;
	}

	public ArrayList<LocalDate> filterByDate(ArrayList<Car> car) {
		ArrayList<LocalDate> invDate = new ArrayList<LocalDate>();

		for (Car tempDate : readFile()) {
			if (invDate.contains(tempDate.getInventoryDate())) {
				invDate.add(tempDate.getInventoryDate());
			}
		}
		return invDate;
	}

	// The inventory should have an option to replenish the inventory
	// by adding pictures and details of a car.
	

	public String writeInventory (String newValue) {

		File fileNewTemp = new File("C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\CarDirectory.txt");

		try (FileWriter invFW = new FileWriter(fileNewTemp)) {

			if (fileNewTemp.exists() && fileNewTemp != null) {
			//	BufferedWriter findValue = new BufferedWriter(invFW);
			//	PrintWriter printValue = new PrintWriter(findValue);

				
				invFW.write(newValue);
				//printValue.flush();
				
			}
			invFW.close();
		} catch (IOException e) {
			System.out.println("Invalid Exception Occurred");
		}
		return newValue;
	}

}
