package cc.ebichu.helloworld;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoreActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), this.MODE_PRIVATE);
        int defaultValue = 0;
        int highScore = sharedPref.getInt(getString(R.string.saved_high_score), defaultValue);

        TextView score_view = (TextView) findViewById(R.id.textView3);
        score_view.setText(String.valueOf(highScore));

        final Button btn_minus = (Button) findViewById(R.id.button_minus);
        final Button btn_plus = (Button) findViewById(R.id.button_plus);
        btn_minus.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Do something in response to button

        int defaultValue = 0;
        int highScore = sharedPref.getInt(getString(R.string.saved_high_score), defaultValue);
        SharedPreferences.Editor editor = sharedPref.edit();

        switch (view.getId()) {
            case R.id.button_minus:
                editor.putInt(getString(R.string.saved_high_score), highScore - 1);
                editor.commit();
                Log.d("test", "plus");
                break;
            case R.id.button_plus:
                editor.putInt(getString(R.string.saved_high_score), highScore + 1);
                editor.commit();
                break;
            default:
                break;
        }
        int highScoreNow = sharedPref.getInt(getString(R.string.saved_high_score), defaultValue);
        TextView score_view = (TextView) findViewById(R.id.textView3);
        score_view.setText(String.valueOf(highScoreNow));
    }
}
