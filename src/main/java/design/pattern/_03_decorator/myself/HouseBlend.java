package design.pattern._03_decorator.myself;

/**
 * 混合 黑咖啡
 */
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
