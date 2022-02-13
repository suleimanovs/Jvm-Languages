package oop.inheriate;

/**
 * Created by Osman on 12:44
 */
public class CatFamily {
    private int ears;
    private int legs;
    private boolean  bigClaws;

    public CatFamily(int ears, int legs, boolean bigClaws) {
        this.ears = ears;
        this.legs = legs;
        this.bigClaws = bigClaws;
    }

    public void showInfo() {
        System.out.println("Количество ушей " + ears + " Количество лап " + legs + " Наличие больших когтей " + bigClaws);
    }

    public void setBigClaws(boolean bigClaws) {
        this.bigClaws = bigClaws;
    }
    public void eat() {
        System.out.println("Eating");
    }
}
