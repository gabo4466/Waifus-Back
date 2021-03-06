package com.waifus.model;

import com.waifus.daoImp.UserDaoImp;
import com.waifus.exceptions.UserException;
import com.waifus.exceptions.UserNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private int idUser;
    private String gender;
    private boolean adultContent;
    private String nickname;
    private boolean admin;
    private String name;
    private String email;
    private String password;
    private String birthday;
    private String profilePhoto;
    private String country;
    private String description;
    private int karma;
    private String theme;
    private boolean activated;
    private boolean banned;
    private String repPass;

    /**
     * Constructor vacio
     */
    public User() {
    }

    /**
     * Constructor que se utiliza para el login
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor que se utiliza en el login
     * @param idUser
     * @param email
     * @param activated
     * @param banned
     */
    public User(int idUser, String email, boolean activated, boolean banned) {
        this.idUser = idUser;
        this.email = email;
        this.activated = activated;
        this.banned = banned;
    }

    /**
     * Contructor empleado en el perfil
     * @param idUser
     * @param gender
     * @param adultContent
     * @param nickname
     * @param admin
     * @param name
     * @param email
     * @param birthday
     * @param profilePhoto
     * @param country
     * @param description
     * @param karma
     * @param theme
     */
    public User(int idUser, String gender, boolean adultContent, String nickname, boolean admin, String name, String email, String birthday, String profilePhoto, String country, String description, int karma, String theme) {
        this.idUser = idUser;
        this.gender = gender;
        this.adultContent = adultContent;
        this.nickname = nickname;
        this.admin = admin;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.profilePhoto = profilePhoto;
        this.country = country;
        this.description = description;
        this.karma = karma;
        this.theme = theme;
    }

    public User(int idUser, String gender, boolean adultContent, String nickname, boolean admin, String name, String email, String password, String birthday, String profilePhoto, String country, String description, int karma, String theme, boolean activated, boolean banned, String repPass) {
        this.idUser = idUser;
        this.gender = gender;
        this.adultContent = adultContent;
        this.nickname = nickname;
        this.admin = admin;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.profilePhoto = profilePhoto;
        this.country = country;
        this.description = description;
        this.karma = karma;
        this.theme = theme;
        this.activated = activated;
        this.banned = banned;
        this.repPass = repPass;
    }

    public User(int idUser, String gender, String nickname, String name, String profilePhoto, String country, String description, int karma) {
        this.idUser = idUser;
        this.gender = gender;
        this.nickname = nickname;
        this.name = name;
        this.profilePhoto = profilePhoto;
        this.country = country;
        this.description = description;
        this.karma = karma;
    }

    public User(String nickname, String name, String email, String password) {
        this.nickname = nickname;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Contructor para establezer conexion con la BD
     * @param idUser
     */
    public User(int idUser) {
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isAdultContent() {
        return adultContent;
    }

    public void setAdultContent(boolean adultContent) {
        this.adultContent = adultContent;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public String getRepPass() {
        return repPass;
    }

    public void setRepPass(String repPass) {
        this.repPass = repPass;
    }

    /**
     * @see com.waifus.daoImp.UserDaoImp#logIn(User) 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserException
     * @throws IOException
     */
    public User logIn() throws SQLException, ClassNotFoundException, UserException, IOException, UserNotFoundException {
        return UserDaoImp.getInstance().logIn(this);
    }

    /**
     * @see com.waifus.daoImp.UserDaoImp#add(User) 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws UserException
     * @throws IOException
     */
    public User register() throws SQLException, ClassNotFoundException, UserException, IOException, UserNotFoundException {
        return UserDaoImp.getInstance().add(this);
    }

    public User get() throws SQLException, ClassNotFoundException, UserNotFoundException {
        return UserDaoImp.getInstance().get(this.idUser);
    }

    public boolean update() throws SQLException, ClassNotFoundException, UserException {
        return UserDaoImp.getInstance().update(this);
    }

    public boolean emailCheck() throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().emailCheck(this);
    }

    public boolean nicknameCheck() throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().nicknameCheck(this);
    }

    public int getId() throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().getId(this);
    }

    public boolean delete() throws SQLException, ClassNotFoundException, UserException {
        return UserDaoImp.getInstance().delete(this);
    }

    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().getAll();
    }

    public ArrayList<User> search(int idx, int pag, String term) throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().search(idx, pag, term);
    }

    public int count(String term) throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().count(term);
    }

    public ArrayList<User>  mostKarmaUsers() throws SQLException, ClassNotFoundException {
        return UserDaoImp.getInstance().mostKarmaUsers();
    }

    public void karmaChange(int i) throws SQLException, ClassNotFoundException, UserException {
        this.karma += i;
        UserDaoImp.getInstance().karmaChange(this);
    }
}
