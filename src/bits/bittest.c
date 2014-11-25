
#include <stdio.h>
#include <string.h>

#include "bits.h"


void signbit_test()
{
    printf("signbit_test\n");

    int arr[] = { -2, -1, 0, 1, 2 };
    int n = sizeof(arr) / sizeof(int);

    for (int i = 0; i < n; ++i) {
        printf("n: %2d => %d\n", arr[i], signbit(arr[i]));
    }
}


void nsetbits_test()
{
    printf("nsetbits_test\n");

    char bits[17];
    memset(&bits[0], 0, sizeof(bits));

    for (int i = 0; i < 16; ++i) {
        printf("n: %2d => %d %s\n", i, nsetbits(i, bits), bits);
    }
}


int main(int argc, char* argv[])
{
    signbit_test();
    nsetbits_test();

    return 0;
}
