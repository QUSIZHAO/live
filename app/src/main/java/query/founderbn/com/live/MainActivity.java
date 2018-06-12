package query.founderbn.com.live;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import android.view.KeyEvent;
import android.widget.QuickContactBadge;


public class MainActivity extends AppCompatActivity {

    QuickContactBadge mBadge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 直接拨号
         * */
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:16619985342"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);

       /* QuickContactBadge quickContactBadge = findViewById(R.id.ren);
        quickContactBadge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                */
        /**
         * 跳转拨号界面
         * */
                /*
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:16619985342"));
                startActivity(intent);
            }
        });*/

        mBadge = findViewById(R.id.ren);
        // 指定联系人的电话号码
        // 先搜索该号码，如果没有则提醒是否添加到联系人
        // 第二个参数为延迟匹配，若为true，则直到被点击时才会查找该地址
        mBadge.assignContactFromPhone("16619985342", false);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                AlertDialog.Builder build = new AlertDialog.Builder(this);
                build.setTitle("注意")
                        .setMessage("确定要退出吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                finish();

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub

                            }
                        })
                        .show();
                break;
        }
        return false;
    }
}
