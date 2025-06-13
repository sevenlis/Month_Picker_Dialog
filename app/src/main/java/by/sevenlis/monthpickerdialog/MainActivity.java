package by.sevenlis.monthpickerdialog;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

import by.sevenlis.monthpickerdialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MonthPickerDialog.MonthPickerDialogListener {

    private ActivityMainBinding binding;
    private Calendar monthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        monthDate = Calendar.getInstance();
        binding.btnPicker.setText(FormatUtils.fMonth(MainActivity.this, monthDate));
        binding.btnPicker.setOnClickListener(v -> {
            MonthPickerDialog dialog =
                    new MonthPickerDialog(MainActivity.this, MainActivity.this)
                            .setDate(monthDate)
                            .useShortNames(false);
            dialog.create();
            dialog.show();
        });

    }

    @Override
    public void onMonthPickerDialogPositiveClick(Calendar calMonthDate) {
        monthDate = calMonthDate;
        binding.btnPicker.setText(FormatUtils.fMonth(this, monthDate));
    }

    @Override
    public void onMonthPickerDialogNegativeClick() {

    }
}