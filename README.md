This is my personal health tracker app built in Kotlin using Jetpack Compose for the UI. I wanted something simple, reliable, and fully native to track vitals like blood pressure, heart rate, weight, and baby kicks.

The app follows MVVM architecture for a clean separation of concerns. I use Room to store data safely on the device, StateFlow for smooth state management, and LiveData where reactive updates are needed. Dependency Injection is handled using Hilt, which keeps the code clean, testable, and easy to maintain.

Background tasks such as reminders and syncing are managed using WorkManager, including notifications triggered every 5 hours, ensuring they work even when the app is closed.

I paid close attention to error handling and reliability—inputs are validated, failures are handled gracefully, and the app avoids unexpected crashes. I also added basic testing for the Room database, ViewModels, Hilt setup, and UI to make sure everything works as expected.

The UI is clean and modern, with intuitive forms, cards, and dialogs. Special care was taken to make vitals input—especially Systolic and Diastolic values—clear and easy to use.
