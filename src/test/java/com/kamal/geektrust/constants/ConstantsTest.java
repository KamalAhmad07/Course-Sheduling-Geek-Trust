package com.kamal.geektrust.constants;

import com.kamal.coursescheduling.*;
import com.kamal.coursescheduling.constant.Constant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstantsTest {

    @Test
    public void testGetValue(){
        assertEquals("ADD_COURSE_OFFERING",Constant.getValue("ADD-COURSE-OFFERING") );
        assertNotEquals("ALLOT-COURSE",Constant.getValue("ALLOT-COURSE"));
        assertEquals("ACCEPTED",Constant.ACCEPTED);
    }
}
