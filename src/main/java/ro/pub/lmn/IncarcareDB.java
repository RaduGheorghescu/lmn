package ro.pub.lmn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ro.pub.lmn.entity.Role;
import ro.pub.lmn.entity.User;
import ro.pub.lmn.service.RoleService;
import ro.pub.lmn.service.UserService;


/**
 * Created by Radu on 4/21/2017.
 */
@Component
public class IncarcareDB implements ApplicationRunner {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public IncarcareDB(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Role role = roleService.findByRoleName("ROLE_ADMIN");
        if(role == null){
            roleService.addRole(new Role("ROLE_ADMIN"));
        }
        role = roleService.findByRoleName("ROLE_USER");
        if(role == null){
            roleService.addRole(new Role("ROLE_USER"));
        }
        User user = userService.findByEmail("radu.gheorghescu@eestec.ro");
        if (user == null){
            user = new User("radu.gheorghescu@eestec.ro","radueadmin",
                    "Radu","Gheorghescu", roleService.findByRoleName("ROLE_ADMIN"));
            user.setId((long) 1);
            userService.saveAsAdmin(user);
        }
    }
}
