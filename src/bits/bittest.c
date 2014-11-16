
#include <stdio.h>

#include "bits.h"


int main(int argc, char* argv[])
{
    int arr[] = { -2, -1, 0, 1, 2 };
    int n = sizeof(arr) / sizeof(int);

    for (int i = 0; i < n; ++i) {
        printf("%d %d\n", arr[i], signbit(arr[i]));
    }

    return 0;
}
