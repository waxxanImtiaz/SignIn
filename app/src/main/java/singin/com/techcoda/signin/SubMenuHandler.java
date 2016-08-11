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
            //IF COMPANY SUB MENU CLICKED
            case R.id.cb_comany_mendatory:
                Fields.ch_company_optional.setChecked(false);
                Fields.ch_company_not_used.setChecked(false);
                Fields.ch_company_mendatory.setChecked(true);
                database.updateSignInSetupFields("company","Mandatory");
                break;
            case R.id.cb_comany_not_used:
                Fields.ch_company_optional.setChecked(false);
                Fields.ch_company_not_used.setChecked(true);
                Fields.ch_company_mendatory.setChecked(false);
                database.updateSignInSetupFields("company","Not Used");
                break;
            case R.id.cb_comany_optional:
                Fields.ch_company_optional.setChecked(true);
                Fields.ch_company_not_used.setChecked(false);
                Fields.ch_company_mendatory.setChecked(false);
                database.updateSignInSetupFields("company","Optional");
                break;
            //IF PHOTO CAPTURE SUB MENU CLICKED
            case R.id.cb_photo_capture_mandatory:
                Fields.cb_photo_capture_mandatory.setChecked(true);
                Fields.cb_photo_capture_optional.setChecked(false);
                database.updateSignInSetupFields("photo capture","Mandatory");
                break;
            case R.id.cb_photo_capture_optional:
                Fields.cb_photo_capture_mandatory.setChecked(false);
                Fields.cb_photo_capture_optional.setChecked(true);
                database.updateSignInSetupFields("photo capture","Optional");
                break;
