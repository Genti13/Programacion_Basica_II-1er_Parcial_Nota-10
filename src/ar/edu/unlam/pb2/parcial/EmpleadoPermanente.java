package ar.edu.unlam.pb2.parcial;

public class EmpleadoPermanente extends Empleado {

	protected Integer antiguedad;

	public EmpleadoPermanente() {
		super();
	}

	public EmpleadoPermanente(Integer horas, Boolean casado, Integer hijos, Integer antiguedad) {
		super(horas, casado, hijos);
		this.antiguedad = antiguedad;
	}

	public void liquidarSueldo() {
		this.sueldo = this.horasTrabajadas * 300.0 + this.hijos * 200.0 + this.antiguedad * 100.0;

		if (this.casado)
			this.sueldo += 100;
	}

}
