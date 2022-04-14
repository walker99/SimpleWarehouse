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
