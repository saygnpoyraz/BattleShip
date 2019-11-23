public class AttackWithBomb implements AttackBehaviour
{

    @Override
    public void attack(Position position) {
        position.getShip().getDamage(6);
        position.getShip().notifyObservers();
        System.out.println("BOMB!!!!");
    }
}
