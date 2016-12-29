package a1221.org.il.hatsalaquestionaire.database;

/**
 * Created by Daniel on 12/28/2016.
 */

public class AppContract {

    public static class Question {
        public static final String _ID = "_id";
        public static final String TITLE = "title";
    }

    public static class Tag {
        public static final String _ID = "_id";
        public static final String TEXT = "text";
        public static final String Q_ID = "q_id";
    }

    public static class Answer {
        public static final String _ID = "_id";
        public static final String isScale = "isScale";
        public static final String Q_ID = "q_id";

    }

    public static class QTranslation {
        public static final String _ID = "_id";
        public static final String Q_ID = "q_id";
        public static final String LANGUAGE = "language";
        public static final String TEXT = "text";
    }

    public static class ATranslation {
        public static final String _ID = "_id";

        public static final String A_ID = "a_id";
        public static final String LANGUAGE = "language";
        public static final String TEXT = "text";
    }

    public static class Category {
        public static final String _ID = "_id";
        public static final String NAME = "name";
        public static final String FATHER_ID = "father_id";
    }

    public static class Language {
        public static final String _ID = "_id";
        public static final String TEXT = "text";
        public static final String SORT_ID = "sort_id";
    }

    public static class CatQ {
        public static final String _ID = "_id";
        public static final String C_ID = "c_id";
        public static final String Q_ID = "q_id";
    }
}
