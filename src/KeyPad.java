import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyPad extends JPanel {

	private JTextField display;
	private Container buttonPanel;
	private JButton clearButton;

	public KeyPad() {
		setLayout(new BorderLayout());
		display = new JTextField();
		add(display, "North");

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 3));
		addButton("7");
		addButton("8");
		addButton("9");
		addButton("4");
		addButton("5");
		addButton("6");
		addButton("1");
		addButton("2");
		addButton("3");
		addButton("0");
		addButton(".");

		clearButton = new JButton("CE");
		buttonPanel.add(clearButton);

		class ClearButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				display.setText("");
			}
		}

		ActionListener listener = new ClearButtonListener();
		clearButton.addActionListener(new ClearButtonListener());

		add(buttonPanel, "Center");
	}

	private void addButton(final String label) {
		class DigitButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				// Don’t add two decimal points
				if (label.equals(".") && display.getText().indexOf(".") != -1) {
					return;
				}
				display.setText(display.getText() + label);
			}
		}

		JButton button = new JButton(label);
		buttonPanel.add(button);
		ActionListener listener = new DigitButtonListener();
		button.addActionListener(listener);
	}

	public double getValue() {
		return Double.parseDouble(display.getText());
	}

	public void clear() {
		display.setText("");
	}
}
