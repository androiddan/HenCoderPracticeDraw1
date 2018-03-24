package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private RectF rectF;
    private Paint paint;

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        if (paint==null){
            paint=new Paint();
        }
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);

        int width=getWidth();
        int height=getHeight();
        int x=width/2;
        int y=height/2;

        if (rectF==null)
            rectF=new RectF(x-300,y-200,x+300,y+200);

        //扇形,有中心点
        canvas.drawArc(rectF,0,-90,true,paint);

        //扇形,无中心点
        canvas.drawArc(rectF,20,120,false,paint);

        //圆弧，有中心点
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF,180,60,false,paint);
    }
}
