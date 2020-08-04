#include <iostream>
#include <cmath>
#include <string>

using namespace std;

void solve() {
    cout << "ohh";   
}

void testCasesIterate() {
  int t;
  cin >> t;
  for(int casenum = 1; casenum <= t; casenum++) {
    cout << "Case #" << casenum << ": ";
    solve();
    cout << "\n";
  }
}

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL); cout.tie(NULL);
  testCasesIterate();
  //solve();
}