package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private Paint paint;
    private RectF rectF;
    private RectF rectF2;
    private Path path = new Path();


    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        if (paint == null) {
            paint = new Paint();
        }
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);

        int width = getWidth();
        int height = getHeight();
        int x = width / 2;
        int y = height / 2;

        if (rectF == null) {
            rectF = new RectF(x - 200, y - 200, x, y);
            rectF2 = new RectF(x, y-200, x + 200, y);
        }

        path.addArc(rectF,-225,225);
        path.arcTo(rectF2,-180,225,false);
        path.lineTo(x,y+130);
        canvas.drawPath(path,paint);
    }
}
