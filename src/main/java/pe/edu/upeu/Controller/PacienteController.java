package pe.edu.upeu.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.Model.Paciente;
import pe.edu.upeu.Services.PacienteService;

	@RestController
	@RequestMapping("/api")
	public class PacienteController {
		@Autowired
		private PacienteService paciente;
		
		@PostMapping("/pacientes")
		public ResponseEntity<Paciente> save(@RequestBody Paciente pac){
			try {
				Paciente pc = paciente.create(new Paciente(pac.getIdpaciente(), pac.getDni(), pac.getNombres(), pac.getApellidos(), pac.getDireccion(), pac.getTelefono()));
				return new ResponseEntity<>(pc, HttpStatus.CREATED);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/paciente")
		public ResponseEntity<List<Paciente>> getAlumnos(){
			try {
				List<Paciente> list = new ArrayList<>();
				list = paciente.readAll();
				if(list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list, HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		@GetMapping("/paciente/{id}")
		public ResponseEntity<Paciente> getUser(@PathVariable("id") long id){
			Paciente pacientes = paciente.read(id);
				if(pacientes.getIdpaciente()>0) {
					return new ResponseEntity<>(pacientes, HttpStatus.OK);
				}else {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				} 
		}
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
			try {
				paciente.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@PutMapping("/paciente/update/{id}")
		public ResponseEntity<Paciente> update(@RequestBody Paciente pacient, @PathVariable("id") long id){
			try {
				Paciente p = paciente.read(id);
				if(p.getIdpaciente()>0) {
					p.setDni(pacient.getDni());
					p.setNombres(pacient.getNombres());
					p.setApellidos(pacient.getApellidos());
					p.setDireccion(pacient.getDireccion());
					p.setTelefono(pacient.getTelefono());
					return new ResponseEntity<>(paciente.create(p),HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}			

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
