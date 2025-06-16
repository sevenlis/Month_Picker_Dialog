package by.sevenlis.monthpickerdialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.content.res.AppCompatResources;

import java.util.Calendar;

import by.sevenlis.monthpickerdialog.databinding.MonthPickerDialogBinding;

public class MonthPickerDialog extends AppCompatDialog {

    public interface MonthPickerDialogListener {
        void onMonthPickerDialogPositiveClick(Calendar calMonthDate);
        void onMonthPickerDialogNegativeClick();
    }

    private MonthPickerDialogBinding binding;

    private final Context mContext;
    private final Calendar calMonthDate;
    private final MonthPickerDialogListener mListener;

    private String[] names;

    public MonthPickerDialog(@NonNull Context mContext, @NonNull MonthPickerDialogListener mListener) {
        super(mContext, R.style.Theme_EditDialogTheme);
        this.calMonthDate = Calendar.getInstance();
        this.calMonthDate.set(Calendar.DATE, 1);
        this.mContext = mContext;
        this.mListener = mListener;
        this.names = mContext.getResources().getStringArray(R.array.months);
    }

    public MonthPickerDialog setDate(Calendar calDate) {
        this.calMonthDate.setTime(calDate.getTime());
        this.calMonthDate.set(Calendar.DATE, 1);
        return this;
    }

    public MonthPickerDialog useShortNames(boolean useShortNames) {
        this.names = mContext.getResources().getStringArray(useShortNames ? R.array.months_short : R.array.months);
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MonthPickerDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setViews();
    }

    private void setDateLabel() {
        String sDate = names[calMonthDate.get(Calendar.MONTH)] + " " + calMonthDate.get(Calendar.YEAR);
        binding.tvDateLabel.setText(sDate);
    }

    private void setYearLabel() {
        binding.tvYearLabel.setText(String.valueOf(calMonthDate.get(Calendar.YEAR)));
    }

    private void setViews() {
        binding.tvMonth0.setText(names[Calendar.JANUARY]);
        binding.tvMonth1.setText(names[Calendar.FEBRUARY]);
        binding.tvMonth2.setText(names[Calendar.MARCH]);
        binding.tvMonth3.setText(names[Calendar.APRIL]);
        binding.tvMonth4.setText(names[Calendar.MAY]);
        binding.tvMonth5.setText(names[Calendar.JUNE]);
        binding.tvMonth6.setText(names[Calendar.JULY]);
        binding.tvMonth7.setText(names[Calendar.AUGUST]);
        binding.tvMonth8.setText(names[Calendar.SEPTEMBER]);
        binding.tvMonth9.setText(names[Calendar.OCTOBER]);
        binding.tvMonth10.setText(names[Calendar.NOVEMBER]);
        binding.tvMonth11.setText(names[Calendar.DECEMBER]);
        setDateLabel();
        setYearLabel();
        setListeners();
        setBackgrounds();
    }

    private void setBackgrounds() {
        Drawable bg_def = AppCompatResources.getDrawable(mContext, R.drawable.month_bg);
        Drawable bg_sel = AppCompatResources.getDrawable(mContext, R.drawable.month_sel_bg);
        binding.tvMonth0.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.JANUARY ? bg_sel : bg_def);
        binding.tvMonth1.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.FEBRUARY ? bg_sel : bg_def);
        binding.tvMonth2.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.MARCH ? bg_sel : bg_def);
        binding.tvMonth3.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.APRIL ? bg_sel : bg_def);
        binding.tvMonth4.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.MAY ? bg_sel : bg_def);
        binding.tvMonth5.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.JUNE ? bg_sel : bg_def);
        binding.tvMonth6.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.JULY ? bg_sel : bg_def);
        binding.tvMonth7.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.AUGUST ? bg_sel : bg_def);
        binding.tvMonth8.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.SEPTEMBER ? bg_sel : bg_def);
        binding.tvMonth9.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.OCTOBER ? bg_sel : bg_def);
        binding.tvMonth10.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.NOVEMBER ? bg_sel : bg_def);
        binding.tvMonth11.setBackground(calMonthDate.get(Calendar.MONTH) == Calendar.DECEMBER ? bg_sel : bg_def);
    }

    private void setListeners() {
        binding.tvMonth0.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.JANUARY);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth1.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.FEBRUARY);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth2.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.MARCH);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth3.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.APRIL);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth4.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.MAY);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth5.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.JUNE);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth6.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.JULY);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth7.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.AUGUST);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth8.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.SEPTEMBER);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth9.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.OCTOBER);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth10.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.NOVEMBER);
            setBackgrounds();
            setDateLabel();
        });
        binding.tvMonth11.setOnClickListener(v -> {
            calMonthDate.set(Calendar.MONTH, Calendar.DECEMBER);
            setBackgrounds();
            setDateLabel();
        });

        binding.btnNegative.setOnClickListener(v -> {
            mListener.onMonthPickerDialogNegativeClick();
            dismiss();
        });
        binding.btnPositive.setOnClickListener(v -> {
            mListener.onMonthPickerDialogPositiveClick(calMonthDate);
            dismiss();
        });

        binding.ibArrowBack.setOnClickListener(v -> {
            calMonthDate.roll(Calendar.YEAR, false);
            setYearLabel();
            setDateLabel();
        });
        binding.ibArrowForward.setOnClickListener(v -> {
            calMonthDate.roll(Calendar.YEAR, true);
            setYearLabel();
            setDateLabel();
        });
    }
}
