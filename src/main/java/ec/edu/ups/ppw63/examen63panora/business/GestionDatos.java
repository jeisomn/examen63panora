package ec.edu.ups.ppw63.examen63panora.business;

import ec.edu.ups.ppw63.examen63panora.dao.RecargaDAO;
import ec.edu.ups.ppw63.examen63panora.model.DetalleRecarga;
import ec.edu.ups.ppw63.examen63panora.model.Recarga;
import ec.edu.ups.ppw63.examen63panora.model.Transaccion;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private RecargaDAO daoCuenta;
	
	@Inject
	private GestionRecargas gestionCuentas;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");

		Recarga recarga = new Recarga();
		recarga.setTelefono("0993998499");
		recarga.setOperador("claro");
		recarga.setSaldo(5.00);
		
		daoCuenta.insert(recarga); 
		
		System.out.println(recarga);
//		
		Transaccion transaccion = new Transaccion();
		transaccion.setTelefono(recarga.getTelefono());  
		transaccion.setValor(15.00);;
		transaccion.setFecha("12/12/2023");
		
		gestionCuentas.Transaccion(transaccion);
		
		DetalleRecarga det1 = new DetalleRecarga();
		det1.setMonto(transaccion.getValor());
		det1.setSaldo(recarga.getSaldo());
		det1.setFecha("05/02/2024");
		
		recarga.addDetalle(det1);
		
		System.out.println("Cuenta con su detalle "+recarga);


	}
}