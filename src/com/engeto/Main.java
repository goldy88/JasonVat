package com.engeto;

import kong.unirest.*;
import kong.unirest.JsonNode;
import kong.unirest.HttpResponse;
import kong.unirest.GetRequest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

import java.util.*;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        GetRequest request = Unirest.get("http://jsonvat.com/");
        HttpResponse<JsonNode> jsonResponse = request.asJson();

        JsonNode json = jsonResponse.getBody();

        JSONObject jsonObject = json.getObject();
        JSONArray list = jsonObject.getJSONArray("rates");


        ArrayList<Country> countries = new ArrayList<>();
        for (Object elements : list) {
            JSONObject jsonElements = (JSONObject) elements;

            String name = jsonElements.getString("name");
            String code = jsonElements.getString("code");
            JSONObject periods = jsonElements.getJSONArray("periods").getJSONObject(0);
            JSONObject rates = periods.getJSONObject("rates");
            double standard = rates.getInt("standard");

            Country country = new Country(standard, name, code);
            countries.add(country);

        }

        Collections.sort(countries, new Comparator<Country>() {
            public int compare(Country o1, Country o2) {
                if (o1.standard < o2.standard)
                    return -1;
                else if (o1.standard < o2.standard)
                    return 1;
                return 0;
            }
        });


        for (int i = 0; i < 3; i++) {
            System.out.println("prvni zeme s nejnizsi sazbou je: " + countries.get(i));

        }

        System.out.println();

        for (int i = 1 ; i < 4; i++) {
            System.out.println("mezi tri zeme s nejvyssi standartni sazbou patri: " + countries.get(countries.size()-i));
        }


    }

}
