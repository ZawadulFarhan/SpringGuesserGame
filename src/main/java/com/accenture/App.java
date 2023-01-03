package com.accenture;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.accenture.classes.*;

public class App 
{
    public static void main( String[] args )
    {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    	Environment environment = context.getBean(Environment.class);
		Umpire umpire = context.getBean(Umpire.class);
    	Scanner s = context.getBean(Scanner.class);
    	
    	final int MINPLAYER = Integer.parseInt(environment.getProperty("minplayer"));
    	final int MAXPLAYER = Integer.parseInt(environment.getProperty("maxplayer"));

    	do {
    		//makes sure details of older guesser games do not affect new game
    		umpire.reset();
    		
    		//scan number of players to n (MINPLAYER-MAXPLAYER) from user. Keep prompting user if input is invalid
        	int n;
        	do {
    			System.out.print("\nEnter number of players(" + MINPLAYER + "-" + MAXPLAYER + "): ");
    			try {
    				n = s.nextInt();
    				s.nextLine();
    			} catch(Exception e) {
    				n = MAXPLAYER+1;
    				s.nextLine();
    			}
    		} while(n > MAXPLAYER || n < MINPLAYER);
        	//paragraphing
        	System.out.println();
    		
        	//add players
    		for (int i = 0; i < n; i++) {
				umpire.addPlayer(context.getBean(Player.class));
			}
    		
    		//run the game
    		umpire.run();
    		
    		//see if user wants to continue
    		System.out.print("Keep playing?\n(y/n): ");
    		
    		//lazily read user input and terminate program if first entered character is not y or Y, else continue
    		switch(s.nextLine().toLowerCase().charAt(0)) {
    		case 'y':
    			break;
    		default:
    			umpire = null;
    			break;	
    		}
    	} while (umpire != null);
    	
    	//goodbye message
    	System.out.println("\nThank you for playing and goodbye!");
    	
    	//close resources
    	try {
    	((AnnotationConfigApplicationContext)context).close();
    	s.close();
    	} catch(Exception e) {
    	}
    }
}
