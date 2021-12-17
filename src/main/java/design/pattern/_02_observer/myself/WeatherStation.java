package design.pattern._02_observer.myself;

import java.util.ArrayList;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData(new ArrayList<Observer>());

        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4);
        weatherData.setMeasurements(82, 70, 29.2);
        weatherData.setMeasurements(78, 90, 29.2);

        System.out.println("---------------------------------------------------");

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1);
    }
    /**
     * Current conditions: 80.0F degrees and 65.0 % humidity
     * Avg/Max/Min temperature = 80.0/80.0/80.0
     * Forecast: Improving weather on the way!
     * Current conditions: 82.0F degrees and 70.0 % humidity
     * Avg/Max/Min temperature = 81.0/82.0/80.0
     * Forecast: Watch out for cooler, rainy weather
     * Current conditions: 78.0F degrees and 90.0 % humidity
     * Avg/Max/Min temperature = 80.0/82.0/78.0
     * Forecast: More of the same
     * ---------------------------------------------------
     * Current conditions: 62.0F degrees and 90.0 % humidity
     * Avg/Max/Min temperature = 75.5/82.0/62.0
     *
     */
}
