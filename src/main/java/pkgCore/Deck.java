package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	//COMPLETE: Fix the Draw method so it throws an exception if the deck is empty
	public Card Draw() throws DeckException {
		if(cardsInDeck.isEmpty()) throw new DeckException(this);
		return cardsInDeck.remove(0);
	}
	
	//COMPLETE: Write an overloaded Draw method to Draw a card of a given eSuit
	public Card Draw(eSuit s){
		Stream<Card> stream = cardsInDeck.stream();
		Card c = stream.filter(p -> p.geteSuit() == s).findFirst().get();
		cardsInDeck.remove(c);
		return c;
	}
	
	//COMPLETE: Write an overloaded Draw method to Draw a card of a given eRank
	public Card Draw(eRank r){
		Stream<Card> stream = cardsInDeck.stream();
		Card c = stream.filter(p -> p.geteRank() == r).findFirst().get();
		cardsInDeck.remove(c);
		return c;
	}
	
	//COMPLETE: Write a method that will return the number of a given eSuit left in the deck.
	public int Count(eSuit s){
		Stream<Card> stream = cardsInDeck.stream();
		return stream.filter(p -> p.geteSuit() == s).mapToInt(p -> 1).sum();
	}
	
	//COMPLETE: Write a method that will return the number of a given eRank left in the deck.
	public int Count(eRank r){
		Stream<Card> stream = cardsInDeck.stream();
		return stream.filter(p -> p.geteRank() == r).mapToInt(p -> 1).sum();
	}
	
	//COMPLETE: Write a method that will return 0 or 1 if a given card is left in the deck.
	public boolean Count(Card c){
		Stream<Card> stream = cardsInDeck.stream();
		return stream.anyMatch(p -> c.equals(p));
	}
}
