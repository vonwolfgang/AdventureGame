public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(String name, int id, int damage, int price){
        this.setName(name);
        this.setId(id);
        this.setDamage(damage);
        this.setPrice(price);
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static Weapon[] weapons(){
        Weapon[] weapons = {new Weapon("Guns", 1, 2, 10), new Weapon("Sword", 2, 3, 35), new Weapon("Rifle", 3, 7, 45)};
        return weapons;
    }

    public static Weapon getWeaponById(int id){
        for (Weapon w : Weapon.weapons()) {
            
            if(w.getId()==id){
                return w;
            }

        }
        return null;
    }
    

}
