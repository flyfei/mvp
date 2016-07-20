package com.tovi.mvp.addnote;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tovi.mvp.R;
import com.tovi.mvp.data.source.NoteRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener, AddNoteContract.View {


    private EditText editTitle;
    private EditText editContent;
    private AddNoteContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTitle = (EditText) findViewById(R.id.note_title);
        editContent = (EditText) findViewById(R.id.note_content);
        findViewById(R.id.btn_save).setOnClickListener(this);

        new AddNotePresenter(this, NoteRepository.getInstance(getApplicationContext()));
    }

    @Override
    public void showName(String name) {
        editTitle.setText(name);
    }

    @Override
    public void showContent(String content) {
        editContent.setText(content);
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(@NonNull AddNoteContract.Presenter mPresenter) {
        this.mPresenter = checkNotNull(mPresenter);
    }

    @Override
    public void onClick(View view) {
        this.mPresenter.saveNote(editTitle.getText().toString(), editContent.getText().toString());
    }
}
