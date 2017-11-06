package ro.pub.lmn.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.pub.lmn.entity.Role;

/**
 * Created by radug on 6/19/2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
