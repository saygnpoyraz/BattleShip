public class AttackNoWay implements AttackBehaviour {

    @Override
    public void attack(Position position) {
        System.out.println("This ship cannot attack");
    }
}
