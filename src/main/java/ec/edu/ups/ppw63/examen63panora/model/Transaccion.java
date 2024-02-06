package ec.edu.ups.ppw63.examen63panora.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Transaccion {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String fecha;
	private Double valor;
	private String telefono;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Transaccion [codigo=" + codigo + ", fecha=" + fecha + ", valor=" + valor + ", telefono=" + telefono
				+ "]";
	}

	

}
