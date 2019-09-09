package com.cml.ijkplayerview_library;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.cml.ijkplayerview.media.IRenderView;
import com.cml.ijkplayerview.media.IjkPlayerView;


public class MainActivity extends AppCompatActivity {

    String path = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
//    String path = "http://114.118.13.13:8080/materials/ALL/eac83f2b9058b78c296cac57c3fa4d9c.mp4";
    private IjkPlayerView ijkPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ijkPlayerView = findViewById(R.id.ijkPlayerView);
        ijkPlayerView
                .init()
//                .setVideoAspectRatio(IRenderView.AR_ASPECT_FILL_PARENT)
                .setVideoPath(path)
//                .setVideoPath(Environment.getExternalStorageDirectory().getAbsolutePath()+"/ad.ts")
                .start();




//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Log.e("Cml",MainActivity.this.getWindow().getDecorView().findFocus().toString());
//                }
//            }
//        }).start();

    }

    public void noVoice(View view) {
        ijkPlayerView.setNoVoice();
    }

    public void haveVoice(View view) {
        ijkPlayerView.resumeVoice();
    }

    public void fullScreen(View view) {

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ijkPlayerView.getLayoutParams();
        lp.width = RelativeLayout.LayoutParams.MATCH_PARENT;
        lp.height = RelativeLayout.LayoutParams.MATCH_PARENT;
        ijkPlayerView.setLayoutParams(lp);

        ijkPlayerView.setVideoAspectRatio(IRenderView.AR_ASPECT_FILL_PARENT);
    }

    public void normalScreen(View view) {

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ijkPlayerView.getLayoutParams();
        lp.width = 300;
        lp.height = 300;
        ijkPlayerView.setLayoutParams(lp);

        ijkPlayerView.setVideoAspectRatio(IRenderView.AR_ASPECT_FIT_PARENT);
    }
}
