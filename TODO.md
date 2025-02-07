## Задание 5. Базовое задание:
Условие:
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:

    Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
    Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
    Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере: @GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
    Изменение статуса задачи. Подсказка метод в контроллере: @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)

    Удаление задачи.
    Подсказка метод в контроллере:
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)

    Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

Подсказка понадобится энумератор:
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;
}

## Задание 8. Spring AOP, управление транзакциями.

**Базовое задание:**
Домашнее задание выполнить для одного из пройденных семинаров в проекте с Базой Данных.
Вам необходимо разработать механизм регистрации действий пользователя в вашем Spring Boot приложении. Используйте Spring AOP
для создания журнала действий, в котором будет сохраняться информация о том, какие методы сервиса вызывались, кем и с какими параметрами.

    Создайте аннотацию @TrackUserAction.
    Реализуйте aspect, который будет регистрировать действия пользователя, когда вызывается метод, отмеченный этой аннотацией.
    Примените аннотацию @TrackUserAction к нескольким методам в слое сервиса.
    Результаты регистрации в консоль
