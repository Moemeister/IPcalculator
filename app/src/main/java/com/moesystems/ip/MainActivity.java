package com.moesystems.ip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ip, netmask,idRed, broadcast, host, netBits, hostBits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = findViewById(R.id.caja_ip);
        netmask = findViewById(R.id.mascara);
        idRed = findViewById(R.id.txt_id_net);
        broadcast = findViewById(R.id.txt_broad);
        host = findViewById(R.id.txt_cant_ip);
        hostBits = findViewById(R.id.txt_part_host);
        netBits = findViewById(R.id.txt_part_red);

    }
    public void calc(View v) {
        //separa la ip por puntos
        String[] octeto = ip.getText().toString().split("\\.");

        int IP = 0;
        int rMask = 0;
        int token = 0;
        int mascara = Integer.parseInt(netmask.getText().toString());

        if(octeto.length != 4) return;

        //ciclo para obtener la ip en binario
        for(int i=3; i>=0; i--) {
            IP |= (Long.parseLong(octeto[3-i])) << (i*8);
        }

        //ciclo para obtener la mascara en binario
        for(int i=1; i <= mascara; i++) {
            rMask |= 1L << (32-i);
        }

        //invert network mask
        token = ~rMask;

        idRed.setText(longToIP(IP & rMask));
        broadcast.setText(longToIP(IP | token));
        host.setText((int)(Math.pow(2, (double)(32-mascara))) -2 + "");
        hostBits.setText((32-mascara) + "");
        netBits.setText(mascara + "");

    }
    //binary to IP
    public String longToIP(long ip){
        String st="";

        for(int i=3; i>=0; i--) {
            st += (0b1111_1111 & (ip >> (i*8) )) + (i!=0? ".": "");
        }

        return st;
    }

}
