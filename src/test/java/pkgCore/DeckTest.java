package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {

	@Test (expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException {
		//COMPLETE: Build a deck, draw until you get a DeckException
		Deck d = new Deck();
		for (int i = 0; i<54; i++) {
			d.Draw();
			
		}

	}
	
	@Test
	public void TestDrawSuit() {
		//COMPLETE: Build a deck, test the Draw(eSuit) method
		Deck d1 = new Deck();
		Card c = d1.Draw(eSuit.SPADES);
		assertTrue(c.geteSuit() == eSuit.SPADES);
		
	}
	
	@Test
	public void TestDrawRank() {
		//COMPLETE: Build a deck, test the Draw(eRank) method
		Deck d2 = new Deck();
		Card d = d2.Draw(eRank.KING);
		assertTrue(d.geteRank() == eRank.KING);
		

	}
	
	@Test
	public void TestDeckRankCount() {
		//COMPLETE: Build a deck, test the DeckRankCount method
		Deck d3 = new Deck();
		assertTrue(d3.Count(eRank.FIVE) == 4);

	}
	
	@Test
	public void TestDeckSuitCount() {
		//COMPLETE: Build a deck, test the DeckSuitCount method
		Deck d4 = new Deck();
		assertTrue(d4.Count(eSuit.CLUBS) == 13);

	}

}