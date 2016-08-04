package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by android on 8/2/2016.
 */
public class LoadOptionFields {
    private Context mContext;
    private View container;
    //Option Fields for setup drop down menu
    private TextView op_comapany;
    private TextView op_phone;
    private TextView op_email;
    private TextView op_city;
    private TextView op_state;
    private TextView op_photoCapture;
    private TextView op_zipCode;
    private TextView op_address;
    private TextView op_here_to_see;
    private TextView op_signatureCapture;
    private Database database;
    public LoadOptionFields(Context mContext,View container)
    {
        this.mContext = mContext;
        this.container = container;
    }

    public  void startLoading(){
        //INITIALIZING LAYOUT OPTION FIELDS
        op_city = (TextView)container.findViewById(R.id.op_city);
        op_address = (TextView)container.findViewById(R.id.op_address);
        op_zipCode = (TextView)container.findViewById(R.id.op_zip_code);
        op_state = (TextView)container.findViewById(R.id.op_state);
        op_photoCapture = (TextView)container.findViewById(R.id.op_photo_capture);
        op_email = (TextView)container.findViewById(R.id.op_email);
        op_comapany = (TextView)container.findViewById(R.id.op_company);
        op_phone = (TextView)container.findViewById(R.id.op_phone);
        op_here_to_see = (TextView)container.findViewById(R.id.op_here_to_see);
        op_signatureCapture =(TextView)container.findViewById(R.id.op_signature_capture);


        database = new Database(mContext);
        //LOAD VALUES FROM DATABASE TO LAYOUT OPTION FIELDS
        op_city.setText(database.isFieldEnabled("city"));
        op_phone.setText(database.isFieldEnabled("phone"));
        op_address.setText(database.isFieldEnabled("address"));
        op_state.setText(database.isFieldEnabled("state"));
        op_photoCapture.setText(database.isFieldEnabled("photo capture"));
        op_email.setText(database.isFieldEnabled("email"));
        op_zipCode.setText(database.isFieldEnabled("zip code"));
        op_here_to_see.setText(database.isFieldEnabled("here to see"));
        op_signatureCapture.setText(database.isFieldEnabled("signature capture"));
    }

}
