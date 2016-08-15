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

import java.util.List;

import singin.com.techcoda.signin.designmenuhandlers.DesignFontColorMenuHandler;

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
    //public static TextView opCompany;

    //FIELDS OF PHOTO CAPTURE SUB MENU
    public static ImageView iv_photo_capture;
    public static TextView tv_photo_capture;
   // public static CheckBox cb_auto_photo_capture;
    public static CheckBox cb_photo_capture_small;
    public static CheckBox cb_photo_capture_large;
    public static CheckBox cb_photo_capture_medium;
    public static CheckBox cb_photo_capture_optional;
    public static CheckBox cb_photo_capture_mandatory;
    public static TextView op_company;
    public static TextView op_city;
    public static TextView op_email;
    public static TextView op_state;
    public static TextView op_guideName;
    public static TextView op_photo_capture;
    public static TextView op_address;
    public static TextView op_zipCode;
    public static TextView op_phone;
    public static TextView op_hereToSee;
    public static TextView op_badgeReturned;
    public static TextView op_badgeNumber;
    public static TextView op_vehicleColor;
    public static TextView op_vehicleMakeModel;
    public static TextView op_vehicleLisencePlate;
    public static TextView op_comments;
    public static TextView op_customFieldOne;
    public static TextView op_customFieldTwo;
    public static TextView op_customFieldThree;
    public static TextView op_customFieldFour;
    public static TextView op_customFieldFive;



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

    //FIELDS OF BADGE NUMBER
    public static CheckBox cb_badge_number_mandatory;
    public static CheckBox cb_badge_number_not_used;
    public static CheckBox cb_badge_number_optional;
    public static TextView tv_badge_number;
    public static ImageView iv_badge_number;
    //FIELDS OF VEHICLE LISENCE PLATE
    public static CheckBox cb_vehicle_lisence_plate_mandatory;
    public static CheckBox cb_vehicle_lisence_plate_not_used;
    public static CheckBox cb_vehicle_lisence_plate_optoinal;
    public static TextView tv_vehicle_lisence_plate;
    public static ImageView iv_vehicle_lisence_plate;

    //FIELDS OF VEHICLE COLOR
    public static CheckBox cb_vehicle_color_mandatory;
    public static CheckBox cb_vehicle_color_not_used;
    public static CheckBox cb_vehicle_color_optoinal;
    public static TextView tv_vehicle_color;
    public static ImageView iv_vehicle_color;

    //FIELDS OF VEHICLE MAKE MODEL
    public static CheckBox cb_vehicle_make_model_mandatory;
    public static CheckBox cb_vehicle_make_model_not_used;
    public static CheckBox cb_vehicle_make_model_optoinal;
    public static TextView tv_vehicle_make_model;
    public static ImageView iv_vehicle_make_model;

    //FIELDS OF COMMENTS
    public static CheckBox cb_comments_mandatory;
    public static CheckBox cb_comments_not_used;
    public static CheckBox cb_comments_optoinal;
    public static TextView tv_comments;
    public static ImageView iv_comments;

    //FIELDS OF badge_returned
    public static CheckBox cb_badge_returned_mandatory;
    public static CheckBox cb_badge_returned_not_used;
    public static CheckBox cb_badge_returned_optional;
    public static TextView tv_badge_returned;
    public static ImageView iv_badge_returned;

    public static CheckBox cb_signin_agreement;
    public static CheckBox cb_signout_agreement;
    //FIELDS OF GUIDE/ESCORT NAME
    public static CheckBox cb_guide_escort_mandatory;
    public static CheckBox cb_guide_escort_not_used;
    public static CheckBox cb_guide_escort_optoinal;
    public static TextView tv_guide_escort;
    public static ImageView iv_guide_escort;

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

    public static View setupContainer;
