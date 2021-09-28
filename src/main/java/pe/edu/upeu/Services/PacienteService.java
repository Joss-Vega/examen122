package pe.edu.upeu.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.Model.Paciente;
import pe.edu.upeu.Repository.PacienteRepository;

@Service
public class PacienteService implements SPaciente{
	@Autowired
	private PacienteRepository pacienteRepository;

	@Override
	public Paciente create(Paciente pc) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(pc);
	}

	@Override
	public List<Paciente> readAll() {
		// TODO Auto-generated method stub
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente read(Long id) {
		// TODO Auto-generated method stub
		return pacienteRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pacienteRepository.deleteById(id);
	}

	@Override
	public Paciente update(Paciente pc) {
		// TODO Auto-generated method stub
		return pacienteRepository.save(pc);
	}

}
