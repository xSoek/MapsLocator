package com.example.retomapssave.Dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class LocationDao_Impl implements LocationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Location> __insertionAdapterOfLocation;

  public LocationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocation = new EntityInsertionAdapter<Location>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Location` (`id`,`street`,`city`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Location value) {
        stmt.bindLong(1, value.getId());
        if (value.getStreet() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStreet());
        }
        if (value.getCity() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCity());
        }
      }
    };
  }

  @Override
  public Object insert(final Location location, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocation.insert(location);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAll(final Continuation<? super List<Location>> p0) {
    final String _sql = "SELECT * FROM location";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Location>>() {
      @Override
      public List<Location> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStreet = CursorUtil.getColumnIndexOrThrow(_cursor, "street");
          final int _cursorIndexOfCity = CursorUtil.getColumnIndexOrThrow(_cursor, "city");
          final List<Location> _result = new ArrayList<Location>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Location _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpStreet;
            _tmpStreet = _cursor.getString(_cursorIndexOfStreet);
            final String _tmpCity;
            _tmpCity = _cursor.getString(_cursorIndexOfCity);
            _item = new Location(_tmpId,_tmpStreet,_tmpCity);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
