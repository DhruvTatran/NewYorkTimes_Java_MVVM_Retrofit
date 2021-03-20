package com.android.newyorktimes.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* Singleton Pattern
* */
public class NetworkCall {
    private static NetworkCall instance;
    private Services servicesInstance;

    private NetworkCall() {}

    public static NetworkCall getInstance() {
        if(instance == null)
            instance = new NetworkCall();

        return instance;
    }

    public Services getService() {
        if(servicesInstance != null)
            return servicesInstance;
        else {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(NetworkConstants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            servicesInstance = retrofit.create(Services.class);
            return servicesInstance;
        }
    }
}
