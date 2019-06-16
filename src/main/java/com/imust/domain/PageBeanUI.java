package com.imust.domain;

public class PageBeanUI {
    private Integer pageNumber =1 ;
    private Integer pageSize = 5;
    private Integer navigatePages = 10;
    private User user;
    private Room room;
    private BedRoom bedRoom;
    private User loginUser;

    @Override
    public String toString() {
        return "PageBeanUI{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", user=" + user +
                ", room=" + room +
                ", bedRoom=" + bedRoom +
                ", loginUser=" + loginUser +
                ", startIndex=" + startIndex +
                '}';
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
