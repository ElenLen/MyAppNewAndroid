package com.example.myappnew.CV;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.myappnew.R;


public class EmotionalFaceView extends View {

    protected float customRadius;
    protected int roundRadius;
    protected float minRadius = getResources().getDimension(R.dimen.slider_round_min_radius);

    protected float maxValue;
    protected float minValue;
    protected float currentValue;

    protected Point customCenter = new Point();
    protected Point center = new Point();
    protected RectF frameOval = new RectF();
    protected Paint paint;

    private int size = 0;

    private int faceColor = Color.YELLOW;
    private int eyesColor = Color.BLACK;
    private int mouthColor = Color.BLACK;
    private int borderColor = Color.BLACK;
    private float borderWidth = 4;

    /*const*/
    public static final long HAPPY =  0;
    public static final long SAD = 1;

    long happinessState = HAPPY;
 /*   public void setHappinessState(long happinessState) {
        this.happinessState = happinessState;
        invalidate();
    }*/

    public EmotionalFaceView(Context context) {
        super(context);
        init();
    }

    public EmotionalFaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
        init();
    }

    public EmotionalFaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initAttrs(attrs);
        init();
    }

    public EmotionalFaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initAttrs(attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.isAntiAlias();
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.EmotionalFaceView);

        // Extract custom attributes into member variables
        happinessState = typedArray.getInt(R.styleable.EmotionalFaceView_state, (int) HAPPY);
        faceColor = typedArray.getColor(R.styleable.EmotionalFaceView_faceColor, Color.YELLOW);
        eyesColor = typedArray.getColor(R.styleable.EmotionalFaceView_eyesColor, Color.BLACK);
        mouthColor = typedArray.getColor(R.styleable.EmotionalFaceView_mouthColor, Color.BLACK);
        borderColor = typedArray.getColor(R.styleable.EmotionalFaceView_borderColor,
                Color.BLACK);
        borderWidth = (int) typedArray.getDimension(R.styleable.EmotionalFaceView_borderWidth,
                4);

        // TypedArray objects are shared and must be recycled.
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(size, size);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*smile*/
        drawFaceBackground(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
    }

    private void drawFaceBackground(Canvas canvas) {
        paint.setColor(faceColor);
        paint.setStyle(Paint.Style.FILL);

        float radius = size / 2f;

        canvas.drawCircle(size / 2f, size / 2f, radius, paint);

        paint.setColor(borderColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(borderWidth);

        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2, paint);
    }

    private void drawEyes(Canvas canvas) {
        paint.setColor(eyesColor);
        paint.setStyle(Paint.Style.FILL);

        RectF leftEyeRect = new RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f);
        canvas.drawOval(leftEyeRect, paint);

        RectF rightEyeRect = new RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f);
        canvas.drawOval(rightEyeRect, paint);
    }

    private void drawMouth(Canvas canvas) {
        // Clear
        Path mouthPath = new Path();
        mouthPath.reset();

        mouthPath.moveTo(size * 0.22f, size * 0.7f);

        if (happinessState == HAPPY) {
            // Happy mouth path
            mouthPath.quadTo(size * 0.5f, size * 0.80f, size * 0.78f, size * 0.7f);
            mouthPath.quadTo(size * 0.5f, size * 0.90f, size * 0.22f, size * 0.7f);
        } else {
            // Sad mouth path
            mouthPath.quadTo(size * 0.5f, size * 0.50f, size * 0.78f, size * 0.7f);
            mouthPath.quadTo(size * 0.5f, size * 0.60f, size * 0.22f, size * 0.7f);
        }

        paint.setColor(mouthColor);
        paint.setStyle(Paint.Style.FILL);

        // Draw mouth path
        canvas.drawPath(mouthPath, paint);
    }


}