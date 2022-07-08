package hiber;

import hiber.config.AppConfig;
import hiber.dao.CarDaolmp;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.CarServicelmp;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru", new Car("Porsche", 911)));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru", new Car("AUDI", 100)));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("VAZ", 2107)));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru", new Car("GAZ", 412)));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Model ="+user.getCar().getModel());
         System.out.println("Series ="+user.getCar().getSeries());
         System.out.println();

      }
      System.out.println(userService.getUser("AUDI", 100));
      List<Car> cars = carService.listAllCars();
      for (Car car : cars) {
         System.out.println("Id = "+car.getId());
         System.out.println("Model = "+car.getModel());
         System.out.println("Series = "+car.getSeries());
         System.out.println();
      }

      context.close();
   }
}
