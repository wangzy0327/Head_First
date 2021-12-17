package design.pattern._03_decorator.myself;

/**
 * 浓缩咖啡 Espresso
 *
 * 首先让Espresso扩展子Beverage类
 *
 *
 *
 *
 */
public class Espresso extends Beverage{

    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
