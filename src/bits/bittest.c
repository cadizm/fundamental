
#include <stdio.h>
#include <string.h>
#include <assert.h>

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


void parity_test()
{
    printf("parity_test\n");

    int n[] = {
         0,
         1,
         2,
         3,
        11,
        136
    };

    for (int i = 0; i < 6; ++i) {
        printf("%d: => %d\n", n[i], parity(n[i]));
    }
}


void lsb_test()
{
    printf("lsb_test\n");

    char bits[17];

    uint16_t n[] = {
          0,  // 0b0
          1,  // 0b1
         16,  // 0b010000
        336,  // 0b101010000
        340   // 0b101010100
    };

    for (int i = 0; i < 5; ++i) {
        memset(&bits[0], 0, sizeof(bits));
        nsetbits(n[i], bits);

        printf("%s: => ", bits);

        uint16_t v = lsb(n[i]);

        memset(&bits[0], 0, sizeof(bits));
        nsetbits(v, bits);

        printf("%s\n", bits);
    }
}


void getbit_test()
{
    printf("getbit_test\n");

    char bits[17];

    uint16_t n[] = {
          0,  // 0b000000000
          1,  // 0b000000001
         16,  // 0b000010000
        336,  // 0b101010000
        340   // 0b101010100
    };

    for (int i = 0; i < 5; ++i) {

        memset(&bits[0], 0, sizeof(bits));
        nsetbits(n[i], bits);

        printf("%s[%d]: => %d\n", bits, 0, getbit(n[i], 0));
        printf("%s[%d]: => %d\n", bits, 4, getbit(n[i], 4));
        printf("\n");
    }
}


void togglebit_test()
{
    printf("togglebit_test\n");

    assert(togglebit(0, 0) == 1);
    assert(togglebit(0, 1) == 2);
    assert(togglebit(0, 2) == 4);
    assert(togglebit(0, 3) == 8);
}


int main(int argc, char* argv[])
{
    signbit_test();
    nsetbits_test();
    parity_test();
    lsb_test();
    getbit_test();
    togglebit_test();

    return 0;
}
