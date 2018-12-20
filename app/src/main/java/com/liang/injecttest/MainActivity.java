package com.liang.injecttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.liang.annotations.BindView;
import com.liang.annotations.OnCheckedChanged;
import com.liang.annotations.OnClick;
import com.liang.annotations.OnEditorAction;
import com.liang.annotations.OnLongClick;
import com.liang.annotations.OnTextChanged;
import com.liang.inject.JInjector;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.textView_)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JInjector.bind(this);
        imageView.setColorFilter(Color.GREEN);
    }

    @OnClick({R.id.button, R.id.imageView})
    public void test(View view) {
        String msg = "";
        switch (view.getId()) {
            case R.id.button:
                msg = "button";
                break;
            case R.id.imageView:
                msg = "imageView";
                break;
        }
        showMsg("OnClick: " + msg);
    }

    @OnLongClick({R.id.button, R.id.imageView})
    public boolean test2(View view) {
        String msg = "";
        switch (view.getId()) {
            case R.id.button:
                msg = "button";
                break;
            case R.id.imageView:
                msg = "imageView";
                break;
        }
        showMsg("OnLongClick: " + msg);
        return true;
    }

    @OnCheckedChanged({R.id.checkBox, R.id.switch1, R.id.toggleButton, R.id.radioButton1, R.id.radioButton2})
    public void testCheckedChange(CompoundButton v, boolean isChecked) {
        Log.d("OnCheckedChanged", "testCheckedChange: " + ((CompoundButton) v).getText() + ", isChecked: " + isChecked);
        String msg = "";
        switch (v.getId()) {
            case R.id.checkBox:
                msg = "checkBox";
                break;
            case R.id.switch1:
                msg = "switch1";
                break;
            case R.id.toggleButton:
                msg = "toggleButton";
                break;
            case R.id.radioButton1:
                msg = "radioButton1";
                break;
            case R.id.radioButton2:
                msg = "radioButton2";
                break;
        }
        showMsg("OnCheckedChanged: " + msg + "\nisChecked: " + isChecked);
    }

    @OnTextChanged(R.id.editText)
    public void testTextChanged(View v, CharSequence s, int start, int before, int count) {
        showMsg("testTextChanged: " + s);
    }

    @OnEditorAction(R.id.editText)
    public boolean testEditorAction(View v, int actionId, KeyEvent event) {
        showMsg("testEditorAction: " + ((EditText) v).getText());
        return true;
    }

    private void showMsg(String msg) {
        textView.setText(msg);
    }
}
