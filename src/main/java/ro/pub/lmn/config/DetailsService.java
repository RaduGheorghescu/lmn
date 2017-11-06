package ro.pub.lmn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ro.pub.lmn.entity.User;
import ro.pub.lmn.service.UserService;


/**
 * Created by Radu on 4/21/2017.
 */
@Component
public class DetailsService implements UserDetailsService {
    private final UserService userService;
    @Autowired
    public DetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(email + " was not found!");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole().getRoleName())
        );
    }
}
