import java.util.Random;

public class Snake extends Obstacle {



    public Snake() {
        super(4, "Snake", 12, getRanDamage(), 0);
    }
    
    public static int getRanDamage() {
        Random r = new Random();
        int ranDamage;

        ranDamage = r.nextInt(6)+1;

        if (ranDamage < 3) {
            ranDamage = 3;
        }
        return ranDamage;
    }



    
}
