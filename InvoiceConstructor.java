import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

class Product {
	private String id;
	private String pname;
	private int qty;
	private double price;
	private double totalPrice;
	Product(String id, String pname, int qty, double price, double totalPrice)
	{

	this.id=id;
	this.pname = pname;
	this.qty = qty;
	this.price = price;
	this.totalPrice = totalPrice;
}
	public String getId() {
	return id;
}
	public String getPname()
{
	return pname;
}
	public int getQty()
{
	return qty;
}
	public double getPrice()
{
	return price;
}
	public double getTotalPrice()
{
	return totalPrice;
}
	public static void displayFormat()
{
	System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");
System.out.print("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");
System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");

}
public void display() {
	System.out.format(" %-9s %-9s %5d %9.2f %14.2f\n" ,id, pname, qty, price, totalPrice);
	}
}
	public class InvoiceConstructor
{
	public static void main(String args[]) {
	String id = null;
	String productName = null;
	int quantity = 0;
	double price = 0.0;
	double totalPrice = 0.0;
	double overAllPrice = 0.0;
	double StateTax, SaleTax, subtotal=0.0, discount=0.0;
	char choice = '\0';
		System.out.println("\t\t\t\t--------------------Invoice-----------------");
		System.out.println("\t\t\t\t\t "+" "+"Fits by Ariha");
		System.out.println("\t\t\t\t\t 5555 Skyline Drive New York");
		System.out.println("\t\t\t\t\t" +" " +"Opposite Nordstrom");
		System.out.println("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\tContact: (310) 491 4871");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		System.out.println("Date: "+formatter.format(date)+" "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (310) 491 4871");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Customer Name: ");
		String customername=scan.nextLine();
	List<Product> product = new ArrayList<Product>();
do {
	System.out.println("Enter the product details: ");
	System.out.print("Product ID: ");
		id = scan.nextLine();
	System.out.print("Product Name: ");
		productName = scan.nextLine();
	System.out.print("Quantity Purchased: ");
		quantity = scan.nextInt();
	System.out.print("Price of Item(per unit): ");
		price = scan.nextDouble();
	totalPrice = price * quantity;
		overAllPrice = overAllPrice + totalPrice;
	product.add( new Product(id, productName, quantity, price, totalPrice) );
	System.out.print("Want to add more items? (y or n): ");
	choice = scan.next().charAt(0);
	scan.nextLine();
}
	while (choice == 'y' || choice == 'Y');
		Product.displayFormat();
		for (Product p : product)
{
	p.display();
}
	System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount ($) " +overAllPrice);
	discount = overAllPrice*2/100;
	System.out.println("\n\t\t\t\t\t\t\t\t\t\t Discount ($) " +discount);
	subtotal = overAllPrice-discount;
	System.out.println("\n\t\t\t\t\t\t\t\t\t\t Subtotal "+subtotal);
	SaleTax=overAllPrice*12/100;
	System.out.println("\n\t\t\t\t\t\t\t\t\t\t SaleTax (%) "+SaleTax);
	StateTax=overAllPrice*12/100;
	System.out.println("\n\t\t\t\t\t\t\t\t\t\t StateTax (%) "+StateTax);
	System.out.println("\n\t\t\t\t\t\t\t\t\t\t Invoice Total " +(subtotal+StateTax+SaleTax));
	System.out.println("\t\t\t\t----------------See You Again <3!-----------------");
	System.out.println("\t\t\t\t Thank You!");
	scan.close();
	}
}