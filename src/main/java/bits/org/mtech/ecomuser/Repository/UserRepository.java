package bits.org.mtech.ecomuser.Repository;

import bits.org.mtech.ecomuser.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {
}