//            case R.id.cb_auto_photo_capture:
//                Fields.cb_auto_photo_capture.setChecked(true);
//                database.updateSignInSetupFields("photo capture","yes");
//                break;
            case R.id.cb_photo_capture_large:
                Fields.cb_photo_capture_large.setChecked(true);
                Fields.cb_photo_capture_small.setChecked(false);
                Fields.cb_photo_capture_medium.setChecked(false);
                database.updateSignInSetupFields("photo capture","Large");
                break;
            case R.id.cb_photo_capture_medium:
                Fields.cb_photo_capture_large.setChecked(false);
                Fields.cb_photo_capture_small.setChecked(false);
                Fields.cb_photo_capture_medium.setChecked(true);
                database.updateSignInSetupFields("photo capture","Medium");
                break;
            case R.id.cb_photo_capture_small:
                Fields.cb_photo_capture_large.setChecked(false);
                Fields.cb_photo_capture_small.setChecked(true);
                Fields.cb_photo_capture_medium.setChecked(false);
                database.updateSignInSetupFields("photo capture","Small");
                break;
            //IF ADDRESS SUB MENU CLICKED
            case R.id.cb_address_mendatory:
                Fields.cb_address_mandatory.setChecked(true);
                Fields.cb_address_not_used.setChecked(false);
                Fields.cb_address_optoinal.setChecked(false);
                database.updateSignInSetupFields("address","Mandatory");
                break;
            case R.id.cb_address_optional:
                Fields.cb_address_mandatory.setChecked(false);
                Fields.cb_address_not_used.setChecked(false);
                Fields.cb_address_optoinal.setChecked(true);
                database.updateSignInSetupFields("address","Optional");
                break;
            case R.id.cb_address_not_used:
                Fields.cb_address_mandatory.setChecked(false);
                Fields.cb_address_not_used.setChecked(true);
                Fields.cb_address_optoinal.setChecked(false);
                database.updateSignInSetupFields("address","Not Used");
                break;
            //IF CITY SUB MENU CLICKED
            case R.id.cb_city_mendatory:
                Fields.cb_city_mandatory.setChecked(true);
                Fields.cb_city_not_used.setChecked(false);
                Fields.cb_city_optional.setChecked(false);
                database.updateSignInSetupFields("city","Mandatory");
                break;
            case R.id.cb_city_optional:
                Fields.cb_city_mandatory.setChecked(false);
                Fields.cb_city_not_used.setChecked(false);
                Fields.cb_city_optional.setChecked(true);
                database.updateSignInSetupFields("city","Optional");
                break;
            case R.id.cb_city_not_used:
                Fields.cb_city_mandatory.setChecked(false);
                Fields.cb_city_not_used.setChecked(true);
                Fields.cb_city_optional.setChecked(false);
                database.updateSignInSetupFields("city","Not Used");
                break;
            //IF STATE SUB MENU CLICKED
            case R.id.cb_state_mendatory:
                Fields.cb_state_mandatory.setChecked(true);
                Fields.cb_state_not_used.setChecked(false);
                Fields.cb_state_optional.setChecked(false);
                database.updateSignInSetupFields("city","Mandatory");
                break;
            case R.id.cb_state_optional:
                Fields.cb_state_mandatory.setChecked(false);
                Fields.cb_state_not_used.setChecked(false);
                Fields.cb_state_optional.setChecked(true);
                database.updateSignInSetupFields("city","Optional");
                break;
            case R.id.cb_state_not_used:
                Fields.cb_state_mandatory.setChecked(false);
                Fields.cb_state_not_used.setChecked(true);
                Fields.cb_state_optional.setChecked(false);
                database.updateSignInSetupFields("city","Not Used");
                break;
            //IF ZIP CODE SUB MENU CLICKED
            case R.id.cb_zip_code_mendatory:
                Fields.cb_zip_code_mandatory.setChecked(true);
                Fields.cb_zip_code_not_used.setChecked(false);
                Fields.cb_zip_code_optional.setChecked(false);
                database.updateSignInSetupFields("zip code","Mandatory");
                break;
            case R.id.cb_zip_code_optional:
                Fields.cb_zip_code_mandatory.setChecked(false);
                Fields.cb_zip_code_not_used.setChecked(false);
                Fields.cb_zip_code_optional.setChecked(true);
                database.updateSignInSetupFields("zip code","Optional");
                break;
            case R.id.cb_zip_code_not_used:
                Fields.cb_zip_code_mandatory.setChecked(false);
                Fields.cb_zip_code_not_used.setChecked(true);
                Fields.cb_zip_code_optional.setChecked(false);
                database.updateSignInSetupFields("zip code","Not Used");
                break;
            //IF POHNE SUB MENU CLICKED
            case R.id.cb_phone_mendatory:
                Fields.cb_phone_mandatory.setChecked(true);
                Fields.cb_phone_not_used.setChecked(false);
                Fields.cb_phone_optional.setChecked(false);
                database.updateSignInSetupFields("phone","Mandatory");
                break;
            case R.id.cb_phone_optional:
                Fields.cb_phone_mandatory.setChecked(false);
                Fields.cb_phone_not_used.setChecked(false);
                Fields.cb_phone_optional.setChecked(true);
                database.updateSignInSetupFields("phone","Optional");
                break;
            case R.id.cb_phone_not_used:
                Fields.cb_phone_mandatory.setChecked(false);
                Fields.cb_phone_not_used.setChecked(true);
                Fields.cb_phone_optional.setChecked(false);
                database.updateSignInSetupFields("phone","Not Used");
                break;
            //IF EMAIL SUB MENU CLICKED
            case R.id.cb_email_mendatory:
                Fields.cb_email_mandatory.setChecked(true);
                Fields.cb_email_not_used.setChecked(false);
                Fields.cb_email_optional.setChecked(false);
                database.updateSignInSetupFields("email","Mandatory");
                break;
            case R.id.cb_email_optional:
                Fields.cb_email_mandatory.setChecked(false);
                Fields.cb_email_not_used.setChecked(false);
                Fields.cb_email_optional.setChecked(true);
                database.updateSignInSetupFields("email","Optional");
                break;
            case R.id.cb_email_not_used:
                Fields.cb_email_mandatory.setChecked(false);
                Fields.cb_email_not_used.setChecked(true);
                Fields.cb_email_optional.setChecked(false);
                database.updateSignInSetupFields("email","Not Used");
                break;
            //IF SIGNATURE CAPTURE SUB MENU CLICKED
            case R.id.cb_signature_capture_mendatory:
                Fields.cb_signature_capture_mandatory.setChecked(true);
                Fields.cb_signature_capture_not_used.setChecked(false);
                Fields.cb_signature_capture_optional.setChecked(false);
                database.updateSignInSetupFields("signature capture","Mandatory");
                break;
            case R.id.cb_signature_capture_not_used:
                Fields.cb_signature_capture_optional.setChecked(false);
                Fields.cb_signature_capture_not_used.setChecked(true);
                Fields.cb_signature_capture_mandatory.setChecked(false);
                database.updateSignInSetupFields("signature capture","Optional");
                break;
            case R.id.cb_signature_capture_optional:
                Fields.cb_signature_capture_mandatory.setChecked(false);
                Fields.cb_signature_capture_not_used.setChecked(false);
                Fields.cb_signature_capture_optional.setChecked(true);
                database.updateSignInSetupFields("signatue capture","Not Used");
                break;
            //IF HERE TO SEE SUB MENU CLICKED
            case R.id.cb_here_to_see_mendatory:
                Fields.cb_here_to_see_mandatory.setChecked(true);
                Fields.cb_here_to_see_not_used.setChecked(false);
                Fields.cb_here_to_see_optional.setChecked(false);
                database.updateSignInSetupFields("here to see","Mandatory");
                break;
            case R.id.cb_here_to_see_not_used:
                Fields.cb_here_to_see_mandatory.setChecked(false);
                Fields.cb_here_to_see_not_used.setChecked(true);
                Fields.cb_here_to_see_optional.setChecked(false);
                database.updateSignInSetupFields("here to see","Optional");
                break;
            case R.id.cb_here_to_see_optional:
                Fields.cb_here_to_see_mandatory.setChecked(false);
                Fields.cb_here_to_see_not_used.setChecked(false);
                Fields.cb_here_to_see_optional.setChecked(true);
                database.updateSignInSetupFields("here to see","Not Used");
                break;

            //IF GUIDE ESCORT/NAME SUB MENU CLICKED
            case R.id.cb_guide_escort_mendatory:
                Fields.cb_guide_escort_mandatory.setChecked(true);
                Fields.cb_guide_escort_not_used.setChecked(false);
                Fields.cb_guide_escort_optoinal.setChecked(false);
                database.updateSignInSetupFields("guide escort","Mandatory");
                break;
            case R.id.cb_guide_escort_not_used:
                Fields.cb_guide_escort_mandatory.setChecked(false);
                Fields.cb_guide_escort_not_used.setChecked(true);
                Fields.cb_guide_escort_optoinal.setChecked(false);
                database.updateSignInSetupFields("guide escort","Optional");
                break;
            case R.id.cb_guide_escort_optional:
                Fields.cb_guide_escort_mandatory.setChecked(false);
                Fields.cb_guide_escort_not_used.setChecked(false);
                Fields.cb_guide_escort_optoinal.setChecked(true);
                database.updateSignInSetupFields("guide escort","Not Used");
                break;
            //IF BADGE RETURNED SUB MENU CLICKED
            case R.id.cb_badge_returned_mendatory:
                Fields.cb_badge_returned_mandatory.setChecked(true);
                Fields.cb_badge_returned_not_used.setChecked(false);
                Fields.cb_badge_returned_optional.setChecked(false);
                database.updateSignInSetupFields("badge returned","Mandatory");
                break;
            case R.id.cb_badge_returned_not_used:
                Fields.cb_badge_returned_mandatory.setChecked(false);
                Fields.cb_badge_returned_not_used.setChecked(true);
                Fields.cb_badge_returned_optional.setChecked(false);
                database.updateSignInSetupFields("badge returned","Optional");
                break;
            case R.id.cb_badge_returned_optional:
                Fields.cb_badge_returned_mandatory.setChecked(false);
                Fields.cb_badge_returned_not_used.setChecked(false);
                Fields.cb_badge_returned_optional.setChecked(true);
                database.updateSignInSetupFields("badge returned","Not Used");
                break;
        }
    }



}
