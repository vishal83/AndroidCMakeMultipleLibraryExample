package com.vishal83.test.cmake.testnativecmake;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateValues();
    }

    private void updateValues() {
        int a = Integer.parseInt(TextUtils.isEmpty(getNumberFromEditText(R.id.inputAEditText)) ? "1" : getNumberFromEditText(R.id.inputAEditText));
        int b = Integer.parseInt(TextUtils.isEmpty(getNumberFromEditText(R.id.inputBEditText)) ? "1" : getNumberFromEditText(R.id.inputBEditText));

        TextView additionOutputTextView = (TextView) findViewById(R.id.additionOutputTextView);
        additionOutputTextView.setText("Addition Output is: " + sumFromJNI(a, b));

        TextView multiplicationOutputTextView = (TextView) findViewById(R.id.multiplicationOutputTextView);
        multiplicationOutputTextView.setText("Multiplication Output is: " + productFromJNI(a, b));
    }

    @NonNull
    private String getNumberFromEditText(int resourceId) {
        return ((EditText) findViewById(resourceId)).getText().toString();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int sumFromJNI(int a, int b);

    public native int productFromJNI(int a, int b);

    public void updateAgain(View view) {
        updateValues();
    }
}
