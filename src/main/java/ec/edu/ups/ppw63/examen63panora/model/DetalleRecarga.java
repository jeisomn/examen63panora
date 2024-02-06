package ec.edu.ups.ppw63.examen63panora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DetalleRecarga {
    @Id
    @GeneratedValue
    private int codigo;
    private Double valor;
    private Double saldo;
    private String fecha;

    public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Double getMonto() {
		return valor;
	}

	public void setMonto(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "DetalleCuenta [codigo=" + codigo +  ", valor=" + valor + ", saldo=" + saldo
				+ ", fecha=" + fecha + "]";
	}


}