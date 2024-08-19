package model;

import java.util.Date;

public interface IBookable {
    void book(Date date, String time);
}