//    //FIELDS OF VEHICLE LISENCE PLATE
//    public static CheckBox cb_vehicle_lisence_plate_mandatory;
//    public static CheckBox cb_vehicle_lisence_plate_not_used;
//    public static CheckBox cb_vehicle_lisence_plate_optional;
//    public static TextView tv_vehicle_lisence_plate;
//    public static ImageView iv_vehicle_lisence_plate;
    //FIELDS OF BADGE NUMBER
//    public static CheckBox cb_badge_number_mandatory;
//    public static CheckBox cb_badge_number_not_used;
//    public static CheckBox cb_badge_number_optional;
//    public static TextView tv_badge_number;
//    public static ImageView iv_badge_number;
    //FIELDS OF VEHICLE MAKE MODEL
//    public static CheckBox cb_vehicle_make_model_mandatory;
//    public static CheckBox cb_vehicle_make_model_not_used;
//    public static CheckBox cb_vehicle_make_model_optional;
//    public static TextView tv_vehicle_make_model;
//    public static ImageView iv_vehicle_make_model;

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
    public static TableRow row_badge_returned;
    public static TableRow row_visitor_agreement_text;


    public static Button btn_email_report_pdf;
    public static Button btn_delete_records;
    public static Button btn_print_reports;
    public static Button btn_export;
    public static Button btn_email_search_data_csv;

    public static ReportDropDownHandler reportDropDownHandler;
    //initialize setupFields
    public static void initilizeSetupFilds(View container,DropDownMenuHandler handler)
    {
        setupContainer = container;
        Fields.iv_company = (ImageView)container.findViewById(R.id.iv_company);
        Fields.tv_company = (TextView)container.findViewById(R.id.tv_company);
        Fields.op_company = (TextView)container.findViewById(R.id.op_company);
        Fields.op_signature_capture = (TextView)container.findViewById(R.id.op_signature_capture);
        Fields.op_photo_capture = (TextView)container.findViewById(R.id.op_photo_capture);
        Fields.tv_address = (TextView)container.findViewById(R.id.tv_address);
        Fields.iv_address = (ImageView)container.findViewById(R.id.iv_address);
        Fields.tv_vehicle_make_model = (TextView)container.findViewById(R.id.tv_vehicle_make_model);
        Fields.iv_vehicle_make_model = (ImageView)container.findViewById(R.id.iv_vehicle_make_model);;
        Fields.tv_vehicle_color = (TextView)container.findViewById(R.id.tv_vehicle_color);
        Fields.iv_vehicle_color = (ImageView)container.findViewById(R.id.iv_vehicle_color);
        Fields.tv_here_to_see = (TextView)container.findViewById(R.id.tv_here_to_see);
        Fields.iv_here_to_see = (ImageView)container.findViewById(R.id.iv_here_to_see);
//        Fields.tv_badge_returned = (TextView)container.findViewById(R.id.tv_badge_returned);
//        Fields.iv_badge_returned = (ImageView)container.findViewById(R.id.iv_badge_returned);
        Fields.iv_badge_number = (ImageView)container.findViewById(R.id.iv_badge_number);
        Fields.tv_badge_number = (TextView)container.findViewById(R.id.tv_badge_number);
        cb_signin_agreement = (CheckBox)container.findViewById(R.id.cb_show_visitor_agreement_upon_signin);
        cb_signout_agreement = (CheckBox)container.findViewById(R.id.cb_show_visitor_agreement_upon_signout);
        Fields.iv_vehicle_lisence_plate = (ImageView)container.findViewById(R.id.iv_vehicle_license_plate);
        Fields.tv_vehicle_lisence_plate = (TextView)container.findViewById(R.id.tv_vehicle_license_plate);
//        Fields.iv_vehicle_make_model = (ImageView)container.findViewById(R.id.iv_vehicle_make_model);
//        Fields.tv_vehicle_make_model = (TextView)container.findViewById(R.id.tv_vehicle_make_model);
//        Fields.iv_vehicle_color = (ImageView)container.findViewById(R.id.iv_vehicle_color);
//        Fields.tv_vehicle_color = (TextView)container.findViewById(R.id.tv_vehicle_color);
        Fields.iv_comments = (ImageView)container.findViewById(R.id.iv_comments);
        Fields.tv_comments = (TextView)container.findViewById(R.id.tv_comments);


        Fields.iv_signature_capture = (ImageView)container.findViewById(R.id.iv_signature_capture);
        Fields.tv_signature_capture = (TextView)container.findViewById(R.id.tv_signature_capture);
        Fields.iv_city = (ImageView)container.findViewById(R.id.iv_city);
        Fields.tv_city = (TextView)container.findViewById(R.id.tv_city);
        Fields.iv_badge_returned = (ImageView)container.findViewById(R.id.iv_badge_returned);
        Fields.tv_badge_returned = (TextView)container.findViewById(R.id.tv_badge_returned);
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
        Fields.iv_guide_escort = (ImageView)container.findViewById(R.id.iv_guide_escort_name);
        Fields.tv_guide_escort = (TextView)container.findViewById(R.id.tv_guide_escort_name);
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
        row_badge_returned = (TableRow)container.findViewById(R.id.row_badge_returned);
        row_custom_field_three = (TableRow)container.findViewById(R.id.row_custom_field_three);
        row_custom_field_four = (TableRow)container.findViewById(R.id.row_custom_field_four);
        row_custom_field_five = (TableRow)container.findViewById(R.id.row_custom_field_five);
        row_visitor_agreement_text = (TableRow)container.findViewById(R.id.row_visitor_agreement_text);

        //HANDLE EVENTS
        Fields.iv_company.setOnClickListener(handler);
        Fields.tv_company.setOnClickListener(handler);
        Fields.iv_badge_returned.setOnClickListener(handler);
        Fields.tv_badge_returned.setOnClickListener(handler);
        Fields.tv_guide_escort.setOnClickListener(handler);
        Fields.tv_address.setOnClickListener(handler);
        Fields.iv_comments.setOnClickListener(handler);
        Fields.tv_comments.setOnClickListener(handler);
        Fields.iv_address.setOnClickListener(handler);
        Fields.iv_vehicle_color.setOnClickListener(handler);
        Fields.tv_vehicle_color.setOnClickListener(handler);
        Fields.tv_guide_escort.setOnClickListener(handler);
        Fields.iv_vehicle_make_model.setOnClickListener(handler);
        Fields.tv_vehicle_make_model.setOnClickListener(handler);
        Fields.iv_vehicle_lisence_plate.setOnClickListener(handler);
        Fields.tv_vehicle_lisence_plate.setOnClickListener(handler);
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
        Fields.tv_badge_number.setOnClickListener(handler);
        Fields.iv_badge_number.setOnClickListener(handler);
        cb_signin_agreement.setOnClickListener(handler);
        cb_signout_agreement.setOnClickListener(handler);

        //Intialize option fields

        op_company = (TextView)container.findViewById(R.id.op_company);
        op_city = (TextView)container.findViewById(R.id.op_city);
        op_address = (TextView)container.findViewById(R.id.op_address);
        op_photo_capture = (TextView)container.findViewById(R.id.op_photo_capture);
        op_state = (TextView)container.findViewById(R.id.op_state);
        op_phone = (TextView)container.findViewById(R.id.op_phone);
        op_badgeNumber = (TextView)container.findViewById(R.id.op_badge_number);
        op_badgeReturned = (TextView)container.findViewById(R.id.op_badge_returned);
        op_zipCode = (TextView)container.findViewById(R.id.op_zip_code);
        op_signature_capture = (TextView)container.findViewById(R.id.op_signature_capture);
        op_guideName = (TextView)container.findViewById(R.id.op_guide_escort_name);
        op_vehicleColor = (TextView)container.findViewById(R.id.op_vehicle_color);
        op_vehicleLisencePlate = (TextView)container.findViewById(R.id.op_vehicle_license_plate);
        op_vehicleMakeModel = (TextView)container.findViewById(R.id.op_vehicle_make_model);
        op_customFieldOne = (TextView)container.findViewById(R.id.op_custom_field_one);
        op_customFieldTwo = (TextView)container.findViewById(R.id.op_custom_field_two);
        op_customFieldThree = (TextView)container.findViewById(R.id.op_custom_field_three);
        op_customFieldFour = (TextView)container.findViewById(R.id.op_custom_field_four);
        op_customFieldFive = (TextView)container.findViewById(R.id.op_custom_field_five);
        op_hereToSee = (TextView)container.findViewById(R.id.op_here_to_see);
        op_comments = (TextView)container.findViewById(R.id.op_comments);
        op_email = (TextView)container.findViewById(R.id.op_email);


        //ROW EVENTS
        row_company.setOnClickListener(handler);
        row_badge_returned.setOnClickListener(handler);
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
    public static void initializeImageButtonPopupMenu(View container)
    {
        btn_delete_records = (Button)container.findViewById(R.id.btn_delete_records);
        btn_export = (Button) container.findViewById(R.id.btn_export);
        btn_email_report_pdf = (Button)container.findViewById(R.id.btn_email_report_pdf);
        btn_email_search_data_csv = (Button)container.findViewById(R.id.btn_email_search_data_csv);
        btn_print_reports = (Button)container.findViewById(R.id.btn_print_reports);
    }
}


