/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;
/**
 * Class Library extends the Building class and adds functionality including a collection
 * of books
 */
public class Library extends Building {

  private static Hashtable<String, Boolean> collection;

  /**
   * Library constructor
   * @param name of library
   * @param address of library
   * @param nFloors number of floors in the library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }
  //methods

  /**
   * Indicates if the collection has a certain title in it
   * @param title of the book we are looking for
   * @return true if the book is in the collection, false otherwise
   */
  public boolean containsTitle(String title){
    return collection.containsKey(title);
  }

  /**
   * Adds a new book to the collection if it isn't already there
   * @param title of the book we are trying to add
   */
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

  /**
   * Removes a book from the collection if it is in the collection
   * @param title of the book we want to remove
   * @return the title of the book
   */
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

  /**
   * Changes the status of a book from true to false if it is availible and in the collection
   * @param title of the book we want to check out
   */
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

  /**
   * Changes status of a book from false to true if it is checked out and in the collection
   * @param title of the book we want to return
   */
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

  /**
   * Checks if a book is in the collection and not checked out
   * @param title of book we are checking
   * @return true if the book is in the collection and not checked out, false otherwise
   */
  public boolean isAvailable(String title){
    if(containsTitle(title) && collection.get(title)){
      return true;
    }
    return false;
  }

  /**
   * Prints the collection with each title and its corresponding availible/unavailible program
   */
  public void printCollection(){
    for (Map.Entry<String, Boolean> entry : collection.entrySet()) {
      String key = entry.getKey();
      Boolean value = entry.getValue();
      String status = value ? "Available" : "Not Available"; 
      System.out.printf("%-20s : %s%n", key, status);
    }
  }

  /**
   * Main method for testing
   * @param args
   */
  public static void main(String[] args) {
    Library myLibrary = new Library("Smith College Library", "1 Chapin Way, Northampton, MA", 3);
    myLibrary.addTitle("hello");
    myLibrary.checkOut("hello");
    myLibrary.checkOut("hello");
    myLibrary.printCollection();
  }
  
  }