package tgw.warehouse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

class WarehouseTest {
    List<LoadCarrier> LcList;
    Warehouse warehouse;

    @BeforeEach
    void setUpOnRack() {
        warehouse = new Warehouse("Warehouse to Test");
        warehouse.createAisle("A1", 1, 3, 5, 2);
        LcList = new ArrayList<>(10);

        LcList.add(new LoadCarrier("LC 1"));
        LcList.add(new LoadCarrier("LC 2"));
        LcList.add(new LoadCarrier("LC 3"));
        LcList.add(new LoadCarrier("LC 4"));
        LcList.add(new LoadCarrier("LC 5"));
        LcList.add(new LoadCarrier("LC 6"));
        LcList.add(new LoadCarrier("LC 7"));
        LcList.add(new LoadCarrier("LC 8"));
        LcList.add(new LoadCarrier("LC 9"));
        LcList.add(new LoadCarrier("LC 10"));

        // x, y, z
        // 0, 0, 0
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(0).deposit(LcList.get(0));
        // 0, 0, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(1).deposit(LcList.get(1));
        // 4, 0, 0
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(0).deposit(LcList.get(2));
        // 4, 0, 1 BLOCKED
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(1).setState(LocationState.BLOCKED);

        // 4, 2, 0
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).deposit(LcList.get(3));
        // 4, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(1).deposit(LcList.get(4));
        // 0, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(1).deposit(LcList.get(5));
        // 1, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).deposit(LcList.get(6));
        // 2, 2, 1
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(1).deposit(LcList.get(7));

        // 1, 1, 1 BLOCKED
        warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(1).setState(LocationState.BLOCKED);
    }

    @Test
    void testCreateAisle_all_30_locations() {
        // empty locations
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(1).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(1).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(2).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(2).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(3).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(3).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(0).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(0).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(2).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(2).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(3).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(3).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(4).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(4).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(3).getLocations().get(0).getState());
        Assert.assertEquals(LocationState.EMPTY, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(3).getLocations().get(1).getState());

        // occupied locations
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(0).getState());
        Assert.assertEquals("LoadCarrier{LC 1}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(0).getLc().toString());
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(1).getState());
        Assert.assertEquals("LoadCarrier{LC 2}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getLocations().get(1).getLc().toString());
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(0).getState());
        Assert.assertEquals("LoadCarrier{LC 3}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(0).getLc().toString());
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).getState());
        Assert.assertEquals("LoadCarrier{LC 4}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).getLc().toString());
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(1).getState());
        Assert.assertEquals("LoadCarrier{LC 5}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(1).getLc().toString());
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(1).getState());
        Assert.assertEquals("LoadCarrier{LC 6}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(0).getLocations().get(1).getLc().toString());
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).getState());
        Assert.assertEquals("LoadCarrier{LC 7}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).getLc().toString());
        Assert.assertEquals(LocationState.OCCUPIED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(1).getState());
        Assert.assertEquals("LoadCarrier{LC 8}", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getLocations().get(1).getLc().toString());

        // blocked locations
        Assert.assertEquals(LocationState.BLOCKED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(1).getState());
        Assert.assertEquals(LocationState.BLOCKED, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getLocations().get(1).getState());
    }

    @Test
    void testGetName_for_most_elements() {
        // Warehouse
        Assert.assertEquals("Warehouse to Test", warehouse.getName());
        // Aisle
        Assert.assertEquals("A1", warehouse.getAisles().get(0).getName());
        // Rack
        Assert.assertEquals("R0-A1", warehouse.getAisles().get(0).getRacks().get(0).getName());
        // Floors
        Assert.assertEquals("F0-R0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getName());
        Assert.assertEquals("F1-R0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getName());
        Assert.assertEquals("F2-R0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getName());
        // Slots
        Assert.assertEquals("S0-F0", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getName());
        Assert.assertEquals("S4-F2", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getName());
        // Locations
        Assert.assertEquals("L0-S4", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).getName());
        Assert.assertEquals("L1-S1", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(1).getLocations().get(1).getName());
        Assert.assertEquals("L1-S1", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getLocations().get(1).getName());
        Assert.assertEquals("L1-S1", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(1).getLocations().get(1).getName());
    }

    @Test
    void testToString_for_most_elements() {
        // Warehouse
        Assert.assertEquals("Warehouse: Warehouse to Test\nAisle: A1\n----------------------------\n", warehouse.toString());
        // Aisle
        Assert.assertEquals("[Aisle: A1\nR0-A1\n]", warehouse.getAisles().toString());
        // Rack
        Assert.assertEquals(" Rack: R0-A1\n  F0-R0\n  F1-R0\n  F2-R0\n", warehouse.getAisles().get(0).getRacks().get(0).toString());
        // Floor
        Assert.assertEquals("  Floor: F0-R0\n   S0-F0\n   S1-F0\n   S2-F0\n   S3-F0\n   S4-F0\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).toString());
        // Slot
        Assert.assertEquals("   Slot: S0-F0\n    L0-S0\n    L1-S0\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).toString());
        Assert.assertEquals("   Slot: S4-F2\n    L0-S4\n    L1-S4\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).toString());
        // Location
        Assert.assertEquals("    L0-S4 - State: OCCUPIED\n", warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(4).getLocations().get(0).toString());
    }

    @Test
    void testCurrentOccupancies_for_all_components() {
        // 30 locations, 2 blocked, 8 occupied and capacity 28
        // 8/28
        Assert.assertEquals(String.format("%.4f", 8.0/28.0), String.format("%.4f",warehouse.getAisles().get(0).getCurrentOccupancyRate()));
        Assert.assertEquals(String.format("%.4f", 8.0/28.0), String.format("%.4f",warehouse.getAisles().get(0).getRacks().get(0).getCurrentOccupancyRate()));
        // Floor 0: 10 locations, 1 blocked, 3 occupied and capacity 9
        // 3/9
        Assert.assertEquals(String.format("%.4f", 3.0/9.0), String.format("%.4f",warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getCurrentOccupancyRate()));
        // Floor 1: 10 locations, 1 blocked, 0 occupied and capacity 9
        // 0/9
        Assert.assertEquals(String.format("%.4f", 0.0/9.0), String.format("%.4f",warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getCurrentOccupancyRate()));
        // Floor 2: 10 locations, 0 blocked, 5 occupied and capacity 10
        // 5/10
        Assert.assertEquals(String.format("%.4f", 5.0/10.0), String.format("%.4f",warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getCurrentOccupancyRate()));
        // Slot 0/0 2 LCs in this slot
        Assert.assertEquals(1.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(0).getCurrentOccupancyRate());
        // Slot 1/1 0 LC and 1 blocked
        Assert.assertEquals(0.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(1).getCurrentOccupancyRate());
        // Slot 2/2 1 LC in this slot
        Assert.assertEquals(0.5, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(2).getSlots().get(2).getCurrentOccupancyRate());
        // Slot 1/3 0 LC
        Assert.assertEquals(0.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(1).getSlots().get(3).getCurrentOccupancyRate());
        // Slot 4/0 1 LC and 1 blocked
        Assert.assertEquals(1.0, warehouse.getAisles().get(0).getRacks().get(0).getFloors().get(0).getSlots().get(4).getCurrentOccupancyRate());
    }
}