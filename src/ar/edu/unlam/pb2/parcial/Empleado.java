package ar.edu.unlam.pb2.parcial;

public abstract class Empleado {

	protected Double sueldo;
	protected Integer horasTrabajadas;
	protected Boolean casado;
	protected Integer hijos;

	public Empleado() {
		this.sueldo = 0.0;
		this.horasTrabajadas = 0;
		this.casado = false;
		this.hijos = 0;
	}

	public Empleado(Integer horas, Boolean casado, Integer hijos) {
		this.sueldo = 0.0;
		this.horasTrabajadas = horas;
		this.casado = casado;
		this.hijos = hijos;
	}

	public Integer getHoras() {
		return this.horasTrabajadas;
	}

	public Integer getHijos() {
		return this.hijos;
	}

	public Boolean getCasado() {
		return this.casado;
	}

	public Double getSueldo() {
		return this.sueldo;
	}
	
	abstract void liquidarSueldo();

}
