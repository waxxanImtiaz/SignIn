package singin.com.techcoda.signin;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
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
        Document doc = new Document();
        try {
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/SignInAppReports";

            final File dir = new File(path);
            if(!dir.exists())
                dir.mkdirs();
            File file = new File(dir, fileName+".pdf");
            FileOutputStream fOut = new FileOutputStream(file);

            PdfWriter.getInstance(doc, fOut);

            //open the document
            doc.open();
            doc.addCreationDate();
            Paragraph p1 = new Paragraph("Total visitors "+status);
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

            PdfPTable table = new PdfPTable((visitors.size()));

            table.addCell("ID");
            table.addCell("First Name");
            table.addCell("Last Name");
            table.completeRow();
            table.setFooterRows(50);

            try {
                List<String> id = visitors.get(0);
                List<String> first = visitors.get(1);
                List<String> last = visitors.get(2);

                int index = 0;

                while (index < id.size()) {
                    table.addCell(id.get(index));
                    table.addCell(first.get(index));
                    table.addCell(last.get(index));
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
