package kg.geeks.game.players;

public class Berserk extends kg.geeks.game.players.Hero {
    private int blockedDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, kg.geeks.game.players.SuperAbility.BLOCK_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(kg.geeks.game.players.Boss boss, kg.geeks.game.players.Hero[] heroes) {
        boss.setHealth(boss.getHealth() - this.blockedDamage);
        System.out.println("Berserk " + this.getName() + " reverted " + this.blockedDamage);
    }

    public int getBlockedDamage() {
        return blockedDamage;
    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}
