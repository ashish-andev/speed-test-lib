/*
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2016 Bertrand Martel
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package fr.bmartel.speedtest;

import java.util.Arrays;
import java.util.Random;

/**
 * Generate Random byte array for randomly generated uploaded file.
 *
 * @author Bertrand Martel
 */
public class RandomGen {

    /**
     * list of incremented byte.
     */
    private static final byte[] SYMBOLS;

    /**
     * number of incremented byte.
     */
    private static final int SYMBOLS_LENGTH = 255;

    /**
     * minimum length required for random byte array.
     */
    private static final int MINIMUM_LENGTH = 1;

    static {
        SYMBOLS = new byte[SYMBOLS_LENGTH];
        for (int i = 0; i < SYMBOLS_LENGTH; i++) {
            SYMBOLS[i] = (byte) i;
        }
    }

    /**
     * random object.
     */
    private final Random mRandom = new Random();

    /**
     * buffer used to retrieve random values.
     */
    private final byte[] mBuf;

    /**
     * Build Random generator object with specify file length.
     *
     * @param length file length to generate
     */
    public RandomGen(final int length) {
        if (length < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("length < " + MINIMUM_LENGTH + ": " + length);
        }
        mBuf = new byte[length];
    }

    /**
     * generate mRandom byte array.
     *
     * @return byte array
     */
    public byte[] nextArray() {
        for (int idx = 0; idx < mBuf.length; ++idx) {
            final int val = mRandom.nextInt(SYMBOLS_LENGTH);
            mBuf[idx] = SYMBOLS[val];
        }
        return Arrays.copyOf(mBuf, mBuf.length);
    }
}
