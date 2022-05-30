package org.team_rocket_unc.electronica_digital_app.utils;

import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

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
        targetText.setOnKeyListener((v, keyCode, event) -> {
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
        });
    }

    public static InputFilter createInputFilter(String allowedCharacters) {
        return (source, start, end, dest, dStart, dEnd) -> source.toString()
                .replaceAll("[^" + allowedCharacters + "]", "").toUpperCase();
    }

}
