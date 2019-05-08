import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

	private ArrayList<Customer> customers;

	public Bank() {
		customers = new ArrayList<Customer>();
	}

	public void addCustomer(Customer c) {
		customers.add(c);
	}

	public void readCustomers(String filename) throws IOException {
		Scanner in = new Scanner(new File(filename));
		while (in.hasNext()) {
			int number = in.nextInt();
			int pin = in.nextInt();
			Customer c = new Customer(number, pin);
			addCustomer(c);
		}
		in.close();
	}

	public Customer findCustomer(int aNumber, int aPin) {
		for (Customer c : customers) {
			if (c.match(aNumber, aPin)) {
				return c;
			}
		}
		return null;
	}
}
