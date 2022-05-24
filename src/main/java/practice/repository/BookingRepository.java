package practice.repository;

import org.springframework.data.repository.CrudRepository;

import practice.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{

}
