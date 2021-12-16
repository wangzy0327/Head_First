package design.pattern.observer.jdkapi.pull;


/**
 * 调用jdk自带 采用 pull 拉取方式
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        System.out.println("---------------------------------------------------");

        weatherData.deleteObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }

    /**
     * Forecast: Improving weather on the way!
     * Avg/Max/Min temperature = 80.0/80.0/80.0
     * Current conditions: 80.0F degrees and 65.0 % humidity
     * Forecast: Watch out for cooler, rainy weather
     * Avg/Max/Min temperature = 81.0/82.0/80.0
     * Current conditions: 82.0F degrees and 70.0 % humidity
     * Forecast: More of the same
     * Avg/Max/Min temperature = 80.0/82.0/78.0
     * Current conditions: 78.0F degrees and 90.0 % humidity
     * ---------------------------------------------------
     * Avg/Max/Min temperature = 75.5/82.0/62.0
     * Current conditions: 62.0F degrees and 90.0 % humidity
     */
}
