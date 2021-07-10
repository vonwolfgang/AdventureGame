import java.util.Random;

public class BattleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);  
        this.setObstacle(obstacle);
        this.setAward(award);
        this.setMaxObstacle(maxObstacle);
    }


    public int getMaxObstacle() {
        return maxObstacle;
    }


    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }


    public String getAward() {
        return award;
    }


    public void setAward(String award) {
        this.award = award;
    }


    public Obstacle getObstacle() {
        return obstacle;
    }


    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }


    @Override
    public boolean onLocation() {

        int obsNumber = randomObstacleNumber();

        System.out.println("You are here now: " +  this.getName());
        System.out.println("There are "+ obsNumber +" "+ this.getObstacle().getName()+ " in there");
        System.out.println("<F>ight or <R>un");
        String selectCase = inp.nextLine().toUpperCase();

        if (selectCase.equals("F")) {
            if(combat(obsNumber)){
                System.out.println("there is no more enemy in there.");
                controlAward();
                return true;
            }
        }

        if(this.getPlayer().getHealth()<=0){
            System.out.println("You are dead");
            return false;
        }


        return true;
    }

    public boolean combat(int obstacleNumber){

        if (Game.selectLoc == 6) {

                for(int i=1; i<=obstacleNumber; i++){

                    this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
                    playerStats();
                    obstacleStats(i);
                    
                    while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                        
                        System.out.println("<H>it or <R>un");
                        String selectCombat = inp.nextLine().toUpperCase();
                        int randomChance = randomFightChance();
                        // 1 = warrior ---- 2 = obstacle 
        
                        if (selectCombat.equals("H")) {
                            
                            if(randomChance == 1){
                                System.out.println();
                                System.out.println("===========================================");
                                System.out.println("You hit to the " + this.getObstacle().getName());
                                int newObsHealth = (this.getObstacle().getHealth()) - (this.getPlayer().getTotalDamage());
                                this.getObstacle().setHealth(newObsHealth);
                                afterHit();
                                if(this.getObstacle().getHealth()>0){
                                    System.out.println();
                                    System.out.println("===========================================");
                                    System.out.println("Monster hit to you");
                                    int newObsDamage = (this.getObstacle().getDamage()) - (this.getPlayer().getInventory().getArmors().getBlock());
                                    newObsDamage = (newObsDamage < 0 ? 0: newObsDamage);
                                    int newPlayerHealth = (this.getPlayer().getHealth()) - (newObsDamage);
                                    this.getPlayer().setHealth(newPlayerHealth);
                                    afterHit();
                                }
                            }
                            else if(randomChance == 2){
        
                                if(this.getObstacle().getHealth()>0){
                                    System.out.println();
                                    System.out.println("===========================================");
                                    System.out.println("Monster hit to you");
                                    int newObsDamage = (this.getObstacle().getDamage()) - (this.getPlayer().getInventory().getArmors().getBlock());
                                    newObsDamage = (newObsDamage < 0 ? 0: newObsDamage);
                                    int newPlayerHealth = (this.getPlayer().getHealth()) - (newObsDamage);
                                    this.getPlayer().setHealth(newPlayerHealth);
                                    afterHit();
                                }
                                System.out.println();
                                System.out.println("===========================================");
                                System.out.println("You hit to the " + this.getObstacle().getName());
                                int newObsHealth = (this.getObstacle().getHealth()) - (this.getPlayer().getTotalDamage());
                                this.getObstacle().setHealth(newObsHealth);
                                afterHit();
                            }
        
                        }
                        else{
                            return false;
                        }

                        if(this.getObstacle().getHealth()<=0){
                            System.out.println("=============================");
                            System.out.println("You defated "+ i+". enemy");
                            System.out.println(" ");
                            randomTreasure();
                            System.out.println("=============================");
                        }
                        else if(this.getPlayer().getHealth() <=0){
                            System.out.println("You are dead");
                            return false;
                        }
                    }
        
        
                }
            
        }
        else{

                for(int i=1; i<=obstacleNumber; i++){

                    this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
                    playerStats();
                    obstacleStats(i);
                    
                    while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0){
                        
                        System.out.println("<H>it or <R>un");
                        String selectCombat = inp.nextLine().toUpperCase();
                        int randomChance = randomFightChance();
                        // 1 = warrior ---- 2 = obstacle 
        
                        if (selectCombat.equals("H")) {
                            
                            if(randomChance == 1){
                                System.out.println();
                                System.out.println("===========================================");
                                System.out.println("You hit to the " + this.getObstacle().getName());
                                int newObsHealth = (this.getObstacle().getHealth()) - (this.getPlayer().getTotalDamage());
                                this.getObstacle().setHealth(newObsHealth);
                                afterHit();
                                if(this.getObstacle().getHealth()>0){
                                    System.out.println();
                                    System.out.println("===========================================");
                                    System.out.println("Monster hit to you");
                                    int newObsDamage = (this.getObstacle().getDamage()) - (this.getPlayer().getInventory().getArmors().getBlock());
                                    newObsDamage = (newObsDamage < 0 ? 0: newObsDamage);
                                    int newPlayerHealth = (this.getPlayer().getHealth()) - (newObsDamage);
                                    this.getPlayer().setHealth(newPlayerHealth);
                                    afterHit();
                                }
                            }
                            else if(randomChance == 2){
        
                                if(this.getObstacle().getHealth()>0){
                                    System.out.println();
                                    System.out.println("===========================================");
                                    System.out.println("Monster hit to you");
                                    int newObsDamage = (this.getObstacle().getDamage()) - (this.getPlayer().getInventory().getArmors().getBlock());
                                    newObsDamage = (newObsDamage < 0 ? 0: newObsDamage);
                                    int newPlayerHealth = (this.getPlayer().getHealth()) - (newObsDamage);
                                    this.getPlayer().setHealth(newPlayerHealth);
                                    afterHit();
                                }
                                System.out.println();
                                System.out.println("===========================================");
                                System.out.println("You hit to the " + this.getObstacle().getName());
                                int newObsHealth = (this.getObstacle().getHealth()) - (this.getPlayer().getTotalDamage());
                                this.getObstacle().setHealth(newObsHealth);
                                afterHit();
                            }
        
                        }
                        else{
                            return false;
                        }
                        if(this.getObstacle().getHealth()<=0){
                            System.out.println();
                            System.out.println("You defated "+ i+". enemy");
                            System.out.println("You earned " + this.getObstacle().getAwardMoney()+ " coins");
                            this.getPlayer().setMoney((this.getPlayer().getMoney())+(this.getObstacle().getAwardMoney()));
                            System.out.println("You have " +this.getPlayer().getMoney()+" coins");
                            System.out.println();
                        }
                        else if(this.getPlayer().getHealth() <=0){
                            System.out.println("You are dead");
                            return false;
                        }
                    }
        
        
                }

        }



        return true;
    }

    public void randomTreasure(){
        
        Random r = new Random();
        int randomType = r.nextInt(100)+1;

        if (randomType<=45) {
            System.out.println("You couldn't earn anything from this snake");
        }
        else if(randomType>45 && randomType<=60){
            
            System.out.println("You earned a weapon");
            int randomWeapon = r.nextInt(10)+1;
           

            if (randomWeapon<=2) {
                System.out.println("You got a rifle");
                this.getPlayer().getInventory().getWeapon().setName(Weapon.weapons()[2].getName());
                this.getPlayer().getInventory().getWeapon().setDamage(Weapon.weapons()[2].getDamage());
            }
            else if (randomWeapon>2 && randomWeapon<=5) {
                System.out.println("You got a sword");
                this.getPlayer().getInventory().getWeapon().setName(Weapon.weapons()[1].getName());
                this.getPlayer().getInventory().getWeapon().setDamage(Weapon.weapons()[1].getDamage());
            }
            else if (randomWeapon>5 && randomWeapon<=10) {
                System.out.println("You got a gun");
                this.getPlayer().getInventory().getWeapon().setName(Weapon.weapons()[0].getName());
                this.getPlayer().getInventory().getWeapon().setDamage(Weapon.weapons()[0].getDamage());
            }
        
        }
        else if (randomType>60 && randomType<=75) {
            
            System.out.println("You earned an armor");
            int randomArmor = r.nextInt(10)+1;
            
            if (randomArmor<=2) {
                System.out.println("You got a heavy armor");
                this.getPlayer().getInventory().getArmors().setName(Armors.armors()[2].getName());
                this.getPlayer().getInventory().getArmors().setBlock(Armors.armors()[2].getBlock());
            }
            else if (randomArmor>2 && randomArmor<=5) {
                System.out.println("You got a middle armor");
                this.getPlayer().getInventory().getArmors().setName(Armors.armors()[1].getName());
                this.getPlayer().getInventory().getArmors().setBlock(Armors.armors()[1].getBlock());
            }
            else if (randomArmor>5 && randomArmor<=10) {
                System.out.println("You got a light armor");
                this.getPlayer().getInventory().getArmors().setName(Armors.armors()[0].getName());
                this.getPlayer().getInventory().getArmors().setBlock(Armors.armors()[0].getBlock());
            }

        }
        else if (randomType>75 && randomType<=100) {
            
            System.out.println("You earned money");
            int randomMoney = r.nextInt(10)+1;

            if (randomMoney<=2) {
                System.out.println("You got 10 coins");
                this.getPlayer().setMoney((this.getPlayer().getMoney()) + 10);
            }
            else if (randomMoney>2 && randomMoney<=5) {
                System.out.println("You got 5 coins");
                this.getPlayer().setMoney((this.getPlayer().getMoney()) + 5);
            }
            else if (randomMoney>5 && randomMoney<=10) {
                System.out.println("You got a coin");
                this.getPlayer().setMoney((this.getPlayer().getMoney()) + 1);
            }

        }

    }

    public void afterHit(){
        System.out.println("Your health: "+ this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+ "'s health: " + this.getObstacle().getHealth());
    }

    public void playerStats(){
        System.out.println("User's knowladge");
        System.out.println("-------------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmors().getName());
        System.out.println("Money: " + this.getPlayer().getMoney());
    }

    
    public void obstacleStats(int i){
        System.out.println();
        System.out.println("==============="+i+". "+this.getObstacle().getName()+"===============");
        System.out.println(this.getObstacle().getName() + "'s knowladge");
        System.out.println("-------------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award money: " + this.getObstacle().getAwardMoney());
    }

    public int randomObstacleNumber(){
        
        Random r = new Random();

        return r.nextInt(this.getMaxObstacle())+1;
    }

    public int randomFightChance(){
        
        Random r = new Random();

        return r.nextInt(2)+1;
    }

    public void controlAward(){
        if (Game.selectLoc == 3 && this.getPlayer().getInventory().isFood() == false) {
            System.out.println("Weldone you win the food");
            this.getPlayer().getInventory().setFood(true);
            
        }
        if (Game.selectLoc == 4 && this.getPlayer().getInventory().isFireWood() == false) {
            System.out.println("Weldone you win the firewood");
            this.getPlayer().getInventory().setFireWood(true);
            
        }
        if (Game.selectLoc == 5 && this.getPlayer().getInventory().isWater() == false) {
            System.out.println("Weldone you win the water");
            this.getPlayer().getInventory().setWater(true);
            
        }
    }
    
}
