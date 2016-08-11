package com.example.jamil.signinapp;
import singin.com.techcoda.signin.*;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

import singin.com.techcoda.signin.R;

public class PrintReport extends Activity {
    TextView tv_heading;
    Database database;
    String flag;
    List<List<String>> name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_report_layout);
        tv_heading = (TextView)findViewById(R.id.tv_heading);
        database = new Database(this);
        Intent intent = getIntent();
        flag = intent.getStringExtra("clickedOn");
        printReportOfUsers(flag);
    }


    public void printReportOfUsers(String action) {

        if(action.equals("premises") || action.equals("gone") ){

            if(action.equals("gone")) {
                tv_heading.setText("Total Visitors Signed Out");
                name = database.getAllVisitorsListUsingStatus(action);
            }
            else
            {
                name = database.getAllVisitorsListUsingStatus("premises");
                tv_heading.setText("Total Visitors OnPremses");
            }
        }
        else {
            name = database.getAllVisitorsList("in");
            tv_heading.setText("Total Visitors Signed In");
        }

        List<String> id = name.get(0);
        List<String> first = name.get(1);
        List<String> last = name.get(2);
        List<String> company =  name.get(20);
        List<String> email = name.get(4);
        List<String> state = name.get(5);
        List<String> address = name.get(6);
        List<String> hereToSee =name.get(7);
        List<String> zipCode = name.get(8);
        List<String> phone = name.get(9);
        List<String> signatureCapture = name.get(10);
        List<String> badgeReturned = name.get(11);
        List<String> badgeNumber = name.get(12);
        List<String> vehicleMakeModel = name.get(13);
        List<String> vehicleColor =name.get(14);
        List<String> vehicleLisencePlate = name.get(15);
        List<String> comments = name.get(16);
        List<String> visitorAgreementText = name.get(17);
        List<String> visitorSignInAgreement = name.get(18);
        List<String> visitorSignOutAgreement = name.get(19);
        List<String> city = name.get(3);


        TableLayout stk = (TableLayout) findViewById(R.id.table_main);


        TableRow tbrow0 = new TableRow(this);



        TextView tv0 = new TextView(this);
        tv0.setText(" ID ");
        tv0.setTextSize(25);
        tv0.setPadding(10,10,10,10);
        tv0.setTextColor(Color.BLACK);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText(" First Name ");
        tv1.setPadding(10,10,10,10);
        tv1.setTextSize(25);
        tv1.setTextColor(Color.BLACK);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" Last Name ");
        tv2.setTextSize(25);
        tv2.setPadding(10,10,10,10);
        tv2.setTextColor(Color.BLACK);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Visitor Sign In Agreement "); //Visitor sign in agreement
        tv3.setTextSize(25);
        tv3.setPadding(10,10,10,10);
        tv3.setTextColor(Color.BLACK);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText(" Address ");
        tv4.setPadding(10,10,10,10);
        tv4.setTextSize(25);
        tv4.setTextColor(Color.BLACK);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(this);
        tv5.setText(" Photo Capture ");//photo capture
        tv5.setPadding(10,10,10,10);
        tv5.setTextSize(25);
        tv5.setTextColor(Color.BLACK);
        tbrow0.addView(tv5);

        TextView tv6 = new TextView(this);
        tv6.setText(" Company ");
        tv6.setTextSize(25);
        tv6.setPadding(10,10,10,10);
        tv6.setTextColor(Color.BLACK);
        tbrow0.addView(tv6);

        TextView tv7 = new TextView(this);
        tv7.setText(" Comments ");//comments
        tv7.setTextSize(25);
        tv7.setPadding(10,10,10,10);
        tv7.setTextColor(Color.BLACK);
        tbrow0.addView(tv7);


        TextView tv8 = new TextView(this);
        tv8.setText(" City ");//visitor sign in agreemnet
        tv8.setTextSize(25);
        tv8.setPadding(10,10,10,10);
        tv8.setTextColor(Color.BLACK);
        tbrow0.addView(tv8);


        TextView tv9 = new TextView(this);
        tv9.setText(" Email ");
        tv9.setTextSize(25);
        tv9.setPadding(10,10,10,10);
        tv9.setTextColor(Color.BLACK);
        tbrow0.addView(tv9);


        TextView tv10 = new TextView(this);
        tv10.setText(" State ");//state
        tv10.setTextColor(Color.BLACK);
        tv10.setTextSize(25);
        tv10.setPadding(10,10,10,10);
        tbrow0.addView(tv10);


        TextView tv11 = new TextView(this);
        tv11.setText(" Guide/Escort Name ");//GUIDE/ESCORT NAME
        tv11.setTextColor(Color.BLACK);
        tv11.setTextSize(25);
        tv11.setPadding(10,10,10,10);
        tbrow0.addView(tv11);


        TextView tv12 = new TextView(this);
        tv12.setText(" Badge Number ");
        tv12.setTextColor(Color.BLACK);
        tv12.setPadding(10,10,10,10);
        tv12.setTextSize(25);
        tbrow0.addView(tv12);


        TextView tv13 = new TextView(this);
        tv13.setText(" Here To See ");
        tv13.setPadding(10,10,10,10);
        tv13.setTextSize(25);
        tv13.setTextColor(Color.BLACK);
        tbrow0.addView(tv13);



        TextView tv14 = new TextView(this);
        tv14.setText(" Badge Returned ");//badge returned
        tv14.setTextColor(Color.BLACK);
        tv14.setTextSize(25);
        tv14.setPadding(10,10,10,10);
        tbrow0.addView(tv14);


        TextView tv15 = new TextView(this);
        tv15.setText(" Vehicle Lisence Plate ");//vehicle lisence plate
        tv15.setPadding(10,10,10,10);
        tv15.setTextSize(25);
        tv15.setTextColor(Color.BLACK);
        tbrow0.addView(tv15);


        TextView tv16 = new TextView(this);
        tv16.setText(" Vehicle Color ");//vehicle color
        tv16.setTextColor(Color.BLACK);
        tv16.setTextSize(25);
        tv16.setPadding(10,10,10,10);
        tbrow0.addView(tv16);


        TextView tv17 = new TextView(this);
        tv17.setText(" Vehicle Make/Model");//vehicle make model
        tv17.setPadding(10,10,10,10);
        tv17.setTextSize(25);
        tv17.setTextColor(Color.BLACK);
        tbrow0.addView(tv17);


        TextView tv18 = new TextView(this);
        tv18.setText(" Phone ");//Phone
        tv18.setTextColor(Color.BLACK);
        tv18.setTextSize(25);
        tv18.setPadding(10,10,10,10);
        tbrow0.addView(tv18);


        TextView tv19 = new TextView(this);
        tv19.setText(" Visitor Agreement Text");//city
        tv19.setTextColor(Color.BLACK);
        tv19.setTextSize(25);
        tv19.setPadding(10,10,10,10);
        tbrow0.addView(tv19);


