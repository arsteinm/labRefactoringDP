package banking.server;

import java.util.Observable;
import java.util.Observer;

import banking.server.ServerSolution.ObservableAccountList;

public class AccountObserver implements Observer {

	private ObservableAccountList list = null;
	
	public AccountObserver(ObservableAccountList list) {
		this.list = list;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

}
