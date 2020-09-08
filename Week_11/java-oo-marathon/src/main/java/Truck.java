public class Truck extends Automobile {
  private int bedLengthFeet;
  private int bedWidthFeet;
  private int containerHeightFeet;
  private int currentLoadCubicFeet;

  public Truck(String type, String model, String make, int mpg, int fuelCapacity, int bedLengthFeet, int bedWidthFeet) {
    super(type, model, make, mpg, fuelCapacity);
    this.bedLengthFeet = bedLengthFeet;
    this.bedWidthFeet = bedWidthFeet;
    this.containerHeightFeet = 3;
    this.toggleEngine();
    this.currentLoadCubicFeet = 0;
  }

  public Truck(String type, String model, String make, int mpg, int fuelCapacity, int bedLengthFeet, int bedWidthFeet, int containerHeightFeet) {
    super(type, model, make, mpg, fuelCapacity);
    this.bedLengthFeet = bedLengthFeet;
    this.bedWidthFeet = bedWidthFeet;
    this.containerHeightFeet = containerHeightFeet;
    this.toggleEngine();
    this.currentLoadCubicFeet = 0;
  }

  public int getBedLengthFeet() {
    return bedLengthFeet;
  }

  public int getBedWidthFeet() {
    return bedWidthFeet;
  }

  public int getContainerHeightFeet() {
    return containerHeightFeet;
  }

  public int getCurrentLoadCubicFeet() {
    return currentLoadCubicFeet;
  }

  public int volumeCapacity() {
    return this.bedLengthFeet * this.bedWidthFeet * this.containerHeightFeet;
  }

  public boolean addCargo(int loadCubicFeet) {
    if(this.volumeCapacity()-this.currentLoadCubicFeet < loadCubicFeet) { return false; }
    this.currentLoadCubicFeet += loadCubicFeet;
    return true;
  }

  public void emptyCargo() { this.currentLoadCubicFeet = 0; }
}
