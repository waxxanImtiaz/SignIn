package singin.com.techcoda.signin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muzammil on 6/16/2016.
 */
public class AdapterSigningOutVisitors extends BaseAdapter {

    Activity activity;
    List<String> id = new ArrayList<String>();
    List<String> firstName = new ArrayList<String>();
    List<String> lastName = new ArrayList<String>();
    private static LayoutInflater inflater = null;

    public AdapterSigningOutVisitors(Activity activity, List<String> id, List<String> firstName, List<String> lastName){
        this.activity = activity;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return firstName.size();
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

        View rowView = inflater.inflate(R.layout.single_signout_visitor_list, null);

        TextView f_name = (TextView) rowView.findViewById(R.id.tv_visitor_firstName);
        TextView l_name = (TextView) rowView.findViewById(R.id.tv_visitor_lastName);

        f_name.setText(firstName.get(position));
        l_name.setText(lastName.get(position));

        return rowView;
    }
}
