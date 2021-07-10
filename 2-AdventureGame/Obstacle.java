public class Obstacle {
    
    private int id;
    private String name;
    private int health;
    private int damage;
    private int awardMoney;
    private int originalHealth;

    public Obstacle(int id, String name, int health, int damage, int awardMoney){
        this.setId(id);
        this.setName(name);
        this.setHealth(health);
        this.setDamage(damage);
        this.setAwardMoney(awardMoney);
        this.setOriginalHealth(health);
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public int getAwardMoney() {
        return awardMoney;
    }

    public void setAwardMoney(int awardMoney) {
        this.awardMoney = awardMoney;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        
        if (health<0) {
            health = 0;
        }
        this.health = health;
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

    

}
