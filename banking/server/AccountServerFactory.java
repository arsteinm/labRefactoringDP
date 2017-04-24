package banking.server;


public class AccountServerFactory {

	private  IAccountServer server = new ServerSolution();
	private static AccountServerFactory instance = new AccountServerFactory();
	
	private AccountServerFactory() {
	
	}

	public static  AccountServerFactory getInstance(){
		return instance;
	}
	
	public  IAccountServer getAccountServer() {
		return server;
	}
}
