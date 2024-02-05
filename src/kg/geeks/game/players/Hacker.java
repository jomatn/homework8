package kg.geeks.game.players;

import java.util.Random;

public class Hacker extends Hero {
    private int stolenHealth = 25;
    private Random random;
    private int roundsCounter = 0;

    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.random = new Random();
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        roundsCounter++;
        if (roundsCounter == 1) {
            Hero randomHero = getOneOfHeroes(heroes);
            boss.setHealth(boss.getHealth() - stolenHealth);
            randomHero.setHealth(randomHero.getHealth() + stolenHealth);

            System.out.println(this.getName() + " stole " + stolenHealth + " health from Boss and gave it to " + randomHero.getName());
            roundsCounter = 0;
        }
    }

    private Hero getOneOfHeroes(Hero[] heroes) {
        int randomIndex = random.nextInt(heroes.length);
        return heroes[randomIndex];
    }
}
