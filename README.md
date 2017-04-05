# ParkApp 

![](./file/ic_launcher.png) 
 
My Graduation Project.

## Introduction

### Description

This project is just my graduation design.

> The project is hosted on GitHub, and it is a public project. if I want to modify the code on other computer, I should configuration my SSH Key on it.

### Include

* 1 Rent and rented

* 2 Service

* 3 Mine

## Remark

* This projet was created on 2017-04-05.

    <font color=#ff0000>**I want to end it before 2017-04-22, god bless me.**</font>

* Don't forget bind view by annotation.

	<font color=#0099ff>Example:</font>

`public class ServiceActivity extends BaseActivity {`

  `@BindView(R.id.list_view) OnScrollListView listView;`

  `@BindView(R.id.empty_view) TextView emptyView;`

  `List<Map<String, Object>> list = new ArrayList<>();`

  `ListViewAdapter adapter;`

  `@Override public int layoutResId() {`

    `return R.layout.activity_service;`

  `}`

`}`