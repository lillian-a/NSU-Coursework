//
// File: Argu_Ass3.cpp
// Project: CSIS 3101 Assignment 3
// Author: Lillian Arguelles
// History: Version 1.2 January 21, 2016
//

#include <iostream>
using namespace std;
// PROTOTYPES
void step1();
void step2();
void step3();
void step4();

int main(int argc, const char * argv[]) {
    
    step1();
    step2();
    step3();
    step4();
    return 0;
    
}

void step1(){
    // STEP 1
    
    int number_1;
    cout << "Enter a number between 1 and 20:" << endl;
    cin >> number_1;
    cout << "You entered a " << number_1 << endl;
}

void step2(){
    // STEP 2
    
    int number_2;
    cout << "Enter a number between 1 and 20:" << endl;
    cin >> number_2;
    // check if number is between 1 and 20
    if(number_2 >=1 && number_2 <= 20){
        cout << "You entered a " << number_2 << endl;
    }
    else{
        cout << "The value you entered is not"
        << " between 1 and 20." << endl;
    }
}

void step3(){
    // STEP 3
    
    int number_3;
    cout << "Enter a number between 1 and 20:" << endl;
    cin >> number_3;
    // check if number is between 1 and 20
    if(number_3 >=1 && number_3 <= 20)
    {
        // check if number is an 8 or an 11
        if(number_3 == 8 || number_3 == 11 || number_3 == 18)
        {
            cout << "You entered an " << number_3 << endl;
        }
        else{
            cout << "You entered a " << number_3 << endl;
        }
    }
    else{
        cout << "The value you entered is not"
        << " between 1 and 20." << endl;
    }
}

void step4(){
    // STEP 4
    
    int number_4;
    cout << "Enter a number between 1 and 20:" << endl;
    cin >> number_4;
    // check if cin failed
    if(cin.fail())
    {
        cout << "Idiot! Your input could not be read "
        << "as a number. Get a life!" << endl;
    }
    else
    {
        // check if number is between 1 and 20
        if(number_4 >=1 && number_4 <= 20)
        {
            // check if number is an 8 or an 11
            if(number_4 == 8 || number_4 == 11 || number_4 == 18){
                cout << "You entered an " << number_4 << endl;
            }
            else{
                cout << "You entered a " << number_4 << endl;
            }
        }
        else
        {
            cout << "The value you entered is not"
            << " between 1 and 20." << endl;
        }
        
    }
}
