package info.androidhive.fingerprint;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dhruv on 28/5/17.
 */

public class LoginAct extends AppCompatActivity {


    private EditText name, uuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#DD303F9F"));
        }

        name = (EditText) findViewById(R.id.name);
        uuid = (EditText) findViewById(R.id.uuid);

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty() || uuid.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "None of the fields can be left empty.", Toast.LENGTH_SHORT).show();
                } else if (uuid.getText().toString().length() != 12) {
                    Toast.makeText(LoginAct.this, "Invalid UUID", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    i.putExtra(Aadhar.PARAM_NAME, name.getText().toString());
                    String uuid_temp = uuid.getText().toString();
                    i.putExtra(Aadhar.PARAM_UUID,
                            uuid_temp.substring(0, 4) + "-" + uuid_temp.substring(4, 8) + "-" + uuid_temp.substring(8, 12));

                    startActivity(i);
                }
            }
        });
    }
}