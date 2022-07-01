package ar.edu.unlam.pb2.parcial;

public class EmpleadoTemporal extends Empleado {

	public EmpleadoTemporal() {
		super();
	}

	public EmpleadoTemporal(Integer horas, Boolean casado, Integer hijos) {
		super(horas, casado, hijos);
	}

	public void liquidarSueldo() {
		this.sueldo = this.horasTrabajadas * 200.0 + this.hijos * 200.0;

		if (this.casado)
			this.sueldo += 100;
	}

}
