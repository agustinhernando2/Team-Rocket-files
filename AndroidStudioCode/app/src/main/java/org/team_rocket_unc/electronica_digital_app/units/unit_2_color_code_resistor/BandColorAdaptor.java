package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.core.content.res.ResourcesCompat;

import org.team_rocket_unc.electronica_digital_app.R;

import java.util.Arrays;
import java.util.List;

public class BandColorAdaptor extends BaseAdapter {

    private final Context context;
    private final List<Integer> colors;

    private static final List<Integer> FULL_BAND_COLORS = Arrays.asList(
            R.color.black,   //BLACK
            R.color.BROWN,   //BROWN
            R.color.RED,   //RED
            R.color.ORANGE,   //ORANGE
            R.color.YELLOW,   //YELLOW
            R.color.GREEN,   //GREEN
            R.color.BLUE,   //BLUE
            R.color.VIOLET,   //VIOLET
            R.color.GRAY,   //GREY
            R.color.WHITE,   //WHITE
            R.color.GOLD,   //GOLD
            R.color.SILVER     //SILVER
            );

    public BandColorAdaptor(Context context, List<Integer> colors) {
        this.context = context;
        this.colors = colors;
    }
    @Override
    public int getCount() {
        return colors != null ? colors.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return colors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.layout_u2_p1_color_band_item, parent, false);
        rootView.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), colors.get(position), null));
        return rootView;
    }

    public static List<Integer> getNormalBandColors() {
        return FULL_BAND_COLORS.subList(0,10);
    }

    public static List<Integer> getPartialBandColors() {
        return FULL_BAND_COLORS.subList(0, 7);
    }

    public static List<Integer> getSpecialBandColors() {
        return FULL_BAND_COLORS.subList(10, 12);
    }

}
