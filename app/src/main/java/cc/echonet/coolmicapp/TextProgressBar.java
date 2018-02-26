package cc.echonet.coolmicapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * http://colintmiller.com/how-to-add-text-over-a-progress-bar-on-android/
 */
public class TextProgressBar extends ProgressBar {
    private String text;
    private Paint textPaint;
    private Rect bounds = new Rect();

    public TextProgressBar(Context context) {
        super(context);
        text = "";
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
    }

    public TextProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        text = "";
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
    }

    public TextProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        text = "";
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        // First draw the regular progress bar, then custom draw our text
        super.onDraw(canvas);

        textPaint.getTextBounds(text, 0, text.length(), bounds);
        int x = getWidth() / 2 - bounds.centerX();
        int y = getHeight() / 2 - bounds.centerY();
        canvas.drawText(text, x, y, textPaint);
    }

    public synchronized void setText(String text) {
        this.text = text;
        drawableStateChanged();
    }

    public void setTextColor(int color) {
        textPaint.setColor(color);
        drawableStateChanged();
    }
}
