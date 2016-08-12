package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by android on 8/1/2016.
 */
public class RestoreCurrentStateOfApplication {
    private Context mContext;
    private View container;
    private Database database;
    private String companySate;
    public RestoreCurrentStateOfApplication(Context context,View container)
    {
        this.mContext = context;
        this.container = container;
        database = new Database(mContext);
        companySate = database.isFieldEnabled("company");
    }

    //CHECK AND LOAD THE STATE OF COMPANY OPTIONS MENU LIST..
    public void loadCompanySubMenu(){

        if(companySate.equals("Not Used"))
        {
            Fields.ch_company_not_used.setChecked(true);
            Fields.ch_company_optional.setChecked(false);
            Fields.ch_company_mendatory.setChecked(false);
        }else if(companySate.equals("Mandatory"))
        {

            Fields.ch_company_not_used.setChecked(false);
            Fields.ch_company_optional.setChecked(false);
            Fields.ch_company_mendatory.setChecked(true);
        }
        else if(companySate.equals("Optional"))
        {

            Fields.ch_company_not_used.setChecked(false);
            Fields.ch_company_optional.setChecked(true);
            Fields.ch_company_mendatory.setChecked(false);
        }
    }
    public void loadPhotoCaptureSubMenuState()
    {
        String photoCaptureState = database.isFieldEnabled("photo capture");
//        String autoPhotoCapture = database.isFieldEnabled("automatic photo capture");
        String photoSizeInEmail = database.isFieldEnabled("photo size in email");
        if(photoCaptureState.equals("Mandatory"))
        {
            Fields.cb_photo_capture_mandatory.setChecked(true);
            Fields.cb_photo_capture_optional.setChecked(false);
        }
        else if(photoCaptureState.equals("Optional"))
        {
            Fields.cb_photo_capture_mandatory.setChecked(false);
            Fields.cb_photo_capture_optional.setChecked(true);
        }
//        if(autoPhotoCapture.equals("yes"))
//        {
//            Fields.cb_auto_photo_capture.setChecked(true);
//        }
//        else if(autoPhotoCapture.equals("no"))
//            Fields.cb_auto_photo_capture.setChecked(false);

        if(photoSizeInEmail.equals("small")){
            Fields.cb_photo_capture_small.setChecked(true);
            Fields.cb_photo_capture_large.setChecked(false);
            Fields.cb_photo_capture_medium.setChecked(false);
        }
        else if(photoSizeInEmail.equals("medium")){
            Fields.cb_photo_capture_small.setChecked(false);
            Fields.cb_photo_capture_large.setChecked(false);
            Fields.cb_photo_capture_medium.setChecked(true);
        }
        else if(photoSizeInEmail.equals("large")){
            Fields.cb_photo_capture_small.setChecked(false);
            Fields.cb_photo_capture_large.setChecked(true);
            Fields.cb_photo_capture_medium.setChecked(false);
        }
    }
    //CHECK AND LOAD THE STATE OF ADDRESS OPTIONS MENU LIST..
    public void loadAddressSubMenuState(){
        String addressOptions = database.isFieldEnabled("address");

        if(addressOptions.equals("Mandatory"))
        {
            Fields.cb_address_mandatory.setChecked(true);
            Fields.cb_address_not_used.setChecked(false);
            Fields.cb_address_optoinal.setChecked(false);
        }
        else if(addressOptions.equals("Not Used"))
        {
            Fields.cb_address_mandatory.setChecked(false);
            Fields.cb_address_not_used.setChecked(true);
            Fields.cb_address_optoinal.setChecked(false);
        }
        else if(addressOptions.equals("Optional"))
        {
            Fields.cb_address_mandatory.setChecked(false);
            Fields.cb_address_not_used.setChecked(false);
            Fields.cb_address_optoinal.setChecked(true);
        }
    }
    //CHECK AND LOAD THE STATE OF CITY OPTIONS MENU LIST..
    public void loadCitySubMenuState(){
        String cityOptions = database.isFieldEnabled("city");
        if(cityOptions.equals("Mandatory"))
        {
            Fields.cb_city_mandatory.setChecked(true);
            Fields.cb_city_not_used.setChecked(false);
            Fields.cb_city_optional.setChecked(false);
        }
        else if(cityOptions.equals("Not Used"))
        {
            Fields.cb_city_mandatory.setChecked(false);
            Fields.cb_city_not_used.setChecked(true);
            Fields.cb_city_optional.setChecked(false);
        }
        else if(cityOptions.equals("Optional"))
        {
            Fields.cb_city_mandatory.setChecked(false);
            Fields.cb_city_not_used.setChecked(false);
            Fields.cb_city_optional.setChecked(true);
        }
    }//END OF loadCitySubMenuState method

