package homework6;

import homework6.entity.Weather;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherModel {
    void getWeather(String selectedCity, Period period) throws IOException, SQLException;

    public List<Weather> getSavedToDBWeather();
}