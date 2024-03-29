package web.service;
import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService{

    @Override
    public List<Car> getCountCars(List<Car> cars, int count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
