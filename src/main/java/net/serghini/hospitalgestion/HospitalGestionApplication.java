package net.serghini.hospitalgestion;

import net.serghini.hospitalgestion.entities.Doctor;
import net.serghini.hospitalgestion.entities.Patient;
import net.serghini.hospitalgestion.repository.DoctorRepository;
import net.serghini.hospitalgestion.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HospitalGestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalGestionApplication.class, args);
    }


    @Bean
    public CommandLineRunner start(PatientRepository  patientRepository , DoctorRepository doctorRepository) {
        return args -> {
            //@NoArgsCounstructor
            Patient p1 = new Patient();
            p1.setNom("Serghini");
            p1.setPrenom("Akram");
            p1.setScore(100);
            p1.setMalade(false);
            p1.setDateNaissance(new Date());



            //AllArgsCounstructor
            Patient p2 = new Patient(null,"BenAllal","Tarek",new Date(),1200,true);



            //builder
            Patient p3=Patient.builder()
                    .nom("Laagual")
                    .prenom("Amin")
                    .malade(false)
                    .dateNaissance(new Date())
                    .score(500)
                    .build();
            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);



            //Doctors

            Doctor d1= Doctor.builder().nom("Oussefar")
                    .prenom("Othman")
                    .specialite("General")
                    .build();

            Doctor d2= Doctor.builder().nom("Hanine")
                    .prenom("Ayoub")
                    .specialite("dentiste")
                    .build();

            Doctor d3= Doctor.builder().nom("Bouamara")
                    .prenom("Amine")
                    .specialite("General")
                    .build();


            doctorRepository.save(d1);
            doctorRepository.save(d2);
            doctorRepository.save(d3);






            List<Patient> patients = patientRepository.findAll();
            patients.forEach(p -> System.out.println(p.toString()));

            List<Doctor> doctors = doctorRepository.findAll();
            doctors.forEach(d -> System.out.println(d.toString()));



        };

    }

}
