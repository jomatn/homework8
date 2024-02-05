package kg.geeks.game.players;

public abstract class Hero extends GameEntity {
    private SuperAbility ability;

    public Hero(int health, int damage, SuperAbility ability, String name) {
        super(health, damage, name);
        this.ability = ability;
    }
    private boolean receivedMagicPower = false;


    public boolean hasReceivedMagicPower() {
        return receivedMagicPower;
    }

    public void setReceivedMagicPower(boolean receivedMagicPower) {
        this.receivedMagicPower = receivedMagicPower;
    }


    public SuperAbility getAbility() {
        return ability;
    }

    public void attack(Boss boss) {
        boss.setHealth(boss.getHealth() - this.getDamage());
    }

    public abstract void applySuperPower(Boss boss, Hero[] heroes);
}
