package com.tovi.mvp.data;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.google.common.base.Objects;

import java.util.UUID;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */
public class Note {
    private String mId;
    private String mTitle;
    private String mContent;
    private boolean isCompleted;

    public Note(String mTitle, @Nullable String mContent) {
        this.mId = UUID.randomUUID().toString();
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(mTitle) || TextUtils.isEmpty(mContent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return Objects.equal(mId, note.mId) && Objects.equal(mTitle, note.mTitle) && Objects.equal(mContent, note.mContent);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mTitle, mContent);
    }

    @Override
    public String toString() {
        return "Note`s title " + mTitle;
    }
}
