package com.a4app;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBros extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listrs = new String[]{"Call Center", "SMS Center", "Driving Direction", "Website", "Info di Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listrs));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
                String nomortel = "tel:0761-73646347";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(nomortel));


            } else if (pilihan.equals("SMS Center"))
            {
                String smsText = "Nining Nur Habibah";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:11950121722"));
                a.putExtra("sms_body",smsText);


            }else if (pilihan.equals("Driving Directions"))
            {
                String lokasirs = "https://www.google.com/maps/place/RS+Awal+Bros+Sudirman/@0.4965894,101.4540993,17z/data=!3m1!4b1!4m5!3m4!1s0x31d5aea46b46e5f1:0xdbacb5fecaf89643!8m2!3d0.4965894!4d101.456288";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(lokasirs));


            }else if (pilihan.equals("Website"))
            {
                String website = "http://awalbros.com/branch/pekanbaru/";
                a = new Intent(Intent.ACTION_VIEW, Uri.parse(website));


            }else if (pilihan.equals("Info di Google"))
            {
                a= new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bross");
            }


            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}