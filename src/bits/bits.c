
#include <stdio.h>
#include <string.h>

#include "bits.h"


int signbit(int v)
{
    return (0x80000000 & v) >> 31;
}


int nsetbits(uint16_t v, char bits[17])
{
    int res = 0;
    unsigned int n = 1;

    memset(&bits[0], 0, 17 * sizeof(char));
    bits[16] = '\0';

    for (int i = 0; i < 16; ++i) {
        if (n & v) {
            res++;
            bits[16 - (i+1)] = '1';
        }
        else {
            bits[16 - (i+1)] = '0';
        }
        n <<= 1;
    }

    return res;
}
