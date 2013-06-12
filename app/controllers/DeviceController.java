package controllers;

import com.google.common.collect.Lists;
import models.Device;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.*;
import play.mvc.*;
import views.html.*;

import java.util.*;

public class DeviceController extends Controller {
    public static Map<String, Device> registeredDevices = new HashMap<String, Device>();

    private static Logger logger = LoggerFactory.getLogger("DeviceController");

    public static Result register() {
        Map<String, String[]> params = request().body().asFormUrlEncoded();
        String[] deviceIds = params.get("deviceId");
        String[] registrationIds = params.get("registrationId");

        if( !ArrayUtils.isEmpty(deviceIds) && !ArrayUtils.isEmpty(registrationIds)) {
            String deviceId = deviceIds[0];
            String registartionId = registrationIds[0];

             logger.info("Adding device: [" + deviceId+ "]");

            registeredDevices.put(deviceId, new Device(deviceId, registartionId));

            return redirect(routes.DeviceController.devices());
        } else {
            return badRequest();
        }
    }

    public static Result devices() {
        return ok(devices.render(Lists.newArrayList(registeredDevices.values())));
    }
}
