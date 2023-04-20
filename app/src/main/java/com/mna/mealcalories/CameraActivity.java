
package com.mna.mealcalories;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.FileProvider;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Environment;
        import android.provider.MediaStore;
        import android.view.View;
        import android.widget.ImageView;

        import java.io.File;

public class CameraActivity extends AppCompatActivity {

    private ImageView imageView;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);


        // camera
        File sdcard = Environment.getExternalStorageDirectory();
        String imageFileName = "capture.jpg";
        file = new File(sdcard, imageFileName);

        imageView = findViewById(R.id.imageView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capture();
            }
        });
    }

    private void capture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Uri uri = Uri.fromFile(file);
        Uri uri = FileProvider.getUriForFile(getBaseContext(), "com.onedelay.chap7.fileprovider", file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        // resolveActivity 메서드를 이용해 카메라 앱이 있는지 확인 가능 (하지만 이 메서드는 없었다고 한다)
        startActivityForResult(intent, 101);
    }
}