package com.waifus.dao;

import com.waifus.exceptions.*;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericDao<G> {
    public boolean update(G obj) throws SQLException, Exception;
    public boolean delete(G obj) throws SQLException, UserException, ChannelException, ThreadException, MultimediaException, CommentException, FollowChannelException;
    public G add(G obj) throws SQLException, Exception;
    public ArrayList<G> getAll() throws SQLException, ChannelNotFoundException;
    public ArrayList<G> search(int idx, int pag, String term) throws SQLException;
    public G get(int id) throws SQLException, Exception;
    public int count(String term) throws SQLException;
}
