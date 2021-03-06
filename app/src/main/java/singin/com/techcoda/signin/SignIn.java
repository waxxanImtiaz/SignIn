package singin.com.techcoda.signin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.example.jamil.signinapp.*;
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
    EditText here_to_see;
    EditText badge_returned;
    EditText badge_number;
    EditText vehicle_make_model;
    EditText vehicle_color;
    EditText vehicle_lisence_plate;
    EditText comments;
    EditText guide_name;
    Button btn_signature_capture;
    CheckBox visitorAgreement;
    LinearLayout ll_visitor_agreement;
    //ImageView iv_sign_capture;
    Bitmap bitmap;
    Database database;
    private static String message;
    private boolean isEmailVisible;
    private List<String> visitor;
    private byte[] sign;
    private final int CAMERA = 0;
    private final int SIGNATURE = 12;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);


        setTheme(R.style.bold_itallic_font);
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
       // iv_sign_capture = (ImageView)findViewById(R.id.iv_sign_capture);
        city = (EditText)findViewById(R.id.et_city);
        zipCode = (EditText)findViewById(R.id.et_zipcode);
        state = (EditText)findViewById(R.id.et_state);
        phone = (EditText)findViewById(R.id.et_phone);
        guide_name = (EditText)findViewById(R.id.et_guide_escort_name);
        imageCaptureLayout  =(LinearLayout)findViewById(R.id.ll_image_capture);
        btn_image_capture = (Button)findViewById(R.id.btn_image_capture);
        iv_picture = (ImageView)findViewById(R.id.imageView);
        here_to_see = (EditText)findViewById(R.id.et_here_to_see);
        badge_number = (EditText)findViewById(R.id.et_badge_number);
        badge_returned = (EditText)findViewById(R.id.et_badge_returned);
        vehicle_make_model = (EditText)findViewById(R.id.et_vehicle_make_model);
        vehicle_color = (EditText)findViewById(R.id.et_vehicle_color);
        comments = (EditText)findViewById(R.id.et_comments);
        vehicle_lisence_plate = (EditText)findViewById(R.id.et_vehicle_lisence_plate);
        visitorAgreement = (CheckBox) findViewById(R.id.cb_visitor_agreement);
        ll_visitor_agreement = (LinearLayout)findViewById(R.id.ll_visitor_agreement);
        btn_signature_capture = (Button)findViewById(R.id.btn_signature_capture);


        btn_signature_capture.setOnClickListener(this);
        btn_image_capture.setOnClickListener(this);
        //iv_sign_capture.setVisibility(View.GONE);
        checkForFields();
        String currentDate = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
        tv_Date.setText(currentDate);

        signInBtn = (Button) findViewById(R.id.btn_signin);
        signInBtn.setOnClickListener(this);
        File photo = new File(getAlbumStorageDir("Signatures"), String.format("Signature_one.jpg", System.currentTimeMillis()));

        if(photo.exists())
        {
            photo.delete();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_signin:
                if(checkForInput(view)) {
                    insertVisitor();
                    Intent i = new Intent(SignIn.this, AdminPanel.class);
                    startActivity(i);
                }
                break;
            case R.id.btn_image_capture:
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA);
                //finish();
                break;
            case R.id.btn_signature_capture:
                Intent i = new Intent(SignIn.this,Signature.class);
                startActivityForResult(i,SIGNATURE);
                onPause();
