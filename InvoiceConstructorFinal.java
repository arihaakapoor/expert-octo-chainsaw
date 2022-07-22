import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class InvoiceConstructorFinal
{
    public static void main(String args[]) {
        printHeader();

        String id,productName;
        int quantity;
        double price,totalPrice,overAllPrice=0 ;
        double stateTax, saleTax, subtotal, discount;
        char choice;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String customername = scan.nextLine();
        List<Product> product = new ArrayList<Product>();
        do {
            System.out.println("Enter the product details:");
            System.out.print("Product ID: ");
            id = scan.nextLine();
            System.out.print("Style Name: ");
            productName = scan.nextLine();
            System.out.print("Quantity Purchased: ");
            quantity = scan.nextInt();
            System.out.print("Price of Item(per unit): ");
            price = scan.nextDouble();
            totalPrice = price * quantity;
            overAllPrice += totalPrice;
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
        System.out.printf("Total Amount ($):%s\n\n",overAllPrice);
        discount = overAllPrice*2/100;

        String discountString = "Discount($):";
        String subTotalString = "Subtotal:";
        String SaleTaxString = "SaleTax(%):";
        String StateTaxString = "StateTax(%):";
        String InvoiceTotal = "Invoice Total:";

        String endGreetingMessage = "We hope to see you Soon!";
        String thankYou = "Thank you";

        System.out.printf("%45s %1.2f\n",discountString,discount);
        subtotal = overAllPrice-discount;

        System.out.printf("%45s %1.2f\n",subTotalString,subtotal);
        saleTax=overAllPrice*12/100;

        System.out.printf("%45s %1.2f\n",SaleTaxString,saleTax);
        stateTax=overAllPrice*12/100;

        System.out.printf("%45s %1.2f\n",StateTaxString,stateTax);
        System.out.printf("%45s %1.2f\n",InvoiceTotal,(subtotal+stateTax+saleTax));

        System.out.println(endGreetingMessage);
        System.out.println(thankYou);
        scan.close();
    }

    static void printHeader(){

        String heading = "Invoice Constructor";
        String companyName = "Fits by Ariha";
        String address = "5555 Skyline Drive New York";
        String city = "Nordstorm";
        String gstNumber = "GSTIN:03AWBPP8756K592";
        String contactNumber = "Contact Number : (310) 491 4871";

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();

        String[] days = new String[] { "Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat" };
        String dateString = "Date: "+formatter.format(date)+" "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1];

        System.out.printf("%50s\n", heading);
        System.out.printf("%45s\n", companyName);
        System.out.printf("%45s\n", address);
        System.out.printf("%45s\n", city);
        System.out.printf("%45s\n" ,gstNumber);
        System.out.printf("%45s\n" ,contactNumber);
        System.out.printf("%45s\n\n",dateString);
    }

}
