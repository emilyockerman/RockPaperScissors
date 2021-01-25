/*
* RockPaperScissors.java
* Author: Emily Ockerman
* Submission Date: September 26, 2018
*
* Purpose: to play rock paper scissors when you have no one 
* else (aka a real, live person) who will play with you.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
CSCI 1301: Project 1 Page 3
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//variable declaration and initialization
		int userScore = 0;
		int computerScore = 0;
		
		//how many points to win
		System.out.print("Points to win: ");
			int pointsToWin = input.nextInt();
			//ensuring positive user input
			while (pointsToWin <= 0)
			{
				System.out.println("Please enter a positive point value.");
				System.out.print("Points to win: ");
				pointsToWin = input.nextInt();
			}
			
		while ((userScore < pointsToWin) && (computerScore < pointsToWin))
		{
			//user's move
			System.out.print("\nRock, paper, or scissors? ");
			String userMove = input.next();
				
			//computer's move
			String computerMove = ComputerOpponent.getMove();
			
			//determining whether computer or user won
			if (userMove.equalsIgnoreCase("rock") && computerMove.equals("scissors") || userMove.equalsIgnoreCase("paper") && computerMove.equals("rock") || userMove.equalsIgnoreCase("scissors") && computerMove.equals("paper"))
			{
				userScore++;
				System.out.print("The computer chose " + computerMove + ", so you win! " + "(" + userScore + "-" + computerScore + ")");
			}
			else if (userMove.equalsIgnoreCase("rock") && computerMove.equals("paper") || userMove.equalsIgnoreCase("paper") && computerMove.equals("scissors") || userMove.equalsIgnoreCase("scissors") && computerMove.equals("rock"))
			{
				computerScore++;
				System.out.print("The computer chose " + computerMove + ", so you lose!" + "(" + userScore + "-" + computerScore + ")");
			}
			else if (userMove.equalsIgnoreCase(computerMove))
			{
				System.out.print("The computer also chose " + computerMove + ", so it's a tie." + "(" + userScore + "-" + computerScore + ")");
			}
			else
			{
				System.out.print("I don't know what game you're playin' but it's not this one. Try again.");
				userMove = input.next();
			}
			
		//programming the output depending on who won
		if (userScore == pointsToWin)
		{
			System.out.println("\nCongrats, you win!");
		}
		else if (computerScore == pointsToWin)
		{
			System.out.println("\nSorry, you lost. Better luck next time!");
		}
		}
	}

}
