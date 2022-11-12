package mission1;

class HyundaiFactory {
    private static HyundaiFactory factory = new HyundaiFactory();
    private HyundaiFactory() {}
    public static HyundaiFactory getFactory() {
        if(factory == null)
            factory = new HyundaiFactory();
        return factory;
    }
    Car createCar() {
        Car car = new Car();
        return car;
    }
}

class Car {
    private static int serialNum = 1000;
    int carNum;

    public Car() {
        serialNum++;
        carNum = serialNum;
    }

    public int showCarNumber() {
        return carNum;
    }
}

public class CarTest {
    public static void main(String[] args) {
        HyundaiFactory factory = HyundaiFactory.getFactory();
        Car myCar = factory.createCar();
        Car yourCar = factory.createCar();

        System.out.println("첫번째 차 번호는 " +myCar.showCarNumber() + "입니다.");
        System.out.println("두번째 차 번호는 " +yourCar.showCarNumber() + "입니다.");
    }
}
