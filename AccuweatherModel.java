package homework6;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework6.entity.Weather;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "pXJd8MokcZCdrd2MsoGl2DBZAyCa0zvv";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    //private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather(String selectedCity, Period period) throws IOException, SQLException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();

                String weatherResponse = oneDayForecastResponse.body().string();

                String localDate = objectMapper.readTree(weatherResponse)
                        .at("/DailyForecasts")
                        .get(0).at("/Date")
                        .asText();

                double temperature = objectMapper.readTree(weatherResponse).at("/DailyForecasts")
                        .get(0)
                        .at("/Temperature/Maximum/Value")
                        .asDouble();

                temperature = (temperature - 32) * (5.0 / 9.0);
                System.out.println("Температура воздуха в городе " + selectedCity + " на " +
                        localDate.split("T")[0] + " составит " + temperature +
                        " градусов по Цельсию");

                Weather weather = new Weather(selectedCity, localDate.split("T")[0], temperature);
                DataBaseRepository dataBaseRepository = new DataBaseRepository();
                dataBaseRepository.saveWeatherToDataBase(weather); //- тут после парсинга добавляем данные в БД


                break;

            case FIVE_DAYS:
                HttpUrl httpUrlFiveDays = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request requestFiveDays = new Request.Builder()
                        .url(httpUrlFiveDays)
                        .build();

                Response fiveDaysForecastResponse = okHttpClient.newCall(requestFiveDays).execute();
                String weatherResponseFiveDays = fiveDaysForecastResponse.body().string();

                int weatherElements = objectMapper.readTree(weatherResponseFiveDays).at("/DailyForecasts").size();
                for (int i = 0; i < weatherElements; i++) {
                    String localDateFiveDays = objectMapper.readTree(weatherResponseFiveDays)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Date")
                            .asText();
                    String weatherDay = objectMapper.readTree(weatherResponseFiveDays)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Day/IconPhrase")
                            .asText();
                    double dayMaxTemperature = objectMapper.readTree(weatherResponseFiveDays)
                            .at("/DailyForecasts")
                            .get(i)
                            .at("/Temperature/Maximum/Value")
                            .asDouble();
                    dayMaxTemperature = (dayMaxTemperature - 32) * (5.0 / 9.0);

                    System.out.println("Погода в городе " + selectedCity + " на " + localDate.split("T")[0]
                            + " " + weatherDay + ", температура воздуха днем составит " + dayMaxTemperature +
                            " градусов по Цельсию");

                    break;
                }
        }


        private String detectCityKey (String selectCity) throws IOException {
            //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOKOL)
                    .host(BASE_HOST)
                    .addPathSegment(LOCATIONS)
                    .addPathSegment(VERSION)
                    .addPathSegment(CITIES)
                    .addPathSegment(AUTOCOMPLETE)
                    .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                    .addQueryParameter("q", selectCity)
                    .build();

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .get()
                    .addHeader("accept", "application/json")
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();

            String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
            return cityKey;
        }
    }

    @Override
    public List<Weather> getSavedToDBWeather () {
        return dataBaseRepository.getSavedToDBWeather();
    }

}
