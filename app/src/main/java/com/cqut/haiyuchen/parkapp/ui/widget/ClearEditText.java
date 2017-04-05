package com.cqut.haiyuchen.parkapp.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.cqut.haiyuchen.parkapp.R;

/**
 * Created by haiyu.chen on 2017/3/31.
 */
public class ClearEditText extends EditText implements View.OnFocusChangeListener {

  private Drawable clearIcon;
  private OnFocusChangeListener onFocusChangeListener;
  private TextWatcher textWatcher;

  public ClearEditText(Context context) {
    super(context);
    init(context);
  }

  public ClearEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    if (attrs != null) {
      TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ClearEditText);
      clearIcon = array.getDrawable(R.styleable.ClearEditText_clear_icon);
      array.recycle();
    }
    init(context);
  }

  private void init(Context context) {
    if (clearIcon == null) {
      clearIcon = context.getResources().getDrawable(R.drawable.ic_clear);
    }
    clearIcon.setBounds(0, 0, clearIcon.getIntrinsicWidth(), clearIcon.getIntrinsicHeight());
    super.setOnFocusChangeListener(this);
    super.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (textWatcher != null) {
          textWatcher.beforeTextChanged(s, start, count, after);
        }
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (isFocused()) {
          setClearIconVisible(s.length() > 0);
        }
        if (textWatcher != null) {
          textWatcher.onTextChanged(s, start, before, count);
        }
      }

      @Override
      public void afterTextChanged(Editable s) {
        if (textWatcher != null) {
          textWatcher.afterTextChanged(s);
        }
      }
    });
  }

  @Override
  public void setOnFocusChangeListener(OnFocusChangeListener l) {
    onFocusChangeListener = l;
  }

  @Override
  public void addTextChangedListener(TextWatcher watcher) {
    textWatcher = watcher;
  }

  /**
   * 因为我们不能直接给EditText设置点击事件，所以我们用记住我们按下的位置来模拟点击事件
   * 当我们按下的位置 在  EditText的宽度 - 图标到控件右边的间距 - 图标的宽度  和
   * EditText的宽度 - 图标到控件右边的间距之间我们就算点击了图标，竖直方向就没有考虑
   */
  @Override
  public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_UP) {
      if (getCompoundDrawables()[2] != null) {
        boolean touchable =
            event.getX() > (getWidth() - getTotalPaddingRight()) && (event.getX() < ((getWidth()
                - getPaddingRight())));
        if (touchable) {
          this.setText(null);
        }
      }
    }
    return super.onTouchEvent(event);
  }

  /**
   * 设置清除图标的显示与隐藏，调用setCompoundDrawables为EditText绘制上去
   */
  protected void setClearIconVisible(boolean visible) {
    Drawable right = visible ? clearIcon : null;
    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right,
        getCompoundDrawables()[3]);
  }

  @Override
  public void onFocusChange(View v, boolean hasFocus) {
    if (hasFocus) {
      setClearIconVisible(getText().length() > 0);
    } else {
      setClearIconVisible(false);
    }
    if (onFocusChangeListener != null) {
      onFocusChangeListener.onFocusChange(v, hasFocus);
    }
  }
}
