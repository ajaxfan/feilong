/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.util.predicate;

import static org.junit.Assert.assertTrue;

import org.apache.commons.collections4.Predicate;
import org.junit.Test;

import com.feilong.lib.collection4.PredicateUtils;
import com.feilong.store.member.User;

public class BeanPredicateTest{

    /**
     * Test.
     */
    @Test
    public void test(){
        User user = new User("feilong");

        Predicate<User> predicate = new BeanPredicate<>("name", PredicateUtils.equalPredicate("feilong"));

        assertTrue(predicate.evaluate(user));
    }

    //---------------------------------------------------------------

    @SuppressWarnings("unused")
    @Test(expected = NullPointerException.class)
    public void testBeanPredicateTestNull1(){
        new BeanPredicate<>("name", null);
    }

    @SuppressWarnings("unused")
    @Test(expected = NullPointerException.class)
    public void testBeanPredicateTestNull(){
        new BeanPredicate<>(null, null);
    }

    /**
     * Test bean predicate test empty.
     */
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testBeanPredicateTestEmpty(){
        new BeanPredicate<>("", null);
    }

    /**
     * Test bean predicate test blank.
     */
    @SuppressWarnings("unused")
    @Test(expected = IllegalArgumentException.class)
    public void testBeanPredicateTestBlank(){
        new BeanPredicate<>(" ", null);
    }
}
