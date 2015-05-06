package swip.junit;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

public class ConfigFactory {
    public static final String BASE_URL = baseUrl();
    private static final Logger LOGGER = Logger.getLogger(ConfigFactory.class.getName());

    private static String baseUrl() {
        try {
            String baseUrl = System.getProperty("webdriver.baseUrl", "http://" + getHostName() + ":8080");
            LOGGER.info("baseUrl " + baseUrl);
            return baseUrl;
        } catch (SocketException | UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getHostName() throws UnknownHostException, SocketException {
        return Collections
                .list(NetworkInterface.getNetworkInterfaces())
                .stream()
                .peek(p -> LOGGER.info(p.getName() + " " + p.getInetAddresses().nextElement().getHostAddress()))
                .filter(p -> Arrays.asList("vboxnet1").contains(p.getName()))
                .findFirst()
                .get()
                .getInetAddresses()
                .nextElement()
                .getHostAddress();
    }

    public static void main(String[] args) throws SocketException, UnknownHostException {
        System.out.println(getHostName());
    }
}