package singin.com.techcoda.signin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by apple on 6/15/16.
 */
public class SignIn extends Activity implements View.OnClickListener {


    Button signInBtn;
    TextView tv_Date;
    EditText firstName, lastName;


    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        database = new Database(this);

        firstName = (EditText) findViewById(R.id.et_firstname);
        lastName = (EditText) findViewById(R.id.et_lastname);
        tv_Date = (TextView) findViewById(R.id.tv_date);

        String currentDate = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
        tv_Date.setText(currentDate);

        signInBtn = (Button) findViewById(R.id.btn_signin);
        signInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_signin:
                insertVisitor();
                Intent i = new Intent(SignIn.this,AdminPanel.class);
                startActivity(i);
                break;
        }


    }


    public void insertVisitor(){

        long rowsVisitor = database.insertVisitor("1", firstName.getText().toString(), lastName.getText().toString());
        if (rowsVisitor > 0){
            String visitorID = database.getVisitorID(); //always get last visitor id who has just signed in
            //CALL METHOD HERE TO GET CURRENT TIME STAMP
            String date, time;
            date = new SimpleDateFormat("dd MM yyyy").format(new Date());
            time = new SimpleDateFormat("HH mm ss").format(new Date());

            long rowsSignIn = database.insertVisitorIntoSingIn(visitorID, time, "premises", date);
            if (rowsSignIn > 0){
                Toast.makeText(this, "Visitor Saved..", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Error while sign in...", Toast.LENGTH_SHORT).show();
        }

    }
}
