package ar.edu.unlam.pb2.parcial;

import java.util.ArrayList;

public class Empresa {
	private Integer cuit;
	private String razon;
	private ArrayList<Empleado> empleados;
	private Double gastoEnPersonal;

	public Empresa(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
		this.cuit = 123456;
		this.razon = "Fines de Lucro";
		this.gastoEnPersonal = 0.0;
	}
	
	public void calcularGasto() {
		for(Empleado empleado : empleados) {
			empleado.liquidarSueldo();
			gastoEnPersonal += empleado.getSueldo();
		}
	}
	
	public Double getGasto() {
		return this.gastoEnPersonal;
	}
	
}
