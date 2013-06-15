package utils;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import models.Device;
import models.Notification;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class GCMGateway {
    private GCMFactory gcmFactory = new GCMFactory();

    public void sendMessage(Set<Device> destinationDevices, Notification notification) throws IOException {
        Sender sender = gcmFactory.createSender();
        Message message = gcmFactory.createMessage("message", notification.getContent(), 3600);

        Collection<String> regIds = Collections2.transform(destinationDevices, new Function<Device, String>() {
            @Nullable
            @Override
            public String apply(@Nullable Device device) {
                return device.getRegisteredId();
            }
        });

        sender.send(message, Lists.newArrayList(regIds), 1);
    }

    public void sendMessage(Device destinationDevice, Notification notification) throws IOException {
        sendMessage(Sets.newHashSet(destinationDevice), notification);
    }

    @VisibleForTesting
    void setGcmFactory(GCMFactory factory) {
        this.gcmFactory = factory;
    }
}