class DesignMenuFields{

    //FONTS
    public static ImageView iv_font;
    public static TextView tv_font;
    public static TableRow row_font;
    public static TextView tv_font_one;
    public static TextView tv_font_two;
    public static TextView tv_font_three;
    public static TextView tv_font_four;
    public static TextView tv_font_five;
    public static TextView tv_font_six;
    public static TextView tv_font_seven;
    public static TextView tv_font_eight;
    public static TextView tv_font_nine;

    public static CheckBox cb_font_one;
    public static CheckBox cb_font_two;
    public static CheckBox cb_font_three;
    public static CheckBox cb_font_four;
    public static CheckBox cb_font_five;
    public static CheckBox cb_font_six;
    public static CheckBox cb_font_seven;
    public static CheckBox cb_font_eight;
    public static CheckBox cb_font_nine;

    //FONT COLORS
    public static ImageView iv_font_color;
    public static TextView tv_font_color;
    public static TableRow row_font_color;
    public static TextView tv_font_color_one;
    public static TextView tv_font_color_two;
    public static TextView tv_font_color_three;
    public static TextView tv_font_color_four;
    public static TextView tv_font_color_five;
    public static TextView tv_font_color_six;
    public static TextView tv_font_color_seven;
    public static TextView tv_font_color_eight;
    public static TextView tv_font_color_nine;
    public static TextView tv_font_color_ten;

