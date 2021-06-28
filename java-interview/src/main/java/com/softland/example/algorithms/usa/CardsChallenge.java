package com.softland.example.algorithms.usa;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/*

TDK
you have three credit cards and use design patters to solve the problem.
Gold: fees: 0 , initial balance 0: credit limit: 1000  creditPoints = 0
                    Every withdraw or transaction it should update the credit limit and Balance
sIlver: fees: 50 , initial balance 50: credit limit: 1500  creditPoints = everytransaction * ½
                   
               Every withdraw or transaction it should update the credit limit and Balance
Platinum: fees  50 , initial balance 100: credit limit: 2000  creditPoints = everytransaction * 1
                   
               Every withdraw or transaction it should update the credit limit and Balance

Note: use design pattern factory suitable for this scenario

 */
public class CardsChallenge {

	public static void main(String[] args) {
		CardFactory cardFactory = new CardFactory();
		
		List<BigDecimal> transactions = new LinkedList<>();
		transactions.add(BigDecimal.valueOf(50.00)); // withdraw
		transactions.add(BigDecimal.valueOf(10.00)); // food
		transactions.add(BigDecimal.valueOf(5.00));  // coke
		System.out.println("Transactions: " + transactions.toString());
		
		CreditCard card = cardFactory.getCreditCard(CardType.GOLD);
		card.withdrawOrTransaction(transactions);
		System.out.println("GOLD " + card.toString());
		
		CreditCard silver = cardFactory.getCreditCard(CardType.SILVER);
		silver.withdrawOrTransaction(transactions);
		System.out.println(CardType.SILVER + silver.toString());

	}

}


abstract class CreditCard {
	protected Double fee;
	protected BigDecimal balance;
	protected BigDecimal limit;
	protected Double points;
	
	public CreditCard(Double fee, BigDecimal balance, BigDecimal limit, Double points) {
		super();
		this.fee = fee;
		this.balance = balance;
		this.limit = limit;
		this.points = points;
	}

	abstract void withdrawOrTransaction(List<BigDecimal> transactions);

	@Override
	public String toString() {
		return String.format("[fee=%s, balance=%s, limit=%s, points=%s]", fee, balance, limit, points);
	}
	
}

class GoldCreditCard extends CreditCard {

	public GoldCreditCard() {
		super((double) 0, BigDecimal.valueOf(0.00), BigDecimal.valueOf(1000.00), (double) 0);
	}

	@Override
	void withdrawOrTransaction(List<BigDecimal> transactions) {
		BigDecimal amount = transactions.stream().reduce(BigDecimal::add).get();
		this.limit = this.limit.subtract(amount);
		this.balance = this.balance.add(amount);
	}
}

// sIlver: fees: 50 , initial balance 50: credit limit: 1500  creditPoints = everytransaction * ½
class SilverCreditCard extends CreditCard {

	public SilverCreditCard() {
		super((double) 50, BigDecimal.valueOf(50.00), BigDecimal.valueOf(1500.00), (double) 0);
	}

	@Override
	void withdrawOrTransaction(List<BigDecimal> transactions) {
		
		BigDecimal amount = transactions.stream().reduce(BigDecimal::add).get();
		this.limit = this.limit.subtract(amount);
		this.balance = this.balance.add(amount).add( BigDecimal.valueOf(this.fee) );
		if (!transactions.isEmpty()) {
			this.points = (double) transactions.size() / 2;
		}
	}
}

// Platinum: fees  50 , initial balance 100: credit limit: 2000  creditPoints = everytransaction * 1
class PlatinumCreditCard extends CreditCard {

	public PlatinumCreditCard() {
		super((double) 50, BigDecimal.valueOf(100.00), BigDecimal.valueOf(2000.00), (double) 0);
	}

	@Override
	void withdrawOrTransaction(List<BigDecimal> transactions) {
		
		BigDecimal amount = transactions.stream().reduce(BigDecimal::add).get();
		this.limit = this.limit.subtract(amount);
		this.balance = this.balance.add(amount);
		if (!transactions.isEmpty()) {
			this.points = (double) transactions.size();
		}
	}
}

enum CardType {
	GOLD, SILVER, PLATINUM
}

class CardFactory {
	
	public CreditCard getCreditCard(CardType cardType) {
		if (cardType == null) return null;
		
		if (cardType == CardType.GOLD) {
			return new GoldCreditCard();
			
		} else if (cardType == CardType.SILVER) {
			return new SilverCreditCard();
			
		} else if (cardType == CardType.PLATINUM) {
			return new PlatinumCreditCard();
		}
		
		return null;
	}
	
}
