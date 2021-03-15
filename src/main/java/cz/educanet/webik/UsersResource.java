package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersManager manager;

    public static List<User> names = new ArrayList<User>();


    @POST
    @Path("register")
    public Response createUser(User user) {
        for (User name : names) {
            if(user.username.equals(name.username))
                return Response.status(400).build();
        }
        names.add(user);
        return Response.ok().build();
    }

    @POST
    @Path("login")
    public Response loginUser(User user) {
        for (User tempuser : names) {
            if (user.username.equals(tempuser.username) && user.password.equals(tempuser.password)) {
                manager.user = user;
                return Response.ok().build();
            }

        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    public Response getLoggedUser() {
        return  Response.ok(names).build();
    }

}
