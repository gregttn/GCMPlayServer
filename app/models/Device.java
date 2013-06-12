package models;

public class Device {
    private String deviceId;
    private String registeredId;

    public Device() {}

    public Device(String deviceId, String registeredId) {
        this.deviceId = deviceId;
        this.registeredId = registeredId;
    }

    public String getRegisteredId() {
        return registeredId;
    }

    public void setRegisteredId(String registeredId) {
        this.registeredId = registeredId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (deviceId != null ? !deviceId.equals(device.deviceId) : device.deviceId != null) return false;
        if (registeredId != null ? !registeredId.equals(device.registeredId) : device.registeredId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceId != null ? deviceId.hashCode() : 0;
        result = 31 * result + (registeredId != null ? registeredId.hashCode() : 0);
        return result;
    }
}
