public interface Vehicle {

    boolean isAvailable();
    int getMaxDistance();
    OperatingEnvironment getOperatingEnvironment();
    String getName();
    void book();
    boolean canOperateOn(OperatingEnvironment operatingEnvironment);

}
