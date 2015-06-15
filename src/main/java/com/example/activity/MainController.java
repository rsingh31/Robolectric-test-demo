package com.example.activity;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.userdata.DaoMaster;
import com.example.userdata.DaoSession;
import com.example.userdata.Favorite;
import com.example.userdata.FavoriteDao;

public class MainController {

    private static SQLiteDatabase db;
    private static DaoMaster daoUserMaster;
    private static DaoSession daoUserSession;
    private static FavoriteDao favoriteDao;
    private static Favorite favorite;


    public static  void getUserDaoInstance(Context context) {
        if (daoUserSession == null) {
           DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,
                  "UserData.sqlite", null);
            db = helper.getWritableDatabase();
            daoUserMaster = new DaoMaster(db);
            daoUserSession = daoUserMaster.newSession();
            favoriteDao = daoUserSession.getFavoriteDao();
            favorite = new Favorite();
        }

    }

    public static void addRecent(long externalid) {


            favorite.setCreationDate(System.currentTimeMillis());
            favorite.setExternalId(externalid);
            favorite.setObject("Lab");
            favorite.setSearchName("Search");
            favorite.setSortOrder((long) 1);
            favoriteDao.insertOrReplace(favorite);
        }
    }

