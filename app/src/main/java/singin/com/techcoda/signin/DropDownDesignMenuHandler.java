package singin.com.techcoda.signin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ScrollView;

/**
 * Created by android on 8/12/2016.
 */
public class DropDownDesignMenuHandler {//extends PopupWindows implements PopupWindow.OnDismissListener,View.OnClickListener {
//    public View mRootView;
//    private ImageView mArrowUp;
//    private ImageView mArrowDown;
//    private LayoutInflater mInflater;
//    private ViewGroup mTrack;
//    private ViewGroup mTrackTwo;
//    private ViewGroup mTrackThree;
//    public ScrollView mScroller;
//    private boolean mDidAction;
//    public int mAnimStyle;
//    private int mOrientation;
//    private int rootWidth=0;
//    private Database database;
//    private View container;
//    private QuickAction.OnDismissListener mDismissListener;
//    public static final int HORIZONTAL = 0;
//    public static final int VERTICAL = 1;
//
//    private static final int ANIM_GROW_FROM_LEFT = 1;
//    private static final int ANIM_GROW_FROM_RIGHT = 2;
//    private static final int ANIM_GROW_FROM_CENTER = 3;
//    public static final int ANIM_REFLECT = 4;
//    public static final int ANIM_AUTO = 5;
//
//    public DropDownDesignMenuHandler(Context context, int orientation, int heading_id) {
//        super(context);
//
//        setHeading_id(heading_id);
//        mOrientation = orientation;
//        setmInflater((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
//        if (mOrientation == HORIZONTAL) {
//            setRootViewId(R.layout.popup_horizontal);
//        } else {
//            setRootViewId(R.layout.popup_vertical);
//        }
//    }//end of constructor
//
//    public void setRootViewId(int id) {
//        mRootView	= (ViewGroup) getmInflater().inflate(id, null);
//        //mRootViewTwo = (ViewGroup)mInflater.inflate(id,null);
//        mArrowDown 	= (ImageView) mRootView.findViewById(R.id.arrow_down_two);
//        mArrowUp 	= (ImageView) mRootView.findViewById(R.id.arrow_up);
//
//        //   filiper = (ViewFlipper)mRootView.findViewById(R.id.dropDownFlipper);
//        mRootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        //mRootViewTwo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//    }
//
//    public void addActionItem(int layout) {
//
//        if (mOrientation == HORIZONTAL) {
//            container = getmInflater().inflate(R.layout.action_item_horizontal, null);
//        } else if (layout == R.layout.setup_menu_layout_vertical && mOrientation == VERTICAL) {
//            container = getmInflater().inflate(R.layout.setup_menu_layout_vertical, null);
//            //setupMenuCurrentSate = new RestoreCurrentStateOfApplication(mContext,container);
//            if (mTrackThree != null)
//                mTrackThree.setVisibility(View.GONE);
//
//            Fields.initilizeSetupFilds(container, this);
//
//            LoadOptionFields loadOptionFields = new LoadOptionFields(mContext, container);
//            loadOptionFields.startLoading();
//            currentSate = new RestoreCurrentStateOfApplication(mContext, container);
//            currentSate.loadAgreement();
//
//        }
//    }
}
