package de.smartformer.hoang.remotecontroll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.github.nkzawa.emitter.Emitter;
//import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Map;

//import de.smartformer.hoang.remotecontroll.models.ConsumerModel;
//
//
//public class BackupSecondActivity extends Activity implements View.OnClickListener{
//
//    private Button backBtn, upBtn, leftBtn, downBtn, rightBtn,
//            okBtn, redBtn, greenBtn, yellowBtn, blueBtn;
//    private String url = "http://78.47.52.172:31337";
//    private Socket socket;
//    private int deviceID;
//    private String deviceName;
//    private Map<String, Integer> keyCodeMap;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
//        Intent intent = getIntent();
//        ConsumerModel consumer = (ConsumerModel) intent.getSerializableExtra(FirstActivity.DEVICE_KEY);
//        deviceName = consumer.getName();
//        deviceID = consumer.getId();
//        keyCodeMap = consumer.getKeyCodeMap();
//        getActionBar().setTitle(deviceName);
//        initUI();
////        try {
////            initSocket();
////        } catch (URISyntaxException e) {
////            e.printStackTrace();
////        }
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.my, menu);
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
//        backBtn = (Button) findViewById(R.id.backButton);
//        upBtn = (Button) findViewById(R.id.upButton);
//        leftBtn = (Button) findViewById(R.id.leftButton);
//        rightBtn = (Button) findViewById(R.id.rightButton);
//        downBtn = (Button) findViewById(R.id.downButton);
//        okBtn = (Button) findViewById(R.id.okButton);
//        redBtn = (Button) findViewById(R.id.redButton);
//        greenBtn = (Button) findViewById(R.id.greenButton);
//        yellowBtn = (Button) findViewById(R.id.yellowButton);
//        blueBtn = (Button) findViewById(R.id.blueButton);
//
//        backBtn.setTag("VK_BACK");
//        upBtn.setTag("VK_UP");
//        leftBtn.setTag("VK_LEFT");
//        rightBtn.setTag("VK_RIGHT");
//        downBtn.setTag("VK_DOWN");
//        okBtn.setTag("VK_ENTER");
//        redBtn.setTag("VK_RED");
//        greenBtn.setTag("VK_GREEN");
//        yellowBtn.setTag("VK_YELLOW");
//        blueBtn.setTag("VK_BLUE");
//        setListener();
//    }
//
//    private void initSocket() throws URISyntaxException {
////        socket = IO.socket(url);
//
//        MySocket.socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                showToast("Connected to device " + deviceName);
//            }
//
//        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                showToast("Device " + deviceName + "  disconnected");
//            }
//
//        }).on(Socket.EVENT_ERROR, new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                showToast("Connection error with device " + deviceName);
//            }
//
//        });
////        socket.connect();
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
//
//    private void sendCommand(String key, int code) throws JSONException {
//        JSONObject jObj = new JSONObject();
//        JSONObject subJObj = new JSONObject();
//
//        jObj.put("deviceId", deviceID);
//        subJObj.put("key", key);
//        subJObj.put("code", code);
//        jObj.put("command", subJObj);
//
//        MySocket.socket.emit("command", jObj);
//    }
//
//    private void setListener(){
//        backBtn.setOnClickListener(this);
//        upBtn.setOnClickListener(this);
//        leftBtn.setOnClickListener(this);
//        rightBtn.setOnClickListener(this);
//        downBtn.setOnClickListener(this);
//        okBtn.setOnClickListener(this);
//        redBtn.setOnClickListener(this);
//        greenBtn.setOnClickListener(this);
//        yellowBtn.setOnClickListener(this);
//        blueBtn.setOnClickListener(this);
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        String key = (String) v.getTag();
//        if(MySocket.socket.connected()) {
//            try {
//                sendCommand(key, keyCodeMap.get(key));
//                showToast(key + " send");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        } else
//            showToast(key + " not send");
//    }
//}
