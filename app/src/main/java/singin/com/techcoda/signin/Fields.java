package singin.com.techcoda.signin;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by android on 7/27/2016.
 */
public class Fields {
    //LAYOUTS AND SCROLLERS
    public static int[] scrollers = {R.id.top_drop_down_scroller,R.id.inner_drop_down_scroller};
    public static int[] scrollerLayouts = {R.id.top_drop_down_layout,R.id.inner_drop_down_layout};
    //FIELDS OF COMPANY
    public static TextView tv_company;
    public static ImageView iv_company;
    public static CheckBox ch_company_not_used;
    public static CheckBox ch_company_mendatory;
    public static CheckBox ch_company_optional;
    public static TextView opCompany;

    //FIELDS OF PHOTO CAPTURE SUB MENU
    public static ImageView iv_photo_capture;
    public static TextView tv_photo_capture;
    public static CheckBox cb_auto_photo_capture;
    public static CheckBox cb_photo_capture_small;
    public static CheckBox cb_photo_capture_large;
    public static CheckBox cb_photo_capture_medium;
    public static CheckBox cb_photo_capture_optional;
    public static CheckBox cb_photo_capture_mandatory;
    public static TextView op_company;
    public static TextView op_photo_capture;

    //FIELDS OF ADDRESS
    public static CheckBox cb_address_mandatory;
    public static CheckBox cb_address_not_used;
    public static CheckBox cb_address_optoinal;
    public static TextView tv_address;
    public static ImageView iv_address;

    //FIELDS OF CITY
    public static CheckBox cb_city_mandatory;
    public static CheckBox cb_city_not_used;
    public static CheckBox cb_city_optional;
    public static TextView tv_city;
    public static ImageView iv_city;

    //FIELDS OF STATE
    public static CheckBox cb_state_mandatory;
    public static CheckBox cb_state_not_used;
    public static CheckBox cb_state_optional;
    public static TextView tv_state;
    public static ImageView iv_state;
    //FIELDS OF ZIP CIDE
    public static CheckBox cb_zip_code_mandatory;
    public static CheckBox cb_zip_code_not_used;
    public static CheckBox cb_zip_code_optional;
    public static TextView tv_zip_code;
    public static ImageView iv_zip;
    //FIELDS OF PHONE
    public static CheckBox cb_phone_mandatory;
    public static CheckBox cb_phone_not_used;
    public static CheckBox cb_phone_optional;
    public static TextView tv_phone;
    public static ImageView iv_phone;
    //FIELDS OF EMAIL
    public static CheckBox cb_email_mandatory;
    public static CheckBox cb_email_not_used;
    public static CheckBox cb_email_optional;
    public static TextView tv_email;
    public static ImageView iv_email;

}

//FONT FAMILIES
class FontFamilies{
    public static int fontFamiliesIndex=0;
    public static String[] fontFamilies = new String[]{"serif","sans-serif","verdana","serif-monospace","casual"
            ,"cursive","monospace","sans-serif-thin","sans-serif-condensed","sans-serif-medium","sans-serif-light","sans-serif-smallcaps"};


}

