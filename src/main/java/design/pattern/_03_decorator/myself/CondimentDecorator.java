package design.pattern._03_decorator.myself;


/**
 * Condiment（调料）抽象类
 *
 * 首先，必须让Condiment Decorator能够取代Beverage，所以将Condiment Decorator扩展自Beverage类
 *
 * 所有的调料装饰者都必须重新实现setDescription()方法。
 *
 */
public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}
