// author : mayur patil
// question link : https://leetcode.com/problems/roman-to-integer/


#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

class Solution {
public:
    int romanToInt(string s) {          
      unordered_map<char, int> o;
        o['I']=1;
        o['V']=5;
        o['X']=10;
        o['L']=50;
        o['C']=100;
        o['D']=500;
        o['M']=1000;
        
        int sum = 0;
        
        for(int i = s.size()-1; i>=0; i-- ) {
            
            if(i == 0) sum += o[s.at(i)]; 
            else {
            
            if(o[s.at(i-1)] < o[s.at(i)]) {
                sum += o[s.at(i)]  - o[s.at(i-1)];
                i--;
            } else {
                sum += o[s.at(i)];
            }
            }
        }
        return sum;
    }
};

int main() {
    Solution s;
    cout << s.romanToInt("MCMXCIV");
}


// similar solution
//https://leetcode.com/problems/roman-to-integer/discuss/923841/C%2B%2B-code-easy-and-short-using-map