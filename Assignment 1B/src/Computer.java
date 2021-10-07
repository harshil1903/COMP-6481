/**
 * ---------------------------------------------------------------------------
 * Assignment 1
 * @author Harshil
 * @author Parth
 * written by: (Harshil Patel - 40163431 , Parth Navsariwala - 40178800)
 * ---------------------------------------------------------------------------
 */


public class Computer {
    public String brand;
    public String model;
    public long SN;
    public double price;
    public static int objCounter = 0;

    // Default constructor...
    public Computer() {
        brand = "HP";
        model = "NoteBookA15";
        SN = 12346789;
        price = 60000.65;
        objCounter++;
    }

    // Copy constructor...
    public Computer(Computer c1) {
        setBrand(c1.getBrand());
        setPrice(c1.getPrice());
        setModel(c1.getModel());
        setSN(c1.getSN());
        objCounter++;
    }

    // All attributes Accessors & Mutators method
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getSN() {
        return SN;
    }

    public void setSN(long SN) {
        this.SN = SN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method for count number of object...
    public static int findNumberOfCreatedComputers() {
        return objCounter;
    }

    // Method for check equality...
    public boolean equals(Object object1) {
        if (object1 != null && object1.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            Computer c1 = (Computer) object1;
            return (this.brand.equals(c1.brand) && this.model.equals(c1.model) && this.price == c1.price);
        }
    }

    // String method to print appropriate information about object
	public String toString() {
		return("\nComputer Info:" +
			   "\nBrand: " + brand +
			   "\nModel: " + model +
			   "\nSN: " + SN +
			   "\nPrice: " + price);
	}

    public static void main(String[] args) {
        Computer c1 = new Computer();
        System.out.println(c1);
        System.out.println("Before Price - "+c1.getPrice());
        c1.setPrice(58000.65);
        System.out.println("After Price - "+c1.getPrice());
        System.out.println();
        Computer c2 = new Computer(c1);
        if (c1.equals(c2)) {
            System.out.println("Both Object c1 and c2 are equal");
        } else {
            System.out.println("Both Object c1 and c2 are not equal");
        }
        System.out.println();
        System.out.println("Number of computer object are created :" + findNumberOfCreatedComputers());
    }

}
