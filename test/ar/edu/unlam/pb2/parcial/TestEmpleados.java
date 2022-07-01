package ar.edu.unlam.pb2.parcial;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;

public class TestEmpleados {
	
	private static final Double MONTO_TEMP = 80 * 200.0 + 100.0;
	private static final Double MONTO_PER1 = 80 * 300.0 + 100.0 + 2 * 200.0 + 6 * 100.0;
	private static final Double MONTO_PER2 = 160 * 300.0 + 100.0 + 0 * 200.0 + 4 * 100.0;
	private static final Double MONTO_GEN = 160 * 400.0 + 100.0 + 1 * 200.0 + 10 * 150.0;
	
	private static final Double MONTO_TOTAL = MONTO_TEMP + MONTO_PER1 + MONTO_PER2 + MONTO_GEN;

	@Test
	public void empleadoTemporal_80Hs_Esposa_SinHijos() {
		EmpleadoTemporal empleado = dadoQueExisteEmpleadoTemporal(80, true, 0);
		cuandoSeLiqudaSuSueldo(empleado);
		elSueldoDeberiaPagarse(empleado);
	}

	@Test
	public void empleadoPermanente_NoGerente_80Hs_Esposa_2Hijos_6Antiguedad() {
		EmpleadoPermanente empleado = dadoQueExisteUnEmpleadoPermanente(80, true, 2, 6);
		cuandoSeLiqudaSuSueldo(empleado);
		elSueldoDeberiaPagarse(empleado);
	}

	@Test
	public void empleadoPermanente_NoGerente_160Hs_Esposa_SinHijos_4Antiguedad() {
		EmpleadoPermanente empleado = dadoQueExisteUnEmpleadoPermanente(160, true, 0, 4);
		cuandoSeLiqudaSuSueldo(empleado);
		elSueldoDeberiaPagarse_empleado2(empleado);
	}

	@Test
	public void gerente_160Hs_Esposa_1Hijo_10Antiguedad() {
		EmpleadoGerente empleado = dadoQueExisteUnEmpleadoGerente(160, true, 1, 10);
		cuandoSeLiqudaSuSueldo(empleado);
		elSueldoDelGerenteDeberiaPagarse(empleado);
	}

	@Test
	public void empresa() {

		EmpleadoTemporal empleadoT = dadoQueExisteEmpleadoTemporal(80, true, 0);
		EmpleadoPermanente empleadoP1 = dadoQueExisteUnEmpleadoPermanente(80, true, 2, 6);
		EmpleadoPermanente empleadoP2 = dadoQueExisteUnEmpleadoPermanente(160, true, 0, 4);
		EmpleadoGerente empleadoGer = dadoQueExisteUnEmpleadoGerente(160, true, 1, 10);

		Empresa empresa = dadoQueLaEmpresaTieneEmpleados(empleadoT, empleadoP1, empleadoP2, empleadoGer);
		
		cuandoLiquidoTodosLosSueldos(empresa);
		
		laEmpresaDeberiaPagar(empresa);

	}

	private void laEmpresaDeberiaPagar(Empresa empresa) {
		Assert.assertEquals(empresa.getGasto(), MONTO_TOTAL);
		
	}

	private void cuandoLiquidoTodosLosSueldos(Empresa empresa) {
		empresa.calcularGasto();
	}

	private Empresa dadoQueLaEmpresaTieneEmpleados(EmpleadoTemporal empleadoT, EmpleadoPermanente empleadoP1,
			EmpleadoPermanente empleadoP2, EmpleadoGerente empleadoGer) {
		ArrayList<Empleado> empleados = new ArrayList<>();
		
		empleados.add(empleadoT);
		empleados.add(empleadoP1);
		empleados.add(empleadoP2);
		empleados.add(empleadoGer);

		return new Empresa(empleados);
	}

	private void elSueldoDelGerenteDeberiaPagarse(EmpleadoGerente empleado) {
		Assert.assertEquals(empleado.getSueldo(), (Double) (160 * 400.0 + 100.0 + 1 * 200.0 + 10 * 150.0));
	}

	private EmpleadoGerente dadoQueExisteUnEmpleadoGerente(Integer horas, Boolean casado, Integer hijos,
			Integer antiguedad) {
		return new EmpleadoGerente(horas, casado, hijos, antiguedad);
	}

	private void elSueldoDeberiaPagarse_empleado2(EmpleadoPermanente empleado) {
		Assert.assertEquals(empleado.getSueldo(), (Double) (160 * 300.0 + 100.0 + 0 * 200.0 + 4 * 100.0));
	}

	private void elSueldoDeberiaPagarse(EmpleadoPermanente empleado) {
		Assert.assertEquals(empleado.getSueldo(), (Double) (80 * 300.0 + 100.0 + 2 * 200.0 + 6 * 100.0));
	}

	private void cuandoSeLiqudaSuSueldo(EmpleadoPermanente empleado) {
		empleado.liquidarSueldo();
	}

	private EmpleadoPermanente dadoQueExisteUnEmpleadoPermanente(Integer horas, Boolean casado, Integer hijos,
			Integer antiguedad) {
		return new EmpleadoPermanente(horas, casado, hijos, antiguedad);
	}

	private void elSueldoDeberiaPagarse(EmpleadoTemporal empleado) {
		Assert.assertEquals(empleado.getSueldo(), (Double) (80.0 * 200.0 + 100.0));
	}

	private void cuandoSeLiqudaSuSueldo(EmpleadoTemporal empleado) {
		empleado.liquidarSueldo();
	}

	private EmpleadoTemporal dadoQueExisteEmpleadoTemporal(Integer horas, Boolean casado, Integer hijos) {
		return new EmpleadoTemporal(horas, casado, hijos);
	}
}
