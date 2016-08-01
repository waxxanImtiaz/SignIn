package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by android on 7/30/2016.
 */
public class SubMenuHandler implements View.OnClickListener{
    private Context mContext;
    private Database database;
    public SubMenuHandler(Context mContext,View container)
    {
        this.mContext = mContext;
        database = new Database(mContext);
    }
    @Override
    public void onClick(View v)
    {
        int id = v.getId();

        switch (id)
        {
            case R.id.cb_comany_mendatory:
                Fields.ch_company_optional.setChecked(false);
                Fields.ch_company_not_used.setChecked(false);
                Fields.ch_company_mendatory.setChecked(true);
                database.updateSignInSetupFields(1,"Mandatory");
                break;
            case R.id.cb_comany_not_used:
                Fields.ch_company_optional.setChecked(false);
                Fields.ch_company_not_used.setChecked(true);
                Fields.ch_company_mendatory.setChecked(false);
              database.updateSignInSetupFields(1,"Not Used");
                break;
            case R.id.cb_comany_optional:
                Fields.ch_company_optional.setChecked(true);
                Fields.ch_company_not_used.setChecked(false);
                Fields.ch_company_mendatory.setChecked(false);
                database.updateSignInSetupFields(1,"Optional");
                break;

        }
    }



}
