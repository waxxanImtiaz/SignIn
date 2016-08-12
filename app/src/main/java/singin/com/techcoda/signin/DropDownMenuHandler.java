package singin.com.techcoda.signin;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by android on 7/29/2016.
 */
public class DropDownMenuHandler extends PopupWindows implements PopupWindow.OnDismissListener,View.OnClickListener {

    public View mRootView;
    private ImageView mArrowUp;
    private ImageView mArrowDown;
    private LayoutInflater mInflater;
    private ViewGroup mTrack;
    private ViewGroup mTrackTwo;
    private ViewGroup mTrackThree;
    public ScrollView mScroller;
    private boolean mDidAction;
    public int mAnimStyle;
    private int mOrientation;
    private int rootWidth=0;
    private Database database;
    private View container;
    private QuickAction.OnDismissListener mDismissListener;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private static final int ANIM_GROW_FROM_LEFT = 1;
    private static final int ANIM_GROW_FROM_RIGHT = 2;
    private static final int ANIM_GROW_FROM_CENTER = 3;
    public static final int ANIM_REFLECT = 4;
    public static final int ANIM_AUTO = 5;
    private SubMenuHandler handler;
   // private ViewFlipper flipper;
    //TOP DROP DOWN MENU HEADING
    private TextView setup;
    private TextView report;
    private TextView design;
    private ImageView company_chroven_left;
    private ImageView address_chroven_left;
    private TextView address_heading_left;
    private ImageView comments_chroven_left;
    private TextView comments_heading_left;
    private TextView company_heading_left;
    private ImageView here_to_see_chroven_left;
    private TextView here_to_see_heading_left;
    private ImageView photo_capture_chroven_left;
    private TextView photo_capture_heading_left;
    private ImageView city_chroven_left;
    private TextView city_heading_left;
    private ImageView state_chroven_left;
    private TextView state_heading_left;
    private ImageView zip_code_chroven_left;
    private TextView zip_code_heading_left;
    private ImageView phone_chroven_left;
    private TextView phone_heading_left;
    private ImageView badge_number_chroven_left;
    private TextView badge_number_heading_left;
    private ImageView email_chroven_left;
    private ImageView badge_returned_chroven_left;
    private TextView badge_returned_heading_left;
    private TextView email_heading_left;
    private ImageView guide_escort_chroven_left;
    private TextView guide_esort_heading_left;
    private ImageView signature_capture_chroven_left;
    private TextView signature_capture_heading_left;
    private TextView visitor_agreement_text_heading_left;
    private ImageView visitor_agreement_text_chroven_left;





    //HEADING INDICATOR
    private int heading_id;

    //SUB MENU DROP DOWN HEADING
    private LinearLayout font_sub_menu_heading_layout;
    private LinearLayout company_sub_menu_heading_layout;
    private LinearLayout photo_capture_sub_menu_heading_layout;
    private LinearLayout address_sub_menu_heading_layout;
    private LinearLayout city_sub_menu_heading_layout;
    private LinearLayout state_sub_menu_heading_layout;
    private LinearLayout zip_sub_menu_heading_layout;
    private LinearLayout phone_sub_menu_heading_layout;
    private LinearLayout comments_sub_menu_heading_layout;
    private LinearLayout badge_number_sub_menu_heading_layout;
    private LinearLayout email_sub_menu_heading_layout;
    private LinearLayout signature_capture_sub_menu_heading_layout;
    private LinearLayout visitor_agreement_text_sub_menu_heading_layout;
    private LinearLayout here_to_see_sub_menu_heading_layout;
    private LinearLayout guide_escort_sub_menu_heading_layout;
    private LinearLayout badge_returned_sub_menu_heading_layout;
    //RESTORE CURRENT STATE
    private RestoreCurrentStateOfApplication currentSate;
    private RestoreCurrentStateOfApplication setupMenuCurrentSate;




