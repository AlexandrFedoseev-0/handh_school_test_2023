import java.util.Random;

public class Creature {
    private int attack;
    private int defense;
    private int health;
    private int maxHealth;
    private int minDamage;
    private int maxDamage;

    public Creature(int attack, int defense, int health, int minDamage, int maxDamage) {
        if (attack<0 | defense<0 | health<0 | minDamage<0 | maxDamage < 0 ){
            throw new IllegalArgumentException("parameters cannot be negative.");
        }
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxHealth = health;

    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        if (damage < 0) {
            throw new IllegalArgumentException("Damage cannot be negative.");
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean attack(Creature target) {
        int attackModifier = attack - target.defense + 1;

        if (attackModifier < 1) {
            attackModifier = 1;
        }

        Random random = new Random();
        int numberOfDice = attackModifier;
        int successfulHits = 0;

        for (int i = 0; i < numberOfDice; i++) {
            int diceRoll = random.nextInt(6) + 1;
            if (diceRoll >= 5) {
                successfulHits++;
            }
        }

        if (successfulHits > 0) {
            int damage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
            target.takeDamage(damage);
            return true;
        } else {
            return false;
        }
    }

    public void heal(int numOfHeal) {
        if (!isAlive()) {
            throw new IllegalStateException("Cannot heal a dead creature.");
        }

        if (numOfHeal>0) {
            int maxHealing = maxHealth * 30 / 100; // 30% от максимального здоровья

            if (health + maxHealing > maxHealth) {
                health = maxHealth;
            } else {
                health += maxHealing;
            }
        }
    }
}

