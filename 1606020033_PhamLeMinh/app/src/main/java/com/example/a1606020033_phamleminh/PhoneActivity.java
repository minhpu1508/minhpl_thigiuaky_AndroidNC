package com.example.a1606020033_phamleminh;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneActivity extends AppCompatActivity {
    RecyclerView contact_recyclerView;
    List<ModelContact> models;
    Map<String,String> mMap = new HashMap<>();
    int iID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        models = new ArrayList<>();
        onInit();
        contact_recyclerView.setHasFixedSize(true);
        contact_recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null)
        {
            iID =(Integer) b.get("getID");
        }
        mMap.put("id",String.valueOf(iID));
        new ContactAsynTask(PhoneActivity.this,new IView(){
            @Override
            public void onRequestSuccess(Bitmap bitmap) {

            }

            @Override
            public void onGetDataSuccess(JSONArray jsonArray) {
                for(int i=0;i <jsonArray.length();i++) {
                    try {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        ModelContact contactModel = new ModelContact();
                        contactModel.setId(Integer.valueOf(jsonObject.getInt("id")));
                        contactModel.setProductname(jsonObject.getString("product_name"));
                        contactModel.setPrice(Integer.valueOf(jsonObject.getInt("price")));
                        contactModel.setDescription(jsonObject.getString("description"));
                        contactModel.setProducer(jsonObject.getString("producer"));

                        models.add(contactModel);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                MyAdapter adapter = new MyAdapter(PhoneActivity.this,R.layout.row_phonecontact_item,models);
                contact_recyclerView.setAdapter(adapter);
            }
        },mMap).execute(" http://www.vidophp.tk/api/account/getdata");
    }
    private void onInit() {
        contact_recyclerView = findViewById(R.id.contact_recylerview);
    }
}
