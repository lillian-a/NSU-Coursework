/* Author:	Lillian Arguelles
* Project:	Assignment 8
* File:		IterableDataBuffer.h
* Date:		March 7 2016
*/

#pragma once
#include "DataBuffer.h"
class DataBufferIterator;
class Iterator;
//#include "DataBufferIterator.h"

class IterableDataBuffer : public DataBuffer
{
public:
	friend class DataBufferIterator;
	Iterator* createIterator();
};

