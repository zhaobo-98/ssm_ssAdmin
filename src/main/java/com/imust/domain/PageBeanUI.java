package com.imust.domain;

public class PageBeanUI {
    private Integer pageNumber =1 ;
    private Integer pageSize = 6;
    private Integer navigatePages = 10;
    private User user;
    private Room room;
    private BedRoom bedRoom;
    private User loginUser;
    private Student student;
    private Dormitory dormitory;
    private Integer bedId;
    private Integer stuId;

    @Override
    public String toString() {
        return "PageBeanUI{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", navigatePages=" + navigatePages +
                ", user=" + user +
                ", room=" + room +
                ", bedRoom=" + bedRoom +
                ", loginUser=" + loginUser +
                ", student=" + student +
                ", dormitory=" + dormitory +
                ", bedId=" + bedId +
                ", stuId=" + stuId +
                ", startIndex=" + startIndex +
                '}';
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(Integer navigatePages) {
        this.navigatePages = navigatePages;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public BedRoom getBedRoom() {
        return bedRoom;
    }

    public void setBedRoom(BedRoom bedRoom) {
        this.bedRoom = bedRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    private Integer startIndex;

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getStartIndex() {
        startIndex = (pageNumber-1)*pageSize;
        return startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }



    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
