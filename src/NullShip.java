public class NullShip extends  Ship {

    @Override
    public void getDamage(int damage) {
        super.getDamage(0);
    }
}
