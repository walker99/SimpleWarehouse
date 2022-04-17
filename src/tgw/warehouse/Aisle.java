package tgw.warehouse;

import java.util.ArrayList;

public class Aisle {
    private String name;
    private double occupancyRate;
    private ArrayList<Rack> racks;

    public Aisle(String name, ArrayList<Rack> racks) {
        this.name = name;
        this.racks = racks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Rack> getRacks() {
        return racks;
    }

    public void setRacks(ArrayList<Rack> racks) {
        this.racks = racks;
    }

    public double getCurrentOccupancyRate()
    {
        int sum = 0;
        int noOfRacks = racks.size();
        // all locations = noOfRacks*noOfFloors*noOfSlots*noOfLocations
        int capacity = noOfRacks * racks.get(0).getFloors().size()*racks.get(0).getFloors().get(0).getSlots().size()*racks.get(0).getFloors().get(0).getSlots().get(0).getLocations().size();

        for (Rack rack:racks)
        {
            for (Floor floor:rack.getFloors())
            {
                for (Slot slot:floor.getSlots())
                {
                    for (Location location:slot.getLocations())
                    {
                        if (location.getState() == LocationState.BLOCKED)
                        {
                            capacity--;
                        }
                    }
                }
            }
        }

        for (Rack rack:racks)
        {
            for (Floor floor:rack.getFloors()) {
                for (Slot slot : floor.getSlots()) {
                    for (Location location : slot.getLocations()) {
                        if (location.getState() == LocationState.EMPTY) {
                            sum++;
                        }
                    }
                }
            }
        }

        return 1.0 - (double) sum/(double) capacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Aisle: " + name + "\n");
        for (Rack rack:racks)
        {
            result.append(rack.getName() + "\n");
        }

        return result.toString();
    }
}