//        TextView tv20 = new TextView(this);
//        tv20.setText(" Visitor Agreement Text ");//visitor agreement text
//        tv20.setTextColor(Color.BLACK);
//        tv20.setPadding(10,10,10,10);
//        tv20.setTextSize(25);
//        tbrow0.addView(tv20);

        TextView tv21 = new TextView(this);
        tv21.setText("\t\t\t\t ");
        tv21.setTextColor(Color.BLACK);
        tbrow0.addView(tv21);

        tbrow0.setPadding(10,10,10,10);
        stk.addView(tbrow0);


        for (int i = 0; i < id.size(); i++)
        {

            TableRow tbrow = new TableRow(this);
            tbrow.setPadding(10,10,10,10);

            TextView t1v = new TextView(this);
            t1v.setText(id.get(i));
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            t1v.setTextSize(15);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setTextSize(15);
            t2v.setText(first.get(i));
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setTextSize(15);
            t3v.setText(last.get(i));
            t3v.setTextColor(Color.BLACK);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);

            TextView t4v = new TextView(this);
            t4v.setTextSize(15);
            t4v.setText( company.get(i));
            t4v.setTextColor(Color.BLACK);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);

            TextView t5v = new TextView(this);
            t5v.setTextSize(15);
            t5v.setText( address.get(i));
            t5v.setTextColor(Color.BLACK);
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);

            TextView t6v = new TextView(this);
            t6v.setText( phone.get(i));
            t6v.setTextSize(15);
            t6v.setTextColor(Color.BLACK);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);

            TextView t7v = new TextView(this);
            t7v.setTextSize(15);
            t7v.setText( email.get(i));
            t7v.setTextColor(Color.BLACK);
            t7v.setGravity(Gravity.CENTER);
            tbrow.addView(t7v);

            TextView t8v = new TextView(this);
            t8v.setTextSize(15);
            t8v.setText(state.get(i));
            t8v.setTextColor(Color.BLACK);
            t8v.setGravity(Gravity.CENTER);
            tbrow.addView(t8v);

            TextView t9v = new TextView(this);
            t9v.setTextSize(15);
            t9v.setText(city.get(i));
            t9v.setTextColor(Color.BLACK);
            t9v.setGravity(Gravity.CENTER);
            tbrow.addView(t9v);

            TextView t10v = new TextView(this);
            t10v.setTextSize(15);
            t10v.setText(zipCode.get(i));
            t10v.setTextColor(Color.BLACK);
            t10v.setGravity(Gravity.CENTER);
            tbrow.addView(t10v);

            TextView t11v = new TextView(this);
            t11v.setTextSize(15);
            t11v.setText( signatureCapture.get(i));
            t11v.setTextColor(Color.BLACK);
            t11v.setGravity(Gravity.CENTER);
            tbrow.addView(t11v);

            TextView t12v = new TextView(this);
            t12v.setTextSize(15);
            t12v.setText(badgeReturned.get(i));
            t12v.setTextColor(Color.BLACK);
            t12v.setGravity(Gravity.CENTER);
            tbrow.addView(t12v);

            TextView t13v = new TextView(this);
            t13v.setText( badgeNumber.get(i));
            t13v.setTextColor(Color.BLACK);
            t13v.setGravity(Gravity.CENTER);
            tbrow.addView(t13v);

            TextView t14v = new TextView(this);
            t14v.setTextSize(15);
            t14v.setText(hereToSee.get(i));
            t14v.setTextColor(Color.BLACK);
            t14v.setGravity(Gravity.CENTER);
            tbrow.addView(t14v);

            TextView t15v = new TextView(this);
            t15v.setText(vehicleMakeModel.get(i));
            t15v.setTextColor(Color.BLACK);
            t15v.setTextSize(15);
            t15v.setGravity(Gravity.CENTER);
            tbrow.addView(t15v);

            TextView t16v = new TextView(this);
            t16v.setTextSize(15);
            t16v.setText(vehicleColor.get(i));
            t16v.setTextColor(Color.BLACK);
            t16v.setGravity(Gravity.CENTER);
            tbrow.addView(t16v);

            TextView t17v = new TextView(this);
            t17v.setTextSize(15);
            t17v.setText(vehicleLisencePlate.get(i));
            t17v.setTextColor(Color.BLACK);
            t17v.setGravity(Gravity.CENTER);
            tbrow.addView(t17v);

            TextView t18v = new TextView(this);
            t18v.setTextSize(15);
            t18v.setText(comments.get(i));
            t18v.setTextColor(Color.BLACK);
            t18v.setGravity(Gravity.CENTER);
            tbrow.addView(t18v);

            TextView t19v = new TextView(this);
            t19v.setTextSize(15);
            t19v.setText(visitorAgreementText.get(i));
            t19v.setTextColor(Color.BLACK);
            t19v.setGravity(Gravity.CENTER);
            tbrow.addView(t19v);

//            TextView t20v = new TextView(this);
//            t20v.setTextSize(15);
//            t20v.setText(visitorSignInAgreement.get(i));
//            t20v.setTextColor(Color.BLACK);
//            t20v.setGravity(Gravity.CENTER);
//            tbrow.addView(t20v);

            TextView t21v = new TextView(this);
            t21v.setText(visitorSignOutAgreement.get(i));
            t21v.setTextSize(15);
            t21v.setTextColor(Color.BLACK);
            t21v.setGravity(Gravity.CENTER);
            tbrow.addView(t21v);

            stk.addView(tbrow);
        }//end of for loop
    }//end of method

}//end of class
