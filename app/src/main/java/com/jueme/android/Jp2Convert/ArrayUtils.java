/**
 * @version $Id: ArrayUtils.java 174 2012-01-15 21:08:04Z mroland $
 *
 * @author Michael Roland <mi.roland@gmail.com>
 *
 * Copyright (c) 2009-2011 Michael Roland
 *
 * ALL RIGHTS RESERVED.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name Michael Roland nor the names of any contributors
 *       may be used to endorse or promote products derived from this software
 *       without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL MICHAEL ROLAND BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jueme.android.Jp2Convert;

import java.util.ArrayList;

/**
 * Utilities for arrays.
 */
public class ArrayUtils {
  private ArrayUtils() {}

  public static byte[] toByteArray (ArrayList<Byte> ... list) {
    int len = 0;
    for (ArrayList<Byte> l : list) {
      if (l != null) {
        len += l.size();
      }
    }

    byte[] result = new byte[len];

    int index = 0;
    for (ArrayList<Byte> l : list) {
      if (l != null) {
        for (Byte b : l) {
          result[index++] = b.byteValue();
        }
      }
    }
    return result;
  }

  public static byte[] toByteArray (ArrayList<byte[]> list) {
    int len = 0;
    for (byte[] array : list) {
      if (array != null) {
        len += array.length;
      }
    }

    byte[] result = new byte[len];

    int index = 0;
    for (byte[] array : list) {
      if (array != null) {
        System.arraycopy(array, 0, result, index, array.length);
        index += array.length;
      }
    }
    return result;
  }

  public static ArrayList concatenate (ArrayList ... list) {
    ArrayList result = new ArrayList();
    for (ArrayList l : list) {
      if (l != null) {
        result.addAll(l);
      }
    }
    return result;
  }

  public static byte[] concatenate (byte[] ... array) {
    int len = 0;
    for (byte[] a : array) {
      if (a != null) {
        len += a.length;
      }
    }

    byte[] result = new byte[len];

    int index = 0;
    for (byte[] a : array) {
      if (a != null) {
        System.arraycopy(a, 0, result, index, a.length);
        index += a.length;
      }
    }

    return result;
  }

}
