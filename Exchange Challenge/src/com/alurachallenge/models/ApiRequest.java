package com.alurachallenge.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    String fromCode;
    String toCode;
    private double exchangeRate;

    public ApiRequest(String fromCode, String toCode) {
        this.fromCode = fromCode;
        this.toCode = toCode;
    }

    public ExchangeApi getInfo(){
        String url = "https://v6.exchangerate-api.com/v6/ea99cdfff4e13f2d4feeef8b/pair/" + "" +
                this.fromCode + "/" + this.toCode;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            ExchangeApi exchangeApi = gson.fromJson(json, ExchangeApi.class);

            return exchangeApi;

        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
