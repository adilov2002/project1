package practice.springboot.demo.db;

import java.util.ArrayList;

public class DBManager {    

    private static ArrayList<Cars> cars = new ArrayList<>();

    static {
        cars.add(new Cars(1L,"Honda", "H1", 220));
        cars.add(new Cars(2L,"Mazda", "M1", 230));
        cars.add(new Cars(3L,"Mercedes", "M12", 280));
        cars.add(new Cars(4L,"Tayota", "T3", 260));
    }

    private static Long id = 5L;
    public static ArrayList<Cars> getAllCars(){
        return cars;
    }

    public static void addCar(Cars car){
        car.setId(id);
        cars.add(car);
        id++;
    }

    public static Cars getCar(Long id){
        for(Cars c : cars){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }


}
