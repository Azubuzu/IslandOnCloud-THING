package ch.hevs.vleiot.IslandOnCloudTHING.model;

import ch.hevs.cloudio.endpoint.*;

public class Inputs extends CloudioObject {
    @Measure
    public CloudioAttribute<Boolean> switch0;

    public Inputs() throws CloudioAttributeConstraintException, CloudioAttributeInitializationException {
        switch0.setInitialValue(false);
    }
}
