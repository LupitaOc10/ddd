package sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataVehiculoTest {
	@Test
	void testInsertar() {
		NegocioVehiculo np=new NegocioVehiculo();
		np.setVehiculoId("6");
		np.setMarca("a");
		np.setModelo("a");
		np.setAño("a");
		np.setColor("a");
		np.setTipo("a");
		
		assertEquals(np.Insertar(), true);
	}
	void testCargarProveedor() {
		NegocioVehiculo np=new NegocioVehiculo();
		np.setVehiculoId("3");
		assertEquals(np.Cargar(), true);
		}
	
	@Test
	void testActualizar() {
		NegocioVehiculo np=new NegocioVehiculo();
		np.setVehiculoId("7");
		np.setMarca("a");
		np.setModelo("a");
		np.setAño("a");
		np.setColor("a");
		np.setTipo("a");
	assertEquals(np.Actualizar(), true);
	}
}