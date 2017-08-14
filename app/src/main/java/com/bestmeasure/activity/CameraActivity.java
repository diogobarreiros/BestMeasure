package com.bestmeasure.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Classe responsável por carregar a camera.
 * @author diogo.barreiros
 *
 */
public class CameraActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    static String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ImageButton btnNovaFoto = (ImageButton)findViewById(R.id.imgBtCamera);
        btnNovaFoto.setOnClickListener(new ImageButton.OnClickListener(){

            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(getApplicationContext(), "Erro ao tirar a foto", Toast.LENGTH_SHORT).show();
            }

            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    private File createImageFile() throws IOException {
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile("PHOTOAPP", ".jpg", storageDir);
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            /*Intent intent = new Intent(CameraActivity.this, PictureActivity.class);
            intent.putExtra("foto", mCurrentPhotoPath);
            startActivity(intent);
            finish();*/
        }
    }
}
