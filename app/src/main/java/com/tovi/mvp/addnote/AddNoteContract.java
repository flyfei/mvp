package com.tovi.mvp.addnote;

import com.tovi.mvp.BasePresenter;
import com.tovi.mvp.BaseView;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */
public interface AddNoteContract {

    interface View extends BaseView<Presenter> {
        void showName(String name);

        void showContent(String content);

        void toast(String msg);
    }

    interface Presenter extends BasePresenter {
        void saveNote(String name, String content);
    }
}
