/**
 * 
 * @author Shreeniket Bendre
 * Project: Poker Hand
 * File: Deck.java
 *
 */
public class Deck 
{
	
	/*
	 * TODO create a Card array field which represents the cards
	 * in the deck.   Also create an int field called nextToDeal
	 * which will identify the next index to deal. This field will
	 * start at 0 and will be incremented each time a card is "dealt".
	 * when nextToDeal = the length of cards, there are no cards left
	 * to deal
	 * 
	 */
	private Card[] cardArray;
	private int nextToDeal;
	/*
	 * TODO create a deck constructor which requires no arguments.
	 * The constructor will generate a standard deck of playing
	 * cards. The values of the playing cards will be from 2-14 where
	 * a rank of "2" has a value of 2 and a rank of "A" has a value 
	 * of 14.
	 * 
	 * I suggest creating arrays for all possible values, ranks, and
	 * suits.   You can then use two nested for loops to create the deck
	 * 
	 */
	public Deck() {
		cardArray = new Card[52];
		nextToDeal = 0;
		
		String[] rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		int[] value = {2,3,4,5,6,7,8,9,10,11,12,13,14};
		char[] suit = {'H','C','D','S'};
		
		int count = 0;
		
		for (int i = 0; i<4; i++) {
			for (int j = 0; j<13; j++) {
				Card card = new Card(suit[i], rank[j], value[j]);
				cardArray[count] = card;
				count++;
			}
		}
		
	}
	
	/*
	 * TODO create a method called shuffle which will arrange all cards
	 * in the array cards in a random order and reset nextToDeal to zero.
	 * 
	 */
	public void shuffle() {
		for (int i = 0; i<52; i++) {
			int indexToShuffle = (int)((Math.random()*51)+1);
			Card temp = cardArray[indexToShuffle];
			cardArray[indexToShuffle] = cardArray[i];
			cardArray[i] = temp;
		}
//		for(int i = 0; i < 52; i++) {
//			System.out.println(i+"|"+cardArray[i].toString());
//		}
		nextToDeal = 0;
	}
	
	/*
	 * TODO create a method called deal which takes no arguments. 
	 * it should return the card at nextToDeal and increment the field
	 * nextToDeal.  If there are no cards left to deal, return null.
	 */
	public Card deal() {
		
		if (nextToDeal<52) {
			Card returnCard = cardArray[nextToDeal];
			nextToDeal++;
			return returnCard;
		}
		
		return null;
	}
	
}
