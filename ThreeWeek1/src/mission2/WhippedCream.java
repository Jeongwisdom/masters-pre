package mission2;

public class WhippedCream extends Decorator {
    public WhippedCream(Coffee beans) {
        super(beans);
    }
    public void brewing() {
        super.brewing();
        System.out.print(" Adding WhippedCream");
    }
}
