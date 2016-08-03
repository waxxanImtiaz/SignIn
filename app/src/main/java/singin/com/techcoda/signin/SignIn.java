package singin.com.techcoda.signin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    EditText company;
    EditText address;
    EditText city;
    EditText zipCode;
    EditText state;
    EditText phone;
    EditText email;
    LinearLayout imageCaptureLayout;
    Button btn_image_capture;
    ImageView iv_picture;
    Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);

        database = new Database(this);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.cat);
        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);

        ImageView circularImageView = (ImageView)findViewById(R.id.imageView);
        circularImageView.setImageBitmap(circularBitmap);


        firstName = (EditText) findViewById(R.id.et_firstname);
        lastName = (EditText) findViewById(R.id.et_lastname);
        tv_Date = (TextView) findViewById(R.id.tv_date);
        company = (EditText)findViewById(R.id.et_company);
        address = (EditText)findViewById(R.id.et_address);
        email = (EditText)findViewById(R.id.et_email);
        city = (EditText)findViewById(R.id.et_city);
        zipCode = (EditText)findViewById(R.id.et_zipcode);
        state = (EditText)findViewById(R.id.et_state);
        phone = (EditText)findViewById(R.id.et_phone);
        imageCaptureLayout  =(LinearLayout)findViewById(R.id.ll_image_capture);
        btn_image_capture = (Button)findViewById(R.id.btn_image_capture);
        iv_picture = (ImageView)findViewById(R.id.imageView);


        btn_image_capture.setOnClickListener(this);
        checkForFields();
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
            case R.id.btn_image_capture:
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        iv_picture.setImageBitmap(bp);
        //iv_picture.setImageBitmap(ImageConverter.getRoundedCornerBitmap(bp,100));
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

    //CHECK FIELDS
    public void checkForFields(){
        String option = database.isFieldEnabled("company");
        //CHECK FOR COMPANY
        if(option.equals("Not Used"))
        {
           company.setVisibility(View.GONE);
        }
        else
            company.setVisibility(View.VISIBLE);


        //CHECK FOR ADDRESS
        option = database.isFieldEnabled("address");
        if(option.equals("Not Used"))
        {
            address.setVisibility(View.GONE);
        }
        else
            address.setVisibility(View.VISIBLE);

        //CHECK FOR CITY
        option = database.isFieldEnabled("city");
        if(option.equals("Not Used"))
        {
            city.setVisibility(View.GONE);
        }
        else
            city.setVisibility(View.VISIBLE);

        //CHECK FOR STATE
        option = database.isFieldEnabled("state");
        if(option.equals("Not Used"))
        {
            state.setVisibility(View.GONE);
        }
        else
            state.setVisibility(View.VISIBLE);

        //CHECK FOR ZIPCODE
        option = database.isFieldEnabled("zip code");
        if(option.equals("Not Used"))
        {
            zipCode.setVisibility(View.GONE);
        }
        else
            zipCode.setVisibility(View.VISIBLE);
        //CHECK FOR PHONE
        option = database.isFieldEnabled("phone");
        if(option.equals("Not Used"))
        {
            phone.setVisibility(View.GONE);
        }
        else
            phone.setVisibility(View.VISIBLE);
        //CHECK FOR EMAIL
        option = database.isFieldEnabled("email");
        if(option.equals("Not Used"))
        {
            email.setVisibility(View.GONE);
        }
        else
            email.setVisibility(View.VISIBLE);
        //CHECK FOR IMAGE CAPTURE
        option = database.isFieldEnabled("photo capture");
        if(!option.equals("Not Used"))
            imageCaptureLayout.setVisibility(View.VISIBLE);
    }//END OF CHECKFORFIELDS METHOD
}
