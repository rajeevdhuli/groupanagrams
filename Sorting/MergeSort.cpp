#include <vector>
#include <iostream>

using namespace std;

void merge(int arr[], int low, int mid, int high) {
    int left = low;
    int right = mid + 1;
    vector<int> v;

    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            v.push_back(arr[left]);
            left++;
        } else {
            v.push_back(arr[right]);
            right++;
        }
    }

    while (left <= mid) {
        v.push_back(arr[left]);
        left++;
    }

    while (right <= high) {
        v.push_back(arr[right]);
        right++;
    }
    int j = 0;
    for (int i = low; i <= high; i++) {
        arr[i] = v[j ];
        j++;
    }
}

void mS(int arr[], int low, int high) {
    if (low == high)
        return;
    int mid = (low + high) / 2;
    mS(arr, low, mid);
    mS(arr, mid + 1, high);
    merge(arr, low, mid, high);
}

void mergeSort(int arr[], int l, int r) {
    mS(arr, l, r);
}
