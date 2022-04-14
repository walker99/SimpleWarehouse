package tgw.warehouse;

import java.util.ArrayList;

public class Slot {
    private String name;
    private ArrayList<Location> locations;

    public Slot(String name, ArrayList<Location> locations) {
        this.name = name;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public double getCurrentOccupancyRate()
    {
        int sum = 0;
        int capacity = locations.size();

        for (Location location:locations)
        {
            if (location.getState() == LocationState.BLOCKED)
            {
                capacity--;
            }
        }

        for (Location location:locations)
        {
            if (location.getState() == LocationState.OCCUPIED)
            {
                sum++;
            }
        }

        return 1.0 - (double) sum/ (double) capacity;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("   Slot: " + name + "\n");
        for (Location location:locations)
        {
            result.append("    " + location.getName() + "\n");
        }

        return result.toString();
    }
}
