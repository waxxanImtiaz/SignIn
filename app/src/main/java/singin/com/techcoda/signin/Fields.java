package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

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

    //FIELDS OF SIGNATURE CAPTURE
    public static CheckBox cb_signature_capture_mandatory;
    public static CheckBox cb_signature_capture_not_used;
    public static CheckBox cb_signature_capture_optional;
    public static TextView tv_signature_capture;
    public static ImageView iv_signature_capture;
    public static TextView op_signature_capture;
    //FIELDS OF VISITOR AGREEMENT TEXT
    public static TextView tv_visitor_agreement_text;
    public static ImageView iv_visitor_agreement_text;
    public static EditText et_visitor_agreement_text;
    public static Button bt_agree;
    public static Button bt_not_agree;

    //FIELDS OF HERE TO SEE
    public static CheckBox cb_here_to_see_mandatory;
    public static CheckBox cb_here_to_see_not_used;
    public static CheckBox cb_here_to_see_optional;
    public static TextView tv_here_to_see;
    public static ImageView iv_here_to_see;

    //ROWS OF SETUP TABLE

    public static TableRow row_company;
    public static TableRow row_city;
    public static TableRow row_address;
    public static TableRow row_email;
    public static TableRow row_state;
    public static TableRow row_zip_code;
    public static TableRow row_phone;
    public static TableRow row_here_to_see;
    public static TableRow row_signature_capture;
    public static TableRow row_photo_capture;
    public static TableRow row_guide_escort;
    public static TableRow row_badge_number;
    public static TableRow row_vehicle_make_model;
    public static TableRow row_vehicle_color;
    public static TableRow row_vehicle_license_plate;
    public static TableRow row_comments;
    public static TableRow row_custom_field_one;
    public static TableRow row_custom_field_two;
    public static TableRow row_custom_field_three;
    public static TableRow row_custom_field_four;
    public static TableRow row_custom_field_five;
    public static TableRow row_visitor_agreement_text;
    public static Button btn_email_report_pdf;
    public static Button tn_delete_records;
    public static Button btn_print_reports;
    public static Button btn_export;
    public static Button btn_email_search_data_csv;


    //initialize setupFields
    public static void initilizeSetupFilds(View container,DropDownMenuHandler handler)
    {
        Fields.iv_company = (ImageView)container.findViewById(R.id.iv_company);
        Fields.tv_company = (TextView)container.findViewById(R.id.tv_company);
        Fields.op_company = (TextView)container.findViewById(R.id.op_company);
        Fields.op_signature_capture = (TextView)container.findViewById(R.id.op_signature_capture);
        Fields.op_photo_capture = (TextView)container.findViewById(R.id.op_photo_capture);
        Fields.tv_address = (TextView)container.findViewById(R.id.tv_address);
        Fields.iv_address = (ImageView)container.findViewById(R.id.iv_address);
        Fields.tv_here_to_see = (TextView)container.findViewById(R.id.tv_here_to_see);
        Fields.iv_here_to_see = (ImageView)container.findViewById(R.id.iv_here_to_see);


        Fields.iv_signature_capture = (ImageView)container.findViewById(R.id.iv_signature_capture);
        Fields.tv_signature_capture = (TextView)container.findViewById(R.id.tv_signature_capture);
        Fields.iv_city = (ImageView)container.findViewById(R.id.iv_city);
        Fields.tv_city = (TextView)container.findViewById(R.id.tv_city);
        Fields.iv_photo_capture = (ImageView)container.findViewById(R.id.iv_photo_capture);
        Fields.tv_photo_capture = (TextView)container.findViewById(R.id.tv_photo_capture);
        Fields.iv_state = (ImageView)container.findViewById(R.id.iv_state);
        Fields.tv_state = (TextView)container.findViewById(R.id.tv_state);
        Fields.iv_zip = (ImageView)container.findViewById(R.id.iv_zip_code);
        Fields.tv_zip_code = (TextView)container.findViewById(R.id.tv_zip_code);
        Fields.iv_phone = (ImageView)container.findViewById(R.id.iv_phone);
        Fields.tv_phone = (TextView)container.findViewById(R.id.tv_phone);
        Fields.iv_email = (ImageView)container.findViewById(R.id.iv_email);
        Fields.tv_email = (TextView)container.findViewById(R.id.tv_email);
        tv_visitor_agreement_text = (TextView)container.findViewById(R.id.tv_visitor_agreement_text);
        iv_visitor_agreement_text = (ImageView)container.findViewById(R.id.iv_visitor_agrement_text);

        //INITIALIZE ROWS
        row_company = (TableRow)container.findViewById(R.id.row_company);
        row_city = (TableRow)container.findViewById(R.id.row_city);
        row_address = (TableRow)container.findViewById(R.id.row_address);
        row_email = (TableRow)container.findViewById(R.id.row_email);
        row_state = (TableRow)container.findViewById(R.id.row_state);
        row_zip_code = (TableRow)container.findViewById(R.id.row_zip_code);
        row_phone = (TableRow)container.findViewById(R.id.row_phone);
        row_here_to_see = (TableRow)container.findViewById(R.id.row_here_to_see);
        row_signature_capture = (TableRow)container.findViewById(R.id.row_signature_capture);
        row_photo_capture = (TableRow)container.findViewById(R.id.row_photo_capture);
        row_guide_escort = (TableRow)container.findViewById(R.id.row_guide_escrot);
        row_badge_number = (TableRow)container.findViewById(R.id.row_badge_number);
        row_vehicle_make_model = (TableRow)container.findViewById(R.id.row_vehicle_make_model);
        row_vehicle_color = (TableRow)container.findViewById(R.id.row_vehicle_color);
        row_vehicle_license_plate = (TableRow)container.findViewById(R.id.row_vehicle_license_plate);
        row_comments = (TableRow)container.findViewById(R.id.row_comments);
        row_custom_field_one = (TableRow)container.findViewById(R.id.row_custom_field_one);
        row_custom_field_two = (TableRow)container.findViewById(R.id.row_custom_field_two);
        row_custom_field_three = (TableRow)container.findViewById(R.id.row_custom_field_three);
        row_custom_field_four = (TableRow)container.findViewById(R.id.row_custom_field_four);
        row_custom_field_five = (TableRow)container.findViewById(R.id.row_custom_field_five);
        row_visitor_agreement_text = (TableRow)container.findViewById(R.id.row_visitor_agreement_text);


        //HANDLE EVENTS
        Fields.iv_company.setOnClickListener(handler);
        Fields.tv_company.setOnClickListener(handler);
        Fields.tv_address.setOnClickListener(handler);
        Fields.iv_address.setOnClickListener(handler);
        Fields.tv_city.setOnClickListener(handler);
        Fields.iv_city.setOnClickListener(handler);
        Fields.tv_state.setOnClickListener(handler);
        Fields.iv_state.setOnClickListener(handler);
        Fields.tv_zip_code.setOnClickListener(handler);
        Fields.iv_zip.setOnClickListener(handler);
        Fields.tv_phone.setOnClickListener(handler);
        Fields.iv_phone.setOnClickListener(handler);
        Fields.tv_email.setOnClickListener(handler);
        Fields.iv_email.setOnClickListener(handler);
        Fields.iv_photo_capture.setOnClickListener(handler);
        Fields.tv_photo_capture.setOnClickListener(handler);
        Fields.iv_signature_capture.setOnClickListener(handler);
        Fields.tv_signature_capture.setOnClickListener(handler);
        Fields.iv_visitor_agreement_text.setOnClickListener(handler);
        Fields.tv_visitor_agreement_text.setOnClickListener(handler);
        Fields.tv_here_to_see.setOnClickListener(handler);
        Fields.iv_here_to_see.setOnClickListener(handler);

        //ROW EVENTS
        row_company.setOnClickListener(handler);
        row_city.setOnClickListener(handler);
        row_address.setOnClickListener(handler);
        row_email.setOnClickListener(handler);
        row_state.setOnClickListener(handler);
        row_zip_code.setOnClickListener(handler);
        row_phone.setOnClickListener(handler);
        row_here_to_see.setOnClickListener(handler);
        row_signature_capture.setOnClickListener(handler);
        row_photo_capture.setOnClickListener(handler);
        row_guide_escort.setOnClickListener(handler);
        row_badge_number.setOnClickListener(handler);
        row_vehicle_make_model.setOnClickListener(handler);
        row_vehicle_color.setOnClickListener(handler);
        row_vehicle_license_plate.setOnClickListener(handler);
        row_comments.setOnClickListener(handler);
        row_custom_field_one.setOnClickListener(handler);
        row_custom_field_two.setOnClickListener(handler);
        row_custom_field_three.setOnClickListener(handler);
        row_custom_field_four.setOnClickListener(handler);
        row_custom_field_five.setOnClickListener(handler);
        row_visitor_agreement_text.setOnClickListener(handler);
    }//end of initializeSetupFields method
    public static void initializeImageButtonPopupMenu()
    {

    }
}

//FONT FAMILIES
class FontFamilies{
    public static int fontFamiliesIndex=0;
    public static String[] fontFamilies = new String[]{"serif","sans-serif","verdana","serif-monospace","casual"
            ,"cursive","monospace","sans-serif-thin","sans-serif-condensed","sans-serif-medium","sans-serif-light","sans-serif-smallcaps"};


}

