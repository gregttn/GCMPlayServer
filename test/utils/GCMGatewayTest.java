package utils;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Sender;
import models.Device;
import models.Notification;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class GCMGatewayTest {
    GCMGateway gcmGateway = new GCMGateway();
    GCMFactory mockFactory = mock(GCMFactory.class);
    Sender mockSender = mock(Sender.class);

    @Before
    public void setup() {
        gcmGateway.setGcmFactory(mockFactory);
        when(mockFactory.createSender()).thenReturn(mockSender);
    }

    @Test
    public void testSendMessage_shouldSendMessageToDevice() throws IOException {
        Device device = new Device("device1","abcdg13435");
        Notification notification = new Notification("some content", "some content id");

        gcmGateway.sendMessage(device, notification);

        verify(mockSender).send(any(Message.class), eq(Arrays.asList(device.getRegisteredId())), eq(1));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSendMessage_throwExceptionWhenNoDevices() throws IOException {
        Notification notification = new Notification("some content", "some content id");

        Set<Device> devices = null;

        gcmGateway.sendMessage(devices, notification);
    }
}
