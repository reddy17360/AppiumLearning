package Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DeviceManager {

    // Pool of available devices
    private static Queue<String> udidPool = new LinkedList<>();

    // Starting port numbers
    private static int appiumPortBase = 4723;
    private static AtomicInteger systemPortCounter = new AtomicInteger(8200);

    /**
     * Call this at the start (before running tests) to initialize device pool.
     */
    public static void initDevices() {
        List<String> devices = getConnectedDevices();
        udidPool.clear();
        udidPool.addAll(devices);
        System.out.println("Detected devices: " + devices);
    }

    /**
     * Get a UDID from the pool for use by a test method / thread.
     * Returns null if none available.
     */
    public synchronized static String acquireDevice() {
        return udidPool.poll();
    }

    /**
     * Return the device back to the pool after test is done.
     */
    public synchronized static void releaseDevice(String udid) {
        if (udid != null) {
            udidPool.offer(udid);
        }
    }

    /**
     * Get the next systemPort (unique) for UiAutomator2.
     */
    public static int getNextSystemPort() {
        return systemPortCounter.getAndIncrement();
    }

    /**
     * Choose an Appium server port for this test instance (unique).
     * You can also use usingAnyFreePort() in Manager, but this gives you control.
     */
    public static int getAppiumPort(int index) {
        return appiumPortBase + index * 2;  // e.g. 4723, 4725, 4727, etc.
    }

    /**
     * Returns list of connected UDIDs via `adb devices`.
     */
    private static List<String> getConnectedDevices() {
        List<String> devices = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while (( (line = reader.readLine()) ) != null) {
                line = line.trim();
                if (line.endsWith("device") && !line.startsWith("List")) {
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 2) {
                        String udid = parts[0];
                        devices.add(udid);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devices;
    }
}
