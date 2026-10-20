package com.ian.bank;
import java.util.Scanner;
import java.util.List;


public class App {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Bank santander = new Bank("0001");
		
		while(true) {
			System.out.println("O que deseja fazer? C= Criar conta E= Sair");
			String op = scanner.nextLine();
			
			if(op.equals("C")) {
				System.out.println("Digite um nome: ");
				String name = scanner.nextLine(); 
				Account account = santander.generateAccount(name);
				santander.insertAccount(account);
				operatingAccount(account);
				
			}else if(op.equals("E")) {
				break;
			}else {
				System.out.println("Operação não reconhecida.");
			}
			
			}
		List<Account> accountList = santander.getAccounts();
		for(Account cc : accountList) {
			System.out.println(cc);
		}
		
		santander.outputTotal();
		scanner.close();
	}
	static void operatingAccount(Account account) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("O que deseja fazer? D= Depósito S= Saque E= Sair.\n");
			String op = scanner.nextLine();
			if(op.equals("D")){
				System.out.println("Qual valor você deseja depositar?\n");
				Double value = scanner.nextDouble();
				account.deposit(value);
				
			} else if(op.equals("S")) {
					System.out.println("Qual valor você deseja sacar?\n");
					Double value = scanner.nextDouble();
					boolean success = account.withdraw(value);
					if(!success) {
						System.out.println("Ops! Seu saldo não é suficiente");
					}
				
			} else if(op.equals("E")) {
					break;
				
			} else {
					System.out.println("Operação não reconhecida.\n");
				
			}
			scanner = new Scanner(System.in);
		}
	}
	}
	/*criar uma conta(ag, conta, nome) v
	limitar o nome a 15 caracteres v
	sacar valores 
	depositar
	nao pode sacar mais do que tem 	
	informar para  o usuario as operaçoes
	D S E*/
