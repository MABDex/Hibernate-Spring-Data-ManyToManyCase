package vedio6youssfi.springbootvedio6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vedio6youssfi.springbootvedio6.entities.Role;


@Repository //  Indique la couche DAO



public interface Rolerepositori extends JpaRepository <Role, Long> {

  Role findByRolename(String rolename);



}
