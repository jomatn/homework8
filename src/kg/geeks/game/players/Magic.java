package kg.geeks.game.players;

import kg.geeks.game.players.Boss;
import kg.geeks.game.players.Hero;
import kg.geeks.game.players.SuperAbility;
import kg.geeks.game.players.logic.RPG_Game;

import java.util.Random;

public class Magic extends Hero {
    private int boostDamage = 25;

    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            hero.setDamage(hero.getDamage() + this.boostDamage);
        }
    }
}