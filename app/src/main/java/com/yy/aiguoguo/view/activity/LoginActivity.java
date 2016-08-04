package com.yy.aiguoguo.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.yy.aiguoguo.R;

import java.io.FileNotFoundException;

/**
 * Created by yyan on 2016/8/3 0003.
 */
public class LoginActivity extends BaseActivity{
    private EditText editName;
    private EditText editPassword;
    private ImageView imageTest;
    private static final int SELECT_PIC_KITKAT = 1001;
    private static final int SELECT_PIC = 1002;
    private static final int PHOTO_REQUEST_CUT = 1003;
    private Uri uritempFile;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editName = (EditText) findViewById(R.id.edit_name);
        editPassword = (EditText) findViewById(R.id.edit_password);
        imageTest = (ImageView) findViewById(R.id.image_test);
        imageTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    startActivityForResult(intent, SELECT_PIC_KITKAT);
                } else {
                    startActivityForResult(intent, SELECT_PIC);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (RESULT_OK == resultCode){

            switch (requestCode){
                case SELECT_PIC_KITKAT:
                    Uri selectedImage = data.getData();
                    startPhotoZoom(selectedImage,150);
                    break;
                case PHOTO_REQUEST_CUT:
                    //将Uri图片转换为Bitmap
                    Bitmap bitmap = null;
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uritempFile));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    imageTest.setImageBitmap(bitmap);
                    //TODO，将裁剪的bitmap显示在imageview控件上
                    break;
                default:
                    break;
            }
            super.onActivityResult(requestCode, resultCode, data);

        }
    }
    /**
     * 裁剪图片
     */
    private void startPhotoZoom(Uri uri, int size) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");

        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", size);
        intent.putExtra("outputY", size);
        intent.putExtra("return-data", true);
        //uritempFile为Uri类变量，实例化uritempFile

        uritempFile = Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().getPath() + "/" + "small.jpg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uritempFile);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());

        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    public void register(View view){

        startActivity(new Intent(getBaseContext(),RegisterActivity.class));

    }
    public void login(View view){
        String name = editName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            toast.showToast("用户名不能为空");
            return;
        }if (TextUtils.isEmpty(password)){
            toast.showToast("密码不能为空");
            return;
        }

    }
}
