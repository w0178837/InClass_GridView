package com.example.w0178837.inclass_gridview;

//source: http://developer.android.com/guide/topics/ui/layout/gridview.html
        import android.support.v7.app.AppCompatActivity;
        import android.os.*;
        import android.view.*;
        import android.widget.*;
        import android.widget.AdapterView.OnItemClickListener;
        import android.content.Context;


public class MainActivity extends AppCompatActivity {

    //the images to display
    Integer[] imageIDs={
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5,
            R.drawable.pic6,
            R.drawable.pic7
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id)
            {
                Toast.makeText(getBaseContext(),
                        "pic" + (position + 1) + " selected",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }//end method onCreate

    public class ImageAdapter extends BaseAdapter
    {
        private Context context;

        public ImageAdapter(Context c)
        {
            context = c;
        }

        //returns the number of images
        public int getCount()
        {
            return imageIDs.length;
        }

        //returns the item
        public Object getItem(int position)
        {
            return position;
        }

        //returns the item id
        public long getItemId(int position)
        {
            return position;
        }


        //returns an ImageView view
        public View getView(int position,View convertView, ViewGroup parent)
        {
            ImageView imageView;
            if(convertView == null)
            {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(185,185));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(5,5,5,5);
            }else{
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(imageIDs[position]);
            return imageView;

        }//end method getView

    }//end class ImagAdapter

}//end class MainActivity
