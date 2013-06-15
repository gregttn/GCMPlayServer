package controllers;

import controllers.routes;
import org.junit.Test;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class DeviceControllerTest {

    @Test
    public void testDevicesShowDevicesNumber() {
        Result result = callAction(controllers.routes.ref.DeviceController.devices());
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(contentAsString(result)).contains("Registered Devices: (0)");
    }

    @Test
    public void testRegisterNoDeviceIdProvided_returnBadRequest() {
        Result result = callAction(controllers.routes.ref.DeviceController.register());
        assertThat(status(result)).isEqualTo(BAD_REQUEST);
        assertEquals(controllers.DeviceController.)
    }
}
