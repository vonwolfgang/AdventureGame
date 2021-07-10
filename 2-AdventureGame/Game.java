import java.util.Scanner;

public class Game{

    private Scanner inp = new Scanner(System.in);
    protected static int selectLoc;
    public Player player;

    public void start(){
        
        System.out.println(" ");
        System.out.println("Welcome to the adventure game!");
        System.out.print("Please login your name: ");
        
        String playerName = inp.nextLine();
        
        player = new Player(playerName);
        
        System.out.println("---------------Welcome " + player.getPlayerName()+"---------------");
        System.out.println("PLease choice a character: ");
        
        player.selectChar();

        Location location = null;
        while(true){
            
            player.printInfo();
            System.out.println(" ");
            System.out.println("================================================");
            System.out.println("Regions: ");
            System.out.println("1-Safe House --> There is no enemy at this house and your health recovers in there");
            System.out.println("2-Tool Store  --> you can buy weapon and armor in there");
            System.out.println("3-Cave  --> There are zombies and food as an award");
            System.out.println("4-Forest  --> There are vampires and firewood as an award"); 
            System.out.println("5-River --> There are bears and water as an award"); 
            System.out.println("6-Mine --> There are snakes and chance of getting weapon, armor or money");                  
            System.out.println("7-Quit  --> If you wanna quit this game choose that");
            System.out.println("================================================");
            System.out.print("Please login a id which you want: ");
            selectLoc = inp.nextInt();
            int j = 0;
            while(j<1){
                j = 0;
                if(selectLoc == 3 && player.getInventory().isFood()==true){
    
                    System.out.println("You have already finished this map you cannot go there again");
                    System.out.print("Please choose different place: ");
                    selectLoc = inp.nextInt();
                    j = 0;
                }
                else if(selectLoc == 4 && player.getInventory().isFireWood()==true){
    
                    System.out.println("You have already finished this map you cannot go there again");
                    System.out.print("Please choose different place: ");
                    selectLoc = inp.nextInt();
                    j = 0;
                }
                
                else if(selectLoc == 5 && player.getInventory().isWater()==true){
    
                    System.out.println("You have already finished this map you cannot go there again");
                    System.out.print("Please choose different place: ");
                    selectLoc = inp.nextInt();
                    j = 0;
                }
                else{
                    System.out.println("You can go there");
                    j = 1;
                }    
            }
            System.out.println(" ");

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                case 7:
                    location = null;
                    break;
                default:
                    System.out.println("please login a valid id");
                    break;
            }
            if (location == null) {
                System.out.println("You have just quitted");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game over");
                break;
            }
        }  
    }
}