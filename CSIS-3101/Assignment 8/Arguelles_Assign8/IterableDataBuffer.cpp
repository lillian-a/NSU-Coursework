/* Author:	Lillian Arguelles
* Project:	Assignment 8
* File:		IterableDataBuffer.cpp
* Date:		March 7 2016
*/

#pragma once
#include "IterableDataBuffer.h"
#include "DataBufferIterator.h"

Iterator* IterableDataBuffer::createIterator() {
	Iterator* ptr = new DataBufferIterator(this);
	return ptr;
}
