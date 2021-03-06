package ro.pub.lmn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pub.lmn.entity.User;
import ro.pub.lmn.entity.UserDetails;
import ro.pub.lmn.entity.dto.UserDTO;
import ro.pub.lmn.repository.UserDetailsRepository;
import ro.pub.lmn.repository.UserRepository;

import java.util.List;

/**
 * Created by radug on 6/19/2017.
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserDetailsRepository userDetailsRepository;
    private final EntityToDTOAndLanguageService entityToDTOAndLanguageService;
    private final EmailService emailService;
    @Autowired
    public UserService(UserRepository userRepository, RoleService roleService, UserDetailsRepository userDetailsRepository, EntityToDTOAndLanguageService entityToDTOAndLanguageService, EmailService emailService){
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.userDetailsRepository = userDetailsRepository;
        this.entityToDTOAndLanguageService = entityToDTOAndLanguageService;
        this.emailService = emailService;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        emailService.sendSimpleMessage(user.getEmail(), "LMN New Account", "New user account created for " + user.getEmail());
        user.setRole(roleService.findByRoleName("ROLE_USER"));
        userRepository.save(user);
    }

    public void saveAsAdmin(User user){
        emailService.sendSimpleMessage(user.getEmail(), "LMN New Account [ADMIN]", "New user account created for " + user.getEmail());
        userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {return userRepository.findOne(id);}

    public void updateUser(UserDTO userDTO) {

        User user = userRepository.findOne(userDTO.getId());
        entityToDTOAndLanguageService.DTOToEntity(userDTO, user);
        UserDetails userDetails = user.getUserDetails();
        entityToDTOAndLanguageService.DTOToEntity(userDTO, userDetails);
        userRepository.save(user);
        userDetailsRepository.save(userDetails);
    }
}
