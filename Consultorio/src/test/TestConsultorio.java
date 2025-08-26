package test;

import consultorio.Medico;
import consultorio.Paciente;

public class TestConsultorio {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Paciente paciente1 = new Paciente("Jose", "Perez", 1.80f, 85);
		Paciente paciente2 = new Paciente("Jorge", "Fern�ndez", 1.60f, 90);

		System.out.println("Pacientes:");
		System.out.println(paciente1.traerNombreCompleto());
		System.out.println(paciente2.traerNombreCompleto());
		
		Medico medico1 = new Medico("Jorge", "Lanata", "Dentista");

		
		System.out.println(medico1.calcularIMC(paciente1));
		System.out.println(medico1.calcularIMC(paciente2));
	}
}
