package banking.interfaces;

import banking.primitive.*;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public abstract class AAccount implements IAsset
{
	static final long serialVersionUID  = -7588980448693010399L;

	//SER316 ACTIVITY 1.4
	protected float accountBalance =0.0F;
	protected String name;

	public AAccount(String n)
	{
		name = n;
	}

	public AAccount(String n, float b)
	{
		name = n;
		accountBalance = b;
	}

	public void display()
	{
	    JOptionPane.showMessageDialog(null, "Account " + name + " has $" + accountBalance);
	}

	public String getName()
	{
		return name;
	}

	public float getBalance()
	{
		return accountBalance;
	}
	
	//ACTIVITY 2-2 SMELL BETWEEN CLASSES - Data Class
	//Deleted DepositAmount Class as this held nothing but a float value for an amount
	//constructor now just references amount directly 
	public abstract void deposit(float amount);
	public abstract void withdraw(float amount);

    public String toString() {
    	return "Account " + name + " has $" + accountBalance +"\n";
    }
}
