package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by android on 7/20/2016.
 */
public class DropDownMenus {

    private List<ActionItem> setup;
    private List<ActionItem> report;
    private List<ActionItem> design;
    private String currentDate;
    private Context mContext;
    private static QuickAction setupQuickAction;
    private static QuickAction reportQuickAction;
    private static QuickAction designQuickAction;
    private static DropDownMenuHandler setupMenu;
    private static DropDownDesignMenuHandler designMenu;
    private static DropDownReportMenuHandler reportMenu;


    public DropDownMenus(Context mContext)
    {
        this.mContext = mContext;
        setupMenu = new DropDownMenuHandler(mContext,DropDownMenuHandler.VERTICAL,R.id.setup);
        setupMenu.setView(Fields.scrollers[0],Fields.scrollerLayouts[0]);
        setupMenu.setMenuHeadings();
        setupMenu.addActionItem(R.layout.setup_menu_layout_vertical);

        designMenu = new DropDownDesignMenuHandler(mContext,DropDownDesignMenuHandler.VERTICAL,R.id.tv_design_head);
        designMenu.setView(Fields.scrollers[0],Fields.scrollerLayouts[0]);
        designMenu.setMenuHeadings();
        designMenu.addActionItem(R.layout.design_menu_layout_vertical);

        reportMenu = new DropDownReportMenuHandler(mContext,R.id.tv_report_head);
        reportMenu.setView(Fields.scrollers[0],Fields.scrollerLayouts[0]);
        reportMenu.setMenuHeadings();
        reportMenu.addActionItem(R.layout.report_popup_layout_vertical);

    }
    public void setup_button_clicked(View view) {
        //setupQuickAction.setSubMenuView(view);
        setupMenu.show(view);

    }

    public void report_button_clicked(View view)
    {
        reportMenu.show(view);
    }
    public void design_button_clicked(View view)
    {
        designMenu.show(view);
    }

    public void addItemsToSetupMenu(){
        setupQuickAction = new QuickAction(mContext, QuickAction.VERTICAL);
        setupQuickAction.setView(Fields.scrollers[0],Fields.scrollerLayouts[0]);
        setupQuickAction.setHeading("setup");
        for(int index = 0; index< getSetupMenu().size(); index++) {
            setupQuickAction.addActionItem(setup.get(index));
        }
        setupQuickAction.setSetupQuickAction(this);

    }//end of addItemsToSetupMenu method
    public void addItemsToReportMenu(){
        reportQuickAction = new QuickAction(mContext, QuickAction.VERTICAL);
        reportQuickAction.setView(Fields.scrollers[0],Fields.scrollerLayouts[0]);
        reportQuickAction.setHeading("report");
        for(int index = 0; index< getReport().size(); index++) {
            reportQuickAction.addActionItem(getReport().get(index));
        }
        reportQuickAction.setSetupQuickAction(this);
    }//end of addItemsToDesignMenu method..
    public void addItemsToDesignMenu(){
        designQuickAction = new QuickAction(mContext, QuickAction.VERTICAL);
        designQuickAction.setView(Fields.scrollers[0],Fields.scrollerLayouts[0]);
        designQuickAction.setHeading("design");
        for(int index = 0; index< getDesign().size(); index++) {
            designQuickAction.addActionItem(getDesign().get(index));
        }
        designQuickAction.setDesignQuickAction(this);
    }//end of addItemsToDesignMenu method..
    public String getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate() {
        String date =new SimpleDateFormat("dd/mm/yyyy").format(new Date());
        this.currentDate = date;
    }//end of setCurrentDate method..

    public List<ActionItem> getReport() {
        return report;
    }

    public void setReport(List<ActionItem> report) {
        this.report = report;
    }

    public List<ActionItem> getDesign() {
        return design;
    }

    public void setDesign(List<ActionItem> design) {
        this.design = design;
    }

    private class ItemClickedHandler implements  QuickAction.OnActionItemClickListener{
        //        new QuickAction.OnActionItemClickListener() {
        @Override
        public void onItemClick(QuickAction source, int pos, int actionId) {
            ActionItem actionItem = setupQuickAction.getActionItem(pos);
            Toast.makeText(mContext, actionItem.getLeftTitle() + " selected", Toast.LENGTH_SHORT).show();
        }
    }//end of class ItemClickedHandler

    private class OnDismissHandler implements  QuickAction.OnDismissListener{
        @Override
        public void onDismiss() {
            Toast.makeText(mContext, "Dismissed", Toast.LENGTH_SHORT).show();
        }
    }//end of OnDismissHandler class
    public List<ActionItem> getSetupMenu() {
        return setup;
    }

    //setting menu items of design drop down list
    public void setReportMenu(){
        report=new ArrayList<ActionItem>();
        report.add(new ActionItem(new View(mContext),13,false));
        report.add(new ActionItem(1,"Field","Name\t    ",mContext.getResources().getDrawable(R.drawable.chevron_right),true));
        report.add(new ActionItem(2,"From",getCurrentDate(),mContext.getResources().getDrawable(R.drawable.chevron_right),true));
        report.add(new ActionItem(3,"To",getCurrentDate(),mContext.getResources().getDrawable(R.drawable.chevron_right),true));
        report.add(new ActionItem(4,"Sort Report By","Date\t\t    ",mContext.getResources().getDrawable(R.drawable.chevron_right),true));
        report.add(new ActionItem(new EditText(mContext),true));
        report.add(new ActionItem(5," ","    ",true));
        report.add(new ActionItem(6," "," ",true));
        report.add(new ActionItem(7," "," ",true));
        report.add(new ActionItem(8," "," ",true));
        report.add(new ActionItem(9," "," ",true));

        addItemsToReportMenu();
    }//end of setDesignMenu button

