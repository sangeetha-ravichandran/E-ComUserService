package bits.org.mtech.ecomuser.Service;

import bits.org.mtech.ecomuser.Model.User;
import bits.org.mtech.ecomuser.Model.UserData;

import java.util.List;
import java.util.Optional;

public interface UserService {
  // Save operation
  User createUser(String name, String address, String phoneNumber);

  // Read operation
  List<User> fetchUserList();
  Optional<User> getUserById(Long userId);

  List<UserData> getAllUserData();

  // Update operation
  User updateUser(User user, Long userId);

  // Delete operation
  void deleteUserById(Long userId);

}
