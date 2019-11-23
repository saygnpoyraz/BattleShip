public class SandalFactory extends ShipFactory {


    @Override
    protected Ship produceShip() {
        Sandal sandal = new Sandal();
        sandal.attackBehaviour = new AttackNoWay();
        sandal.defenceBehaviour = new DefenceWithArmor();
        sandal.registerObserver(new HealthStatus());
        sandal.setHealth(2);
        sandal.setArmor(2);
        return sandal;
    }
}
