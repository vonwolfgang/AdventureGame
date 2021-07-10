import java.util.Scanner;

public class Player {
    
    private int damage;
    private int health;
    private int money;
    private String playerName;
    private String warriorName;
    private Scanner inp = new Scanner(System.in);
    private Inventory inventory;
    private int originalHealth;

    public Player(String playerName){
        this.setPlayerName(playerName);
        this.setInventory(new Inventory(false, false, false));
    }


    public int getOriginalHealth() {
        return originalHealth;
    }


    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }


    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public String getWarriorName() {
        return warriorName;
    }
    public void setWarriorName(String warriorName) {
        this.warriorName = warriorName;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getHealth() {

        if (this.health<0) {
            this.health = 0;
        }
        return health;
    }
    public void setHealth(int health) {

        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getTotalDamage(){
        return damage+this.getInventory().getWeapon().getDamage();
    }


    public void selectChar(){

        GameCharacter[] charList = {new Samurai(), new Archery(), new Knight()};
        System.out.println("Characters");
        System.out.println("===========================================");
        for (GameCharacter gameCharacter : charList) {
            System.out.println("Id: "+ gameCharacter.getId() +" Name: " + gameCharacter.getName() + " Health: " + gameCharacter.getHealth() + " Damage: " + gameCharacter.getDamage() + " Money: " + gameCharacter.getMoney());
        }
        System.out.println("===========================================");
        System.out.print("Please login a character id: ");
        int selectChar = inp.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            
            case 2:
                initPlayer(new Archery());
                break;
            case 3:
                initPlayer(new Knight());
                break;
                
            default:
                initPlayer(new Samurai());
                break;
        }

        System.out.println("===================================");
        System.out.println();
        System.out.println("User's knowladge: ");
        System.out.println("User's name: "+this.getPlayerName() +" Warrior's Name: " + this.getWarriorName() + " Health: " + this.getHealth() + " Damage: " + this.getTotalDamage() + " Money: " + this.getMoney());
    }

    public void printInfo(){
        System.out.println("Your weapon: " + this.getInventory().getWeapon().getName()
        + " Your damage: " + this.getDamage() +" Your armor: "+this.getInventory().getArmors().getName()+" Your blocking: "+this.getInventory().getArmors().getBlock()+ " Your health: " + this.getHealth() + " Your money: " + this.getMoney());
    }




    public void initPlayer(GameCharacter gameCharacter){
        
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setWarriorName(gameCharacter.getName());
        this.setMoney(gameCharacter.getMoney());
    }

    
}