//                finish();
                break;
        }
    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("SignaturePad", "Directory not created");
        }
        return file;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        flag = false;
        try {
            if (requestCode == CAMERA) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                if (bp != null)
                    iv_picture.setImageBitmap(bp);
            }

            if(requestCode == SIGNATURE) {
               sign = (byte[]) data.getExtras().get("signature");
               flag = true;
            }
        }catch(Exception e)
        {
            Log.d("Exception:",e.getMessage());
        }
    }//end of method
    @Override
    protected void onPause(){
        super.onPause();

    }
    public void insertVisitor(){

        visitor  = new ArrayList<String>();
        visitor.add("1");
        visitor.add(firstName.getText().toString());
        visitor.add(lastName.getText().toString());

        if(company.getVisibility() == View.VISIBLE )
            visitor.add(company.getText().toString());
        else visitor.add("N/A");

        if(address.getVisibility() == View.VISIBLE)
            visitor.add(address.getText().toString());
        else visitor.add("N/A");

        if(city.getVisibility() == View.VISIBLE )
            visitor.add(city.getText().toString());
        else visitor.add("N/A");

        if(email.getVisibility() == View.VISIBLE )
            visitor.add(email.getText().toString());
        else visitor.add("N/A");

        if(state.getVisibility() == View.VISIBLE )
            visitor.add(state.getText().toString());
        else visitor.add("N/A");

        if(zipCode.getVisibility() == View.VISIBLE )
            visitor.add(zipCode.getText().toString());
        else visitor.add("N/A");


        if(phone.getVisibility() == View.VISIBLE )
            visitor.add(phone.getText().toString());
        else visitor.add("N/A");

        if(here_to_see.getVisibility() == View.VISIBLE )
            visitor.add(here_to_see.getText().toString());
        else visitor.add("N/A");

        //SIGNATURE CAPTURE
        visitor.add("N/A");


        if(guide_name.getVisibility() == View.VISIBLE )
        visitor.add(guide_name.getText().toString());
        else visitor.add("N/A");


        if(badge_number.getVisibility() == View.VISIBLE )
            visitor.add(badge_number.getText().toString());
        else visitor.add("N/A");


        if(badge_returned.getVisibility() == View.VISIBLE )
            visitor.add(badge_returned.getText().toString());
        else visitor.add("N/A");


        if(vehicle_make_model.getVisibility() == View.VISIBLE )
            visitor.add(vehicle_make_model.getText().toString());
        else visitor.add("N/A");


        if(vehicle_color.getVisibility() == View.VISIBLE )
            visitor.add(vehicle_color.getText().toString());
        else visitor.add("N/A");


        if(vehicle_lisence_plate.getVisibility() == View.VISIBLE )
            visitor.add(vehicle_lisence_plate.getText().toString());
        else visitor.add("N/A");


        if(comments.getVisibility() == View.VISIBLE )
            visitor.add(comments.getText().toString());
        else visitor.add("N/A");


        if(visitorAgreement.getVisibility() == View.VISIBLE )
            if(visitorAgreement.isChecked())
                visitor.add("true");
            else visitor.add("false");
        else visitor.add("N/A");

        //Visitor signoutAgreement
        visitor.add("N/A");

        //visitor agreement text
        visitor.add("N/A");

        //status
        visitor.add("premises");

        //getBytes(iv_sign_capture)
        long rowsVisitor = database.insertVisitor(visitor,getBytes(iv_picture),null);
//        long rowsVisitor = database.insertVisitor("1", firstName.getText().toString(), lastName.getText().toString());

        if (rowsVisitor > 0){
            String visitorID = database.getVisitorID(); //always get last visitor id who has just signed in
            //CALL METHOD HERE TO GET CURRENT TIME STAMP
            String date, time;
            date = new SimpleDateFormat("dd MM yyyy").format(new Date());
            time = new SimpleDateFormat("HH mm ss").format(new Date());

            long rowsSignIn = database.insertVisitorIntoSingIn(visitorID, time, "premises", date);
            if (rowsSignIn > 0){
                Toast.makeText(this, "Visitor Saved..", Toast.LENGTH_SHORT).show();

//                if(isOnline())
//                {
//                    sendEmailToAdmin();
//                    Toast.makeText(this, "Email send to admin successfully..", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    Toast.makeText(this, "Email did not sent to Admin! No internet connection available..", Toast.LENGTH_SHORT).show();
//                }

            }
        }
        else{
            Toast.makeText(this, "Error while sign in...", Toast.LENGTH_SHORT).show();
        }

    }

    public byte[] getBytes(ImageView iv_picture)
    {
        BitmapDrawable drawable = (BitmapDrawable) iv_picture.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] img = bos.toByteArray();
        return  img;
    }//end of getBytes method..
    //CHECK FIELDS
    public void checkForFields(){
        String option = database.isFieldEnabled("company");
        //CHECK FOR COMPANY
        if(option.equals("Not Used"))
        {

           company.setVisibility(View.GONE);
        }
        else {
            company.setVisibility(View.VISIBLE);

        }


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

        option = database.isFieldEnabled("here to see");

        if(option != null && !option.equals("Not Used"))
            here_to_see.setVisibility(View.VISIBLE);
        else
            here_to_see.setVisibility(View.GONE);

        option = database.isFieldEnabled("guide escort");

        if(option != null && !option.equals("Not Used"))
            guide_name.setVisibility(View.VISIBLE);
        else
            guide_name.setVisibility(View.GONE);

        option = database.isFieldEnabled("badge returned");

        if(option != null && !option.equals("Not Used"))
            badge_returned.setVisibility(View.VISIBLE);
        else
           badge_returned.setVisibility(View.GONE);



        option = database.isFieldEnabled("badge number");

        if(option != null && !option.equals("Not Used"))
            badge_number.setVisibility(View.VISIBLE);
        else
            badge_number.setVisibility(View.GONE);

        option = database.isFieldEnabled("comments");

        if(option != null && !option.equals("Not Used"))
            comments.setVisibility(View.VISIBLE);
        else
            comments.setVisibility(View.GONE);

        option = database.isFieldEnabled("vehicle make model");
        if(option != null && !option.equals("Not Used"))
            vehicle_make_model.setVisibility(View.GONE);
        else
            vehicle_make_model.setVisibility(View.GONE);

        option = database.isFieldEnabled("vehicle_color");
        if(option != null && !option.equals("Not Used"))
            vehicle_color.setVisibility(View.VISIBLE);
        else
            vehicle_color.setVisibility(View.GONE);


        option = database.isFieldEnabled("vehicle lisence plate");

        if(option != null && !option.equals("Not Used"))
            vehicle_lisence_plate.setVisibility(View.VISIBLE);
        else
            vehicle_lisence_plate.setVisibility(View.GONE);

        option = database.isFieldEnabled("signin agreement");
        if(option != null && !option.equals("false"))
            ll_visitor_agreement.setVisibility(View.VISIBLE);
        else
            ll_visitor_agreement.setVisibility(View.GONE);

        option = database.isFieldEnabled("signature capture");
        if(option != null && !option.equals("false"))
            btn_signature_capture.setVisibility(View.VISIBLE);
        else
            btn_signature_capture.setVisibility(View.GONE);
    }//END OF CHECKFORFIELDS METHOD

    //CHECK FOR INPUT
    public boolean checkForInput(View view){
        String option = database.isFieldEnabled("company");

        if(firstName.getText().toString().isEmpty()){
            message = "First Name" +" field is empty";
            open(view);
            return false;
        }
        if(lastName.getText().toString().isEmpty()){
            message = "Last Name"+" field is empty";
            open(view);
            return false;
        }
        option = database.isFieldEnabled("city");

        if(option != null && option.equals("Mandatory"))
        {
            if(city.getText().toString().isEmpty()){
                message = "City"+" field is empty";
                open(view);
                return false;
            }
        }

        option = database.isFieldEnabled("company");

        if(option != null && option.equals("Mandatory"))
        {
            message = "Company"+" field is empty";

            if(company.getText().toString().isEmpty()){
                message = "Company"+" field is empty";
                open(view);
                return false;
            }
        }

        option = database.isFieldEnabled("address");
        if(option != null && option.equals("Mandatory"))
        {
            if(address.getText().toString().isEmpty()){
                message = "Address"+" field is empty";
                open(view);
                return false;
            }

        }


        option = database.isFieldEnabled("email");
        if(option != null && option.equals("Mandatory")) {
            if (email.getText().toString().isEmpty()) {
                isEmailVisible = true;
                if (email.getText().equals("")) {
                    message = "Email" + " field is empty";
                    open(view);
                    return false;
                }
            }
        }

         option = database.isFieldEnabled("signature capture");
        if(option != null && option.equals("Mandatory")) {
            if (!flag) {
                message = "Please Capture Signature before Sign In";
                open(view);
                return false;
            }
        }

        option = database.isFieldEnabled("guide escort");
        if(option != null && option.equals("Mandatory"))
        {
            if(guide_name.getText().toString().isEmpty())
            {
                isEmailVisible = true;
                if(guide_name.getText().equals("")){
                    message = "Guide/Escort Name"+" field is empty";
                    open(view);
                    return false;
                }
            }
        }

        option = database.isFieldEnabled("badge returned");
        if(option != null && option.equals("Mandatory"))
        {
            if(badge_returned.getText().toString().isEmpty())
            {
                isEmailVisible = true;
                if(badge_returned.getText().equals("")){
                    message = "Badge Returned"+" field is empty";
                    open(view);
                    return false;
                }
            }
        }

        option = database.isFieldEnabled("badge number");
        if(option != null && option.equals("Mandatory"))
        {
            if(badge_number.getText().toString().isEmpty())
            {
                isEmailVisible = true;
                if(badge_number.getText().equals("")){
                    message = "Badge Number"+" field is empty";
                    open(view);
                    return false;
                }
            }
        }

        option = database.isFieldEnabled("comments");
        if(option != null && option.equals("Mandatory"))
        {
            if(here_to_see.getText().toString().isEmpty())
            {
                isEmailVisible = true;
                if(comments.getText().equals("")){
                    message = "Comments"+" field is empty";
                    open(view);
                    return false;
                }
            }
        }


        option = database.isFieldEnabled("vehicle make/model");
        if(option != null && option.equals("Mandatory"))
        {
            if(vehicle_make_model.getText().toString().isEmpty())
            {
                isEmailVisible = true;
                if(vehicle_make_model.getText().equals("")){
                    message = "Vehicle Make/Model"+" field is empty";
                    open(view);
                    return false;
                }
            }
        }

        option = database.isFieldEnabled("vehicle color");
        if(option != null && option.equals("Mandatory"))
        {
            if(vehicle_color.getText().toString().isEmpty())
            {
                isEmailVisible = true;
                if(vehicle_color.getText().equals("")){
                    message = "Vehicle Color"+" field is empty";
                    open(view);
                    return false;
                }
            }
        }

        option = database.isFieldEnabled("vehicle lisence plate");
        if(option != null && option.equals("Mandatory"))
        {
            if(vehicle_lisence_plate.getText().toString().isEmpty())
            {
                isEmailVisible = true;
                if(vehicle_lisence_plate.getText().equals("")){
                    message = "Vehicle Lisense Plate"+" field is empty";
                    open(view);
                    return false;
                }
            }
        }

        option = database.isFieldEnabled("here to see");
        if(option != null && option.equals("Mandatory"))
        {
        if(here_to_see.getText().toString().isEmpty())
        {
            isEmailVisible = true;
            if(here_to_see.getText().equals("")){
                message = "Here To See"+" field is empty";
                open(view);
                return false;
            }
        }
        }
        option = database.isFieldEnabled("vehicle color");
        if(option != null && option.equals("Mandatory")) {
            if (vehicle_color.getText().toString().isEmpty()) {
                isEmailVisible = true;
                if (vehicle_color.getText().equals("")) {
                    message = "Vehicle Color" + " field is empty";
                    open(view);
                    return false;
                }
            }
        }
        option = database.isFieldEnabled("vehicle lisence plate");
        if( option != null && option.equals("Mandatory")) {
            if (vehicle_lisence_plate.getText().toString().isEmpty()) {
                isEmailVisible = true;
                if (vehicle_lisence_plate.getText().equals("")) {
                    message = "Vehicle Lisence Plate" + " field is empty";
                    open(view);
                    return false;
                }
            }
        }
        option = database.isFieldEnabled("vehicle make model");
        if(option != null && option.equals("Mandatory")) {
            if (vehicle_make_model.getText().toString().isEmpty()) {
                isEmailVisible = true;
                if (vehicle_make_model.getText().equals("")) {
                    message = "Vehicle Make/Model" + " field is empty";
                    open(view);
                    return false;
                }
            }
        }
        option = database.isFieldEnabled("comments");
        if( option != null && option.equals("Mandatory")) {

            if (comments.getText().toString().isEmpty()) {
                isEmailVisible = true;
                if (comments.getText().equals("")) {
                    message = "Comments" + " field is empty";
                    open(view);
                    return false;
                }
            }
        }

        option = database.isFieldEnabled("signin agreement");
        if(option != null && option.equals("true")) {
            if (!visitorAgreement.isChecked()) {
                isEmailVisible = true;
                if (vehicle_color.getText().equals("")) {
                    message = "Please Show Signin Agreement";
                    open(view);
                    return false;
                }
            }
        }

        return true;
    }//end of method checkForFields

