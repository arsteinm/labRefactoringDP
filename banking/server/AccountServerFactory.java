package banking.server;


public class AccountServerFactory {

	public AccountServerFactory() {
	}

	public IAccountServer getAccountServer() {
		return new ServerSolution();
	}
}
