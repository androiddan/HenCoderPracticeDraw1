package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice10HistogramView extends View {

    private Paint paint;
    private Paint textPaint;
    private Path path;
    private List<Integer> list = new ArrayList<>();

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Random random = new Random();
        int count = 7;
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(count));//[1,7)
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        if (paint == null) {
            paint = new Paint();
            textPaint = new Paint();
            path = new Path();
            path = new Path();
        }
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);

        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(24);


        int width = getWidth();
        int height = getHeight();

        //canvas画两条直线
//        float[] dots = {100, 100, 100, height - 300,100, height - 300, width - 100, height - 300};
//        canvas.drawLines(dots,paint);

        //距离底部距离
        int dy = 150;

        //path画两条直线
        path.moveTo(100, 100);
        path.lineTo(100, height - dy);
        path.rLineTo(width - 200, 0);
        canvas.drawPath(path, paint);

        //矩形最大长度,总高度-头部间距-底部间距
        float Y = height - 100 - dy;
        float X = width - 200;
        //数据的长度
        float size = list.size();
        //矩形间隔
        float interval = 20;
        //每个矩形的宽度，加入8个数据，则需要9个间隔最后依然要多出一个
        float w = (X - interval * (size + 1)) / size;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);

        //绘制矩形以及文字
        for (int i = 0; i < list.size(); i++) {
            //left起点=100+间隔*i+矩形宽度*(i-1)
            float l = 100 + interval * (i + 1) + w * i;
            float t = Y+100/* Y轴顶部需要空出距离，不然会超出 */ - Y * (list.get(i) / size);
            float r = l + w;
            float b = height - 150;
            canvas.drawRect(l, t, r, b, paint);

            //绘制文字
            String text = String.valueOf(list.get(i));
            canvas.drawText(text, l + w / 2,
                    b + 20 + textPaint.measureText(text), textPaint);//注意：measureText只计算宽度，这会导致text长度越大，离x轴越远
        }

        String title = "直方图";
        textPaint.setTextSize(48);
        float testLen = textPaint.measureText(title);
        canvas.drawText(title, width / 2 - testLen / 2, height - 30, textPaint);//这里需要计算宽度，方便放在中心点

    }
}
