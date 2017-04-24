package banking.gui;

import banking.interfaces.AAccount;
import banking.server.IAccountServer;
import banking.server.AccountServerFactory;

import java.io.*;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class MainFrame extends JFrame {

	IAccountServer	myServer;
	Properties		props;
	JLabel			typeLabel;
	JLabel			nameLabel;
	JLabel			balanceLabel;
	JComboBox<String>		typeOptions;
	JTextField		nameField;
	JTextField		balanceField;
	JButton			newAccountButton;
	JButton			displayAccountsButton;

	public MainFrame(String propertyFile) throws IOException {

		//** initialize myServer
		AccountServerFactory factory = AccountServerFactory.getInstance();
		myServer = factory.getAccountServer();

		props = new Properties();

		FileInputStream fis = null; 
		try {
			fis =  new FileInputStream(propertyFile);
			props.load(fis);
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			throw ioe;
		}

		constructForm();
	}

	
	private void constructForm() {
		//*** Make these read from properties
		typeLabel		= new JLabel(props.getProperty("TypeLabel"));
		nameLabel		= new JLabel(props.getProperty("NameLabel"));
		balanceLabel	= new JLabel(props.getProperty("BalanceLabel"));

		String[] accountTypes = {"Savings", "Checking"};
		typeOptions = new JComboBox<String>(accountTypes);
		nameField = new JTextField(20);
		balanceField = new JTextField(20);

		newAccountButton = new JButton("New Account");
		displayAccountsButton = new JButton("Display");

		this.addWindowListener(new FrameHandler());
		newAccountButton.addActionListener(new NewAccountHandler());
		displayAccountsButton.addActionListener(new DisplayHandler());
		balanceField.addFocusListener(new BalanceChecker());

		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(typeLabel);
		pane.add(typeOptions);
		pane.add(nameLabel);
		pane.add(nameField);
		pane.add(balanceLabel);
		pane.add(balanceField);
		pane.add(newAccountButton);
		pane.add(displayAccountsButton);

		setSize(250, 200);
	}

	class DisplayHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			List<AAccount> accounts = myServer.getAllAccounts();
			StringBuffer sb = new StringBuffer();
			AAccount thisAcct = null;
			for (Iterator<AAccount> li = accounts.iterator(); li.hasNext();) {
				thisAcct = li.next();
				sb.append(thisAcct.toString());
			}

			JOptionPane.showMessageDialog(null, sb.toString());
			System.out.println(accounts);
		}
	}

	// Complete a handler for new account button
	class NewAccountHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String type = typeOptions.getSelectedItem().toString();
			String name = nameField.getText();
			String balance = balanceField.getText();

			myServer.newAccount(type, name, Float.parseFloat(balance));
		}
	}

	// Write a handler for the balance field that, when 
	// focus is lost, checks that the field is a proper float
	class BalanceChecker implements FocusListener {
		public void focusGained(FocusEvent e) {
		}
		
		public void focusLost(FocusEvent e) {
			boolean passed = true;

			String text = balanceField.getText();
			if (text.length() == 0)
				passed = false;
			try {
				Float.parseFloat(text);
			} catch (Exception ex) {
				passed = false;
			}

			if (!passed) {
				balanceField.setText("");
				balanceField.requestFocus();
			}
		} 
	}

	//** Complete a handler for the Frame that terminates 
	//** (System.exit(1)) on windowClosing event
	static class FrameHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
}
