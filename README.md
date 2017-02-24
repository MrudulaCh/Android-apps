# Mobile-Apps - TapToDo

TapToDo is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Mrudula Chennoju

Time spent: 20 hours spent in total

## User Stories

The following required functionality is completed:

1)User can successfully add and remove items from the todo list
2)User can tap a todo item in the list and bring up an edit screen for the todo item and then have any changes to the fields reflected in the todo list.
3)User can persist todo items and retrieve them properly on app restart.


The following optional features are implemented:

1) Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
2) Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
3) Add support for completion due dates for todo items (and display within listview item)
5) Add support for selecting the priority of each todo item (and display in listview item).Priority is displayed in colored buttons.Red for high,Green for intermediate,Blue for Low,Yellow for very low.
6) Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following additional features are implemented:

1)Splash screen is added to the app.
2)Adding item to the list from app menu.
3)Priority buttons are customized to circular buttons.
4)If the status of the todo is done, the particular list item is showed with a different image.

## Video Walkthrough 
 
Here's a walkthrough of implemented user stories:

<img src='C:\Users\Pragiti\Documents\AndroidCodePath\videos\TapToDo.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

1)Customizing buttons to circular buttons and adding colors and displaying the same colored buttons in the list items.
2)Showing calender for due date field using dialog fragment.
3)Adding customized menu items(edit and delete) to the dynamic list items.

## License

    Copyright [yyyy] [Mrudula Chennoju]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
