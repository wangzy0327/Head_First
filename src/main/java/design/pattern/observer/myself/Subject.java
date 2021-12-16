package design.pattern.observer.myself;

public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    public void registerObserver(Observer o);

    /**
     * 删除观察者
     * @param o
     */
    public void removeObserver(Observer o);

    /**
     * 当主题状态改变时，这个方法会被调用，以通知所有的观察者
     */
    public void notifyObservers();
}
