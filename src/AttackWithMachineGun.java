
public class AttackWithMachineGun implements AttackBehaviour {
    @Override
    public void attack(Position position) {
        position.getShip().getDamage(3);
        position.getShip().notifyObservers();
        System.out.println("TA TA TA ");
    }
}
