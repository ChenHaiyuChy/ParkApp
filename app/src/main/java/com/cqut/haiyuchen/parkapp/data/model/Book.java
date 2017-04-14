package com.cqut.haiyuchen.parkapp.data.model;

import java.util.List;
import java.util.Map;

/**
 * Created by haiyu.chen on 2017/4/11.
 */

public class Book {
  private int count;
  private int start;
  private int total;
  private List<Map<String, Object>> books;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<Map<String, Object>> getBooks() {
    return books;
  }

  public void setBooks(List<Map<String, Object>> books) {
    this.books = books;
  }

  @Override public String toString() {
    return "Book{" +
        "count=" + count +
        ", start=" + start +
        ", total=" + total +
        ", books=" + books +
        '}';
  }
}
