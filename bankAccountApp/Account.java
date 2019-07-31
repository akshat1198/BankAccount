package bankAccountApp;

public abstract class Account implements IBaseRate {
	private String name;
	private String sSN;
	private double balance;
	
	protected String accountNumber;
	protected double rate;
	
	private static int index = 10000;
	
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
	
		
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		int uniqueID = index;
		String lastTwoSSN = sSN.substring(sSN.length()-2,sSN.length());
		int randomNum = (int)(Math.random()*Math.pow(10, 3));
		return lastTwoSSN+uniqueID+randomNum;
	}
	public void compound() {
		double accruedInterest = balance*(rate/100);
		System.out.println("Accrued Interest $"+accruedInterest);
		balance+=accruedInterest;
		printBalance();
		
	}
	public void deposit(double amount) {
		balance+=amount;
		System.out.println("Depositing $"+amount);
		printBalance();
	}
	public void withdraw(double amount) {
		balance-=amount;
		System.out.println("Withdrawing $"+amount);
		printBalance();
	}
	public void transfer(String toWhere,double amount) {
		balance-= amount;
		System.out.println("Transferring $" + amount+" to "+toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now $"+balance);
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: "+name+
				"\nAccount Number: "+accountNumber+
				"\nBalance: "+balance+
				"\nRate: "+rate+"%");
	}
}
