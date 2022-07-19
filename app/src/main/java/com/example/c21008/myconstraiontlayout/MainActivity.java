package com.example.c21008.myconstraiontlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btConfirm = findViewById(R.id.btConfirm);
        HelloListener listener = new HelloListener();   //リスナのインスタンス生成
        btConfirm.setOnClickListener(listener);           //ボタンにリスナを組み込む

        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }


    //リスナクラス <= イベントの監視
    private class HelloListener implements View.OnClickListener {

        //イベントハイドラ　<= イベント発生時
        @Override
        public void onClick(View view) {

            EditText inname = findViewById(R.id.etName);    //入力した名前を挿入
            EditText inmail = findViewById(R.id.etMail);    //入力したメールアドレスを挿入
            EditText intitle = findViewById(R.id.etMailTitle);    //入力したタイトルを挿入
            EditText incomment = findViewById(R.id.etComment);    //入力したコメントを挿入

            String innameStr = inname.getText().toString(); //名前を文字列型へ
            String inmailStr = inmail.getText().toString(); //メールアドレスを文字列型へ
            String intitlelStr = intitle.getText().toString(); //タイトルを文字列型へ
            String incommentStr = incomment.getText().toString(); //コメントを文字列型へ
            String data = "名前：" + innameStr + "\nメールアドレス：" + inmailStr + "\nタイトル：" + intitlelStr + "\n内容：" + incommentStr + "と送信します。";

            int id = view.getId();
            switch (id) {   //ボタン入力
                case R.id.btConfirm:  //確認{
                    Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
                    OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                    dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragmen");
                    break;

                case R.id.btSend:   //送信
                    Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
                    break;

                case R.id.btClear:   //クリア
                    inname.setText("");
                    inmail.setText("");
                    intitle.setText("");
                    incomment.setText("");
                    break;
            }
        }
    }
}