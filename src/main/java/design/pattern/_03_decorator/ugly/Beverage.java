package design.pattern._03_decorator.ugly;

/**
 * Beverage 饮料 基类下手，加上实际变量是否加 调料（牛奶、豆浆、摩卡、奶泡...）
 */
public abstract class Beverage {
    protected String description;
    protected Milk milk;
    protected Soy soy;
    protected Mocha mocha;
    protected Whip whip;


    public void getDescription(){
        System.out.println(this.description+" "
                +((this.hasMilk())?this.milk.getName():"")
                +((this.hasSoy())?this.soy.getName():"")
                +((this.hasMocha())?this.mocha.getName():"")
                +((this.hasWhip())?this.whip.getName():""));
    }

    public abstract double cost();

    public boolean hasMilk(){
        return this.milk != null;
    }
    public void setMilk(Milk milk){
        this.milk = milk;
    }

    public boolean hasSoy(){
        return this.soy != null;
    }
    public void setSoy(Soy soy){
        this.soy = soy;
    }

    public boolean hasMocha(){
        return this.mocha != null;
    }
    public void setMocha(Mocha mocha){
        this.mocha = mocha;
    }

    public boolean hasWhip(){
        return this.whip != null;
    }
    public void setWhip(Whip whip){
        this.whip = whip;
    }
}
