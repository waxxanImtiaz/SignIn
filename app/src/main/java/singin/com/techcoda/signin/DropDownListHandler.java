package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 7/22/2016.
 */
public class DropDownListHandler implements View.OnClickListener {
    private QuickAction fontColorSubMenuQuickAction;
    private List<ActionItem> fontColorMenu;
    private QuickAction fontSubMenuQuickAction;
    private List<ActionItem> fontMenu;
    private List<ActionItem> companySubMenu;
    private QuickAction photoCaptureSubMenuQuickAction;
    private List<ActionItem> photoCaptureSubMenu;
    private QuickAction companySubMenuQuickAction;
    private List<ActionItem> visitorAgreementSubMenu;
    private QuickAction visitorAgreementQuickAction;
    private Context mContext;
    private View view;
    private QuickAction currentQuickAction;
    private ActionItem action;
    public DropDownListHandler(Context mContext,ActionItem action)
    {
        this.mContext = mContext;
        this.action = action;

    }
    @Override
    public void onClick(View v)
    {
      //  this.setView(v);
        if(action.getLeftTitle() != null && action.getLeftTitle().equals("Print Settings")) {
            getCurrentQuickAction().setInnerDropDownHeading("font color");
            getCurrentQuickAction().setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            getCurrentQuickAction().setInnerDropDown();

       }else if(action.getLeftTitle() != null && action.getLeftTitle().equals("Font")) {
                 getCurrentQuickAction().setInnerDropDownHeading("font");
                 getCurrentQuickAction().setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
                 getCurrentQuickAction().setInnerDropDown();
        }
        else if(action.getLeftTitle() != null && action.getLeftTitle().equals("company"))
        {
            getCurrentQuickAction().setInnerDropDownHeading("company");
            getCurrentQuickAction().setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            getCurrentQuickAction().setInnerDropDown();
        }
        else if(action.getLeftTitle() != null && action.getLeftTitle().equals("Photo Capture"))
        {
            getCurrentQuickAction().setInnerDropDownHeading("photo capture");
            getCurrentQuickAction().setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            getCurrentQuickAction().setInnerDropDown();
        }
        else if(action.getLeftTitle() != null && action.getLeftTitle().equals("Visitor Agreement Text"))
        {
            getCurrentQuickAction().setInnerDropDownHeading("visitor agreement text");
            getCurrentQuickAction().setView(Fields.scrollers[1],Fields.scrollerLayouts[1]);
            getCurrentQuickAction().setInnerDropDown();
        }



    }//end of onClick method..


