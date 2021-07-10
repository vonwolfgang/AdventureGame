public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }
    
    @Override
    public boolean onLocation(){
        System.out.println("================================");
        System.out.println("You are in the Safe House");
        System.out.println("Your health is recovering now");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("================================");
        winControl();
        System.out.println("================================");
        return true;
    }    

    public void winControl(){

        if ((this.getPlayer().getInventory().isWater()==true) && (this.getPlayer().getInventory().isFood()==true)) {
            if (this.getPlayer().getInventory().isFireWood()==true) {
                System.out.println("Oh man you won the game");
                System.out.println("Now, it's up to you. If you want you can keep playing or you can quit");
            }
            else{
                System.out.println("Oh man if you want to win the game you need to get the Firewood also.");
                System.out.println("you have just Food and Water");
            }
        }
        else if ((this.getPlayer().getInventory().isWater()==true) && (this.getPlayer().getInventory().isFireWood()==true)) {
            if (this.getPlayer().getInventory().isFood()==true) {
                System.out.println("Oh man you won the game");
                System.out.println("Now, it's up to you. If you want you can keep playing or you can quit");
            }
            else{
                System.out.println("Oh man if you want to win the game you need to get the Food also.");
                System.out.println("you have just Water and Firewood");
            }
        }
        else if ((this.getPlayer().getInventory().isFireWood()==true) && (this.getPlayer().getInventory().isFood()==true)) {
            if (this.getPlayer().getInventory().isWater()==true) {
                System.out.println("Oh man you won the game");
                System.out.println("Now, it's up to you. If you want you can keep playing or you can quit");
            }
            else{
                System.out.println("Oh man if you want to win the game you need to get the Water also.");
                System.out.println("you have just Food and Firewood");
            }
        }
        else{
            System.out.println("To win the game you need to find all treasure.");
            System.out.println("Treasure: Food, Firewood, Water");
        }   
    
    }

    
}
