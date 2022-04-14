package tgw.warehouse;

import java.util.ArrayList;

public class Floor {
    private String name;
    private double occupancyRate;
    private ArrayList<Slot> slots;

    public Floor(String name, ArrayList<Slot> slots) {
        this.name = name;
        this.slots = slots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }

    public double getCurrentOccupancyRate()
    {
        int sum = 0;
        int noOfSlots = slots.size();
        int capacity = slots.get(0).getLocations().size() * noOfSlots;

        for (Slot slot:slots)
        {
            for (Location location:slot.getLocations())
            {
                if (location.getState() == LocationState.BLOCKED)
                {
                    capacity--;
                }
            }
        }

        for (Slot slot:slots)
        {
            for (Location location:slot.getLocations())
            {
                if (location.getState() == LocationState.EMPTY)
                {
                    sum++;
                }
            }
        }

        return 1.0 - (double) sum/(double) capacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("  Floor: " + name +"\n");
        for (Slot slot:slots)
        {
            result.append("   " + slot.getName() + "\n");
        }

        return result.toString();
    }
}
