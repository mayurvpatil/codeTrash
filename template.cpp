#include <iostream>
#include <cmath>
#include <string>
#include <vector>

using namespace std;

// ----------- SMART BEGIN ---------
#define rep(i, a, b) for(int i = a; i < (b); ++i)
#define trav(a, x) for(auto& a : x)
#define all(x) x.begin(), x.end()
#define sz(x) (int)(x).size()

typedef vector<int> vi;
typedef long long ll;
typedef pair<int, int> pii;
typedef vector<vector<ll> > matrix;
typedef pair<ll, ll> pll;

template <typename T> 
vector<T> rcin( int n) { vector<T> v;while(n > 0) { T t;cin >> t;v.push_back(t);n--;}return v;} // auto vec = rcin<ll>(5);
vector<string> split(string s, string del) { int t = 0; vector<string> v; while(t != -1) { t = s.find(del); v.push_back(s.substr(0, t)); if(s.length() > t+del.length()) {s = s.substr(t+del.length(), s.length());}}return v;} 
// split(string, del): vector<string>

// ----------- SMART END ---------

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
  
  // Enable INPUT while debugging
  // freopen("op", "w", stdout);
  // freopen("input", "r", stdin);

  //testCasesIterate();
  solve();
}