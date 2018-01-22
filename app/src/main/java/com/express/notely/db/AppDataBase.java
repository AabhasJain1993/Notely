package com.express.notely.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aabhas on
 */
public class AppDataBase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="todo";
    private static final String TABLE_TO_DO_ITEMS ="todoitems";
   // private static final String TABLE_UNANALYSED_PHOTOS="unanalysedphotos";
    //private static final String TABLE_FACE_VECTOR="facevector";

    private static final String KEY_ID="id";
    private static final String KEY_CATEGORY="category";
    private static final String KEY_ITEM_NUMBER="number";
    //private static final String KEY_DISPLAY_NAME="displayname";
    //private static final String KEY_IS_JUNK="isjunk";
    //private static final String KEY_IS_SHOW_THUMBNAILS="showthumbnails";
    private static final String KEY_PHOTO_TAG_INDEX="tagindex";
    private static final String KEY_CONFIDENCE="confidence";
    private static final String KEY_TAG_TIME="tagtime";
    //private static final String KEY_PHOTO_HASH="photohash";
    private static final String KEY_FACE_VECTOR="vector";


    private static AppDataBase appDataBase;

    public static synchronized AppDataBase getInstance(Context context){
        if(appDataBase==null){
            appDataBase= new AppDataBase(context.getApplicationContext());
        }
        return appDataBase;
    }

    private AppDataBase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        String CREATE_KNOWN_FOLDER_TABLE = "CREATE TABLE " + TABLE_KNOWN_FOLDER + "("
//                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_PATH + " TEXT, "
//                + KEY_DISPLAY_NAME + " TEXT, " + KEY_IS_JUNK +" INTEGER, "+ KEY_IS_SHOW_THUMBNAILS+ " INTEGER)";

      //  String CREATE_ITEMS_TABLE="CREATE TABLE "+ TABLE_TO_DO_ITEMS + "("
        //         + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ KEY_CATEGORY + " TEXT, "
      //          + KEY_ITEM_NUMBER + " INTEGER)";
        String CREATE_ITEMS_TABLE="CREATE TABLE "+ TABLE_TO_DO_ITEMS + "("
                 + KEY_CATEGORY + " TEXT PRIMARY KEY, "
                 + KEY_ITEM_NUMBER + " INTEGER)";
//        String CREATE_UNANALYSED_PHOTO_TABLE="CREATE TABLE "+ TABLE_UNANALYSED_PHOTOS + "("
//                + KEY_PATH+ " TEXT)";
//
//        String CREATE_FACE_VECTOR_TABLE="CREATE TABLE "+TABLE_FACE_VECTOR+"("
//                + KEY_PATH+" TEXT,"+KEY_FACE_VECTOR+" TEXT)";


       // db.execSQL(CREATE_KNOWN_FOLDER_TABLE);
        db.execSQL(CREATE_ITEMS_TABLE);
//        db.execSQL(CREATE_UNANALYSED_PHOTO_TABLE);
//        db.execSQL(CREATE_FACE_VECTOR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS"+TABLE_KNOWN_FOLDER);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_TO_DO_ITEMS);
        onCreate(db);
    }


}
