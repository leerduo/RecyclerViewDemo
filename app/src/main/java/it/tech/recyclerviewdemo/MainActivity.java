package it.tech.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import it.tech.recyclerviewdemo.bean.EventInfo;
import it.tech.recyclerviewdemo.bean.EventResultInfo;
import it.tech.recyclerviewdemo.http.AsyncHttpUtilClient;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private static final String URL= "https://api.douban.com/v2/event/list?loc=118183";
    List<EventInfo> eventInfos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


       // mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        //添加分割线
       // mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
               // DividerItemDecoration.VERTICAL_LIST));

    }

    private void initData() {

        AsyncHttpUtilClient.get(URL,null,new AsyncHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody);
                EventResultInfo resultInfo = JSON.parseObject(json, EventResultInfo.class);
                //Log.e(TAG, "onSuccess " + resultInfo.toString());
                eventInfos = resultInfo.getEvents();
                //Log.e(TAG, "onSuccess " + eventInfos.toString());
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       // specify an adapter (see also next example)
                       mAdapter = new MyAdapter(eventInfos);
                       mRecyclerView.setAdapter(mAdapter);
                   }
               });

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<EventInfo> eventInfos;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            CardView cardView;
            TextView title;
            TextView time;
            TextView address;
            TextView count;
            ImageView icon;
            public ViewHolder(View v) {
                super(v);
                cardView = (CardView) v.findViewById(R.id.card_view);
                title = (TextView) v.findViewById(R.id.tvTitle);
                time = (TextView) v.findViewById(R.id.time);
                address = (TextView) v.findViewById(R.id.address);
                count = (TextView) v.findViewById(R.id.tvCount);
                icon = (ImageView) v.findViewById(R.id.item_icon);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(List<EventInfo> eventInfos) {
            this.eventInfos = eventInfos;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_item, parent, false);
            // set the view's size, margins, paddings and layout parameters
            v.setPadding(5,5,5,5);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element

            holder.title.setText(eventInfos.get(position).getTitle());
            Log.e(TAG, "onBindViewHolder " + eventInfos.get(position).getTitle());
            holder.time.setText(eventInfos.get(position).getBegin_time() + "~" +
                    eventInfos.get(position).getEnd_time());
            holder.address.setText(eventInfos.get(position).getAddress());
            holder.count.setText(eventInfos.get(position).getWisher_count() + "人感兴趣," +
            eventInfos.get(position).getParticipant_count() + "人参加");
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(eventInfos.get(position).getImage(),holder.icon);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return eventInfos.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
