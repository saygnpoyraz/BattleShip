public class MachineGunShipFactory extends ShipFactory {
    @Override
    protected Ship produceShip() {
        MachineGunShip machineGunShip = new MachineGunShip();
        machineGunShip.attackBehaviour = new AttackWithMachineGun();
        machineGunShip.defenceBehaviour = new DefenceNoWay();
        machineGunShip.registerObserver(new HealthStatus());
        machineGunShip.setHealth(2);
        machineGunShip.setArmor(0);
        return machineGunShip;
    }
}
