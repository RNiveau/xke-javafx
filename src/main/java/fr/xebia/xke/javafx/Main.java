package fr.xebia.xke.javafx;

import fr.xebia.xke.javafx.context.Context;
import fr.xebia.xke.javafx.domain.XebiaCards;
import fr.xebia.xke.javafx.services.api.IXebiaCardsService;
import fr.xebia.xke.javafx.services.api.XebiaCardsServiceImpl;
import fr.xebia.xke.javafx.utils.JfxUtils;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
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
        initPrimaryStage(primaryStage);
        initContext(primaryStage);
    }

    private void initContext(Stage primaryStage) {
        ExecutorService executorService;
        final Stage progressBar = openLoadingWindow();

        executorService = Executors.newSingleThreadExecutor();
        Task<XebiaCards> task = new Task<XebiaCards>() {
            @Override
            protected XebiaCards call() throws Exception {
                IXebiaCardsService xebiaCardsService = new XebiaCardsServiceImpl();
                return xebiaCardsService.getCards();
            }
        };
        task.setOnFailed((event) -> progressBar.close());
        task.setOnSucceeded(workerStateEvent -> {
            Context.getInstance().setXebiaCards((XebiaCards) workerStateEvent.getSource().getValue());
            Context.getInstance().setPrimaryStage(primaryStage);
            primaryStage.setScene(new Scene(JfxUtils.loadFxml("/fxml/screen.fxml")));
            progressBar.close();
        });
        executorService.submit(task);
        executorService.shutdown();
    }

    private void initPrimaryStage(Stage primaryStage) {
        primaryStage.setWidth(600);
        primaryStage.setHeight(Screen.getPrimary().getVisualBounds()
                .getHeight());
        primaryStage.setX(Screen.getPrimary().getVisualBounds().getMinX());
        primaryStage.setY(Screen.getPrimary().getVisualBounds().getMinY());
        primaryStage.setTitle("Xke JavaFX");
        primaryStage.show();
    }

    private Stage openLoadingWindow() {
        final Stage progressBar = new Stage();
        progressBar.initModality(Modality.WINDOW_MODAL);
        progressBar.setScene(new Scene(new Group(JfxUtils.loadFxml("/fxml/loading.fxml"))));
        progressBar.show();
        return progressBar;
    }
}
