package design.pattern.observer.jdkapi.pull;

import design.pattern.observer.myself.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk 自带 Observer
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: "+temperature
                +"F degrees and "+humidity+" % humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        //对应notifyObservers();
        //因为这里采用“拉”方式，所以arg为null，需要自己获取值
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
