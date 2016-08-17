package singin.com.techcoda.signin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;


public class QuickAction{} //extends PopupWindows implements OnDismissListener,OnClickListener{
//	protected View mRootView;
//	protected ImageView mArrowUp;
//	protected ImageView mArrowDown;
//	private String topDownHeading;
//	private String innerDropDownHeading;
//	protected LayoutInflater mInflater;
//	protected ViewGroup mTrack;
//	protected ScrollView mScroller;
//	protected OnActionItemClickListener mItemClickListener;
//	protected OnDismissListener mDismissListener;
//	private DropDownListHandler dropDownHandler;
//	private View container;
//	private View subMenuView;
//	protected List<ActionItem> actionItems = new ArrayList<ActionItem>();
//	private DropDownMenus previousDropDownMenu;
//	private DropDownMenus designQuickAction;
//	private static ActionItem action;
//	protected boolean mDidAction;
//	protected int mChildPos;
//    protected int mInsertPos;
//    protected int mAnimStyle;
//    protected int mOrientation;
//    protected int rootWidth=0;
//
//    public static final int HORIZONTAL = 0;
//    public static final int VERTICAL = 1;
//
//    public static final int ANIM_GROW_FROM_LEFT = 1;
//	public static final int ANIM_GROW_FROM_RIGHT = 2;
//	public static final int ANIM_GROW_FROM_CENTER = 3;
//	public static final int ANIM_REFLECT = 4;
//	public static final int ANIM_AUTO = 5;
//	private ViewFlipper filiper;
//	private int scroller;
//	private int scrollerLayout;
//	//Layout variables...
//	private DropDownMenus setupQuickAction;
//	private String titleLeft;
//	private CheckBox rightCheckBox;
//	private boolean isRightTitleEnabled;
//	private String titleRight;
//	private boolean isLineEnabled;
//	private View rightColor;
//	private String color;
//	private View leftColor;
//	private Drawable icon;
//	private CheckBox visitorAgreemtnCheckBoxOne;
//	private EditText searchField;
//	private View blank;
//	private TextView left;
//	private TextView right;
//	private ImageView img;
//	private CheckBox visitorAgreementCheckBoxTwo;
//	private EditText searchFieldTwo;
//	private View rightColorBar;
//	private EditText simpleTextField;
//	private EditText isSimlpleTextFieldEnalbed;
//	private View leftColorBar;
//	private View blankTwo;
//	private View seperator;
//	private View colorBar;
//	private CheckBox rightCheck;
//	private View colorBarTwo;
//	private TextView setup;
//	private TextView report;
//	private TextView design;
//	private LinearLayout fontHeading;
//    /**
//     * Constructor for default vertical layout
//     *
//     * @param context  Context
//     */
//    public QuickAction(Context context) {
//        this(context, VERTICAL);
//
//    }
//
//    /**
//     * Constructor allowing orientation override
//     *
//     * @param context    Context
//     * @param orientation Layout orientation, can be vartical or horizontal
//     */
//    public QuickAction(Context context, int orientation) {
//        super(context);
//
//        mOrientation = orientation;
//        mInflater 	 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//		if (mOrientation == HORIZONTAL) {
//			setRootViewId(R.layout.popup_horizontal);
//		} else {
//			setRootViewId(R.layout.popup_vertical);
//		}
//    }
//	public void setView(int scroller,int scrollerLayout)
//	{
//		setScroller(scroller);
//		setScrollerLayout(scrollerLayout);
//		mTrack 		= (ViewGroup) mRootView.findViewById(getScrollerLayout());
//
//		mScroller	= (ScrollView) mRootView.findViewById(getScroller());
//
//		mAnimStyle 	= ANIM_AUTO;
//		mChildPos 	= 0;
//	}
//
//	public static ActionItem getAction() {
//		return action;
//	}
//
//	public static void setAction(ActionItem action) {
//		QuickAction.action = action;
//	}
//
//	/**
//     * Get action item at an index
//     *
//     * @param index  Index of item (position from callback)
//     *
//     * @return  Action Item at the position
//     */
//    public ActionItem getActionItem(int index) {
//        return actionItems.get(index);
//    }
//
//	/**
//	 * Set root view.
//	 *
//	 * @param id Layout resource id
//	 */
//	public void setRootViewId(int id) {
//		mRootView	= (ViewGroup) mInflater.inflate(id, null);
//
//
////		if(mTrack.getChildCount()>0)
////			mTrack.removeAllViewsInLayout();
//		mArrowDown 	= (ImageView) mRootView.findViewById(R.id.arrow_down_two);
//		mArrowUp 	= (ImageView) mRootView.findViewById(R.id.arrow_up);
//
//		//filiper = (ViewFlipper)mRootView.findViewById(R.id.dropDownFlipper);
//		//This was previously defined on show() method, moved here to prevent force close that occured
//		//when tapping fastly on a view to show quickaction dialog.
//
//		mRootView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//	}
//	/**
//	 * Set animation style
//	 *
//	 * @param mAnimStyle animation style, default is set to ANIM_AUTO
//	 */
//	public void setAnimStyle(int mAnimStyle) {
//		this.mAnimStyle = mAnimStyle;
//	}
//
//	/**
//	 * Set listener for action item clicked.
//	 *
//	 * @param listener Listener
//	 */
//	public void setOnActionItemClickListener(OnActionItemClickListener listener) {
//		mItemClickListener = listener;
//	}
//
//
// 	public void reset(){
//		mInsertPos = 0;
//		actionItems = new ArrayList<ActionItem>();
//	}
//	public void setHeading(String heading)
//	{
//		this.topDownHeading = heading;
//		 setup = (TextView)mRootView.findViewById(R.id.setup);
//		 report = (TextView)mRootView.findViewById(R.id.report_heading);
//		 design = (TextView)mRootView.findViewById(R.id.design);
//		fontHeading = (LinearLayout)mRootView.findViewById(R.id.font_sub_menu_heading_layout);
//
//
//		if(!topDownHeading.equals("setup"))
//		{
//			setup.setVisibility(View.GONE);
//		}
//		if(!topDownHeading.equals("report"))
//    	{
//			report.setVisibility(View.GONE);
//		}
//		if(!topDownHeading.equals("design"))
//				design.setVisibility(View.GONE);
//		fontHeading.setVisibility(View.GONE);
//		setContentView(mRootView);
//	}//end of setPaddingOf method..
//
//
//	public void setInnerDropDown(){
//		//LinearLayout tracks = (LinearLayout)mRootView.findViewById(R.id.tracks);
//
//		ImageView leftImage = (ImageView)mRootView.findViewById(R.id.chroven_left);
//		TextView tx_heading_left = (TextView)mRootView.findViewById(R.id.txt_design);
//		final TextView heading_right = (TextView) mRootView.findViewById(R.id.font_heading_center);
//		previousDropDownMenu = new DropDownMenus(mContext);
//
//
//		fontHeading.setVisibility(View.VISIBLE);
//		if( getInnerDropDownHeading().equals("font color")) {
//
//			reset();
//
//			if(mTrack.getChildCount()>0){
//				mTrack.removeAllViews();
//			}
//			tx_heading_left.setText("Design");
//			heading_right.setText("\tFont Color");
//			getDropDownHandler().setFontColorSubMenu();
//			getDropDownHandler().addItemsToFontColorMenu();
//		}//end of if(heading("font color")) statement
//		else if( getInnerDropDownHeading().equals("font"))
//		{
//
//			reset();
//
//			if(mTrack.getChildCount()>0){
//				mTrack.removeAllViews();
//			}
//			FontFamilies.fontFamiliesIndex = 0;
//			getDropDownHandler().setFontSubMenu();
//			getDropDownHandler().addItemToFontSubMenu();
//			tx_heading_left.setText("Design");
//			heading_right.setText("\t\tFont     ");
//
//		}//end of if(heading.equals("font")) statement
//		else if( getInnerDropDownHeading().equals("company")){
//			getDropDownHandler().setCompanySubMenu();
//			getDropDownHandler().addItemsToCompanySubMenu();
//			tx_heading_left.setText("Setup");
//			heading_right.setText("\t    company");
//		}//end of else if(heading.equals("company")) statement
//		else if( getInnerDropDownHeading().equals("photo capture"))
//		{
//			getDropDownHandler().setPhotoCaptureSubmenu();
//			getDropDownHandler().addItemsToPhotoCaptureSubMenu();
//			tx_heading_left.setText("Setup");
//			heading_right.setText("Photo Capture");
//		}//end of else if(heading.equals("photo capture")) statement
//		else  if( getInnerDropDownHeading().equals("company"))
//		{
//			getDropDownHandler().setCompanySubMenu();
//			getDropDownHandler().addItemsToCompanySubMenu();
//			tx_heading_left.setText("Setup");
//			heading_right.setText("\t    company");
//		}//end of else if(heading.equals("company")) statement
//		else if( getInnerDropDownHeading().equals("visitor agreement text"))
//		{
//
//			getDropDownHandler().setVisitorAgreementSubMenu();
//			getDropDownHandler().addItemsToVisitorAgreementSubMenu();
//			tx_heading_left.setText("Setup");
//			heading_right.setText("Visitor Agreement Text");
//		}
//		else
//			fontHeading.setVisibility(View.GONE);
//
//		filiper.showPrevious();
//		tx_heading_left.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				design.setVisibility(View.VISIBLE);
//				fontHeading.setVisibility(View.GONE);
//				filiper.showNext();
//			}
//		});
//		leftImage.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				design.setVisibility(View.VISIBLE);
//				fontHeading.setVisibility(View.GONE);
//				filiper.showNext();
//			}
//		});
//		setContentView(mRootView);
//	}
//	@Override
//	public void onClick(View v)
//	{
//		dismiss();
//		//previousDropDownMenu.design_button_clicked(getSubMenuView());
//	}
//
//	public void addSubActionItem(ActionItem action)
//	{
//
//		actionItems.add(action);
//		this.setAction(action);
//		initializeLayoutVariables();
//		if(leftColorBar != null && color != null)
//		{
//			leftColorBar.setBackgroundColor(Color.parseColor(color));
//
//		}
//
//		if (titleLeft != null &&  topDownHeading.equals("font")) {
//
//			Typeface face = Typeface.create(FontFamilies.fontFamilies[FontFamilies.fontFamiliesIndex],R.style.normal_font);
//
//			left.setTypeface(face);
//			left.setText(FontFamilies.fontFamilies[FontFamilies.fontFamiliesIndex]);
//			FontFamilies.fontFamiliesIndex++;
//		}else if(titleLeft != null && ! topDownHeading.equals("font")){
//			left.setText(titleLeft);
//		}
//		else {
//			left.setVisibility(View.GONE);
//		}
//		if( topDownHeading.equals("photo capture"))
//			simpleTextField.setHint("Photo Capture");
//
//		if( topDownHeading.equals("visitor agreement text"))
//			simpleTextField.setHint("Please sign here");
//		if(rightCheckBox == null)
//		{
//			rightCheck.setVisibility(View.GONE);
//		}
//        if(leftColor == null)
//		{
//			leftColorBar.setVisibility(View.GONE);
//		}
//		if(searchField == null)
//			searchFieldTwo.setVisibility(View.GONE);
//		if(visitorAgreemtnCheckBoxOne == null)
//			visitorAgreementCheckBoxTwo.setVisibility(View.GONE);
//
//		if(blank != null)
//		{
//			LayoutParams params = blankTwo.getLayoutParams();
//
//			params.height = action.getBlankHeight();
//			params.width = 270;
//
//			blankTwo.setLayoutParams(params);
//		}
//		else
//			blankTwo.setVisibility(View.GONE);
//
//		if(rightColor == null)
//		{
//			colorBarTwo.setVisibility(View.GONE);
//		}
//		if(!isLineEnabled)
//		{
//			seperator.setVisibility(View.GONE);
//		}
//		if(titleLeft != null && isRightTitleEnabled)
//		{
//			int color = R.color.right_title_color;
//			left.setTextColor(Color.parseColor("#bdbdbd"));
//			//left.setTextColor(Color.alpha(color));
//		}
//
//		settings();
//	}//end of addSubActionItem method..
//
//	//initializeLayout variables method
//
//	public void initializeLayoutVariables(){
//		rightCheckBox = action.getColorAgreement();
//		titleLeft 	= action.getLeftTitle();
//		isRightTitleEnabled = action.isRightTitleEnabled();
//		titleRight = action.getRightTilte();
//		isLineEnabled = action.isLineEnabled();
//		colorBar = action.getColorBar();
//		leftColor = action.getLeftColorBar();
//		icon = action.getIcon();
//		visitorAgreemtnCheckBoxOne = action.getVisitorAgreementCheckBox();
//		searchField = action.getSearchField();
//		blank =  action.getBlank();
//		color = action.getColor();
//		isSimlpleTextFieldEnalbed = action.getIsSimpleTextFieldEnabled();
//		if( mOrientation == HORIZONTAL)
//		{
//			container = mInflater.inflate(R.layout.action_item_horizontal, null);
//		}else  {
//			container = mInflater.inflate(R.layout.action_item_vertical, null);
//		}
//
//		left 	= (TextView) container.findViewById(R.id.titleLeft);
//		right 	= (TextView) container.findViewById(R.id.titleRight);
//		img = (ImageView)container.findViewById(R.id.iv_icon);
//		visitorAgreementCheckBoxTwo = (CheckBox)container.findViewById(R.id.visitor_agreement_check_box);
//		searchFieldTwo = (EditText)container.findViewById(R.id.report_menu_search_field);
//		colorBarTwo = (View)container.findViewById(R.id.right_color_bar);
//		leftColorBar = (View)container.findViewById(R.id.left_color_bar);
//		blankTwo = (View)container.findViewById(R.id.blank);
//		seperator = (View)container.findViewById(R.id.separator);
//		rightCheck = (CheckBox)container.findViewById(R.id.rightCheckBox);
//		simpleTextField = (EditText)container.findViewById(R.id.simple_text_field);
//	}
//
//	/**
//	 * Add action item
//	 *
//	 * @param action  {@link ActionItem}
//	 */
//	public void addActionItem(ActionItem action) {
//
//		actionItems.add(action);
//		this.setAction(action);
//
//		initializeLayoutVariables();
//		setDropDownHandler(new DropDownListHandler(mContext,action));
//		getDropDownHandler().setCurrentQuickAction(this);
//		img.setOnClickListener(getDropDownHandler());
//
//		//if(titleLeft != null && titleLeft.equals("Font Color") || titleLeft != null && titleLeft.equals("Font"))
//		if(titleLeft != null)
//			left.setOnClickListener(getDropDownHandler());
//
////		if(titleLeft != null && titleLeft.equals("company"))
////			left.setOnClickListener(getDropDownHandler());
//
//		if(rightCheckBox == null)
//		{
//			rightCheck.setVisibility(View.GONE);
//		}
//		if(leftColor == null)
//			leftColorBar.setVisibility(View.GONE);
//
//		if (titleLeft != null) {
//
//			if(titleLeft.equals("Subtitle") && titleRight != null){
//				left.setWidth(70);
//				left.setPadding(5,10,0,5);
//				right.setPadding(-80,10,0,5);
//			}//end of inner if
//			left.setText(titleLeft);
//		} else {
//			left.setVisibility(View.GONE);
//		}
//		if(titleLeft != null && isRightTitleEnabled)
//		{
//			int color = R.color.right_title_color;
//			left.setTextColor(Color.parseColor("#bdbdbd"));
//			//left.setTextColor(Color.alpha(color));
//		}
//		if(searchField == null)
//			searchFieldTwo.setVisibility(View.GONE);
//		if(visitorAgreemtnCheckBoxOne == null)
//			visitorAgreementCheckBoxTwo.setVisibility(View.GONE);
//
//		if(blank != null)
//		{
//			LayoutParams params = blankTwo.getLayoutParams();
//
//			params.height = action.getBlankHeight();
//			params.width = 270;
//
//			blankTwo.setLayoutParams(params);
//		}
//		else
//			blankTwo.setVisibility(View.GONE);
//
//
//		if(colorBar != null && icon != null && titleLeft != null)
//		{
//			img.setVisibility(View.GONE);
//			//color_bar is enabled
//		}
//		else
//		{
//			colorBarTwo.setVisibility(View.GONE);
//		}
//		//setting padding of 'Report' heading
//		if(getTopDropDownHeading().equals("report") )
//		{
//			LayoutParams params = seperator.getLayoutParams();
//			params.width = 290;
//		}
//		if(!isLineEnabled)
//		{
//			seperator.setVisibility(View.GONE);
//		}
//
//		settings();
//		}//end of addActionItem method..
//
//
//	public void settings(){
//		if(isSimlpleTextFieldEnalbed == null)
//		{
//			simpleTextField.setVisibility(View.GONE);
//		}
//		if (icon != null ) {
//			img.setImageDrawable(icon);
//		} else {
//			img.setVisibility(View.GONE);
//		}
//		if(titleRight != null)
//		{
//			right.setText(titleRight);
//		}
//		else {
//			right.setVisibility(View.GONE);
//		}
//		final int pos 		=  mChildPos;
//		final int actionId 	= getAction().getActionId();
//
//		container.setFocusable(true);
//		container.setClickable(true);
//
//		if (mOrientation == HORIZONTAL && mChildPos != 0) {
//			View separator = mInflater.inflate(R.layout.horiz_separator, null);
//
//			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT);
//
//			separator.setLayoutParams(params);
//			separator.setPadding(5, 0, 5, 0);
//
//			mTrack.addView(separator, mInsertPos);
//			mInsertPos++;
//		}
//
//		mTrack.addView(container, mInsertPos);
//		mChildPos++;
//		mInsertPos++;
//
//	}
//	/**
//	 * Show quickaction popup. Popup is automatically positioned, on top or bottom of anchor view.
//	 *
//	 */
//	public void show (View anchor) {
//		preShow();
//
//		int xPos, yPos, arrowPos;
//
//		mDidAction 			= false;
//
//		int[] location 		= new int[2];
//
//
//		anchor.getLocationOnScreen(location);
//		Rect anchorRect 	= new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1]
//		                	+ anchor.getHeight());
//
//		//mRootView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//
//		mRootView.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//
//		int rootHeight 		= mRootView.getMeasuredHeight();
//
//		if (rootWidth == 0) {
//			rootWidth		= mRootView.getMeasuredWidth();
//		}
//
//		int screenWidth 	= mWindowManager.getDefaultDisplay().getWidth();
//		int screenHeight	= mWindowManager.getDefaultDisplay().getHeight();
//
//		//automatically get X coord of popup (top left)
//		if ((anchorRect.left + rootWidth) > screenWidth) {
//			xPos 		= anchorRect.left - (rootWidth-anchor.getWidth());
//			xPos 		= (xPos < 0) ? 0 : xPos;
//
//			arrowPos 	= anchorRect.centerX()-xPos;
//
//		} else {
//			if (anchor.getWidth() > rootWidth) {
//				xPos = anchorRect.centerX() - (rootWidth/2);
//			} else {
//				xPos = anchorRect.left;
//			}
//
//			arrowPos = anchorRect.centerX()-xPos;
//		}
//
//		int dyTop			= anchorRect.top;
//		int dyBottom		= screenHeight - anchorRect.bottom;
//
//		boolean onTop		= (dyTop > dyBottom) ? true : false;
//
//		if (onTop) {
//			if (rootHeight > dyTop) {
//				yPos 			= 15;
//				LayoutParams l 	= mScroller.getLayoutParams();
//				l.height		= dyTop - anchor.getHeight();
//			} else {
//				yPos = anchorRect.top - rootHeight;
//			}
//		} else {
//			yPos = anchorRect.bottom;
//
//			if (rootHeight > dyBottom) {
//				LayoutParams l 	= mScroller.getLayoutParams();
//				l.height		= dyBottom;
//			}
//		}
//
//		showArrow(((onTop) ? R.id.arrow_down_two : R.id.arrow_up), arrowPos);
//
//		setAnimationStyle(screenWidth, anchorRect.centerX(), onTop);
//
//		mWindow.showAtLocation(anchor, Gravity.NO_GRAVITY, xPos, yPos);
//	}
//
//	/**
//	 * Set animation style
//	 *
//	 * @param screenWidth screen width
//	 * @param requestedX distance from left edge
//	 * @param onTop flag to indicate where the popup should be displayed. Set TRUE if displayed on top of anchor view
//	 * 		  and vice versa
//	 */
//	private void setAnimationStyle(int screenWidth, int requestedX, boolean onTop) {
//		int arrowPos = requestedX - mArrowUp.getMeasuredWidth()/2;
//
//		switch (mAnimStyle) {
//		case ANIM_GROW_FROM_LEFT:
//			mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
//			break;
//
//		case ANIM_GROW_FROM_RIGHT:
//			mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Right : R.style.Animations_PopDownMenu_Right);
//			break;
//
//		case ANIM_GROW_FROM_CENTER:
//			mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Center : R.style.Animations_PopDownMenu_Center);
//		break;
//
//		case ANIM_REFLECT:
//			mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Reflect : R.style.Animations_PopDownMenu_Reflect);
//		break;
//
//		case ANIM_AUTO:
//			if (arrowPos <= screenWidth/4) {
//				mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Left : R.style.Animations_PopDownMenu_Left);
//			} else if (arrowPos > screenWidth/4 && arrowPos < 3 * (screenWidth/4)) {
//				mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Center : R.style.Animations_PopDownMenu_Center);
//			} else {
//				mWindow.setAnimationStyle((onTop) ? R.style.Animations_PopUpMenu_Right : R.style.Animations_PopDownMenu_Right);
//			}
//
//			break;
//		}
//	}
//
//	/**
//	 * Show arrow
//	 *
//	 * @param whichArrow arrow type resource id
//	 * @param requestedX distance from left screen
//	 */
//	private void showArrow(int whichArrow, int requestedX) {
//        final View showArrow = (whichArrow == R.id.arrow_up) ? mArrowUp : mArrowDown;
//        final View hideArrow = (whichArrow == R.id.arrow_up) ? mArrowDown : mArrowUp;
//
//        final int arrowWidth = mArrowUp.getMeasuredWidth();
//
//        showArrow.setVisibility(View.VISIBLE);
//
//        ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams)showArrow.getLayoutParams();
//
//        param.leftMargin = requestedX - arrowWidth / 2;
//
//        hideArrow.setVisibility(View.INVISIBLE);
//    }
//
//
//	/**
//	 * Set listener for window dismissed. This listener will only be fired if the quicakction dialog is dismissed
//	 * by clicking outside the dialog or clicking on sticky item.
//	 */
//	public void setOnDismissListener(OnDismissListener listener) {
//		setOnDismissListener(this);
//
//		mDismissListener = listener;
//	}
//
//
//	@Override
//	public void onDismiss() {
//		if (!mDidAction && mDismissListener != null) {
//			mDismissListener.onDismiss();
//		}
//	}
//
//	public String getTopDropDownHeading() {
//		return  topDownHeading;
//	}
//	public void setTopDropDownHeading(String topHeading) {
//		 topDownHeading = topHeading;
//	}
//
//	public View getSubMenuView() {
//		return subMenuView;
//	}
//
//	public void setSubMenuView(View subMenuView) {
//		this.subMenuView = subMenuView;
//	}
//
//	public DropDownMenus getDesignQuickAction() {
//		return designQuickAction;
//	}
//
//	public void setDesignQuickAction(DropDownMenus designQuickAction) {
//		this.designQuickAction = designQuickAction;
//	}
//
//	public DropDownListHandler getDropDownHandler() {
//		return dropDownHandler;
//	}
//
//	public void setDropDownHandler(DropDownListHandler dropDownHandler) {
//		this.dropDownHandler = dropDownHandler;
//	}
//
//	public DropDownMenus getSetupQuickAction() {
//		return setupQuickAction;
//	}
//
//	public void setSetupQuickAction(DropDownMenus setupQuickAction) {
//		this.setupQuickAction = setupQuickAction;
//	}
//
//	public int getScroller() {
//		return scroller;
//	}
//
//	public void setScroller(int scroller) {
//		this.scroller = scroller;
//	}
//
//	public int getScrollerLayout() {
//		return scrollerLayout;
//	}
//
//	public void setScrollerLayout(int scrollerLayout) {
//		this.scrollerLayout = scrollerLayout;
//	}
//
//	public String getInnerDropDownHeading() {
//		return innerDropDownHeading;
//	}
//
//	public void setInnerDropDownHeading(String innerDropDownHeading) {
//		this.innerDropDownHeading = innerDropDownHeading;
//	}
//
//	/**
//	 * Listener for item click
//	 *
//	 */
//	public interface OnActionItemClickListener {
//		public abstract void onItemClick(QuickAction source, int pos, int actionId);
//	}
//
//	/**
//	 * Listener for window dismiss
//	 *
//	 */
//	public interface OnDismissListener {
//		public abstract void onDismiss();
//	}
//}