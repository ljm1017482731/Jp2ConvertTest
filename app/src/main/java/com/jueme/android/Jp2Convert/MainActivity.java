package com.jueme.android.Jp2Convert;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import at.mroland.android.apps.imagedecoder.BitmapImageFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView iv = findViewById(R.id.iv);
        new Thread(){
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        InputStream is = getResources().openRawResource(R.raw.jp2test);
                        ArrayList<byte[]> chunks = new ArrayList<byte[]>();
                        if (is != null) {
                            int readBytes;
                            do {
                                byte[] chunk = new byte[1024];
                                try {
                                    readBytes = is.read(chunk);
                                } catch (Exception e) {
                                    readBytes = -1;
                                }
                                if (readBytes > 0) {
                                    chunks.add(Arrays.copyOf(chunk, readBytes));
                                }
                            } while (readBytes >= 0);
                        }

                        byte[] fileData = ArrayUtils.toByteArray(chunks);
                        BitmapImageFactory fac = BitmapImageFactory.get(fileData);
//				          ImageDecoder decode = new ImageDecoder(MainActivity.this);
//				          BitmapImage bi = decode.decodeImage(fileData);
                        Bitmap map = null;
                        if(fac != null){
                            map = fac.getImage();
                            Log.d(TAG, "Width: "+map.getWidth()+",Height:"+map.getHeight());
                        }

                        if(map != null){
                            iv.setImageBitmap(map);
                        }
                    }
                });
            };
        }.start();
    }

}
