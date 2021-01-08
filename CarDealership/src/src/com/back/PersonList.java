package src.com.back;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonList {

	public ArrayList<Person> readPerson() {
		String personFile = "C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\PersonList.txt";
		ArrayList<Person> personData = new ArrayList<Person>();

		try {
			Scanner hold = new Scanner(new File(personFile));

			while (hold.hasNextLine()) {
				String invent = hold.nextLine();
				String[] inventory = invent.split(", ");

					String firstName = inventory[0];

					String lastName = inventory[1];

					String street = inventory[2];
					
					String city = inventory[3];
					
					String state = inventory[4];
					
					int zip = Integer.parseInt(inventory[5]);

					long phoneNumber = Long.parseLong(inventory[6]);

					long cardNumber = Long.parseLong(inventory[7]);

					int cvv = Integer.parseInt(inventory[8]);

					int expirationMonth = Integer.parseInt(inventory[9]);

					int expirationYear = Integer.parseInt(inventory[10]);
					
					String password = inventory[11];

					String username = inventory[12];
					
					int custID = Integer.parseInt(inventory[13]);
							

					Person sold = new Person(firstName, lastName, street, city, state, zip, phoneNumber,
							cardNumber, cvv, expirationMonth, expirationYear, password, username, custID);

					personData.add(sold);
					System.out.println(sold.toString());

				}

			
		} catch (FileNotFoundException e) {
			System.out.println("Cannot read file");
		} catch (NumberFormatException d) {
			System.out.println("Can't read number value");
		} catch (DateTimeParseException c) {
			System.out.println("Can't read the date");
		}
		return personData;
	}
	
	public void updatePersonFile(ArrayList<Person> persons) {
		String personFile = "C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\PersonList.txt";
		
		System.out.println("UPDATING PERSON FILE");
		
		Path path = Paths.get(personFile);
		File file = new File(personFile);
		
		if(file.exists()) {
			try {
				for(int i = 0; i < 6; i++) {
					Thread.sleep(500);
					System.gc();
				}
				Files.delete(path);
				System.out.println("FILE DELETED");
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("FILE NOT DELTED");
				e.printStackTrace();
			}
		}
		try {
			file.createNewFile();
			System.out.println("file created");
		}
		catch(IOException e) {
			System.out.println("File failed to be created");
			e.printStackTrace();
		}
		
		for(Person person : persons) {
			FileWriter fw;
			try {
				fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(person.toString());
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		
		
	}
	
	public String writePerson (String newValue) {

		File fileNewTemp = new File("C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\PersonList.txt");

		try (FileWriter invFW = new FileWriter(fileNewTemp)) {

			if (fileNewTemp.exists() && fileNewTemp != null) {
//				BufferedWriter findValue = new BufferedWriter(invFW);
//				PrintWriter printValue = new PrintWriter(findValue);

				invFW.write(newValue);
				invFW.close();
			}
		} catch (IOException e) {
			System.out.println("Invalid Exception Occurred");
		}
		return newValue;
	}
	
}
