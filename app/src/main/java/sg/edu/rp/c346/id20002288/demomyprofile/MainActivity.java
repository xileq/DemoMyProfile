package sg.edu.rp.c346.id20002288.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText etname,etgpa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.etname);
        etgpa=findViewById(R.id.etgpa);
    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs =getPreferences((MODE_PRIVATE));
        SharedPreferences.Editor prefeditor = prefs.edit();
        prefeditor.putString("name",etname.getText().toString());
        prefeditor.putFloat("gpa",Float.parseFloat(etgpa.getText().toString()));
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name","Unknown");
        float gpa = prefs.getFloat("gpa",0f);
        etname.setText(name);
        etgpa.setText(String.valueOf(gpa));
    }
}