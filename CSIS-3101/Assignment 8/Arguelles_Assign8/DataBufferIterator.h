/* Author:	Lillian Arguelles
 * Project:	Assignment 8
 * File:	DataBufferIterator.cpp
 * Date:	March 7 2016
 */
// File: DataBufferIterator.h
// Project: GoF Iterator in C++
// Author: Michael Van Hilst
// Version: 1.0 February 5, 2015
// Copyright (c) Michael Van Hilst 2015 All rights reserved.

#pragma once
#include "Iterator.h"
#include "IterableDataBuffer.h"

class DataBufferIterator : public Iterator {
protected:
	IterableDataBuffer* collection;
	int cursor;
public:
	DataBufferIterator(IterableDataBuffer* collection);
	//~DataBufferIterator();
	void first();
	void next();
	bool isDone();
	int currentItem();
};