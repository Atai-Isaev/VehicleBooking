import javax.management.openmbean.OpenMBeanAttributeInfo;

public class Customer {

    private int id;
    private String name;
    private VehicleManagement vehicleManagement;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /*
        TODO    - CM
        @author - Atai
        @date   - 18.03.2021
        @time   - 18:10
     */

    public boolean searchAndBookVehicle(int maxDistance, OperatingEnvironment operatingEnvironment){
        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setVehicleManagement(VehicleManagement vehicleManagement) {
        this.vehicleManagement = vehicleManagement;
    }
}
