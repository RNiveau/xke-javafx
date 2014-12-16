package fr.xebia.xke.javafx.context;

import fr.xebia.xke.javafx.domain.Card;
import fr.xebia.xke.javafx.domain.XebiaCards;
import javafx.stage.Stage;

/**
 * Created by romainn on 12/12/2014.
 */
public class Context {

    private static Context instance = new Context();

    private Card selected;

    private Stage primaryStage;

    private XebiaCards xebiaCards;

    private Context() {

    }

    public static Context getInstance() {
        return instance;
    }

    public XebiaCards getXebiaCards() {
        return xebiaCards;
    }

    public void setXebiaCards(XebiaCards xebiaCards) {
        this.xebiaCards = xebiaCards;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Card getSelected() {
        return selected;
    }

    public void setSelected(Card selected) {
        this.selected = selected;
    }
}
