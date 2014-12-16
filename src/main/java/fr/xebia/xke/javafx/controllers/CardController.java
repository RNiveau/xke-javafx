package fr.xebia.xke.javafx.controllers;

import fr.xebia.xke.javafx.context.Context;
import fr.xebia.xke.javafx.domain.Card;
import fr.xebia.xke.javafx.utils.JfxUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.stage.Screen;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by romainn on 15/12/2014.
 */
public class CardController implements Initializable {

    @FXML
    public Label title;

    @FXML
    public WebView description;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        Card selected = Context.getInstance().getSelected();
        title.setText(selected.getTitle());
        description.getEngine().loadContent(selected.getDescription());
        description.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight() - 200);
    }

    public void back(ActionEvent event) {
        Context.getInstance().getPrimaryStage().setScene(new Scene(JfxUtils.loadFxml("/fxml/screen.fxml")));
    }
}
