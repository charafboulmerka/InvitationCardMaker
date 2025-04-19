package com.jeddah.invitationcards.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.ItemTouchHelper;

import com.jeddah.invitationcards.R;

import java.util.ArrayList;
import java.util.HashMap;

public class PhotoDrawView extends View {
    static Canvas CANVAS = null;
    static final int DRAG = 1;
    public static int ERASE_MODE = 0;
    public static int MAGIC_MODE = 2;
    public static int MAGIC_MODE_RESTORE = 3;
    public static int MIRROR_MODE = 5;
    public static int MOVING_MODE = 4;
    static final int NONE = 0;
    public static int POINTER_DISTANCE = 0;
    public static int POINTER_OFFSET = 20;
    private static final float TOUCH_TOLERANCE = 4.0f;
    public static int UNERASE_MODE = 1;
    static final int ZOOM = 2;
    static Paint eraser;
    private static Path mPath;
    private static Path mPathErase;
    public static int mode;
    static Canvas newCanvas;
    public static Bitmap savedBitmap;
    static Paint uneraser;
    PointF DownPT = new PointF();
    float SCALE = 1.0f;
    final int STACKSIZE = 10;
    String TAG = "tri.dung";
    boolean TOUCH = false;
    int ZOOM_PROGRESS = 0;

    /* renamed from: bm */
    Bitmap f177bm;
    int bmHeight;
    int bmWidth;
    Bitmap bmp;
    ArrayList<Boolean> checkMirrorStep;
    Bitmap clippedBitmap;
    int currentIndex = -1;

    /* renamed from: d */
    private float f178d = 0.0f;
    public PointF drawingPoint;
    private String filename;
    int[] lastBitmapData;
    private float[] lastEvent = null;
    private Paint mBitmapPaint;
    public Context mContext;
    private Paint mMaskPaint;

    /* renamed from: mX */
    private float f179mX;

    /* renamed from: mY */
    private float f180mY;
    Bitmap magicPointer;
    public int magicThreshold = 15;
    public int magicTouchRange = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
    Matrix matrix = new Matrix();
    PointF mid = new PointF();
    public MotionEvent motionEvent;
    HashMap<Integer, Float> newDistance = new HashMap<>();
    private float newRot = 0.0f;
    float oldDist = 1.0f;
    int[] saveBitmapData;
    Matrix savedMatrix = new Matrix();
    ArrayList<int[]> stackChange;
    PointF start = new PointF();
    private int strokeWidth = 10;
    int touchMode = 0;
    public PointF touchPoint;
    int viewHeight;
    int viewWidth;
    HashMap<Integer, Float> zoomIncrease = new HashMap<>();
    Point zoomPos = new Point();

    public PhotoDrawView(Context context, Bitmap bitmap, int i, int i2, int i3, int i4) {
        super(context);
        this.bmp = bitmap;
        this.mContext = context;
        this.viewWidth = i3;
        this.viewHeight = i4;
        this.bmWidth = i;
        this.bmHeight = i2;
        setLayerType(1, (Paint) null);
        init(bitmap, i, i2);
        this.zoomIncrease.put(1, Float.valueOf(1.5f));
        this.zoomIncrease.put(2, Float.valueOf(2.0f));
        this.zoomIncrease.put(3, Float.valueOf(2.5f));
        this.zoomIncrease.put(4, Float.valueOf(3.0f));
        this.zoomIncrease.put(5, Float.valueOf(3.5f));
        this.newDistance.put(1, Float.valueOf(500.0f));
        this.newDistance.put(2, Float.valueOf(525.0f));
        this.newDistance.put(3, Float.valueOf(550.0f));
        this.newDistance.put(4, Float.valueOf(575.0f));
        this.newDistance.put(5, Float.valueOf(600.0f));
    }

