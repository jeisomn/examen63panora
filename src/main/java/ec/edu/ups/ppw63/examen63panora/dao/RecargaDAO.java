package ec.edu.ups.ppw63.examen63panora.dao;

import java.util.List;

import ec.edu.ups.ppw63.examen63panora.model.DetalleRecarga;
import ec.edu.ups.ppw63.examen63panora.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {

	@PersistenceContext
	private EntityManager em;

	public void insert(Recarga cuenta) {
		em.persist(cuenta);
		// Tiene el imput de la sentencia
	}

	public void update(Recarga cuenta) {
		em.merge(cuenta);
	}

	public void remove(int codigo) {
		Recarga cuenta = em.find(Recarga.class, codigo);
		// Se utiliza para buscar por la clave primaria
		em.remove(cuenta);
	}

	public Recarga read(int codigo) {
		Recarga cuenta = em.find(Recarga.class, codigo);
		return cuenta;
	}

	public List<Recarga> getAll() {
		String jpql = "SELECT r FROM Recarga r";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
	
	public List<DetalleRecarga> getDetalles() {
		String jpql = "SELECT d FROM DetalleRecarga d";
		Query q = em.createQuery(jpql, DetalleRecarga.class);
		return q.getResultList();
	}
	
	public void addDetalles(List<DetalleRecarga> detalles) {
		for(DetalleRecarga detalleCuenta : detalles) {
			em.persist(detalleCuenta);
		}
	}
	
	public Recarga getRecargaPorNuemro(String telefono) {
		try {
			String sql = "SELECT r FROM Recarga r WHERE r.telefono = :telefono";
			Query q = em.createQuery(sql, Recarga.class);
			q.setParameter("telefono", telefono);
			return (Recarga) q.getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
			return  null;
		}
	}
}
