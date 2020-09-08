public class Automobile { // public abstract class Automobile {
  private String type;
  private String model;
  private String make;
  private int mpg;
  private int fuelCapacity;
  private boolean running;

  public Automobile(String type, String model, String make, int mpg, int fuelCapacity) {
    this.type = type;
    this.model = model;
    this.make = make;
    this.mpg = mpg;
    this.fuelCapacity = fuelCapacity;
    this.running = true;
  }

  public String getType() {
    return type;
  }

  public String getModel() {
    return model;
  }

  public String getMake() {
    return make;
  }

  public int getMpg() {
    return mpg;
  }

  public int getFuelCapacity() {
    return fuelCapacity;
  }

  public boolean getRunning() {
    return running;
  }

  public void toggleEngine() { this.running = !this.running; }
}
