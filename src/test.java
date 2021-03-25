import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Deck deck = new Deck();
		//deck.shuffle();

		//ArrayList <String> content = new ArrayList<String>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File("Duplicate.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//7H, 8H, 9H, 10H, JH		

		boolean continueYes = true;

		while (continueYes) {

			String[] contentSuit = new String[5];
			Character[] contentSuitMain = new Character[5];
			String[] contentRank = new String[5];

			for(int i = 0; i<5; i++) {
				String temp = scan.next();
				String tempFinal = temp.replaceAll(",", "");
				contentSuit[i]=tempFinal.substring(1, 2);
				contentRank[i]=tempFinal.substring(0,1);
				if (contentRank[i].equals("1")) {
					contentRank[i]="10";
					contentSuit[i]=tempFinal.substring(2, 3);
				}
				
			}
			if (scan.hasNextLine()) {
			scan.nextLine();
			}
			for (int i = 0; i<5;i++) {
				contentSuitMain[i]=contentSuit[i].charAt(0);
			}

			Card cardOne = new Card(contentSuitMain[0], contentRank[0], test(contentRank[0],0));
			Card cardTwo = new Card(contentSuitMain[1], contentRank[1], test(contentRank[1],1));
			Card cardThree = new Card(contentSuitMain[2], contentRank[2], test(contentRank[2],2));
			Card cardFour = new Card(contentSuitMain[3], contentRank[3], test(contentRank[3],3));
			Card cardFive = new Card(contentSuitMain[4], contentRank[4], test(contentRank[4],4));


			Card[] cardArr = {cardOne, cardTwo, cardThree, cardFour, cardFive};
			PokerHand hand = new PokerHand(cardArr);



			System.out.println(hand.getBestHand());
			
			if (!scan.hasNextLine()) {
				continueYes = false;
			}
		}

	}

	public static int test(String str, int i) {

		if (str.equals("J")) {
			return 11;
		}
		if (str.equals("Q")) {
			return 12;
		}
		if (str.equals("K")) {
			return 13;
		}
		if (str.equals("A")) {
			return 14;
		}
		if (str.equals("1")) {
			return 10;
		}
		
		return Integer.parseInt(str);
	}

}
