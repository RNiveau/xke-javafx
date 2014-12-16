package fr.xebia.xke.javafx.services.api;

import fr.xebia.xke.javafx.domain.XebiaCards;
import retrofit.RestAdapter;

/**
 * Created by romainn on 15/12/2014.
 */
public class XebiaCardsServiceImpl implements IXebiaCardsService {
    @Override
    public XebiaCards getCards() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://raw.githubusercontent.com")
                .build();
        IXebiaCardsService xebiaCardsService = restAdapter.create(IXebiaCardsService.class);
        return xebiaCardsService.getCards();
    }
}
