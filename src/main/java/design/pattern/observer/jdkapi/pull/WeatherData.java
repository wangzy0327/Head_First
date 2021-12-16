package design.pattern.observer.jdkapi.pull;

import java.util.Observable;

/**
 * jdk自带 有 pull(拉) 和 push(推) 两种方式
 * Observable is Deprecated(since="9")
 * 被观察者
 *
 * pull 方式 按需拉取内容，根据每个观察者自己的需求取得自己的数据，需要多次调用被观察者的get属性方法
 *
 * 我们不再需要追踪观察者了，也不在需要管理注册与删除(超类代劳即可)
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementsChanged(){
        //setChanged()方法可以让你在更新观察者是，有更多的弹性，你可以更适当地通知观察者。
        //比方说，如果没有setChanged()方法，我们的气象站是如此敏锐，以致于温度计读数每十分之一度就会更新，
        //这会造成WeatherData对象持续不断地通知观察者，我们并不希望看到这样的事情发生
        //如果我们希望半度以上才更新，就可以在温度差达到半度时，调用setChanged()，进行有效的更新
        setChanged();
        //这里没有调用notifyObservers()传送数据对象，这表示我们采用的做法是“拉”
        //会判断是否changed为true
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
