package singin.com.techcoda.signin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by android on 7/25/2016.
 */
public class SubMenuQuickAction {}//extends QuickAction {
//
//    public SubMenuQuickAction(Context context) {
//        this(context, VERTICAL);
//    }
//    public SubMenuQuickAction(Context context, int orientation) {
//        super(context,orientation);
//    }//end of constructor
//
//    @Override
//    public void setHeading(String heading){
//        LinearLayout submenu = (LinearLayout)mRootView.findViewById(R.id.sub_menu_layout);
//
//        if(!heading.equals("Font Color"))
//            submenu.setVisibility(View.GONE);
//
//        setContentView(mRootView);
//    }
//    @Override
//    public void addActionItem(ActionItem action) {
//        actionItems.add(action);
//        final String titleLeft 	= action.getLeftTitle();
//        String titleRight = action.getRightTilte();
//        boolean isLineEnabled = action.isLineEnabled();
//        View colorBar = action.getColorBar();
//        Drawable icon = action.getIcon();
//        CheckBox visitorAgreemtnCheckBoxOne = action.getVisitorAgreementCheckBox();
//        EditText searchField = action.getSearchField();
//        View blank =  action.getBlank();
//
//        View container;
//        if( mOrientation == HORIZONTAL)
//        {
//            container = mInflater.inflate(R.layout.action_item_horizontal, null);
//        }else  {
//            container = mInflater.inflate(R.layout.action_item_vertical, null);
//        }
//
//
//
//        TextView left 	= (TextView) container.findViewById(R.id.titleLeft);
//        TextView right 	= (TextView) container.findViewById(R.id.titleRight);
//        ImageView img = (ImageView)container.findViewById(R.id.iv_icon);
//        CheckBox visitorAgreementCheckBoxTwo = (CheckBox)container.findViewById(R.id.visitor_agreement_check_box);
//        EditText searchFieldTwo = (EditText)container.findViewById(R.id.report_menu_search_field);
//        View colorBarTwo = (View)container.findViewById(R.id.right_color_bar);
//        View blankTwo = (View)container.findViewById(R.id.blank);
//        View seperator = (View)container.findViewById(R.id.separator);
//
////        DropDownListHandler handler = new DropDownListHandler(mContext,container,action);
////        img.setOnClickListener(handler);
//
//
//        if (icon != null ) {
//            img.setImageDrawable(icon);
//
//        } else {
//            img.setVisibility(View.GONE);
//        }
//        if (titleLeft != null) {
//            left.setText(titleLeft);
//        } else {
//            left.setVisibility(View.GONE);
//        }
//        if(titleRight != null)
//        {
//            right.setText(titleRight);
//        }
//        else {
//            right.setVisibility(View.GONE);
//        }
//        if(searchField != null)
//        {
//            //Ok
//        }
//        else{
//            searchFieldTwo.setVisibility(View.GONE);
//        }
////
//        if(visitorAgreemtnCheckBoxOne != null)
//        {
////			isOnlyTitle = false;
//        }
//        else
//            visitorAgreementCheckBoxTwo.setVisibility(View.GONE);
//
//        if(blank != null)
//        {
//            ViewGroup.LayoutParams params = blankTwo.getLayoutParams();
//
//            params.height = action.getBlankHeight();
//            params.width = 270;
//
//            blankTwo.setLayoutParams(params);
//        }
//        else
//            blankTwo.setVisibility(View.GONE);
//
//
//        if(colorBar != null)
//        {
//            Toast.makeText(mContext.getApplicationContext(),"Color bar is enabled",Toast.LENGTH_LONG).show();
//            //color_bar is enabled
//        }
//        else
//        {
//            colorBarTwo.setVisibility(View.GONE);
//        }
//
//        if(isLineEnabled)
//        {
//
//        }else
//            seperator.setVisibility(View.GONE);
//        final int pos 		=  mChildPos;
//        final int actionId 	= action.getActionId();
//
//
//        container.setFocusable(true);
//        container.setClickable(true);
//
//        if (mOrientation == HORIZONTAL && mChildPos != 0) {
//            View separator = mInflater.inflate(R.layout.horiz_separator, null);
//
//            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.FILL_PARENT);
//
//            separator.setLayoutParams(params);
//            separator.setPadding(5, 0, 5, 0);
//
//            mTrack.addView(separator, mInsertPos);
//
//            mInsertPos++;
//        }
//
//        mTrack.addView(container, mInsertPos);
//        mChildPos++;
//        mInsertPos++;
//    }//end of addActionItem method..
//}//end of class...
