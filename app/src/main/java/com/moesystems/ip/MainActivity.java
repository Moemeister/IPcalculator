package com.moesystems.ip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ip, mask,idNet, broad, hosts, netBits, hostBits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = findViewById(R.id.caja_ip);
        mask = findViewById(R.id.mascara);

        idNet = findViewById(R.id.txt_id_net);
        broad = findViewById(R.id.txt_broad);
        hosts = findViewById(R.id.txt_cant_ip);
        netBits = findViewById(R.id.txt_part_red);
        hostBits = findViewById(R.id.txt_part_host);
    }
    /*public void calculate(View v) {
        String[] st = ip.getText().toString().split("\\.");

        long rIP = 0;
        long rMask = 0;
        long wildcard = 0;
        int maskInt = Integer.parseInt(mask.getText().toString());

        if(st.length != 4) return;

        //Get binary ip address
        for(int i=3; i>=0; i--) {
            rIP |= (Long.parseLong(st[3-i])) << (i*8);
        }

        //Get binary network mask
        for(int i=1; i <= maskInt; i++) {
            rMask |= 1L << (32-i);
        }

        //invert network mask
        wildcard = ~rMask;

        idNet.setText(longToIP(rIP & rMask));
        broad.setText(longToIP(rIP | wildcard));
        hosts.setText((int)(Math.pow(2, (double)(32-maskInt))) -2 + "");
        netBits.setText(maskInt + "");
        hostBits.setText((32-maskInt) + "");

    }

    public String longToIP(long ip){
        String st="";

        for(int i=3; i>=0; i--) {
            st += (0b1111_1111 & (ip >> (i*8) )) + (i!=0? ".": "");
        }

        return st;
    }

    public void reset(View v) {

        ip.setText("");
        mask.setText("");

        idNet.setText("");
        broad.setText("");
        hosts.setText("");
        netBits.setText("");
        hostBits.setText("");
    }*/
}
