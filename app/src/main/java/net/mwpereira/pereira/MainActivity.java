package net.mwpereira.pereira;

import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntityHC4;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGetHC4;
import org.apache.http.client.methods.HttpPostHC4;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button B_Login;

    EditText ET_Placa;
    EditText ET_Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B_Login=(Button)findViewById(R.id.B_Login);
        ET_Placa=(EditText)findViewById(R.id.ET_Pass);
        ET_Pass=(EditText)findViewById(R.id.ET_Pass);
        B_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String placa = ET_Placa.getText().toString().trim();
                String pass = ET_Pass.getText().toString();
                List<NameValuePair> datos;
                try {
                    CloseableHttpClient myhttpclient = HttpClients.createDefault();
                    HttpPostHC4 post =new HttpPostHC4("http://mwpereira.net/logistica/Movil/access_movil.php");
                    datos=new ArrayList<NameValuePair>(2);
                    datos.add(new BasicNameValuePair("usuario",placa));
                    datos.add(new BasicNameValuePair("password",placa));
                    post.setEntity(new UrlEncodedFormEntityHC4(datos));
                    CloseableHttpResponse httpresponse = myhttpclient.execute(post);
                    System.out.println(httpresponse);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
