/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 * TwitterWhatAreYouDoingService Service
 *
 * @author ngloc_it
 */

public class TwitterWhatAreYouDoingService {

    /** Creates a new instance of TwitterWhatAreYouDoingService */
    public TwitterWhatAreYouDoingService() {
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(Throwable th) {}
    }

    /**
     *
     * @param device
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse updateDeliveryDevice(String device, String format) throws IOException {
        TwitterWhatAreYouDoingServiceAuthenticator.login();
        String[][] pathParams = new String[][]{{"{format}", format}};
        String[][] queryParams = new String[][]{{"device", device}};
        RestConnection conn = new RestConnection("http://twitter.com/account/update_delivery_device.{format}", pathParams, null);
        sleep(1000);
        return conn.post(null, queryParams);
    }
}
