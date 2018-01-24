package com.express.notely.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.express.notely.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Toolbar extends RelativeLayout implements View.OnClickListener {

    @Bind(R.id.toolbar_home)
    TextView toolbarHome;

    @Bind(R.id.toolbar_text)
    TextView toolbarText;

    @Bind(R.id.toolbar_menu_items)
    LinearLayout menuItems;

   // private int navIcon;
    private String title;
    private int menuItemsLayout = 0;
    private String textStyle = null;
    private String textAlign = null;


    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    @OnClick(R.id.toolbar_home)
    void onNavIconClicked() {
        onClick(toolbarHome);
    }

    public void setTitleText(String s) {
        toolbarText.setText(s);
    }

    public void setTextStyle(String style){
        if(style!= null && style.equals("bold"))
            toolbarText.setTypeface(null, Typeface.BOLD);
        else
            toolbarText.setTypeface(null, Typeface.NORMAL);
    }

    public void setEllipsize(){
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        final int width  = displayMetrics.widthPixels;
        toolbarText.setMaxLines(1);
        toolbarText.setEllipsize(TextUtils.TruncateAt.END);
        toolbarText.setMaxWidth((int) (width*0.7));
    }

    public void setTextAlign(String align){
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) toolbarText.getLayoutParams();
        if(align == null || align.equals("left")){
            params.addRule(RelativeLayout.RIGHT_OF, R.id.toolbar_home);
        }else if(align.equals("center")){
            params.addRule(RelativeLayout.CENTER_IN_PARENT);
        }
        toolbarText.setLayoutParams(params);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setGravity(Gravity.CENTER_VERTICAL);
        ButterKnife.bind(this);
        setClickable(true);
        setTitleText(title);
        setTextStyle(textStyle);
        setTextAlign(textAlign);
        setMenuItemLayout();
    }

    private void setMenuItemLayout() {
        menuItems.removeAllViews();
        if (menuItemsLayout != 0) {
            ViewGroup items = (ViewGroup) LayoutInflater.from(getContext()).inflate(menuItemsLayout, menuItems, true);
            for (int index = 0; index < items.getChildCount(); index++) {
                items.getChildAt(index).setOnClickListener(this);
            }
        }
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.toolbar, this);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ToolbarWidget);

        final int N = a.getIndexCount();
        for (int i = 0; i < N; ++i) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.ToolbarWidget_title_text:
                    title = a.getString(attr);
                    break;
                case R.styleable.ToolbarWidget_menu_items:
                    menuItemsLayout = a.getResourceId(attr, 0);
                    break;
                case R.styleable.ToolbarWidget_title_text_style:
                    textStyle = a.getString(attr);
                    break;
                case R.styleable.ToolbarWidget_title_text_align:
                    textAlign = a.getString(attr);
                    break;
            }
        }
        a.recycle();
    }

    @Override
    public void onClick(View view) {
        if (!EventIntervalUtils.canClick())
            return;
        ((Activity) getContext()).onBackPressed();
    }
}