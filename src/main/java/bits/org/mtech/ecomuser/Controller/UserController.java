package bits.org.mtech.ecomuser.Controller;

import bits.org.mtech.ecomuser.Model.Order;
import bits.org.mtech.ecomuser.Model.User;
import bits.org.mtech.ecomuser.Model.UserData;
import bits.org.mtech.ecomuser.Service.UserService;
import bits.org.mtech.ecomuser.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotation
@RestController

// Class
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private OrderClient orderClient;

  // Save operation
  @PostMapping("/users/create")
  public User createUser(
          @RequestParam String name,
          @RequestParam String address,
          @RequestParam String phoneNumber)
  {
    return userService.createUser(name, address, phoneNumber);
  }

  // Read operation
  @GetMapping("/users")
  public List<UserData> getUsers()
  {
    return userService.getAllUserData();
  }

  // Update operation
  @PutMapping("/users/{id}")
  public User updateUser(@RequestBody User user,
                   @PathVariable("id") Long userId)
  {
    return userService.updateUser(user, userId);
  }

  // Delete operation
  @DeleteMapping("/users/{id}")
  public String deleteUserById(@PathVariable("id") Long userId)
  {
    userService.deleteUserById(userId);
    return "Deleted Successfully";
  }

  // Read operation
  @GetMapping("/users/{id}/orders")
  public List<Order> getOrdersForUser(@PathVariable("id") Long userId)
  {
    List<Order> orders = null;
    try {
      orders = orderClient.getOrdersByUser(userId);
    } catch (Exception e) {
      System.out.println("could not get user's orders " + e.getMessage());
    }
    return orders;
  }

}
