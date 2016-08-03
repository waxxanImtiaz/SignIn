package singin.com.techcoda.signin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;

/**
 * Created by m on 6/14/2016.
 */
public class Database {

    Context context;
    DatabaseHandler dbh;

    public Database(Context context){
        dbh = new DatabaseHandler(context);
        this.context = context;
    }

    //INSERT SING IN VISITOR
    public long insertVisitor(String companyID, String firstName, String lastName){

        SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHandler.COL_COMPANY_ID, companyID);
        contentValues.put(DatabaseHandler.COL_FIRST_NAME, firstName);
        contentValues.put(DatabaseHandler.COL_LAST_NAME, lastName);

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
        //email row
        contentValues.put(DatabaseHandler.COL_FIELD_ID, "email");
        contentValues.put(DatabaseHandler.COL_FIELD_OPTION, "Not Used");
        rows = rows + db.insert(DatabaseHandler.TABLE_SINGN_IN_SETUP_FIELDS, null, contentValues);
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



    //GET ALL VISITORS IN LIST - SIGN IN

    //getting all current date visitors
    //this method shows all the visitors of current date, those who sign in today will
    // be shown by this mehtod
    public List<List<String>> getAllVisitorsList(){
        List<List<String>> name = new ArrayList<>();
        List<String> id = new ArrayList<>();
        List<String> first = new ArrayList<>();
        List<String> last = new ArrayList<>();

        String date = new SimpleDateFormat("dd MM yyyy").format(new Date()); //get current system date
        List<String> listID = getVisitorsIDByDate( date ); //get id's from sign in table where status= premises and date= current date

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
        public static final String COL_EMAIL = "email";
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

//        //COLORS
//        public static final String TABLE_COLORS ="colors";
//        public static final String COL_COLOR_ID ="color_id";
//        public static final String COL_COLOR_CODE ="color_code";
//
//        //FONT STYLES
//        public static final String TABLE_FONT_STYLES="fonts";
//        public static final String COL_FONT_ID="font_id";
//        public static final String COL_FONT_NAME="font_name";
//        public static final String COL_FONT_PATH="font_path";

        //SINGN IN SETUP FIELDS TABLE
        public static final String TABLE_SINGN_IN_SETUP_FIELDS = "sign_in_setup_fields";
        public static final String COL_FIELD_ID="id";
        public static final String COL_FIELD_OPTION = "option";

        //CREATE TABEL'S
        public static final String CREATE_TABLE_COMPANY = "CREATE TABLE " + TABLE_COMPANY + "(" + COL_COMPANY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " VARCHAR(255), " + COL_STATUS + " VARCHAR(50));";
        public static final String CREATE_TABLE_ADMIN = "CREATE TABLE " + TABLE_ADMIN + "(" + COL_ADMIN_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_COMPANY_ID + " INTEGER, " + COL_NAME + " VARCHAR(255), " + COL_EMAIL + " VARCHAR(255), " + COL_PASSWORD + " VARCHAR(255));";
        public static final String CREATE_TABLE_VISITOR = "CREATE TABLE " + TABLE_VISITOR + "(" + COL_VISITOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_COMPANY_ID + " INTEGER, " + COL_FIRST_NAME + " VARCHAR(255), " + COL_LAST_NAME + " VARCHAR(255));";
        public static final String CREATE_TABLE_SIGNIN = "CREATE TABLE " + TABLE_SIGN_IN + "(" + COL_SIGN_IN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_VISITOR_ID + " INTEGER, " + COL_IN + " VARCHAR(50), " + COL_OUT + " VARCHAR(50), " + COL_STATUS + " VARCHAR(50), " + COL_DATE + " VARCHAR(50));";
        public static final String CREATE_TABLE_FIELD_SETUP="CREATE TABLE "+TABLE_SINGN_IN_SETUP_FIELDS + " ("+COL_FIELD_ID+" VARCHAR(100),"+ COL_FIELD_OPTION+" VARCHAR(30));";

        //DROP TABLE
        public static final String DROP_TABLE_COMPANY = "DROP TABLE IF EXISTS " + TABLE_COMPANY;
        public static final String DROP_TABLE_ADMIN = "DROP TABLE IF EXISTS " + TABLE_ADMIN;
        public static final String DROP_TABLE_VISITOR = "DROP TABLE IF EXISTS " + TABLE_VISITOR;
        public static final String DROP_TABLE_SIGNIN = "DROP TABLE IF EXISTS " + TABLE_SIGN_IN;
        public  static final String DROP_TABLE_SIGNIN_SETUP_FIELDS = "DROP TABLE IF EXISTS "+TABLE_SINGN_IN_SETUP_FIELDS;

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
           // insertIntoSignInSetupFields();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL(DROP_TABLE_COMPANY);
            db.execSQL(DROP_TABLE_ADMIN);
            db.execSQL(DROP_TABLE_VISITOR);
            db.execSQL(DROP_TABLE_SIGNIN);
            db.execSQL(DROP_TABLE_SIGNIN_SETUP_FIELDS);
            onCreate(db);
        }
    }//end of DatabaseHandler

}
