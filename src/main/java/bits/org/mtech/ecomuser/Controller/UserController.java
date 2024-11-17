package bits.org.mtech.ecomuser.Controller;

import bits.org.mtech.ecomuser.Model.Order;
import bits.org.mtech.ecomuser.Model.User;
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
  public List<User> getUsers()
  {
    return userService.fetchUserList();
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
  public String deleteDepartmentById(@PathVariable("id") Long userId)
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
      Optional<User> user = userService.getUserById(userId);
      if (user.isPresent()) {
        user.get().setOrders(orders);
      }
    } catch (Exception e) {
      System.out.println("could not get user's orders " + e.getMessage());
    }
    return orders;
  }

}
