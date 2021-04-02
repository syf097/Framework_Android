/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bonait.bnframework.common.base;

/**
 * Represents an Item in our application. Each item has a name, id, full size image url and
 * thumbnail url.
 */
public class Item {

    public static Item[] ITEMS = new Item[] {
            new Item("Flying in the Light",  "https://i.loli.net/2021/04/01/aGM19dQcEwTmpPy.jpg"),
    };

    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final String mName;
    private final String mFileName;

    Item(String name, String fileName) {
        mName = name;
        mFileName = fileName;
    }

    public int getId() {
        return mName.hashCode() + mFileName.hashCode();
    }


    public String getName() {
        return mName;
    }

    public String getPhotoUrl() {
        return mFileName;
    }


}
