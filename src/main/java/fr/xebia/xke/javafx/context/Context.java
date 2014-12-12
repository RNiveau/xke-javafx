package fr.xebia.xke.javafx.context;

/**
 * Created by romainn on 12/12/2014.
 */
public class Context {

    private static Context instance = new Context();

    private Context() {

    }

    public static Context getInstance() {
        return instance;
    }

}
