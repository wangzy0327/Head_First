package design.pattern.observer.myself;

public interface Observer {
    /**
     * 当气象观测值改变时，主题会把这些状态值当做方法的参数，传递给观察者
     * 所有的观察者必须实现update()方法
     * @param temp
     * @param humidity
     * @param pressure
     */
    public void update(double temp,double humidity,double pressure);
}
