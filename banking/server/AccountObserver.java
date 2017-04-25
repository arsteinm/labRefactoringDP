package banking.server;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import banking.interfaces.AAccount;

public class AccountObserver implements Observer {

	private List<AAccount> list = null;
	
	public AccountObserver(List<AAccount> list) {
		this.list = list;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		AAccount account = (AAccount) arg1;
		System.out.println("Account " + account.getName() + " has been added, there are now " + list.size() + " accounts on the server");
	}

}
