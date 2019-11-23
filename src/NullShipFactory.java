public class NullShipFactory extends ShipFactory {


    @Override
    protected Ship produceShip() {
        NullShip nullShip = new NullShip();
        nullShip.attackBehaviour = new AttackNoWay();
        nullShip.defenceBehaviour = new DefenceNoWay();
        return nullShip;
    }
}
