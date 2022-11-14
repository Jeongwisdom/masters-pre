package mission2;

public class Latte extends Decorator {
    public Latte(Coffee beans) {
        super(beans);
    }

    @Override
    public void brewing() {
        super.brewing();
        System.out.print(" Adding milk");
    }
}
