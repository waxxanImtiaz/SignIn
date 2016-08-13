package singin.com.techcoda.signin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;

public class Database {

    Context context;
    DatabaseHandler dbh;

    public Database(Context context){
        dbh = new DatabaseHandler(context);
        this.context = context;
    }

    //GET FONT STYLE
    public String getFontPath(String name){

        String font_Path = null;

        String[] selectionArgs = { name };
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_FONT_PATH+ " FROM " + DatabaseHandler.TABLE_FONT_STYLES + " WHERE " + DatabaseHandler.COL_FONT_NAME +"=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        while(cursor.moveToNext()){
            font_Path = cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FONT_PATH));
        }
        return font_Path;
    }

    public void insertStylesIntoFontStyles(){
        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        long rows = 0;
        //first row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 1);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Hand writting");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/handwritting.ttf");
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        //second row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 2);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Groovey");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/groovey_fonts.ttf");
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        //Third row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 3);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Libel Suit Rg");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/libel-suit-rg.ttf");
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //fourth row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 4);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Tauri Regular");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/Tauri-Regular.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //fifth row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 5);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Roboto Black");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/Roboto-Black.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //sixth row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 6);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Roboto Light");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/Roboto-Light.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //seventh row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 7);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "DroidSerif Regular");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/DroidSerif-Regular.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //eighth row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 8);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Jumping Running");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/Jumping Running.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //ninth row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 9);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Roboto Regular");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/Roboto-Regular.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //tenth row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 10);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Airplane swash italic");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/J-airplane-swash-italic-font.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);

        //evelenth row
        contentValues.put(DatabaseHandler.COL_FONT_ID, 11);
        contentValues.put(DatabaseHandler.COL_FONT_NAME, "Raleway Regular");
        contentValues.put(DatabaseHandler.COL_FONT_PATH, "fonts/Raleway-Regular.ttf");
        db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
        rows = rows + db.insert(DatabaseHandler.TABLE_FONT_STYLES, null, contentValues);
       // Toast.makeText(context.getApplicationContext(),rows+" rows effected",Toast.LENGTH_SHORT).show();
    }
    //INSERT SING IN VISITOR
