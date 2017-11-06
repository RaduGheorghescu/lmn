package ro.pub.lmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.pub.lmn.entity.User;

/**
 * Created by radug on 6/19/2017.
 */
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
