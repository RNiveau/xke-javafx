package fr.xebia.xke.javafx.services.api;

import fr.xebia.xke.javafx.domain.XebiaCards;
import retrofit.http.GET;

/**
 * Created by romainn on 15/12/2014.
 */
public interface IXebiaCardsService {

    @GET("/Nilhcem/xebia-essentials-android/master/essentials-android/src/main/res/raw/cards_data.json")
    XebiaCards getCards();

}
