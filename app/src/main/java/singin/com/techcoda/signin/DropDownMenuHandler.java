package singin.com.techcoda.signin;

import android.content.Context;
import android.graphics.Rect;
import android.icu.text.DateFormat;
import android.media.Image;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.w3c.dom.Text;

/**
 * Created by android on 7/29/2016.
 */
public class DropDownMenuHandler extends PopupWindows implements PopupWindow.OnDismissListener,View.OnClickListener {

    private View mRootView;
    private View mRootViewTwo;
    private ImageView mArrowUp;
    private ImageView mArrowDown;
    private LayoutInflater mInflater;
    private ViewGroup mTrack;
    private ScrollView mScroller;
    private boolean mDidAction;
    private int mAnimStyle;
    private int mOrientation;
    private int rootWidth=0;
    private View container;
    private boolean isCompanyLoaded;
    private boolean isPhotoCaptureLoaded;
    private QuickAction.OnDismissListener mDismissListener;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private static final int ANIM_GROW_FROM_LEFT = 1;
    private static final int ANIM_GROW_FROM_RIGHT = 2;
    private static final int ANIM_GROW_FROM_CENTER = 3;
    private static final int ANIM_REFLECT = 4;
    private static final int ANIM_AUTO = 5;
    private SubMenuHandler handler;
    private ViewFlipper flipper;
    //TOP DROP DOWN MENU HEADING
    private TextView setup;
    private TextView report;
    private TextView design;
    private ImageView company_chroven_left;
    private TextView company_heading_left;
    private ImageView photo_capture_chroven_left;
    private TextView photo_capture_heading_left;
    //HEADING INDICATOR
    private int heading_id;

    //SUB MENU DROP DOWN HEADING
    private LinearLayout font_sub_menu_heading_layout;
    private LinearLayout company_sub_menu_heading_layout;
    private LinearLayout photo_capture_sub_menu_heading_layout;


    public DropDownMenuHandler(Context context, int orientation,int heading_id) {
        super(context);

        setHeading_id(heading_id);
        mOrientation = orientation;
        mInflater 	 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (mOrientation == HORIZONTAL) {
            setRootViewId(R.layout.popup_horizontal);
        } else {
            setRootViewId(R.layout.popup_vertical);
        }


    }//end of constructor

    public void setRootViewId(int id) {
        mRootView	= (ViewGroup) mInflater.inflate(id, null);
       mRootViewTwo = (ViewGroup)mInflater.inflate(id,null);
        mArrowDown 	= (ImageView) mRootView.findViewById(R.id.arrow_down_two);
        mArrowUp 	= (ImageView) mRootView.findViewById(R.id.arrow_up);

        //   filiper = (ViewFlipper)mRootView.findViewById(R.id.dropDownFlipper);
        mRootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mRootViewTwo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    }
    public void addActionItem(int layout) {

        if( mOrientation == HORIZONTAL)
        {
            container = mInflater.inflate(R.layout.action_item_horizontal, null);
        }else if(layout == R.layout.setup_menu_layout_vertical && mOrientation == VERTICAL )
        {
            container = mInflater.inflate(R.layout.setup_menu_layout_vertical , null);

            Fields.iv_company = (ImageView)container.findViewById(R.id.iv_company);
            Fields.tv_company = (TextView)container.findViewById(R.id.tv_company);
            Fields.iv_company.setOnClickListener(this);
            Fields.tv_company.setOnClickListener(this);

            Fields.iv_photo_capture = (ImageView)container.findViewById(R.id.iv_photo_capture);
            Fields.tv_photo_capture = (TextView)container.findViewById(R.id.tv_photo_capture);
            Fields.iv_photo_capture.setOnClickListener(this);
            Fields.tv_photo_capture.setOnClickListener(this);


        }
        else if(layout == R.layout.company_sub_menu) {
            container = mInflater.inflate(R.layout.company_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);

            Fields.ch_company_mendatory = (CheckBox)container.findViewById(R.id.cb_comany_mendatory);
            Fields.ch_company_not_used = (CheckBox)container.findViewById(R.id.cb_comany_not_used);
            Fields.ch_company_optional = (CheckBox)container.findViewById(R.id.cb_comany_optional);

            Fields.ch_company_not_used.setOnClickListener(handler);
            Fields.ch_company_mendatory.setOnClickListener(handler);
            Fields.ch_company_optional.setOnClickListener(handler);
        }
        else if(layout == R.layout.photo_capture_sub_menu)
        {
            container = mInflater.inflate(R.layout.photo_capture_sub_menu, null);
            handler = new SubMenuHandler(mContext,container);
            Fields.cb_photo_capture_mandatory = (CheckBox)container.findViewById(R.id.cb_photo_capture_mandatory);
            Fields.cb_photo_capture_optional = (CheckBox)container.findViewById(R.id.cb_photo_capture_optional);
            Fields.cb_auto_photo_capture = (CheckBox)container.findViewById(R.id.cb_auto_photo_capture);
            Fields.cb_photo_capture_large = (CheckBox)container.findViewById(R.id.cb_photo_capture_large);
            Fields.cb_photo_capture_medium = (CheckBox)container.findViewById(R.id.cb_photo_capture_medium);
            Fields.cb_photo_capture_small = (CheckBox)container.findViewById(R.id.cb_photo_capture_small);

            Fields.cb_photo_capture_optional.setOnClickListener(handler);
            Fields.cb_photo_capture_large.setOnClickListener(handler);
            Fields.cb_photo_capture_small.setOnClickListener(handler);
            Fields.cb_photo_capture_medium.setOnClickListener(handler);
            Fields.cb_photo_capture_optional.setOnClickListener(handler);
            Fields.cb_photo_capture_mandatory.setOnClickListener(handler);
        }
        else
            container = mInflater.inflate(R.layout.popup_vertical , null);



        container.setFocusable(true);
        container.setClickable(true);
        mTrack.addView(container);

//        if(layout == R.layout.company_sub_menu )
//        load("company");
    }
    public void setView(int scroller,int scrollerLayout)
    {

        //if(sub == 0)
          mTrack 		= (ViewGroup) mRootView.findViewById(scrollerLayout);

        //mTrackTwo 		= (ViewGroup) mRootView.findViewById(scrollerLayout);

        mScroller	= (ScrollView) mRootView.findViewById(scroller);

        mAnimStyle 	= ANIM_AUTO;


       // mChildPos 	= 0;
    }

