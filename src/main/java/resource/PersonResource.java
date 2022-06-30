package resource;

import model.Person;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@RequestScoped
@Path("persons")
public class PersonResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPerson() {
        return Arrays.asList(new Person("andremlg","andre@livramento.com"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        String responseMessage = "Person " + person.getUsername() + " received successfully.";
        return Response.status(Response.Status.CREATED).entity(responseMessage).build();
    }
}
