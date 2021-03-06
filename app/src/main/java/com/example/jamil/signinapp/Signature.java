package com.example.jamil.signinapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import singin.com.techcoda.signin.R;
import com.example.jamil.signinapp.views.SignaturePad;
import java.io.*;

public class Signature extends Activity implements View.OnClickListener{

    private SignaturePad mSignaturePad;
    private Button mClearButton;
    private Button mSaveButton;
    private final int SIGNATURE = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);

        mSignaturePad = (SignaturePad) findViewById(R.id.signature_pad);
        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
                Toast.makeText(Signature.this, "OnStartSigning", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSigned() {
                mSaveButton.setEnabled(true);
                mClearButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                mSaveButton.setEnabled(false);
                mClearButton.setEnabled(false);
            }
        });

        mClearButton = (Button) findViewById(R.id.clear_button);
        mSaveButton = (Button) findViewById(R.id.save_button);

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSignaturePad.clear();
            }
        });


        mSaveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        Bitmap signatureBitmap = mSignaturePad.getSignatureBitmap();
        Intent i = new Intent();
        i.putExtra("signature",getBytes(signatureBitmap));
        setResult(SIGNATURE,i);
        finish();
//        if(addJpgSignatureToGallery(signatureBitmap)) {
//              Toast.makeText(Signature.this, "Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
//
//
//        } else {
//            Toast.makeText(Signature.this, "Unable to store the signature", Toast.LENGTH_SHORT).show();
//        }
//        if(addSvgSignatureToGallery(mSignaturePad.getSignatureSvg())) {
//            //Toast.makeText(Signature.this, "SVG Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(Signature.this, "Unable to store the SVG signature", Toast.LENGTH_SHORT).show();
//        }
    }
    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("SignaturePad", "Directory not created");
        }
        return file;
    }

    public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        OutputStream stream = new FileOutputStream(photo);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        stream.close();
    }

    public boolean addJpgSignatureToGallery(Bitmap signature) {
        boolean result = false;
        try {
            File photo = new File(getAlbumStorageDir("Signatures"), String.format("Signature_one.jpg", System.currentTimeMillis()));
            saveBitmapToJPG(signature, photo);

            scanMediaFile(photo);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public byte[] getBytes(Bitmap bitmap)
    {
//        BitmapDrawable drawable = (BitmapDrawable) iv_picture.getDrawable();
//        Bitmap bitmap = drawable.getBitmap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] img = bos.toByteArray();
        return  img;
    }//end of getBytes method..
    private void scanMediaFile(File photo) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(photo);
        mediaScanIntent.setData(contentUri);
        Signature.this.sendBroadcast(mediaScanIntent);
    }

    public boolean addSvgSignatureToGallery(String signatureSvg) {
        boolean result = false;
        try {
            File svgFile = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_one.svg", System.currentTimeMillis()));
            OutputStream stream = new FileOutputStream(svgFile);
            OutputStreamWriter writer  = new OutputStreamWriter(stream);
            writer.write(signatureSvg);
            writer.close();
            stream.flush();
            stream.close();
            scanMediaFile(svgFile);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

