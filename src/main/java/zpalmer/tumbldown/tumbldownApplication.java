package zpalmer.tumbldown;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import zpalmer.tumbldown.resources.HelloWorldResource;

public class tumbldownApplication extends Application<tumbldownConfiguration> {

    public static void main(final String[] args) throws Exception {
        new tumbldownApplication().run(args);
    }

    @Override
    public String getName() {
        return "tumbldown";
    }

    @Override
    public void initialize(final Bootstrap<tumbldownConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final tumbldownConfiguration configuration,
                    final Environment environment) {
        // this "registers" a resource as something that can be reached in the environment
        final HelloWorldResource helloResource = new HelloWorldResource(
                configuration.getHelloWorldTemplate(),
                configuration.getHelloWorldDefaultName()
        );
        environment.jersey().register(helloResource);
    }

}