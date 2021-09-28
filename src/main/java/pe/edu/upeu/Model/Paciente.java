package pe.edu.upeu.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="paciente")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idpaciente;

	@Column(name="Dni")
	private String dni;
	@Column(name="Nombres")
	private String nombres;
	@Column(name="Apellidos")
	private String apellidos;
	@Column(name="Direccion")
	private String direccion;
	@Column(name="Telefono")
	private String telefono;
	
	}
}
