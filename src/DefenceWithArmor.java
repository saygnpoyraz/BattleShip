public class DefenceWithArmor implements  DefenceBehaviour{
    @Override
    public void defence(Ship ship) {
        ship.setArmor(ship.getArmor()+2) ;
    }
}
