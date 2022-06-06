package Design;

import Model.ParkingSLotType;
import Model.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSlot {

    String name;
    @Builder.Default
    boolean isFree =true;
    ParkingSLotType parkingSLotType;
    Vehicle vehicle;
    public ParkingSlot(String name , ParkingSLotType parkingSLotType)
    {
        this.name = name;
        this.parkingSLotType = parkingSLotType;
    }
    public void addVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        this.isFree =false;
    }

    public void removeVehicle ( Vehicle vehicle)
    {
        this.vehicle = null;
        this.isFree =true;
    }
}
