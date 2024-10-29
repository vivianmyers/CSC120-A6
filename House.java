/* This is a stub for the House class */

import java.util.ArrayList;

/**
 * The House class extends the Building class and adds functionality involving
 * dining rooms and residents.
 */
public class House extends Building {
  
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  /**
   * House Constructor
   * @param name is the building name
   * @param address is the building address
   * @param nFloors is the number of floors
   * @param hasDining indicates whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDining) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDining;
    
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Indicates if the house has a dining room
   * @return True if it does, flase otherwise
   */
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  }

  /**
   * Returns the size of the residents list
   * @return size of residents
   */
  public int nResidents(){
    return residents.size();
  }

  
  /**
   * Checks if a person is in the residents list
   * @param person is the person we are looking for in the residents list
   * @return True if the person is in residents, false otherwise
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  /**
   * Adds a new resident to the resident list if they dont already live there
   * @param name of the person we would like to add
   */
  public void moveIn(String name){
    try{
      if(!isResident(name)){
        residents.add(name);
      }else{
        throw new Exception(name + "already lives here.");
      }
    } catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }

  /**
   * Removes a person from residents if they are on the list
   * @param name of the person we want to remove
   * @return the name of the person removed
   */
  public String moveOut(String name){
    try{
      if(isResident(name)){
        residents.remove(name);
      }else{
        throw new Exception(name + " does not live here.");
      }
    } catch(Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return name;
  }
  /**
   * Main method for testing
   * @param args
   */
  public static void main(String[] args) {
    House house = new House("myHouse", "948 New Boston", 2, true);
    house.moveIn("Vivian");
    System.out.println(house);
  }

}