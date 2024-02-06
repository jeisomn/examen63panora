package ec.edu.ups.ppw63.demo63.services;

import ec.edu.ups.ppw63.examen63panora.business.GestionRecargas;
import ec.edu.ups.ppw63.examen63panora.model.Transaccion;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class TransaccionService {

	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response transaccion(Transaccion transaccion) {
		try {
			gRecargas.Transaccion(transaccion);
			System.out.println("Transaccion a realizar "+transaccion);
			ErrorMassage error = new ErrorMassage(9999, "ok");
			return Response.status(Response.Status.CREATED).entity(error).build();
		} catch (Exception e) {
			// TODO: handle exception
			ErrorMassage error = new ErrorMassage(9999, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
}
