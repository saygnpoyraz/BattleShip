import java.util.LinkedList;
import java.util.List;

public abstract class Ship implements Observable {

     List<Observer> observers;


     private String name;
     private int health;
     private int armor;

     AttackBehaviour attackBehaviour;
     DefenceBehaviour defenceBehaviour;


    public Ship() {
        observers = new LinkedList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void attack(Position position){attackBehaviour.attack(position);}

    public void defence(){defenceBehaviour.defence(this);}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void printStatus(){
        if (health == 0) System.out.println("DEAD");
        else System.out.println("NAME: " + name + " HP: " + health + " ARMOR: " + armor);
    }
    public void getDamage(int damage){
        if (armor >= damage) armor = armor - damage;
        else{
            health = health + armor - damage;
            armor = 0;
        }
        if (health < 0 ) health = 0;
    }

}
