package kg.geeks.game.players;

public abstract class Hero extends GameEntity {
    private kg.geeks.game.players.SuperAbility ability;

    public Hero(int health, int damage, kg.geeks.game.players.SuperAbility ability, String name) {
        super(health, damage, name);
        this.ability = ability;
    }

    public kg.geeks.game.players.SuperAbility getAbility() {
        return ability;
    }

    public void attack(Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }

    public abstract void applySuperPower(Boss boss, Hero[] heroes);
}
