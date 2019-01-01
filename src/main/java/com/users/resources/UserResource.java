package com.users.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import javax.ws.rs.QueryParam;
import javax.validation.constraints.Null;



@Path("/users")
public class UserResource {

    ArrayList<User> usersDataBase = new ArrayList<User>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsers() {
        int i;
        List<User> allUsers = new ArrayList<User>();
        for (i = 0; i < usersDataBase.size(); i++) {
            allUsers.add(usersDataBase.get(i));
        }
        return allUsers;
        // return usersDataBase;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") String userId) {
        User user=null;
        for (int i = 0; i < usersDataBase.size(); i++)
        {if (usersDataBase.get(i).getId()==Integer.parseInt(userId))
            return usersDataBase.get(i);
        }
        return user;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User user) {
        usersDataBase.add(user);
        return Response.status(Response.Status.CREATED).entity(user.getId()).build();
    }

    @DELETE
    @Path("/{id}")
    public void deleteUserById(@PathParam("id") String userId) {
        for (int i = usersDataBase.size()-1; i >=0; i--)
        {if (usersDataBase.get(i).getId() == Integer.parseInt(userId))
                usersDataBase.remove(i);
        }
    }
}
