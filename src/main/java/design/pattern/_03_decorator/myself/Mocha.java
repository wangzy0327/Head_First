package design.pattern._03_decorator.myself;

/**
 * 摩卡 是一个装饰者，让它扩展自CondimentDecorator, CondimentDecorator 扩展自Beverage
 *
 * 要让Mocha能够引用一个Beverage，做法如下：
 * 1、用一个实例变量记录饮料，也就是被装饰者
 * 2、想办法让被装饰者（饮料）被记录到实例变量中。这里的做法是：把饮料当做构造器的参数，再由构造器将此饮料记录在实例变量中。
 *
 */
public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" , Mocha";
    }


}
