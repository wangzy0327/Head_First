package design.pattern._02_observer.myself;

import java.util.List;

public class WeatherData implements Subject{

    private List<Observer> observers;

    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observers)
            o.update(temperature,humidity,pressure);
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(double temperature,double humidity,double pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


}
