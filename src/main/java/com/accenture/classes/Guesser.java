package com.accenture.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Guesser {
	
	private Scanner s;
	private Environment environment;
	private int guess;
	
	@Autowired
	public Guesser(Scanner s, Environment environment) {
		super();
		this.s = s;
		this.environment = environment;
	}

	public int getGuess() {
		final int MINGUESS = Integer.parseInt(environment.getProperty("minguess"));
		final int MAXGUESS = Integer.parseInt(environment.getProperty("maxguess"));
		
		//scan guess(MINGUESS-MAXGUESS) from user. Keep prompting user if input is invalid
		do {
			System.out.print("\nGuesser, please enter a number from " + MINGUESS + " to " + MAXGUESS + ": ");
			try {
				guess = s.nextInt();
				s.nextLine();
			} catch(Exception e) {
				guess = MAXGUESS+1;
				s.nextLine();
			}
		} while(guess > MAXGUESS || guess < MINGUESS);
		System.out.println();
		
		return guess;
	}
}
