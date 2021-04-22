package lab4;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Boat[] boats = new Boat[]{
                new Boat("Malchezaar", true, 'C', 2, 200),
                new Boat("Alexstraza", false, 'B', 5, 900),
                new Boat("Reno", false, 'S', 20, 15000),
        };
        printArray(boats);
        sortByName(boats);
        printArray(boats);
        sortByQuality(boats);
        printArray(boats);
    }
    private static void sortByName(Boat[] arrayOfBoats){
        Arrays.sort(arrayOfBoats, Comparator.comparing(Boat::getName));
    }
    private static void sortByQuality(Boat[] arrayOfBoats){
        Arrays.sort(arrayOfBoats, Comparator.comparing(Boat::getMaxNumberOfPassengers).reversed());
    }
    private static void printArray(Boat[] arrayOfBoats){
        System.out.println("|  Name of boat  | Is this boat rowing " +
                "| Quality of boat | Max number of passengers |  Cost of boat  |");
        for (Boat i : arrayOfBoats) {
            System.out.printf("|%s|%s|%s|%s|%s|\n",
                    centerString(16, i.name),
                    centerString(21, Boolean.toString(i.isRowing)),
                    centerString(17, Character.toString(i.quality)),
                    centerString(26, Integer.toString(i.maxNumberOfPassengers)),
                    centerString(16, Integer.toString(i.cost)));
        }
    }
    public static String centerString (int width, String s) {
        return String.format("%-" + width  + "s",
               String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }
}

