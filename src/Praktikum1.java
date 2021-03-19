public class Praktikum1 {
    public static void main(String[] args) {

        VehicleManagement vehicleManagement = new VehicleManagement();

        Customer customer1 = new Customer(1, "John");
        Customer customer2 = new Customer(2, "Alex");
        Customer customer3 = new Customer(3, "Anna");

        Vehicle vehicle1 = new eCar(100, "Tesla");
        Vehicle vehicle2 = new Boat(150, "Delvi");
        Vehicle vehicle3 = new Helicopter(200, "Shuza");



        vehicleManagement.addVehicle(vehicle1);
        vehicleManagement.addVehicle(vehicle2);
        vehicleManagement.addVehicle(vehicle3);

        customer1.setVehicleManagement(vehicleManagement);
        customer2.setVehicleManagement(vehicleManagement);
        customer3.setVehicleManagement(vehicleManagement);

        customer1.searchAndBookVehicle(1000,OperatingEnvironment.WATER);



    }
}
