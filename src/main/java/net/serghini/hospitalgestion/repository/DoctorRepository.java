package net.serghini.hospitalgestion.repository;

import net.serghini.hospitalgestion.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Page<Doctor> findByNomContainsIgnoreCase(String firstName, Pageable pageable);


}
