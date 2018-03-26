/* Author:	Lillian Arguelles
* Project:	Assignment 7
* File:	OrderedDataBuffer.h
* Date:	March 7 2016
*/
#pragma once
#include "DataBuffer.h"

class OrderedDataBuffer : public DataBuffer
{
protected:
	void shiftUpOne(int index);
	void shiftDownOne(int index);
public:
	OrderedDataBuffer();
	~OrderedDataBuffer();
	void add(int value);
	void remove(int value);
	bool copyData(int buff[], int len);
};

