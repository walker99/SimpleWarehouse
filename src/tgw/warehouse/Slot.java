package tgw.warehouse;

import java.util.ArrayList;

/**
 * Slots are parts of floors (see it as the x-coordinate)
 * In a slot you find locations (see it as the z-coordinate)
 */
public class Slot {
    private String name;
    private ArrayList<Location> locations;

    /**
     * Constructor for a slot
     *
     * @param name Name of this slot
     * @param locations List of locations
     */
    public Slot(String name, ArrayList<Location> locations) {
        this.name = name;
        this.locations = locations;
    }

    /**
     * Retruns the slot name
     * @return slot name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the slot
     * @param name slot name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the locations of a slot
     * @return ArrayList of locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Sets the location list for this slot
     * @param locations ArrayList of locations
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Calculates the occupancy rat at the current time
     * occupancy rat = 1 - occupied locations/available locations
     * @return occupancy rate
     */
    public double getCurrentOccupancyRate()
    {
        // initialize to get the correct sum
        int sum = 0;
        // capacity is location size
        int capacity = locations.size();

        // loop through all locations
        for (Location location:locations)
        {
            // lower the capacity if a location is blocked
            if (location.getState() == LocationState.BLOCKED)
            {
                capacity--;
            }
        }

        // loop again through all locations
        for (Location location:locations)
        {
            // if a location is occupied sum it up!
            if (location.getState() == LocationState.OCCUPIED)
            {
                sum++;
            }
        }

        // calculate the capacity
        // todo: think about the situation if all locations are blocked!
        return (double) sum/ (double) capacity;
    }

    /**
     * Returns a representation of slot
     * @return string of this object
     */
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
