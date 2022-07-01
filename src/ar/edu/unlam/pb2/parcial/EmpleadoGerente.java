package ar.edu.unlam.pb2.parcial;

public class EmpleadoGerente extends EmpleadoPermanente {

	public EmpleadoGerente() {
		super();
	}

	public EmpleadoGerente(Integer horas, Boolean casado, Integer hijos, Integer antiguedad) {
		super(horas, casado, hijos, antiguedad);
	}

	public void liquidarSueldo() {
		this.sueldo = this.horasTrabajadas * 400.0 + this.hijos * 200.0 + this.antiguedad * 150.0;

		if (this.casado)
			this.sueldo += 100;
	}
}
