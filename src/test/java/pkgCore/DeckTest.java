package pkgCore;
import static org.junit.Assert.*;
import org.junit.Test;
public class DeckTest {
	@Test
	public void TestDeck() throws Exception {
		Deck d = new Deck(1);
		assertEquals(d.getCards().size(),52);
		Deck e = new Deck(6);
		assertEquals(e.getCards().size(),312);
	}
}