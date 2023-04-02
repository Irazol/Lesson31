package Interface;

import java.util.List;
import Class.Car;

public interface CarDAO {

    void add(Car car);

    List<Car> getAll();

    Car getById(int id);

    void updatePrice(int price, int carId);

    void remove(String mark);

}
