package singin.com.techcoda.signin;

import android.content.Context;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

public class DropDownDesignMenuHandler extends PopupWindows implements PopupWindow.OnDismissListener,View.OnClickListener {
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
    private int rootWidth = 0;
    private Database database;
    private View container;
    private QuickAction.OnDismissListener mDismissListener;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private ImageView font_chroven_left;
    private TextView font_heading_left;
    private static final int ANIM_GROW_FROM_LEFT = 1;
    private static final int ANIM_GROW_FROM_RIGHT = 2;
    private static final int ANIM_GROW_FROM_CENTER = 3;
    public static final int ANIM_REFLECT = 4;
    public static final int ANIM_AUTO = 5;
    private int heading_id;
    private LinearLayout font_sub_menu_heading_layout;
    private TextView design;
    public DropDownDesignMenuHandler(Context context, int orientation, int heading_id) {
        super(context);

        setHeading_id(heading_id);
        mOrientation = orientation;
        setmInflater((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        setRootViewId(R.layout.design_popup_layout_vertical);
    }//end of constructor

    public void setRootViewId(int id) {
        mRootView = (ViewGroup) getmInflater().inflate(id, null);
        mArrowDown = (ImageView) mRootView.findViewById(R.id.arrow_down_two);
        mArrowUp = (ImageView) mRootView.findViewById(R.id.arrow_up);
        mRootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
    public void addActionItem(int layout) {

         if (layout == R.layout.design_menu_layout_vertical && mOrientation == VERTICAL) {
            container = getmInflater().inflate(R.layout.design_menu_layout_vertical, null);


             if(mTrackThree != null)
                 mTrackThree.setVisibility(View.GONE);
             DesignMenuFields.initilizeDesignMenuFields(container,this);
        }
        else if(layout == R.layout.font_styles_sub_menu_lat)
        {
            container = getmInflater().inflate(R.layout.font_styles_sub_menu_lat, null);
            DesignMenuFields.loadFontNames(container);


        }
        else if(layout == R.layout.font_sub_color_menu)
        {
            container = getmInflater().inflate(R.layout.font_sub_color_menu, null);
                 }
        container.setFocusable(true);
        container.setClickable(true);
        getmTrack().addView(container);
    }
    public void setView(int scroller,int scrollerLayout)
    {
        setmTrack((ViewGroup) mRootView.findViewById(scrollerLayout));
        mTrackTwo = (ViewGroup)mRootView.findViewById(R.id.dropDownChangerOne);
        mTrackThree = (ViewGroup)mRootView.findViewById(R.id.dropDownChangerTwo);
        mScroller	= (ScrollView) mRootView.findViewById(scroller);
        mAnimStyle 	= ANIM_AUTO;
    }


    public void setMenuHeadings() {
        design = (TextView)mRootView.findViewById(R.id.tv_design_head);
        font_sub_menu_heading_layout  = (LinearLayout)mRootView.findViewById(R.id.font_sub_menu_heading_layout_design);
        font_chroven_left = (ImageView)mRootView.findViewById(R.id.font_chroven_left_design);
        font_heading_left = (TextView)mRootView.findViewById(R.id.font_heading_left_design);
        font_sub_menu_heading_layout.setVisibility(View.GONE);
        font_chroven_left.setOnClickListener(this);
        font_heading_left.setOnClickListener(this);
        switch (getHeading_id()) {
            case R.id.tv_design_head:
                design.setVisibility(View.VISIBLE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
        }
        setContentView(mRootView);
    }

    public void setSubMenuHeadings(int id) {


        switch (id)
        {
            case R.id.tv_design_head:
                design.setVisibility(View.VISIBLE);
                font_sub_menu_heading_layout.setVisibility(View.GONE);
                break;
            case R.id.font_sub_menu_heading_layout_design:
                font_sub_menu_heading_layout.setVisibility(View.VISIBLE);
                design.setVisibility(View.GONE);
                break;

        }
        setContentView(mRootView);
    }

    public void load(String head) {
        if(head.equals("font")) {
            setView(Fields.scrollers[1], Fields.scrollerLayouts[1]);
            if (getmTrack().getChildCount() > 0)
                getmTrack().removeAllViews();
            setSubMenuHeadings(R.id.font_sub_menu_heading_layout_design);
            addActionItem(R.layout.font_styles_sub_menu_lat);
            font_chroven_left.setOnClickListener(this);
            font_heading_left.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {

            case R.id.row_font:
            case R.id.tv_font:
            case R.id.iv_font:
           // case R.id.op_font:
                load("font");
                mTrackTwo.setVisibility(View.GONE);
                mTrackThree.setVisibility(View.VISIBLE);
                break;
            case R.id.font_chroven_left_design:
            case R.id.font_heading_left_design:
            //case R.id.font_sub_menu_heading_layout:
                setSubMenuHeadings(R.id.tv_design_head);
                mTrackTwo.setVisibility(View.VISIBLE);
                mTrackThree.setVisibility(View.GONE);
                //Fields.op_company.setText(database.isFieldEnabled("company"));
                break;
        }
    }
    @Override
    public void onDismiss() {
        if (!mDidAction && mDismissListener != null) {
            mDismissListener.onDismiss();
        }
    }


    public void show(View anchor) {
        preShow();

        int xPos, yPos, arrowPos;

        mDidAction = false;

        int[] location = new int[2];


        anchor.getLocationOnScreen(location);
        Rect anchorRect = new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1]
                + anchor.getHeight());

        //mRootView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));

        mRootView.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        int rootHeight = mRootView.getMeasuredHeight();

        if (rootWidth == 0) {
            rootWidth = mRootView.getMeasuredWidth();
        }

        int screenWidth = mWindowManager.getDefaultDisplay().getWidth();
        int screenHeight = mWindowManager.getDefaultDisplay().getHeight();

        //automatically get X coord of popup (top left)
        if ((anchorRect.left + rootWidth) > screenWidth) {
            xPos = anchorRect.left - (rootWidth - anchor.getWidth());
            xPos = (xPos < 0) ? 0 : xPos;

            arrowPos = anchorRect.centerX() - xPos;

        } else {
            if (anchor.getWidth() > rootWidth) {
                xPos = anchorRect.centerX() - (rootWidth / 2);
            } else {
                xPos = anchorRect.left;
            }

            arrowPos = anchorRect.centerX() - xPos;
        }

        int dyTop = anchorRect.top;
        int dyBottom = screenHeight - anchorRect.bottom;

        boolean onTop = (dyTop > dyBottom) ? true : false;

        if (onTop) {
            if (rootHeight > dyTop) {
                yPos = 15;
                ViewGroup.LayoutParams l = mScroller.getLayoutParams();
                l.height = dyTop - anchor.getHeight();
            } else {
                yPos = anchorRect.top - rootHeight;
            }
        } else {
            yPos = anchorRect.bottom;

            if (rootHeight > dyBottom) {
                ViewGroup.LayoutParams l = mScroller.getLayoutParams();
                l.height = dyBottom;
            }
        }

        showArrow(((onTop) ? R.id.arrow_down_two : R.id.arrow_up), arrowPos);

        setAnimationStyle(screenWidth, anchorRect.centerX(), onTop);

        mWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, xPos, yPos);
    }

    public int getHeading_id() {
        return 0;
    }

    public void setHeading_id(int heading_id) {
        this.heading_id = heading_id;
    }

    public void setAnimationStyle(int screenWidth, int requestedX, boolean onTop) {
        int arrowPos = requestedX - mArrowUp.getMeasuredWidth() / 2;

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
                if (arrowPos <= screenWidth / 4) {
                    mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
                } else if (arrowPos > screenWidth / 4 && arrowPos < 3 * (screenWidth / 4)) {
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

        ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams) showArrow.getLayoutParams();

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