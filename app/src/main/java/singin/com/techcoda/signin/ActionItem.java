package singin.com.techcoda.signin;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


public class ActionItem {
//	private Drawable icon;
//	private Bitmap thumb;
//	private String leftTitle;
//	private String rightTilte;
//	private CheckBox visitorAgreementCheckBox;
//	private EditText searchField;
//	private boolean isLineEnabled;
//	private int actionId = -1;
//    private boolean selected;
//	private View leftColorBar;
//	private View blank;
//	private CheckBox colorAgreement;
//	private String color;
//	private View colorBar;
//	private boolean isRightTitleEnabled;
//	private int blankHeight;
//    private boolean sticky;
//	private EditText isSimpleTextFieldEnabled;
//
//	public ActionItem(boolean isLineEnabled,EditText textField){
//		this.setIsSimpleTextFieldEnabled(textField);
//		this.setLineEnabled(isLineEnabled);
//	}
//    public ActionItem(int actionId, String leftTitle, Drawable icon,boolean isLineEnabled) {
//        this.leftTitle = leftTitle;
//        this.icon = icon;
//        this.actionId = actionId;
//		this.setLineEnabled(isLineEnabled);
//    }
//	public ActionItem(int actionId,String leftTitle,String titleRight,View color_bar,Drawable icon,boolean isLineEnabled)
//	{
//		this.setActionId(actionId);
//		this.setLeftTitle(leftTitle);
//		this.setColorBar(color_bar);
//		this.setLineEnabled(isLineEnabled);
//		this.setRightTilte(titleRight);
//		this.setIcon(icon);
//	}
//	public ActionItem(int actionId,String leftTitle,boolean isRightTitleEnabled,boolean isLineEnabled){
//		this.setRightTitleEnabled(isRightTitleEnabled);
//		this.setLeftTitle(leftTitle);
//		this.setActionId(actionId);
//		this.setLineEnabled(isLineEnabled);
//	}
//    public ActionItem(int actionId,String leftTitle,boolean isLineEnabled)
//    {
//        this.setLeftTitle(leftTitle);
//        this.icon = null;
//        this.setActionId(actionId);
//		this.setLineEnabled(isLineEnabled);
//    }
//	public ActionItem(int actionId,View leftColorBar,String color,String titleRight,CheckBox rightCheckBox,boolean isLineEnabled)
//	{
//		this.setActionId(actionId);
//		this.setLeftColorBar(leftColorBar);
//		this.setColor(color);
//		this.setRightTilte(titleRight);
//		this.setLineEnabled(isLineEnabled);
//		this.setColorAgreement(rightCheckBox);
//	}
//
//	public ActionItem(EditText searchField,boolean isLineEnabled)
//	{
//		setSearchField(searchField);
//		this.setLineEnabled(isLineEnabled);
//	}
//	public ActionItem(int actionId, String leftTitle,String rightTitle, Drawable icon,boolean isLineEnabled) {
//		this.leftTitle = leftTitle;
//		this.icon = icon;
//		this.setRightTilte(rightTitle);
//		this.actionId = actionId;
//		this.setLineEnabled(isLineEnabled);
//	}
//    public ActionItem(int actionId, String leftTitle,String rightTitle,boolean isLineEnabled) {
//        this.leftTitle = leftTitle;
//        this.icon = null;
//        this.setRightTilte(rightTitle);
//        this.actionId = actionId;
//		this.setLineEnabled(isLineEnabled);
//    }
//
//	public ActionItem(int actionId,String leftTitle,CheckBox visitorAgreementCheckBox,boolean isLineEnabled)
//	{
//		this.setActionId(actionId);
//		this.setLeftTitle(leftTitle);
//		this.setVisitorAgreementCheckBox(visitorAgreementCheckBox);
//		this.setLineEnabled(isLineEnabled);
//	}
//	public ActionItem(View blank,int height,boolean isLineEnabled)
//	{
//		this.setBlank(blank);
//		setBlankHeight(height);
//		this.setLineEnabled(isLineEnabled);
//	}
//	public ActionItem(int actionId,String leftTitle,String rightTilte,CheckBox colorAgreement,boolean isLineEnabled)
//	{
//		this.setActionId(actionId);
//		this.setLeftTitle(leftTitle);
//		this.setRightTilte(rightTilte);
//		this.setColorAgreement(colorAgreement);
//		this.setLineEnabled(isLineEnabled);
//	}
//	/**
//     * Constructor
//     */
//
//    /**
//     * Constructor
//     *
//     * @param actionId  Action id of the item
//     * @param title     Text to show for the item
//     */
//
//    /**
//     * Constructor
//     *
//     * @param icon {@link Drawable} action icon
//     */
//    public ActionItem(Drawable icon,boolean isLineEnabled) {
//        this(-1, null, icon,isLineEnabled);
//    }
//
//    /**
//     * Constructor
//     *
//     * @param actionId  Action ID of item
//     * @param icon      {@link Drawable} action icon
//     */
//    public ActionItem(int actionId, Drawable icon,boolean isLineEnabled) {
//        this(actionId, null, icon,isLineEnabled);
//    }
//
//	/**
//	 * Set action title
//	 *
//	 * @param title action title
//	 */
//	public void setLeftTitle(String title) {
//		this.leftTitle = title;
//	}
//
//	/**
//	 * Get action title
//	 *
//	 * @return action title
//	 */
//	public String getLeftTitle() {
//		return this.leftTitle;
//	}
//
//	/**
//	 * Set action icon
//	 *
//	 * @param icon {@link Drawable} action icon
//	 */
//	public void setIcon(Drawable icon) {
//		this.icon = icon;
//	}
//
//	/**
//	 * Get action icon
//	 * @return  {@link Drawable} action icon
//	 */
//	public Drawable getIcon() {
//		return this.icon;
//	}
//
//	 /**
//     * Set action id
//     *
//     * @param actionId  Action id for this action
//     */
//    public void setActionId(int actionId) {
//        this.actionId = actionId;
//    }
//
//    /**
//     * @return  Our action id
//     */
//
//	public boolean isSelected() {
//		return this.selected;
//	}
//
//	/**
//	 * Set thumb
//	 *
//	 * @param thumb Thumb image
//	 */
//	public void setThumb(Bitmap thumb) {
//		this.thumb = thumb;
//	}
//
//	/**
//	 * Get thumb image
//	 *
//	 * @return Thumb image
//	 */
//	public Bitmap getThumb() {
//		return this.thumb;
//	}
//
//	public int getActionId() {
//        return actionId;
//    }
//
//    /**
//     * Set sticky status of button
//     *
//     * @param sticky  true for sticky, pop up sends event but does not disappear
//     */
//    public void setSticky(boolean sticky) {
//        this.sticky = sticky;
//    }
//
//    /**
//     * @return  true if button is sticky, menu stays visible after press
//     */
//    public boolean isSticky() {
//        return sticky;
//    }
//
//	/**
//	 * Set selected flag;
//	 *
//	 * @param selected Flag to indicate the item is selected
//	 */
//	public void setSelected(boolean selected) {
//		this.selected = selected;
//	}
//
//	public String getRightTilte() {
//		return rightTilte;
//	}
//
//	public void setRightTilte(String rightTilte) {
//		this.rightTilte = rightTilte;
//	}
//
//	public CheckBox getVisitorAgreementCheckBox() {
//		return visitorAgreementCheckBox;
//	}
//
//	public void setVisitorAgreementCheckBox(CheckBox visitorAgreementCheckBox) {
//		this.visitorAgreementCheckBox = visitorAgreementCheckBox;
//	}
//
//	public View getBlank() {
//		return blank;
//	}
//
//	public void setBlank(View blank) {
//		this.blank = blank;
//	}
//
//	public int getBlankHeight() {
//		return blankHeight;
//	}
//
//	public void setBlankHeight(int blankHeight) {
//		this.blankHeight = blankHeight;
//	}
//
//	public EditText getSearchField() {
//		return searchField;
//	}
//
//	public void setSearchField(EditText searchField) {
//		this.searchField = searchField;
//	}
//
//	public boolean isRightTitleEnabled() {
//		return isRightTitleEnabled;
//	}
//
//	public void setRightTitleEnabled(boolean seperatorEnabled) {
//		isRightTitleEnabled = seperatorEnabled;
//	}
//
//	public boolean isLineEnabled() {
//		return isLineEnabled;
//	}
//
//	public void setLineEnabled(boolean lineEnabled) {
//		isLineEnabled = lineEnabled;
//	}
//
//	public View getColorBar() {
//		return colorBar;
//	}
//
//	public void setColorBar(View colorBar) {
//		this.colorBar = colorBar;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public void setColor(String color) {
//		this.color = color;
//	}
//
//	public View getLeftColorBar() {
//		return leftColorBar;
//	}
//
//	public void setLeftColorBar(View leftColorBar) {
//		this.leftColorBar = leftColorBar;
//	}
//
//	public CheckBox getColorAgreement() {
//		return colorAgreement;
//	}
//
//	public void setColorAgreement(CheckBox colorAgreement) {
//		this.colorAgreement = colorAgreement;
//	}
//
//	public EditText getIsSimpleTextFieldEnabled() {
//		return isSimpleTextFieldEnabled;
//	}
//
//	public void setIsSimpleTextFieldEnabled(EditText isSimpleTextFieldEnabled) {
//		this.isSimpleTextFieldEnabled = isSimpleTextFieldEnabled;
//	}
}