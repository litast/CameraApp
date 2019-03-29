package lv.lita.stauvere.cameraapp;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ImageSwitcher sw;
    private Button prev, next;
    GridView myGrid;

    int[] imageId = {
            R.drawable.flag_azerbaijan,
            R.drawable.flag_canada,
            R.drawable.flag_croatia,
            R.drawable.flag_iceland,
            R.drawable.flag_latvia,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        //ImageSwitcher
        sw = (ImageSwitcher) findViewById(R.id.imgsw);
        sw.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        sw.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);

        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Thumb Down", Toast.LENGTH_SHORT).show();
                sw.setImageResource(R.mipmap.thumbs_down);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Thumb Up", Toast.LENGTH_SHORT).show();
                sw.setImageResource(R.mipmap.thumbs_up);
            }
        });
 */

        //GridView
        GridAdapter adapter = new GridAdapter(MainActivity.this,imageId);
        GridView myGrid = (GridView) findViewById(R.id.gridView);
        myGrid.setAdapter(adapter);
        myGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "Bilde " + (position + 1 ), Toast.LENGTH_SHORT).show();

            }
        });

    }

}


class GridAdapter extends BaseAdapter {

    Context context;

    final int[] Imageid;

    GridAdapter(Context context, int[] Imageid) {
        this.context = context;
        this.Imageid = Imageid;
    }

    @Override
    public int getCount() {
        return Imageid.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if (convertView == null) {
            //layout uzstadisana
            gridView = new View(context);
            gridView = inflater.inflate(R.layout.single_item, null);
            //bildes uzstadisana
            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_imageView);
            imageView.setImageResource(Imageid[position]);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }


}