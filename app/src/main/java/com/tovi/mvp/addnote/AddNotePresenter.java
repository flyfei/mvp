package com.tovi.mvp.addnote;

import android.support.annotation.NonNull;

import com.tovi.mvp.data.Note;
import com.tovi.mvp.data.source.NoteDataSource;
import com.tovi.mvp.data.source.NoteRepository;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */
public class AddNotePresenter implements AddNoteContract.Presenter, NoteDataSource.GetTaskCallback {

    @NonNull
    private final AddNoteContract.View mView;

    @NonNull
    private final NoteRepository mNoteRepository;

    public AddNotePresenter(@NonNull AddNoteContract.View view, @NonNull NoteRepository noteRepository) {
        this.mView = checkNotNull(view);
        this.mNoteRepository = checkNotNull(noteRepository);
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        mNoteRepository.getNote(this);
    }

    @Override
    public void stop() {

    }

    @Override
    public void saveNote(String name, String content) {
        Note note = new Note(name, content);
        if (note.isEmpty()) {
            mView.toast("name or content is null");
            return;
        }
        mNoteRepository.saveNote(note);
        mView.toast("success");
    }

    @Override
    public void onNoteLoaded(Note note) {
        mView.showName(note.getmTitle());
        mView.showContent(note.getmContent());
    }

    @Override
    public void onNoData() {
        mView.toast("Sorry, No Data");
    }

}
