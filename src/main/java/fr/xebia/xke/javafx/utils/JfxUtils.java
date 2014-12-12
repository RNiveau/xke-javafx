package fr.xebia.xke.javafx.utils;

import fr.xebia.xke.javafx.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Created by romainn on 13/08/2014.
 */
public class JfxUtils {

    static public Node loadFxml(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(Main.class.getResource(fxml));
            Node root = loader.load(Main.class.getResource(fxml).openStream());
            return root;
        } catch (IOException e) {
            throw new IllegalStateException("cannot load FXML screen", e);
        }
    }


}
