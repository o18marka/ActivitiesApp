package com.example.brom.activitiesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static String  EXTRA_MESSAGE = " ";
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    private ArrayList<String> listData=new ArrayList<>(Arrays.asList(mountainNames));
    private ArrayList<mountain> mountainArrayList=new ArrayList<>(); //här


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.startaActivity);
        b.setText("TestKnapp!(Gör inget)");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.my_item,R.id.my_item,listData);//Här
        ListView my_listview=(ListView) findViewById(R.id.my_item);//här
        my_listview.setAdapter(adapter);//här

        mountainArrayList.add(new mountain("Matterhorn","Alps",4478)); //här
        mountainArrayList.add(new mountain("Mont Blanc","Alps",4808)); //här
        mountainArrayList.add(new mountain("Denali","Alaska",6190)); //här

        ArrayAdapter<mountain> adapter2=new ArrayAdapter<mountain>(this,R.layout.my_item,R.id.my_item,mountainArrayList); //här

        my_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() { //Min Toast
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent intent = new Intent(MainActivity.this, MountainDetailsActivity.class);
                    String mountaininfo = mountainArrayList.get(position).info();
                    intent.putExtra(EXTRA_MESSAGE, mountaininfo);
                    startActivity(intent);

            }
        });


        // 1. Create a ListView as in previous assignment
        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.
    }



    @Override
    protected void onStop() {
        super.onStop();
    }
}
