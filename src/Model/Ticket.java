package Model;

import Design.ParkingSlot;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Ticket {
    String ticketNo;
    long startTime;
    long endTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle , ParkingSlot parkingSlot)
    {
        return Ticket.builder()
                .parkingSlot(parkingSlot)
                .startTime(System.currentTimeMillis())
                .vehicle(vehicle).ticketNo(vehicle.getVehicleNo()+System.currentTimeMillis())
                .build();

    }


}
