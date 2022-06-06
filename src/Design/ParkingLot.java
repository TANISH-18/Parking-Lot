package Design;

import Model.Address;
import Model.Ticket;
import Model.Vehicle;
import Model.ParkingSLotType;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class ParkingLot {
    private String nameOfParkingLot;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private  static ParkingLot parkinglot = null;
    private ParkingLot (String nameOfParkingLot , Address address , List<ParkingFloor> parkingFloors)
    {
        this.nameOfParkingLot =nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;

    }

    public  static ParkingLot getInstance(String nameOfParkingLot,Address address ,List<ParkingFloor> parkingFloors)
    {
        if(parkinglot == null)
        {
            parkinglot = new ParkingLot(nameOfParkingLot,address,parkingFloors);

        }
        return parkinglot;
    }

    public Ticket cutTicket(Vehicle vehicle)
    {
        ParkingSlot parkingSlot = getParkingSlot(vehicle);
        if(parkingSlot == null) return null;
        Ticket ticket = createTicketForSlot(parkingSlot, vehicle);
        //System.out.println("hello");
        return  ticket;
    }
    public  double payTicket (Ticket ticket)
    {
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
         long duration =  (endTime-ticket.getStartTime())/1000;
        System.out.println("dur "+ duration);
        int price = (int) ticket.getParkingSlot().getParkingSLotType().getPrice(duration);
        return price;
    }
    private ParkingSlot getParkingSlot(Vehicle vehicle)
    {
        ParkingSlot slot = null;
        for(ParkingFloor parkingFloor : parkingFloors) {
            slot = parkingFloor.getSlotForVehicle(vehicle);

            if (slot != null)
                break;
        }
        return slot;
    }
    private Ticket createTicketForSlot(ParkingSlot parkingSlot , Vehicle vehicle) {
        return Ticket.createTicket(vehicle,parkingSlot);
    }
}
