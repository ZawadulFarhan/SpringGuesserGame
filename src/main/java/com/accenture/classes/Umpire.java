package com.accenture.classes;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Umpire {
	
	@Autowired
	private Guesser guesser;
	private ArrayList<Player> players;
	
	public void reset() {
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player) {
		System.out.println("Player(" + player.getName() + ") has joined the game.");
		players.add(player);
	}
	
	public void run() {
		//boolean flag that checks for winners
		boolean noWinners = true;
		//an arraylist to store winning player's names
		ArrayList<String> winners = new ArrayList<String>();
		int gNum = guesser.getGuess();
		
		//iterate through all players
		for(Player player: players) {
			System.out.println(player.getName() + " has guessed " + player.getGuess() + "..."); //announce player's number
			//check if player has won
			if(player.getGuess() == gNum) {
				winners.add(player.getName());
				noWinners = false;
			}
		}
		
		// announce game results
		if(noWinners) {
			// announce no winners
			System.out.println("\nNoone has guessed the number... You win!\n");
		} else {
			// announce list of winners
			System.out.println("\n" + String.join(", ", winners) + " has guessed the correct number!\n\n" + winners.size()
			+ " players have guessed your number... You lose!\n");
		}
	}
}
