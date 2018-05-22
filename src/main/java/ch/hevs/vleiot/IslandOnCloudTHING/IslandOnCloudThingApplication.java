package ch.hevs.vleiot.IslandOnCloudTHING;

import ch.hevs.cloudio.endpoint.*;
import ch.hevs.vleiot.IslandOnCloudTHING.model.IoBox;
import ch.hevs.vleiot.IslandOnCloudTHING.ui.JIoBoxFrame;
import ch.hevs.vleiot.IslandOnCloudTHING.ui.JSwitch;
import ch.hevs.vleiot.IslandOnCloudTHING.ui.JSwitchListener;
import java.util.Scanner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class IslandOnCloudThingApplication {
	public static void main(String... args) {
		try {
			final CloudioEndpoint endpoint = new CloudioEndpoint("StuderInnotec_1");
			final IoBox box = endpoint.addNode("io", IoBox.class);
			final JIoBoxFrame frame = new JIoBoxFrame(1);
			Scanner scan = new Scanner(System.in);
			String text;

			box.outputs.led0.addListener(new CloudioAttributeListener<Boolean>() {
				@Override
				public void attributeHasChanged(CloudioAttribute<Boolean> attribute) {
					System.out.println("IoBoxExample.attributeHasChanged to : "+box.inputs.switch0.getValue());
				}
			});

			while (true) {
				text = scan.nextLine();
				try {
					if (text.equals("ON")) {
						box.inputs.switch0.setValue(true);
					}
					else {
						box.inputs.switch0.setValue(false);
					}
				} catch (CloudioAttributeConstraintException e) {
					e.printStackTrace();
				}
			}

			/*frame.getSwitch(0).setListener(new JSwitchListener() {
				@Override
				public void stateChanged(JSwitch jswitch) {
					try {
						box.inputs.switch0.setValue(jswitch.getState());
					} catch (CloudioAttributeConstraintException e) {
						e.printStackTrace();
					}
				}
			});*/



			/*
			frame.setVisible(true);

			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					endpoint.close();
					//Runtime.getRuntime().exit(0);
				}
			});*/

		} catch (InvalidUuidException e) {
			e.printStackTrace();
		} catch (InvalidPropertyException e) {
			e.printStackTrace();
		} catch (CloudioEndpointInitializationException e) {
			e.printStackTrace();
		} catch (DuplicateNamedItemException e) {
			e.printStackTrace();
		}
	}
}
