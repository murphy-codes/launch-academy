public class Car extends Automobile {
  private int capacity;
  private int numPassengers;

  public Car(String type, String model, String make, int mpg, int fuelCapacity, int capacity, int numPassengers) {
    super(type, model, make, mpg, fuelCapacity);
    this.capacity = capacity;
    this.numPassengers = numPassengers;
    this.toggleEngine();
  }

  public Car(String type, String model, String make, int mpg, int fuelCapacity, boolean running, int capacity, int numPassengers) {
    super(type, model, make, mpg, fuelCapacity);
    this.capacity = capacity;
    this.numPassengers = numPassengers;
    if( this.getRunning() != running) {this.toggleEngine();}
  }

  public int getCapacity() {
    return capacity;
  }

  public int getNumPassengers() {
    return numPassengers;
  }

  public boolean addPassengers(int newPassengers) {
    if(this.capacity-this.numPassengers < newPassengers) { return false; }
    this.numPassengers += newPassengers;
    return true;
  }

  public void exitPassengers(int removePassengers) {
    if(removePassengers > this.numPassengers) { this.numPassengers = 0; }
    else { this.numPassengers -= removePassengers; }
  }
}
