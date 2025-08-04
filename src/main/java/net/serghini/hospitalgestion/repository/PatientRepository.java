package net.serghini.hospitalgestion.repository;

import net.serghini.hospitalgestion.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
