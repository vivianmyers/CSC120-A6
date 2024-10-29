/* This is a stub for the Cafe class */

/**
 * Class Cafe extends class Building and manages an inventory of coffee, sugar, cream, and cups as well 
 * as methods to manage them and sell coffee
 */
public class Cafe extends Building{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Cafe constructor
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors
     * @param coffee ounces of coffee
     * @param sugar number of sugaar packets
     * @param cream number of creams
     * @param cups number of cups
     */
    public Cafe(String name, String address, int nFloors, int coffee, int sugar, int cream, int cups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = coffee;
        this.nSugarPackets = sugar;
        this.nCreams = cream;
        this.nCups = cups;
        System.out.println("You have built a cafe: ☕");
    }

    //methods

    /**
     * Creates and sells a coffee by removing given amounts of each material, restocks with exact amounts needed for a coffee
     * if there is not enough stock to make that coffee
     * @param size coffee ounces needed for a coffee
     * @param nSugarPackets number of sugar packets needed for a coffee
     * @param nCreams number of creams needed for a coffee
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){

        if(this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1){
            System.out.println("Not enough stock: Restocking...");
            restock(nCoffeeOunces, nSugarPackets, nCreams, 50);
        }

        System.out.println("Making coffee!");
        this.nCoffeeOunces-= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups--;

    }

    /**
     * Restocks the cafe
     * @param nCoffeeOunces number of coffee ounces to restock
     * @param nSugarPackets number of sugar packets to restock
     * @param nCreams number of creams to restock
     * @param nCups number of cups to restock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }
    

    /**
     * Main method for testing
     */
    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "1 Chapin Way", 3, 0, 0, 0, 0);
        compassCafe.sellCoffee(5, 2, 0);
        
    }
    
}
