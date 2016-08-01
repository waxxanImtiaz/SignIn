package singin.com.techcoda.signin;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Muzammil on 6/15/2016.
 */
public class AdminPanel extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

    Database database;
    LinearLayout ll_in, ll_onpremises, ll_out;
    TextView counterSignIn, counterSignOut, counterOnPremises;
    ImageButton mDownloadImageButton;
    Button mDesignButton;
    Button mSetupButton;
    Button mReportButton;

    private DropDownMenus mDropDownMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        database = new Database(this);

        ll_in = (LinearLayout) findViewById(R.id.ll_signin);
        ll_onpremises = (LinearLayout) findViewById(R.id.ll_onpremises);
        ll_out = (LinearLayout) findViewById(R.id.ll_signout);

        mDropDownMenu = new DropDownMenus(getApplicationContext());
        mDropDownMenu.setCurrentDate();;
        mDropDownMenu.setReportMenu();
       // mDropDownMenu.setSetupMenu();
        mDropDownMenu.setDesignMenu();

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

        Toast.makeText(AdminPanel.this, "onCreate Method is called", Toast.LENGTH_SHORT).show();
        getAllCountersData();
    }


    public void getAllCountersData(){

        int in, out, onPremises;
        String date = new SimpleDateFormat("dd MM yyyy").format(new Date());

        in = database.getCountVisitorIn(date);
        out = database.getCountVisitorOut(date);
        onPremises = database.getCountVisitorOnPremises(date);

        counterSignIn.setText(String.valueOf(in));
        counterSignOut.setText(String.valueOf(out));
        counterOnPremises.setText(String.valueOf(onPremises));
    }//end of getAllCountersData

    @Override
    public void onClick(View v) {

//        Intent intent;

        switch(v.getId()) {

            case R.id.ll_signin:
                showDialogBoxSignIn();
                break;

            case R.id.ll_onpremises:
                showDialogBoxOnPremises();
                break;

            case R.id.ll_signout:
                showDialogBoxSignOut();
                break;
            case R.id.imgbtn_download:
                Toast.makeText(AdminPanel.this, "Image button is clicked clicked outside", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_report:
                mDropDownMenu.report_button_clicked(v);
                break;
            case R.id.btn_setup:
                mDropDownMenu.setup_button_clicked(v);
               // Toast.makeText(AdminPanel.this, "Setup button clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_design:
                mDropDownMenu.design_button_clicked(v);
                break;
//            case R.id.imgbtn_download:
//                Toast.makeText(AdminPanel.this, "Search button is clicked outside", Toast.LENGTH_SHORT).show();
//                 break;

        }
    }

    //Credentials for Dialog box
    ListView list;
    EditText firstName;
    Button search;

    List<List<String>> name;

    public void showDialogBoxOnPremises(){

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.list_of_onpremises);
        dialog.setCancelable(true);

        firstName = (EditText) dialog.findViewById(R.id.et_onpremises_firstname);
        list = (ListView) dialog.findViewById(R.id.list_onpremises);
        search = (Button) dialog.findViewById(R.id.btn_search_onpremises);
        mDownloadImageButton = (ImageButton)findViewById(R.id.imgbtn_download);

      //  mDownloadImageButton.setOnClickListener(this);
//        mDownloadImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(AdminPanel.this, "Image button is clicked clicked in onpremsis", Toast.LENGTH_SHORT).show();
//            }
//        });
        getAllVisitorOnPremises();//getting all visitors list - ON PREMISES




        search.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdminPanel.this, "Search button is clicked", Toast.LENGTH_SHORT).show();
                getAllVisitorOnPremisesByName();//getting all by name - ON PREMISES
            }
        });

        dialog.show();

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

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.list_of_onpremises);
        dialog.setCancelable(true);

        firstName = (EditText) dialog.findViewById(R.id.et_onpremises_firstname);
        list = (ListView) dialog.findViewById(R.id.list_onpremises);
        search = (Button) dialog.findViewById(R.id.btn_search_onpremises);
        mDownloadImageButton = (ImageButton)findViewById(R.id.imgbtn_download);


        Toast.makeText(AdminPanel.this, "Image button is clicked clicked in signin", Toast.LENGTH_SHORT).show();

//        mDownloadImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(AdminPanel.this, "Image button is clicked clicked in signin", Toast.LENGTH_SHORT).show();
//            }
//        });
        getAllVisitorSignIn();//getting all visitors in list

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllVisitorSignInByName();//getting sign in visitors by name
            }
        });


        dialog.show();
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

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.list_of_onpremises);
        dialog.setCancelable(true);

        firstName = (EditText) dialog.findViewById(R.id.et_onpremises_firstname);
        list = (ListView) dialog.findViewById(R.id.list_onpremises);
        search = (Button) dialog.findViewById(R.id.btn_search_onpremises);
        mDownloadImageButton = (ImageButton)findViewById(R.id.imgbtn_download);

        Toast.makeText(AdminPanel.this, "Image button is clicked on signout", Toast.LENGTH_SHORT).show();

//        mDownloadImageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(AdminPanel.this, "Image button is clicked on signout", Toast.LENGTH_SHORT).show();
//            }
//        });
        getAllVisitorsSignOutByName();//getting all visitors list - SIGN OUT

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllVisitorsSignOut();//getting all by name - SIGN OUT
            }
        });


        dialog.show();
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
}//end of class
