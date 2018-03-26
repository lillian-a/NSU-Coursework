/* Author:	Lillian Arguelles
* Project:	Assignment 8
* File:		Iterator.h
* Date:		March 7 2016
*/
//
// File: Iterator.h
// Project: GoF Iterator in C++
// Author: Lillian Arguelles
// Version: 1.0 February 5, 2015
//
// Copyright (c) Michael Van Hilst 2015 All rights reserved.
//


class Iterator {
public:
	virtual void first() = 0;
	virtual void next() = 0;
	virtual int currentItem() = 0;
	virtual bool isDone() = 0;
};