    //CHECK AND LOAD STATE OF STATE OPTIONS MENU LIST..
    public void loadStateSubMenuState(){
        String stateOptions = database.isFieldEnabled("state");
        if(stateOptions.equals("Mandatory"))
        {
            Fields.cb_state_mandatory.setChecked(true);
            Fields.cb_state_not_used.setChecked(false);
            Fields.cb_state_optional.setChecked(false);
        }
        else if(stateOptions.equals("Not Used"))
        {
            Fields.cb_state_mandatory.setChecked(false);
            Fields.cb_state_not_used.setChecked(true);
            Fields.cb_state_optional.setChecked(false);
        }
        else if(stateOptions.equals("Optional"))
        {
            Fields.cb_state_mandatory.setChecked(false);
            Fields.cb_state_not_used.setChecked(false);
            Fields.cb_state_optional.setChecked(true);
        }
    }//end of loadStateSubMenuState method..
    // CHECK AND LOAD STATE OF ZIP CODE OPTIONS MENU LIST..
    public void loadZipCodeSubMenuState(){
        String zipOptions = database.isFieldEnabled("zip code");
        if(zipOptions.equals("Mandatory"))
        {
            Fields.cb_zip_code_mandatory.setChecked(true);
            Fields.cb_zip_code_not_used.setChecked(false);
            Fields.cb_zip_code_optional.setChecked(false);
        }
        else if(zipOptions.equals("Not Used"))
        {
            Fields.cb_zip_code_mandatory.setChecked(false);
            Fields.cb_zip_code_not_used.setChecked(true);
            Fields.cb_zip_code_optional.setChecked(false);
        }
        else if(zipOptions.equals("Optional"))
        {
            Fields.cb_zip_code_mandatory.setChecked(false);
            Fields.cb_zip_code_not_used.setChecked(false);
            Fields.cb_zip_code_optional.setChecked(true);
        }
    }//end of loadStateSubMenuState method..

    // CHECK AND LOAD STATE OF PHONE OPTIONS MENU LIST..
    public void loadPhoneSubMenuState(){
        String phoneOptions = database.isFieldEnabled("phone");
        if(phoneOptions.equals("Mandatory"))
        {
            Fields.cb_phone_mandatory.setChecked(true);
            Fields.cb_phone_not_used.setChecked(false);
            Fields.cb_phone_optional.setChecked(false);
        }
        else if(phoneOptions.equals("Not Used"))
        {
            Fields.cb_phone_mandatory.setChecked(false);
            Fields.cb_phone_not_used.setChecked(true);
            Fields.cb_phone_optional.setChecked(false);
        }
        else if(phoneOptions.equals("Optional"))
        {
            Fields.cb_phone_mandatory.setChecked(false);
            Fields.cb_phone_not_used.setChecked(false);
            Fields.cb_phone_optional.setChecked(true);
        }
    }//end of loadStateSubMenuState method..

    // CHECK AND LOAD STATE OF EMAIL OPTIONS MENU LIST..
    public void loadEmailSubMenuState(){
        String emailOptions = database.isFieldEnabled("email");
        if(emailOptions.equals("Mandatory"))
        {
            Fields.cb_email_mandatory.setChecked(true);
            Fields.cb_email_not_used.setChecked(false);
            Fields.cb_email_optional.setChecked(false);
        }
        else if(emailOptions.equals("Not Used"))
        {
            Fields.cb_email_mandatory.setChecked(false);
            Fields.cb_email_not_used.setChecked(true);
            Fields.cb_email_optional.setChecked(false);
        }
        else if(emailOptions.equals("Optional"))
        {
            Fields.cb_email_mandatory.setChecked(false);
            Fields.cb_email_not_used.setChecked(false);
            Fields.cb_email_optional.setChecked(true);
        }
    }//end of loadEmailSubMenuState method..
    // CHECK AND LOAD STATE OF SIGNATURE CAPTURE OPTIONS MENU LIST..
    public void loadSignatureCaptureSubMenuState(){
        String signature_captureOptions = database.isFieldEnabled("signature capture");
        if(signature_captureOptions.equals("Mandatory"))
        {
            Fields.cb_signature_capture_mandatory.setChecked(true);
            Fields.cb_signature_capture_not_used.setChecked(false);
            Fields.cb_signature_capture_optional.setChecked(false);
        }
        else if(signature_captureOptions.equals("Not Used"))
        {
            Fields.cb_signature_capture_mandatory.setChecked(false);
            Fields.cb_signature_capture_not_used.setChecked(true);
            Fields.cb_signature_capture_optional.setChecked(false);
        }
        else if(signature_captureOptions.equals("Optional"))
        {
            Fields.cb_signature_capture_mandatory.setChecked(false);
            Fields.cb_signature_capture_not_used.setChecked(false);
            Fields.cb_signature_capture_optional.setChecked(true);
        }
    }//end of loadSignatureCaptureSubMenuState method

