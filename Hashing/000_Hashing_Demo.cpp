
/*
- Hashing Demo
-
- Pattern:
- Hashing
-
- Approach:
- Precompute frequency counts in a fixed-size hash table and answer queries in constant time.
-
- Time Complexity: O(n + q)
- Space Complexity: O(1)
*/

#include <bits/stdc++.h>
using namespace std;

int main() {

    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    //precompute:
    int hash[13] = {0};
    for (int i = 0; i < n; i++) {
        hash[arr[i]] += 1;
    }

    int q;
    cin >> q;
    while (q--) {
        int number;
        cin >> number;
        // fetching:
        cout << hash[number] << endl;
    }
    return 0;
}
