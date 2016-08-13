package singin.com.techcoda.signin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Muzammil on 6/16/2016.
 */
public class SignOut extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    EditText firstName;
    Button btnSignOut;
    ListView listOfVisitorsSigningOut;

    Database database;

    List<List<String>> name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_out_activity);

        database = new Database(this);

        firstName = (EditText) findViewById(R.id.et_signout_firstname);
        btnSignOut = (Button) findViewById(R.id.btn_signout);
        listOfVisitorsSigningOut = (ListView) findViewById(R.id.list_visitors_signout);

        btnSignOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getVisitors();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        signOutVisitor(position);
        getVisitors();

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void signOutVisitor(int position){

        String timeOut = new SimpleDateFormat("HH mm ss").format(new Date());
        List<String> visitorID = name.get(0);

        long rows = database.visitorSignOut(visitorID.get(position), timeOut, "gone");
        if (rows > 0){
            Toast.makeText(this, "Sign Out Successful", Toast.LENGTH_SHORT).show();
        }else{
            showDialog("Error Occured, Please Sign Out again");
        }
    }//end of signOutVisitor

    public void showDialog(String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);

//        alertDialogBuilder.setItems(path);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
//                        finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void getVisitors(){
        //Get all the visitors which are on premises
        name = database.getVisitorNameByFirstName(firstName.getText().toString(), "premises");
        AdapterSigningOutVisitors adapter = new AdapterSigningOutVisitors(this, name.get(0), name.get(1), name.get(2));
        listOfVisitorsSigningOut.setAdapter(adapter);
        listOfVisitorsSigningOut.setOnItemClickListener(this);
    }
}
