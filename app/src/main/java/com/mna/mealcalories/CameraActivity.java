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
import java.lang.ref.WeakReference;

public class CameraActivity extends AppCompatActivity {

    private File file;

    private static final int REQUEST_CODE = 22;
    Button btnpicture;
    ImageView imageView;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        File sdcard = Environment.getExternalStorageDirectory();
        String imageFileName = "capture.jpg";
        file = new File(sdcard, imageFileName);

        btnpicture = findViewById(R.id.btncamera_id);
        imageView = findViewById(R.id.image);
        btnpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                activityResultLauncher.launch(cameraIntent);
            }
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {

            @Override
            public void onActivityResult(ActivityResult result) {
                Bundle extras = result.getData().getExtras();
                Uri imageUri;
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                WeakReference<Bitmap> result_1 = new WeakReference<>(Bitmap.createScaledBitmap(imageBitmap,
                                imageBitmap.getWidth(), imageBitmap.getHeight(), false).
                        copy(Bitmap.Config.RGB_565, true));
                Bitmap bm = result_1.get();
//                imageUri = saveImage(bm, CameraActivity.this);
//                imageView.setImageURI(imageUri);
            }
        });
    }
}