    public DropDownMenuHandler(Context context, int orientation,int heading_id) {
        super(context);

        setHeading_id(heading_id);
        mOrientation = orientation;
        setmInflater((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        if (mOrientation == HORIZONTAL) {
            setRootViewId(R.layout.popup_horizontal);
        } else {
            setRootViewId(R.layout.popup_vertical);
        }
    }//end of constructor

    public void setRootViewId(int id) {
        mRootView	= (ViewGroup) getmInflater().inflate(id, null);
       //mRootViewTwo = (ViewGroup)mInflater.inflate(id,null);
        mArrowDown 	= (ImageView) mRootView.findViewById(R.id.arrow_down_two);
        mArrowUp 	= (ImageView) mRootView.findViewById(R.id.arrow_up);

        //   filiper = (ViewFlipper)mRootView.findViewById(R.id.dropDownFlipper);
        mRootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //mRootViewTwo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }
    public void addActionItem(int layout) {

        if( mOrientation == HORIZONTAL)
        {
            container = getmInflater().inflate(R.layout.action_item_horizontal, null);
        }else if(layout == R.layout.setup_menu_layout_vertical && mOrientation == VERTICAL )
        {
            container = getmInflater().inflate(R.layout.setup_menu_layout_vertical , null);
            //setupMenuCurrentSate = new RestoreCurrentStateOfApplication(mContext,container);
            if(mTrackThree != null)
             mTrackThree.setVisibility(View.GONE);

            Fields.initilizeSetupFilds(container,this);
            LoadOptionFields loadOptionFields = new LoadOptio

            nFields(mContext,container);


            loadOptionFields.startLoading();
            currentSate = new RestoreCurrentStateOfApplication(mContext,container);
            currentSate.loadAgreement();

        }
        else if(layout == R.layout.comments_sub_menu)
        {
            container = getmInflater().inflate(R.layout.comments_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);
            Fields.cb_comments_mandatory = (CheckBox)container.findViewById(R.id.cb_comments_mendatory);
            Fields.cb_comments_not_used = (CheckBox)container.findViewById(R.id.cb_comments_not_used);
            Fields.cb_comments_optoinal = (CheckBox)container.findViewById(R.id.cb_comments_optional);

            currentSate.loadCommentsSubMenuState();
            Fields.cb_comments_optoinal.setOnClickListener(handler);
            Fields.cb_comments_not_used.setOnClickListener(handler);
            Fields.cb_comments_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.badge_number_sub_menu)
        {
            container = getmInflater().inflate(R.layout.badge_number_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);
            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_badge_number_mandatory = (CheckBox)container.findViewById(R.id.cb_badge_number_mendatory);
            Fields.cb_badge_number_not_used = (CheckBox)container.findViewById(R.id.cb_badge_number_not_used);
            Fields.cb_badge_number_optional = (CheckBox)container.findViewById(R.id.cb_badge_number_optional);


            currentSate.loadBadgeNumberSubMenuState();
            Fields.cb_badge_number_optional.setOnClickListener(handler);
            Fields.cb_badge_number_not_used.setOnClickListener(handler);
            Fields.cb_badge_number_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.company_sub_menu) {

            container = getmInflater().inflate(R.layout.company_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.ch_company_mendatory = (CheckBox)container.findViewById(R.id.cb_comany_mendatory);
            Fields.ch_company_not_used = (CheckBox)container.findViewById(R.id.cb_comany_not_used);
            Fields.ch_company_optional = (CheckBox)container.findViewById(R.id.cb_comany_optional);
            currentSate.loadCompanySubMenu();
            Fields.ch_company_not_used.setOnClickListener(handler);
            Fields.ch_company_mendatory.setOnClickListener(handler);
            Fields.ch_company_optional.setOnClickListener(handler);
        }
        else if(layout == R.layout.guide_escort_sub_menu) {

            container = getmInflater().inflate(R.layout.guide_escort_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_guide_escort_mandatory = (CheckBox)container.findViewById(R.id.cb_guide_escort_mendatory);
            Fields.cb_guide_escort_not_used = (CheckBox)container.findViewById(R.id.cb_guide_escort_not_used);
            Fields.cb_guide_escort_optoinal = (CheckBox)container.findViewById(R.id.cb_guide_escort_optional);
            currentSate.loadGuideEscortSubMenu();
            Fields.cb_guide_escort_not_used.setOnClickListener(handler);
            Fields.cb_guide_escort_mandatory.setOnClickListener(handler);
            Fields.cb_guide_escort_optoinal.setOnClickListener(handler);
        }
        else if(layout == R.layout.photo_capture_sub_menu)
        {
            container = getmInflater().inflate(R.layout.photo_capture_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_photo_capture_mandatory = (CheckBox)container.findViewById(R.id.cb_photo_capture_mandatory);
            Fields.cb_photo_capture_optional = (CheckBox)container.findViewById(R.id.cb_photo_capture_optional);
           // Fields.cb_auto_photo_capture = (CheckBox)container.findViewById(R.id.cb_auto_photo_capture);
            Fields.cb_photo_capture_large = (CheckBox)container.findViewById(R.id.cb_photo_capture_large);
            Fields.cb_photo_capture_medium = (CheckBox)container.findViewById(R.id.cb_photo_capture_medium);
            Fields.cb_photo_capture_small = (CheckBox)container.findViewById(R.id.cb_photo_capture_small);

            currentSate.loadPhotoCaptureSubMenuState();
            Fields.cb_photo_capture_optional.setOnClickListener(handler);
            Fields.cb_photo_capture_large.setOnClickListener(handler);
            Fields.cb_photo_capture_small.setOnClickListener(handler);
            Fields.cb_photo_capture_medium.setOnClickListener(handler);
            Fields.cb_photo_capture_optional.setOnClickListener(handler);
            Fields.cb_photo_capture_mandatory.setOnClickListener(handler);
        } else if(layout == R.layout.badge_returned_sub_menu)
        {
            container = getmInflater().inflate(R.layout.badge_returned_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);
            Fields.cb_badge_returned_mandatory = (CheckBox)container.findViewById(R.id.cb_badge_returned_mendatory);
            Fields.cb_badge_returned_not_used = (CheckBox)container.findViewById(R.id.cb_badge_returned_not_used);
            Fields.cb_badge_returned_optional = (CheckBox)container.findViewById(R.id.cb_badge_returned_optional);

            currentSate.loadBadgeReturnedSubMenuState();
            Fields.cb_badge_returned_optional.setOnClickListener(handler);
            Fields.cb_badge_returned_not_used.setOnClickListener(handler);
            Fields.cb_badge_returned_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.address_sub_menu)
        {
            container = getmInflater().inflate(R.layout.address_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);
            Fields.cb_address_mandatory = (CheckBox)container.findViewById(R.id.cb_address_mendatory);
            Fields.cb_address_not_used = (CheckBox)container.findViewById(R.id.cb_address_not_used);
            Fields.cb_address_optoinal = (CheckBox)container.findViewById(R.id.cb_address_optional);

            currentSate.loadAddressSubMenuState();
            Fields.cb_address_optoinal.setOnClickListener(handler);
            Fields.cb_address_not_used.setOnClickListener(handler);
            Fields.cb_address_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.city_sub_menu)
        {
            container = getmInflater().inflate(R.layout.city_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);
            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_city_mandatory = (CheckBox)container.findViewById(R.id.cb_city_mendatory);
            Fields.cb_city_not_used = (CheckBox)container.findViewById(R.id.cb_city_not_used);
            Fields.cb_city_optional = (CheckBox)container.findViewById(R.id.cb_city_optional);


            currentSate.loadCitySubMenuState();
            Fields.cb_city_optional.setOnClickListener(handler);
            Fields.cb_city_not_used.setOnClickListener(handler);
            Fields.cb_city_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.state_sub_menu)
        {
            container = getmInflater().inflate(R.layout.state_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);
            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_state_mandatory = (CheckBox)container.findViewById(R.id.cb_state_mendatory);
            Fields.cb_state_not_used = (CheckBox)container.findViewById(R.id.cb_state_not_used);
            Fields.cb_state_optional = (CheckBox)container.findViewById(R.id.cb_state_optional);


            currentSate.loadStateSubMenuState();
            Fields.cb_state_optional.setOnClickListener(handler);
            Fields.cb_state_not_used.setOnClickListener(handler);
            Fields.cb_state_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.zip_code_sub_menu)
        {
            container = getmInflater().inflate(R.layout.zip_code_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);
            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_zip_code_mandatory = (CheckBox)container.findViewById(R.id.cb_zip_code_mendatory);
            Fields.cb_zip_code_not_used = (CheckBox)container.findViewById(R.id.cb_zip_code_not_used);
            Fields.cb_zip_code_optional = (CheckBox)container.findViewById(R.id.cb_zip_code_optional);


            currentSate.loadZipCodeSubMenuState();
            Fields.cb_zip_code_optional.setOnClickListener(handler);
            Fields.cb_zip_code_not_used.setOnClickListener(handler);
            Fields.cb_zip_code_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.phone_sub_menu)
        {
            container = getmInflater().inflate(R.layout.phone_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);
            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_phone_mandatory = (CheckBox)container.findViewById(R.id.cb_phone_mendatory);
            Fields.cb_phone_not_used = (CheckBox)container.findViewById(R.id.cb_phone_not_used);
            Fields.cb_phone_optional = (CheckBox)container.findViewById(R.id.cb_phone_optional);


            currentSate.loadPhoneSubMenuState();
            Fields.cb_phone_optional.setOnClickListener(handler);
            Fields.cb_phone_not_used.setOnClickListener(handler);
            Fields.cb_phone_mandatory.setOnClickListener(handler);

        }
        else if(layout == R.layout.email_sub_menu)
        {
            container = getmInflater().inflate(R.layout.email_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);
            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_email_mandatory = (CheckBox)container.findViewById(R.id.cb_email_mendatory);
            Fields.cb_email_not_used = (CheckBox)container.findViewById(R.id.cb_email_not_used);
            Fields.cb_email_optional = (CheckBox)container.findViewById(R.id.cb_email_optional);


            currentSate.loadEmailSubMenuState();
            Fields.cb_email_optional.setOnClickListener(handler);
            Fields.cb_email_not_used.setOnClickListener(handler);
            Fields.cb_email_mandatory.setOnClickListener(handler);

        } else if(layout == R.layout.signature_capture_sub_menu)
        {
            container = getmInflater().inflate(R.layout.signature_capture_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_signature_capture_mandatory = (CheckBox)container.findViewById(R.id.cb_signature_capture_mendatory);
            Fields.cb_signature_capture_optional = (CheckBox)container.findViewById(R.id.cb_signature_capture_optional);
            Fields.cb_signature_capture_not_used = (CheckBox)container.findViewById(R.id.cb_signature_capture_not_used);
            currentSate.loadSignatureCaptureSubMenuState();
            Fields.cb_signature_capture_optional.setOnClickListener(handler);
            Fields.cb_signature_capture_optional.setOnClickListener(handler);
            Fields.cb_signature_capture_mandatory.setOnClickListener(handler);
        }
        else if(layout == R.layout.visitor_agreement_text_sub_menu)
        {
            container = getmInflater().inflate(R.layout.visitor_agreement_text_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

//            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.et_visitor_agreement_text = (EditText)container.findViewById(R.id.et_visitor_agreement_text_sub);
            Fields.bt_agree = (Button)container.findViewById(R.id.bt_visitor_agree);
            Fields.bt_not_agree = (Button)container.findViewById(R.id.bt_visitor_not_agree);

//            currentSate.loadSignatureCaptureSubMenuState();
//            Fields.cb_signature_capture_optional.setOnClickListener(handler);
//            Fields.cb_signature_capture_optional.setOnClickListener(handler);
//            Fields.cb_signature_capture_mandatory.setOnClickListener(handler);
        }
        else if(layout == R.layout.here_to_see_sub_menu) {

            container = getmInflater().inflate(R.layout.here_to_see_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            currentSate = new RestoreCurrentStateOfApplication(mContext,container);

            Fields.cb_here_to_see_mandatory = (CheckBox)container.findViewById(R.id.cb_here_to_see_mendatory);
            Fields.cb_here_to_see_not_used = (CheckBox)container.findViewById(R.id.cb_here_to_see_not_used);
            Fields.cb_here_to_see_optional = (CheckBox)container.findViewById(R.id.cb_here_to_see_optional);
            currentSate.loadHereToSeeSubMenu();
            Fields.cb_here_to_see_not_used.setOnClickListener(handler);
            Fields.cb_here_to_see_mandatory.setOnClickListener(handler);
            Fields.cb_here_to_see_optional.setOnClickListener(handler);
        }else
            container = getmInflater().inflate(R.layout.popup_vertical , null);



        container.setFocusable(true);
        container.setClickable(true);
        getmTrack().addView(container);
    }
    public void setView(int scroller,int scrollerLayout)
    {

        //if(sub == 0)
          setmTrack((ViewGroup) mRootView.findViewById(scrollerLayout));
          mTrackTwo = (ViewGroup)mRootView.findViewById(R.id.dropDownChangerOne);
          mTrackThree = (ViewGroup)mRootView.findViewById(R.id.dropDownChangerTwo);


        //mTrackTwo 		= (ViewGroup) mRootView.findViewById(scrollerLayout);

        mScroller	= (ScrollView) mRootView.findViewById(scroller);
        mAnimStyle 	= ANIM_AUTO;
       // mChildPos 	= 0;
    }

    public void setMenuHeadings(){

        setup = (TextView)mRootView.findViewById(R.id.setup);
        design = (TextView)mRootView.findViewById(R.id.design);
        report = (TextView)mRootView.findViewById(R.id.report_heading);
//        flipper = (ViewFlipper)mRootView.findViewById(R.id.dropDownFlipper);
        font_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.font_sub_menu_heading_layout);
        badge_returned_sub_menu_heading_layout  = (LinearLayout)mRootView.findViewById(R.id.badge_returned_sub_menu_heading_layout);
        company_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.company_sub_menu_heading_layout);
        photo_capture_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.photo_capture_sub_menu_heading_layout);
        address_sub_menu_heading_layout  = (LinearLayout)mRootView.findViewById(R.id.address_sub_menu_heading_layout);
        signature_capture_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.signature_capture_sub_menu_heading_layout);
        company_chroven_left = (ImageView)mRootView.findViewById(R.id.company_chroven_left);
        badge_number_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.badge_number_sub_menu_heading_layout);
        company_heading_left = (TextView)mRootView.findViewById(R.id.company_heading_left);
        comments_sub_menu_heading_layout  = (LinearLayout)mRootView.findViewById(R.id.comments_sub_menu_heading_layout);
        city_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.city_sub_menu_heading_layout);
        state_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.state_sub_menu_heading_layout);
        zip_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.zip_sub_menu_heading_layout);
        phone_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.phone_sub_menu_heading_layout);
        email_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.email_sub_menu_heading_layout);
        guide_escort_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.guide_escort_sub_menu_heading_layout);
        visitor_agreement_text_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.visitor_agreement_text_sub_menu_heading_layout);
        here_to_see_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.here_to_see_sub_menu_heading_layout);

        visitor_agreement_text_chroven_left = (ImageView)mRootView.findViewById(R.id.visitor_agreement_text_chroven_left);
        visitor_agreement_text_heading_left = (TextView)mRootView.findViewById(R.id.visitor_agreement_text_heading_left);
        signature_capture_chroven_left = (ImageView)mRootView.findViewById(R.id.signature_capture_chroven_left);
        signature_capture_heading_left = (TextView)mRootView.findViewById(R.id.signature_capture_heading_left);
        photo_capture_chroven_left = (ImageView)mRootView.findViewById(R.id.photo_capture_chroven_left);
        photo_capture_heading_left = (TextView)mRootView.findViewById(R.id.photo_capture_heading_left);
        address_chroven_left = (ImageView)mRootView.findViewById(R.id.address_chroven_left);
        badge_returned_chroven_left = (ImageView)mRootView.findViewById(R.id.badge_returned_chroven_left);
        badge_returned_heading_left = (TextView)mRootView.findViewById(R.id.badge_returned_heading_left);
        address_heading_left = (TextView)mRootView.findViewById(R.id.address_heading_left);
        here_to_see_chroven_left = (ImageView)mRootView.findViewById(R.id.here_to_see_chroven_left);
        badge_number_chroven_left = (ImageView)mRootView.findViewById(R.id.badge_number_chroven_left);
        badge_number_heading_left = (TextView)mRootView.findViewById(R.id.badge_number_heading_left);
        here_to_see_heading_left = (TextView)mRootView.findViewById(R.id.here_to_see_heading_left);
        city_chroven_left = (ImageView)mRootView.findViewById(R.id.city_chroven_left);
        city_heading_left = (TextView)mRootView.findViewById(R.id.city_heading_left);
        state_chroven_left = (ImageView)mRootView.findViewById(R.id.state_chroven_left);
        comments_chroven_left = (ImageView)mRootView.findViewById(R.id.comments_chroven_left);
        comments_heading_left = (TextView)mRootView.findViewById(R.id.comments_heading_left);
        state_heading_left = (TextView)mRootView.findViewById(R.id.state_heading_left);
        zip_code_chroven_left = (ImageView)mRootView.findViewById(R.id.zip_chroven_left);
        zip_code_heading_left = (TextView)mRootView.findViewById(R.id.zip_heading_left);
        phone_chroven_left = (ImageView)mRootView.findViewById(R.id.phone_chroven_left);
        phone_heading_left = (TextView)mRootView.findViewById(R.id.phone_heading_left);
        guide_escort_chroven_left = (ImageView)mRootView.findViewById(R.id.guide_escort_chroven_left);
        guide_esort_heading_left = (TextView)mRootView.findViewById(R.id.guide_escort_heading_left);

        email_chroven_left = (ImageView)mRootView.findViewById(R.id.email_chroven_left);
        email_heading_left = (TextView)mRootView.findViewById(R.id.email_heading_left);


        visitor_agreement_text_heading_left.setOnClickListener(this);
        visitor_agreement_text_chroven_left.setOnClickListener(this);
        address_heading_left.setOnClickListener(this);
        guide_escort_chroven_left.setOnClickListener(this);
        guide_esort_heading_left.setOnClickListener(this);
        address_chroven_left.setOnClickListener(this);
        city_chroven_left.setOnClickListener(this);
        city_heading_left.setOnClickListener(this);
        state_chroven_left.setOnClickListener(this);
        comments_chroven_left.setOnClickListener(this);
        comments_heading_left.setOnClickListener(this);
        state_heading_left.setOnClickListener(this);
        zip_code_chroven_left.setOnClickListener(this);
        zip_code_heading_left.setOnClickListener(this);
        badge_number_chroven_left.setOnClickListener(this);
        badge_number_heading_left.setOnClickListener(this);
        phone_chroven_left.setOnClickListener(this);
        signature_capture_chroven_left.setOnClickListener(this);
        signature_capture_heading_left.setOnClickListener(this);
        here_to_see_chroven_left.setOnClickListener(this);
        badge_returned_heading_left.setOnClickListener(this);
        badge_returned_chroven_left.setOnClickListener(this);
        here_to_see_heading_left.setOnClickListener(this);
        phone_heading_left.setOnClickListener(this);
        photo_capture_chroven_left.setOnClickListener(this);
        photo_capture_heading_left.setOnClickListener(this);
        email_chroven_left.setOnClickListener(this);
        email_heading_left.setOnClickListener(this);
        switch (getHeading_id())
        {
            case R.id.setup:
                design.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
//                if(setup != null)
                    setup.setVisibility(View.VISIBLE);
                break;
            case R.id.report_heading:
                design.setVisibility(View.GONE);
                setup.setVisibility(View.GONE);
                report.setVisibility(View.VISIBLE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.design:
                setup.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.VISIBLE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
        }
        setContentView(mRootView);
    }

    @Override
    public void onClick(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.row_company:
            case R.id.tv_company:
            case R.id.iv_company:
                    load("company");
//                    setupMenuCurrentSate.loadSetupCurrentState();
//                    flipper.showNext();
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.company_chroven_left:
            case R.id.company_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_comments:
            case R.id.tv_comments:
            case R.id.iv_comments:
                load("comments");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.comments_chroven_left:
            case R.id.comments_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.cb_show_visitor_agreement_upon_signin:
                database = new Database(mContext);
                if(Fields.cb_signin_agreement.isChecked()){

                    Fields.cb_signin_agreement.setChecked(true);
                    database.updateSignInSetupFields("signin agreement","true");
                }
                else {
                    Fields.cb_signin_agreement.setChecked(false);
                    database.updateSignInSetupFields("signin agreement","false");
                }
                break;
            case R.id.cb_show_visitor_agreement_upon_signout:
                database = new Database(mContext);
                if(Fields.cb_signout_agreement.isChecked()){
                    database.updateSignInSetupFields("signout agreement","true");
                    Fields.cb_signout_agreement.setChecked(true);
                }
                else {
                    database.updateSignInSetupFields("signout agreement","false");
                    Fields.cb_signout_agreement.setChecked(false);
                }
                break;
            case R.id.row_photo_capture:
            case R.id.tv_photo_capture:
            case R.id.iv_photo_capture:
                    load("photo capture");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.photo_capture_heading_left:
            case R.id.photo_capture_chroven_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.iv_badge_number:
            case R.id.tv_badge_number:
                load("badge number");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.badge_number_chroven_left:
            case R.id.badge_number_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_address:
            case R.id.tv_address:
            case R.id.iv_address:
                load("address");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.address_chroven_left:
            case R.id.address_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.iv_city:
            case R.id.tv_city:
                load("city");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.city_chroven_left:
            case R.id.city_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_state:
            case R.id.iv_state:
            case R.id.tv_state:
                load("state");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.state_chroven_left:
            case R.id.state_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_zip_code:
            case R.id.tv_zip_code:
            case R.id.iv_zip_code:
                load("zip code");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.zip_chroven_left:
            case R.id.zip_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_phone:
            case R.id.iv_phone:
            case R.id.tv_phone:
                load("phone");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.phone_chroven_left:
            case R.id.phone_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_email:
            case R.id.iv_email:
            case R.id.tv_email:
                load("email");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.email_chroven_left:
            case R.id.email_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_signature_capture:
            case R.id.iv_signature_capture:
            case R.id.tv_signature_capture:
                load("signature capture");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.signature_capture_heading_left:
            case R.id.signature_capture_chroven_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_visitor_agreement_text:
            case R.id.iv_visitor_agrement_text:
            case R.id.tv_visitor_agreement_text:
                load("visitor agreement text");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.visitor_agreement_text_chroven_left:
            case R.id.visitor_agreement_text_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
            case R.id.row_here_to_see:
            case R.id.iv_here_to_see:
            case R.id.tv_here_to_see:
                load("here to see");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.here_to_see_chroven_left:
            case R.id.here_to_see_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;

            case R.id.row_guide_escrot:
            case R.id.iv_guide_escort_name:
            case R.id.tv_guide_escort_name:
                load("guide escort");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.guide_escort_chroven_left:
            case R.id.guide_escort_heading_left:
                setSubMenuHeadings(R.id.setup);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                break;
        }//end of switch
    }//end of onClick method


    public void setSubMenuHeadings(int id)
    {
        switch (id)
        {
            case R.id.setup:
                design.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                setup.setVisibility(View.VISIBLE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.report_heading:
                design.setVisibility(View.GONE);
                setup.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                report.setVisibility(View.VISIBLE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.design:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.VISIBLE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.company_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
            break;
            case R.id.photo_capture_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.address_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.city_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.state_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.zip_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.phone_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.email_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.signature_capture_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.visitor_agreement_text_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.here_to_see_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                break;
            case R.id.guide_escort_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.badge_returned_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.badge_number_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;

            case R.id.comments_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                comments_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                badge_returned_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                address_sub_menu_heading_layout.setVisibility(View.GONE);
                city_sub_menu_heading_layout.setVisibility(View.GONE);
                state_sub_menu_heading_layout.setVisibility(View.GONE);
                badge_number_sub_menu_heading_layout.setVisibility(View.GONE);
                zip_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                signature_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                phone_sub_menu_heading_layout.setVisibility(View.GONE);
                email_sub_menu_heading_layout.setVisibility(View.GONE);
                guide_escort_sub_menu_heading_layout.setVisibility(View.GONE);
                visitor_agreement_text_sub_menu_heading_layout.setVisibility(View.GONE);
                here_to_see_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
        }
        setContentView(mRootView);
    }
    public void load(String head){
        if(head.equals("company"))
        {


            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.company_sub_menu_heading_layout);
            addActionItem(R.layout.company_sub_menu);

            company_chroven_left.setOnClickListener(this);
            company_heading_left.setOnClickListener(this);
            //isCompanyLoaded = true;
        }
        else if(head.equals("comments"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.comments_sub_menu_heading_layout);
            addActionItem(R.layout.comments_sub_menu);
        }
        else if(head.equals("photo capture")){
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.photo_capture_sub_menu_heading_layout);
            addActionItem(R.layout.photo_capture_sub_menu);
            //isPhotoCaptureLoaded = true;
        }
        else if(head.equals("badge number"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.badge_number_sub_menu_heading_layout);
            addActionItem(R.layout.badge_number_sub_menu);
        }
        else if(head.equals("badge returned"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.badge_returned_sub_menu_heading_layout);
            addActionItem(R.layout.badge_returned_sub_menu);
        }
        else if(head.equals("address"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.address_sub_menu_heading_layout);
            addActionItem(R.layout.address_sub_menu);
        }
        else if(head.equals("city"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.city_sub_menu_heading_layout);
            addActionItem(R.layout.city_sub_menu);
        }
        else if(head.equals("state"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.state_sub_menu_heading_layout);
            addActionItem(R.layout.state_sub_menu);
        }
        else if(head.equals("zip code"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.zip_sub_menu_heading_layout);
            addActionItem(R.layout.zip_code_sub_menu);
        }else if(head.equals("phone"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.phone_sub_menu_heading_layout);
            addActionItem(R.layout.phone_sub_menu);
        }
        else if(head.equals("email"))
        {
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.email_sub_menu_heading_layout);
            addActionItem(R.layout.email_sub_menu);
        }
        else if(head.equals("signature capture")){
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.signature_capture_sub_menu_heading_layout);
            addActionItem(R.layout.signature_capture_sub_menu);
            //isPhotoCaptureLoaded = true;
        }
        else if(head.equals("visitor agreement text")){
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.visitor_agreement_text_sub_menu_heading_layout);
            addActionItem(R.layout.visitor_agreement_text_sub_menu);
        }
        else if(head.equals("here to see")){
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.here_to_see_sub_menu_heading_layout);
            addActionItem(R.layout.here_to_see_sub_menu);
        }
        else if(head.equals("guide escort")){
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            if(getmTrack().getChildCount()>0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.guide_escort_sub_menu_heading_layout);
            addActionItem(R.layout.guide_escort_sub_menu);
        }
    }


    /**
     * Set animation style
     *
     * @param screenWidth screen width
     * @param requestedX distance from left edge
     * @param onTop flag to indicate where the popup should be displayed. Set TRUE if displayed on top of anchor view
     * 		  and vice versa
     */
    public void setAnimationStyle(int screenWidth, int requestedX, boolean onTop) {
        int arrowPos = requestedX - mArrowUp.getMeasuredWidth()/2;

        switch (mAnimStyle) {
            case ANIM_GROW_FROM_LEFT:
                mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
                break;

            case ANIM_GROW_FROM_RIGHT:
                mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Right : R.style.Animations_PopDownMenu_Right);
                break;

            case ANIM_GROW_FROM_CENTER:
                mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Center : R.style.Animations_PopDownMenu_Center);
                break;

            case ANIM_REFLECT:
                mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Reflect : R.style.Animations_PopDownMenu_Reflect);
                break;

            case ANIM_AUTO:
                if (arrowPos <= screenWidth/4) {
                    mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
                } else if (arrowPos > screenWidth/4 && arrowPos < 3 * (screenWidth/4)) {
                    mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Center : R.style.Animations_PopDownMenu_Center);
                } else {
                    mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Right : R.style.Animations_PopDownMenu_Right);
                }

                break;
        }
    }

    /**
     * Show arrow
     *
     * @param whichArrow arrow type resource id
     * @param requestedX distance from left screen
     */
    public void showArrow(int whichArrow, int requestedX) {
        final View showArrow = (whichArrow == R.id.arrow_up) ? mArrowUp : mArrowDown;
        final View hideArrow = (whichArrow == R.id.arrow_up) ? mArrowDown : mArrowUp;

        final int arrowWidth = mArrowUp.getMeasuredWidth();

        showArrow.setVisibility(View.VISIBLE);

        ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams)showArrow.getLayoutParams();

        param.leftMargin = requestedX - arrowWidth /2;

        hideArrow.setVisibility(View.INVISIBLE);
    }

    /**
     * Set listener for window dismissed. This listener will only be fired if the quicakction dialog is dismissed
     * by clicking outside the dialog or clicking on sticky item.
     */
    public void setOnDismissListener(QuickAction.OnDismissListener listener) {
        setOnDismissListener(this);

        mDismissListener = listener;
    }


    @Override
    public void onDismiss() {
        if (!mDidAction && mDismissListener != null) {
            mDismissListener.onDismiss();
        }
    }


    public void show (View anchor) {
        preShow();

        int xPos, yPos, arrowPos;

        mDidAction 			= false;

        int[] location 		= new int[2];


        anchor.getLocationOnScreen(location);
        Rect anchorRect 	= new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1]
                + anchor.getHeight());

        //mRootView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        mRootView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        int rootHeight 		= mRootView.getMeasuredHeight();

        if (rootWidth == 0) {
            rootWidth		= mRootView.getMeasuredWidth();
        }

        int screenWidth 	= mWindowManager.getDefaultDisplay().getWidth();
        int screenHeight	= mWindowManager.getDefaultDisplay().getHeight();

        //automatically get X coord of popup (top left)
        if ((anchorRect.left + rootWidth) > screenWidth) {
            xPos 		= anchorRect.left - (rootWidth-anchor.getWidth());
            xPos 		= (xPos < 0) ? 0 : xPos;

            arrowPos 	= anchorRect.centerX()-xPos;

        } else {
            if (anchor.getWidth() > rootWidth) {
                xPos = anchorRect.centerX() - (rootWidth/2);
            } else {
                xPos = anchorRect.left;
            }

            arrowPos = anchorRect.centerX()-xPos;
        }

        int dyTop			= anchorRect.top;
        int dyBottom		= screenHeight - anchorRect.bottom;

        boolean onTop		= (dyTop > dyBottom) ? true : false;

        if (onTop) {
            if (rootHeight > dyTop) {
                yPos 			= 15;
                ViewGroup.LayoutParams l 	= mScroller.getLayoutParams();
                l.height		= dyTop - anchor.getHeight();
            } else {
                yPos = anchorRect.top - rootHeight;
            }
        } else {
            yPos = anchorRect.bottom;

            if (rootHeight > dyBottom) {
                ViewGroup.LayoutParams l 	= mScroller.getLayoutParams();
                l.height		= dyBottom;
            }
        }

        showArrow(((onTop) ? R.id.arrow_down_two : R.id.arrow_up), arrowPos);

        setAnimationStyle(screenWidth, anchorRect.centerX(), onTop);

        mWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, xPos, yPos);
    }
    public int getHeading_id() {
        return heading_id;
    }

    public void setHeading_id(int heading_id) {
        this.heading_id = heading_id;
    }

    public ViewGroup getmTrack() {
        return mTrack;
    }

    public void setmTrack(ViewGroup mTrack) {
        this.mTrack = mTrack;
    }

    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public void setmInflater(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }
}
