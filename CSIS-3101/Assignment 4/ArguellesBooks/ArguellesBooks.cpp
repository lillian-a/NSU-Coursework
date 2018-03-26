/*
* File:    ArguellesBooks.h
* Project: Assignment 4
* Author:  Lillian Arguelles
* Hisory:  February 14, 2016 initial version
*/

#include "Book.h"
using namespace std;


int main() {
	Book textbook;
	Book reference;
	Book alternateRef;
	textbook.setTitle("Big Java: Early Objects");
	textbook.setAuthor("Cay S. Horstmann");
	textbook.setEdition(5);
	textbook.setYear(2013);
	textbook.setPublisher("John Wiley & Sons");
	reference.setTitle("Java for Dummies");
	reference.setAuthor("Barry Burd, PhD");
	reference.setPublisher(textbook.getPublisher());
	reference.setEdition(6);
	reference.setYear(2014);
	alternateRef.setTitle("Java for Everyone: Late Objects");
	alternateRef.setAuthor(textbook.getAuthor());
	alternateRef.setEdition(2);
	alternateRef.setYear(2012);
	alternateRef.setPublisher(textbook.getPublisher());
	textbook.show();
	reference.show();
	alternateRef.show();
    return 0;
}
