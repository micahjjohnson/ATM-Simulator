import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ATMViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM theATM;
		try {
			Bank theBank = new Bank();
			theBank.readCustomers("customers.txt");
			theATM = new ATM(theBank);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error opening accounts file.");
			return;
		}

		JFrame frame = new ATMFrame(theATM);
		frame.setTitle("ATM BY Micah Johnson");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
