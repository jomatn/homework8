package kg.geeks.game.players;

import kg.geeks.game.players.logic.RPG_Game;

import java.util.Random;

public class Hacker extends Hero {
    private int stolenHealth = 25;
    private Random random;
    private int roundsCounter = 0; // Счетчик раундов

    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
        this.random = new Random();
    }

    public void applySuperPower(Boss boss, Hero[] heroes) {
        roundsCounter++; // Увеличиваем счетчик раундов

        // Если прошел один раунд
        if (roundsCounter == 1) {
            // Выбираем случайного героя из массива heroes
            Hero randomHero = getOneOfHeroes(heroes);

            // Передаем здоровье выбранному герою
            boss.setHealth(boss.getHealth() - stolenHealth);
            randomHero.setHealth(randomHero.getHealth() + stolenHealth);

            System.out.println(this.getName() + " stole " + stolenHealth + " health from Boss and gave it to " + randomHero.getName());

            // Сбрасываем счетчик раундов
            roundsCounter = 0;
        }
    }

    private Hero getOneOfHeroes(Hero[] heroes) {
        int randomIndex = random.nextInt(heroes.length);
        return heroes[randomIndex];
    }
}
