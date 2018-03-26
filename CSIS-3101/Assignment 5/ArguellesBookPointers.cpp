/*
 * File:    ArguellesBookPointers.cpp
 * Proj:    Assignment 5
 * Author:  Lillian Arguelles
 * Hisory:  February 15, 2016 initial version
*/
#include "Book.h"
using namespace std;

int main1();
int main2();

int main() {
    main1();
    main2();
}

int main1() {
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

int main2() {
    Book* ptrTextbook = new Book();
    Book* ptrReference = new Book();
    Book* ptrAlternateRef = new Book();
    ptrTextbook->setTitle("Big Java: Early Objects");
    ptrTextbook->setAuthor("Cay S. Horstmann");
    ptrTextbook->setEdition(5);
    ptrTextbook->setYear(2013);
    ptrTextbook->setPublisher("John Wiley & Sons");
    ptrReference->setTitle("Java for Dummies");
    ptrReference->setAuthor("Barry Burd, PhD");
    ptrReference->setPublisher(ptrTextbook->getPublisher());
    ptrReference->setEdition(6);
    ptrReference->setYear(2014);
    ptrAlternateRef->setTitle("Java for Everyone: Late Objects");
    ptrAlternateRef->setAuthor(ptrTextbook->getAuthor());
    ptrAlternateRef->setEdition(2);
    ptrAlternateRef->setYear(2012);
    ptrAlternateRef->setPublisher(ptrTextbook->getPublisher());
    ptrTextbook->show();
    ptrReference->show();
    ptrAlternateRef->show();
    return 0;
}