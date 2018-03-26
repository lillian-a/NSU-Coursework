/*
 * File:    Book.h
 * Project: Assignment 4
 * Author:  Lillian Arguelles
 * Hisory:  February 14, 2016 initial version
 */
#include <string>
using namespace std;

#pragma once
class Book
{
	string title;
	string author;
	string publisher;
	int year;
	int edition;

public:
	Book();
	~Book();
	void setTitle(string title);
	void setAuthor(string author);
	void setPublisher(string publisher);
	void setYear(int year);
	void setEdition(int edition);
	string getTitle();
	string getAuthor();
	string getPublisher();
	int getYear();
	int getEdition();
	void show();
};

