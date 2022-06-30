package resource;

import Dao.PersonDao;
import model.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@RequestScoped
@Path("persons")
public class PersonResource {

    @Inject
    private PersonDao personDao;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPerson() {
        return Arrays.asList(new Person("andremlg","andre@livramento.com"));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addPerson(Person person) {
        personDao.createPerson(person);
        String respMessage = "Person #" + person.getId() + " created successfully.";
        return Response.status(Response.Status.CREATED).entity(respMessage).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Person getPerson(@PathParam("id") int id) {
        Person person = personDao.readPerson(id);
        return person;
    }

}
