/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.weatherradar;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author ana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.ipma.pt/open-data/")
            .addConverterFactory(GsonConverterFactory. create ())
            .build();
        IpmaService service = retrofit.create(IpmaService.class);
        GetCityService cityService = retrofit.create(GetCityService.class);
        String city = args[0];
        Call<City> callSyncCity = cityService.getCity();
        try{
            int city_id = 0;
            Response<City> response = callSyncCity.execute();
            City forecastCity = response.body();
            for(CityDetails x : forecastCity.getData()){
                if( city.equals(x.getLocal())){
                    city_id = x.getGlobalIdLocal();              
                }
            }
            System.out.println(city_id);
            Call<IpmaCityForecast> callSync = service.getForecastForACity( city_id );
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();
            System. out .println( "max temp for today: " + forecast.getData().
            listIterator().next().getTMax());
        } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
    
}
