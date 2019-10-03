package cl.globallogic.ejercicio.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.globallogic.ejercicio.modelo.User;

@Repository
public interface UserRespository extends CrudRepository<User, String>{

	
}
