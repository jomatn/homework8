package kg.geeks.game.players;

public class Witcher extends Hero {
    private int lives;

    public Witcher(int health, int damage, int lives, String name) {
        super(health, damage, SuperAbility.EXTRA_LIVE, name);
        this.lives = lives;
        lives = getHealth();
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && this != heroes[i]) {
                int sacrificedHealth = Math.min(this.getHealth(), this.lives);
                System.out.println("Witcher sacrificed " + sacrificedHealth + " health to revive " + heroes[i].getName() + ".");

                heroes[i].setHealth(sacrificedHealth);
                this.setHealth(this.getHealth() - sacrificedHealth);
                break;
            }
            }
        }
    }
