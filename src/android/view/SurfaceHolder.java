package android.view;

public interface SurfaceHolder {
    interface Callback {
        boolean surfaceChanged(SurfaceHolder holder, Integer format, 
                Integer width, Integer height);
        boolean surfaceCreated(SurfaceHolder holder);
        boolean surfaceDestroyed(SurfaceHolder holder);
    }
    void addCallback(Callback callback);
    void removeCallback(Callback callback);
    void setType(Integer type);
    void setFormat(Integer format);

}
