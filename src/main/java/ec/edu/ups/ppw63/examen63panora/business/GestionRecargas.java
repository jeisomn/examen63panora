package ec.edu.ups.ppw63.examen63panora.business;

import java.util.List;
import ec.edu.ups.ppw63.examen63panora.dao.RecargaDAO;
import ec.edu.ups.ppw63.examen63panora.model.DetalleRecarga;
import ec.edu.ups.ppw63.examen63panora.model.Recarga;
import ec.edu.ups.ppw63.examen63panora.model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {

	@Inject
	private RecargaDAO daoRecarga;

	public void guardarCuentas(Recarga recarga) {
		Recarga cue = daoRecarga.read(recarga.getCodigo());
		if (cue != null) {
			daoRecarga.update(recarga);
		} else {
			daoRecarga.insert(recarga);
		}
	}

	public void actualizarCuentas(Recarga recarga) throws Exception {
		Recarga cue = daoRecarga.read(recarga.getCodigo());
		if (cue != null) {
			daoRecarga.update(recarga);
		} else {
			throw new Exception("Cuenta no existe");
		}
	}

	public void eliminarRecargas(int codigo) {
		daoRecarga.remove(codigo);
	}
	
	public List<Recarga> getRecargas() {
		return daoRecarga.getAll();
	}

	public List<DetalleRecarga> getDetalles() {
		return daoRecarga.getDetalles();
	}

	public Recarga getRecargaPorNumero(String telefono) {
		return daoRecarga.getRecargaPorNuemro(telefono);
	}

	public void agregarDetallesTransaccion(Recarga recarga, Transaccion transaccion) {
		DetalleRecarga detalleecarga = new DetalleRecarga();
		detalleecarga.setMonto(-transaccion.getValor()); // Monto negativo para la cuenta origen
		detalleecarga.setSaldo(recarga.getSaldo());
		detalleecarga.setFecha(transaccion.getFecha());

		recarga.addDetalle(detalleecarga);

		daoRecarga.update(recarga);
	}

//	
	public void Transaccion(Transaccion transaccion) {
		try {

			if (!validarNumeroTelefono(transaccion.getTelefono())) {
				throw new IllegalArgumentException("El número de teléfono no es válido");
			}

			Recarga recarga = getRecargaPorNumero(transaccion.getTelefono());

			System.out.println("Antes de realizar la recarga " + recarga);


			if (recarga != null ) {

				if (transaccion.getValor() >= 0) {

					double monto = transaccion.getValor();

					recarga.setSaldo(recarga.getSaldo() + monto);	

					daoRecarga.update(recarga);

					
					System.out.println("Despues de realizar la recarga " + recarga);
					
				}else {
					System.out.println("Error: Valor de recarga incorrecto");
				}
			}else {
				System.out.println("Error: No existe una recarga asociada");
			}

		} catch (Exception e) {
			System.out.println("Error al realizar la transacción: " + e.getMessage());
		}

	}

	private boolean validarNumeroTelefono(String numero) {
		return numero != null && numero.trim().length() == 10; // Validación sencilla de longitud de 10 dígitos
	}
}