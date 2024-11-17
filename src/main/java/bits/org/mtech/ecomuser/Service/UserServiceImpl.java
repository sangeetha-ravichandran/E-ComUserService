package bits.org.mtech.ecomuser.Service;

import bits.org.mtech.ecomuser.Model.User;
import bits.org.mtech.ecomuser.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  UserRepository userRepository;

  @Override
  public User createUser(String name, String address, String phoneNumber) {
    User user = new User(name,address,phoneNumber);
    return userRepository.save(user);
  }

  @Override
  public List<User> fetchUserList() {
    return (List<User>) userRepository.findAll();
  }

  @Override
  public Optional<User> getUserById(Long userId) {
    return userRepository.findById(userId);
  }

  @Override
  public User updateUser(User user, Long userId) {
    User userFromDb = userRepository.findById(userId).get();

    if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
      userFromDb.setUserName(user.getUserName());
    }

    if (Objects.nonNull(user.getUserAddress()) && !"".equalsIgnoreCase(user.getUserAddress())) {
      userFromDb.setUserAddress(user.getUserAddress());
    }

    if (Objects.nonNull(user.getUserPhoneNumber()) && !"".equalsIgnoreCase(user.getUserPhoneNumber())) {
      userFromDb.setUserPhoneNumber(user.getUserPhoneNumber());
    }

    return userRepository.save(userFromDb);
  }

  @Override
  public void deleteUserById(Long userId) {
    userRepository.deleteById(userId);
  }
}
