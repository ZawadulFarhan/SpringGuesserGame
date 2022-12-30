package com.accenture.classes;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
public class Player {
	
	//list of pre-generated name options
	static final String[] firstNameList = {"Mckinley", "Thomas", "Elden", "Shawn", "Marion", 
			"Carl", "Rita", "Chris", "Tamika", "Christoper", "Cole", "Bryce", "Russ", 
			"Claudine", "Meghan", "Ulysses", "Santiago", "Markus", "Carroll", "Evan", "Josie",
			"Edgar", "Richie", "Ty", "Ashlee", "Desmond", "Lila", "Thanh", "Grady", "Jacob"};
	
	static final String[] lastNameList = {"Mccullough", "Adams", "Pruitt", "Blair", "Mcintyre", 
			"Wong", "Dickerson", "Sellers", "Snyder", "Owen", "Silva", "Dillon", "Holden", 
			"Merritt", "Mckenzie", "Banks", "Webster", "Cantu", "Hamilton", "Zavala", "Boone",
			"Davila", "English", "Eaton", "Ortega", "Willis", "Briggs", "Chavez", "Potter", "Wiley"};
	
	private Random rand;
	private String name;
	private int guess;

	public Player(Random random) {
		this.rand = random;
		//generate random name
		name = firstNameList[rand.nextInt(30)] + " " + lastNameList[rand.nextInt(30)];
		//generate guess as a random number
		guess = rand.nextInt(10);	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGuess() {
		return guess;
	}
}
