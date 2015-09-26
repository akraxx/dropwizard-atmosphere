package fr.mmarie;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by Maximilien on 26/09/2015.
 */
public class DropwizardAtmosphereApplication extends Application<DropwizardAtmosphereConfiguration> {
    @Override
    public void run(DropwizardAtmosphereConfiguration dropwizardAtmosphereConfiguration, Environment environment) throws Exception {

    }

    public static void main(String[] args) throws Exception {
        new DropwizardAtmosphereApplication().run(args);
    }
}
