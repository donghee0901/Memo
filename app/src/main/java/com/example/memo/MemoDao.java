package com.example.memo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MemoDao {
    @Query("SELECT * FROM MemoEntity")
    List<MemoEntity> getMemoAll();

    @Query("SELECT * FROM MemoEntity WHERE id = (:id)")
    MemoEntity getMemoById(int id);

    @Query("SELECT count(*) FROM MemoEntity")
    int getCount();

    @Query("SELECT max(id) FROM MemoEntity")
    int getMaxCount();

    @Query("DELETE FROM MemoEntity")
    void deleteAll();

    @Insert
    void insert(MemoEntity user);

    @Update
    void update(MemoEntity user);

    @Delete
    void delete(MemoEntity user);
}
