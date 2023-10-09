
public class Main {
    public static void main(String[] args) {
        Player player = new Player(16, 10, 60, 5, 15);
        Monster monster = new Monster(13, 8, 80, 3, 15);
        int numOfHeal=4;

        while (player.isAlive() && monster.isAlive()) {
            if (player.getHealth()< player.getMaxHealth()/2 & numOfHeal>0) {
                player.heal(numOfHeal);
                numOfHeal--;
                System.out.println("Player applies healing");
            }
            else {
                boolean playerAttackSuccess = player.attack(monster);

                if (playerAttackSuccess) {
                    System.out.println("Player attacks and hits monster.");
                } else {
                    System.out.println("Player attacks but misses.");
                }
            }
            boolean monsterAttackSuccess = monster.attack(player);



            if (monsterAttackSuccess) {
                System.out.println("Monster attacks and hits player.");
            } else {
                System.out.println("Monster attacks but misses.");
            }


            System.out.println("Player Health: " + player.getHealth());
            System.out.println("Monster Health: " + monster.getHealth());
        }


        if (player.isAlive()) {
            System.out.println("Player wins!");
        } else {
            System.out.println("Monster wins!");
        }
    }
}
