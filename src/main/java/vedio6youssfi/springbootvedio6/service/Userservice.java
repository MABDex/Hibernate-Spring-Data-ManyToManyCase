package vedio6youssfi.springbootvedio6.service;

import vedio6youssfi.springbootvedio6.entities.Role;
import vedio6youssfi.springbootvedio6.entities.User;

public interface Userservice {


    User addNewUser(User user);
    Role addNewRole(Role role);

    User findUserByUsername(String username);
    Role findRoleByUsername(String username);

    void addRoleToUser(String username, String rolename);



}
