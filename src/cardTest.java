import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class cardTest {

	public static void main(String[] args) throws FileNotFoundException 
	{
		char[] suit = {'H','D','C','S'};
		int[] val = {2,3,4,5,6,7,8,9,10,11,12,13,14};
		String[] rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		String filename = "comments.txt";

		PrintWriter out = new PrintWriter(filename);
		
		
		double score = 0;
		double total = 0;
	
//		out.println("PokerHand Constructor args incorrects: -40");
//		score-=40;
		
		
		PokerHand hand = new PokerHand();
		
		total+=2;
		if(hand.getBestHand().equals("Royal Flush")) score+=2;
		for(int attempts = 0; attempts<10; attempts++)
		{
			for(int i = 0; i < 4; i++)
			{
				Card[] cards = null;
				try{Card[] c = {new Card(suit[i],"10",10),new Card(suit[i],"K",13),new Card(suit[i],"Q",12),new Card(suit[i],"J",11),new Card(suit[i],"A",14)};
				cards = c;
				shuffle(cards);
				}
				catch(Exception e)
				{
					out.println("Card Constructor failed");
					out.println("Score: 0");
					out.close();
					System.exit(0);
				}
				try {
				hand = new PokerHand(cards);
				}
				catch(Exception e)
				{
					out.println("PokerHand constructor failed");
					out.println("Score: 10");
					out.close();
					System.exit(0);
				}
				total+=2;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Royal Flush")) score+=2;
				else out.println(hand + " Royal Flush::You returned: " +hand.getBestHand()+"Deduction:2");
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run. Deduction: 2");
					
				}
			}
			
			for(int i = 2; i < 9; i++)
			{
				int j = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[j],"" + i,i),new Card(suit[j],"" + (i+1),i+1),new Card(suit[j],"" + (i+2),i+2),new Card(suit[j],"" + (i+3),i+3),new Card(suit[j],"" + (i+4),i+4)};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try{
					if(hand.getBestHand().equalsIgnoreCase("Straight Flush")) score++;
				
					else out.println(hand + " Straight Flush::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			for(int i = 2; i < 9; i++)
			{
				int j = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[j],""+i,i),new Card(suit[(j+1)%4],""+(i+1),i+1),new Card(suit[j],""+(i+2),i+2),new Card(suit[j],""+(i+3),i+3),new Card(suit[j],""+(i+4),i+4)};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Straight")) score++;
				else out.println(hand + " Straight::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			for(int i = 1; i < 9; i++)
			{
				int j = (int)(Math.random()*13);
				int s = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[s],rank[j],val[j]),new Card(suit[s],rank[j=(j+6)%13],val[j]),new Card(suit[s],rank[j=(j+6)%13],val[j]),new Card(suit[s],rank[j=(j+6)%13],val[j]),new Card(suit[s],rank[j=(j+6)%13],val[j])};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Flush")) score++;
				else out.println(hand + " Flush::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			for(int i = 1; i < 9; i++)
			{
				int j = (int)(Math.random()*13);
				int s = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[s],rank[j],val[j]),new Card(suit[(s+1)%4],rank[j],val[j]),new Card(suit[s],rank[j=(j+1)%13],val[j]),new Card(suit[(++s)%4],rank[j],val[j]),new Card(suit[(++s)%4],rank[j],val[j])};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Full House")) score++;
				else out.println(hand + " Full House::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			for(int i = 1; i < 9; i++)
			{
				int j = (int)(Math.random()*13);
				int s = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[s],rank[j],val[j]),new Card(suit[(++s)%4],rank[(j+2)%13],val[(j+2)%13]),new Card(suit[(++s)%4],rank[j=(j+1)%13],val[j]),new Card(suit[(++s)%4],rank[j],val[j]),new Card(suit[(++s)%4],rank[j],val[j])};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Three of a Kind")) score++;
				else out.println(hand + " 3ok::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			
			for(int i = 1; i < 9; i++)
			{
				int j = (int)(Math.random()*13);
				int s = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[s],rank[j],val[j]),new Card(suit[(++s)%4],rank[(j+1)%13],val[(j+1)%13]),new Card(suit[(++s)%4],rank[(j+1)%13],val[j=(j+1)%13]),new Card(suit[(++s)%4],rank[j],val[j]),new Card(suit[(++s)%4],rank[j],val[j])};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Four of a Kind")) score++;
				else out.println(hand + " 4ok::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			for(int i = 1; i < 9; i++)
			{
				int j = (int)(Math.random()*13);
				int s = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[s],rank[j],val[j]),new Card(suit[(s+1)%4],rank[j],val[j]),new Card(suit[(++s)%4],rank[j=(j+1)%13],val[j]),new Card(suit[(++s)%4],rank[j],val[j]),new Card(suit[(++s)%4],rank[(j+1)%13],val[(j+1)%13])};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Pair")) score++;
				else out.println(hand + " Pair::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			for(int i = 1; i < 9; i++)
			{
				int j = (int)(Math.random()*13);
				int s = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[s],rank[j],val[j]),new Card(suit[(s+1)%4],rank[j],val[j]),new Card(suit[s],rank[j=(j+1)%13],val[j]),new Card(suit[s],rank[(j+2)%13],val[(j+2)%13]),new Card(suit[s],rank[j=(j+1)%13],val[j])};
				shuffle(cards);
				hand = new PokerHand(cards);
				total++;
				try {
				if(hand.getBestHand().equalsIgnoreCase("Pair")) score++;
				else out.println(hand + " Pair::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getBestHand failed to run.  Deduction: 1");
				}
			}
			
			for(int i = 0; i < 10; i++)
			{
				int j = (int)(Math.random()*13);
				int s = (int)(Math.random()*4);
				Card[] cards = {new Card(suit[s],rank[j],val[j]),new Card(suit[(s+1)%4],rank[j=(j+6)%13],val[j]),new Card(suit[s],rank[j=(j+6)%13],val[j]),new Card(suit[s],rank[j=(j+6)%13],val[j]),new Card(suit[s],rank[j=(j+6)%13],val[j])};
				shuffle(cards);
				int max = 0;
				total++;
				try{
				for(Card card: cards)
				{
					if(card.getValue()>max)
						max=card.getValue();
				}
				hand = new PokerHand(cards);
				
				if(hand.getBestHand().trim().equalsIgnoreCase("High " + rank[max-2])) score++;
				else out.println(hand + " High " + rank[max-2]+"::You returned: " +hand.getBestHand());
				}
				catch(Exception e)
				{
					out.println(hand + " getValue failed to run.  Deduction: 1");
				}
			}
		}
		
		try {
		hand = new PokerHand();
		
		Card[] newCards = {new Card('C',"2",2),new Card('C',"2",2)};
		int[] replace = {0,1};
		hand.discard(replace, newCards);
		if(hand.toString().equalsIgnoreCase("2C, 2C, QH, JH, 10H") || 
				hand.toString().equalsIgnoreCase("2C, 2C, QH, KH, AH"))
			score+=25;
		else out.println("discard incorrect: -25");
		
		
		hand = new PokerHand();
		Card[] newCards2 = {new Card('C',"2",2),new Card('C',"2",2), new Card('C',"2",2)};
		int[] replace2 = {1,2,3};
		hand.discard(replace2, newCards2);
		if(hand.toString().equalsIgnoreCase("AH, 2C, 2C, 2C, 10H") || 
				hand.toString().equalsIgnoreCase("10H, 2C, 2C, 2C, AH"))
			score+=25;
		else
			out.println("discard incorrect: -25");
		}catch(Exception e)
		{
			out.println("discard failed. Deduction: 10");
		}
		

		
		
		total += 50;
		
		Card[] c1=null;
		int cardCount = 0;
		
		try {
			Deck deck = new Deck();
			Card[] deckCards = new Card[52];
			c1=deckCards;
			for(int i = 0; i<52; i++)
			{
				deckCards[i]=deck.deal();
			}
			char[] suits = {'H','D','C','S'};
			String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
			int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
			
			for(int s = 0; s < 4; s++)
			{
				for(int r = 0; r<ranks.length; r++)
				{
					boolean found = false;
					for(Card c : deckCards)
					{
						if(c.getValue()==values[r] && c.getRank().equals(ranks[r])&&c.getSuit()==suits[s])
							found=true;
					}
					if(found)
						cardCount++;
					else out.println("didn't find " + ranks[r]+suits[s]);
				}
			}
		}catch(Exception e)
		{
			out.println("Error in Deck Constructor/Deal Method");
		}
		
		if(cardCount==52)
			score+=15;
		else out.println("Deck missing cards: -15");
		total+=15;		
