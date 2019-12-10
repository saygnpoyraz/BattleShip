public class BombShipFactory extends ShipFactory {
    @Override
    public Ship produceShip() {
        BombShip bombShip = new BombShip();
        bombShip.setName("Bomb Ship");
        bombShip.attackBehaviour = new AttackWithBomb();
        bombShip.defenceBehaviour = new DefenceNoWay();
        bombShip.registerObserver(new HealthStatus());
        bombShip.setHealth(5);
        bombShip.setArmor(0);
        return bombShip;
    }
}
