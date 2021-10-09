package android.hardware;

import android.view.SurfaceHolder;
/**
 *
 * @author Pablo
 */
public class Camera {
    int cId = 0;
    public Camera(int cameraId) {
        cId = cameraId;
        System.out.println(getClass().getName() +  ": Camera " + cameraId + " creada");
    }

    public static class Parameters {}
    
    public interface ShutterCallback  { }
    public interface PictureCallback  { }
    Parameters params;
    
    public static Camera open(Integer cameraId) {
        return new Camera(cameraId);
    }
    
    public Parameters getParameters() {
        return new Parameters();
    }
    
    public void setParameters(Parameters par) {
        this.params = par;
    }
    public final void setDisplayOrientation(Integer degrees) {
        System.out.println(getClass().getName() +  ": Ajustando orientacion del Display a " + degrees + " grados");
    }
    
    public final void setPreviewDisplay(SurfaceHolder holder) {}
    
    public final void startPreview() throws InterruptedException {
        System.out.println(getClass().getName() +  ": Iniciando Preview");
        Thread.sleep(1000);
    }
    
    public final void stopPreview() {
        System.out.println(getClass().getName() +  ": Deteniendo Preview");
    }
    
    public final void release() {
        System.out.println(getClass().getName() +  ": release()");
    }
    
    public final void takePicture(ShutterCallback shutter, PictureCallback raw, PictureCallback postview, PictureCallback jpeg) {
        System.out.println(getClass().getName() +  ": Tomando foto");
        try {
            startPreview();
            stopPreview();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getcId() {
        return cId;
    }
}
