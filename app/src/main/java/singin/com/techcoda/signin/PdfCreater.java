package singin.com.techcoda.signin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import android.content.Context;
import android.os.Environment;
import android.graphics.Color;
import android.widget.Toast;

/**
 * Created by android on 8/4/2016.
 */
public class PdfCreater {

    private Context mContext;
    public String path;
    public PdfCreater(Context context){
        this.mContext = context;
    }
    public boolean createPDF(List<List<String>> visitors,String fileName,String status)
    {
        Document doc = new Document(PageSize.ARCH_D);
        try {
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/SignInAppReports";

            final File dir = new File(path);
            if(!dir.exists())
                dir.mkdirs();
            doc.setMargins(10,10,10,10);
            File file = new File(dir, fileName+".pdf");
            FileOutputStream fOut = new FileOutputStream(file);

            PdfWriter.getInstance(doc, fOut);

            //open the document
            doc.open();
            doc.addCreationDate();
            Paragraph p1 = null;
            if(status.equals("in"))
                p1= new Paragraph("Total Visitors Signed In");
            else
                if(status.equals("signout"))
                    p1= new Paragraph("Total Visitors Signed Out");
                else
                    p1= new Paragraph("Total Visitors OnPremesis");
            Font paraFont= new Font(new Font(300));
            //paraFont.setSize(200);
            paraFont.setColor(new harmony.java.awt.Color(Color.CYAN));
            p1.setAlignment(Paragraph.ALIGN_CENTER);
            p1.setFont(paraFont);
            p1.setFont(paraFont);
            doc.add(p1);

            //SPACE ONE
            p1 = new Paragraph("\t\t\t");
            doc.add(p1);
            //SPACE TWO
            p1 = new Paragraph("\t\t\t");
            //SPACE THREE
            doc.add(p1);
            p1 = new Paragraph("\t\t\t");
            doc.add(p1);

//            PdfPTable table = new PdfPTable((visitors.si));
            PdfPTable table = new PdfPTable((6));

            table.addCell("ID");
            table.addCell("First Name");
            table.addCell("Last Name");
            table.addCell("City");//city
            table.addCell("Company");//company
            table.addCell("Comments");//comments
//            table.addCell("Address");//Address
//            table.addCell("Here To See");//here to see
//            table.addCell("Email "); //Email
//            table.addCell("Photo Capture");//photo capture
//            table.addCell("State "); //State
//            table.addCell("guide name ");//guide name
//            table.addCell("Badge Number ");//Badge number
//            table.addCell("Badge Returned ");//badge returned
//            table.addCell("Vehicle License Plate ");//vehicle lisence plate
//            table.addCell("Vehicle Color"); //Vehicle color
//            table.addCell("Vehicle Make/Model ");
//            table.addCell("Phone ");//phone
           // table.addCell("Vehicle Lisense Plate ");
//            table.addCell("Visitor Agreement Text ");//visitor agreement text
//            table.addCell("Sign In Agreement ");
//            table.addCell("Sign Out Agreement ");
//            table.addCell("Agreement Text ");
//            table.completeRow();
//            table.setFooterRows(50);

            try {

                List<String> id = visitors.get(0);
                List<String> first = visitors.get(1);
                List<String> last = visitors.get(2);
                List<String> company = visitors.get(3);
                List<String> email = visitors.get(4);
//                List<String> state = visitors.get(5);
//                List<String> city = visitors.get(6);
//                List<String> guideName =visitors.get(7);
//                List<String> address = visitors.get(8);
//                List<String> hereToSee = visitors.get(9);
//                List<String> zipCode = visitors.get(10);
//                List<String> phone =visitors.get(11);
//                List<String> signatureCapture =visitors.get(12);
//                List<String> badgeReturned = visitors.get(13);
//                List<String> badgeNumber = visitors.get(14);
//                List<String> vehicleMakeModel = visitors.get(15);
//                List<String> vehicleColor = visitors.get(16);
//                List<String> vehicleLisencePlate =visitors.get(17);
                List<String> comments = visitors.get(18);
//                List<String> visitorSignInAgreement =visitors.get(19);
//                List<String> visitorSignOutAgreement = visitors.get(20);
//                List<String> visitorAgreementText = visitors.get(21);

                int index = 0;

                while (index < id.size()) {
                    table.addCell(id.get(index));
                    table.addCell(first.get(index));
                    table.addCell(last.get(index));
                    table.addCell(company.get(index));
                    table.addCell(email.get(index));
//                    table.addCell(state.get(index));
//                    table.addCell(city.get(index));
//                    table.addCell(guideName.get(index));
//                    table.addCell(address.get(index));
//                    table.addCell(hereToSee.get(index));
//                    table.addCell(zipCode.get(index));
//                    table.addCell(phone.get(index));
//                    table.addCell(signatureCapture.get(index));
//                    table.addCell(badgeReturned.get(index));
//                    table.addCell(badgeNumber.get(index));
//                    table.addCell(vehicleMakeModel.get(index));
//                    table.addCell(vehicleColor.get(index));
                   // table.addCell(vehicleLisencePlate.get(index));
                    table.addCell(comments.get(index));
//                    table.addCell(visitorSignInAgreement.get(index));
//                    table.addCell(visitorSignOutAgreement.get(index));
                   // table.addCell(visitorAgreementText.get(index));
                    index++;
                }//end of while loop

//            set footer
                Phrase footerText = new Phrase("Total visitors " + status + " document");
                HeaderFooter pdfFooter = new HeaderFooter(footerText, false);
                doc.setFooter(pdfFooter);
                doc.add(table);
                doc.addCreationDate();
                return true;
            }catch (NullPointerException e)
            {
                Toast.makeText(mContext.getApplicationContext(),"No any visitor is "+status,Toast.LENGTH_LONG).show();
            }
        } catch (DocumentException de) {
            Toast.makeText(mContext.getApplicationContext(),"DocumentException:"+de,Toast.LENGTH_LONG).show();
        } catch (IOException e) {

            Toast.makeText(mContext.getApplicationContext(),"IOException:"+e,Toast.LENGTH_LONG).show();
        }
        finally
        {
            doc.close();
        }
        return false;
    }//end of method
}//end of class
