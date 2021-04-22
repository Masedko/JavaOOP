package lab4;

public class Boat {
    String name;
    boolean isRowing;
    char quality;
    int maxNumberOfPassengers;
    int cost;

    Boat(String name, boolean isRowing, char quality,
         int maxNumberOfPassengers, int cost){
        this.name = name;
        this.isRowing = isRowing;
        this.quality = quality;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.cost = cost;
    }
    public String getName(){
        return name;
    }
    public int getMaxNumberOfPassengers(){
        return maxNumberOfPassengers;
    }
}
