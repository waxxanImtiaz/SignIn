package singin.com.techcoda.signin;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jamil.signinapp.PrintReport;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Muzammil on 6/15/2016.
 */
public class AdminPanel extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    Database database;
    private LinearLayout rlBackground;
    LinearLayout ll_in, ll_onpremises, ll_out;
    TextView counterSignIn, counterSignOut, counterOnPremises;
    ImageButton mDownloadImageButton;
    Button mDesignButton;
    Button mSetupButton;
    Button mReportButton;
    private LinearLayout countersButtonClicked;
    PopupWindowHandler handler;
    private DropDownMenus mDropDownMenu;
    String flag;
    Dialog onPremsisDialog;
    Dialog onSignInDialog;
    Dialog onSignOutDialog;
    PdfCreater pdfCreater;
    String status;
    File file;
    Intent i;
    String state;
    String date;
    boolean isPrintReportClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        pdfCreater = new PdfCreater(this);
        database = new Database(this);
        handler = new PopupWindowHandler(getApplicationContext());
        ll_in = (LinearLayout) findViewById(R.id.ll_signin);
        ll_onpremises = (LinearLayout) findViewById(R.id.ll_onpremises);
        ll_out = (LinearLayout) findViewById(R.id.ll_signout);

        mDropDownMenu = new DropDownMenus(getApplicationContext());
        mDropDownMenu.setCurrentDate();;
        mDropDownMenu.setReportMenu();
       // mDropDownMenu.setSetupMenu();
        mDropDownMenu.setDesignMenu();
        initComponenets();
        mSetupButton = (Button)findViewById(R.id.btn_setup);
        mReportButton = (Button)findViewById(R.id.btn_report);
        mDesignButton = (Button)findViewById(R.id.btn_design);

        mDesignButton.setOnClickListener(this);
        mSetupButton.setOnClickListener(this);
        ll_in.setOnClickListener(this);
        ll_onpremises.setOnClickListener(this);
        mReportButton.setOnClickListener(this);
        ll_out.setOnClickListener(this);


        counterSignIn = (TextView) findViewById(R.id.tv_counter_signin);
        counterSignOut = (TextView) findViewById(R.id.tv_counter_signout);
        counterOnPremises = (TextView) findViewById(R.id.tv_counter_onpremises);

        i = new Intent(this, PrintReport.class);
        Toast.makeText(AdminPanel.this, "onCreate Method is called", Toast.LENGTH_SHORT).show();
        getAllCountersData();
    }


    public void checkButtonClickAndDismiss(){

            if(flag != null && flag.equals( "onpremises") )
            {
                onPremsisDialog.dismiss();
            }else if(flag != null && flag.equals( "signin") )
            {
                onSignInDialog.dismiss();
            }else if(flag != null && flag.equals( "signout"))
            {
                onSignOutDialog.dismiss();
            }
        statusButtonClicked();
    }
    public void getAllCountersData(){

        int in, out, onPremises;
        date = new SimpleDateFormat("dd MM yyyy").format(new Date());

        in = database.getCountVisitorIn(date);
        out = database.getCountVisitorOut(date);
        onPremises = database.getCountVisitorOnPremises(date);

        counterSignIn.setText(String.valueOf(in));
        counterSignOut.setText(String.valueOf(out));
        counterOnPremises.setText(String.valueOf(onPremises));
    }//end of getAllCountersData

    @Override
    public void onClick(View v) {
        switch(v.getId()) {

            case R.id.ll_signin:
                setCountersButtonClicked(ll_in);
                flag = "signin";
                state = "in";
                showDialogBoxSignIn();
                break;

            case R.id.ll_onpremises:
                setCountersButtonClicked(ll_onpremises);
                showDialogBoxOnPremises();
                flag = "onpremises";
                state = "premises";
                setCountersButtonClicked(ll_onpremises);
                break;

            case R.id.ll_signout:
                setCountersButtonClicked(ll_out);
                flag = "signout";
                state = "gone";
                showDialogBoxSignOut();
                break;
            case R.id.download_btn_image:
                checkButtonClickAndDismiss();
                break;
            case R.id.btn_report:
                mDropDownMenu.report_button_clicked(v);
                break;
            case R.id.btn_setup:
                mDropDownMenu.setup_button_clicked(v);
                break;
            case R.id.btn_design:
                mDropDownMenu.design_button_clicked(v);
                break;

            case R.id.btn_delete_records:
                int rows =0;
                if(!equals("in"))
                 rows = database.deleteAllVisitorsOn(state,date);
                else{
                    rows = database.deleteAllVisitorsOn(state,date);
                }
                resetCounters(rows);
                    break;
            case R.id.btn_print_reports:
                i.putExtra("clickedOn",state);
                startActivity(i);
                break;
            case R.id.btn_email_report_pdf:
                pdfCreater = new PdfCreater(getApplicationContext());


                if(state.equals("premises") || state.equals("gone") ){

                    if(state.equals("gone")) {
                        name = database.getAllVisitorsListUsingStatus(state);
                    }
                    else
                    {
                        name = database.getAllVisitorsListUsingStatus("premises");
                    }
                }
                else {
                    name = database.getAllVisitorsList();
                }
                if(pdfCreater.createPDF(name,flag,state)){
                    //showDialog("pdf created successfully");
                    emailReport();
                }
                else
                    showDialog("pdf not created");
                break;
            //END OF CASE

            }
    }//End of onClick method


    public void resetCounters(int rows)
    {

            showDialog("All Visitors "+flag+" deleted successfully");
            if(state.equals("in")){
                counterSignIn.setText("0");
                counterSignOut.setText("0");
                counterOnPremises.setText("0");
            }
            else if(state.equals("gone")){
                counterSignOut.setText("0");
            }
            else {
                counterOnPremises.setText("0");

            }
        if(rows > 0){
            showDialog("Status is empty");
        }


    }
    //Credentials for Dialog box
    ListView list;
    EditText firstName;
    Button search;

    List<List<String>> name;

    public void showDialogBoxOnPremises(){

        onPremsisDialog = new Dialog(this);
        onPremsisDialog.setContentView(R.layout.list_of_onpremises);
        onPremsisDialog.setCancelable(true);

        firstName = (EditText) onPremsisDialog.findViewById(R.id.et_onpremises_firstname);
        list = (ListView) onPremsisDialog.findViewById(R.id.list_onpremises);
        search = (Button) onPremsisDialog.findViewById(R.id.btn_search_onpremises);
        mDownloadImageButton = (ImageButton)onPremsisDialog.findViewById(R.id.download_btn_image);

        mDownloadImageButton.setOnClickListener(this);
        getAllVisitorOnPremises();//getting all visitors list - ON PREMISES

        search.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminPanel.this, "Search button is clicked", Toast.LENGTH_SHORT).show();
                getAllVisitorOnPremisesByName();//getting all by name - ON PREMISES
            }
        });
        onPremsisDialog.show();

    }

    public void getAllVisitorOnPremises(){

        //Get all the visitors which are on premises
        name = database.getAllVisitorsListByStatus("premises");
        AdapterSigningOutVisitors adapter = new AdapterSigningOutVisitors(this, name.get(0), name.get(1), name.get(2));
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    public void getAllVisitorOnPremisesByName(){

        //Get all the visitors which are on premises
        name = database.getVisitorNameByFirstName(firstName.getText().toString(), "premises");
        AdapterSigningOutVisitors adapter = new AdapterSigningOutVisitors(this, name.get(0), name.get(1), name.get(2));
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }


    //SIGN IN LIST
    public void showDialogBoxSignIn(){

        onSignInDialog = new Dialog(this);
        onSignInDialog.setContentView(R.layout.list_of_onpremises);
        onSignInDialog.setCancelable(true);

        firstName = (EditText) onSignInDialog.findViewById(R.id.et_onpremises_firstname);
        list = (ListView) onSignInDialog.findViewById(R.id.list_onpremises);
        search = (Button) onSignInDialog.findViewById(R.id.btn_search_onpremises);
        mDownloadImageButton = (ImageButton)onSignInDialog.findViewById(R.id.download_btn_image);

        getAllVisitorSignIn();
        mDownloadImageButton.setOnClickListener(this);//getting all visitors in list
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminPanel.this, "Search button is clicked clicked in signin", Toast.LENGTH_SHORT).show();

                getAllVisitorSignInByName();//getting sign in visitors by name
            }
        });
        onSignInDialog.show();
    }

    public void getAllVisitorSignIn(){
        //Get all the visitors which are on premises
        name = database.getAllVisitorsList(); //get list of visitors who sign in today
        AdapterSigningOutVisitors adapter = new AdapterSigningOutVisitors(this, name.get(0), name.get(1), name.get(2));
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    public void getAllVisitorSignInByName(){

        //Get all the visitors which are on premises
        name = database.getVisitorNameByFirstNameForSignIn(firstName.getText().toString()); //get list of visitors who sign in today
        AdapterSigningOutVisitors adapter = new AdapterSigningOutVisitors(this, name.get(0), name.get(1), name.get(2));
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }


    //SIGN OUT LIST
    public void showDialogBoxSignOut(){

        onSignOutDialog = new Dialog(this);
        onSignOutDialog.setContentView(R.layout.list_of_onpremises);
        onSignOutDialog.setCancelable(true);

        firstName = (EditText) onSignOutDialog.findViewById(R.id.et_onpremises_firstname);
        list = (ListView) onSignOutDialog.findViewById(R.id.list_onpremises);
        search = (Button) onSignOutDialog.findViewById(R.id.btn_search_onpremises);
        mDownloadImageButton = (ImageButton)onSignOutDialog.findViewById(R.id.download_btn_image);

        getAllVisitorsSignOutByName();//getting all visitors list - SIGN OUT

        mDownloadImageButton.setOnClickListener(this);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllVisitorsSignOut();//getting all by name - SIGN OUT
            }
        });


        onSignOutDialog.show();
    }//end of showDialogBoxSignOut method..

    public void getAllVisitorsSignOutByName(){
        //Get all the visitors which are on premises
        name = database.getAllVisitorsListByStatus("gone");
        AdapterSigningOutVisitors adapter = new AdapterSigningOutVisitors(this, name.get(0), name.get(1), name.get(2));
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    public void getAllVisitorsSignOut(){
        //Get all the visitors which are on premises
        name = database.getVisitorNameByFirstName(firstName.getText().toString(), "gone");
        AdapterSigningOutVisitors adapter = new AdapterSigningOutVisitors(this, name.get(0), name.get(1), name.get(2));
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Pos: " + position, Toast.LENGTH_SHORT).show();
    }

    //INITIALIZE COMPONENTS
    private void initComponenets(){
        rlBackground = (LinearLayout) findViewById(R.id.signin_activity);

        rlBackground.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                int[] location = new int[2];
                location[0] = (int) event.getX();
                location[1] = (int) event.getY();
                location[1] = location[1] + getActionBarHeight() + getStatusBarHeight();
                return false;
            }
        });
    }

    private void statusButtonClicked(){
        EasyDialog dialog;
        if (getCountersButtonClicked() == ll_onpremises )
        {
            status = "onpremises";
                  dialog =  new EasyDialog(AdminPanel.this);
                 dialog.setLayoutResourceId(R.layout.counters_popup)
//                .setBackgroundColor(AdminPanel.this.getResources().getColor(R.color.background_color_blue))
                .setLocationByAttachedView(getCountersButtonClicked())
                .setAnimationTranslationShow(EasyDialog.DIRECTION_Y, 1000, -800, 100, -50, 50, 0)
                .setAnimationTranslationDismiss(EasyDialog.DIRECTION_Y, 500, 0, -800)
                .setGravity(EasyDialog.GRAVITY_TOP)
                .setTouchOutsideDismiss(true)
                .setMatchParent(false)
                .setMarginLeftAndRight(24, 24)
                .show();
                Fields.initializeImageButtonPopupMenu(dialog.contentView);
                initializeHandler();

        }
        else if(getCountersButtonClicked() == ll_out) {
            status = "signout";
            dialog =  new EasyDialog(AdminPanel.this);
            dialog.setLayoutResourceId(R.layout.counters_popup)
                    // .setBackgroundColor(AdminPanel.this.getResources().getColor(R.color.background_color_blue))
                    .setLocationByAttachedView(getCountersButtonClicked())
                    .setGravity(EasyDialog.GRAVITY_LEFT)
                    .setAnimationAlphaShow(300, 0.0f, 1.0f)
                    .setAnimationAlphaDismiss(300, 1.0f, 0.0f)
                    .setTouchOutsideDismiss(true)
                    .setMatchParent(false).show();
            Fields.initializeImageButtonPopupMenu(dialog.contentView);
            initializeHandler();
        }
        else
        {
            status = "signin";
            dialog =  new EasyDialog(AdminPanel.this);
            dialog.setLayoutResourceId(R.layout.counters_popup)
                    .setLocationByAttachedView(ll_in)
                    .setGravity(EasyDialog.GRAVITY_RIGHT)
                    .setAnimationAlphaShow(300, 0.0f, 1.0f)
                    .setAnimationAlphaDismiss(300, 1.0f, 0.0f)
                    .setTouchOutsideDismiss(true)
                    .setMatchParent(false)
                    .show();
            Fields.initializeImageButtonPopupMenu(dialog.contentView);
            initializeHandler();
//            if (Fields.reportDropDownHandler.isPdfCreated())
//            {
//                showDialog("signin.pdf file is created at "+Fields.reportDropDownHandler.getPath());
//            }
//
        }

    }

    private void initializeHandler(){
        Fields.btn_delete_records.setOnClickListener(this);
        Fields.btn_email_report_pdf.setOnClickListener(this);
        Fields.btn_print_reports.setOnClickListener(this);
        Fields.btn_email_search_data_csv.setOnClickListener(this);
        Fields.btn_export.setOnClickListener(this);

    }
    private int getStatusBarHeight()
    {
        int result = 0;
        int resourceId = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = this.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    private int getActionBarHeight()
    {

        return this.getStatusBarHeight();
    }

    public LinearLayout getCountersButtonClicked() {
        return countersButtonClicked;
    }

    public void setCountersButtonClicked(LinearLayout countersButtonClicked) {
        this.countersButtonClicked = countersButtonClicked;
    }
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
    @Override
    public void onBackPressed(){
        if(file != null && file.exists() && isPrintReportClicked)
        {
         file.delete();
        }

        super.onBackPressed();
    }

    public void emailReport(){
        Toast.makeText(AdminPanel.this, "\"Send email\"", Toast.LENGTH_SHORT).show();
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"Email address"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        email.putExtra(Intent.EXTRA_STREAM,Uri.fromFile(new File(pdfCreater.path+"/"+flag+".pdf")));
        email.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //need this to prompts email client only
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
        //isEmailSend = true;
    }
}//end of class
