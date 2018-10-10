# SearchableSpinner 
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SearchableSpinner-green.svg?style=true)](https://android-arsenal.com/details/1/3272)

Spinner with searchable items.

Searchable Spinner is a dialog spinner with the search feature which allows to search the items loaded in the spinner.

![Alt text](https://github.com/miteshpithadiya/SearchableSpinner/blob/master/searchablespinnerlibrary/src/main/res/nobleltevzwLMY47XMeditab02192016201518.gif "Searchable Spinner")

# Gradle
    dependencies {
        ...
        implementation 'kenmeidearu.searchablespinner:searchablespinnerlibrary:1.5.0'
    }

# Usage
    <com.kenmeidearu.searchablespinnerlibrary.SearchableSpinner
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

     ArrayList<mListString> StringIsi = new ArrayList<>();//must crete this to generate data there are n1-n4
     customerNama = getResources().getStringArray(R.array.planets);//change with your own array
     int id = 0;
     for (String s : customerNama) {
            StringIsi.add(new mListString(id, s, s, s, s));
            id++;
     }
        assert sp != null;
    sp.setTitleList("--Select Customer--");//use this to create initial search first
    sp.setAdapter(StringIsi, 2, 1);// type spinner 1-4, searh option 1-4

    
# Changelog
* <b>1.5.0</b>
    * initial release.
    * Adopt from https://github.com/miteshpithadiya/SearchableSpinner
    * thansk for your library

# License

    Copyright 2016 Kenmeidearu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
