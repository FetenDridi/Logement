package webservices;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloRessources {


    @GET
    @Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response.status(200).entity("Hello World").build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHelloTo(@PathParam (value="name")String name){
        return Response.status(200).entity("Hello "+name+" !").build();
    }



}