//    public void sendEmailToAdmin(){
//        Intent emailIntent = new Intent();
//        emailIntent.setClassName("com.google.android.gms", "com.google.android.gms.ComposeActivityGmail");// Package Name, Class Name
//        emailIntent.setData(Uri.parse("mailto:"));
//        emailIntent.setType("text/plain");
//        emailIntent.putExtra(Intent.EXTRA_EMAIL, "waxxan.imtiaz.123@gmail.com");
//        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "New Visitor Signed In");
//        emailIntent.putExtra(Intent.EXTRA_TEXT, "First Name:"+firstName.getText().toString()+",Last Name:"+lastName.getText().toString());
//        try {
//            startActivity(emailIntent);
//        } catch(Exception ex) {
//            Toast.makeText(getApplicationContext(),"Email did not send",Toast.LENGTH_SHORT).show();
//        }
//    }
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(message);

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
              //
                // finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

//    public boolean isOnline() {
//        try {
//            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//            return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
//
//        } catch (Exception e) {
//            Toast.makeText(getApplicationContext(), "Error while checking for wifi", Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
//    public void showDialog(String message){
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        alertDialogBuilder.setMessage(message);
//
////        alertDialogBuilder.setItems(path);
//        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface arg0, int arg1) {
////                        finish();
//            }
//        });
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }
}
