/* Author:	Lillian Arguelles
* Project:	Assignment 8
* File:		DataBufferIterator.cpp
* Date:		March 7 2016
*/

#include "DataBufferIterator.h"

DataBufferIterator::DataBufferIterator(IterableDataBuffer* collection) {
	cursor = 0;
	this->collection = collection;
}
//DataBufferIterator::~DataBufferIterator() {
//}
void DataBufferIterator::first() {
	cursor = 0;
}

void DataBufferIterator::next() {
	if (!isDone()) {
		cursor++;
	}
}

bool DataBufferIterator::isDone() {
	return cursor >= collection->length;
}

int DataBufferIterator::currentItem() {
	if (isDone()) {
		return 0;
	}
	else {
		return collection->buffer[cursor];
	}
}