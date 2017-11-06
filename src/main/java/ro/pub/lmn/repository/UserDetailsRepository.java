package ro.pub.lmn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.pub.lmn.entity.UserDetails;

/**
 * Created by radug on 11/1/2017.
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails,Long>{
}
