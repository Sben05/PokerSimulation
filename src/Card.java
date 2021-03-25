/**
 * 
 * @author Shreeniket Bendre
 * Project: Poker Hand
 * File: Card.java
 *
 */

import java.util.Scanner;

/**
 * 
 * @author mellis
 * This class represents a single playing card
 * understand that the rank is what you would see 
 * on the card (2,3,4,5,6,7,8,9,10,J,Q,K,A).
 * The value is a number corresponding to the rank
 * which gives each card a numerical value.  This can
 * be used for keeping score, putting cards in order
 * easily, etc. For our purposes, when you construct
 * Cards, the value would match the rank for 
 * ranks 2-10, then J has a value of 11, Q has a value
 * of 12, K has a value of 13, and A has value of 14.
 */


public class Card
{

	private char suit;
	private String rank;
	private int value;
	
	public Card(char suit, String rank, int value)
	{
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}
	
	
	public char getSuit()
	{
		return suit;
	}
	
	public String getRank()
	{
		return rank;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String toString()
	{
		return rank + suit;
	}

	
}