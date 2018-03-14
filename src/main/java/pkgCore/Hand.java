package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;

public class Hand {

	private int iScore;
	private ArrayList<Card> HandCards = new ArrayList<Card>();
	
	public Hand()
	{
		
	}
	
	public int[] ScoreHand()
	{
		int [] iScore = new int[2];
		
		iScore[0] = 0;
		iScore[1] = 0;
		
		boolean bAce = false;
		for(Card c: HandCards) {
			switch(c.geteRank()) {
			case TWO:
			case THREE:
			case FOUR:
			case FIVE:
			case SIX:
			case SEVEN:
			case EIGHT:
			case NINE:
			case TEN:
				iScore[0] += c.geteRank().getiRankNbr();
				break;
			case JACK:
			case QUEEN:
			case KING:
				iScore[0] += 10;
				break;
			case ACE:
				iScore[0] += 1;
				bAce = true;
			}
			//iScore[0] += c.geteRank().getiCardValueMin();
			if (c.geteRank() == eRank.ACE)
				bAce = true;
		}
		iScore[1] = (bAce) ? iScore[0]+ eRank.ACE.getiCardValueMax()-eRank.ACE.getiCardValueMin() : iScore[0];
		//Collections.sort(HandCards);
		
		
		for (Card c: HandCards)
		{
			iScore[0] += c.geteRank().getiCardValueMin();
			iScore[1] += c.geteRank().getiCardValueMax();
			//	TODO: Determine the score.  
			//			Cards:
			//			2-3-4 - score = 11
			//			5-J-Q - score = 25
			//			5-6-7-2 - score = 20
			//			J-Q	- score = 20
			//			8-A = score = 9 or 19
			//			4-A = score = 5 or 15
		}
		SetHandScore(iScore);
		return iScore;
	}
	
	public void Draw(Deck d) throws Exception
	{
		HandCards.add(d.draw());
		//	TODO: add a card to 'cards' from a card drawn from Deck d
	}
	
	private void AddCard(Card c)
	{
		HandCards.add(c);
	}
	
	public boolean bCanDealerHit() {
		boolean bDraw = false;
		
		for(int iScore : ScoreHand()) {
			if(iScore >= 17)
				return false;
		}
		return true;
	}
	
	public boolean bCanPlayerDraw() {
		for (int iScore: ScoreHand()) {
			if (iScore <21)
				return true;
		}
		return false;
	}
	
	public boolean isBlackJack() {
		int[] iScores = ScoreHand();
		
		if ((iScores[0] == 21) && (HandCards.size() == 2))
			return true;
		return false;
	}
	public void SetHandScore(int[] Scores) {
		
		this.iScore = Scores[0];
		if (Scores[1] <= 21)
			iScore = Scores[1];
		
	}
}
