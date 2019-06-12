package com.imust.domain;

public class PageBeanUI {
    private Integer pageNumber =1 ;
    private Integer pageSize = 2;
    private User user;
    private Room room;
    private Dormitory dormitory;
    private BedRoom bedRoom;

    @Override
    public String toString() {
        return "PageBeanUI{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", user=" + user +
                ", room=" + room +
                ", dormitory=" + dormitory +
                ", bedRoom=" + bedRoom +
                ", startIndex=" + startIndex +
                '}';
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
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
