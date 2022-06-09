package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import org.team_rocket_unc.electronica_digital_app.R;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ResistorInfo {

    private final String value;
    private final int band1;
    private final int band2;
    private final int band3;
    private final int band4;

    private static final BiMap<Integer, Integer> COLOR_MAP = HashBiMap.create();
    private static final Map<Integer, String> MULTIPLIER_MAP = new HashMap<>();

    static {
        COLOR_MAP.put(R.color.black, 0);
        COLOR_MAP.put(R.color.BROWN, 1);
        COLOR_MAP.put(R.color.RED, 2);
        COLOR_MAP.put(R.color.ORANGE, 3);
        COLOR_MAP.put(R.color.YELLOW, 4);
        COLOR_MAP.put(R.color.GREEN, 5);
        COLOR_MAP.put(R.color.BLUE, 6);
        COLOR_MAP.put(R.color.VIOLET, 7);
        COLOR_MAP.put(R.color.GRAY, 8);
        COLOR_MAP.put(R.color.WHITE, 9);
        MULTIPLIER_MAP.put(0, "");
        MULTIPLIER_MAP.put(1, "k");
        MULTIPLIER_MAP.put(2, "M");
    }

    public ResistorInfo(String value) {
        this.value = value;

        String[] valueSections = value.replaceAll("\u00B1|\u03A9|%", "").split(" ");
        double numericalValue = Double.parseDouble(valueSections[0].replaceAll("k|M", ""));
        numericalValue *= value.contains("M") ? 1000000 : value.contains("k") ? 1000 : 1;
        int totalDigits = (int) Math.log10(numericalValue);
        this.band3 = COLOR_MAP.inverse().get(totalDigits - 1);
        numericalValue *= 10;
        totalDigits++;
        int firstDigit = (int) (numericalValue/ (int) Math.pow(10,totalDigits));
        numericalValue -= firstDigit * Math.pow(10, totalDigits);
        int secondDigit = (int) (numericalValue/ (int) Math.pow(10, totalDigits-1));
        this.band1 = COLOR_MAP.inverse().get(firstDigit);
        this.band2 = COLOR_MAP.inverse().get(secondDigit);
        this.band4 = valueSections[1].equals("5") ? R.color.GOLD : R.color.SILVER;

    }

    public ResistorInfo(int band1, int band2, int band3, int band4) {
        double resistance = (long) ((COLOR_MAP.get(band1) * 10 + COLOR_MAP.get(band2)) * Math.pow(10, COLOR_MAP.get(band3)));
        int multiplier = 0;
        while(resistance >= 1000) {
            multiplier++;
            resistance /= 1000;
        }
        this.value = new DecimalFormat("0.#").format(resistance) + MULTIPLIER_MAP.get(multiplier) + '\u03A9'  + " \u00B1" + (band4 == R.color.GOLD ? 5 : 10) + "%";
        this.band1 = band1;
        this.band2 = band2;
        this.band3 = band3;
        this.band4 = band4;
    }

    public String getValue() {
        return value;
    }

    public int getBand1() {
        return band1;
    }

    public int getBand2() {
        return band2;
    }

    public int getBand3() {
        return band3;
    }

    public int getBand4() {
        return band4;
    }

}
