/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;

public class Library extends Building {

  private static Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }
  //methods
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }
  public void addTitle(String title){
    try {
      if (containsTitle(title)) {
        throw new Exception("The book '" + title + "' is already in the collection.");
      } else {
        collection.put(title, true); 
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

  public String removeTitle(String title){
    try {
      if (!containsTitle(title)) {
        throw new Exception("The book '" + title + "' is not in the collection.");
      } else {
        collection.remove(title, true);
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
    return title;
  }

  public void checkOut(String title){
    try {
      if(containsTitle(title) && isAvailable(title)){
        collection.replace(title, true, false);
      }else{
        throw new Exception("Unable to checkout: " + title);
      }

    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }
  
  public void returnBook(String title){
    try{
      if(containsTitle(title) && !isAvailable(title)){
        collection.replace(title, false, true);
      }else{
        throw new Exception("Unable to return: " + title);
      }
    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
    
  }

  public boolean isAvailable(String title){
    if(containsTitle(title) && collection.get(title)){
      return true;
    }
    return false;
  }

  public void printCollection(){
    for (Map.Entry<String, Boolean> entry : collection.entrySet()) {
      String key = entry.getKey();
      Boolean value = entry.getValue();
      String status = value ? "Available" : "Not Available"; 
      System.out.printf("%-20s : %s%n", key, status);
    }
  }

  public static void main(String[] args) {
    Library myLibrary = new Library("Smith College Library", "1 Chapin Way, Northampton, MA", 3);
    myLibrary.addTitle("hello");
    myLibrary.checkOut("hello");
    myLibrary.checkOut("hello");
    myLibrary.printCollection();
  }
  
  }