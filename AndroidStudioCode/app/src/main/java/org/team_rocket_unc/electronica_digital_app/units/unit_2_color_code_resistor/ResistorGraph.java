package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import org.team_rocket_unc.electronica_digital_app.R;


public class ResistorGraph extends View implements Observer {

    private final Context context;
    private final static Paint resistorPaint = new Paint();
    private final static Paint cablePaint = new Paint();
    private final static Paint band1Paint = new Paint();
    private final static Paint band2Paint = new Paint();
    private final static Paint band3Paint = new Paint();
    private final static Paint band4Paint = new Paint();

    public ResistorGraph(Context context) {
        super(context);
        this.context = context;
        setPaintColor(resistorPaint, R.color.resistor);
        setPaintColor(cablePaint, R.color.black);
    }

    public ResistorGraph(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setPaintColor(resistorPaint, R.color.resistor);
    }

    public ResistorGraph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setPaintColor(resistorPaint, R.color.resistor);
    }

    @Override
    protected void onDraw(Canvas canvas){
        int width = 1000;
        int height = (int)(width * ((float) getHeight()/(float)getWidth()));
        canvas.scale(getWidth()/1000f,getWidth()/1000f);
        canvas.drawColor(Color.rgb(90,90,100));

        RectF cableRect = new RectF(width/2-350, height/2-10, width/2+350, height/2+10);
        canvas.drawRect(cableRect, cablePaint);
        int top = height/2 - 100;
        int bottom = height/2 + 100;
        RectF resistorRect = new RectF(width/2-200,top,width/2+200,bottom);
        canvas.drawRoundRect(resistorRect,10,10, resistorPaint);
        RectF band1Rect = new RectF(width/2-150, top, width/2 - 130, bottom);
        RectF band2Rect = new RectF(width/2-110, top, width/2 - 90, bottom);
        RectF band3Rect = new RectF(width/2-70, top, width/2 - 50, bottom);
        RectF band4Rect = new RectF(width/2+90, top, width/2 + 110, bottom);
        canvas.drawRect(band1Rect, band1Paint);
        canvas.drawRect(band2Rect, band2Paint);
        canvas.drawRect(band3Rect, band3Paint);
        canvas.drawRect(band4Rect, band4Paint);
    }

    private void setPaintColor(Paint paint, int color) {
        paint.setColor(ResourcesCompat.getColor(context.getResources(), color, null));
    }

    @Override
    public void update(ResistorInfo resistorInfo) {
        setPaintColor(band1Paint, resistorInfo.getBand1());
        setPaintColor(band2Paint, resistorInfo.getBand2());
        setPaintColor(band3Paint, resistorInfo.getBand3());
        setPaintColor(band4Paint, resistorInfo.getBand4());
        this.invalidate();
    }

}
