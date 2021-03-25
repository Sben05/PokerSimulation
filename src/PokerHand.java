/**
 * 
 * @author Shreeniket Bendre
 * Project: Poker Hand
 * File: PokerHand.java
 *
 */
public class PokerHand 
{
	
	/*
	 * This field represents the cards in a player's hand
	 */
	private Card[] hand;
	
	
	
	/*
	 * TODO Create a constructor which takes no arguments and initializes
	 * the hand (our hand always has five cards) to an Ace of hearts, 
	 * King of hearts, Queen of hearts, Jack of hearts, and 10 of hearts.  
	 * This is a royal flush
	 *
	 */
	public PokerHand() {
		
		Card cardOne = new Card('H', "A", 14);
		Card cardTwo = new Card('H', "K", 13);
		Card cardThree = new Card('H', "Q", 12);
		Card cardFour = new Card('H', "J", 11);
		Card cardFive = new Card('H', "10", 10);
		Card[] handTwo = {cardOne, cardTwo, cardThree, cardFour, cardFive};
		hand = handTwo;
	}
	
	/* 
	 * TODO Create a constructor which takes an array of 5 Cards 
	 * as an argument and initializes the hand to the five cards 
	 * passed.
	 * 
	 */
	public PokerHand(Card[] handTwo) {
		hand = handTwo;
	}
	
	
	
	/**
	 * This method sortHandByValue will put your cards in order
	 * from smallest to largest.  It is private and can only be
	 * called in this class.  It may prove useful for you.
	 */
	private void sortHandByValue()
	{
		for(int i = 0; i < hand.length; i++)
		{
			int index = i;
			int minVal = hand[i].getValue();
			for(int j = i+1; j < hand.length; j++)
			{
				if(hand[j].getValue()< minVal)
				{
					index = j;
					minVal = hand[j].getValue();
				}
			}
			Card temp = hand[i];
			hand[i] = hand[index];
			hand[index] = temp;
		}
	}
	
	
	/*
	 * TODO write a method called getBestHand (sorting will help)
	 * this method will take no arguments and will return a String 
	 * identifying the best hand which can be made.  The possible hands 
	 * and return values are as follows. These are in order of precedence
	 * (the ones at the top are the best hands).
	 * return "Royal Flush" if all cards in the hand are the same
	 * 	  suit and the card ranks are A, K, Q, J, 10
	 * return "Straight Flush" if all cards are in the same suit
	 *    and the cards are all in consecutive order by value
	 *    ex.  7H, 8H, 9H, 10H, JH
	 * return "Four of a Kind" if there are four matching cards in hand
	 * 	  ex.  9D, 9H, 9S, 9C, 10D
	 * return "Flush" if all cards are the same suit.  Rank does
	 *    not matter.  Ex.  3S, 7S, 10S, KS, AS
	 * return "Straight" if all cards are in consecutive order
	 *    by value, but not the same suit.  Ex. 4H, 5C, 6H, 7D, 8S
	 * return "Full House" if there are a set of three matching
	 *    ranks and a separate set of two matching ranks.  
	 *    Ex. 4H, 4C, JD, JH, JS
	 * return "Three of a Kind" if there are three cards with the same
	 *    rank.  Ex 5C, 9H, QC, QH, QD
	 * return "Pair" if there are two matching ranks.  
	 *    Ex. 3D, 5D, 5H, KC, AH
	 * return "High (rank of highest card)" if none of the others apply
	 * 	  Ex.  3D, 6H, 10S, JD, QD would return "High Q"
	 */
	public String getBestHand() {
		sortHandByValue();
		
		boolean straightOrRoyalFlush = true;
		boolean flush = true;
		boolean straight = true;
		boolean hasThree = false; 
		boolean	hasTwo = false; 
		
		//Straight and Royal flush
		for (int i = 0; i<4; i++) {
			if (!((hand[i].getValue()+1 == hand[i+1].getValue() && flush)&&(hand[i].getSuit()==hand[i+1].getSuit()))) {
				straightOrRoyalFlush = false;
			}
			if (hand[i].getSuit()!=hand[i+1].getSuit()) {
				flush = false;
			}
		}
		if (straightOrRoyalFlush) {
			if (hand[0].getRank().equals("10") && 
				hand[1].getRank().equals("J") && 
				hand[2].getRank().equals("Q") && 
				hand[3].getRank().equals("K") && 
				hand[4].getRank().equals("A") ) {
				return "Royal Flush";
			}
			return "Straight Flush";
		}
		
		//Match val
		int [] matchVal = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		for (int i = 0; i<5; i++) {
			matchVal[hand[i].getValue()-2]++;
		}
		
		//Four of a kind and flush
		for (int i = 0; i<matchVal.length; i++) {
			if (matchVal[i]>=4) {return "Four of a Kind";}
		}
		if (flush) {return "Flush";}
		
		//Straight
		for (int i = 0; i<4; i++) {
			if (hand[i].getValue()+1 != hand[i+1].getValue() && straight) {
				straight = false;
			}
		}
		if (straight) {return "Straight";}
		
		//Rest
		for (int i = 0; i<matchVal.length; i++) {
			if (matchVal[i]==3) {hasThree = true;}
			else if (matchVal[i]==2) {hasTwo = true;}
		}
		
		if (hasThree&&hasTwo) {return "Full House";}
		else if (hasThree) {return "Three of a Kind";}
		else if (hasTwo) {return "Pair";}
		
		int highestVal = 0;
		int highestValPos = 0;
		for (int i = 0; i<5; i++) {
			if (hand[i].getValue()>highestVal) {
				highestValPos = i;
				highestVal = hand[i].getValue();
				}
		}
		return "High "+hand[highestValPos].getRank();
		
	}
	
	
	/*
	 * TODO write a toString method which returns a string containing
	 * the rank and suit of every card in the hand, separated by a comma
	 * Ex.  3D, 4D, 4D, 8S, KH
	 */
	public String toString() {
		String stringToReturn = "";
		
		for (int i = 0; i<4; i++) {
			stringToReturn += hand[i].getRank()+hand[i].getSuit()+", ";
		}
		stringToReturn += hand[4].getRank()+hand[4].getSuit();
		
		return stringToReturn;
	}
	
	
	/*
	 * TODO Write a method called discard.  The goal of this method is 
	 * to choose cards to discard and replace with new cards.  The 
	 * method should take two arguments, 
	 * the first will be an int array which will store the indexes of 
	 * hand which are to be replaced, and the second is a Card array 
	 * which will contain the new cards to be placed into hand.
	 * Ex.  hand contains 4H,4D,4C,JS,KC  
	 * 		given int[] arr = {3,4};
	 * 		and Card[] cards = {4S,AD} //using shorthand to demonstrate
	 * 		after discard(arr,cards);
	 * 		hand would now contain 4H,4D,4C,4S,AD
	 * 
	 */
	public void discard (int[] index, Card[] cardArr) {
		for (int i = 0; i<index.length; i++) {
			int tempIndex = index[i];
			hand[tempIndex] = cardArr[i];
		}
	}
}

