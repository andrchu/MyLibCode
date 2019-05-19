package com.example.chu.playanimtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class VoiceView extends View {
    private Paint paint;
    private int mRectWidth, mRectHeight;
    private int offset = 8;
    private RectF rectF;

    public VoiceView(Context context) {
        this(context, null);
    }

    public VoiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        mRectWidth = 32;
        mRectHeight = 8;
        rectF = new RectF();
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        int size = new Random().nextInt(5) + 1;
        for (int i = 0; i < size; i++) {
            rectF.set(0, 200 - (mRectHeight * (i + 1) + offset * i),
                    mRectWidth, 200 - (i * mRectHeight + i * offset));
            canvas.drawRoundRect(rectF, 4, 4, paint);
        }

        postInvalidateDelayed(200);
    }


}
