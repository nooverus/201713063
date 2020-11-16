package kr.co.company.ActivityForResult_201713063;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kr.co.company.ActivityForResult_201713063.R;

/**
 * Created by igchun on 2017-05-01.
 */
//두번째 SubActivity2 생성
public class SubActivity2 extends AppCompatActivity {
    EditText edit3;//입력받을 edit text 변수생성


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub2);

        edit3 = (EditText) findViewById(R.id.edit3);//id가 edit3인 입력텍스트를 받아와 변수에 저장
        Button button_okay = (Button) findViewById(R.id.button_okay);//입력완료 버튼 id를 받아온다
        button_okay.setOnClickListener(new View.OnClickListener() { //입력완료 버튼에 대한 이벤트처리
            public void onClick(View v) {// subactivity 로 결과를 내보낸다
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", edit3.getText().toString());//입력바은 메시지를 INPUT_TEXT 에 저장
                setResult(RESULT_OK, intent);

                finish();
            }
        });

        Button button_canceler = (Button) findViewById(R.id.button_canceler);//취소 버튼에 대한 처리 기존의 취소버튼과 같은 이벤트로 만든다
        button_canceler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}