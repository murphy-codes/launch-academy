import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TruckTest {
  private Truck truck;
  private Truck bedTruck;

  @BeforeEach
  public void setupTruck(){
    this.truck = new Truck("pickup", "Tundra", "Toyota", 31, 11, 8, 6);
    this.bedTruck = new Truck("pickup", "Tundra", "Toyota", 31, 11, 8, 6, 4);
  }

  @Test
  @DisplayName("When initialized a Truck has a type")
  public void init_truck_hasType(){
    Assertions.assertEquals("pickup", this.truck.getType());
  }

  @Test
  @DisplayName("When initialized a Truck has a model")
  public void init_truck_hasModel(){
    Assertions.assertEquals("Tundra", this.truck.getModel());
  }

  @Test
  @DisplayName("When initialized a Truck has a make")
  public void init_truck_hasMake(){
    Assertions.assertEquals("Toyota", this.truck.getMake());
  }

  @Test
  @DisplayName("When initialized a Truck has a mpg")
  public void init_truck_hasMpg(){
    Assertions.assertEquals(31, this.truck.getMpg());
  }

  @Test
  @DisplayName("When initialized a Truck has a fuelCapacity")
  public void init_truck_hasFuelCapacity(){
    Assertions.assertEquals(11, this.truck.getFuelCapacity());
  }

  @Test
  @DisplayName("When initialized a Truck is running or not running")
  public void init_truck_runningFalse(){
    Assertions.assertEquals(false, this.truck.getRunning());
  }

  @Test
  @DisplayName("When initialized a Truck has a bedLengthFeet")
  public void init_truck_hasBedLengthFeet(){
    Assertions.assertEquals(8, this.truck.getBedLengthFeet());
  }

  @Test
  @DisplayName("When initialized a Truck has a bedWidthFeet")
  public void init_truck_hasBedWidthFeet(){
    Assertions.assertEquals(6, this.truck.getBedWidthFeet());
  }

  @Test
  @DisplayName("When initialized a Truck can have a containerHeightFeet")
  public void init_truck_can_have_containerHeightFeet(){ Assertions.assertEquals(4, this.bedTruck.getContainerHeightFeet()); }

  @Test
  @DisplayName("When initialized a Truck's currentLoadCubicFeet is 0")
  public void init_truck_currentLoadCubicFeet_equals_0(){ Assertions.assertEquals(0, this.truck.getCurrentLoadCubicFeet()); }

  @Test
  @DisplayName("Truck has method to calculate volume capacity")
  public void calculate_volumeCapacity_method(){
    Assertions.assertEquals(144, this.truck.volumeCapacity());
  }

  @Test
  @DisplayName("Truck has method to add to currentLoadCubicFeet")
  public void add_to_currentLoadCubicFeet_method(){
    this.truck.addCargo(72);
    Assertions.assertEquals(72, this.truck.getCurrentLoadCubicFeet());
  }

  @Test
  @DisplayName("currentLoadCubicFeet does not change if added to over capacity")
  public void no_change_currentLoadCubicFeet_method_over_capacity (){
    this.truck.addCargo(150);
    Assertions.assertEquals(0, this.truck.getCurrentLoadCubicFeet());
  }

  @Test
  @DisplayName("method to add to currentLoadCubicFeet returns false if adding over capacity")
  public void add_to_currentLoadCubicFeet_method_over_capacity_return_false(){ Assertions.assertEquals(false, this.truck.addCargo(150)); }

  @Test
  @DisplayName("Truck has method to empty currentLoadCubicFeet")
  public void empty_currentLoadCubicFeet_method(){
    this.truck.addCargo(72);
    this.truck.emptyCargo();
    Assertions.assertEquals(0, this.truck.getCurrentLoadCubicFeet());
  }
}
