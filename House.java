/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building {
  
  private ArrayList<String> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDining) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDining;
    
    System.out.println("You have built a house: 🏠");
  }

  //getters
  public boolean hasDiningRoom(){
    return hasDiningRoom;
  };
  public int nResidents(){
    return residents.size();
  };

  //methods

  public boolean isResident(String person){
    return residents.contains(person);
  }

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

  public static void main(String[] args) {
    House house = new House("myHouse", "948 New Boston", 2, true);
    house.moveIn("Vivian");
    System.out.println(house);
  }

}