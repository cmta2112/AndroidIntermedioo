package pe.edu.cibertec.gestures;

import android.content.Context;
import android.graphics.Matrix;
import android.support.v4.view.GestureDetectorCompat;

import android.support.v4.view.ScaleGestureDetectorCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class ScaleImageView extends AppCompatImageView {

    private GestureDetectorCompat scrollGestureDetector;
    private ScaleGestureDetector scaleGestureDetector;

    private  float scaleFactor = 1f;

    public ScaleImageView(Context context) {
        super(context);

        init();

    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       init();
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
        this.scrollGestureDetector= new GestureDetectorCompat(getContext(), new ScrollListener());
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(),new ScaleListener());


    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scrollGestureDetector.onTouchEvent(event);
        scaleGestureDetector.onTouchEvent(event);
        return true;

    }
    float scrollX = getScrollX();
    float scrollY = getScrollY();

// cambios al metodo por default
    private class ScrollListener extends GestureDetector.SimpleOnGestureListener {

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            scrollX +=distanceX;
            scrollY +=distanceY;

            scrollX= Math.max(0.5f, Math.min(scrollX, getDrawable().getIntrinsicWidth()));
            scrollY= Math.max(0.5f, Math.min(scrollX, getDrawable().getIntrinsicHeight()));

            scrollTo((int)scrollX,(int) scrollY);
            return  true;


        }


    }



    private class ScaleListener extends  ScaleGestureDetector.SimpleOnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            //OBTENER EL FACTOR ESCALA
            scaleFactor *= detector.getScaleFactor();

            //NO PERMITIR QUE EL OBJETO SE VUELVA MUY PEQUEÑO O MUY GRANDE
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));

            //OBTENER LA MATRIZ INICIAL DE LA IMAGEN
            android.graphics.Matrix matrix = new Matrix(getImageMatrix());

            //CALCULAR LA NUEVA MATRIX EN BASE FACTOR DE ESCALA
            matrix.setScale(scaleFactor,scaleFactor,detector.getFocusX(), detector.getFocusY());

            //ESTABLECER LA NUEVA MATRIX
            setImageMatrix(matrix);

            return true;

            //return super.onScale(detector);
        }
    }



}
