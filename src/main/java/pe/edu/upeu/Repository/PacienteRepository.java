package pe.edu.upeu.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import pe.edu.upeu.Model.Paciente;
@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>{

}
