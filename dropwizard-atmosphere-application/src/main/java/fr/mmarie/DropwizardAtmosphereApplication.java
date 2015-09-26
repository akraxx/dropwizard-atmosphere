package fr.mmarie;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.atmosphere.cpr.AtmosphereServlet;

/**
 * Created by Maximilien on 26/09/2015.
 */
public class DropwizardAtmosphereApplication extends Application<DropwizardAtmosphereConfiguration> {
    @Override
    public void run(DropwizardAtmosphereConfiguration dropwizardAtmosphereConfiguration, Environment environment) throws Exception {
        AtmosphereServlet atmosphereServlet = new AtmosphereServlet();
        atmosphereServlet.framework().addInitParameter("com.sun.jersey.config.property.packages", "fr.mmarie.resources");
        atmosphereServlet.framework().addInitParameter("org.atmosphere.websocket.messageContentType", "application/json");
        environment.servlets().addServlet("Chat", atmosphereServlet).addMapping("/chat/*");
    }

    public static void main(String[] args) throws Exception {
        new DropwizardAtmosphereApplication().run(args);
    }
}
