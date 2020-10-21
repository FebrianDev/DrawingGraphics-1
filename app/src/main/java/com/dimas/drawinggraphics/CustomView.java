package com.dimas.drawinggraphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;

import java.lang.reflect.Array;

public class CustomView extends AppCompatImageView {

    private Paint paint;
    private Bitmap bitmap;
    public CustomView(@NonNull Context context) {
        super(context);
        paint = new Paint();
        bitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.car_logo2), 300, 300, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.translate(getWidth() / 4, 100);
        canvas.drawRect(500,250,-100,0,paint);
        canvas.drawRect(625,500,-350,250,paint);

        paint.setColor(Color.RED);
        drawTriangle(canvas, paint,-100,125,250);
        drawTriangle(canvas, paint,500,125,250);

        paint.setColor(Color.YELLOW);
        canvas.drawRect(100,50,-50,200,paint);
        paint.setColor(Color.WHITE);
        canvas.drawRect(300,50,150,200,paint);
        paint.setColor(Color.WHITE);
        canvas.drawRect(500,50,350,200,paint);

        canvas.drawBitmap(bitmap, 50,180,paint);

        paint.setColor(Color.BLACK);
        canvas.drawCircle(-50, 480,120,paint);
        canvas.drawCircle(400, 480,120,paint);
        paint.setTextSize(72);
        canvas.drawText("NRP : 4210191029", 700, 150, paint);
        canvas.drawText("Nama : Dimas Rizky AF", 700, 250, paint);
    }

    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top

        path.close();

        canvas.drawPath(path, paint);
    }
}
