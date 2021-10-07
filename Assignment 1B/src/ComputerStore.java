/**
 * ---------------------------------------------------------------------------
 * Assignment 1
 * @author Harshil
 * @author Parth
 * written by: (Harshil Patel - 40163431 , Parth Navsariwala - 40178800)
 * ---------------------------------------------------------------------------
 */


/**
 * This program has a ComputerStore class which provides the functionality of inventory management of computers.
 * Along with adding computer info, user can also edit information of computers already in the store, display list
 * of computers of a particular brands or list of computers below certain price.
 */



import java.util.Scanner;


class ComputerStore {
	
	Computer computers[];
	static int counter = 0;
	int capacity;
	
	
	public ComputerStore() {
		computers = new Computer[10];
		capacity = 10;
	}
	
	public ComputerStore(int capacity) {
		computers = new Computer[capacity];
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getCountOfComputers() {
		return counter;
	}

	//Method to check if password is correct or not
	public boolean passwordChecker() {
		
		Scanner sc = new Scanner(System.in);
		int passwordCount = 0;
		
		do 
		{
			System.out.print("\nEnter Password: ");
			String ps = sc.nextLine();
			
			
			if(ps.equals("password")) 
			{
				return true;
			}
			else
			{
				System.out.println("Wrong Password");
				++passwordCount;
			}
			
		}while(passwordCount < 3);

		System.out.println("\nWrong Password entered 3 times, returning to main menu.\n");

		return false;
	}
	
	
	//Method to add computer info to the computer store
	public void addComputer() {
		
		if(!passwordChecker())
			return;
		
		
		Scanner sc = new Scanner(System.in);
		
		String brand = null, model = null;
		long serialNumber = 0;
		double price = 0;

		if(capacity == counter)
		{
			System.out.println("Computer Store is full, no more computers can be added\n");
			return;
		}


		System.out.println("How many computers you want to enter?");
		int num_com = sc.nextInt();
		sc.nextLine();

		while(num_com > (capacity - counter))
		{
			System.out.println("Entered number is greater than capacity of the Computer Store, you can only add " + (capacity - counter) + " computers");
			System.out.println("How many computers you want to enter?");
			num_com = sc.nextInt();
			sc.nextLine();
		}
		
		
		for (int i = 0; i < num_com; i++) {
			System.out.println("\n\nEnter Details of Computer " + i + " :\n");
			
			System.out.println("Enter Brand of Computer");
			brand = sc.nextLine();
			System.out.println("Enter Model of Computer");
			model = sc.nextLine();
			System.out.println("Enter Serial Number Of Computer");
			serialNumber = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Price of Computer");
			price = sc.nextDouble();
			sc.nextLine();
			
			computers[counter] = new Computer();
			computers[counter].setBrand(brand);
			computers[counter].setModel(model);
			computers[counter].setSN(serialNumber);
			computers[counter].setPrice(price);
			counter++;
			
		}

	}


	//method to edit information of existing computer in the computer store
	public void editComputer(int index) {
		
		if(!passwordChecker())
			return;
		
		Scanner sc = new Scanner(System.in);
		int choice = 1;
				
		System.out.println("\nComputer # " + index +
						   "\nBrand: " + computers[index].getBrand() +
						   "\nModel: " + computers[index].getModel() +
						   "\nSN: " + computers[index].getSN() +
						   "\nPrice: " + computers[index].getPrice());


		while (1 <= choice && choice < 5)
		{
			System.out.println("\nWhat information would you like to change?" +
					   "\n1. Brand" + 
				       "\n2. Model" +
				       "\n3. SN" +
				       "\n4. Price" +
				       "\n5. Quit" +
					   "\nEnter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
		
			if(!(1 <= choice && choice <= 5))
			{
				System.out.println("\nEnter Valid choice from 1 to 5 ");
				choice = 1;
			}
			else
			{
				switch(choice) 
				{
					case 1:
						System.out.println("\nEnter updated Brand Name:  ");
						computers[index].setBrand(sc.nextLine());
						break;
					case 2:
						System.out.println("\nEnter updated Model Name:  ");
						computers[index].setModel(sc.nextLine());
						break;
						
					case 3:
						System.out.println("\nEnter updated Serial Number:  ");
						computers[index].setSN(sc.nextLong());
						sc.nextLine();
						break;
						
					case 4:
						System.out.println("\nEnter updated Price:  ");
						computers[index].setPrice(sc.nextDouble());
						sc.nextLine();
						break;
						
					case 5:
						break;
	
					default:
						break;
				}
			}
		}

	}


	//method to display all computers of a specific brand
	public void displayComputerByBrand(String computerBrand) {
		int flag = 0;
		for(Computer computer : computers) {
			if(computer != null && computer.getBrand().equals(computerBrand))
			{
				System.out.println(computer);
				flag = 1;
			}			
		}

		if(flag == 0){
			System.out.println("No computers by that brand name exists.");
		}
	}


	//method to display computers with price lesser than certain value
	public void displayComputerCheaperThan(double computerPrice) {
		int flag = 0;
		for(Computer computer : computers) {
			if(computer != null && computer.getPrice() < computerPrice)
			{
				System.out.println(computer);
				flag = 1;
			}			
		}

		if(flag == 0){
			System.out.println("No computers below that price exists.");
		}
	}
	

	//Driver function
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome To Computer Shop");
		System.out.println("WELCOME\nEnter the maximum number of computers your store can own :");
		int capacity = sc.nextInt();
		sc.nextLine();
		
		ComputerStore computerStore = new ComputerStore(capacity);
		int userChoice = 1;
		
		while ((userChoice > 0 && userChoice < 5))
		{
			
			System.out.println("\nWhat do you want to do?");
			System.out.println("1. Enter new computers (password required)");
			System.out.println("2. Change information of a computer (password required)");
			System.out.println("3. Display all computers by a specific brand");
			System.out.println("4. Display all computers under a certain a price.");
			System.out.println("5. Quit");
			System.out.println("Please Enter Your Choice >");
			userChoice = sc.nextInt();
			sc.nextLine();
		
			switch (userChoice) {
				case 1:
					computerStore.addComputer();
					break;
					
				case 2:
					System.out.println("Please enter computer index number:");
					int index = sc.nextInt();
					sc.nextLine();
					computerStore.editComputer(index);
					break;
					
				case 3:
					System.out.println("Please enter computer brand name:");
					String brand = sc.nextLine();
					computerStore.displayComputerByBrand(brand);
					break;
				
				case 4:
					System.out.println("Please enter maximum computer price :");
					double price = sc.nextDouble();
					sc.nextLine();
					computerStore.displayComputerCheaperThan(price);
					break;
				
				case 5:
					System.out.println("\nExiting Computer Store now. Thank you  ");
					break;
				
				default:
					System.out.println("\nInvalid choice, enter a number from 1 to 5");
					userChoice = 1;
					break;			
			}
				
		}
		
		sc.close();
	}
	
}
