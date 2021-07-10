public class Inventory {

  private Weapon weapon;
  private Armors armors;
  private boolean food=false;
  private boolean fireWood=false;
  private boolean water=false;
  

  Inventory(boolean food, boolean fireWood, boolean water){

        this.food = food;
        this.fireWood = fireWood;
        this.water = water;
        this.setWeapon(new Weapon("Punch", -1, 1, 0));
        this.setArmors(new Armors(-1, "Clothed", 0, 0));
    }

public boolean isWater() {
    return water;
}

public void setWater(boolean water) {
    this.water = water;
}

public boolean isFireWood() {
    return fireWood;
}

public void setFireWood(boolean fireWood) {
    this.fireWood = fireWood;
}

public boolean isFood() {
    return food;
}

public void setFood(boolean food) {
    this.food = food;
}

public Armors getArmors() {
    return armors;
}

public void setArmors(Armors armors) {
    this.armors = armors;
}

public Weapon getWeapon() {
    return weapon;
}

public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
}
    
}
