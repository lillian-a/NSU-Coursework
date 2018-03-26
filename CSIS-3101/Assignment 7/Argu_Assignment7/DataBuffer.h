/* Author:	Lillian Arguelles
 * Project:	Assignment 7
 * File:	DataBuffer.h
 * Date:	March 7 2016
 */
#pragma once

class DataBuffer
{
protected:	
	static const int BUFFER_SIZE = 256;
	int buffer[BUFFER_SIZE];
	int length;

public:
	DataBuffer();
	~DataBuffer();
	bool copyData(int buff[], int length);
	void print();
	int sum();
	double mean();
	int maxValue();
	int minValue();
	int range();
};

