package android.com.VideoMusic;

import java.io.IOException;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlayerActivity extends Activity implements SurfaceHolder.Callback {
	Camera camera;
	SurfaceView surfaceView;
	SurfaceHolder surfaceHolder;
	boolean isRunning;
	int volume = 0;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        surfaceView = (SurfaceView)findViewById(R.id.surface_view);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        //for 'compatibility'
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		//don't make any changes right now...
	}

	public void surfaceCreated(SurfaceHolder arg0) {
		camera = Camera.open();
        if (camera != null){
        	try {
        		camera.setPreviewDisplay(surfaceHolder);
        		camera.startPreview();
        	} catch (IOException e){
        		e.printStackTrace();
        	}
        }	
	}

	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
}