    public void loadHereToSeeSubMenu(){
        String here_to_seeOptions = database.isFieldEnabled("here to see");
        if(here_to_seeOptions.equals("Mandatory"))
        {
            Fields.cb_here_to_see_mandatory.setChecked(true);
            Fields.cb_here_to_see_not_used.setChecked(false);
            Fields.cb_here_to_see_optional.setChecked(false);
        }
        else if(here_to_seeOptions.equals("Not Used"))
        {
            Fields.cb_here_to_see_mandatory.setChecked(false);
            Fields.cb_here_to_see_not_used.setChecked(true);
            Fields.cb_here_to_see_optional.setChecked(false);
        }
        else if(here_to_seeOptions.equals("Optional"))
        {
            Fields.cb_here_to_see_mandatory.setChecked(false);
            Fields.cb_here_to_see_not_used.setChecked(false);
            Fields.cb_here_to_see_optional.setChecked(true);
        }
    }
    public void loadGuideEscortSubMenu(){
        String guide_escortOptions = database.isFieldEnabled("guide escort");
        if(guide_escortOptions.equals("Mandatory"))
        {
            Fields.cb_guide_escort_mandatory.setChecked(true);
            Fields.cb_guide_escort_not_used.setChecked(false);
            Fields.cb_guide_escort_optoinal.setChecked(false);
        }
        else if(guide_escortOptions.equals("Not Used"))
        {
            Fields.cb_guide_escort_mandatory.setChecked(false);
            Fields.cb_guide_escort_not_used.setChecked(true);
            Fields.cb_guide_escort_optoinal.setChecked(false);
        }
        else if(guide_escortOptions.equals("Optional"))
        {
            Fields.cb_guide_escort_mandatory.setChecked(false);
            Fields.cb_guide_escort_not_used.setChecked(false);
            Fields.cb_guide_escort_optoinal.setChecked(true);
        }
    }

    public void loadBadgeReturnedSubMenuState(){
        String badge_returnedOptions = database.isFieldEnabled("badge returned");
        if(badge_returnedOptions.equals("Mandatory"))
        {
            Fields.cb_badge_returned_mandatory.setChecked(true);
            Fields.cb_badge_returned_not_used.setChecked(false);
            Fields.cb_badge_returned_optional.setChecked(false);
        }
        else if(badge_returnedOptions.equals("Not Used"))
        {
            Fields.cb_badge_returned_mandatory.setChecked(false);
            Fields.cb_badge_returned_not_used.setChecked(true);
            Fields.cb_badge_returned_optional.setChecked(false);
        }
        else if(badge_returnedOptions.equals("Optional"))
        {
            Fields.cb_badge_returned_mandatory.setChecked(false);
            Fields.cb_badge_returned_not_used.setChecked(false);
            Fields.cb_badge_returned_optional.setChecked(true);
        }
    }

    public void loadBadgeNumberSubMenuState(){
        String badge_numberOptions = database.isFieldEnabled("badge number");
        if(badge_numberOptions.equals("Mandatory"))
        {
            Fields.cb_badge_number_mandatory.setChecked(true);
            Fields.cb_badge_number_not_used.setChecked(false);
            Fields.cb_badge_number_optional.setChecked(false);
        }
        else if(badge_numberOptions.equals("Not Used"))
        {
            Fields.cb_badge_number_mandatory.setChecked(false);
            Fields.cb_badge_number_not_used.setChecked(true);
            Fields.cb_badge_number_optional.setChecked(false);
        }
        else if(badge_numberOptions.equals("Optional"))
        {
            Fields.cb_badge_number_mandatory.setChecked(false);
            Fields.cb_badge_number_not_used.setChecked(false);
            Fields.cb_badge_number_optional.setChecked(true);
        }
    }
    public void loadCommentsSubMenuState(){
        String commentsOptions = database.isFieldEnabled("comments");
        if(commentsOptions.equals("Mandatory"))
        {
            Fields.cb_comments_mandatory.setChecked(true);
            Fields.cb_comments_not_used.setChecked(false);
            Fields.cb_comments_optoinal.setChecked(false);
        }
        else if(commentsOptions.equals("Not Used"))
        {
            Fields.cb_comments_mandatory.setChecked(false);
            Fields.cb_comments_not_used.setChecked(true);
            Fields.cb_comments_optoinal.setChecked(false);
        }
        else if(commentsOptions.equals("Optional"))
        {
            Fields.cb_comments_mandatory.setChecked(false);
            Fields.cb_comments_not_used.setChecked(false);
            Fields.cb_comments_optoinal.setChecked(true);
        }
    }

    public void loadAgreement(){
        String signInAgreementOptions = database.isFieldEnabled("signin agreement");
        String signOutAgreementOptions = database.isFieldEnabled("signout agreement");

        if(signInAgreementOptions.equals("true"))
        {
            Fields.cb_signin_agreement.setChecked(true);
        }
        else
            Fields.cb_signin_agreement.setChecked(false);


        if(signOutAgreementOptions.equals("false"))
        {
            Fields.cb_signout_agreement.setChecked(false);
        }
        else
            Fields.cb_signout_agreement.setChecked(true);
    }

}

