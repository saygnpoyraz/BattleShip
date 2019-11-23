public class HealthStatus implements Observer{
    @Override
    public void update(Ship ship) {
        if (ship.getHealth() == 0){
            ShipFactory nullShipFactory = new NullShipFactory();
            ship = nullShipFactory.produceShip();
        }

    }
}
