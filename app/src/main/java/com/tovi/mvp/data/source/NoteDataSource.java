package com.tovi.mvp.data.source;

import com.tovi.mvp.data.Note;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */
public interface NoteDataSource {
    interface GetTaskCallback {
        void onNoteLoaded(Note note);

        void onNoData();
    }

    void saveNote(Note note);
}
