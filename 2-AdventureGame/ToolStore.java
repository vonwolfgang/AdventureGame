public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }
    
    @Override
    public boolean onLocation(){
        
        System.out.println("----------Welcome to the Tool Store----------");
        System.out.println("1-Weapons\n2-Armors\n3-Quit");
        System.out.print("Please choose an id: ");
        int selectTool = Location.inp.nextInt();
        while(selectTool <1 || selectTool>3){
            System.out.println("You chose a wrong thing");
            selectTool = Location.inp.nextInt();
        }

        switch (selectTool) {
            case 1:
                printWeapons();
                buyWeapon();
                break;
            case 2:
                printArmors();
                buyArmor();
                break;
            case 3:
                System.out.println("You are exiting now");
                return true;
        }
        return true;
    }

    public void printWeapons(){
        System.out.println("------------Weapons------------");
        System.out.println("0-Quit");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println("Id: "+ weapon.getId()+" Name: "+weapon.getName()+" Damage: "+weapon.getDamage()+" Price: "+weapon.getPrice());
        }
    }

    public void buyWeapon(){
          
        System.out.print("Please choose a id: ");
        int selectWeapon = inp.nextInt();
        
        while(selectWeapon <0 || selectWeapon>Weapon.weapons().length){
            System.out.println("You chose a wrong thing");
            selectWeapon = Location.inp.nextInt();
        }  

        if (selectWeapon != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);
            if (selectedWeapon != null){

                if (selectedWeapon.getPrice()>this.getPlayer().getMoney()) {
                    System.out.println(" ");
                    System.out.println("You don't have enough money");
                    System.out.println(" ");        
                }
                else{
                    System.out.println(" ");
                    System.out.println("You have bought this weapon " + selectedWeapon.getName());
                    int newMoney = (this.getPlayer().getMoney()) - (selectedWeapon.getPrice());
                    this.getPlayer().setMoney(newMoney);
                    System.out.println(" ");
                    System.out.println("Your new money: " + this.getPlayer().getMoney());
                    System.out.println(" ");
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    this.getPlayer().setDamage((this.getPlayer().getInventory().getWeapon().getDamage())+ (this.getPlayer().getDamage()));
                }   
            } 
        }


        
    }

    public void printArmors(){
        System.out.println("------------Armors------------");
        System.out.println("0-Quit");
        for (Armors armors : Armors.armors()) {
            System.out.println("Id: " + armors.getId()+ " Name: "+armors.getName()+" Block: "+armors.getBlock()+" Price: " + armors.getPrice());
        }
    }

    public void buyArmor(){
          
        System.out.print("Please choose a armor id: ");
        int selectArmor = inp.nextInt();
        
        while(selectArmor <0 || selectArmor>Armors.armors().length){
            System.out.println("You chose a wrong thing");
            selectArmor = Location.inp.nextInt();
        }  

        if (selectArmor!=0) {
            Armors selectedArmor = Armors.getArmorById(selectArmor);
            if (selectedArmor != null){
    
                if (selectedArmor.getPrice()>this.getPlayer().getMoney()) {
                    System.out.println(" ");
                    System.out.println("You don't have enough money");
                    System.out.println(" ");        
                }
                else{
                    System.out.println(" ");
                    System.out.println("You have bought this armor " + selectedArmor.getName());
                    int newMoney = (this.getPlayer().getMoney()) - (selectedArmor.getPrice());
                    this.getPlayer().setMoney(newMoney);
                    System.out.println(" ");
                    System.out.println("Your new money: " + this.getPlayer().getMoney());
                    System.out.println(" ");
                    this.getPlayer().getInventory().setArmors(selectedArmor);
                }   
            } 
        }

    }
    
}
