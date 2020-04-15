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
package com.feilong.coreextension.awt;

import static com.feilong.coreextension.awt.FontConstants.VERDANA;
import static com.feilong.coreextension.awt.FontConstants.YAHEI;

import java.awt.Font;

/**
 * 字体类.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.0.0
 */
public final class FontUtil{

    /** Don't let anyone instantiate this class. */
    private FontUtil(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    //---------------------------------------------------------------

    /**
     * 获得verdana字体(默认 {@link Font#PLAIN}).
     *
     * @param size
     *            the size
     * @return verdana字体
     * @see Font#PLAIN
     * @see FontConstants#VERDANA
     */
    public static final Font getVerdanaPlainFont(int size){
        return newFont(VERDANA, size);
    }

    /**
     * 获得微软雅黑字体(默认 {@link Font#PLAIN}).
     *
     * @param size
     *            the size
     * @return 获得微软雅黑字体
     * @see Font#PLAIN
     * @see FontConstants#YAHEI
     */
    public static final Font getYaHeiPlainFont(int size){
        return newFont(YAHEI, size);
    }

    //---------------------------------------------------------------

    /**
     * 获得字体(默认 {@link Font#PLAIN}).
     *
     * @param fontName
     *            字体名称.<br>
     *            可以是字体外观名称或字体系列名称,并可表示此 GraphicsEnvironment 中找到的逻辑字体或物理字体.<br>
     *            逻辑字体的系列名称有:Dialog、DialogInput、Monospaced、Serif 或 SansSerif. <br>
     *            如果 name 为 null,则将新 Font 的 逻辑字体名称(由 getName() 返回)设置为 "Default".
     * @param size
     *            the size
     * @return 字体
     * @see Font#PLAIN
     * @since 1.8.3
     */
    public static final Font newFont(String fontName,int size){
        // 普通样式常量
        return newFont(fontName, Font.PLAIN, size);
    }

    /**
     * 获得字体.
     * 
     * @param fontName
     *            字体名称.<br>
     *            可以是字体外观名称或字体系列名称,并可表示此 GraphicsEnvironment 中找到的逻辑字体或物理字体.<br>
     *            逻辑字体的系列名称有:Dialog、DialogInput、Monospaced、Serif 或 SansSerif. <br>
     *            如果 name 为 null,则将新 Font 的 逻辑字体名称(由 getName() 返回)设置为 "Default".
     * @param fontStyle
     *            字体样式<br>
     *            粗体 {@link Font#BOLD} 斜体 {@link Font#ITALIC} 普通样式常量 {@link Font#PLAIN} <br>
     *            Font 的样式常量.样式参数是整数位掩码,可以为 PLAIN,或 BOLD 和 ITALIC 的按位或(例如,ITALIC 或 BOLD|ITALIC).<br>
     *            如果样式参数不符合任何一个期望的整数位掩码,则将样式设置为 PLAIN.
     * @param fontSize
     *            字体磅值大小 9pt=12px
     * @return 字体
     * @since 1.8.3
     */
    public static final Font newFont(String fontName,int fontStyle,int fontSize){
        return new Font(fontName, fontStyle, fontSize);
    }
}
