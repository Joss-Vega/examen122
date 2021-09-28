package pe.edu.upeu.Services;

import java.util.List;

import pe.edu.upeu.Model.Paciente;
public interface SPaciente {
	Paciente create(Paciente pc);
	List<Paciente> readAll();
	Paciente read(Long id);
	void delete(Long id);
	Paciente update(Paciente pc);
}