    public void setVisitorAgreementSubMenu() {
        visitorAgreementSubMenu = new ArrayList<ActionItem>();
        visitorAgreementSubMenu.add(new ActionItem(true,new EditText(mContext)));
    }// end of setVisitorAgreementSubMenu method
    public void setCompanySubMenu(){
        companySubMenu = new ArrayList<ActionItem>();
        companySubMenu.add(new ActionItem(false,new EditText(mContext)));
        companySubMenu.add(new ActionItem(new View(mContext),19,false));
        companySubMenu.add(new ActionItem(1,"Not Used","   ",new CheckBox(mContext),true));
        companySubMenu.add(new ActionItem(2,"Mandatory","   ",new CheckBox(mContext),true));
        companySubMenu.add(new ActionItem(3,"Optional","   ",new CheckBox(mContext),true));
        companySubMenu.add(new ActionItem(new View(mContext),10,true));
        companySubMenu.add(new ActionItem(new View(mContext),40,false));
    }//end of setCompanySubMenu method..
    public void setPhotoCaptureSubmenu(){
        photoCaptureSubMenu = new ArrayList<ActionItem>();
        photoCaptureSubMenu.add(new ActionItem(new View(mContext),7,false));
        photoCaptureSubMenu.add(new ActionItem(true,new EditText(mContext)));
        photoCaptureSubMenu.add(new ActionItem(new View(mContext),10,false));
        photoCaptureSubMenu.add(new ActionItem(1,"Mandatory","   ",new CheckBox(mContext),true));
        photoCaptureSubMenu.add(new ActionItem(2,"Optional","   ",new CheckBox(mContext),true));
        photoCaptureSubMenu.add(new ActionItem(new View(mContext),10,false));
        photoCaptureSubMenu.add(new ActionItem(3,"Automatic Photo Capture","   ",new CheckBox(mContext),true));
        photoCaptureSubMenu.add(new ActionItem(4, "PHOTO SIZE IN EMAIL",true,false));
        photoCaptureSubMenu.add(new ActionItem(new View(mContext),7,true));
        photoCaptureSubMenu.add(new ActionItem(5,"Small","   ",new CheckBox(mContext),true));
        photoCaptureSubMenu.add(new ActionItem(6,"Mediam","   ",new CheckBox(mContext),true));
        photoCaptureSubMenu.add(new ActionItem(7,"Large","   ",new CheckBox(mContext),true));

    }
    public void setFontSubMenu(){
        fontMenu = new ArrayList<ActionItem>();

        fontMenu.add(new ActionItem(1, "  ","   ", new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(2,"Bold","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(3,"Itallic","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(4,"Sans","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(5,"Verdana","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(6,"Verdana","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(7,"Verdana","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(8,"Verdana","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(9,"Verdana","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(10,"Verdana","   ",new CheckBox(mContext),true));
        fontMenu.add(new ActionItem(11,"Verdana","   ",new CheckBox(mContext),true));
    }

    public void setFontColorSubMenu(){
            fontColorMenu = new ArrayList<ActionItem>();
            fontColorMenu.add(new ActionItem(1,new View(mContext),"#000FFF","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(2,new View(mContext),"#856DDE","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(3,new View(mContext),"#7c7692","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(new View(mContext), 15,true));
            fontColorMenu.add(new ActionItem(4,new View(mContext),"#6e766a","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(5,new View(mContext),"#58ec0d","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(6,new View(mContext),"#000000","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(7,new View(mContext),"#900dec","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(8,new View(mContext),"#c0e4e7","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(9,new View(mContext),"#baab15","   ",new CheckBox(mContext),true));
            fontColorMenu.add(new ActionItem(10,new View(mContext),"#c0e4e7","   ",new CheckBox(mContext),true));
        }

    public void addItemsToVisitorAgreementSubMenu(){
        setVisitorAgreementQuickAction(getCurrentQuickAction());
        for(int index = 0; index< visitorAgreementSubMenu.size(); index++) {
            getCurrentQuickAction().addSubActionItem(visitorAgreementSubMenu.get(index));
        }
    }
    public void addItemsToPhotoCaptureSubMenu(){
        setPhotoCaptureSubMenuQuickAction(getCurrentQuickAction());
        for(int index = 0; index< photoCaptureSubMenu.size(); index++) {
            getCurrentQuickAction().addSubActionItem(photoCaptureSubMenu.get(index));
        }
    }
    public void addItemsToCompanySubMenu(){
        setCompanySubMenuQuickAction(getCurrentQuickAction());
        for(int index = 0; index< companySubMenu.size(); index++) {
            getCompanySubMenuQuickAction().addSubActionItem(companySubMenu.get(index));
        }
    }//end of addItemsToCompanySubMenu method..
        public void addItemToFontSubMenu(){
            setFontSubMenuQuickAction(getCurrentQuickAction());
            for(int index = 0; index< fontMenu.size(); index++) {
                getCurrentQuickAction().addSubActionItem(fontMenu.get(index));
            }
        }
        public void addItemsToFontColorMenu(){
            setFontColorSubMenuQuickAction(getCurrentQuickAction());
            for(int index = 0; index< fontColorMenu.size(); index++) {
                getCurrentQuickAction().addSubActionItem(fontColorMenu.get(index));
            }
        }//end of addItemsToFontSubMenu method..

        public QuickAction getFontColorSubMenuQuickAction() {
            return fontColorSubMenuQuickAction;
        }

        public void setFontColorSubMenuQuickAction(QuickAction fontSubMenuQuickAction) {
        this.fontColorSubMenuQuickAction = fontSubMenuQuickAction;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public QuickAction getCurrentQuickAction() {
        return currentQuickAction;
    }

    public void setCurrentQuickAction(QuickAction currentQuickAction) {
        this.currentQuickAction = currentQuickAction;
    }

    public QuickAction getFontSubMenuQuickAction() {
        return fontSubMenuQuickAction;
    }

    public void setFontSubMenuQuickAction(QuickAction fontSubMenuQuickAction) {
        this.fontSubMenuQuickAction = fontSubMenuQuickAction;
    }

    public QuickAction getCompanySubMenuQuickAction() {
        return companySubMenuQuickAction;
    }

    public void setCompanySubMenuQuickAction(QuickAction companySubMenuQuickAction) {
        this.companySubMenuQuickAction = companySubMenuQuickAction;
    }

    public QuickAction getPhotoCaptureSubMenuQuickAction() {
        return photoCaptureSubMenuQuickAction;
    }

    public void setPhotoCaptureSubMenuQuickAction(QuickAction photoCaptureSubMenuQuickAction) {
        this.photoCaptureSubMenuQuickAction = photoCaptureSubMenuQuickAction;
    }

    public List<ActionItem> getPhotoCaptureSubMenu() {
        return photoCaptureSubMenu;
    }


    public List<ActionItem> getVisitorAgreementSubMenu() {
        return visitorAgreementSubMenu;
    }

    public QuickAction getVisitorAgreementQuickAction() {
        return visitorAgreementQuickAction;
    }

    public void setVisitorAgreementQuickAction(QuickAction visitorAgreementQuickAction) {
        this.visitorAgreementQuickAction = visitorAgreementQuickAction;
    }
}//end of class
