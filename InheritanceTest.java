package edu.utvt.springdata;

import edu.utvt.springdata.data.entities.Alumno;
import edu.utvt.springdata.data.entities.Administrativo;
import edu.utvt.springdata.data.repositories.AlumnoRepository;
import edu.utvt.springdata.data.repositories.AdministrativoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest

public class InheritanceTest {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private AdministrativoRepository administrativoRepository;

    @Test
    void testGuardarAlumno() {
        Alumno alumno = new Alumno();
        alumno.setNombre("Ana Karen");
        alumno.setApellido("Alvarez");
        alumno.setEmail("al222210983@gmail.com");
        alumno.setFechaNacimiento(new Date());

        alumnoRepository.save(alumno);
    }

    @Test
    void testGuardarAdministrativo() {
        Administrativo admin = new Administrativo();
        admin.setNombre("Ana Karen ");
        admin.setApellido("Alvarez");
        admin.setEmail("anacoahuila@gmail.com");
        admin.setFechaNacimiento(new Date());
        admin.setSalario(50000.0);

        administrativoRepository.save(admin);
    }
}

