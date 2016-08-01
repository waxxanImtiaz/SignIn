package singin.com.techcoda.signin;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView heading;
    Button goSignIn, goSignOut;

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goSignIn = (Button) findViewById(R.id.btn_go_signin);
        goSignOut = (Button) findViewById(R.id.btn_goto_signout);

        goSignIn.setOnClickListener(this);
        goSignOut.setOnClickListener(this);
        database = new Database(this);
        database.insertIntoSignInSetupFields();
        heading = (TextView) findViewById(R.id.tv_instruction);
        Typeface mlibelFont = Typeface.createFromAsset(getAssets(), "fonts/libel-suit-rg.ttf");
        heading.setTypeface(mlibelFont);
    }

    @Override
    public void onClick(View view) {

        Intent intent;
        switch (view.getId()) {

            case R.id.btn_go_signin:
                intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
                break;

            case R.id.btn_goto_signout:
                intent = new Intent(MainActivity.this, SignOut.class);
                startActivity(intent);
                break;

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admin_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }//end of onCreateOptionMenu


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {
            case R.id.admin_icon:
                intent = new Intent(MainActivity.this, AdminPanel.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }//end of switch
    }
}
