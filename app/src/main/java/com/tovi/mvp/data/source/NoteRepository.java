package com.tovi.mvp.data.source;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.tovi.mvp.data.Note;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */
public class NoteRepository implements NoteDataSource {
    private static NoteRepository source;

    private Note note;

    public static NoteRepository getInstance() {
        if (null == source) {
            source = new NoteRepository();
        }
        return source;
    }

    public void getNote(@NonNull NoteDataSource.GetTaskCallback getTaskCallback) {
        checkNotNull(getTaskCallback);

        if (isEmpty()) {
            getTaskCallback.onNoData();
        }
        getTaskCallback.onNoteLoaded(note);
    }

    public void saveNote(@NonNull Note note) {
        checkNotNull(note);
        this.note = note;
    }

    private boolean isEmpty() {
        if (null == note) {
            return true;
        }
        if (TextUtils.isEmpty(note.getmTitle()) && TextUtils.isEmpty(note.getmContent())) {
            return false;
        }
        return true;
    }
}
