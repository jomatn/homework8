package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Boss extends kg.geeks.game.players.GameEntity {
    private kg.geeks.game.players.SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }

    public kg.geeks.game.players.SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence() {
        kg.geeks.game.players.SuperAbility[] variants = kg.geeks.game.players.SuperAbility.values();
        int randomIndex = RPG_Game.random.nextInt(variants.length);
        this.defence = variants[randomIndex];
    }

    public void attack(kg.geeks.game.players.Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                if (heroes[i] instanceof Berserk && this.getDefence() != kg.geeks.game.players.SuperAbility.BLOCK_DAMAGE_AND_REVERT) {
                    ((Berserk) heroes[i]).setBlockedDamage(this.getDamage() / 5);
                    heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - ((Berserk) heroes[i]).getBlockedDamage()));
                } else {
                    heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "BOSS " + super.toString() + " defence: " + this.defence;
    }
}
