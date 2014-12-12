package fr.xebia.xke.javafx;

import fr.xebia.xke.javafx.utils.JfxUtils;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by romainn on 12/12/2014.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    @SuppressWarnings("serial")
    public void start(Stage primaryStage) {
        primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds()
                .getHeight());
        primaryStage.setX(Screen.getPrimary().getVisualBounds().getMinX());
        primaryStage.setY(Screen.getPrimary().getVisualBounds().getMinY());
        primaryStage.setTitle("Xke JavaFX");
        primaryStage.setScene(new Scene((Parent) JfxUtils.loadFxml("/fxml/screen.fxml")));
        primaryStage.show();

        ExecutorService executorService;

        final Stage progressBar = openLoadingWindow(primaryStage);

        executorService = Executors.newSingleThreadExecutor();

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                //https://raw.githubusercontent.com/Nilhcem/xebia-essentials-android/master/essentials-android/src/main/res/raw/cards_data.json
                return null;
            }
        };
        task.setOnFailed((event) -> progressBar.close());
        task.setOnSucceeded(workerStateEvent -> progressBar.close());
        executorService.submit(task);
        executorService.shutdown();
    }

    private Stage openLoadingWindow(Stage stage) {
        final Stage progressBar = new Stage();
        progressBar.initModality(Modality.WINDOW_MODAL);
        progressBar.initOwner(stage.getScene().getWindow());
        progressBar.setScene(new Scene(new Group(JfxUtils.loadFxml("/fxml/loading.fxml"))));
        progressBar.show();
        return progressBar;
    }
}
