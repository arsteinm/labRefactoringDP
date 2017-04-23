package banking.primitive.core;

import banking.primitive.*;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public abstract class Account implements Asset
{
	protected float balance =0.0F;
	protected String name;

	public Account(String n)
	{
		name = n;
	}

	public Account(String n, float b)
	{
		name = n;
		balance = b;
	}

	public void display()
	{
	    JOptionPane.showMessageDialog(null, "Account " + name + " has $" + balance);
	}

	public String getName()
	{
		return name;
	}

	public float getBalance()
	{
		return balance;
	}
	
	public abstract void deposit(DepositParameter parameterObject);
	public abstract void withdraw(float amount);

    public String toString() {
    	return "Account " + name + " has $" + balance +"\n";
    }
}
