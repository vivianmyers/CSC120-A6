
/**
 * Class Building is the parent class of Cafe, House, and Library
 */
public class Building {

    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;

    /**
     * Building constructor
     * @param name name of building
     * @param address address of building
     * @param nFloors number of floors
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Returns name of building
     * @return name of building
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns address of building
     * @return address of building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns number of floors in a building
     * @return number of floors
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Prints information about a building including its name, floors, and address
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
     * Main method for testing
     * @param args
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
