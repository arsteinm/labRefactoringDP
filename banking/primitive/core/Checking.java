package banking.primitive.core;

import banking.interfaces.Account;

@SuppressWarnings("serial")
public class Checking extends Account {
	static final long serialVersionUID  = -7588980448693010399L;

	private int numWithdraws = 0;

	private Checking(String name) {
		super(name);
	}

    public static Checking createChecking(String name) {
        return new Checking(name);
    }

	public Checking(String name, float balance) {
		super(name, balance);
	}

	public void display() {
		System.out.print("Checking ");
		super.display();
	}

	public void deposit(DepositParameter parameterObject) {
		balance = balance + parameterObject.amount;
	}

	public void withdraw(float amount) {
		balance = balance - amount;
		numWithdraws++;
		if (numWithdraws > 10)
			balance = balance - 2;
	}

	public String toString() {
		return "Chk:" + getName() + ":" + getBalance();
	}

    public char charAt(int i) {
        return name.charAt(i);
    }
}
