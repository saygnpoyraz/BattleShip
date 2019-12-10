public class DefenceWithArmor implements  DefenceBehaviour{
    @Override
    public void defence(Ship ship) {
        ship.printStatus();
        ship.setArmor(ship.getArmor()+2) ;
        ship.printStatus();
    }
}
