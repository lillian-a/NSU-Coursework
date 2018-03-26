/* Author:	Lillian Arguelles
 * Project:	Assignment 6
 * File:	testDataBuffer.cpp
 * Date:	March 7 2016
 */

#include <iostream>
#include "DataBuffer.h"
using namespace std;

void testDataBuffer(int arr[], int length);
int main() {
	const int ARR0_LEN = 2;
	int arr0[ARR0_LEN] = { -2,-1 };
	const int ARR1_LEN = 10;
	int arr1[ARR1_LEN] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	const int ARR2_LEN = 25;
	int arr2[ARR2_LEN] = { 2, 4, 6, 8, 10, 12, 14, 16, 7, 6, 22, 8, 9,
		16, 5, 2, 7, 8, 12, 2, 0, 14, 17, 19, 22 };
	testDataBuffer(arr0, ARR0_LEN);
	testDataBuffer(arr1, ARR1_LEN);
	testDataBuffer(arr2, ARR2_LEN);
	return 0;
}
void testDataBuffer(int arr[], int length) {
	DataBuffer buf;
	buf.copyData(arr, length);
	buf.print();
	cout << "Sum " << buf.sum() << endl;
	cout << "Min " << buf.minValue() << endl;
	cout << "Max " << buf.maxValue() << endl;
	cout << "Range " << buf.range() << endl;
	cout << "Mean " << buf.mean() << endl;

}