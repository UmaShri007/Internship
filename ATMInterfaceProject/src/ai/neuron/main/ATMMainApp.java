package ai.neuron.main;

import java.util.Scanner;

import ai.neuron.accountrelated.AccountHolder;
import ai.neuron.accountrelated.AccountHolder;
import ai.neuron.bankrelated.BankTransactionImpl;
import ai.neuron.bankrelated.IBankTransactions;

public class ATMMainApp {
	
	static {
		System.out.println("Welcome to the JhanDhan Bank!!");
	}

	public static void main(String[] args) {

		IBankTransactions service = new BankTransactionImpl();
		Scanner scan = new Scanner(System.in);

		// Getting the userId,usePin and validating for login

		System.out.println("Enter your userID:");

		String uid = scan.next();
		boolean status = false;
		if (uid.length() == 5) {
			System.out.println("Enter your 4 digit pin number");
			String upin = scan.next();
			status = AccountHolder.validateUser(uid, upin);
		} else {
			System.out.println("Incorrect userId");
			System.exit(0);
		}


		// Display the service menu and direct it to respective method
		while (status == true) {
			System.out.println("1. View available balance\n2. Withdrawal\n3. Deposit"
					+ "			\n4. TransactionHistory\n5. Exit");
			System.out.println("Please enter your required service:: ");
			int servReqd = scan.nextInt();

			switch (servReqd) {

			case 1:
				service.viewBalance();
				break;

			case 2:
				System.out.println("Enter the amount you wish to withdraw:: ");
				Double wAmount = scan.nextDouble();
				service.withdraw(wAmount);
				break;

			case 3:
				System.out.println("Enter the amount you wish to deposit:: ");
				Double dAmount = scan.nextDouble();
				service.deposit(dAmount);
				break;

			case 4:
				service.dispTranscationHistory();
				break;

			case 5:
				System.out.println("Please collect your ATM Card\nThank you for using our services!!");
				System.exit(0);

			default:
				System.out.println("Please enter the correct choice");
				break;
			}
			
		}

	}

}