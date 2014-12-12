
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


/*
 * Time complexity is O(n)
 */
int parity(uint32_t v)
{
    int res = 0;

    // XOR is associative and true whenever an odd number
    // of inputs is true
    // http://en.wikipedia.org/wiki/Exclusive_or
    while (v) {
        res ^= v & 1;
        v >>= 1;
    }

    return res;
}


/*
 * Time complexity is O(k), where k is num set bits
 */
int parity_(uint32_t v)
{
    int res = 0;

    while (v) {
        res ^= 1;
        v &= (v - 1);  // drop lowest set bit
    }

    return res;
}


int lsb(uint32_t v)
{
    return v & ~(v - 1);
}


int getbit(uint64_t v, int n)
{
    return (v >> n) & 1;
}


uint64_t setbit(uint64_t v, int n)
{
    return v |= (1UL << n);
}


uint64_t clearbit(uint64_t v, int n)
{
    return v &= ~(1UL << n);  // flip bits and AND
}


uint64_t togglebit(uint64_t v, int n)
{
    return v ^= (1UL << n);
}


/*
 * Approach is to get ith and jth bits and compare:
 *   1. if they are the same, then do nothing
 *   2. if they differ, then create mask (OR) and toggle (XOR)
 */
uint64_t swap64(uint64_t v, int i, int j)
{
    int m = (v >> i) & 1;
    int n = (v >> j) & 1;

    if (m != n) {
        v ^= (1UL << i) | (1UL << j);
    }

    return v;
}
