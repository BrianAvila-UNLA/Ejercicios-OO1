package consultorio;

public class Medico {
	
	private String nombre;
	private String apellido;
	private String especialidad;
	
	public Medico(String nombre, String apellido, String especialidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
	}
	
	public float calcularIMC (Paciente paciente) {
		float IMC = paciente.getPeso()/(paciente.getEstatura()*paciente.getEstatura());
		
		return IMC;
	}
	
}


