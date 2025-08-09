package net.serghini.hospitalgestion.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Doctors")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder


public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;
}
