package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("m1", 111)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("m2", 222)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("m3", 333)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("m4", 4444)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println(user.getCar());

         System.out.println();
      }
      System.out.println("user by car : ");
      System.out.println(userService.getUserByModelAndSeries("m1", 111));

      context.close();
   }
}
