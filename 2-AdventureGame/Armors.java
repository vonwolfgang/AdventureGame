public class Armors {
   
    private int id;
    private int block;
    private String name;
    private int price;

    Armors(int id, String name, int block, int price){
        this.setId(id);
        this.setName(name);
        this.setBlock(block);
        this.setPrice(price);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Armors[] armors(){
        Armors[] armorList = {new Armors(1,"Light", 1, 15), new Armors(2, "Middle", 3, 25), new Armors(3, "Heavy", 5, 40)};
        return armorList;
    }

    public static Armors getArmorById(int id){
        for (Armors a : Armors.armors()) {
            
            if(a.getId()==id){
                return a;
            }

            
        }
        return null;
    }

    

}