    //COLOR CHECKBOXES
    public static TextView cb_font_color_one;
    public static TextView cb_font_color_two;
    public static TextView cb_font_color_three;
    public static TextView cb_font_color_four;
    public static TextView cb_font_color_five;
    public static TextView cb_font_color_six;
    public static TextView cb_font_color_seven;
    public static TextView cb_font_color_eight;
    public static TextView cb_font_color_nine;
    public static TextView cb_font_color_ten;


    public static void initilizeDesignMenuFields(View container,DropDownDesignMenuHandler handler){

        //FONT ROW
        iv_font = (ImageView)container.findViewById(R.id.iv_font);
        tv_font = (TextView)container.findViewById(R.id.tv_font);
        row_font = (TableRow)container.findViewById(R.id.row_font);

        iv_font.setOnClickListener(handler);
        tv_font.setOnClickListener(handler);
        row_font.setOnClickListener(handler);

        //FONT COLOR ROW
        iv_font_color = (ImageView)container.findViewById(R.id.iv_font_color);
        tv_font_color = (TextView)container.findViewById(R.id.tv_font_color);
        row_font_color = (TableRow) container.findViewById(R.id.row_font_color);

        iv_font_color.setOnClickListener(handler);
        tv_font_color.setOnClickListener(handler);
        row_font_color.setOnClickListener(handler);
    }
    public static void loadFontColors(View container,DesignFontColorMenuHandler handler)
    {
        cb_font_color_one = (CheckBox)container.findViewById(R.id.cb_font_color_one);
        cb_font_color_two = (CheckBox)container.findViewById(R.id.cb_font_color_two);
        cb_font_color_three = (CheckBox)container.findViewById(R.id.cb_font_color_three);
        cb_font_color_four = (CheckBox)container.findViewById(R.id.icb_font_color_four);
        cb_font_color_five = (CheckBox)container.findViewById(R.id.cb_font_color_five);
        cb_font_color_six = (CheckBox)container.findViewById(R.id.cb_font_color_six);
        cb_font_color_seven = (CheckBox)container.findViewById(R.id.cb_font_color_seven);
        cb_font_color_eight = (CheckBox)container.findViewById(R.id.cb_font_color_eight);
        cb_font_color_nine = (CheckBox)container.findViewById(R.id.cb_font_color_nine);
        cb_font_color_ten = (CheckBox)container.findViewById(R.id.cb_font_color_ten);


        cb_font_color_one.setOnClickListener(handler);
        cb_font_color_two.setOnClickListener(handler);
        cb_font_color_three.setOnClickListener(handler);
        cb_font_color_four.setOnClickListener(handler);
        cb_font_color_five.setOnClickListener(handler);
        cb_font_color_six.setOnClickListener(handler);
        cb_font_color_seven.setOnClickListener(handler);
        cb_font_color_eight.setOnClickListener(handler);
        cb_font_color_nine.setOnClickListener(handler);
        cb_font_color_ten.setOnClickListener(handler);

    }
    public static void loadFontNames(View container)
    {
        DesignMenuFields.tv_font_one = (TextView)container.findViewById(R.id.tv_font_one);
        DesignMenuFields.tv_font_two = (TextView)container.findViewById(R.id.tv_font_two);
        DesignMenuFields.tv_font_three = (TextView)container.findViewById(R.id.tv_font_three);
        DesignMenuFields.tv_font_four = (TextView)container.findViewById(R.id.tv_font_four);
        DesignMenuFields.tv_font_five = (TextView)container.findViewById(R.id.tv_font_five);
        DesignMenuFields.tv_font_six = (TextView)container.findViewById(R.id.tv_font_six);
        DesignMenuFields.tv_font_seven = (TextView)container.findViewById(R.id.tv_font_seven);
        DesignMenuFields.tv_font_eight = (TextView)container.findViewById(R.id.tv_font_eight);
        DesignMenuFields.tv_font_nine = (TextView)container.findViewById(R.id.tv_font_nine);

        tv_font_one.setText( "Hand writting");
        tv_font_two.setText("Groovey");
        tv_font_three.setText("Libel Suit Rg");
        tv_font_four.setText( "Tauri Regular");
        tv_font_five.setText("Roboto Black");
        tv_font_six.setText("Roboto Light");
        tv_font_seven.setText("Jumping Running");
        tv_font_eight.setText("Roboto Regular");
        tv_font_nine.setText("Airplane swash italic");
        //tv_font_ten.setText("Raleway Regular");
    }
}
//FONT FAMILIES
class FontFamilies{
    public static int fontFamiliesIndex=0;
    public static String[] fontFamilies = new String[]{"serif","sans-serif","verdana","serif-monospace","casual"
            ,"cursive","monospace","sans-serif-thin","sans-serif-condensed","sans-serif-medium","sans-serif-light","sans-serif-smallcaps"};


}

