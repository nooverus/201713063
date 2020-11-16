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

public class SubActivity extends AppCompatActivity {
    EditText edit;//1차입력 텍스트
    static final int GET_STRING2 = 1;
    TextView text3;//Subactivity2 로부터 입력받은 결과를 저장할 텍스트 뷰

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

        edit = (EditText) findViewById(R.id.edit);//입력받을 1차 텍스트
        Button button_ok = (Button) findViewById(R.id.button_ok);//서브액티비티에 입력완료를 버튼
        button_ok.setOnClickListener(new View.OnClickListener() {//입력완료 버튼을 눌렀을때 이벤트처리
            public void onClick(View v) {//서브액티비티에 입력된 1차입력,2차입력텍스트 결과를 내보내기위한 메소드
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", edit.getText().toString());//1차텍스트에 대한 내용을 INPUT_TEXT에 담는다
                intent.putExtra("INPUT_TEXT2", text3.getText().toString());//2차텍스트에 대한 내용을 INPUT_TEXT2에 담는다
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Button button_cancel = (Button) findViewById(R.id.button_cancel);//취소버튼 변수설정
        button_cancel.setOnClickListener(new View.OnClickListener() {//취소버튼에 대한 이벤트처리
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        text3 = (TextView) findViewById(R.id.text3);//서브액티비티2로부터 받아온 결과를 저장할 텍스트
        Button button_input = (Button) findViewById(R.id.button_input);//2차데이터 입력 버튼 변수설정
        button_input.setOnClickListener(new View.OnClickListener() {//2차데이터 입력 버튼을 눌렀을때의 이벤트처리
            // @Override
            public void onClick(View view) {//서브액티비티2로 넘어간다
                Intent input = new Intent(SubActivity.this, SubActivity2.class);

                startActivityForResult(input, GET_STRING2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//서브액티비티2로부터 결과를 받아온다
        if (requestCode == GET_STRING2) {
            if (resultCode == RESULT_OK) {
                text3.setText(data.getStringExtra("INPUT_TEXT"));//INPUT_TEXT에 저장된 결과를 텍스트3에 입력한다
            }
        }
    }

}
