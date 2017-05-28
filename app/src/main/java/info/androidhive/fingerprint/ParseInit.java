package info.androidhive.fingerprint;

import com.parse.Parse;

/**
 * Created by dhruv on 7/2/17.
 */

public class ParseInit extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("HLCAmFOzjxs4qA41p3AYeXBxQ4UgezVkniyOP2s9")
                .server("https://parseapi.back4app.com/")
                .clientKey("QaDlfRJeIcEQsfMU0ZeK48XdjnRML3uqKQPu4F6k")
                .build());
    }
}
