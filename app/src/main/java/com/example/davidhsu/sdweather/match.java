package com.example.davidhsu.sdweather;

/**
 * Created by David Hsu on 2015/9/19.
 */
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.davidhsu.sdweather.sqlDatabase.MySQLiteOpenHelper;
import com.example.davidhsu.sdweather.sqlDatabase.Spot;


public class match extends AppCompatActivity {
    private ImageView ivSpot;
    private TextView tvId;
    private MySQLiteOpenHelper helper;
    private byte[] image;
    private final int tem = 21;
    private List<Spot> spotList1;
    private List<Spot> spotList2;
    private int index;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match);

        if (helper == null) {
            helper = new MySQLiteOpenHelper(this);
        }
        spotList1 =helper.getShortSpots();
        spotList2 =helper.getLongSpots();
        showSpotsMatch(0);

    }

    private void showSpotsMatch(int index) {
        ivSpot = (ImageView) findViewById(R.id.ivSpot);
        tvId = (TextView) findViewById(R.id.tvId);

        if (helper == null) {
            helper = new MySQLiteOpenHelper(this);
        }






        if (tem<=24){
            Spot spot = spotList1.get(index);
            image = spot.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,
                    spot.getImage().length);
            ivSpot.setImageBitmap(bitmap);
            tvId.setText(Integer.toString(spot.getId()));
        }
        else if (tem>=24) {
            Spot spot = spotList2.get(index);
            image = spot.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,
                    spot.getImage().length);
            ivSpot.setImageBitmap(bitmap);
            tvId.setText(Integer.toString(spot.getId()));
        }

    }

    public void onNextClickMatch(View view) {
        index++;
        if (index >= spotList1.size()) {
            index = 0;
        }
        showSpotsMatch(index);
    }

    public void onBackClickMatch(View view) {
        index--;
        if (index < 0) {
            index = spotList1.size() - 1;
        }
        showSpotsMatch(index);
    }


    public void onCancelClick(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helper != null) {
            helper.close();
        }
    }

}
