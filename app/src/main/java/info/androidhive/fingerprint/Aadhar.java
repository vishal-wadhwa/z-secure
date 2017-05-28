package info.androidhive.fingerprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by dhruv on 28/5/17.
 */

public class Aadhar extends AppCompatActivity {
    public static final String PARAM_UUID = "param_uuid";
    public static final String PARAM_NAME = "param_name";
    private String name;
    private String uuid;
    private TextView tvName, tvUUID;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aadhar);

        name = getIntent().getStringExtra(PARAM_NAME);
        uuid = getIntent().getStringExtra(PARAM_UUID);

        btn = (Button) findViewById(R.id.btn);

        tvName = (TextView) findViewById(R.id.name);
        tvUUID = (TextView) findViewById(R.id.uuid);

        tvName.setText(name);
        tvUUID.setText(uuid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aadhar.this, FingerprintActivity.class);
                startActivity(i);
            }
        });
    }
}