package ec.edu.ups.ppw63.demo63.services;

import java.util.List;
import ec.edu.ups.ppw63.examen63panora.business.GestionRecargas;
import ec.edu.ups.ppw63.examen63panora.model.DetalleRecarga;
import ec.edu.ups.ppw63.examen63panora.model.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recarga")
public class RecargasService {

	@Inject
	private GestionRecargas gRecargas;
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recarga recarga) {
		try {
			System.out.println("FACT"+recarga);
			gRecargas.guardarCuentas(recarga);
			System.out.println("FACT"+recarga);
		return Response.ok(recarga).build();
		
		}catch (Exception e) {
			ErrorMassage error = new ErrorMassage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try {
			gRecargas.eliminarRecargas(codigo);;
			return "OK";
			}catch (Exception e) {
				return "Error";
			}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getRecargas(){
		List<Recarga> Recargas = gRecargas.getRecargas();
		System.out.println("Recargas listado: " + Recargas);
		if(Recargas.size()>0)
			return Response.ok(Recargas).build();
		
		ErrorMassage error = new ErrorMassage(6, "No se registran Recargas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("lista")
	public Response getDetalles(){
		List<DetalleRecarga> detalles = gRecargas.getDetalles();
		System.out.println("Detalles de las recargas " + detalles);
		if(detalles.size()>0)
			return Response.ok(detalles).build();
		
		ErrorMassage error = new ErrorMassage(6, "No se registran detalles");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	
	
}


