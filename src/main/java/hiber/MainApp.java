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

      User user1 = new User("Vasya", "Pupkin", "12r@fif.com");
      User user2 = new User("Joui", "Hugashvili", "grizin@jo.com");
      User user3 = new User("Grisha", "Po", "gr@kazan.com");
      User user4 = new User("Mao", "Dzedun", "kitayoza@chaynik.com");

      Car car1 = new Car("Lada", 01);
      Car car2 = new Car("Kia", 02);
      Car car3 = new Car("BMW", 03);
      Car car4 = new Car("Audi", 04);

      user1.setEmpCar(car1);
      user2.setEmpCar(car2);
      user3.setEmpCar(car3);
      user4.setEmpCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      System.out.println("++++++++++++++++++++++++++++++++++++");
      User us = userService.getByModel("Audi", 4);
         System.out.println("Id = "+us.getId());
         System.out.println("First Name = "+us.getFirstName());
         System.out.println("Last Name = "+us.getLastName());
         System.out.println("Email = "+us.getEmail());


      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getEmpCar());
         System.out.println("1. _____________________________________________");
      }






//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }


      context.close();
   }
}
