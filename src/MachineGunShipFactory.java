public class MachineGunShipFactory extends ShipFactory {
    @Override
    public Ship produceShip() {
        MachineGunShip machineGunShip = new MachineGunShip();
        machineGunShip.setName("MachineGun Ship");
        machineGunShip.attackBehaviour = new AttackWithMachineGun();
        machineGunShip.defenceBehaviour = new DefenceWithArmor();
        machineGunShip.registerObserver(new HealthStatus());
        machineGunShip.setHealth(4);
        machineGunShip.setArmor(0);
        return machineGunShip;
    }
}