//    public long insertVisitor(String companyID, String firstName, String lastName){
    public long insertVisitor(List<String> siginIn, byte[] b){

        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHandler.COL_COMPANY_ID, siginIn.get(0));
        contentValues.put(DatabaseHandler.COL_FIRST_NAME, siginIn.get(1));
        contentValues.put(DatabaseHandler.COL_LAST_NAME, siginIn.get(2));


        String temp = null;

        temp = siginIn.get(3);
        contentValues.put(DatabaseHandler.COL_COMPANY, temp+"");

        temp = siginIn.get(4);
        if(temp != null)
            contentValues.put(DatabaseHandler.COL_ADDRESS, temp+"");

        temp = siginIn.get(5);
        if(temp != null)
            contentValues.put(DatabaseHandler.COL_CITY, temp+"");

        temp = siginIn.get(6);
        if(temp != null)
            contentValues.put(DatabaseHandler.COL_EMAIL, temp+"");
        temp = siginIn.get(7);
        if(temp != null)
            contentValues.put(DatabaseHandler.COL_STATE, temp+"");

        temp = siginIn.get(8);
        if(temp != null)
            contentValues.put(DatabaseHandler.COL_ZIPCODE, temp+"");


        temp = siginIn.get(9);
        if(temp != null)
            contentValues.put(DatabaseHandler.COL_PHONE, temp+"");

        temp = siginIn.get(10);
        if(temp != null)
            contentValues.put(DatabaseHandler.COL_HERE_TO_SEE, temp+"");
        temp = siginIn.get(11);
        contentValues.put(DatabaseHandler.COL_SIGNATRUE_CAPTURE, temp+"");

        contentValues.put(DatabaseHandler.COL_PHOTO_CAPTURE , b);
        temp = siginIn.get(12);
        contentValues.put(DatabaseHandler.COL_GUIDE_NAME, temp+"");

        temp = siginIn.get(13);
        contentValues.put(DatabaseHandler.COL_BADGE_NUMBER, temp+"");

        temp = siginIn.get(14);
        contentValues.put(DatabaseHandler.COL_BADGE_RETURNED, temp+"");


        temp = siginIn.get(15);
        contentValues.put(DatabaseHandler.COL_VEHICLE_MAKE_MODEL, temp+"");

        temp = siginIn.get(16);
        contentValues.put(DatabaseHandler.COL_VEHICLE_COLOR, temp+"");

        temp = siginIn.get(17);
        contentValues.put(DatabaseHandler.COL_VEHICLE_LISENCE_PLATE, temp+"");

        temp = siginIn.get(18);
        contentValues.put(DatabaseHandler.COL_COMMENTS, temp+"");

        temp = siginIn.get(19);
        contentValues.put(DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNIN, temp+"");


        temp = siginIn.get(20);
        contentValues.put(DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNOUT, temp+"");

        temp = siginIn.get(21);
        contentValues.put(DatabaseHandler.COL_VISITOR_AGREEMENT_TEXT, temp+"");

        temp = siginIn.get(22);
        contentValues.put(DatabaseHandler.COL_USER_STATUS, temp);
        long rows = db.insert(DatabaseHandler.TABLE_VISITOR, null, contentValues);
        return rows;
    }

    //GET VISITOR ID
    public String getVisitorID(){

        String visitor_ID = null;

        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_VISITOR_ID + " FROM " + DatabaseHandler.TABLE_VISITOR + " ORDER BY " + DatabaseHandler.COL_VISITOR_ID +" DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToNext()){
            visitor_ID = cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VISITOR_ID));
        }
        return visitor_ID;
    }

    //INSERT VISITOR TIME_STAMP INTO TABLE_SIGNIN
    public long insertVisitorIntoSingIn(String visitorID, String signIn, String status, String date){

        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHandler.COL_VISITOR_ID, visitorID);
        contentValues.put(DatabaseHandler.COL_IN, signIn);
        contentValues.put(DatabaseHandler.COL_STATUS, status);
        contentValues.put(DatabaseHandler.COL_DATE, date);

        long rows = db.insert(DatabaseHandler.TABLE_SIGN_IN, null, contentValues);
        return rows;

    }

    public long insertIntoSignInSetupFields(){

        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        long rows = 0;

        //compnay row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "company");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //address row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "address");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //city row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "city");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //state row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "state");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //zip code row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "zip code");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //phone row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "phone");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //guide escort/name row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "guide escort");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //email row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "email");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //badge returned row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "badge returned");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //badge number row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "badge number");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //vehicle color row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "vehicle color");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //vehicle make/model row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "vehicle make/model");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //vehicle lisence plate row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "vehicle lisence plate");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //comments row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "comments");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);


        //
        //custom field one row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "custom field one");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //custom field two row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "custom field two");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //custom field three row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "custom field three");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //custom field four row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "custom field four");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //custom field five row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "custom field five");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);


        //

        //here to see row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "here to see");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //signature capture row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "signature capture");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //photo capture row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "photo capture");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Mandatory");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //automatic photo capture row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "automatic photo capture");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "yes");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //Photo size in email row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "photo size in email");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "small");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);

        //Sign in agreement row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "signin agreement");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "false");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);


        //Sign out agreement row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "signout agreement");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "false");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
        //Toast.makeText(context.getApplicationContext(),rows+" rows effected",Toast.LENGTH_LONG).show();
        return rows;
    }

    //METHODS FOR ADMIN PANEL
    ///////////////////////////////////////////////////
    //GET COUNT OF VISITOR IN BY DATE
    public int getCountVisitorIn(String date){

        int count = 0;
        String[] selectionArgs = { date };
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_IN + " FROM " + DatabaseHandler.TABLE_SIGN_IN + " WHERE " + DatabaseHandler.COL_DATE + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if(cursor.moveToFirst()){
            count = cursor.getCount();
        }
        return count;
    }

    public int getCountVisitorOut(String date){
        int count = 0;
        String[] selectionArgs = { date, "gone" };
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_OUT + " FROM " + DatabaseHandler.TABLE_SIGN_IN + " WHERE " + DatabaseHandler.COL_DATE + "=? AND " + DatabaseHandler.COL_STATUS + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if(cursor.moveToFirst()){
            count = cursor.getCount();
        }
        return count;
    }

    public int getCountVisitorOnPremises(String date){
        int count = 0;
        String[] selectionArgs = { date, "premises" };
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_STATUS + " FROM " + DatabaseHandler.TABLE_SIGN_IN + " WHERE " + DatabaseHandler.COL_DATE + "=? AND " + DatabaseHandler.COL_STATUS + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if(cursor.moveToFirst()){
            count = cursor.getCount();
        }
        return count;
    }



    //METHODS FOR SIGN OUT ACTIVITY
    ///////////////////////////////////////////////////
    //GET NAME FOR LIST

    //sign in, sign out or on premises = ACTION
    public List<String> getVisitorsIDByStatusAndDate(String action, String date){

        List<String> id = new ArrayList<>();
        String[] selectionArgs = { action, date };
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_VISITOR_ID + " FROM " + DatabaseHandler.TABLE_SIGN_IN + " WHERE " + DatabaseHandler.COL_STATUS + "=? AND " + DatabaseHandler.COL_DATE + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        while(cursor.moveToNext()){
            id.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VISITOR_ID)));
        }
        return id;
    }

    //sign in, sign out or on premises = ACTION
    public List<List<String>> getVisitorNameByFirstName(String firstName, String action){
        List<List<String>> name = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();

        String date = new SimpleDateFormat("dd MM yyyy").format(new Date()); //get current system date
        List<String> listID = getVisitorsIDByStatusAndDate(action , date); //get id's from sign in table where status= premises and date= current date

        SQLiteDatabase db = dbh.getWritableDatabase(); //open datebase

        //run loop to get everytime data by id which is stored in listID
        for(int i=0; i<listID.size(); i++){

            String[] selectionArgs = { listID.get(i), firstName };
            String query = "SELECT " + DatabaseHandler.COL_FIRST_NAME + ", " + DatabaseHandler.COL_LAST_NAME + " FROM " + DatabaseHandler.TABLE_VISITOR + " WHERE " + DatabaseHandler.COL_VISITOR_ID + "=? AND " + DatabaseHandler.COL_FIRST_NAME + "=?";
            Cursor cursor = db.rawQuery(query, selectionArgs);
            if(cursor.moveToNext()){
                id.add(listID.get(i));
                first.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FIRST_NAME)));
                last.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_LAST_NAME)));
            }

        }//end of for loop


        name.add(id);
        name.add(first);
        name.add(last);
        return name;
    }


    public List<String> getVisitorsIDByDate(String date){

        List<String> id = new ArrayList<>();
        String[] selectionArgs = { date };
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_VISITOR_ID + " FROM " + DatabaseHandler.TABLE_SIGN_IN + " WHERE " + DatabaseHandler.COL_DATE + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        while(cursor.moveToNext()){
            id.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VISITOR_ID)));
        }
        return id;
    }
    //get signIn fields enable or not
    public String isFieldEnabled(String id){

        String[] selectionArgs = { id };
        SQLiteDatabase db = dbh.getWritableDatabase();
        String query = "SELECT " + DatabaseHandler.COL_FIELD_OPTION + " FROM " + DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS+ " WHERE " + DatabaseHandler.COL_FIELD_ID + "=?";
        Cursor cursor = db.rawQuery(query, selectionArgs);
        if(cursor.moveToNext()){
            return cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FIELD_OPTION));
        }

        return null;
    }

    //this method shows all the visitors of current date, those who sign in today will
    // be shown by this mehtod
    public List<List<String>> getVisitorNameByFirstNameForSignIn(String firstName){
        List<List<String>> name = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();

        String date = new SimpleDateFormat("dd MM yyyy").format(new Date()); //get current system date
        List<String> listID = getVisitorsIDByDate( date ); //get id's from sign in table where status= premises and date= current date

        SQLiteDatabase db = dbh.getWritableDatabase(); //open datebase

        //run loop to get everytime data by id which is stored in listID
        for(int i=0; i<listID.size(); i++){

            String[] selectionArgs = { listID.get(i), firstName };
            String query = "SELECT " + DatabaseHandler.COL_FIRST_NAME + ", " + DatabaseHandler.COL_LAST_NAME + " FROM " + DatabaseHandler.TABLE_VISITOR + " WHERE " + DatabaseHandler.COL_VISITOR_ID + "=? AND " + DatabaseHandler.COL_FIRST_NAME + "=?";
            Cursor cursor = db.rawQuery(query, selectionArgs);
            if(cursor.moveToNext()){
                id.add(listID.get(i));
                first.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FIRST_NAME)));
                last.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_LAST_NAME)));
            }

        }//end of for loop


        name.add(id);
        name.add(first);
        name.add(last);
        return name;
    }


    public long updateSignInSetupFields(String id,String option){

        String whereClause = DatabaseHandler.COL_FIELD_ID + "=?";
        String[] selectionArgs = { id };

        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, option);
        long rows = db.update(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, contentValues, whereClause, selectionArgs);
        return rows;
    }
    //Sign Out visitor: update TABLE SIGNIN where status will be premises to gone
    public long visitorSignOut(String id, String date, String status){

        String whereClause = DatabaseHandler.COL_VISITOR_ID + "=?";
        String[] selectionArgs = { id };

        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHandler.COL_OUT, date);
        contentValues.put(DatabaseHandler.COL_STATUS, status);

        long rows = db.update(DatabaseHandler.TABLE_SIGN_IN, contentValues, whereClause, selectionArgs);
        return rows;
    }



    public int deleteAllVisitorsOn(String state,String d)
    {
        SQLiteDatabase db = dbh.getWritableDatabase();
        String date = new SimpleDateFormat("dd MM yyyy").format(new Date()); //get current system date
        List<String> listID = getVisitorsIDByStatusAndDate(state , d);
        int rows = 0;
        for(int i =0; i<listID.size(); i++) {
            rows += db.delete(DatabaseHandler.TABLE_VISITOR, DatabaseHandler.COL_VISITOR_ID+ " = ? AND "+DatabaseHandler.COL_USER_STATUS+" =?", new String[]{i+"",state});
        }
        String whereClause = DatabaseHandler.COL_STATUS + "=?";
        String[] selectionArgs = { state };
        if(state.equals("premises") || state.equals("gone")) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHandler.COL_STATUS, "none");
            db.update(DatabaseHandler.TABLE_SIGN_IN, contentValues, whereClause, selectionArgs);
        }
        else{
            selectionArgs = new String[]{ state };
            whereClause = DatabaseHandler.COL_STATUS + "=?";
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHandler.COL_STATUS, "none");
            db.update(DatabaseHandler.TABLE_SIGN_IN, contentValues, whereClause, selectionArgs);
        }
        db.close();// Closing database connection
        return rows;
    }
    //GET ALL VISITORS IN LIST - SIGN IN

    //getting all current date visitors
    //this method shows all the visitors of current date, those who sign in today will
    // be shown by this mehtod
    public List<List<String>> getAllVisitorsListUsingStatus(String action){
        List<List<String>> name = new ArrayList<>();

        List<String> id = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();
        List<String> company = new ArrayList<>();
        List<String> email = new ArrayList<>();
        List<String> state = new ArrayList<>();
        List<String> city = new ArrayList<>();
        List<String> guideName = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> hereToSee = new ArrayList<>();
        List<String> zipCode = new ArrayList<>();
        List<String> phone = new ArrayList<>();
        List<String> signatureCapture = new ArrayList<>();
        List<String> badgeReturned = new ArrayList<>();
        List<String> badgeNumber = new ArrayList<>();
        List<String> vehicleMakeModel = new ArrayList<>();
        List<String> vehicleColor = new ArrayList<>();
        List<String> vehicleLisencePlate = new ArrayList<>();
        List<String> comments = new ArrayList<>();
        List<String> visitorSignInAgreement = new ArrayList<>();
        List<String> visitorSignOutAgreement = new ArrayList<>();
        List<String> visitorAgreementText = new ArrayList<>();


        String date = new SimpleDateFormat("dd MM yyyy").format(new Date()); //get current system date
        List<String> listID = getVisitorsIDByStatusAndDate(action , date); //get id's from sign in table where status= premises and date= current date

        SQLiteDatabase db = dbh.getWritableDatabase(); //open datebase

        //run loop to get everytime data by id which is stored in listID
        for(int i=0; i<listID.size(); i++){

            String[] selectionArgs = { listID.get(i) };
            String query = "SELECT " + DatabaseHandler.COL_FIRST_NAME + ", " + DatabaseHandler.COL_LAST_NAME+ ", "+ DatabaseHandler.COL_COMPANY+ ", " + DatabaseHandler.COL_EMAIL+ ", " + DatabaseHandler.COL_ADDRESS+ ", " + DatabaseHandler.COL_PHONE+ ", " + DatabaseHandler.COL_STATE+ ", " + DatabaseHandler.COL_HERE_TO_SEE+ ", " + DatabaseHandler.COL_ZIPCODE+ ", " + DatabaseHandler.COL_CITY+ ", " + DatabaseHandler.COL_SIGNATRUE_CAPTURE+ ", " + DatabaseHandler.COL_VEHICLE_LISENCE_PLATE+ ", " + DatabaseHandler.COL_VEHICLE_COLOR+ ", " + DatabaseHandler.COL_VEHICLE_MAKE_MODEL+ ", " + DatabaseHandler.COL_BADGE_RETURNED+ ", " + DatabaseHandler.COL_BADGE_NUMBER+ ", " + DatabaseHandler.COL_COMMENTS+ ", " + DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNOUT+ ", " + DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNIN+ ", " + DatabaseHandler.COL_VISITOR_AGREEMENT_TEXT +", " + DatabaseHandler.COL_CITY +", " + DatabaseHandler.COL_GUIDE_NAME + " FROM " + DatabaseHandler.TABLE_VISITOR + " WHERE " + DatabaseHandler.COL_VISITOR_ID + "=?";
            Cursor cursor = db.rawQuery(query, selectionArgs);
            if(cursor.moveToNext()){
                id.add(listID.get(i));
                first.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FIRST_NAME)));
                last.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_LAST_NAME)));
                company.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_COMPANY)));
                email.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_EMAIL)));
                state.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_STATE)));
                address.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_ADDRESS)));
                hereToSee.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_HERE_TO_SEE)));
                zipCode.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_ZIPCODE)));
                phone.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_PHONE)));
                signatureCapture.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_SIGNATRUE_CAPTURE)));
                badgeReturned.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_BADGE_RETURNED)));
                badgeNumber.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_BADGE_NUMBER)));
                vehicleMakeModel.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VEHICLE_MAKE_MODEL)));
                vehicleColor.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VEHICLE_COLOR)));
                vehicleLisencePlate.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VEHICLE_LISENCE_PLATE)));
                comments.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_COMMENTS)));
                visitorAgreementText.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VISITOR_AGREEMENT_TEXT)));
                city.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_CITY)));
                guideName.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_GUIDE_NAME)));
                visitorSignInAgreement.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNIN)));
                visitorSignOutAgreement.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNOUT)));


            }

        }//end of for loop


        name.add(id);
        name.add(first);
        name.add(last);
        name.add(company);
        name.add(email);
        name.add(state);
        name.add(address);
        name.add(hereToSee);
        name.add(zipCode);
        name.add(phone);
        name.add(signatureCapture);
        name.add(badgeReturned);
        name.add(badgeNumber);
        name.add(vehicleMakeModel);
        name.add(vehicleColor);
        name.add(vehicleLisencePlate);
        name.add(comments);
        name.add(visitorAgreementText);
        name.add(visitorSignInAgreement);
        name.add(visitorSignOutAgreement);
        name.add(city);
        name.add(guideName);
        return name;
    }


    public List<List<String>> getAllVisitorsList(String status){

        List<List<String>> name = new ArrayList<>();

        List<String> id = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();
        List<String> company = new ArrayList<>();
        List<String> address = new ArrayList<>();
        List<String> city = new ArrayList<>();
        List<String> state = new ArrayList<>();
        List<String> phone = new ArrayList<>();
        List<String> zipCode = new ArrayList<>();
        List<String> email = new ArrayList<>();
        List<String> hereToSee = new ArrayList<>();
        List<String> signatureCapture = new ArrayList<>();
        List<String> badgeReturn = new ArrayList<>();
        List<String> guideName = new ArrayList<>();
        List<String> badgeNumber = new ArrayList<>();
        List<String> vehicleMakeModel = new ArrayList<>();
        List<String> vehicleColor = new ArrayList<>();
        List<String> vehicleLisencePlate = new ArrayList<>();
        List<String> visitorSignInAgreement = new ArrayList<>();
        List<String> visitorSignOutAgreement = new ArrayList<>();
        List<String> visitorAgreementText = new ArrayList<>();
        List<String> comments = new ArrayList<>();

        String date = new SimpleDateFormat("dd MM yyyy").format(new Date()); //get current system date
        List<String> listID = getVisitorsIDByDate( date ); //get id's from sign in table where status= premises and date= current date

        SQLiteDatabase db = dbh.getWritableDatabase(); //open datebase

        //run loop to get everytime data by id which is stored in listID
        for(int i=0; i<listID.size(); i++){

            String[] selectionArgs = { listID.get(i),status };
            String query = "SELECT " + DatabaseHandler.COL_FIRST_NAME + ", " + DatabaseHandler.COL_LAST_NAME
                    +","+DatabaseHandler.COL_ADDRESS+","+DatabaseHandler.COL_EMAIL+","+DatabaseHandler.COL_CITY
                    +","+DatabaseHandler.COL_COMMENTS+","+DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNIN+","+
                    DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNOUT+","+DatabaseHandler.COL_VISITOR_AGREEMENT_TEXT+","+DatabaseHandler.COL_ZIPCODE
                    +","+DatabaseHandler.COL_STATE+","+DatabaseHandler.COL_PHONE+","+DatabaseHandler.COL_COMPANY+","+DatabaseHandler.COL_HERE_TO_SEE
                    +","+DatabaseHandler.COL_VEHICLE_COLOR+","+DatabaseHandler.COL_VEHICLE_MAKE_MODEL+ "," +
                    DatabaseHandler.COL_VEHICLE_LISENCE_PLATE+","+DatabaseHandler.COL_BADGE_NUMBER+","+DatabaseHandler.COL_BADGE_RETURNED
                    +","+DatabaseHandler.COL_GUIDE_NAME+","+DatabaseHandler.COL_SIGNATRUE_CAPTURE+" FROM " + DatabaseHandler.TABLE_VISITOR + " WHERE " + DatabaseHandler.COL_VISITOR_ID + "=? AND "+DatabaseHandler.COL_USER_STATUS+" =?";


            Cursor cursor = db.rawQuery(query, selectionArgs);
            if(cursor.moveToNext()){
                id.add(listID.get(i));
                first.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FIRST_NAME)));
                last.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_LAST_NAME)));
                email.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_EMAIL)));
                comments.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_COMMENTS)));
                company.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_COMPANY)));
                city.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_CITY)));
                address.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_ADDRESS)));
                hereToSee.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_HERE_TO_SEE)));
                zipCode.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_ZIPCODE)));
                signatureCapture.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_SIGNATRUE_CAPTURE)));
                badgeNumber.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_BADGE_NUMBER)));
                badgeReturn.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_BADGE_RETURNED)));
                guideName.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_GUIDE_NAME)));
                vehicleColor.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VEHICLE_COLOR)));
                vehicleMakeModel.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VEHICLE_MAKE_MODEL)));
                vehicleLisencePlate.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VEHICLE_LISENCE_PLATE)));
                visitorSignInAgreement.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNIN)));
                visitorSignOutAgreement.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_SHOW_AGREEMENT_ON_SIGNOUT)));
                visitorAgreementText.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_VISITOR_AGREEMENT_TEXT)));
                state.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_STATE)));
                phone.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_PHONE)));


            }

        }//end of for loop


        name.add(id);
        name.add(first);
        name.add(last);
        name.add(city);
        name.add(company);
        name.add(comments);
        name.add(address);
        name.add(hereToSee);
        name.add(email);
        name.add(signatureCapture);
        name.add(state);
        name.add(guideName);
        name.add(badgeNumber);
        name.add(badgeReturn);
        name.add(vehicleLisencePlate);
        name.add(vehicleColor);
        name.add(vehicleMakeModel);
        name.add(phone);
        name.add(vehicleMakeModel);
        name.add(visitorAgreementText);
        name.add(visitorSignInAgreement);
        name.add(visitorSignOutAgreement);
        name.add(zipCode);

        return name;
    }
    //GET ALL VISITORS IN LIST - ON PREMISES
    public List<List<String>> getAllVisitorsListByStatus(String action){
        List<List<String>> name = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();

        String date = new SimpleDateFormat("dd MM yyyy").format(new Date()); //get current system date
        List<String> listID = getVisitorsIDByStatusAndDate(action , date); //get id's from sign in table where status= premises and date= current date

        SQLiteDatabase db = dbh.getWritableDatabase(); //open datebase

        //run loop to get everytime data by id which is stored in listID
        for(int i=0; i<listID.size(); i++){

            String[] selectionArgs = { listID.get(i) };
            String query = "SELECT " + DatabaseHandler.COL_FIRST_NAME + ", " + DatabaseHandler.COL_LAST_NAME + " FROM " + DatabaseHandler.TABLE_VISITOR + " WHERE " + DatabaseHandler.COL_VISITOR_ID + "=?";
            Cursor cursor = db.rawQuery(query, selectionArgs);
            if(cursor.moveToNext()){
                id.add(listID.get(i));
                first.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_FIRST_NAME)));
                last.add(cursor.getString(cursor.getColumnIndex(DatabaseHandler.COL_LAST_NAME)));
            }

        }//end of for loop


        name.add(id);
        name.add(first);
        name.add(last);
        return name;
    }









    public class DatabaseHandler extends SQLiteOpenHelper{

        public static final String DB_NAME = "signin";
        public static final int DB_VERSION = 5;


        //COMPANY
        public static final String TABLE_COMPANY = "company";
        public static final String COL_COMPANY_ID = "company_id";
        public static final String COL_NAME = "name";
        public static final String COL_STATUS = "status";


        //ADMIN
        public static final String TABLE_ADMIN = "admin";
        public static final String COL_ADMIN_ID = "admin_id";
        //public static final String COL_NAME = "name";
        //public static final String COL_EMAIL = "email";
        public static final String COL_PASSWORD = "password";



        //SIGN IN
        public static final String TABLE_SIGN_IN = "signin";
        public static final String COL_SIGN_IN = "id";
        //public static final String COL_VISITOR_ID = "visitor_id";
        public static final String COL_IN = "signedin";
        public static final String COL_OUT = "signedout";
        //public static final String COL_STATUS = "status";
        public static final String COL_DATE = "date";

        //VISITOR
        public static final String TABLE_VISITOR = "visitor";
        //public static final String COL_COMPANY_ID = "company_id"; //foreign key
        public static final String COL_VISITOR_ID = "visitor_id"; //primary key
        public static final String COL_FIRST_NAME = "first_name";
        public static final String COL_LAST_NAME = "last_name";
        public static final String COL_ADDRESS = "address";
        public static final String COL_COMPANY = "company";
        public static final String COL_CITY = "city";
        public static final String COL_STATE = "state";
        public static final String COL_USER_STATUS = "user_status";
        public static final String COL_ZIPCODE = "zipcode";
        public static final String COL_PHONE = "phone";
        public static final String COL_EMAIL = "email";
        public static final String COL_HERE_TO_SEE = "here_to_see";
        public static final String COL_SIGNATRUE_CAPTURE = "signature_capture";
        public static final String COL_PHOTO_CAPTURE = "photo_capture";
        public static final String COL_GUIDE_NAME = "guide_name";
        public static final String COL_BADGE_RETURNED = "returned";
        public static final String COL_BADGE_NUMBER = "badge_number";
        public static final String COL_VEHICLE_MAKE_MODEL = "vehicle_make_model";
        public static final String COL_VEHICLE_COLOR = "color";
        public static final String COL_VEHICLE_LISENCE_PLATE = "lisence_plate";
        public static final String COL_COMMENTS = "comments";
        public static final String COL_SHOW_AGREEMENT_ON_SIGNIN = "show_agreement_on_signin";
        public static final String COL_SHOW_AGREEMENT_ON_SIGNOUT = "signout";
        public static final String COL_VISITOR_AGREEMENT_TEXT = "visitor_agreement_text";




        //COLORS
        public static final String TABLE_COLORS ="colors";
        public static final String COL_COLOR_ID ="color_id";
        public static final String COL_COLOR_CODE ="color_code";
//
        //FONT STYLES
        public static final String TABLE_FONT_STYLES="fonts";
        public static final String COL_FONT_ID="font_id";
        public static final String COL_FONT_NAME="font_name";
        public static final String COL_FONT_PATH="font_path";

        //SINGN IN SETUP FIELDS TABLE
        public static final String TABLE_SINGN_IN_SETUP_FIELDS = "sign_in_setup_fields";
        public static final String COL_FIELD_ID="id";
        public static final String COL_FIELD_OPTION = "option";

        //CREATE TABEL'S
        public static final String CREATE_TABLE_COMPANY = "CREATE TABLE " + TABLE_COMPANY + "(" + COL_COMPANY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " VARCHAR(255), " + COL_STATUS + " VARCHAR(50));";
        public static final String CREATE_TABLE_ADMIN = "CREATE TABLE " + TABLE_ADMIN + "(" + COL_ADMIN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_COMPANY_ID + " INTEGER, " + COL_NAME + " VARCHAR(255), " + COL_EMAIL + " VARCHAR(255), " + COL_PASSWORD + " VARCHAR(255));";
        public static final String CREATE_TABLE_VISITOR = "CREATE TABLE " + TABLE_VISITOR + "(" + COL_VISITOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_COMPANY_ID + " INTEGER, " + COL_FIRST_NAME + " VARCHAR(255), "+ COL_USER_STATUS + " VARCHAR(255), " + COL_LAST_NAME + " VARCHAR(255),"+ COL_COMPANY +" VARCHAR(255),"+COL_ADDRESS+" VARCHAR(255),"+COL_CITY+" VARCHAR(255),"+COL_EMAIL+" VARCHAR(255),"+COL_STATE+" VARCHAR(255),"+COL_ZIPCODE+" VARCHAR(255),"+COL_PHONE+" VARCHAR(255),"+COL_HERE_TO_SEE+" VARCHAR(255),"+COL_SIGNATRUE_CAPTURE+"  VARCHAR(255),"+COL_PHOTO_CAPTURE+" BLOB,"+COL_GUIDE_NAME+"  VARCHAR(255),"+COL_BADGE_NUMBER+"  VARCHAR(255),"+COL_BADGE_RETURNED+"  VARCHAR(255),"+COL_VEHICLE_MAKE_MODEL+" VARCHAR(255),"+COL_VEHICLE_COLOR+"  VARCHAR(255),"+COL_VEHICLE_LISENCE_PLATE+"  VARCHAR(255),"+COL_COMMENTS+"  VARCHAR(255),"+COL_SHOW_AGREEMENT_ON_SIGNIN+"  VARCHAR(255),"+COL_SHOW_AGREEMENT_ON_SIGNOUT+"  VARCHAR(255),"+COL_VISITOR_AGREEMENT_TEXT+"  VARCHAR(255));";
        public static final String CREATE_TABLE_SIGNIN = "CREATE TABLE " + TABLE_SIGN_IN + "(" + COL_SIGN_IN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_VISITOR_ID + " INTEGER, " + COL_IN + " VARCHAR(50), " + COL_OUT + " VARCHAR(50), " + COL_STATUS + " VARCHAR(50), " + COL_DATE + " VARCHAR(50));";
        public static final String CREATE_TABLE_FIELD_SETUP="CREATE TABLE "+TABLE_SINGN_IN_SETUP_FIELDS + " ("+COL_FIELD_ID+" VARCHAR(100),"+ COL_FIELD_OPTION+" VARCHAR(30));";
        public static final String CREATE_TABLE_FONT_STYLES="CREATE TABLE " + TABLE_FONT_STYLES +"(" + COL_FONT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_FONT_NAME + " VARCHAR(50), " + COL_FONT_PATH + " VARCHAR(50));";
        public static final String CREATE_TABLE_COLORS=" CREATE TABLE " + TABLE_COLORS + "("+COL_COLOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," + COL_COLOR_CODE + " VARCHAR(50));";

        //DROP TABLE
        public static final String DROP_TABLE_COMPANY = "DROP TABLE IF EXISTS " + TABLE_COMPANY;
        public static final String DROP_TABLE_ADMIN = "DROP TABLE IF EXISTS " + TABLE_ADMIN;
        public static final String DROP_TABLE_VISITOR = "DROP TABLE IF EXISTS " + TABLE_VISITOR;
        public static final String DROP_TABLE_SIGNIN = "DROP TABLE IF EXISTS " + TABLE_SIGN_IN;
        public  static final String DROP_TABLE_SIGNIN_SETUP_FIELDS = "DROP TABLE IF EXISTS "+TABLE_SINGN_IN_SETUP_FIELDS;
        public static final String DROP_TABLE_FONT_STYLES = "DROP TABLE IF EXISTS " + TABLE_FONT_STYLES;
        public static final String DROP_TABLE_COLORS = "DROP TABLE IF EXISTS " + TABLE_COLORS;

        Context context;

        public DatabaseHandler(Context context){
            super(context, DB_NAME, null, DB_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_COMPANY);
            db.execSQL(CREATE_TABLE_ADMIN);
            db.execSQL(CREATE_TABLE_VISITOR);
            db.execSQL(CREATE_TABLE_SIGNIN);
            db.execSQL(CREATE_TABLE_FIELD_SETUP);
            db.execSQL(CREATE_TABLE_FONT_STYLES);
            db.execSQL(CREATE_TABLE_COLORS);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(DROP_TABLE_COMPANY);
            db.execSQL(DROP_TABLE_ADMIN);
            db.execSQL(DROP_TABLE_VISITOR);
            db.execSQL(DROP_TABLE_SIGNIN);
            db.execSQL(DROP_TABLE_SIGNIN_SETUP_FIELDS);
            db.execSQL(DROP_TABLE_FONT_STYLES);
            db.execSQL(DROP_TABLE_COLORS);
            onCreate(db);
        }
    }//end of DatabaseHandler

}
