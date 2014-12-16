package fr.xebia.xke.javafx.controllers;

import fr.xebia.xke.javafx.context.Context;
import fr.xebia.xke.javafx.domain.Card;
import fr.xebia.xke.javafx.domain.Category;
import fr.xebia.xke.javafx.utils.JfxUtils;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by romainn on 12/12/2014.
 */
public class ScreenController implements Initializable {

    @FXML
    public VBox vBox;

    private static Function<Card, VBox> mapCardVbox = card -> {
        Optional<Category> category = Context.getInstance().getXebiaCards().getCategories().stream().filter(cat -> cat.getId().equals(card.getCategory())).findFirst();

        VBox vbox = new VBox();
        vbox.getStyleClass().add("list-cards");

        Text text = new Text(card.getTitle());
        text.getStyleClass().add("title");

        vbox.setOnMouseClicked(event -> {
            ScaleTransition scaleTransition =
                    new ScaleTransition(Duration.millis(1000), (Node) event.getSource());
            scaleTransition.setToX(2f);
            scaleTransition.setToY(2f);
            scaleTransition.setOnFinished(e -> {
                Context.getInstance().setSelected(card);
                Context.getInstance().getPrimaryStage().setScene(new Scene(JfxUtils.loadFxml("/fxml/card.fxml")));
            });
            scaleTransition.play();
        });
        vbox.getChildren().add(text);

        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.loadContent("<html><body style='background-color: " + category.get().getColor() + "' >" + card.getSummary() + "</body></html>");
        webView.setPrefHeight(200);
        webView.setPrefWidth(500);
        vbox.getChildren().add(webView);
        return vbox;
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox.getChildren().addAll(Context.getInstance().getXebiaCards().getCards().stream().map(mapCardVbox).collect(Collectors.toList()));
    }
}
