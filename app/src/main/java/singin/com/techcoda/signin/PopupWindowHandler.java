package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.ScrollView;

/**
 * Created by android on 8/4/2016.
 */
public class PopupWindowHandler extends DropDownMenuHandler implements PopupWindow.OnDismissListener {
    private View container;
    private View v;
    public PopupWindowHandler(Context context){
        super(context,22,12);
        setRootViewId(R.layout.status_popup);
    }
    public void setView(int layout,int list) {
        if (list == 1){
            setContentView(mRootView);
            container = super.getmInflater().inflate(layout, null);
            if (getmTrack() != null && getmTrack().getChildCount()>0)
            {
                getmTrack().removeAllViews();
            }
            setmTrack((ViewGroup) mRootView.findViewById(R.id.status_drop_down_layout));

    }
        else if(list == 2)
        {

        }
        mScroller	= (ScrollView) mRootView.findViewById(R.id.status_drop_down_scroller);
        mAnimStyle 	= ANIM_AUTO;
        container.setFocusable(true);
        container.setClickable(true);
        getmTrack().addView(container);
    }
}
