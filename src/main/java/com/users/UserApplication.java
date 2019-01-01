package com.users;
import com.users.resources.*;
import com.users.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;

public class UserApplication extends Application<Configuration> {

    public static void main(final String[] args) throws Exception {
        new UserApplication().run(args);
    }

    @Override
    public void run(final Configuration configuration,
                    final Environment environment) {
        JerseyEnvironment jersey = environment.jersey();
        jersey.register(new UserResource());

    }

}
