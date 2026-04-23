# Приложение StarWarsApp

Это приложеине написано для поклонников вселенной Star Wars. В этом прлиожении реализована следующая функциональность:  
- Главный экран, реализованный с помощью вкладок (tabs) каждой категории (например: персонажи, планеты, расы и тд)
- Переход между вкладками с использованием Pager.
- На главном экране добавлена возможность поиска персонажей вселенной. 
- Навигация по клику на элемент той или иной категории.
- Кэширование данных с помощью Room.
- Корректная обработка состояний и ошибок (например, обработка ошибки при сетевом запросе к API). 

### Автор

**ToothLonely**

# Стек:

| Категория     | Технология                                                                      |
|---------------|---------------------------------------------------------------------------------|
| Architecture  | ![MVVM](https://img.shields.io/badge/MVVM-purple)                               |
| Language      | ![Kotlin](https://img.shields.io/badge/Kotlin-blue)                             |
| UI            | ![Compose](https://img.shields.io/badge/Jetpack-Compose-lightgrey)              |
| Network       | ![Retrofit](https://img.shields.io/badge/Retrofit-green)                        |
| Database      | ![Room](https://img.shields.io/badge/Room-red)                                  |
| DI            | ![Hilt](https://img.shields.io/badge/Hilt-orange)                               |
| Navigation    | ![Navigation, Pager](https://img.shields.io/badge/Jetpack-Navigation-lightgrey) |
| Image Loading | ![Coil](https://img.shields.io/badge/Coil-yellow)                               |
| Concurrency   | ![Coroutines](https://img.shields.io/badge/Coroutines-yellowgreen)              |

# Структура проекта:

| Package      | Content                                                     |
|--------------|-------------------------------------------------------------|
| app/         | Application                                                 | 
| data/        | Database, API service, DAOs, Repository (implementations)   |
| di/          | DI Modules                                                  |
| domain/      | Models, Repository (interfaces), UseCase                    | 
| presentation/| Navigation, Tabs, Screens, MainActivity                     |
