package net.serghini.hospitalgestion.repository;

import net.serghini.hospitalgestion.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {
Page<Patient> findByNomContainsIgnoreCase(String keyword , Pageable pageable);
}