//		try
//		{
			Deck deck2 = new Deck();
			deck2.shuffle();
			Card[] c2 = new Card[52];
			for(int i =0;i<52;i++)
			{
				c2[i]=deck2.deal();
			}
			int same = 0;
			for(int i=0;i<52;i++)
			{
				if(c2[i].getValue()==c1[i].getValue()&&c2[i].getRank().contentEquals(c1[i].getRank())&&c2[i].getSuit()==c1[i].getSuit())
					same++;
			}
			if(same>25)
				out.println("Cards not shuffled properly. Deduction: 10");
			else
				score+=10;
			int count =0;
			for(Card c : c2)
			{
				boolean found = false;
			
				for(Card n : c1)
				{
					if(n.getRank().equals(c.getRank())&&n.getValue()==c.getValue()&&n.getSuit()==c.getSuit())
						{found = true;
						break;}
				}
				if(found) count++;
				
			}
			if(count<52)
				out.println("Cards lost in shuffle. Deduction: 10");
			else score+=10;
		//}
//		catch(Exception e)
//		{
//			out.println("Error in Deck. Deduction: 20");
//		}
//		out.println("Error in Shuffle. Deduction: 20");

		total+=20;
		

		
		
		
		
		
		
		out.println("score: " + score);
		out.println("total: " +total);
		out.println("percent: " +score/total*100);
		//out.print("points: " + score/total * 40);
		out.close();
		
	}
	
	private static void shuffle(Card[] cards)
	{
		for(int i = 0; i<cards.length; i++)
		{
			int index = (int)(Math.random() * cards.length);
			Card temp = cards[index];
			cards[index]= cards[i];
			cards[i]=temp;
		}
	}
	


}
