package ro.pub.lmn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pub.lmn.entity.Role;
import ro.pub.lmn.repository.RoleRepository;

/**
 * Created by radug on 6/19/2017.
 */
@Service
public class RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }

    public Role findByRoleName(String roleName){
        return  roleRepository.findByRoleName(roleName);
    }
}
