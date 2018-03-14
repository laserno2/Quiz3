package pkgCore;
import pkgEnum.*;
import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	
	private ArrayList<Card> cards = new ArrayList<Card>(52);
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public Deck(int iNumOfDecks) throws Exception {
		if (iNumOfDecks <1)
			throw new Exception("NumOfDecks <1");
		for(int a = 0; a < iNumOfDecks; a++) {
			for(eSuit eSuit: eSuit.values()) {
				for(eRank eRank: eRank.values()) {
					cards.add(new Card(eRank,eSuit));
				}
			}
			Collections.shuffle(cards);
		}
	}
	
	public Deck() throws Exception{
		this(1);
	}
	
	public Card draw() throws Exception {
		if (cards.size() == 0) {
			throw new Exception("Empty Deck");
		}
		return cards.remove(0);
	}
	
	public int getRemaining(Object eNum) {
        int remaining = 0;
        if(eNum instanceof eSuit) {
            for (Card c : this.cards) {
                if (c.geteSuit() == eNum) {
                    remaining ++;
                }
            }
        }
        else {
            for (Card c : this.cards) {
                if (c.geteRank() == eNum) {
                    remaining ++;
                }
            }
        }  
        return remaining;
    }
}
