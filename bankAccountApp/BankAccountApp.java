package bankAccountApp;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		String file = "C:\\Users\\aksha\\eclipse-workspace\\JavaProjects\\src\\utilities\\NewBankAccounts.csv";
		List<String[]> newAccountHolder = utilities.CSV.read(file);
		for(String[] accountHolder:newAccountHolder) {
			
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
		
			if (accountType.equals("Savings")) {
				
				accounts.add(new Savings(name,sSN,initDeposit));
			}
			else if (accountType.equals("Checkings")) {
				
				accounts.add(new Checking(name,sSN,initDeposit));
			}
			//else {
				//System.out.println("Error reading the account type");
			//}
		}
		
		for(Account acc:accounts) {
			System.out.println("\n******************\n");
			acc.showInfo();
		}
		
		accounts.get((int)Math.random()*accounts.size()).deposit(1000);
		accounts.get((int)Math.random()*accounts.size()).deposit(1500);
	}

}
