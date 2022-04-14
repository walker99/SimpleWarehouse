package tgw.warehouse;

import java.util.ArrayList;

public class Rack {
    private String name;
    private double occupancyRate;
    private ArrayList<Floor> floors;

    public Rack(String name, ArrayList<Floor> floors) {
        this.name = name;
        this.floors = floors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(" Rack: " + name + "\n");
        for (Floor floor:floors)
        {
            result.append("  " + floor.getName() + "\n");
        }

        return result.toString();
    }
}
