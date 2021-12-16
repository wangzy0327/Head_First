package design.pattern.observer.ugly;

/**
 * 此系统中的三个部分是气象站(获取实际气象数据的物理装置)、WeatherData对象(追踪来自气象站的数据，并更新布告板)
 * 和 布告板(显示目前天气状况给用户看)
 *
 * WeatherData对象知道如何跟物理气象站联系，以取得更新的数据。WeatherData对象会随即更新三个布告板的显示：
 * 目前状况（温度、湿度、气压）、气象统计和天气预报。
 *
 */

/**
 * 当新的测量数据备妥时，measurementsChanged()方法就会被调用（我们不在乎此方法是如何被调用的，我们只在乎它被调用了）。
 * 我们需要实现 三个使用天气数据的布告板：“目前状况”布告、“气象统计”布告、“天气预告”布告。一旦WeatherData有新的测量，这些布告必须马上更新。
 * 此系统必须可扩展，让其他开发人员建立定制的布告板，用户可以随心所欲或删除任何布告板。目前初始的布告板有三类：“目前状况”布告、“气象统计”布告、“天气预告”布告
 *
 */
public class WeatherData {
    /**
     * 温度
     * @return
     */
    public double getTemperature(){
        return 0.0;
    }

    /**
     * 湿度
     * @return
     */
    public double getHumidity(){
        return 0.0;
    }

    /**
     * 气压
     * @return
     */
    public double getPressure(){
        return 0.0;
    }

    public void measurementsChanged(){
        double temp = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();

        /**
         * 这里针对具体实现编程，会导致我们以后在增加或删除布告板时必须修改程序
         */

        /**
         *
         * update(),这里至少看起来像是一个统一的接口，布告板的方法名称都是update(),参数都是温度、湿度、气压
         *
         * currentConditionDisplay.update(temp,humidity,pressure);
         * statisticsDisplay.update(temp,humidity,pressure);
         * forecasetDisplay.update(temp,humidity,pressure);
         *
         */

    }
}
