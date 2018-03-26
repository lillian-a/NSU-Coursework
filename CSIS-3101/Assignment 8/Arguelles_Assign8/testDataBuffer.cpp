/* Author:	Lillian Arguelles
* Project:	Assignment 8
* File:		testDataBuffer.cpp
* Date:		March 7 2016
*/

#include <iostream>
#include "DataBuffer.h"
#include "IterableDataBuffer.h"
#include "Iterator.h"
using namespace std;

void testDataBuffer(int arr[], int length);
void testIterableDataBuffer(int arr[], int length);

int main() {
	const int ARR0_LEN = 2;
	int arr0[ARR0_LEN] = { -2, -1 };
	const int ARR1_LEN = 10;
	int arr1[ARR1_LEN] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	const int ARR2_LEN = 25;
	int arr2[ARR2_LEN] = { 2, 4, 6, 8, 10, 12, 14, 16, 7, 6, 22, 8,
		9, 16, 5, 2, 7, 8, 12, 2, 0, 14, 17, 19, 22 };
	testDataBuffer(arr0, ARR0_LEN);
	testDataBuffer(arr1, ARR1_LEN);
	testDataBuffer(arr2, ARR2_LEN);
	testIterableDataBuffer(arr1, ARR1_LEN);
	testIterableDataBuffer(arr2, ARR2_LEN);
	return 0;
}
void testDataBuffer(int arr[], int length) {
	IterableDataBuffer data;
	data.copyData(arr, length);
	cout << endl; // blank line
	data.print();
	cout << "Sum " << data.sum() << endl;
	cout << "Min " << data.minValue() << endl;
	cout << "Max " << data.maxValue() << endl;
	cout << "Range " << data.range() << endl;
	cout << "Mean " << data.mean() << endl;

}
void testIterableDataBuffer(int arr[], int length) {
	IterableDataBuffer data;
	data.copyData(arr, length);
	cout << "\n Ordered data buffer" << endl;
	data.print();
	Iterator* iter1 = data.createIterator();
	iter1->next();
	cout << "The first iterator is on " << iter1->currentItem()
		<< endl;
	Iterator* iter2 = data.createIterator();
	cout << "Using the second iterator: " << endl;
	for (iter2->first(); !iter2->isDone(); iter2->next())
		cout << iter2->currentItem() << " ";
	cout << endl;
	cout << "The first iterator is still on " << iter1->currentItem()
		<< endl;
	delete iter1;
	delete iter2;
}