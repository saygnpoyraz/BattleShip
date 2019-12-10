public class HealthStatus implements Observer{
    @Override
    public void update(Ship ship) {
        if (ship.isDead()){
            ship.shipDead();
        }

    }
}
