package algorithm;

public class testMain {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(2, 3, 4);

        boolean b = parkingSystem.addCar4(3);
        boolean b1 = parkingSystem.addCar4(0);
        boolean b2 = parkingSystem.addCar4(2);
        boolean b3 = parkingSystem.addCar4(1);
        boolean b4 = parkingSystem.addCar4(1);
        boolean b5 = parkingSystem.addCar4(1);

        System.out.println(b + "-" + b1 + "-" + b2 + "-" + b3 + "-" + b4 + "-" + b5);

    }
}
