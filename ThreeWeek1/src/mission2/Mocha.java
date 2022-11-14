package mission2;

public class Mocha extends Decorator {
    public Mocha(Coffee beans) {
        super(beans);
    }

    public void brewing() {
        super.brewing();
        System.out.print(" Adding Mocha Syrup");
    }
}
