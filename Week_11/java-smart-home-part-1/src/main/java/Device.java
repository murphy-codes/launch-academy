public class Device {
  private String name;
  private boolean powered;

  public Device(String name) {
    this.name = name;
    this.powered = false;
  }

//  public Device(String name, boolean powered) {
//    this.name = name;
//    this.powered = powered;
//  }

  public String getName() { return name; }

  public boolean isPowered() {
    return powered;
  }

  public void togglePower() {
    this.powered = !this.powered;

    if(this.powered) { System.out.println("The device is powered on."); }
    else { System.out.println("The device is powered off."); }
  }

  public String toString() {
    return String "Device Name: " + this.name + "\nHas Power: " + this.powered;
  }
}
