package de.smartformer.hoang.remotecontroll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

//import com.github.nkzawa.emitter.Emitter;
//import com.github.nkzawa.socketio.client.IO;
//import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import de.smartformer.hoang.remotecontroll.adapters.ConsumerListAdapter;
import de.smartformer.hoang.remotecontroll.models.ConsumerModel;
import de.smartformer.hoang.remotecontroll.utils.Utils;


//public class BackupFirstActivity extends Activity implements AdapterView.OnItemClickListener {

//    private List<ConsumerModel> consumerList;
//    private ConsumerListAdapter adapter;
//
//    public static final String DEVICE_KEY = "deviceKey";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_first);
//        consumerList = new ArrayList<ConsumerModel>();
//        adapter = new ConsumerListAdapter(this, R.layout.listitem_consumer, consumerList);
//        initUI();
//
//        try {
//            initSocket();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.first, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void initUI() {
//        ListView consumerListView = (ListView) findViewById(R.id.comsumerListView);
//        consumerListView.setAdapter(adapter);
//        consumerListView.setOnItemClickListener(this);
//    }
//
//
//    private void initSocket() throws URISyntaxException {
//        String url = "http://78.47.52.172:31337";
//        MySocket.socket = IO.socket(url);
//        MySocket.socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                connectController();
//                showToast("Connected to server");
//            }
//        }).on("availableConsumers", new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                if (args.length > 0) {
//                    JSONArray jArray = (JSONArray) args[0];
//                    if (jArray != null) {
//                        List<ConsumerModel> newConsumerList = null;
//                        try {
//                            newConsumerList = Utils.parseDeviceJSONArray(jArray);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        updateMessageList(newConsumerList);
//                    }
//                }
//            }
//        }).on("newConsumer", new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                if (args.length > 0) {
//                    JSONObject jObj = (JSONObject) args[0];
//                    List<ConsumerModel> newConsumerList = new ArrayList<ConsumerModel>();
//                    try {
//                        newConsumerList.add(Utils.parseDeviceJSONObject(jObj));
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    updateMessageList(newConsumerList);
//                    showToast("New device connected");
//                }
//            }
//        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                updateMessageList();
//                showToast("Server disconnected");
//            }
//        }).on(Socket.EVENT_ERROR, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                showToast("Connection error!");
//            }
//        });
//        MySocket.socket.connect();
//    }
//
//    private void connectController() {
//        MySocket.socket.emit("connectController", android.os.Build.MODEL);
//    }
//
//    private void updateMessageList(final List<ConsumerModel> consumerList) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                adapter.addAll(consumerList);
//                adapter.notifyDataSetChanged();
//            }
//        });
//    }
//
//    private void updateMessageList() {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                adapter.clear();
//                adapter.notifyDataSetChanged();
//            }
//        });
//    }
//
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra(DEVICE_KEY, consumerList.get(position));
//
//        startActivity(intent);
//    }
//
//    private void showToast(final String text) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
