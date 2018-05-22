package ch.hevs.vleiot.IslandOnCloudTHING.model;

import ch.hevs.cloudio.endpoint.*;

public class Outputs extends CloudioObject{
    @SetPoint
    public CloudioAttribute<Boolean> led0;

    public Outputs() throws CloudioAttributeConstraintException, CloudioAttributeInitializationException {
        led0.setInitialValue(false);
    }
}
