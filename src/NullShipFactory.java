public class NullShipFactory extends ShipFactory {


    @Override
    public Ship produceShip() {
        NullShip nullShip = new NullShip();
        nullShip.attackBehaviour = new AttackNoWay();
        nullShip.defenceBehaviour = new DefenceNoWay();
        return nullShip;
    }
}
