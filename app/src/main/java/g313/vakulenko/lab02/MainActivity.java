package g313.vakulenko.lab02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editA, editB;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editA = findViewById(R.id.editA);
        editB = findViewById(R.id.editB);
        result = findViewById(R.id.Result);
    }

    @SuppressLint("NonConstantResourceId")
    public void onButtonClick(View view) {
        // Получение значений из текстовых полей
        String inputA = editA.getText().toString();
        String inputB = editB.getText().toString();

        // Проверка на пустые значения
        if (inputA.isEmpty() || inputB.isEmpty()) {
            result.setText("Введите значения");
            return;
        }

        double a, b;

        // Проверка на корректный ввод
        try {
            a = Double.parseDouble(inputA);
            b = Double.parseDouble(inputB);
        } catch (NumberFormatException e) {
            result.setText("Некорректный ввод. Введите числовые значения.");
            return;
        }

        double resA;
        double resB;
        String output;

        // Определение операции по id кнопки
        if (view.getId() == R.id.butAdd) {
            // Сложение
            output = String.valueOf(a + b);
        } else if (view.getId() == R.id.butSub) {
            // Вычитание
            output = String.valueOf(a - b);
        } else if (view.getId() == R.id.butMult) {
            // Умножение
            output = String.valueOf(a * b);
        } else if (view.getId() == R.id.butDiv) {
            // Деление
            // Проверка на 0
            if (b == 0) {
                result.setText("Делить на ноль нельзя!");
                return;
            }
            output = String.valueOf(a / b);
        } else if (view.getId() == R.id.butSin) {
            // Синус
            resA = Math.sin(Math.toRadians(a));
            resB = Math.sin(Math.toRadians(b));
            output = resA + " | " + resB;
        } else if (view.getId() == R.id.butCos) {
            // Косинус
            resA = Math.cos(Math.toRadians(a));
            resB = Math.cos(Math.toRadians(b));
            output = resA + " | " + resB;
        } else if (view.getId() == R.id.butTan) {
            // Тангенс
            resA = Math.tan(Math.toRadians(a));
            resB = Math.tan(Math.toRadians(b));
            output = resA + " | " + resB;
        } else if (view.getId() == R.id.butSqrt) {
            // Квадратный корень
            // Проверка на отрицательные значения
            if (a < 0 || b < 0) {
                result.setText("Нельзя извлекать корень из отрицательного числа");
                return;
            }
            resA = Math.sqrt(a);
            resB = Math.sqrt(b);
            output = resA + " | " + resB;
        } else if (view.getId() == R.id.butPow) {
            // Возведение в степень
            resA = Math.pow(a, b);
            resB = Math.pow(b, a);
            output = resA + " | " + resB;
        } else {
            output = "Ошибка в операции";
        }

        result.setText(output);
    }
}