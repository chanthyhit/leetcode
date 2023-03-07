package collection;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Car[] cars = {
                new Car(12343, "Nissan", "2017"),
                new Car(12345, "Toyota", "2020"),
                new Car(12346, "Toyota", "2020"),
                new Car(12344, "BMW", "2019"),
                new Car(12341, "GMC", "2021"),
                new Car(12342, "Tesla", "2018"),
        };

        //linkedList(cars);
        //arrayList(cars);

        //hashSet(cars, cars[0]);
        //linkedHashSet(cars, cars[0]);
        //treeSet(cars, cars[0]);

        //hasMap(cars, cars[0]);
        //linkedHashMap(cars, cars[0]);
        //treeMap(cars, cars[0]);

        mapTest();
    }

    static void mapTest(){
        Map<Integer, String> map = new TreeMap<>();
        map.put(1,"Zebra");
        map.put(3,"Dog");
        map.put(4,"Cat");
        map.put(2,"Cow");
        map.entrySet().stream().sorted((b,a)->a.getValue().compareTo(b.getValue())).forEach(System.out::println);
        //map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).forEach(System.out::println);
    }

    // --- List testing
    static void arrayList(Car[] cars){
        List<Car> carList = new ArrayList<>(Arrays.asList(cars));
        carList.stream().forEach(System.out::println);
    }
    static void linkedList(Car[] cars){
        List<Car> carList = new LinkedList<>(Arrays.asList(cars));
        carList.stream().forEach(System.out::println);
    }

    // --- Set testing
    static void hashSet(Car[] cars, Car car){
        Set<Car> carSet = new HashSet<>(Arrays.asList(cars));
        carSet.add(car); // attempt duplicate record by modified to random hashCode()
        carSet.stream().forEach(System.out::println);
    }
    static void linkedHashSet(Car[] cars, Car car){
        Set<Car> carSet = new LinkedHashSet<>(Arrays.asList(cars));
        carSet.add(car); // attempt duplicate record by modified to random hashCode()
        carSet.stream().forEach(System.out::println);
    }
    static void treeSet(Car[] cars, Car car){
        Comparator<Car> comparator = (a,b)->Integer.compare(b.getVin(),a.getVin());
        Set<Car> carSet = new TreeSet<>(comparator);
        carSet.addAll(Arrays.asList(cars));
        carSet.add(car); // attempt duplicate record by modified to random hashCode()
        carSet.stream().forEach(System.out::println);
    }

    // --- Map testing
    static void hasMap(Car[] cars, Car car){
        Map<Car, Car> carMap = new HashMap<>();
        for(Car c : cars) carMap.put(c,c);
        carMap.put(car, car); // attempt duplicate record by modified to random hashCode()
        carMap.entrySet().stream().forEach(System.out::println);
    }
    static void linkedHashMap(Car[] cars, Car car){
        Map<Integer, Car> carMap = new LinkedHashMap<>();
        for(Car c : cars) carMap.put(c.getVin(),c);
        carMap.put(car.getVin(), car); // attempt duplicate record by modified to random hashCode()
        carMap.entrySet().stream().forEach(System.out::println);
    }
    static void treeMap(Car[] cars, Car car){
        Map<Integer, Car> carMap = new TreeMap<>(Comparator.reverseOrder());
        for(Car c : cars) carMap.put(c.getVin(),c);
        carMap.put(car.getVin(), car); // attempt duplicate record by modified to random hashCode()
        carMap.entrySet().stream().forEach(System.out::println);
    }
}
