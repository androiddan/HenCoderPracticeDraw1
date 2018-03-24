package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    private Paint paint;

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        if (paint==null){
            paint=new Paint();
        }
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);

        int width=getWidth();
        int height=getHeight();
        int x=width/2;
        int y=height/2;

        //圆点
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(20);
        canvas.drawPoint(x/2,y,paint);

        //方点
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(x/2+x,y,paint);
    }
}
