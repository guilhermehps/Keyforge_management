package com.KeyforgeManagement.application.data.api;

import com.KeyforgeManagement.application.data.model.Deck;
import com.KeyforgeManagement.application.data.model.wrapperDecksOfKeyforge.GlobalStatistics;
import com.KeyforgeManagement.application.data.model.wrapperDecksOfKeyforge.SingleDeckReference;
import com.KeyforgeManagement.application.data.model.wrapperMasterVault.Kmvresults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Api {

    private static final String BASE_URL_DOK = "https://decksofkeyforge.com/api/";
    private static final String BASE_URL_KMV = "https://www.keyforgegame.com/api/";

    private static final KeyforgeMasterVaultApi APIKMV = new Retrofit.Builder()
            .baseUrl(BASE_URL_KMV)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KeyforgeMasterVaultApi.class);

    private static final DecksOfKeyforgeApi APIDOK = new Retrofit.Builder()
            .baseUrl(BASE_URL_DOK)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DecksOfKeyforgeApi.class);

    public static Call<List<Deck>> getDecks(String deckName) {
        return APIDOK.getDecks(deckName);
    }

    public static Call<Kmvresults> getCards(String deckId) {
        return APIKMV.getCards(deckId);
    }

    public static Call<List<GlobalStatistics>> getStats() {
        return APIDOK.getStatistics();
    }

    public static Call<SingleDeckReference> getDeckFromId(String deckId) {
        return APIDOK.getDeckFromId(deckId);
    }

    private Api() {
    }
}