    public void setMenuHeadings(){

        setup = (TextView)mRootView.findViewById(R.id.setup);
        design = (TextView)mRootView.findViewById(R.id.design);
        report = (TextView)mRootView.findViewById(R.id.report_heading);
        flipper = (ViewFlipper)mRootView.findViewById(R.id.dropDownFlipper);
        font_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.font_sub_menu_heading_layout);
        company_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.company_sub_menu_heading_layout);
        photo_capture_sub_menu_heading_layout = (LinearLayout)mRootView.findViewById(R.id.photo_capture_sub_menu_heading_layout);

        switch (getHeading_id())
        {
            case R.id.setup:
                design.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                if(setup != null)
                    setup.setVisibility(View.VISIBLE);
                break;
            case R.id.report_heading:
                design.setVisibility(View.GONE);
                setup.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.design:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.GONE);
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
            case R.id.iv_company:
            case R.id.tv_company:
                Toast.makeText(mContext.getApplicationContext(), "company clicked", Toast.LENGTH_SHORT).show();
                if(!isCompanyLoaded)
                {
                    load("company");
                    flipper.showPrevious();
                }
                else {
                    setSubMenuHeadings(R.id.company_sub_menu_heading_layout);
                    flipper.showPrevious();
                }
                break;
            case R.id.company_chroven_left:
            case R.id.company_heading_left:
                setSubMenuHeadings(R.id.setup);
                flipper.showNext();

            case R.id.iv_photo_capture:
                Toast.makeText(mContext.getApplicationContext(), "Photo Capture", Toast.LENGTH_SHORT).show();
                if(!isPhotoCaptureLoaded)
                {
                    load("photo capture");
                    flipper.showPrevious();
                }
                else {
                    setSubMenuHeadings(R.id.company_sub_menu_heading_layout);
                    flipper.showPrevious();
                }
                break;
            case R.id.photo_capture_heading_left:
            case R.id.photo_capture_chroven_left:
                setSubMenuHeadings(R.id.setup);
                flipper.showNext();
        }
    }//end of onClick method


    public void setSubMenuHeadings(int id)
    {

        company_chroven_left = (ImageView)mRootView.findViewById(R.id.company_chroven_left);
        company_heading_left = (TextView)mRootView.findViewById(R.id.company_heading_left);

        company_chroven_left.setOnClickListener(this);
        company_heading_left.setOnClickListener(this);

        photo_capture_chroven_left = (ImageView)mRootView.findViewById(R.id.photo_capture_chroven_left);
        photo_capture_heading_left = (TextView)mRootView.findViewById(R.id.photo_capture_heading_left);

        photo_capture_chroven_left.setOnClickListener(this);
        photo_capture_heading_left.setOnClickListener(this);

        switch (id)
        {
            case R.id.setup:
                design.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                setup.setVisibility(View.VISIBLE);
                break;
            case R.id.report_heading:
                design.setVisibility(View.GONE);
                setup.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.design:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.company_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.VISIBLE);
            break;
            case R.id.photo_capture_sub_menu_heading_layout:
                setup.setVisibility(View.GONE);
                report.setVisibility(View.GONE);
                design.setVisibility(View.GONE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                company_sub_menu_heading_layout.setVisibility(View.GONE);
                photo_capture_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                break;

    }
        setContentView(mRootView);
    }
    public void load(String head){
        if(head.equals("company"))
        {

            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            setSubMenuHeadings(R.id.company_sub_menu_heading_layout);
            addActionItem(R.layout.company_sub_menu);
            isCompanyLoaded = true;
        }
        else if(head.equals("photo capture")){
            setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            setSubMenuHeadings(R.id.photo_capture_sub_menu_heading_layout);
            addActionItem(R.layout.photo_capture_sub_menu);
            isPhotoCaptureLoaded = true;
        }
        else{
            isCompanyLoaded = false;
            isPhotoCaptureLoaded = false;
        }

         //isCompanyLoaded = false;

    }


    /**
     * Set animation style
     *
     * @param screenWidth screen width
     * @param requestedX distance from left edge
     * @param onTop flag to indicate where the popup should be displayed. Set TRUE if displayed on top of anchor view
     * 		  and vice versa
     */
    private void setAnimationStyle(int screenWidth, int requestedX, boolean onTop) {
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
    private void showArrow(int whichArrow, int requestedX) {
        final View showArrow = (whichArrow == R.id.arrow_up) ? mArrowUp : mArrowDown;
        final View hideArrow = (whichArrow == R.id.arrow_up) ? mArrowDown : mArrowUp;

        final int arrowWidth = mArrowUp.getMeasuredWidth();

        showArrow.setVisibility(View.VISIBLE);

        ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams)showArrow.getLayoutParams();

        param.leftMargin = requestedX - arrowWidth / 2;

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
}
