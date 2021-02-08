package com.rresende.hackerrank;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class JavaSubstringComparisons {
    
    
    @Test
    public void compare() {
        assertThat(getSmallestAndLargest("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs", 144), is("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs\\nASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs"));

    }

    static String getSmallestAndLargest(String S, int k) {
        String smallest = S.substring(0, k);
        String largest = smallest;
        for (int i = 0; i < S.length() && (k+i) <= S.length(); i++) {
            String s = S.substring(i, k+i);
            if (s.compareTo(smallest) <= 0)
                smallest = s;
            if (s.compareTo(largest) >= 0)
                largest = s;
        }
        return smallest + "\n" + largest;
    }

}
