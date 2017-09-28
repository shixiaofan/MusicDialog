package com.example.administrator.customdialog;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity{
    private CircleImage  TestBtn;
    private  MediaPlayer mp;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestBtn=(CircleImage) findViewById(R.id.testBtn);
        iv=(ImageView)findViewById(R.id.iv);
        TestBtn.setOnClickListener(new musicDialog());
        iv.setOnClickListener(new musicStop());
    }


    private void showMenuDialog() {
        //dialog 不能用Application的Context
        AlertDialog menuDialog = new AlertDialog.Builder(MainActivity.this, R.style.MenuDialog).create();
        menuDialog.show();
        Window window = menuDialog.getWindow();
        window.setContentView(R.layout.custom_dialog);
        window.setGravity(Gravity.BOTTOM); //设置对话框在界面底部显示
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = getWindowManager().getDefaultDisplay().getWidth();
        window.setAttributes(params);//此句代码一定要放在show()后面，否则不起作用
        menuDialog.setCanceledOnTouchOutside(true);
        final RelativeLayout rl_one = (RelativeLayout) window.findViewById(R.id.rl_one);
        RelativeLayout rl_exit = (RelativeLayout) window.findViewById(R.id.rl_four);
        RelativeLayout rl_two = (RelativeLayout) window.findViewById(R.id.rl_two);
        RelativeLayout rl_setting = (RelativeLayout) window.findViewById(R.id.rl_three);
        rl_one.setOnClickListener(new musicOne() );
        rl_two.setOnClickListener(new musicTwo() );
}





class musicStop implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        mp.stop();
    }
}
class musicDialog implements View.OnClickListener{
    @Override
    public void onClick(View view) {
        showMenuDialog();
    }
}
class musicOne implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        mp=MediaPlayer.create(MainActivity.this,R.raw.one);
        mp.start();

    }
}
    class musicTwo implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            mp=MediaPlayer.create(MainActivity.this,R.raw.two);
            mp.start();
        }
    }
}