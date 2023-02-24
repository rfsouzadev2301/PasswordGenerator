package me.rafaelsouza.password_generator.example;

import java.util.InputMismatchException;
import java.util.Scanner;

import me.rafaelsouza.password_generator.entities.password.PasswordBuilder;
import me.rafaelsouza.password_generator.exception.PasswordBuilderException;

public class Program {

	public static void main(String[] args) throws PasswordBuilderException {
		
		Scanner sc = new Scanner(System.in);
		
		Integer passwordLength;
		do {
			System.out.print("Minimum password length: ");
			try {	
					passwordLength = sc.nextInt();
			}catch(InputMismatchException e) {
				sc.nextLine();
				passwordLength = null;
			}
			
		}while(passwordLength == null);
		
		
		sc.nextLine();
		
		char selected = ' ';
		do {
			System.out.println();
			System.out.print("Must have simple characters? (Y/N) ");
			selected = sc.nextLine().charAt(0);
		}while(selected != 'y' && selected != 'Y' && selected != 'n' && selected != 'N');
		boolean hasSimples = yesOrNo(selected);
		
		do {
			System.out.println();
			System.out.print("Must have numeric characters? (Y/N) ");
			selected = sc.nextLine().charAt(0);
		}while(selected != 'y' && selected != 'Y' && selected != 'n' && selected != 'N');
		boolean hasNumeric = yesOrNo(selected);
		
		do {
			System.out.println();
			System.out.print("Must have special characters? (Y/N) ");
			selected = sc.nextLine().charAt(0);
		}while(selected != 'y' && selected != 'Y' && selected != 'n' && selected != 'N');
		boolean hasSpecial = yesOrNo(selected);
		
		do {
			System.out.println();
			System.out.print("Must have uppercase characters? (Y/N) ");
			selected = sc.nextLine().charAt(0);
		}while(selected != 'y' && selected != 'Y' && selected != 'n' && selected != 'N');
		boolean hasUppercase = yesOrNo(selected);
		
		PasswordBuilder passwordBuilder = new PasswordBuilder(hasSimples, hasNumeric, hasSpecial, hasUppercase);
		
		try {
			passwordBuilder.generateRandomPassaword(passwordLength);
		}catch(PasswordBuilderException e) {
			System.out.println();
			System.out.println("You put a password length too low for the requirements, by default now the length is 4");
			passwordBuilder.generateRandomPassaword(4);
		}
		
		sc.close();
		
		String password = passwordBuilder.toString();
		
		System.out.println();
		System.out.println(password);
	}

	private static boolean yesOrNo(char selected) {
		if (selected == 'Y' || selected == 'y') {
			return true;
		}
		if (selected == 'N' || selected == 'n'){
			return false;
		}
		throw new InputMismatchException();
	}
}
