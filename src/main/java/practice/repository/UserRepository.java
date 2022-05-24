package practice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import practice.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
