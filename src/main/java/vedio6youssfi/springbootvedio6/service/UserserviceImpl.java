package vedio6youssfi.springbootvedio6.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vedio6youssfi.springbootvedio6.entities.Role;
import vedio6youssfi.springbootvedio6.entities.User;
import vedio6youssfi.springbootvedio6.repositories.Rolerepositori;
import vedio6youssfi.springbootvedio6.repositories.UserRepositori;

import java.util.UUID;


@Service // indique que ici couche metier
@Transactional // Cela signifie que les transactions sont déléguées à Spring

@AllArgsConstructor   // attention il faut pas faie constructur sans parametre dans couche service

public class UserserviceImpl implements Userservice {



    private UserRepositori userRepositori;
    private Rolerepositori rolerepositori;





    @Override
    public User addNewUser(User user) {
        user.setUserid(UUID.randomUUID().toString());
        // Identiant als (chaine de caracter) kaysawbo system , beaucoup mieux que Incrementation b les numero

        return userRepositori.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return rolerepositori.save(role);
    }

    @Override
    public User findUserByUsername(String username) { // hatl9a method f interface UserRepositori (findByUsername)
        return userRepositori.findByUsername(username);
    }

    @Override
    public Role findRoleByUsername(String username) { // hatl9a method f interface RoleRepositori (findByUsername)
        return rolerepositori.findByRolename(username);
    }


    @Override
    public void addRoleToUser(String username, String rolename) {
        User user = findUserByUsername(username);
        Role role = findRoleByUsername(rolename);

        if (user == null || role == null) {
            throw new RuntimeException("Benutzer oder Rolle nicht gefunden!");
        }

        user.getRoles().add(role);
        role.getUsers().add(user);
    }
}
