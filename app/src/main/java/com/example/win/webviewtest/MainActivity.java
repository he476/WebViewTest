package com.example.win.webviewtest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    private String header="http://";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.et);
        button=findViewById(R.id.btn);

//        Intent intent =new Intent(Intent.ACTION_VIEW);
//        intent.putExtra("url","http://www.baidu.com");
////        intent.setData(Uri.parse("http://www.baidu.com"));
//        Intent choose=Intent.createChooser(intent,"选择一个浏览器");
//        startActivity(choose);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String url=header+editText.getText().toString();
                intent.putExtra("url",url);
                Intent choose=Intent.createChooser(intent,"选择一个浏览器");
                startActivity(choose);
            }
        }
        );
    }
}
