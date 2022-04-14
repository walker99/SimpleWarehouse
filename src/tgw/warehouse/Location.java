package tgw.warehouse;

public class Location {
    private String name;
    private LocationState state;
    private LoadCarrier lc;

    public Location(String name) {
        this.name = name;
        state = LocationState.EMPTY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationState getState() {
        return state;
    }

    public void setState(LocationState state) {
        this.state = state;
    }

    public void deposit(LoadCarrier loadCarrier)
    {
        lc = loadCarrier;
        setState(LocationState.OCCUPIED);
    }

    public void pickup(LoadCarrier loadCarrier)
    {
        lc = null;
        setState(LocationState.EMPTY);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("    " + name);
        result.append(" - State: " + state.toString() + "\n");

        return result.toString();
    }
}
