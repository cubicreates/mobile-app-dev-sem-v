# Sem5 Android Practical App

A beginner-friendly Java + XML Android application covering all practical topics from Units I to V. Every topic has its own dedicated Activity and XML layout, connected through a Navigation Drawer and an Action Bar Options Menu.

## Navigation & Menus

- **Entry Screen (`MainActivity`)**: Displays `Hello World` and an `Enter App` button. Clicking it shows a `"Entering app"` toast and opens `LoginActivity`.
- **Navigation Drawer (`BaseActivity` + `res/menu/drawer_menu.xml`)**: Every screen after `MainActivity` includes a hamburger menu button in the Action Bar to jump directly to any of the 15 screens.
- **Options Menu (`res/menu/options_menu.xml`)**: 3-dots Action Bar menu on drawer screens with `Home`, `About`, and `Exit`.

---

## Implemented Screens by Unit

### Unit I: Introduction to Android
1. **Hello World** — `MainActivity.java` / `activity_main.xml`
   - Blank screen with `Hello World` text and `Enter App` button.
2. **Login Screen** — `LoginActivity.java` / `activity_login.xml`
   - `LinearLayout` with `EditText` (username & password), `CheckBox` (`Remember Me`), and `Button` (`Login`).
3. **RecyclerView & CardView** — `RecyclerViewActivity.java`, `StudentAdapter.java` / `activity_recycler_view.xml`, `item_card.xml`
   - Displays a scrollable list of `CardView` items using `RecyclerView` and `LinearLayoutManager`.

### Unit II: Activities & Intents
4. **Activity Lifecycle** — `LifecycleActivity.java` / `activity_lifecycle.xml`
   - Prints and toasts lifecycle callbacks (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onRestart`, `onDestroy`).
5. **Explicit Intent & Pass Data** — `ExplicitIntentActivity.java`, `SecondActivity.java` / `activity_explicit_intent.xml`, `activity_second.xml`
   - Sends text from `ExplicitIntentActivity` to `SecondActivity` using `Intent.putExtra` and `getStringExtra`.
6. **Implicit Intents** — `ImplicitIntentActivity.java` / `activity_implicit_intent.xml`
   - Opens a web page (`Intent.ACTION_VIEW`) and opens the phone dialer (`Intent.ACTION_DIAL`).

### Unit III: Fragments
7. **Add Fragment** — `AddFragmentActivity.java`, `FirstFragment.java` / `activity_add_fragment.xml`, `fragment_first.xml`
   - Adds `FirstFragment` into a `FrameLayout` via `FragmentManager`.
8. **Replace Fragment** — `ReplaceFragmentActivity.java`, `FirstFragment.java`, `SecondFragment.java` / `activity_replace_fragment.xml`, `fragment_second.xml`
   - Switches between `FirstFragment` and `SecondFragment` using `FragmentTransaction.replace(...)`.
9. **Pass Data Between Fragments** — `PassDataFragmentActivity.java`, `SenderFragment.java`, `ReceiverFragment.java` / `activity_pass_data_fragment.xml`, `fragment_sender.xml`, `fragment_receiver.xml`
   - Sends a string from `SenderFragment` to `ReceiverFragment` using `Bundle` and `setArguments(...)`.

### Unit IV: Exploring Action Bar
10. **Option Menu** — `OptionMenuActivity.java` / `activity_option_menu.xml`, `res/menu/options_menu.xml`
    - Demonstrates the 3-dots Action Bar options menu and updates the screen text when options are clicked.
11. **Context & Popup Menus** — `ContextPopupMenuActivity.java` / `activity_context_popup_menu.xml`, `res/menu/context_menu.xml`, `res/menu/popup_menu.xml`
    - Long-press the text for a Context Menu (`registerForContextMenu`); tap the button for a `PopupMenu`.
12. **Tab Navigation with ViewPager** — `TabViewPagerActivity.java`, `TabPagerAdapter.java`, `FirstFragment.java`, `SecondFragment.java`, `ThirdFragment.java` / `activity_tab_viewpager.xml`, `fragment_third.xml`
    - Uses `TabLayout`, `ViewPager2`, and `TabLayoutMediator` across three fragment tabs.

### Unit V: Broadcast & Services
13. **Custom Broadcast** — `BroadcastActivity.java` / `activity_broadcast.xml`
    - Sends and receives a custom broadcast (`com.example.sem5.CUSTOM_BROADCAST`) using a dynamic `BroadcastReceiver`.
14. **Notification** — `NotificationActivity.java` / `activity_notification.xml`
    - Creates a `NotificationChannel` (API 26+), requests `POST_NOTIFICATIONS` on Android 13+, and displays a notification via `NotificationCompat.Builder`.
15. **Music Service** — `MusicServiceActivity.java`, `MusicService.java` / `activity_music_service.xml`
    - Starts and stops a background `Service` that plays the default system ringtone with `MediaPlayer`.

---

## Build & Run

```powershell
.\gradlew.bat assembleDebug testDebugUnitTest
```

- All app icons in `app/src/main/res/mipmap-*` were preserved untouched.
- Every Activity and `MusicService` is registered in `app/src/main/AndroidManifest.xml`.
