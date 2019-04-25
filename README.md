# WebViewTest
# 自定义WebView验证隐式Intent的使用
### 本实验通过自定义WebView加载URL来验证隐式Intent的使用。<br>
 实验包含两个应用：<br>
 第一个应用：获取URL地址并启动隐式Intent的调用。<br>
 第二个应用：自定义WebView来加载URL<br>

实现隐式Intent的调用
```
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
```
自定义WebView
```
Bundle bundle=getIntent().getExtras();
        url=bundle.getString("url");
        Log.i("hhhh",url);
        webView=findViewById(R.id.webview);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                webView.loadUrl(url);
                return true;
            }
        });
```


<br>
实验效果：<br>
![image](https://github.com/he476/WebViewTest/blob/master/images/51.png)<br>
![image](https://github.com/he476/WebViewTest/blob/master/images/52.png)<br>
