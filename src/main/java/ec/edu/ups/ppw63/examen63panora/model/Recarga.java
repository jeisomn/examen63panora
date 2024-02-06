package ec.edu.ups.ppw63.examen63panora.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Recarga {

	@Id
	@GeneratedValue
	private int codigo;
	private String telefono;
	private String operador;
	private double saldo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DetalleRecarga> detalles;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<DetalleRecarga> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleRecarga> detalles) {
		this.detalles = detalles;
	}

	public void addDetalle(DetalleRecarga detalle) {
		if(detalles==null)
			detalles = new ArrayList<DetalleRecarga>();
		detalles.add(detalle);
	}
	
	@Override
	public String toString() {
		return "Recarga [codigo=" + codigo + ", telefono=" + telefono + ", operador=" + operador + ", saldo=" + saldo
				+ ", detalles=" + detalles + "]";
	}
	

	
}