    //setting menu items of design drop down list
    public void setDesignMenu(){
        setDesign(new ArrayList<ActionItem>());
      //  setup.add(new ActionItem(39, "VISITOR AGREEMENT", "disable"));
        getDesign().add(new ActionItem(new View(mContext),13,false));
        getDesign().add(new ActionItem(1,"UPGRADE TO PRO TO SIGN IN",true,false));
        getDesign().add(new ActionItem(2,"UNLIMITED USERS PER DAY",true,false));
        getDesign().add(new ActionItem(new View(mContext),14,false));
        getDesign().add(new ActionItem(3,"UPGRADE TO PRO","\t\t\t",mContext.getResources().getDrawable(R.drawable.chevron_right),false));
        getDesign().add(new ActionItem(new View(mContext),16,false));

        getDesign().add(new ActionItem(4,"SIGN IN SUPPORT",true,false));
        getDesign().add(new ActionItem(5,"Email Support","\t\t\t",mContext.getResources().getDrawable(R.drawable.chevron_right),false));
        getDesign().add(new ActionItem(new View(mContext),16,false));

        getDesign().add(new ActionItem(6,"SLIDES SHOW",true,false));
        getDesign().add(new ActionItem(7,"Use Landscape Photo Series"," ",false));
        getDesign().add(new ActionItem(8,"Use Flora Photo Series"," ",false));
        getDesign().add(new ActionItem(9,"Add Photos","\t\t\t",mContext.getResources().getDrawable(R.drawable.chevron_right),false));
        getDesign().add(new ActionItem(10,"Remove Photos","\t\t\t",mContext.getResources().getDrawable(R.drawable.chevron_right),false));
        getDesign().add(new ActionItem(new View(mContext),16,false));

        getDesign().add(new ActionItem(11,"BADGE",true,false));
        getDesign().add(new ActionItem(12,"Select Badge Logo"," ",false));
        getDesign().add(new ActionItem(13,"Select Badge Logo","\t  HELOO",false));
        getDesign().add(new ActionItem(14,"Print After Sign in"," ",false));
        getDesign().add(new ActionItem(15,"Email After Sign in"," ",false));
        getDesign().add(new ActionItem(16,"Admin Email"," ",false));
        getDesign().add(new ActionItem(17,"Print Settings","\t\t\t",mContext.getResources().getDrawable(R.drawable.chevron_right),false));
        getDesign().add(new ActionItem(new View(mContext),16,false));
        getDesign().add(new ActionItem(18,"WELCOME TEXT",true,false));
        getDesign().add(new ActionItem(19,"Title","\tWelcome",false));
        getDesign().add(new ActionItem(20,"Subtitle","All-Visitors please Sign in",false));
        getDesign().add(new ActionItem(21,"Font","\t\t\t",mContext.getResources().getDrawable(R.drawable.chevron_right),false));
        getDesign().add(new ActionItem(22,"Font Color","\t\t\t",mContext.getResources().getDrawable(R.drawable.chevron_right),false));

        getDesign().add(new ActionItem(new View(mContext),16,false));
        getDesign().add(new ActionItem(23,"ADMINISTRATOR PASSWORD",true,false));
        getDesign().add(new ActionItem(24,"Password Requird"," ",false));
        getDesign().add(new ActionItem(25,"Password"," ",false));

        getDesign().add(new ActionItem(new View(mContext),16,false));
        getDesign().add(new ActionItem(26,"LDAP/ACTIVE DIRECTORY",true,false));
        getDesign().add(new ActionItem(27,"Account Setting"," ",false));

        getDesign().add(new ActionItem(new View(mContext),16,false));
        getDesign().add(new ActionItem(new View(mContext),16,false));
        addItemsToDesignMenu();
    }
    //setting menu items of setup drop down list
    public void setSetupMenu() {
            setup = new ArrayList<ActionItem>();
            setup.add(new ActionItem(1, "", "",true));
            setup.add(new ActionItem(2, "First Name", "Mendatory",true));
            setup.add(new ActionItem(3, "Last Name", "Mendatory",true));
            setup.add(new ActionItem(4, "company", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(6, "Address", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(7, "City", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(8, "State", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(9, "Zip", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(11, "Phone", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(12, "Email", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(14, "Here to See", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));

            setup.add(new ActionItem(16, "Signature Capture", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(17, "Photo Capture", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(19, "Guid/Escort Name", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(21, "Badge Number", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(22, "Badge Returned", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(24, "Vehicle Make/Model", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(25, "Vehicle Color", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(26, "Vehicle license Plate", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(28, "Comments", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(30, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(31, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(32, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(33, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(34, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(35, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(36, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(37, "Custom Field", "Not used", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

            setup.add(new ActionItem(39, "VISITOR AGREEMENT",true,false));
            setup.add(new ActionItem(40, "Show Agreement Upon Sign In   ", new CheckBox(mContext),true));
            setup.add(new ActionItem(41, "Show Agreement Upon Sign Out", new CheckBox(mContext),true));
            setup.add(new ActionItem(42, "Visitor Agreement Text", "\t\t\t", mContext.getResources().getDrawable(R.drawable.chevron_right),true));
            setup.add(new ActionItem(new View(mContext), 15,true));

             addItemsToSetupMenu();
    }//end setSetupMenu method
}
