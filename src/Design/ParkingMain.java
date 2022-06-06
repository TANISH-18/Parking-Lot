package Design;
import Model.*;
import lombok.Builder;

import java.util.*;
@Builder
public class ParkingMain {
    public static void main(String[] args) throws InterruptedException {
        String nameOfParkingLot ="Pintosss Parking Lot";
        Address address = Address.builder().city("Bangalore").state("KA").build();
        Map<ParkingSLotType, Map<String, ParkingSlot>> allSlots = new HashMap<>();
        Map<String,ParkingSlot> compactSlot = new HashMap<>();
        compactSlot.put("C1",new ParkingSlot("C1",ParkingSLotType.Car));
        compactSlot.put("C2",new ParkingSlot("C2",ParkingSLotType.Car));
        compactSlot.put("C3",new ParkingSlot("C3",ParkingSLotType.Car));
        allSlots.put(ParkingSLotType.Car,compactSlot);

        Map<String,ParkingSlot> largeSlot = new HashMap<>();
        largeSlot.put("L1",new ParkingSlot("L1",ParkingSLotType.Bus));
        largeSlot.put("L2",new ParkingSlot("L2",ParkingSLotType.Bus));
        largeSlot.put("L3",new ParkingSlot("L3",ParkingSLotType.Bus));
        allSlots.put(ParkingSLotType.Bus,largeSlot);
        ParkingFloor parkingFloor = new ParkingFloor("1",allSlots);
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingFloors.add(parkingFloor);
        ParkingLot parkingLot = ParkingLot.getInstance(nameOfParkingLot,address,parkingFloors);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.Car);
        vehicle.setVehicleNo("KA-01-MA-9999");
        vehicle.setVehicleType(VehicleType.Car);
        vehicle.setVehicleNo("KA-01-MA-9998");
        vehicle.setVehicleType(VehicleType.Car);
        vehicle.setVehicleNo("KA-01-MA-9997");


        Ticket ticket = parkingLot.cutTicket(vehicle);
        System.out.println(" ticket number >> "+ticket.getTicketNo());
        //persist the ticket to db here
        Thread.sleep(10000);
        double price = parkingLot.payTicket(ticket);
        System.out.println("price is >>" + price);
    }
}
