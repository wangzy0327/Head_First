package design.pattern._02_observer.jdkapi.push;

import design.pattern._02_observer.myself.DisplayElement;

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
        //因为这里采用“推”方式，所以arg为非null，通过参数传递
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            AllProperties properties = (AllProperties)arg;
            this.temperature = properties.getTemperature();
            this.humidity = properties.getHumidity();
            display();
        }
    }
}