    public void switchMode(int i) {
        mode = i;
        resetPath();
        saveLastMaskData();
        int i2 = mode;
        if (i2 == MAGIC_MODE || i2 == MAGIC_MODE_RESTORE) {
            this.magicPointer = BitmapFactory.decodeResource(getResources(), R.drawable.color_select);
        } else if (i2 == ERASE_MODE || i2 == UNERASE_MODE) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.color_select);
            int i3 = this.strokeWidth;
            this.magicPointer = Bitmap.createScaledBitmap(decodeResource, i3 + 5, i3 + 5, false);
        }
        invalidate();
    }

    public void init(Bitmap bitmap, int i, int i2) {
        mPath = new Path();
        mPathErase = new Path();
        Paint paint = new Paint();
        eraser = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        eraser.setAntiAlias(true);
        eraser.setStyle(Paint.Style.STROKE);
        eraser.setStrokeJoin(Paint.Join.ROUND);
        eraser.setStrokeCap(Paint.Cap.ROUND);
        eraser.setStrokeWidth((float) this.strokeWidth);
        Paint paint2 = new Paint();
        uneraser = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        uneraser.setAntiAlias(true);
        uneraser.setStyle(Paint.Style.STROKE);
        uneraser.setStrokeJoin(Paint.Join.ROUND);
        uneraser.setStrokeCap(Paint.Cap.ROUND);
        uneraser.setStrokeWidth((float) this.strokeWidth);
        this.matrix.postTranslate((float) ((this.viewWidth - i) / 2), (float) ((this.viewHeight - i2) / 2));
        Paint paint3 = new Paint();
        this.mBitmapPaint = paint3;
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mBitmapPaint.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.mMaskPaint = paint4;
        paint4.setAntiAlias(true);
        this.f177bm = bitmap;
        this.f177bm = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        this.clippedBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.clippedBitmap);
        newCanvas = canvas;
        canvas.save();
        newCanvas.drawARGB(255, 255, 255, 255);
        this.magicTouchRange = i > i2 ? i2 / 2 : i / 2;
        int i3 = i * i2;
        int[] iArr = new int[i3];
        this.saveBitmapData = iArr;
        Bitmap bitmap2 = this.f177bm;
        bitmap2.getPixels(iArr, 0, bitmap2.getWidth(), 0, 0, this.f177bm.getWidth(), this.f177bm.getHeight());
        this.lastBitmapData = new int[i3];
        this.magicPointer = BitmapFactory.decodeResource(getResources(), R.drawable.color_select);
        float f = (float) (i / 2);
        float f2 = (float) (i2 / 2);
        this.touchPoint = new PointF(f, f2);
        this.drawingPoint = new PointF(f, f2);
        saveLastMaskData();
        this.stackChange = new ArrayList<>();
        this.checkMirrorStep = new ArrayList<>();
        addToStack(false);
        this.filename = "img_" + String.format("%d.jpg", new Object[]{Long.valueOf(System.currentTimeMillis())});
        POINTER_DISTANCE = (int) (((float) POINTER_OFFSET) * this.mContext.getResources().getDisplayMetrics().density);
    }

    
    public void addToStack(boolean z) {
        if (this.stackChange.size() >= 10) {
            this.stackChange.remove(0);
            int i = this.currentIndex;
            if (i > 0) {
                this.currentIndex = i - 1;
            }
        }
        ArrayList<int[]> arrayList = this.stackChange;
        if (arrayList != null) {
            if (this.currentIndex == 0) {
                for (int size = arrayList.size() - 1; size > 0; size--) {
                    this.stackChange.remove(size);
                    this.checkMirrorStep.remove(size);
                }
            }
            int[] iArr = new int[(this.clippedBitmap.getWidth() * this.clippedBitmap.getHeight())];
            Bitmap bitmap = this.clippedBitmap;
            bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, this.clippedBitmap.getWidth(), this.clippedBitmap.getHeight());
            this.stackChange.add(iArr);
            this.checkMirrorStep.add(Boolean.valueOf(z));
            this.currentIndex = this.stackChange.size() - 1;
        }
    }

    public Bitmap drawBitmap(Bitmap bitmap) {
        int i = mode;
        if (i == ERASE_MODE || i == UNERASE_MODE) {
            if (mode == ERASE_MODE) {
                uneraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            } else {
                uneraser.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            }
            float f = this.SCALE;
            if (f <= 1.0f) {
                f = 1.0f;
            }
            eraser.setStrokeWidth(((float) this.strokeWidth) / f);
            uneraser.setStrokeWidth(((float) this.strokeWidth) / f);
            newCanvas.drawPath(mPath, eraser);
            newCanvas.drawPath(mPathErase, uneraser);
        }
        return this.clippedBitmap;
    }

    
    public void onDraw(Canvas canvas) {
        canvas.drawColor(-1);
        CANVAS = canvas;
        if (this.ZOOM_PROGRESS == 0 || this.TOUCH) {
            canvas.drawBitmap(this.f177bm, this.matrix, this.mMaskPaint);
            canvas.drawBitmap(drawBitmap(this.f177bm), this.matrix, this.mBitmapPaint);
        } else {
            Matrix matrix2 = new Matrix();
            matrix2.reset();
            int i = this.ZOOM_PROGRESS;
            matrix2.postScale((float) i, (float) i, (float) this.zoomPos.x, (float) this.zoomPos.y);
            canvas.drawBitmap(this.f177bm, matrix2, this.mMaskPaint);
            canvas.drawBitmap(drawBitmap(this.f177bm), matrix2, this.mBitmapPaint);
        }
        int i2 = mode;
        if (i2 == MAGIC_MODE || i2 == MAGIC_MODE_RESTORE || i2 == ERASE_MODE || i2 == UNERASE_MODE) {
            canvas.drawBitmap(this.magicPointer, this.drawingPoint.x - ((float) (this.magicPointer.getWidth() / 2)), this.drawingPoint.y - ((float) (this.magicPointer.getHeight() / 2)), this.mMaskPaint);
        }
        super.onDraw(canvas);
    }

    public void saveLastMaskData() {
        Bitmap bitmap = this.clippedBitmap;
        bitmap.getPixels(this.lastBitmapData, 0, bitmap.getWidth(), 0, 0, this.clippedBitmap.getWidth(), this.clippedBitmap.getHeight());
    }

    public void resetPath() {
        mPath.reset();
        mPathErase.reset();
    }

    private void touch_start(float f, float f2) {
        mPath.reset();
        mPathErase.reset();
        if (mode == ERASE_MODE) {
            mPath.moveTo(f, f2);
        } else {
            mPathErase.moveTo(f, f2);
        }
        this.f179mX = f;
        this.f180mY = f2;
    }

    private void touch_move(float f, float f2) {
        float abs = Math.abs(f - this.f179mX);
        float abs2 = Math.abs(f2 - this.f180mY);
        if (abs >= TOUCH_TOLERANCE || abs2 >= TOUCH_TOLERANCE) {
            if (mode == ERASE_MODE) {
                Path path = mPath;
                float f3 = this.f179mX;
                float f4 = this.f180mY;
                path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            } else {
                Path path2 = mPathErase;
                float f5 = this.f179mX;
                float f6 = this.f180mY;
                path2.quadTo(f5, f6, (f + f5) / 2.0f, (f2 + f6) / 2.0f);
            }
            this.f179mX = f;
            this.f180mY = f2;
        }
    }

    private void touch_up() {
        if (mode == ERASE_MODE) {
            mPath.lineTo(this.f179mX, this.f180mY);
        } else {
            mPathErase.lineTo(this.f179mX, this.f180mY);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent2) {
        float x = motionEvent2.getX();
        float y = motionEvent2.getY();
        this.zoomPos.x = (int) motionEvent2.getX();
        this.zoomPos.y = (int) motionEvent2.getY();
        setMotionEvent(motionEvent2);
        int i = mode;
        if (i == ERASE_MODE || i == UNERASE_MODE) {
            y -= (float) POINTER_DISTANCE;
        }
        int i2 = mode;
        if (i2 == MAGIC_MODE || i2 == MAGIC_MODE_RESTORE || i2 == ERASE_MODE || i2 == UNERASE_MODE) {
            this.drawingPoint.x = x;
            this.drawingPoint.y = y;
        }
        if (mode != MOVING_MODE) {
            float[] fArr = new float[9];
            this.matrix.getValues(fArr);
            float f = fArr[0];
            RectF rectF = new RectF();
            this.matrix.mapRect(rectF);
            x = (x - rectF.left) / f;
            y = (y - rectF.top) / f;
        }
        int actionMasked = motionEvent2.getActionMasked();
        if (actionMasked == 0) {
            this.savedMatrix.set(this.matrix);
            this.start.set(motionEvent2.getX(), motionEvent2.getY());
            this.lastEvent = null;
            this.touchMode = 1;
            int i3 = mode;
            if (i3 == ERASE_MODE || i3 == UNERASE_MODE) {
                touch_start(x, y);
            } else if (i3 == MOVING_MODE) {
                this.DownPT.x = motionEvent2.getX();
                this.DownPT.y = motionEvent2.getY();
            }
            invalidate();
        } else if (actionMasked == 1) {
            int i4 = mode;
            if (i4 == ERASE_MODE || i4 == UNERASE_MODE) {
                touch_up();
                Log.d(this.TAG, "add to stack");
                addToStack(false);
            } else if (i4 == MAGIC_MODE || i4 == MAGIC_MODE_RESTORE) {
                this.touchPoint.x = x;
                this.touchPoint.y = y;
                saveLastMaskData();
            }
            invalidate();
            resetPath();
        } else if (actionMasked == 2) {
            int i5 = this.touchMode;
            if (i5 == 1) {
                int i6 = mode;
                if (i6 == ERASE_MODE || i6 == UNERASE_MODE) {
                    touch_move(x, y);
                } else if (i6 == MOVING_MODE) {
                    PointF pointF = new PointF(motionEvent2.getX() - this.DownPT.x, motionEvent2.getY() - this.DownPT.y);
                    this.matrix.postTranslate(pointF.x, pointF.y);
                    this.DownPT.x = motionEvent2.getX();
                    this.DownPT.y = motionEvent2.getY();
                } else if (i6 == MAGIC_MODE || i6 == MAGIC_MODE_RESTORE) {
                    this.touchPoint.x = x;
                    this.touchPoint.y = y;
                }
                invalidate();
            } else if (i5 == 2 && mode == MOVING_MODE) {
                draw(CANVAS);
                setZoom1(motionEvent2);
            }
        } else if (actionMasked == 5) {
            draw(CANVAS);
            float[] fArr2 = new float[4];
            this.lastEvent = fArr2;
            fArr2[0] = motionEvent2.getX(0);
            this.lastEvent[1] = motionEvent2.getX(1);
            this.lastEvent[2] = motionEvent2.getY(0);
            this.lastEvent[3] = motionEvent2.getY(1);
            this.f178d = rotation(motionEvent2);
            setZoom2(motionEvent2);
        } else if (actionMasked == 6) {
            this.touchMode = 0;
            this.lastEvent = null;
            Log.d(this.TAG, "mode=NONE");
        }
        return true;
    }

    private float rotation(MotionEvent motionEvent2) {
        return (float) Math.toDegrees(Math.atan2((double) (motionEvent2.getY(0) - motionEvent2.getY(1)), (double) (motionEvent2.getX(0) - motionEvent2.getX(1))));
    }

    private void setMotionEvent(MotionEvent motionEvent2) {
        this.motionEvent = motionEvent2;
    }

    private void setZoom1(MotionEvent motionEvent2) {
        this.TOUCH = true;
        float spacing = spacing(motionEvent2);
        String str = this.TAG;
        Log.d(str, "newDist=" + spacing);
        if (spacing > 5.0f) {
            this.matrix.set(this.savedMatrix);
            float f = spacing / this.oldDist;
            this.SCALE = f;
            this.matrix.postScale(f, f, this.mid.x, this.mid.y);
            String str2 = this.TAG;
            Log.d(str2, "scale =" + this.SCALE);
        }
        if (this.lastEvent != null && motionEvent2.getPointerCount() == 2) {
            float rotation = rotation(motionEvent2);
            this.newRot = rotation;
            float f2 = rotation - this.f178d;
            float[] fArr = new float[9];
            this.matrix.getValues(fArr);
            float f3 = fArr[0];
            float f4 = fArr[4];
            float f5 = fArr[8];
            this.matrix.postRotate(f2, f3 + (((float) (this.bmp.getWidth() / 2)) * f5), f4 + (((float) (this.bmp.getHeight() / 2)) * f5));
        }
        invalidate();
    }

    private void setZoom2(MotionEvent motionEvent2) {
        this.TOUCH = true;
        float spacing = spacing(motionEvent2);
        this.oldDist = spacing;
        if (spacing > 5.0f) {
            this.savedMatrix.set(this.matrix);
            midPoint(this.mid, motionEvent2);
            this.touchMode = 2;
        }
    }

    private float spacing(MotionEvent motionEvent2) {
        float x = motionEvent2.getX(0) - motionEvent2.getX(1);
        float y = motionEvent2.getY(0) - motionEvent2.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private void midPoint(PointF pointF, MotionEvent motionEvent2) {
        pointF.set((motionEvent2.getX(0) + motionEvent2.getX(1)) / 2.0f, (motionEvent2.getY(0) + motionEvent2.getY(1)) / 2.0f);
    }
}
