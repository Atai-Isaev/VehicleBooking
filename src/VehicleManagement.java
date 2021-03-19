import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleManagement {

    //List of all vehicles in system
    private List<Vehicle> vehicleList;

    // @Integer = id of customer
    // @List<Vehicle>   = all customers booked vehicles
    private Map<Integer, List<Vehicle>> bookedVehicles;


    public VehicleManagement() {
        vehicleList = new ArrayList<>();
        bookedVehicles = new HashMap<>();
    }

    /*
        TODO    - CM addVehicle
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:05
     */

    void addVehicle(Vehicle vehicle) {
        if (vehicle != null) {
            vehicleList.add(vehicle);
            System.out.println("Vehicle: " + vehicle.getName() + " added to vehicle List!");
        } else System.out.println("Object Vehicle is null!");
    }

    /*
        TODO    - CM findMatchingVehicles
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:06
        @return - a filtered List of vehicles
     */

    public List<Vehicle> findMatchingVehicles(int maxDistance, OperatingEnvironment operatingEnvironment) {

        List<Vehicle> resultList = new ArrayList<>();

        if (vehicleList.isEmpty()) {
            System.out.println("VehicleManagement have 0 vehicles");
            return null;
        }
        else {
            for (int i = 0; i < vehicleList.size(); i++) {
                Vehicle currentVehicle = vehicleList.get(i);

                if (currentVehicle.isAvailable()) {
                    if (currentVehicle.canOperateOn(operatingEnvironment)
                            && currentVehicle.getMaxDistance() >= maxDistance) resultList.add(currentVehicle);
                }
            }

            if (resultList.isEmpty()){
                System.out.println("0 Vehicle was found");
                return null;
            }
            else {
                System.out.println("There is "+resultList.size()+" vehicle(s) for you!");
                for (int i = 0; i < resultList.size(); i++) {

                    Vehicle vehicle = resultList.get(i);
                    System.out.println("Vehicle: "+ vehicle.getName()+", max distance: "+vehicle.getMaxDistance()
                            +", operating environment: "+vehicle.getOperatingEnvironment());
                }
                return resultList;
            }


        }
    }

    /*
        TODO    - CM bookVehicle
        Book a specific vehicle
        it is important
        if(bookedVehicles.List<Vehicle>.size!=0 or bookedVehicles.List<Vehicle>.size>0)

        @author - Atai
        @date   - 18.03.2021
        @time   - 18:07
     */

    public boolean bookVehicle(Vehicle vehicle, Customer customer) {

        if (vehicle == null || customer == null || vehicle.isAvailable()) return false;

        if(bookedVehicles.containsKey(customer.getId())){

            List<Vehicle> customersBookedVehicles = bookedVehicles.get(customer.getId());

            if(customersBookedVehicles.isEmpty()){
                vehicle.book();
                List<Vehicle> newList = new ArrayList<>();
                newList.add(vehicle);
                bookedVehicles.put(customer.getId(), newList);
                return true;
            }
            else {
                vehicle.book();
                customersBookedVehicles.add(vehicle);
                bookedVehicles.put(customer.getId(), customersBookedVehicles);
                return true;
            }

        }
        else {
            vehicle.book();
            List<Vehicle> newList = new ArrayList<>();
            newList.add(vehicle);
            bookedVehicles.put(customer.getId(), newList);
            return true;
        }

    }

    /*
        TODO    - CM showBookedVehicles
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:08
     */

    public void showBookedVehicles() {
        if (bookedVehicles.isEmpty()) System.out.println("There is no booked vehicles yet!");
        else bookedVehicles.forEach((customerId, vehicleList) ->
                vehicleList.forEach(vehicle ->
                        System.out.println("Customer id: " + customerId + ", Vehicle: " + vehicle.getName() + ", operating environment: " + vehicle.getOperatingEnvironment() + ", max distance: " + vehicle.getMaxDistance())));
    }
}
