/* Author:	Lillian Arguelles
* Project:	Assignment 7
* File:	OrderedDataBuffer.h
* Date:	March 7 2016
*/
#include <iostream>
#include "OrderedDataBuffer.h"
using namespace std;

void OrderedDataBuffer::shiftUpOne(int index) {
	length++;
	for (int i = length; i >= index; i--) {
		buffer[i] = buffer[i - 1];
	}
}

void OrderedDataBuffer::shiftDownOne(int index) {
	for (int i = index; i < length; i++) {
		buffer[i] = buffer[i + 1];
	}
	length--;
}

OrderedDataBuffer::OrderedDataBuffer() {

}


OrderedDataBuffer::~OrderedDataBuffer() {

}

void OrderedDataBuffer::add(int value) {
	int i;
	for (i = 0; i < length && buffer[i] < value; i++);
	shiftUpOne(i);
	buffer[i] = value;
}

void OrderedDataBuffer::remove(int value) {
	int i, j;
	for (j = 0; buffer[j] < length; j++) {
		if (buffer[j] == value) {
			shiftDownOne(j);
			j = 0;
		}
	}
}

bool OrderedDataBuffer::copyData(int buff[], int len) {
	if (length > BUFFER_SIZE) {
		return false;
	}
	else {
		for (int i = 0; i < len; i++) {
			//cout << i << " " << buff[i] << endl;
			int temp = buff[i];
			add(temp);
		}
		length = len;
		return true;
	}
}
