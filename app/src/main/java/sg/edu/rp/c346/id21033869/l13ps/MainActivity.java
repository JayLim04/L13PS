package sg.edu.rp.c346.id21033869.l13ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvCarpark;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCarpark = findViewById(R.id.lvCarpark);
        client= new AsyncHttpClient();

    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Carpark> alCarpark = new ArrayList<>();

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            int totalLots;
            String lotType;
            String lotsAvailable;
            String carparkNumber;


            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrCarparkData = firstObj.getJSONArray("carpark_data");
                    for (int i = 0; i < jsonArrCarparkData.length(); i++) {
                        JSONObject jsonObjCarpark = jsonArrCarparkData.getJSONObject(i);
                        JSONArray jsonArrCarparkInfo = jsonObjCarpark.getJSONArray("carpark_info");
                        JSONObject secondObj = jsonArrCarparkInfo.getJSONObject(0);


                        totalLots = secondObj.getInt("total_lots");
                        lotType = secondObj.getString("lot_type");
                        lotsAvailable = secondObj.getString("lots_available");
                        carparkNumber=jsonObjCarpark.getString("carpark_number");
                        Carpark carpark = new Carpark(totalLots, lotType,lotsAvailable,carparkNumber);
                        alCarpark.add(carpark);
                    }
                } catch (JSONException e) {
                    Log.d("exception", e.toString());

                }//POINT X – Code to display List View
                ArrayAdapter<Carpark> aa = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alCarpark);
                lvCarpark.setAdapter(aa);
            }


            });



        }
    }

