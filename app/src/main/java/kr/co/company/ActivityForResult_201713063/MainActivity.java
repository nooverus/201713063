package kr.co.company.ActivityForResult_201713063;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.company.ActivityForResult_201713063.R;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text1,text2;//서브액티비들로부터 받은 결과들을 저장한 텍스트

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        button.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                Intent in = new Intent(MainActivity.this, SubActivity.class);

                startActivityForResult(in, GET_STRING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                text1.setText(data.getStringExtra("INPUT_TEXT"));
                text2.setText(data.getStringExtra("INPUT_TEXT2"));//서브액티비티2로부터 입력받은 결과가 저장된 INPUT_TEXT 로부터 읽어와 텍스트2에저장
            }
        }
    }
}
