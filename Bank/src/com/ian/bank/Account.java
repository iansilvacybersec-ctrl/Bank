package com.ian.bank;

public class Account {
	
	private static final int MAX_LENGTH = 15;
	private String ag;
	private String cc;
	private String name;
	private double balance;
	private Log logger;
	
	public Account(String ag, String cc, String name){
		this.ag = ag;
		setName(name);
		this.cc = cc;
		logger = new Log();
		
	}
	public double getBalance() {
		return balance;
	}
	
	public void setName(String name) {
		if(name.length() > MAX_LENGTH) {
			this.name = name.substring(0, MAX_LENGTH);
		} else{
			this.name = name;
		}
		
	}
	public boolean withdraw(double value) {
		if(value>balance){
			logger.out("SAQUE - R$"+value+" Seu saldo é insuficiente");
			return false;}
		balance -= value;
		logger.out("SAQUE - R$"+value+" Seu saldo agora é de R$" +balance);
		return true;
		
		}
	
	public void deposit(double value) {
		balance += value;
		logger.out("DEPÓSITO - R$"+value+" Seu saldo agora é de R$"+balance);
	}

	public String toString() {
		return "A conta "+this.name+" " +this.cc+" / " +this.ag+" tem R$"+ balance;
	}
}
	

