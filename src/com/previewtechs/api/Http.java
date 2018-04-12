package com.previewtechs.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Http {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://myaccount.previewtechs.com")
                .build();

        AccessTokenServiceInterface service = retrofit.create(AccessTokenServiceInterface.class);

        //grant types = client_credentials
        Call<TokenResponse> call = service.getToken("OAUTH CLIENT ID", "CLIENT SECRET", "basic email", "client_credentials");
        try {
            Response<TokenResponse> response = call.execute();
            System.out.println(response.body().getAccessToken());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
