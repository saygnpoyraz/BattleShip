public class BombShipFactory extends ShipFactory {
    @Override
    protected Ship produceShip() {
        BombShip bombShip = new BombShip();
        bombShip.attackBehaviour = new AttackWithBomb();
        bombShip.defenceBehaviour = new DefenceNoWay();
        bombShip.registerObserver(new HealthStatus());
        bombShip.setHealth(5);
        bombShip.setArmor(0);
        return bombShip;
    }
}
