package Design;
import java.util.*;
import Model.ParkingSLotType;
import Model.Vehicle;
import Model.VehicleType;

public class ParkingFloor {
    String name;
     Map<ParkingSLotType,Map<String, ParkingSlot>> parkingSlots;
    public ParkingFloor(String name , Map<ParkingSLotType, Map<String, ParkingSlot>> parkingSlots)
    {
        this.name = name;
        this.parkingSlots = parkingSlots;
    }

    private ParkingSLotType pickSlot(VehicleType vehicleType)
    {
        if(vehicleType.equals(VehicleType.Bike))
            return ParkingSLotType.Bike;
        if(vehicleType.equals(VehicleType.Car))
            return ParkingSLotType.Car;
        if (vehicleType.equals(VehicleType.Bus))
            return ParkingSLotType.Bus;

      return null;
    }
    public ParkingSlot getSlotForVehicle(Vehicle vehicle)
    {
        VehicleType vehicleType = vehicle.getVehicleType();
        ParkingSLotType parkingSLotType = pickSlot(vehicleType);
        Map<String, ParkingSlot> Parkingslot = parkingSlots.get(parkingSLotType);
        ParkingSlot slot = null;
        for(Map.Entry<String,ParkingSlot> mp : Parkingslot.entrySet())
        {

            if(mp.getValue().isFree)
            {
                slot= mp.getValue();
                slot.addVehicle(vehicle);
                break;

            }
        }
        System.out.println("slot"+ slot);
        return slot;
    }




}
