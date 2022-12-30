package com.accenture.classes;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Guesser {
	
	private Scanner s;
	private int guess;
	
	public Guesser(Scanner scanner) {
		super();
		this.s = scanner;
	}

	public int getGuess() {
		//scan guess(0-9) from user. Keep prompting user if input is invalid
		do {
			System.out.print("\nGuesser, please enter a number from 0 to 9: ");
			try {
				guess = s.nextInt();
				s.nextLine();
			} catch(Exception e) {
				guess = -1;
				s.nextLine();
			}
		} while(guess > 9 || guess < 0);
		System.out.println();
		
		return guess;
	}
}
