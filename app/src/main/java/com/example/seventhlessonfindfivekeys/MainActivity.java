package com.example.seventhlessonfindfivekeys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // поля
    private TextView screen, coordinates;
    private float x; // координата касания по оси X
    private float y; // координата касания по оси Y
    private int[] coordinatesKeys; // массив координат 5 ключей
    private int interval = 50; // погрешность поиска

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка разметки к полям
        screen = findViewById(R.id.screen);
        coordinates = findViewById(R.id.coordinates);

//        // заполнение массива координат выбранными числами, где чётные это координаты X, а нечётные координаты Y
//        coordinatesKeys = new int[]{100, 100, 200, 200, 300, 300, 400, 400, 500, 500};
        // заполнение массива координат случайными числами
        coordinatesKeys = valueArrayRandom();

        // обработка касания TextView
        screen.setOnTouchListener(listener);
    }

    // метод генерации массива 10 случайных чисел (для координат 5 ключей)
    private int[] valueArrayRandom() {
        Random random = new Random(); // создание обьекта класса Random
        int[] arrayValue = new int[10]; // создание массива для заполнения
        for (int i = 0; i < arrayValue.length; i++) { // цикл заполнение массива случайным числом
            if (i % 2 == 0) { // если индексы чётные то это координата X
                arrayValue[i] = random.nextInt(1044);
            } else { // иначе если индексы нечётные то это координата по оси Y
                arrayValue[i] = random.nextInt(1510);
            }
        }
        return arrayValue;
    }

    // оздание слушателя
    private View.OnTouchListener listener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            // определение координат касания
            x = motionEvent.getX();
            y = motionEvent.getY();

            // определение типа касания
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN: // нажатие
                    coordinates.setText("Нажатие " + x + ", " + y);
                    break;
                case MotionEvent.ACTION_MOVE: // движение
                    coordinates.setText("Движение " + x + ", " + y);
                    if (x >= (coordinatesKeys[0] - interval) && x <= (coordinatesKeys[0] + interval) && y >= (coordinatesKeys[1] - interval) && y <= (coordinatesKeys[1] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден первый ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[2] - interval) && x <= (coordinatesKeys[2] + interval) && y >= (coordinatesKeys[3] - interval) && y <= (coordinatesKeys[3] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден второй ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[4] - interval) && x <= (coordinatesKeys[4] + interval) && y >= (coordinatesKeys[5] - interval) && y <= (coordinatesKeys[5] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден третий ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[6] - interval) && x <= (coordinatesKeys[6] + interval) && y >= (coordinatesKeys[7] - interval) && y <= (coordinatesKeys[7] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден четвёртый ключ", Toast.LENGTH_SHORT).show();
                    } else if (x >= (coordinatesKeys[8] - interval) && x <= (coordinatesKeys[8] + interval) && y >= (coordinatesKeys[9] - interval) && y <= (coordinatesKeys[9] + interval)) {
                        Toast.makeText(MainActivity.this, "Найден пятый ключ", Toast.LENGTH_SHORT).show();
                    }
                        break;
                case MotionEvent.ACTION_UP: // отпускание
                    coordinates.setText("Отпускание " + x + ", " + y);
                    break;
            }

            return true;
        }
    };
}




