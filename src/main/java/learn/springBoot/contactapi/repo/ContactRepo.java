package learn.springBoot.contactapi.repo;

import org.springframework.stereotype.Repository;
import learn.springBoot.contactapi.domain.Contact;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;;;

@Repository
public interface ContactRepo extends JpaRepository<Contact, String>{
    Optional<Contact> findById(String id);
}
