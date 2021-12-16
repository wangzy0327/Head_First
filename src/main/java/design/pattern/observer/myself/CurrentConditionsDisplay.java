package design.pattern.observer.myself;

public class CurrentConditionsDisplay implements Observer,DisplayElement{

    private double temperature;
    private double humidity;
    private Subject weatherData;

    /**
     * 构造器需要weatherData对象（也就是主题）作为注册之用
     * @param weatherData
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    /**
     * 只是把最近的温度和湿度展示出来
     */
    @Override
    public void display() {
        System.out.println("Current conditions: "+temperature
                +"F degrees and "+humidity+" % humidity");
    }

    /**
     * 当update()被调用时，我们把温度和湿度保存起来然后调用display()
     * @param temp
     * @param humidity
     * @param pressure
     */
    @Override
    public void update(double temp, double humidity, double pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }


}
