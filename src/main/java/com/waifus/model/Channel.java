package com.waifus.model;

import com.waifus.daoImp.ChannelDaoImp;
import com.waifus.exceptions.ChannelException;
import com.waifus.exceptions.ChannelNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Channel {
    private int idChannel;
    private String dateChannel;
    private String description;
    private String photo;
    private String banner;
    private String name;
    private boolean deleted;
    private int user;

    private int threads;

    public Channel() {
    }

    public Channel(int idChannel) {
        this.idChannel = idChannel;
    }

    public Channel(int idChannel, String dateChannel, String description, String photo, String banner, String name, boolean deleted, int user) {
        this.idChannel = idChannel;
        this.dateChannel = dateChannel;
        this.description = description;
        this.photo = photo;
        this.banner = banner;
        this.name = name;
        this.deleted = deleted;
        this.user = user;
    }

    public Channel(int idChannel, String dateChannel, String description, String photo, String banner, String name, int user) {
        this.idChannel = idChannel;
        this.dateChannel = dateChannel;
        this.description = description;
        this.photo = photo;
        this.banner = banner;
        this.name = name;
        this.user = user;
    }

    public int getIdChannel() {
        return idChannel;
    }

    public void setIdChannel(int idChannel) {
        this.idChannel = idChannel;
    }

    public String getDateChannel() {
        return dateChannel;
    }

    public void setDateChannel(String dateChannel) {
        this.dateChannel = dateChannel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public Channel add() throws SQLException, ClassNotFoundException, ChannelException, IOException, ChannelNotFoundException {
        return ChannelDaoImp.getInstance().add(this);
    }

    public Channel get() throws SQLException, ClassNotFoundException, ChannelNotFoundException {
        return ChannelDaoImp.getInstance().get(this.idChannel);
    }

    public boolean update() throws SQLException, ClassNotFoundException, ChannelException {
        return ChannelDaoImp.getInstance().update(this);
    }

    public boolean delete() throws SQLException, ClassNotFoundException, ChannelException {
        return ChannelDaoImp.getInstance().delete(this);
    }

    public ArrayList<Channel> getall() throws SQLException, ClassNotFoundException {
        return ChannelDaoImp.getInstance().getAll();
    }

    public ArrayList<Channel> search(int idx, int pag, String term) throws SQLException, ClassNotFoundException {
        return ChannelDaoImp.getInstance().search(idx, pag, term);
    }

    public int count(String term) throws SQLException, ClassNotFoundException {
        return ChannelDaoImp.getInstance().count(term);
    }

    public boolean nameCheck() throws SQLException, ClassNotFoundException {
        return ChannelDaoImp.getInstance().nameCheck(this);
    }

    public ArrayList<Channel> channelsWMostThreads() throws SQLException, ClassNotFoundException {
        return ChannelDaoImp.getInstance().channelsWMostThreads();
    }

    public int count() throws SQLException, ClassNotFoundException {
        return ChannelDaoImp.getInstance().count(this.idChannel);
    }
}
