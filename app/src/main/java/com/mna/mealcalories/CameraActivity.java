package com.mna.mealcalories;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.Random;

public class CameraActivity extends AppCompatActivity {

    private File file;
    private File sdcard;
    private static final int REQUEST_CODE = 22;
    Button btnpicture;
    ImageView imageView;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        try{

            sdcard = Environment.getExternalStorageDirectory();

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("File error");
        }

        btnpicture = findViewById(R.id.btncamera_id);
        imageView = findViewById(R.id.image);
        btnpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                try{

                    activityResultLauncher.launch(cameraIntent);
                }catch (Exception ex){
                    ex.printStackTrace();
                    System.out.println("activity camera launch eror");
                }
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

            @Override
            public void onActivityResult(ActivityResult result) {
                Bundle extras = result.getData().getExtras();

                Bitmap imageBitmap = (Bitmap) extras.get("data");
                WeakReference<Bitmap> result_1 = new WeakReference<>(Bitmap.createScaledBitmap(imageBitmap,
                                imageBitmap.getWidth(), imageBitmap.getHeight(), false).
                        copy(Bitmap.Config.RGB_565, true));
                Bitmap bm = result_1.get();


                file = new File(sdcard, generateRandomImageName());
                imageView.setImageBitmap(bm);

                try
                {
                    file.createNewFile();
                    FileOutputStream ostream = new FileOutputStream(file);
                    bm.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                    ostream.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    private String generateRandomImageName() {
        String imageFileName = "mealcalories_" + Math.floor(Math.random() * 813363 + 20) + ".jpg";

        return  imageFileName;
    }
}
