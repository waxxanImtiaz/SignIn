package singin.com.techcoda.signin;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by android on 8/5/2016.
 */
public class ReportDropDownHandler implements View.OnClickListener {

    private Context mContext;
    private String status;
    private List<List<String>> name;
    private PdfCreater pdfCreater;
    private boolean isPdfCreated;
    private String path;
    public ReportDropDownHandler(Context mContext,String status,
                                 List<List<String>> name)
    {
        this.mContext = mContext;
        this.status = status;
        this.name = name;
        setPdfCreater(new PdfCreater(mContext));
    }
    @Override
    public void onClick(View v){
        int id = v.getId();

        switch (id)
        {
            case R.id.btn_delete_records:
                //
                break;
            case R.id.btn_print_reports:
               setPdfCreated( getPdfCreater().createPDF(name,status,status));
               setPath(pdfCreater.path);
                break;


        }
    }

    public PdfCreater getPdfCreater() {
        return pdfCreater;
    }

    public void setPdfCreater(PdfCreater pdfCreater) {
        this.pdfCreater = pdfCreater;
    }

    public boolean isPdfCreated() {
        return isPdfCreated;
    }

    public void setPdfCreated(boolean pdfCreated) {
        isPdfCreated = pdfCreated;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

