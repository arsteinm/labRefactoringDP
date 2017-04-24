package banking.primitive.core;

import banking.interfaces.AAccount;
import banking.interfaces.IInterestBearing;

@SuppressWarnings("serial")
public class Savings extends AAccount implements IInterestBearing {
	static final long serialVersionUID  = -7588980448693010399L;
	
	private int numWithdraws = 0;

	public Savings(String name) {
		super(name);
	}

	public Savings(String name, float balance) {
		super(name, balance);
	}

	public void display() {
		super.display();
	}
	//ACTIVITY 2-2 SMELL BETWEEN CLASSES - Data Class
	//Deleted DepositAmount Class as this held nothing but a float value
	//constructor now just references amount directly 
	public void deposit(float amount) {
		accountBalance = accountBalance + amount - 0.50F;
	}

	public void withdraw(float amount) {
		accountBalance = accountBalance - amount;
		numWithdraws++;
		if (numWithdraws > 3)
			accountBalance = accountBalance - 1;
	}

	public void accrueInterest() {
		accountBalance = accountBalance * 1.001F;
	}

	public String toString() {
		return "Sav:" + getName() + ":" + getBalance();
	}
}
