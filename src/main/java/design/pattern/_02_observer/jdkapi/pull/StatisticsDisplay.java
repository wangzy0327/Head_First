package design.pattern._02_observer.jdkapi.pull;

import design.pattern._02_observer.myself.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk 自带 Observer
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private Observable observable;
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum= 0.0f;
    private int numReadings;

    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(Observable o, Object arg) {
        //对应notifyObservers();
        //因为这里采用“拉”方式，所以arg为null，需要自己获取值
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            tempSum += weatherData.getTemperature();
            numReadings++;

            if (weatherData.getTemperature() > maxTemp) {
                maxTemp = weatherData.getTemperature();
            }

            if (weatherData.getTemperature() < minTemp) {
                minTemp = weatherData.getTemperature();
            }
            display();
        }
    }
}
