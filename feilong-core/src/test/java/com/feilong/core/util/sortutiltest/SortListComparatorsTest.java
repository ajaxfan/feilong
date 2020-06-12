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
package com.feilong.core.util.sortutiltest;

import static com.feilong.core.bean.ConvertUtil.toList;
import static com.feilong.core.util.SortUtil.sortList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.feilong.core.util.CollectionsUtil;
import com.feilong.core.util.comparator.PropertyComparator;
import com.feilong.lib.collection4.comparators.FixedOrderComparator;
import com.feilong.store.member.User;

/**
 * The Class SortUtilSortListComparatorsTest.
 *
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 */
public class SortListComparatorsTest{

    @Test
    public void testSortListComparators(){
        User zhangfei = new User("张飞", 23);
        User guanyu = new User("关羽", 30);
        User liubei = new User("刘备", 25);

        String[] names = { "刘备", "关羽" };
        List<User> list = CollectionsUtil.select(toList(zhangfei, guanyu, liubei), "name", names);
        sortList(list, new PropertyComparator<User>("name", new FixedOrderComparator<>(names)));

        assertThat(list, contains(liubei, guanyu));
    }

    @Test
    public void testSortListComparators1(){
        User guanyu = new User("关羽", 30);

        User liubei60 = new User("刘备", 60);
        User liubei25 = new User("刘备", 25);
        User liubei30 = new User("刘备", 30);
        User liubei10 = new User("刘备", 10);

        String[] names = { "刘备", "关羽" };
        List<User> list = CollectionsUtil.select(toList(liubei60, liubei30, liubei10, guanyu, liubei25), "name", names);
        sortList(
                        list, //
                        new PropertyComparator<User>("name", new FixedOrderComparator<>(names)),
                        new PropertyComparator<User>("age"));

        assertThat(list, contains(liubei10, liubei25, liubei30, liubei60, guanyu));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testSortListNullList(){
        assertEquals(emptyList(), sortList((List) null, (Comparator) null));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testSortListEmptyList(){
        assertEquals(emptyList(), sortList(new ArrayList<>(), (Comparator) null));
    }

    @SuppressWarnings({ "unchecked" })
    @Test
    public void testSortListNullComparators(){
        List<User> list = toList(new User("张飞", 23), new User("关羽", 30), new User("刘备", 25));
        assertEquals(list, sortList(list, (Comparator[]) null));
    }

    @Test
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void testSortListNullComparator(){
        List<User> list = toList(new User("张飞", 23), new User("关羽", 30), new User("刘备", 25));
        assertEquals(list, sortList(list, (Comparator) null));
    }
}
