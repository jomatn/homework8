package kg.geeks.game.players;

public class Magic extends kg.geeks.game.players.Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, kg.geeks.game.players.SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, kg.geeks.game.players.Hero[] heroes) {
        // logic of boosting
    }
}
