package com.example.enetcom.roomwordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {
  //  public static final String EXTRA_REPLY =
      //      "com.example.android.roomwordssample.REPLY";
  public static final String EXTRA_REPLY = "com.example.roomwordssample.REPLY";
    public static final String EXTRA_REPLY_ID = "com.android.roomwordssample.REPLY_ID";
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private EditText mEditWordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        mEditWordView = findViewById(R.id.edit_word);
        setContentView(R.layout.activity_new_word);

        mEditWordView = findViewById(R.id.edit_word);
        int id = -1 ;

        final Bundle extras = getIntent().getExtras();

        // Si nous recevons du contenu, remplissez-le pour que l'utilisateur puisse le modifier.
        if (extras != null) {
            String word = extras.getString(MainActivity.EXTRA_DATA_UPDATE_WORD, "");
            if (!word.isEmpty()) {
                mEditWordView.setText(word);
                mEditWordView.setSelection(word.length());
                mEditWordView.requestFocus();
            }
        } // Sinon, commencez par des champs vides.

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = mEditWordView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    if (extras != null && extras.containsKey(MainActivity.EXTRA_DATA_ID)) {
                        int id = extras.getInt(MainActivity.EXTRA_DATA_ID, -1);
                        if (id != -1) {
                            replyIntent.putExtra(EXTRA_REPLY_ID, id);
                        }
                    }
                    // Définir le statut du résultat pour indiquer le succès.
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }



}