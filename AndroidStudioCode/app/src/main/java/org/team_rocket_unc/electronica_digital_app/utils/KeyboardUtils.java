package org.team_rocket_unc.electronica_digital_app.utils;

import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public final class KeyboardUtils {

    private KeyboardUtils() {
    }

    public static void functionAfterChange(EditText targetText, Runnable function) {
        targetText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                function.run();
            }
        });
    }

    public static void closeKeyboardOnEnter(EditText targetText, Activity activity) {
        targetText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER) {
                    try {
                        InputMethodManager inputMethodManager =
                                (InputMethodManager) activity.getSystemService(
                                        Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(
                                activity.getCurrentFocus().getWindowToken(), 0);
                    }
                    catch (Exception ignore){}
                    return true;
                }
                return false;
            }
        });
    }

    public static InputFilter createInputFilter(String allowedCharacters) {
        return new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                return source.toString().replaceAll("[^" + allowedCharacters + "]", "").toUpperCase();
            }
        };
    }

}
