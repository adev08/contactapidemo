package learn.springboot.contactapi.repo;

import org.springframework.stereotype.Repository;
import learn.springboot.contactapi.domain.Contact;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;;;

@Repository
public interface ContactRepo extends JpaRepository<Contact, String>{
    Optional<Contact> findById(String id);
}
