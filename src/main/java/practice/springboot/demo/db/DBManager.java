package practice.springboot.demo.db;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Cars> cars;

    static {
        cars.add(new Cars(1L,"Honda", "H1", 220));
        cars.add(new Cars(2L,"Mazda", "M1", 230));
        cars.add(new Cars(3L,"Mercedes", "M12", 280));
        cars.add(new Cars(4L,"Tayota", "T3", 260));
    }

    public static ArrayList<Cars> getAllCars(){
        return cars;
    }
}
