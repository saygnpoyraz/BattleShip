public class AttackWithBomb implements AttackBehaviour
{

    @Override
    public void attack(Position position) {
        if (position.getShip() instanceof  NullShip) System.out.println("MISSsss");
        position.getShip().getDamage(10);
        position.getShip().notifyObservers();
        if (!(position.getShip() instanceof NullShip))
            System.out.println("BOMB!!!");
    }
}
