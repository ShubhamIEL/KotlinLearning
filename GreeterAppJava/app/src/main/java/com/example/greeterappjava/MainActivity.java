//package com.example.greeterappjava;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText nameEditText;
//    private Button greetButton;
//    private TextView greetingTextView;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        nameEditText =findViewById(R.id.nameEditText);
//        greetButton = findViewById(R.id.greetButton);
//        greetingTextView =findViewById(R.id.greetingTextView);
//
//        greetButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                handleGreetClick();
//            }
//        });
//    }
//    private void handleGreetClick(){
//        String name = nameEditText.getText().toString();
//        if(name.trim().isEmpty()){
//            greetingTextView.setText("PLease ENTER a NAME!");
//        }else{
//            String greetingMessage = "Hello, "+ name + " !";
//            greetingTextView.setText(greetingMessage);
//        }
//
//
//    }
//}