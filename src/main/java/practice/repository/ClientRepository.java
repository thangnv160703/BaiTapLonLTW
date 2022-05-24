package practice.repository;

import org.springframework.data.repository.CrudRepository;

import practice.model.Client;

public interface ClientRepository extends CrudRepository<Client, Long>{

}
