package ai.neuron.bankrelated;

import java.util.HashMap;
import java.util.Map;

import ai.neuron.accountrelated.Account;

public class BankTransactionImpl implements IBankTransactions {

	Account accnt = new Account();

	Map<Double, String> ministmt = new HashMap<>();

	@Override
	public void viewBalance() {
		System.out.println("Your available balance is :: " + accnt.getAccountBalance());
	}

	@Override
	public void deposit(double dAmount) {

		ministmt.put(dAmount," ===> Amount Deposited");
		System.out.println("RS " + dAmount + " deposited successfully to your account!");
		accnt.setAccountBalance(accnt.getAccountBalance()+dAmount );
		viewBalance();

	}

	@Override
	public void withdraw(double wAmount) {
		if (wAmount <= accnt.getAccountBalance()) {
			ministmt.put(wAmount," ===> Amount Withdrawn");
			System.out.println("Please collect the cash :: RS " + wAmount);
			accnt.setAccountBalance(accnt.getAccountBalance() - wAmount);
			viewBalance();
		} else {
			System.out.println("Insufficient Balance!!!");
		}
	}

	@Override
	public void dispTranscationHistory() {

		for (Map.Entry<Double, String> m : ministmt.entrySet()) {
			System.out.println(m.getKey() + "" + m.getValue());
		}

	}

}