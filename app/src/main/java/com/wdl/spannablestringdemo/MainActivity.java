package com.wdl.spannablestringdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


/**
 * Spannable四种模式：
 * 1.Spannable.SPAN_INCLUSIVE_EXCLUSIVE 起始下标之前添加新文字也会应用、结束下标之后添加新文字不会应用
 * 2.Spannable.SPAN_INCLUSIVE_INCLUSIVE 起始下标和结束下标前、后添加文本都会应用
 * 3.Spannable.SPAN_EXCLUSIVE_INCLUSIVE 与第一种相反
 * 4.Spannable.SPAN_EXCLUSIVE_EXCLUSIVE 都不包括
 * <p>
 */
public class MainActivity extends AppCompatActivity
{
    private TextView mForegroundTv;
    private TextView mBackgroundTv;
    private TextView mImageTv;
    private TextView mURLTv;
    private TextView mClickableTv;
    private TextView mSuperscriptTv;
    private TextView mSubscriptTv;
    private TextView mRelativeSizeTv;
    private TextView mUnderlineTv;
    private TextView mStrikethroughTv;
    private TextView mStyleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mForegroundTv = findViewById(R.id.tv_foreground_span);
        mBackgroundTv = findViewById(R.id.tv_background_span);
        mImageTv = findViewById(R.id.tv_image_span);
        mURLTv = findViewById(R.id.tv_url_span);
        mClickableTv = findViewById(R.id.tv_clickable_span);
        mSuperscriptTv = findViewById(R.id.tv_super_script_span);
        mSubscriptTv = findViewById(R.id.tv_subscript_span);
        mRelativeSizeTv = findViewById(R.id.tv_relative_size_span);
        mUnderlineTv = findViewById(R.id.tv_underline_span);
        mStrikethroughTv = findViewById(R.id.tv_strikethrough_span);
        mStyleTv = findViewById(R.id.tv_style_span);

        setForeground();
        setBackground();
        setRelativeSize();
        setImage();
        setStrikethrough();
        setUnderline();
        setStyle();
        setURL();
        setSuperscript();
        setSubscript();
        setCilckable();
    }

    /**
     * 设置前景色-即textColor
     */
    private void setForeground()
    {
        final String content = mForegroundTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FFD700"));
        spannableString.setSpan(foregroundColorSpan, 2, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mForegroundTv.setText(spannableString);
    }

    /**
     * 设置背景色
     */
    private void setBackground()
    {
        final String content = mBackgroundTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#FFD700"));
        spannableString.setSpan(backgroundColorSpan, 2, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mBackgroundTv.setText(spannableString);
    }

    /**
     * 设置字体相对textSize的相对大小
     */
    private void setRelativeSize()
    {
        final String content = mRelativeSizeTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        RelativeSizeSpan relativeSizeSpan1 = new RelativeSizeSpan(1.2f);
        RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(1.4f);
        RelativeSizeSpan relativeSizeSpan3 = new RelativeSizeSpan(1.6f);
        spannableString.setSpan(relativeSizeSpan1, 0, 1, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(relativeSizeSpan2, 1, 2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(relativeSizeSpan3, 2, 3, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mRelativeSizeTv.setText(spannableString);
    }

    /**
     * 插入图片
     */
    private void setImage()
    {
        final String content = mImageTv.getText().toString();
        SpannableString spannableString = new SpannableString("在文本中添加表情（表情）");
        Drawable drawable = getResources().getDrawable(R.drawable.ic_assistant_photo_black_24dp);
        drawable.setBounds(0, 0, 42, 42);
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannableString.setSpan(imageSpan, 6, 8, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mImageTv.setText(spannableString);
    }

    /**
     * 删除线
     */
    private void setStrikethrough()
    {
        final String content = mStrikethroughTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString.setSpan(strikethroughSpan, 2, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mStrikethroughTv.setText(spannableString);
    }

    /**
     * 下划线
     */
    private void setUnderline()
    {
        final String content = mUnderlineTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableString.setSpan(underlineSpan, 2, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mUnderlineTv.setText(spannableString);
    }

    /**
     * Style
     */
    private void setStyle()
    {
        final String content = mStyleTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        StyleSpan boldStyle = new StyleSpan(Typeface.BOLD);
        StyleSpan itelicStyle = new StyleSpan(Typeface.ITALIC);
        spannableString.setSpan(boldStyle, 2, 4, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(itelicStyle, 4, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mStyleTv.setText(spannableString);
    }

    /**
     * URL
     */
    private void setURL()
    {
        final String content = "https://www.baidu.com";
        SpannableString spannableString = new SpannableString(content);
        URLSpan urlSpan = new URLSpan(content);
        spannableString.setSpan(urlSpan, 0, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mURLTv.setText(spannableString);
        mURLTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(content));
                startActivity(intent);
            }
        });
    }

    /**
     * 上角标
     */
    private void setSuperscript()
    {
        final String content = mSuperscriptTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        spannableString.setSpan(superscriptSpan, 2, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mSuperscriptTv.setText(spannableString);
    }

    /**
     * 下角标
     */
    private void setSubscript()
    {
        final String content = mSubscriptTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        spannableString.setSpan(subscriptSpan, 2, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        mSubscriptTv.setText(spannableString);
    }

    private static final String TAG = "MainActivity";

    /**
     * 单击
     */
    private void setCilckable()
    {
        final String content = mClickableTv.getText().toString();
        SpannableString spannableString = new SpannableString(content);
        ClickableSpan clickableSpan = new ClickableSpan()
        {
            @Override
            public void onClick(@NonNull View widget)
            {
                Log.e(TAG, "onClick: ");
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds)
            {
                //super.updateDrawState(ds);
                // 去除下划线
                ds.setUnderlineText(false);
            }
        };
        spannableString.setSpan(clickableSpan, 2, content.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        // 必须设置
        mClickableTv.setMovementMethod(LinkMovementMethod.getInstance());
        // 点击时的背景色
        mClickableTv.setHighlightColor(Color.parseColor("#36969696"));
        mClickableTv.setText(spannableString);
    }
}
