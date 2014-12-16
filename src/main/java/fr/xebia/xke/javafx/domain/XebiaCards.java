package fr.xebia.xke.javafx.domain;

import java.util.List;

/**
 * Created by romainn on 15/12/2014.
 */
public class XebiaCards {

    private List<Category> categories;

    private List<Card> cards;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
