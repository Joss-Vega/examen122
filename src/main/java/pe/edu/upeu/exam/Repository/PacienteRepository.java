package pe.edu.upeu.exam.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.exam.Model.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>{

}
