package vedio6youssfi.springbootvedio6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vedio6youssfi.springbootvedio6.entities.User;

public interface UserRepositori extends JpaRepository<User, String> {

   User findByUsername(String username);

}
