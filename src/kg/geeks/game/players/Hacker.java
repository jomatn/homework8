package kg.geeks.game.players;
import kg.geeks.game.players.logic.RPG_Game;

import java.util.Random;

public class Hacker extends Hero {
    private Hero[] heroes;
    private Random random;
    private int stolenHealth;

    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.STEAL_HEALTH, name);
        this.heroes = new Hero[5];
        this.random = new Random();
        this.stolenHealth = RPG_Game.random.nextInt(10) + 1;  // N-ое количество здоровья

        // Заполняем массив героев объектами Hero
        for (int i = 0; i < heroes.length; i++) {
        }
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boss.setHealth(boss.getHealth() - stolenHealth);
        Hero randomHero = getOneOfHeroes();
        randomHero.setHealth(randomHero.getHealth() + stolenHealth);

        System.out.println(this.getName() + " stole " + stolenHealth + " health from Boss and gave it to " + randomHero.getName());
    }

    public Hero getOneOfHeroes() {
        int randomIndex = random.nextInt(heroes.length);
        return heroes[randomIndex];
    }
}
