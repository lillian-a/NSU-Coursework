/*
* File:    Book.cpp
* Project: Assignment 4
* Author:  Lillian Arguelles
* Hisory:  February 14, 2016 initial version
*/

#include <iostream>
#include "Book.h"
using namespace std;


Book::Book()
{
}


Book::~Book()
{
}

void Book::setTitle(string title){
	this->title = title;
}
void Book::setAuthor(string author){
	this->author = author;
}
void Book::setPublisher(string publisher){
	this->publisher = publisher;
}
void Book::setYear(int year){
	this->year = year;
}
void Book::setEdition(int edition){
	this->edition = edition;
}
string Book::getTitle(){
	return title;
}
string Book::getAuthor(){
	return author;
}
string Book::getPublisher(){
	return publisher;
}
int Book::getYear(){
	return year;
}
int Book::getEdition(){
	return edition;
}

void Book::show() {
	cout << title << " " << author << endl;

}