package info.androidhive.fingerprint;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.kontakt.sdk.android.ble.connection.OnServiceReadyListener;
import com.kontakt.sdk.android.ble.manager.ProximityManager;
import com.kontakt.sdk.android.ble.manager.ProximityManagerFactory;
import com.kontakt.sdk.android.ble.manager.listeners.EddystoneListener;
import com.kontakt.sdk.android.ble.manager.listeners.simple.SimpleEddystoneListener;
import com.kontakt.sdk.android.common.KontaktSDK;
import com.kontakt.sdk.android.common.profile.IEddystoneDevice;
import com.kontakt.sdk.android.common.profile.IEddystoneNamespace;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeAct";
    private ProximityManager proximityManager;
    public String contain[];
    public int ind = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contain = new String[3];

        KontaktSDK.initialize("YBVNhCQdbYqQtkxOZyAPmyshZkQXhKUl");

        proximityManager = ProximityManagerFactory.create(this);
        proximityManager.setEddystoneListener(createEddystoneListener());
    }

    @Override
    protected void onStart() {
        super.onStart();
        startScanning();
    }

    @Override
    protected void onStop() {
        proximityManager.stopScanning();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        proximityManager.disconnect();
        proximityManager = null;
        super.onDestroy();
    }

    private void startScanning() {
        proximityManager.connect(new OnServiceReadyListener() {
            @Override
            public void onServiceReady() {
                proximityManager.startScanning();
            }
        });
    }

    private EddystoneListener createEddystoneListener() {
        return new SimpleEddystoneListener() {
            @Override
            public void onEddystoneDiscovered(IEddystoneDevice eddystone, IEddystoneNamespace namespace) {
                Log.d("Sample", "Eddystone discovered: " + eddystone.toString() + eddystone.getNamespace());

                Toast.makeText(HomeActivity.this, "ENTRY IS AUTHENTICATED!!!!", Toast.LENGTH_LONG).show();

//                ParseQuery<ParseUser> query = ParseUser.getQuery();
//                query.findInBackground(new FindCallback<ParseUser>() {
//                    @Override
//                    public void done(List<ParseUser> userList, ParseException e) {
//                        if (e == null) {
//                            int already = 0;
//                            Log.d(TAG, "userListSize: " + userList.size());
////                            for (int j = 0; j < 3; j++) {
////                                if (contain[j].equals(Aadhar.loginName)) {
////                                    already = 0;
////                                }
////                            }
//
//                            Log.d(TAG,"AadharName:  "+Aadhar.loginName);
//
//                            for (int i = 0; i < userList.size(); i++) {
//                                if (Aadhar.loginName.equals(userList.get(i).getUsername().toString())) {
//
//                                    already = 1;
//
//                                    Toast.makeText(HomeActivity.this, "ENTRY IS AUTHENTICATED!!!!", Toast.LENGTH_LONG).show();
//
////                                    new AlertDialog.Builder(HomeActivity.this).setTitle("Please Retry").setMessage("An Account already exists with the provided Email Address.")
////                                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
////                                                public void onClick(DialogInterface dialog, int which) {
////                                                    // continue with delete
////                                                }
////                                            }).show();
//                                }
//                            }
//
//                            if (already == 0) {
//                                final ParseUser user = new ParseUser();
//                                user.setUsername(Aadhar.loginName);
//                                user.setPassword("pass");
//                                user.signUpInBackground(new SignUpCallback() {
//                                    @Override
//                                    public void done(ParseException e) {
//                                        if (e == null) {
//                                            Toast.makeText(HomeActivity.this, "SIGNED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
//                                        } else {
//                                            Log.d(TAG,"error",e);
//                                        }
//                                    }
//                                });
//                            }
//                            else {
//                                ParseUser user = ParseUser.getCurrentUser();
//                                contain[ind++] = user.getUsername();
//                            }
//                        }
//                        else {
//                            Log.d(TAG,"error:: "+e);
//                        }
//                    }
//                });

            }

            @Override
            public void onEddystoneLost(IEddystoneDevice eddystone, IEddystoneNamespace namespace) {
                Log.d("Sample", "onEddystoneLost: " + eddystone.getUniqueId());
            }
        };
    }
}