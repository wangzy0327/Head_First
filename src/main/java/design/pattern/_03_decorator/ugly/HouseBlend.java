package design.pattern._03_decorator.ugly;


/**
 * 调料价格的改变会更改现有的代码
 *
 * 一旦出现新的调料，就需要加上新的方法，并改变超类中的cost()方法
 *
 * 以后可能会开发出新饮料，对这些饮料而言（例如：冰茶）,某些调料可能并不适合，但是在这个设计方式中，Tea（茶）子类仍将继承哪些不适合的方法，例如：hasWhip()(加奶泡)
 *
 * 万一顾客想要双倍摩卡咖啡，怎么办？
 *
 */
public class HouseBlend extends Beverage{

    private double cost;

    public HouseBlend(String description,double cost) {
        this.description = description;
        this.cost = cost;
    }

    public HouseBlend(String description) {
        this.description = description;
    }

    public HouseBlend() {
        this.description = "Most Excellent House Blend";
    }

    @Override
    public double cost() {
        return this.cost
                +((super.hasMilk())?this.milk.getCost():0.0)
                +((super.hasSoy())?this.milk.getCost():0.0)
                +((super.hasMocha())?this.milk.getCost():0.0)
                +((super.hasWhip())?this.milk.getCost():0.0);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
