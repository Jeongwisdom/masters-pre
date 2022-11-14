package mission2;

public abstract class Decorator extends Coffee {
    private Coffee beans;

    public Decorator(Coffee beans) {
        this.beans = beans;
    }

    @Override
    public void brewing() {
        beans.brewing();
    }
}
