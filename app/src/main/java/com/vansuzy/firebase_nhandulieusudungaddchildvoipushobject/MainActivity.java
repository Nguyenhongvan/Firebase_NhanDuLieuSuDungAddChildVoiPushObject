package com.vansuzy.firebase_nhandulieusudungaddchildvoipushobject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mData;

    ListView lvXe;
    ArrayList<String> arrPhuongTien;
    ArrayAdapter<String> adapterPhuongTien = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvXe = (ListView) findViewById(R.id.lvXe);
        arrPhuongTien = new ArrayList<String>();
        adapterPhuongTien = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrPhuongTien
        );
        lvXe.setAdapter(adapterPhuongTien);

        mData = FirebaseDatabase.getInstance().getReference();

        PhuongTien phuongTien = new PhuongTien("Xe khách", 10);
        //mData.child("PhuongTien").push().setValue(phuongTien);

        // nhận dữ liệu Object về
        mData.child("PhuongTien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                PhuongTien pTien = dataSnapshot.getValue(PhuongTien.class);
                arrPhuongTien.add(pTien.Ten + " - " + pTien.Banh + " bánh");
                adapterPhuongTien.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
