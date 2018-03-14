package pkgCore;
import pkgEnum.*;
public class Card implements Comparable {

	private eRank eRank;
	private eSuit eSuit;
	public Card(pkgEnum.eRank eRank, pkgEnum.eSuit eSuit) {
		super();
		this.eRank = eRank;
		this.eSuit = eSuit;
	}
	public Card(eSuit eSuit,eRank eRank) {
		super();
		this.eRank = eRank;
		this.eSuit = eSuit;
	}
	
	public eRank geteRank() {
		return eRank;
	}

	public eSuit geteSuit() {
		return eSuit;
	}

	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return c.geteRank().compareTo(this.geteRank());

}

	
	
}
