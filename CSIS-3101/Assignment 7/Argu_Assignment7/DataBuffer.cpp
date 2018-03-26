/* Author:	Lillian Arguelles
 * Project:	Assignment 7
 * File:	DataBuffer.cpp
 * Date:	March 7 2016
 */
#include <iostream>
#include <iomanip>
#include "DataBuffer.h"
#include "OrderedDataBuffer.h"
using namespace std;



DataBuffer::DataBuffer() {
	length = 0;
}


DataBuffer::~DataBuffer() {
}

bool DataBuffer::copyData(int buff[], int len) {
	if (length > BUFFER_SIZE) {
		return false;
	}
	else {
		for (int i = 0; i < len; i++) {
			buffer[i] = buff[i];
		}
		length = len;
		return true;
	}
}

void DataBuffer::print() {
	int width = 7;
	for (int i = 0, j = 1; i < length; i++, j++) {
		cout << setw(width) << buffer[i];
		if (j == 10) {
			j = 0;
			cout << endl;
		}
	}
	cout << endl;
}

int DataBuffer::sum() {
	int sum = 0;
	for (int i = 0; i < length; i++) {
		sum += buffer[i];
	}
	return sum;
}

double DataBuffer::mean() {
	double mean = ((double)sum() / (double)length);
	return mean;
}

int DataBuffer::maxValue() {
	int max = buffer[0];
	for (int i = 1; i < length; i++) {
		if (buffer[i] > max) {
			max = buffer[i];
		}
	}
	return max;
}

int DataBuffer::minValue() {
	int min = buffer[0];
	for (int i = 1; i < length; i++) {
		if (buffer[i] < min) {
			min = buffer[i];
		}
	}
	return min;
}

int DataBuffer::range() {
	int range = maxValue() - minValue();
	return range;
}
