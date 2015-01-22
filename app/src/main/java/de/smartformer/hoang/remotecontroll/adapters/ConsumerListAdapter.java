package de.smartformer.hoang.remotecontroll.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.CheckedOutputStream;

import de.smartformer.hoang.remotecontroll.R;
import de.smartformer.hoang.remotecontroll.models.ConsumerModel;

/**
 * Created by hoang on 26.11.14.
 */
public class ConsumerListAdapter extends ArrayAdapter<ConsumerModel> {

    private Context context;
    private int layout;
    private List<ConsumerModel> consumerList;

    public ConsumerListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.consumerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.consumerNameTextView);
        textView.setText(consumerList.get(position).getName());
        return convertView;
    }
}
